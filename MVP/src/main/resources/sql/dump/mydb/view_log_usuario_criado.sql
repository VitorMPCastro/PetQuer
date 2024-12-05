create definer = root@`%` view view_log_usuario_criado as
select `mydb`.`log_usuario_criado`.`id_log_usuario_criado` AS `id_log_usuario_criado`,
       `mydb`.`log_usuario_criado`.`timestamp`             AS `timestamp`,
       `mydb`.`log_usuario_criado`.`id_usuario`            AS `id_usuario`
from `mydb`.`log_usuario_criado`;

