create definer = root@`%` trigger after_user_insert
    after insert
    on user
    for each row
BEGIN
    INSERT INTO log_usuario_criado (id_usuario, timestamp)
    VALUES (NEW.id, CURRENT_TIMESTAMP);
END;

