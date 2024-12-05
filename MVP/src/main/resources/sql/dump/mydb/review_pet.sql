create table review_pet
(
    id_review_anuncio int auto_increment
        primary key,
    avaliacao         int    not null,
    comentario        text   null,
    nota              int    not null,
    id_reserva        bigint null,
    constraint review_pet_id_reserva_fk
        foreign key (id_reserva) references reserva (id_reserva)
);

