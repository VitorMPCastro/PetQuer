create table individual
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

