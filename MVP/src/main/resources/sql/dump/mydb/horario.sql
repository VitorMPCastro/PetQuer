create table horario
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

