create table log_reserva_alterada
(
    id_log_reserva_alterada int auto_increment
        primary key,
    timestamp               timestamp default CURRENT_TIMESTAMP not null,
    id_reserva              bigint                              null,
    constraint id_reserva_fk
        foreign key (id_reserva) references reserva (id_reserva)
);

