/** 2016年11月1日17:37:13 */
ALTER TABLE `of_order_fund` 
ADD COLUMN `external_scheduled_protocol_id` VARCHAR(20) NULL COMMENT '定投申购、变更时的定投协议号' AFTER `external_undo_no`;
ALTER TABLE `of_order_fund` 
ADD COLUMN `external_protocol_period_unit` VARCHAR(1) NULL COMMENT '协议周期单位(\'年\',\'月\',\'日\')' AFTER `external_scheduled_protocol_id`,
ADD COLUMN `external_protocol_fix_day` INT(2) NULL COMMENT '定投交易日' AFTER `external_protocol_period_unit`;
