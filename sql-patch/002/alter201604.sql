/** 2016��10��27��16:25:37 */
ALTER TABLE `fi_fund_info` 
ADD COLUMN `fi_fund_type_name` VARCHAR(64) NULL COMMENT '������������' AFTER `fi_ofund_type`;
ALTER TABLE `fi_fund_info` 
CHANGE COLUMN `fi_ofund_type` `fi_ofund_type` CHAR(1) NULL DEFAULT NULL COMMENT '��������code(�Ӻ���ȡ��)' ,
CHANGE COLUMN `fi_fund_type_name` `fi_fund_type_name` VARCHAR(64) NULL DEFAULT NULL COMMENT '�����������ƣ��Ӿ�Դȡ�õ�' ,
ADD COLUMN `fi_fund_type_code` INT(16) NOT NULL COMMENT '��������code�����ǴӾ�Դȡ�õģ�������ȡ�õĲ�һ��' AFTER `fi_fund_type_name`;
ALTER TABLE `fi_fund_info` 
CHANGE COLUMN `fi_fund_type_code` `fi_fund_type_code` INT(16) NULL COMMENT '��������code�����ǴӾ�Դȡ�õģ�������ȡ�õĲ�һ��' ;
