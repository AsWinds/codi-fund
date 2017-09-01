drop table if exists pp_peproduct;

	/*==============================================================*/
	/* table: pp_peproduct                                          */
	/*==============================================================*/
	create table pp_peproduct
	(
	   pp_product_id        bigint not null auto_increment,
	   pp_product_name      varchar(500) not null,
	   pp_product_duration  varchar(150) not null,
	   pp_product_status    int not null comment '1-已上架
	            2-已下架',
	   pp_product_thumbnail varchar(500) not null,
	   pp_product_url       varchar(150) not null,
	   pp_is_valid          bit not null,
	   pp_create_date       datetime not null,
	   pp_create_user_id    varchar(25),
	   pp_last_update_date  datetime,
	   pp_last_update_user_id varchar(25),
	   primary key (pp_product_id)
	)
	
	charset = utf8;