create table denuncia_usuario
(
    id_denuncia_usuario int auto_increment
        primary key,
    descricao           text   null,
    alvo                bigint null,
    id_tipo_denuncia    bigint null,
    id_usuario          bigint null,
    constraint Alvo_fk
        foreign key (alvo) references user (id),
    constraint usuario_id_tipo_denuncia_fk
        foreign key (id_tipo_denuncia) references tipo_denuncia (id_tipo_denuncia),
    constraint usuario_id_usuario_fk
        foreign key (id_usuario) references user (id)
);

