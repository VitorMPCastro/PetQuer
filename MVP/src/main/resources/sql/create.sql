create table if not exists anuncio
(
    id_anuncio     bigint auto_increment
        primary key,
    descricao      varchar(255) null,
    endereco       varchar(100) not null,
    id_usuario     bigint       not null,
    titulo_anuncio varchar(40)  not null
);

create table if not exists horario
(
    id_horario      int auto_increment
        primary key,
    dia_semana      enum ('Domingo', 'Quarta', 'Quinta', 'Sabado', 'Segunda', 'Sexta', 'Terca') not null,
    horario_inicio  time(6)                                                                     not null,
    horario_termino time(6)                                                                     not null,
    id_anuncio      bigint                                                                      null,
    constraint horario_id_anuncio_fk
        foreign key (id_anuncio) references anuncio (id_anuncio)
);

create table if not exists log_anuncio_alterado
(
    id_log_anuncio_alterado int auto_increment
        primary key,
    timestamp               timestamp default CURRENT_TIMESTAMP not null,
    id_anuncio              bigint                              null,
    constraint log_anuncio_alterado_id_anuncio_fk
        foreign key (id_anuncio) references anuncio (id_anuncio)
);

create table if not exists log_anuncio_criado
(
    id_log_anuncio_criado int auto_increment
        primary key,
    timestamp             timestamp default CURRENT_TIMESTAMP not null,
    id_anuncio            bigint                              null,
    constraint log_anuncio_criado_id_anuncio_fk
        foreign key (id_anuncio) references anuncio (id_anuncio)
);

create table if not exists log_anuncio_excluido
(
    id_log_anuncio_excluido int auto_increment
        primary key,
    timestamp               timestamp default CURRENT_TIMESTAMP not null,
    id_anuncio              bigint                              null,
    constraint log_anuncio_excluido_id_anuncio_fk
        foreign key (id_anuncio) references anuncio (id_anuncio)
);

create table if not exists metodo_pagamento
(
    id_metodo_pagamento int auto_increment
        primary key,
    metodo              varchar(20) not null
);

create table if not exists pagamento
(
    id_pagamento        int            not null
        primary key,
    datahora            datetime(6)    not null,
    valor               decimal(38, 2) not null,
    id_metodo_pagamento int            null,
    constraint id_metodo_pagamento_fk
        foreign key (id_metodo_pagamento) references metodo_pagamento (id_metodo_pagamento)
);

create table if not exists pet
(
    id_pet             bigint auto_increment
        primary key,
    data_de_nascimento date                                null,
    id_usuario         bigint                              null,
    nome               varchar(255)                        null,
    observacao         varchar(255)                        null,
    porte              enum ('Grande', 'Medio', 'Pequeno') null,
    raca               varchar(255)                        null
);

create table if not exists log_pet_alterado
(
    id_log_pet_alterado int auto_increment
        primary key,
    timestamp           timestamp default CURRENT_TIMESTAMP not null,
    id_pet              bigint                              null,
    constraint id_pet_fk
        foreign key (id_pet) references pet (id_pet)
);

create table if not exists log_pet_criado
(
    id_log_pet_criado int auto_increment
        primary key,
    timestamp         timestamp default CURRENT_TIMESTAMP not null,
    id_pet            bigint                              null,
    constraint log_pet_criado_id_pet_fk
        foreign key (id_pet) references pet (id_pet)
);

create table if not exists log_pet_excluido
(
    id_log_pet_excluido int auto_increment
        primary key,
    timestamp           timestamp default CURRENT_TIMESTAMP not null,
    id_pet              bigint                              null,
    constraint log_pet_excluido_id_pet_fk
        foreign key (id_pet) references pet (id_pet)
);

create table if not exists reserva
(
    id_reserva bigint auto_increment
        primary key,
    fim        datetime(6) null,
    id_anuncio bigint      null,
    inicio     datetime(6) null,
    pet_id_pet bigint      null
);

create table if not exists log_reserva_alterada
(
    id_log_reserva_alterada int auto_increment
        primary key,
    timestamp               timestamp default CURRENT_TIMESTAMP not null,
    id_reserva              bigint                              null,
    constraint id_reserva_fk
        foreign key (id_reserva) references reserva (id_reserva)
);

create table if not exists log_reserva_cancelada
(
    id_log_reserva_cancelada int auto_increment
        primary key,
    timestamp                timestamp default CURRENT_TIMESTAMP not null,
    id_reserva               bigint                              null,
    constraint log_reserva_cancelada_id_reserva_fk
        foreign key (id_reserva) references reserva (id_reserva)
);

create table if not exists log_reserva_criada
(
    id_log_reserva_criada int auto_increment
        primary key,
    timestamp             timestamp default CURRENT_TIMESTAMP not null,
    id_reserva            bigint                              null,
    constraint log_reserva_criada_id_reserva_fk
        foreign key (id_reserva) references reserva (id_reserva)
);

create table if not exists review_anuncio
(
    id_review_anuncio int auto_increment
        primary key,
    avaliacao         int    not null,
    comentario        text   null,
    nota              int    not null,
    id_reserva        bigint null,
    constraint review_anuncio_id_reserva_fk
        foreign key (id_reserva) references reserva (id_reserva)
);

create table if not exists review_pet
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

create table if not exists tipo_denuncia
(
    id_tipo_denuncia bigint auto_increment
        primary key,
    tipo             varchar(255) null
);

create table if not exists user
(
    id         bigint auto_increment
        primary key,
    created_at datetime(6)  null,
    email      varchar(255) null,
    password   varchar(255) null,
    user_type  varchar(255) null,
    username   varchar(255) null
);

create table if not exists company
(
    id           bigint auto_increment
        primary key,
    cnpj         varchar(255) null,
    company_name varchar(255) null,
    iduser       bigint       null,
    constraint UKie1y6glv9v1pjfivri6m08nqo
        unique (iduser),
    constraint FKasv0xqnfaxnhhovc9xeip4ds
        foreign key (iduser) references user (id)
);

create table if not exists denuncia_anuncio
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

create table if not exists denuncia_usuario
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

create table if not exists individual
(
    id              bigint auto_increment
        primary key,
    cpf             varchar(255) null,
    individual_name varchar(255) null,
    rg              varchar(255) null,
    iduser          bigint       null,
    constraint UK9a7sjtww5pxd7yfo60wjbjqs1
        unique (iduser),
    constraint FK5tq54n73hfuusksq9hqcfe2bk
        foreign key (iduser) references user (id)
);

create table if not exists log_usuario_alterado
(
    id_log_usuario_alterado int auto_increment
        primary key,
    timestamp               timestamp default CURRENT_TIMESTAMP not null,
    id_usuario              bigint                              null,
    constraint log_usuario_alterado_id_usuario_fk
        foreign key (id_usuario) references user (id)
);

create table if not exists log_usuario_criado
(
    id_log_usuario_criado int auto_increment
        primary key,
    timestamp             timestamp default CURRENT_TIMESTAMP not null,
    id_usuario            bigint                              null,
    constraint log_usuario_criado_id_usuario_fk
        foreign key (id_usuario) references user (id)
);
