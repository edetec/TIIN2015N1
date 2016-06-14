USE `agtur_db`;
CREATE  OR REPLACE VIEW `caixa_escursoes` AS
    SELECT 
        `e`.`id` AS `escursao_id`,
        `e`.`destino` AS `destino`,
        `e`.`partida` AS `data`,
        COUNT(0) AS `clientes`,
        SUM(`e`.`valor`) AS `total`
    FROM
        (`Escursao` `e`
        JOIN `Escursao_Usuario` `eu` ON ((`e`.`id` = `eu`.`Escursao_id`)))
    GROUP BY `e`.`id` , `e`.`destino` , `e`.`partida`;
