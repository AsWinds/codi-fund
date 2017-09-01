/* 扣款状态 */
alter table of_order_fund add of_deduct_status int null;
/* ta确认状态 */
alter table of_order_fund add of_taconfirm_flag int null;
/* 发送标志 */
alter table of_order_fund add of_send_flag int null;