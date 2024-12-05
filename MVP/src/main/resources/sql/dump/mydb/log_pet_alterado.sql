create table log_pet_alterado
(
    id_log_pet_alterado int auto_increment
        primary key,
    timestamp           timestamp default CURRENT_TIMESTAMP not null,
    id_pet              bigint                              null,
    constraint id_pet_fk
        foreign key (id_pet) references pet (id_pet)
);

