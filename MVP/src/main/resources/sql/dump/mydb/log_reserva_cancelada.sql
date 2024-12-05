create table log_reserva_cancelada
(
    id_log_reserva_cancelada int auto_increment
        primary key,
    timestamp                timestamp default CURRENT_TIMESTAMP not null,
    id_reserva               bigint                              null,
    constraint log_reserva_cancelada_id_reserva_fk
        foreign key (id_reserva) references reserva (id_reserva)
);

