/** 2016年10月27日16:25:37 */
ALTER TABLE `fi_fund_info` 
ADD COLUMN `fi_fund_type_name` VARCHAR(64) NULL COMMENT '基金类型名称' AFTER `fi_ofund_type`;
ALTER TABLE `fi_fund_info` 
CHANGE COLUMN `fi_ofund_type` `fi_ofund_type` CHAR(1) NULL DEFAULT NULL COMMENT '基金类型code(从恒生取得)' ,
CHANGE COLUMN `fi_fund_type_name` `fi_fund_type_name` VARCHAR(64) NULL DEFAULT NULL COMMENT '基金类型名称，从聚源取得的' ,
ADD COLUMN `fi_fund_type_code` INT(16) NOT NULL COMMENT '基金类型code，这是从聚源取得的，跟恒生取得的不一样' AFTER `fi_fund_type_name`;
ALTER TABLE `fi_fund_info` 
CHANGE COLUMN `fi_fund_type_code` `fi_fund_type_code` INT(16) NULL COMMENT '基金类型code，这是从聚源取得的，跟恒生取得的不一样' ;
