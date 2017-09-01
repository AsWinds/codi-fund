#设置易宝渠道申购单笔限额
#50000 -> 工商银行-ICBC，农业银行-ABC，中国银行-BOC，建设银行-CCB，交通银行-COMM，招商银行-CMB，兴业银行-CIB，浦发银行-SPDB，邮储银行-PSBC
update rule_lu_lookup
set rule_lu_component_value='50000', 
	 rule_lu_last_updated_user_id='Shangdu',
	 rule_lu_last_updated_date=now()
where rule_lu_type='EPAYBANK' and rule_lu_value in ('ICBC','ABC','BOC','CCB','COMM','CMB','CIB','SPDB','PSBC');

#300000 -> 光大银行-CEB, 中信银行-CITIC, 平安银行-SPABANK
update rule_lu_lookup
set rule_lu_component_value='300000', 
	 rule_lu_last_updated_user_id='Shangdu',
	 rule_lu_last_updated_date=now()
where rule_lu_type='EPAYBANK' and rule_lu_value in ('CEB','CITIC','SPABANK');

#200000 -> 广发银行-GDB, 华夏银行-HXBANK
update rule_lu_lookup
set rule_lu_component_value='200000', 
	 rule_lu_last_updated_user_id='Shangdu',
	 rule_lu_last_updated_date=now()
where rule_lu_type='EPAYBANK' and rule_lu_value in ('GDB','HXBANK');

#设置支付渠道,目前只有易宝
INSERT INTO `rule_lu_lookup` (`rule_lu_type`, `rule_lu_value`, `rule_lu_text`, rule_lu_component_value,
`rule_lu_status`, `rule_lu_valid`, `rule_create_user_id`, `rule_lu_create_date`, `rule_lu_last_updated_user_id`, `rule_lu_last_updated_date`) VALUES
('PAYWAY', 'P', '易宝支付', 'EPAYBANK', 1, b'1', 'Shangdu', now(), null, null);





	