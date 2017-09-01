
/* User Session表 删除数据 */
delete from us_user_session where ur_user_id=302;

/* User Bank表 备份数据 */
insert into ubh_user_bank_history (ub_user_bank_id, ur_user_id, ub_bank_name, ub_bank_code,
		ub_user_bank_no, ub_user_bank_owner,
		ub_user_bank_mobile,
		ub_bank_branch_name, ub_create_date, ub_create_user_id,
		ub_last_updated_date,
		ub_last_updated_user_id,ub_is_valid,external_trade_account,external_protocol_no,ub_capital_mode, ubh_create_date) 
		select ub_user_bank_id, ur_user_id, ub_bank_name, ub_bank_code,
		ub_user_bank_no, ub_user_bank_owner,
		ub_user_bank_mobile,
		ub_bank_branch_name, ub_create_date, ub_create_user_id,
		ub_last_updated_date,
		ub_last_updated_user_id,ub_is_valid,external_trade_account,external_protocol_no,ub_capital_mode, now() from ub_user_bank  
		where ur_user_id=302 and ub_user_bank_id in (195,215) and ub_user_bank_owner='林尚都' and ub_user_bank_mobile='13819152672';

/* User Bank表 删除数据 */		
delete from ub_user_bank  where ur_user_id=302 and ub_user_bank_id in (195,215) and ub_user_bank_owner='林尚都' and ub_user_bank_mobile='13819152672';

/* User表 备份数据 */
insert into urh_user_history( ur_user_id, ur_user_mobile, ur_user_name, ur_user_card, ur_user_email, ur_login_password, 
    ur_trade_password, ur_user_state, ur_create_date, ur_create_user_id, ur_last_updated_date, 
    ur_last_updated_user_id,ur_is_valid,external_client_id,ur_user_from, urh_create_date) select  ur_user_id, ur_user_mobile, ur_user_name, ur_user_card, ur_user_email, ur_login_password, 
    ur_trade_password, ur_user_state, ur_create_date, ur_create_user_id, ur_last_updated_date, 
    ur_last_updated_user_id,ur_is_valid,external_client_id,ur_user_from, now() from ur_user where ur_user_id=302 and ur_user_mobile='13819152672' and ur_user_name='林尚都';

/* User表 删除数据 */
delete from ur_user where ur_user_id=302 and ur_user_mobile='13819152672' and ur_user_name='林尚都';
