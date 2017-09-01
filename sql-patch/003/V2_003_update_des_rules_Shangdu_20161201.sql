#更新密码的正则，需要重启redis
update rule_lu_lookup
set rule_lu_text='(?<FIELD>["]?#FIELD#["]?)(?<OPERATOR>[:|=]["]?)(?<HIDE>.{0,35}?)(?<END>[,|&|"])', 
	 rule_lu_last_updated_user_id='Shangdu',
	 rule_lu_last_updated_date=now()
where rule_lu_type='DESEXP' and rule_lu_value='PASSWORD';


INSERT INTO `rule_lu_lookup` (`rule_lu_type`, `rule_lu_value`, `rule_lu_text`, rule_lu_component_value,
`rule_lu_status`, `rule_lu_valid`, `rule_create_user_id`, `rule_lu_create_date`, `rule_lu_last_updated_user_id`, `rule_lu_last_updated_date`) VALUES
#要脱敏的输入字段
('DESFD', 'id_no', 'CARD', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
('DESFD', 'real_name', 'NAME', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
('DESFD', 'mobile_tel', 'MOBILE', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
('DESFD', 'bank_account', 'BANK', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
('DESFD', 'newest_passwd', 'PASSWORD', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now());


	