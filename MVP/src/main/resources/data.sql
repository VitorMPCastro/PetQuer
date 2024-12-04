-- src/main/resources/data.sql

-- Views
CREATE VIEW PetDetails AS
SELECT p.id_pet, p.nome, p.raca, p.porte, p.observacao, p.data_de_nascimento, u.nome AS usuario_nome
FROM pet p
JOIN usuario u ON p.id_usuario = u.id_usuario;

CREATE VIEW UserPets AS
SELECT u.id_usuario, u.nome, COUNT(p.id_pet) AS pet_count
FROM usuario u
LEFT JOIN pet p ON u.id_usuario = p.id_usuario
GROUP BY u.id_usuario, u.nome;

CREATE VIEW PetAges AS
SELECT p.id_pet, p.nome, TIMESTAMPDIFF(YEAR, p.data_de_nascimento, CURDATE()) AS age
FROM pet p;

CREATE VIEW LargePets AS
SELECT p.id_pet, p.nome, p.raca, p.porte
FROM pet p
WHERE p.porte = 'Grande';

CREATE VIEW RecentPets AS
SELECT p.id_pet, p.nome, p.data_de_nascimento
FROM pet p
WHERE p.data_de_nascimento > DATE_SUB(CURDATE(), INTERVAL 1 YEAR);

-- Procedures
CREATE PROCEDURE GetPetDetails(IN petId INT)
BEGIN
  SELECT p.id_pet, p.nome, p.raca, p.porte, p.observacao, p.data_de_nascimento, u.nome AS usuario_nome
  FROM pet p
  JOIN usuario u ON p.id_usuario = u.id_usuario
  WHERE p.id_pet = petId;
END;

CREATE PROCEDURE GetUserPets(IN userId INT)
BEGIN
  SELECT p.id_pet, p.nome, p.raca, p.porte, p.observacao, p.data_de_nascimento
  FROM pet p
  WHERE p.id_usuario = userId;
END;

CREATE PROCEDURE GetPetsByBreed(IN breed VARCHAR(255))
BEGIN
  SELECT p.id_pet, p.nome, p.porte, p.observacao, p.data_de_nascimento
  FROM pet p
  WHERE p.raca = breed;
END;

CREATE PROCEDURE GetLargePets()
BEGIN
  SELECT p.id_pet, p.nome, p.raca, p.observacao, p.data_de_nascimento
  FROM pet p
  WHERE p.porte = 'Grande';
END;

CREATE PROCEDURE GetRecentPets()
BEGIN
  SELECT p.id_pet, p.nome, p.raca, p.porte, p.observacao, p.data_de_nascimento
  FROM pet p
  WHERE p.data_de_nascimento > DATE_SUB(CURDATE(), INTERVAL 1 YEAR);
END;

-- Triggers
CREATE TRIGGER before_pet_insert
BEFORE INSERT ON pet
FOR EACH ROW
BEGIN
  SET NEW.data_de_nascimento = IFNULL(NEW.data_de_nascimento, CURDATE());
END;

CREATE TRIGGER after_pet_insert
AFTER INSERT ON pet
FOR EACH ROW
BEGIN
  INSERT INTO log_pet_excluido (timestamp, id_pet) VALUES (CURRENT_TIMESTAMP, NEW.id_pet);
END;

CREATE TRIGGER before_pet_update
BEFORE UPDATE ON pet
FOR EACH ROW
BEGIN
  SET NEW.data_de_nascimento = IFNULL(NEW.data_de_nascimento, OLD.data_de_nascimento);
END;

CREATE TRIGGER after_pet_delete
AFTER DELETE ON pet
FOR EACH ROW
BEGIN
  INSERT INTO log_pet_excluido (timestamp, id_pet) VALUES (CURRENT_TIMESTAMP, OLD.id_pet);
END;

CREATE TRIGGER before_usuario_insert
BEFORE INSERT ON usuario
FOR EACH ROW
BEGIN
  SET NEW.nome = UPPER(NEW.nome);
END;