create table pet
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

