create table log_usuario_criado
(
    id_log_usuario_criado int auto_increment
        primary key,
    timestamp             timestamp default CURRENT_TIMESTAMP not null,
    id_usuario            bigint                              null,
    constraint log_usuario_criado_id_usuario_fk
        foreign key (id_usuario) references user (id)
);

