CREATE OR REPLACE VIEW mydb.user_log_view AS
SELECT `u`.`id` AS `id`, `u`.`username` AS `username`, `l`.`timestamp` AS `timestamp`
FROM (`mydb`.`user` `u` JOIN `mydb`.`log_usuario_criado` `l` ON ((`u`.`id` = `l`.`id_usuario`)));

CREATE OR REPLACE VIEW mydb.view_log_anuncio_alterado AS
SELECT `mydb`.`log_anuncio_alterado`.`id_log_anuncio_alterado` AS `id_log_anuncio_alterado`,
       `mydb`.`log_anuncio_alterado`.`timestamp`               AS `timestamp`,
       `mydb`.`log_anuncio_alterado`.`id_anuncio`              AS `id_anuncio`
FROM `mydb`.`log_anuncio_alterado`;

CREATE OR REPLACE VIEW mydb.view_log_anuncio_criado AS
SELECT `mydb`.`log_anuncio_criado`.`id_log_anuncio_criado` AS `id_log_anuncio_criado`,
       `mydb`.`log_anuncio_criado`.`timestamp`             AS `timestamp`,
       `mydb`.`log_anuncio_criado`.`id_anuncio`            AS `id_anuncio`
FROM `mydb`.`log_anuncio_criado`;

CREATE OR REPLACE VIEW mydb.view_log_anuncio_excluido AS
SELECT `mydb`.`log_anuncio_excluido`.`id_log_anuncio_excluido` AS `id_log_anuncio_excluido`,
       `mydb`.`log_anuncio_excluido`.`timestamp`               AS `timestamp`,
       `mydb`.`log_anuncio_excluido`.`id_anuncio`              AS `id_anuncio`
FROM `mydb`.`log_anuncio_excluido`;

CREATE OR REPLACE VIEW mydb.view_log_pet_alterado AS
SELECT `mydb`.`log_pet_alterado`.`id_log_pet_alterado` AS `id_log_pet_alterado`,
       `mydb`.`log_pet_alterado`.`timestamp`           AS `timestamp`,
       `mydb`.`log_pet_alterado`.`id_pet`              AS `id_pet`
FROM `mydb`.`log_pet_alterado`;

CREATE OR REPLACE VIEW mydb.view_log_pet_criado AS
SELECT `mydb`.`log_pet_criado`.`id_log_pet_criado` AS `id_log_pet_criado`,
       `mydb`.`log_pet_criado`.`timestamp`         AS `timestamp`,
       `mydb`.`log_pet_criado`.`id_pet`            AS `id_pet`
FROM `mydb`.`log_pet_criado`;

CREATE OR REPLACE VIEW mydb.view_log_pet_excluido AS
SELECT `mydb`.`log_pet_excluido`.`id_log_pet_excluido` AS `id_log_pet_excluido`,
       `mydb`.`log_pet_excluido`.`timestamp`           AS `timestamp`,
       `mydb`.`log_pet_excluido`.`id_pet`              AS `id_pet`
FROM `mydb`.`log_pet_excluido`;

CREATE OR REPLACE VIEW mydb.view_log_reserva_alterada AS
SELECT `mydb`.`log_reserva_alterada`.`id_log_reserva_alterada` AS `id_log_reserva_alterada`,
       `mydb`.`log_reserva_alterada`.`timestamp`               AS `timestamp`,
       `mydb`.`log_reserva_alterada`.`id_reserva`              AS `id_reserva`
FROM `mydb`.`log_reserva_alterada`;

CREATE OR REPLACE VIEW mydb.view_log_usuario_criado AS
SELECT `mydb`.`log_usuario_criado`.`id_log_usuario_criado` AS `id_log_usuario_criado`,
       `mydb`.`log_usuario_criado`.`timestamp`             AS `timestamp`,
       `mydb`.`log_usuario_criado`.`id_usuario`            AS `id_usuario`
FROM `mydb`.`log_usuario_criado`;