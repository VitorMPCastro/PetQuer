create table log_pet_excluido
(
    id_log_pet_excluido int auto_increment
        primary key,
    timestamp           timestamp default CURRENT_TIMESTAMP not null,
    id_pet              bigint                              null,
    constraint log_pet_excluido_id_pet_fk
        foreign key (id_pet) references pet (id_pet)
);

