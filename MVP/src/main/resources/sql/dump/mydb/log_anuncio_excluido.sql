create table log_anuncio_excluido
(
    id_log_anuncio_excluido int auto_increment
        primary key,
    timestamp               timestamp default CURRENT_TIMESTAMP not null,
    id_anuncio              bigint                              null,
    constraint log_anuncio_excluido_id_anuncio_fk
        foreign key (id_anuncio) references anuncio (id_anuncio)
);

