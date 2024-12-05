create definer = root@`%` view view_log_pet_excluido as
select `mydb`.`log_pet_excluido`.`id_log_pet_excluido` AS `id_log_pet_excluido`,
       `mydb`.`log_pet_excluido`.`timestamp`           AS `timestamp`,
       `mydb`.`log_pet_excluido`.`id_pet`              AS `id_pet`
from `mydb`.`log_pet_excluido`;

