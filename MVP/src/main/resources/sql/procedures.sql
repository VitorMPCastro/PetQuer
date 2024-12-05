CREATE PROCEDURE qnt_pet_porte (IN porte VARCHAR(10))
BEGIN
    SELECT COUNT(*) FROM pet
    WHERE porte = porte;
END;

CREATE PROCEDURE GetUserLogs(IN userId INT)
BEGIN
    SELECT * FROM log_usuario_criado WHERE id_usuario = userId;
END;

CREATE PROCEDURE sp_AgendarReserva (
    IN pet_id_pet INT,
    IN inicio DATETIME(6),
    IN fim DATETIME(6)
)
BEGIN
    INSERT INTO reserva (pet_id_pet, inicio, fim)
    VALUES (pet_id_pet, inicio, fim);
END;