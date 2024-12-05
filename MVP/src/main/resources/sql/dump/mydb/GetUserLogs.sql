create
    definer = root@`%` procedure GetUserLogs(IN userId int)
BEGIN
    SELECT * FROM log_usuario_criado WHERE id_usuario = userId;
END;

