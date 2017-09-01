	
INSERT INTO `rule_lu_lookup` (`rule_lu_type`, `rule_lu_value`, `rule_lu_text`, rule_lu_component_value,
`rule_lu_status`, `rule_lu_valid`, `rule_create_user_id`, `rule_lu_create_date`, `rule_lu_last_updated_user_id`, `rule_lu_last_updated_date`) VALUES	
	('SMSCONF', 'IPTIME', '设置一个时间段，单位为分钟，控制一个IP在一个时间段的发送频率', '60', NULL, b'1', 'Shangdu', now(), null, null),
	('SMSCONF', 'MOBILETIME', '设置一个时间段，单位为分钟，控制一个手机号在一个时间段的发送频率', '1', NULL, b'1', 'Shangdu', now(), null, null),
	('SMSCONF', 'IPLIMIT', '设置一个发送次数，控制一个IP在一个时间段的发送次数', '600', NULL, b'1', 'Shangdu', now(), null, null),
	('SMSCONF', 'MOBILELIMIT', '设置一个发送次数，控制一个手机号在一个时间段的发送次数', '1', NULL, b'1', 'Shangdu', now(), null, null);