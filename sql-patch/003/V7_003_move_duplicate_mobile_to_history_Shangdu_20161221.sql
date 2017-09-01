#把重复数据拷贝到历史表
insert into urh_user_history(ur_user_id, ur_user_mobile, ur_user_name, ur_user_card, ur_user_email, ur_login_password, 
    ur_trade_password, ur_user_state, ur_create_date, ur_create_user_id, ur_last_updated_date, 
    ur_last_updated_user_id,ur_is_valid,external_client_id,ur_user_from, urh_create_date) 
select ur_user_id, ur_user_mobile, ur_user_name, ur_user_card, ur_user_email, ur_login_password, 
    ur_trade_password, ur_user_state, ur_create_date, ur_create_user_id, ur_last_updated_date, 
    ur_last_updated_user_id,ur_is_valid,external_client_id,ur_user_from, now() from ur_user 
where ur_user_id=320 and ur_user_mobile='13567178555' and ur_is_valid=0;

#删除重复数据
delete from ur_user where ur_user_id=320 and ur_user_mobile='13567178555' and ur_is_valid=0;
