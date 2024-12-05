create definer = root@`%` view view_log_anuncio_criado as
select `mydb`.`log_anuncio_criado`.`id_log_anuncio_criado` AS `id_log_anuncio_criado`,
       `mydb`.`log_anuncio_criado`.`timestamp`             AS `timestamp`,
       `mydb`.`log_anuncio_criado`.`id_anuncio`            AS `id_anuncio`
from `mydb`.`log_anuncio_criado`;

