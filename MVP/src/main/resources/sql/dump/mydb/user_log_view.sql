create definer = root@`%` view user_log_view as
select `u`.`id` AS `id`, `u`.`username` AS `username`, `l`.`timestamp` AS `timestamp`
from (`mydb`.`user` `u` join `mydb`.`log_usuario_criado` `l` on ((`u`.`id` = `l`.`id_usuario`)));

