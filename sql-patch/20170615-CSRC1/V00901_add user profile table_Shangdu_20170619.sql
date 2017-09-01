drop table if exists uf_user_profile;

    /*==============================================================*/
/* table: uf_user_profile                                       */
/*==============================================================*/
    create table uf_user_profile
        (
            uf_profile_id        bigint not null auto_increment,
            ur_user_id           bigint not null,
            uf_user_address      varchar(300),
    uf_address_code      varchar(100),
    uf_user_occupation   varchar(100),
    uf_occupation_code   varchar(20),
    uf_self_sustain      bit,
    uf_beneficiary       varchar(25),
    uf_owner             varchar(25),
    uf_test_expired_date datetime,
    uf_create_date       datetime not null,
    uf_create_user_id    varchar(25),
    uf_last_updated_date datetime,
    uf_last_updated_user_id varchar(25),
    primary key (uf_profile_id)
) DEFAULT CHARSET = utf8;
 
    alter table uf_user_profile add constraint fk_uf_ur_id foreign key (ur_user_id)
    references ur_user (ur_user_id) on delete restrict on update restrict;