-- Procedure 1: GetPetDetails
CREATE PROCEDURE GetPetDetails(IN petId INT)
BEGIN
  SELECT p.id_pet, p.nome, p.raca, p.porte, p.observacao, p.data_de_nascimento, u.nome AS usuario_nome
  FROM pet p
  JOIN usuario u ON p.id_usuario = u.id_usuario
  WHERE p.id_pet = petId;
END;

-- Procedure 2: GetUserPets
CREATE PROCEDURE GetUserPets(IN userId INT)
BEGIN
  SELECT p.id_pet, p.nome, p.raca, p.porte, p.observacao, p.data_de_nascimento
  FROM pet p
  WHERE p.id_usuario = userId;
END;

-- Procedure 3: GetPetsByBreed
CREATE PROCEDURE GetPetsByBreed(IN breed VARCHAR(255))
BEGIN
  SELECT p.id_pet, p.nome, p.porte, p.observacao, p.data_de_nascimento
  FROM pet p
  WHERE p.raca = breed;
END;

-- Procedure 4: GetLargePets
CREATE PROCEDURE GetLargePets()
BEGIN
  SELECT p.id_pet, p.nome, p.raca, p.observacao, p.data_de_nascimento
  FROM pet p
  WHERE p.porte = 'Grande';
END;

-- Procedure 5: GetRecentPets
CREATE PROCEDURE GetRecentPets()
BEGIN
  SELECT p.id_pet, p.nome, p.raca, p.porte, p.observacao, p.data_de_nascimento
  FROM pet p
  WHERE p.data_de_nascimento > DATE_SUB(CURDATE(), INTERVAL 1 YEAR);
END;