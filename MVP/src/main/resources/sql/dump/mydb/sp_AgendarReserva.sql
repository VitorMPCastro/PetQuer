create
    definer = root@`%` procedure sp_AgendarReserva(IN pet_id_pet int, IN inicio datetime(6), IN fim datetime(6))
BEGIN
    INSERT INTO reserva (pet_id_pet, inicio, fim)
    VALUES (pet_id_pet, inicio, fim);
END;

