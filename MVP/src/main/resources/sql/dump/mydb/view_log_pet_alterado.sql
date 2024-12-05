create definer = root@`%` view view_log_pet_alterado as
select `mydb`.`log_pet_alterado`.`id_log_pet_alterado` AS `id_log_pet_alterado`,
       `mydb`.`log_pet_alterado`.`timestamp`           AS `timestamp`,
       `mydb`.`log_pet_alterado`.`id_pet`              AS `id_pet`
from `mydb`.`log_pet_alterado`;

