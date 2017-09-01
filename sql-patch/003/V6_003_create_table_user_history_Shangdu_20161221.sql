drop table if exists urh_user_history;

/*==============================================================*/
/* table: urh_user_history                                      */
/*==============================================================*/
create table urh_user_history
(
   urh_history_id       bigint not null auto_increment,
   ur_user_id           bigint not null,
   ur_user_mobile       varchar(11) not null,
   ur_user_name         varchar(25),
   ur_user_card         varchar(25),
   ur_user_email        varchar(25),
   ur_login_password    varchar(50),
   ur_trade_password    varchar(50),
   ur_user_state        int not null,
   ur_create_date       timestamp not null,
   ur_create_user_id    varchar(25),
   ur_last_updated_date timestamp,
   ur_last_updated_user_id varchar(25),
   ur_is_valid          bool not null,
   external_client_id   varchar(30),
   ur_user_from         varchar(20),
   urh_create_date      timestamp not null,
   primary key (urh_history_id)
)
charset = utf8;