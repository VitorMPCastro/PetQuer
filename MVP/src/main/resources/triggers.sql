-- Trigger 1: before_pet_insert
CREATE TRIGGER before_pet_insert
BEFORE INSERT ON pet
FOR EACH ROW
BEGIN
  SET NEW.data_de_nascimento = IFNULL(NEW.data_de_nascimento, CURDATE());
END;

-- Trigger 2: after_pet_insert
CREATE TRIGGER after_pet_insert
AFTER INSERT ON pet
FOR EACH ROW
BEGIN
  INSERT INTO log_pet_excluido (timestamp, id_pet) VALUES (CURRENT_TIMESTAMP, NEW.id_pet);
END;

-- Trigger 3: before_pet_update
CREATE TRIGGER before_pet_update
BEFORE UPDATE ON pet
FOR EACH ROW
BEGIN
  SET NEW.data_de_nascimento = IFNULL(NEW.data_de_nascimento, OLD.data_de_nascimento);
END;

-- Trigger 4: after_pet_delete
CREATE TRIGGER after_pet_delete
AFTER DELETE ON pet
FOR EACH ROW
BEGIN
  INSERT INTO log_pet_excluido (timestamp, id_pet) VALUES (CURRENT_TIMESTAMP, OLD.id_pet);
END;

-- Trigger 5: before_usuario_insert
CREATE TRIGGER before_usuario_insert
BEFORE INSERT ON usuario
FOR EACH ROW
BEGIN
  SET NEW.nome = UPPER(NEW.nome);
END;