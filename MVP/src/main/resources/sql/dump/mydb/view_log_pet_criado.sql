create definer = root@`%` view view_log_pet_criado as
select `mydb`.`log_pet_criado`.`id_log_pet_criado` AS `id_log_pet_criado`,
       `mydb`.`log_pet_criado`.`timestamp`         AS `timestamp`,
       `mydb`.`log_pet_criado`.`id_pet`            AS `id_pet`
from `mydb`.`log_pet_criado`;

