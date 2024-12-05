create table log_anuncio_alterado
(
    id_log_anuncio_alterado int auto_increment
        primary key,
    timestamp               timestamp default CURRENT_TIMESTAMP not null,
    id_anuncio              bigint                              null,
    constraint log_anuncio_alterado_id_anuncio_fk
        foreign key (id_anuncio) references anuncio (id_anuncio)
);

