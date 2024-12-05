create definer = root@`%` view view_log_anuncio_alterado as
select `mydb`.`log_anuncio_alterado`.`id_log_anuncio_alterado` AS `id_log_anuncio_alterado`,
       `mydb`.`log_anuncio_alterado`.`timestamp`               AS `timestamp`,
       `mydb`.`log_anuncio_alterado`.`id_anuncio`              AS `id_anuncio`
from `mydb`.`log_anuncio_alterado`;

