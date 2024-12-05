create table reserva
(
    id_reserva bigint auto_increment
        primary key,
    fim        datetime(6) null,
    id_anuncio bigint      null,
    inicio     datetime(6) null,
    pet_id_pet bigint      null
);

