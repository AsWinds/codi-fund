INSERT INTO `rule_lu_lookup` (`rule_lu_type`, `rule_lu_value`, `rule_lu_text`, rule_lu_component_value,
`rule_lu_status`, `rule_lu_valid`, `rule_create_user_id`, `rule_lu_create_date`, `rule_lu_last_updated_user_id`, `rule_lu_last_updated_date`) VALUES
	('TAACCSTATUS', '0', '正常', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', '1', '新开户', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', '2', '账号登记', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', '5', '正在销户', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', '6', '销户', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', 'A', '挂失', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', 'D', '冻结', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', 'F', '开户失败', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', 'G', '冻结且挂失', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', 'I', '取消登记', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now());
	