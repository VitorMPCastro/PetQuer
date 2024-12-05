create table company
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

