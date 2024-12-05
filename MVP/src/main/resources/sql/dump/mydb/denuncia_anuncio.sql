create table denuncia_anuncio
(
    id_denuncia_anuncio int auto_increment
        primary key,
    descricao           text   null,
    id_anuncio          bigint null,
    id_tipo_denuncia    bigint null,
    id_usuario          bigint null,
    constraint id_anuncio_fk
        foreign key (id_anuncio) references anuncio (id_anuncio),
    constraint id_tipo_denuncia_fk
        foreign key (id_tipo_denuncia) references tipo_denuncia (id_tipo_denuncia),
    constraint id_usuario_fk
        foreign key (id_usuario) references user (id)
);

