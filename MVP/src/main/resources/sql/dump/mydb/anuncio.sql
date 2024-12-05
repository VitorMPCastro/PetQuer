create table anuncio
(
    id_anuncio     bigint auto_increment
        primary key,
    descricao      varchar(255) null,
    endereco       varchar(100) not null,
    id_usuario     bigint       not null,
    titulo_anuncio varchar(40)  not null
);

