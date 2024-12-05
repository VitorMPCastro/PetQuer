create definer = root@`%` view view_log_reserva_alterada as
select `mydb`.`log_reserva_alterada`.`id_log_reserva_alterada` AS `id_log_reserva_alterada`,
       `mydb`.`log_reserva_alterada`.`timestamp`               AS `timestamp`,
       `mydb`.`log_reserva_alterada`.`id_reserva`              AS `id_reserva`
from `mydb`.`log_reserva_alterada`;

