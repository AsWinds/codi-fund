CREATE TABLE `ubh_user_bank_history` (
	`ubh_history_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`ub_user_bank_id` BIGINT(20) NOT NULL,
	`ur_user_id` BIGINT(20) NOT NULL,
	`ub_bank_name` VARCHAR(50) NULL DEFAULT NULL,
	`ub_bank_code` VARCHAR(15) NULL DEFAULT NULL,
	`ub_user_bank_no` VARCHAR(25) NOT NULL,
	`ub_user_bank_owner` VARCHAR(25) NOT NULL,
	`ub_user_bank_mobile` VARCHAR(11) NOT NULL,
	`ub_bank_branch_name` VARCHAR(75) NULL DEFAULT NULL,
	`ub_create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`ub_create_user_id` VARCHAR(25) NULL DEFAULT NULL,
	`ub_last_updated_date` TIMESTAMP NULL DEFAULT NULL,
	`ub_last_updated_user_id` VARCHAR(25) NULL DEFAULT NULL,
	`ub_is_valid` BIT(1) NOT NULL,
	`external_trade_account` VARCHAR(20) NULL DEFAULT NULL,
	`external_protocol_no` VARCHAR(50) NULL DEFAULT NULL,
	`ub_capital_mode` VARCHAR(10) NULL DEFAULT NULL,
	`ubh_create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`ubh_history_id`)
)
charset = utf8;