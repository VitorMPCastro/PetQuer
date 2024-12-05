create definer = root@`%` trigger after_pet_insert
    after insert
    on pet
    for each row
BEGIN
    INSERT INTO log_pet_criado (id_pet, timestamp)
    VALUES (NEW.id_pet, CURRENT_TIMESTAMP);
END;

