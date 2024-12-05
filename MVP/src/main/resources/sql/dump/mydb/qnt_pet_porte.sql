create
    definer = root@`%` procedure qnt_pet_porte(IN porte varchar(10))
BEGIN
    SELECT COUNT(*) FROM pet
    WHERE porte = porte;
END;

