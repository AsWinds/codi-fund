INSERT INTO `rule_lu_lookup` (`rule_lu_type`, `rule_lu_value`, `rule_lu_text`, rule_lu_component_value,
`rule_lu_status`, `rule_lu_valid`, `rule_create_user_id`, `rule_lu_create_date`, `rule_lu_last_updated_user_id`, `rule_lu_last_updated_date`) VALUES
	#要脱敏的对应规则
	('DESEXP', 'PASSWORD', '(?<FIELD>[\"]?#FIELD#[\"]?)(?<OPERATOR>[:|=])(?<HIDE>[\"]?.{0,35}?)(?<END>[,|&|\"])', '${FIELD}${OPERATOR}#REPLACE#${END}', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESEXP', 'BANK', '(?<FIELD>[\"]?#FIELD#[\"]?)(?<OPERATOR>[:|=])(?<START>[\"]?\\d{6})(?<HIDE>\\d{2,15})(?<END>\\d{4}[,|&|\"]?)', '${FIELD}${OPERATOR}${START}#REPLACE#${END}', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESEXP', 'MOBILE', '(?<FIELD>[\"]?#FIELD#[\"]?)(?<OPERATOR>[:|=])(?<START>[\"]?\\d{3})(?<HIDE>\\d{4})(?<END>\\d{4}[,|&|\"]?)', '${FIELD}${OPERATOR}${START}#REPLACE#${END}', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESEXP', 'CARD', '(?<FIELD>[\"]?#FIELD#[\"]?)(?<OPERATOR>[:|=])(?<START>[\"]?\\d{10})(?<HIDE>\\d{1,4})(?<END>\\d{3}[\\d|x|X][,|&|\"]?)', '${FIELD}${OPERATOR}${START}#REPLACE#${END}', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESEXP', 'NAME', '(?<FIELD>[\"]?#FIELD#[\"]?)(?<OPERATOR>[:|=])(?<START>[\"]?.{1}+)(?<HIDE>.{1}+.{0,10}?)(?<END>.{0,1}?[,|&|\"]+)', '${FIELD}${OPERATOR}${START}#REPLACE#${END}', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),	
	
	#要脱敏的输入字段
	('DESFD', 'password', 'PASSWORD', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESFD', 'bankCard', 'BANK', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESFD', 'loginName', 'MOBILE', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESFD', 'userMobile', 'MOBILE', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESFD', 'userName', 'NAME', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESFD', 'userCard', 'CARD', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESFD', 'loginPassword', 'PASSWORD', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESFD', 'tradePassword', 'PASSWORD', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESFD', 'mobile', 'MOBILE', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESFD', 'cardNo', 'BANK', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),	
	('DESFD', 'userBankNo', 'BANK', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESFD', 'userBankMobile', 'MOBILE', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),	
	('DESFD', 'old_password', 'PASSWORD', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),	
	('DESFD', 'new_password', 'PASSWORD', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESFD', 'id_card', 'CARD', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('DESFD', 'bankAccount', 'BANK', 'DESEXP', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now());

