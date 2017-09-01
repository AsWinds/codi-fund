drop table if exists pa_peappointment;

	/*==============================================================*/
	/* table: pa_peappointment                                      */
	/*==============================================================*/
	create table pa_peappointment
	(
	   pa_appointment_id    bigint not null auto_increment,
	   pa_client_name       varchar(150) not null,
	   pa_client_mobile     varchar(50) not null,
	   pp_product_id        bigint not null,
	   pp_product_name      varchar(500) not null,
	   pa_appointment_time  datetime not null,
	   pa_is_valid          bit not null,
	   pa_create_date       datetime not null,
	   pa_create_user_id    varchar(25),
	   pa_last_update_date  datetime,
	   pa_last_update_user_id varchar(25),
	   primary key (pa_appointment_id)
	)
	charset = utf8;

	alter table pa_peappointment add constraint pa_fk_reference_017 foreign key (pp_product_id)
	      references pp_peproduct (pp_product_id) on delete restrict on update restrict;