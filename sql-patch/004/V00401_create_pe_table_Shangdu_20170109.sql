drop table if exists up_user_privateequity;

	/*==============================================================*/
	/* table: up_user_privateequity                                 */
	/*==============================================================*/
	create table up_user_privateequity
	(
	   up_pe_id             bigint not null auto_increment,
	   ur_user_id           bigint,
	   up_qualified_invester bit,
	   up_is_valid          bit not null,
	   up_paper_id          varchar(50),
	   up_risk_tolerance    varchar(10),
	   up_create_date       datetime not null,
	   up_create_user_id    varchar(25),
	   up_last_update_date  datetime,
	   up_last_update_user_id varchar(25),
	   primary key (up_pe_id)
	)
	charset = utf8;

	alter table up_user_privateequity add constraint up_fk_reference_5 foreign key (ur_user_id)
	      references ur_user (ur_user_id) on delete restrict on update restrict;