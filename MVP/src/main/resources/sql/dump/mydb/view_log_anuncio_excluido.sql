create definer = root@`%` view view_log_anuncio_excluido as
select `mydb`.`log_anuncio_excluido`.`id_log_anuncio_excluido` AS `id_log_anuncio_excluido`,
       `mydb`.`log_anuncio_excluido`.`timestamp`               AS `timestamp`,
       `mydb`.`log_anuncio_excluido`.`id_anuncio`              AS `id_anuncio`
from `mydb`.`log_anuncio_excluido`;

