create definer = root@`%` trigger before_insert_log_usuario
    before insert
    on log_usuario_criado
    for each row
BEGIN
    SET NEW.timestamp = CURRENT_TIMESTAMP;
END;

