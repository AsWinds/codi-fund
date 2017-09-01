--V1_insert_lookup_EXDFDTYPE_AND_EXDBANK_20161027
--V2_insert_lookup_HSBANK_AND_EPAYBANK_20161101
--V3_alter_lookup_table_add_column_component_value_20161101
--V4_insert_lookup_TDACCSTATUS_20161103
--V5_insert_lookup_TAACCSTATUS_20161103
--V6_add_ip_column_to_session_table_20161107
--V7_create_session_history_table_20161107

--rule_lu_lookup
--us_user_session
--ush_user_session_history
--oc_operation_content
--STATIC_SH300
--of_order_fund
--av_app_version
--QRTZ*


	
--us_user_session
alter table us_user_session add column us_ip varchar(25) null;

--ush_user_session_history
CREATE TABLE IF NOT EXISTS `ush_user_session_history` (
  `ush_user_session_history_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `us_user_session_id` bigint(20) NOT NULL,
  `ur_user_id` bigint(20) NOT NULL,
  `us_channel_id` varchar(50) DEFAULT NULL,
  `us_device_id` varchar(50) DEFAULT NULL,
  `us_login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `us_expire_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `us_token` varchar(50) NOT NULL,
  `us_ip` varchar(25) DEFAULT NULL,
   ush_create_date TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ush_user_session_history_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--oc_operation_content
DROP TABLE IF EXISTS `oc_operation_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oc_operation_content` (
  `oc_id` bigint(9) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `oc_title` varchar(45) NOT NULL COMMENT '名称',
  `oc_sub_title` varchar(45) DEFAULT NULL COMMENT '副标题',
  `oc_description` varchar(200) DEFAULT NULL COMMENT '说明',
  `oc_tag` varchar(45) DEFAULT NULL COMMENT '标签',
  `oc_style` varchar(500) DEFAULT NULL COMMENT '样式,JSON格式  例子：{''tagColor'': ''#fff''}',
  `oc_block_name` varchar(45) DEFAULT NULL COMMENT '区块',
  `oc_priority` int(5) DEFAULT '0' COMMENT '优先级，用于排序。值越大越靠前',
  `oc_indicant` varchar(45) DEFAULT NULL COMMENT '指标值',
  `oc_indicant_description` varchar(45) DEFAULT NULL COMMENT '指标说明',
  `oc_url` varchar(500) DEFAULT NULL COMMENT '跳转的页面URL',
  `oc_status` varchar(2) DEFAULT '0' COMMENT '状态（0：正常显示；1：不显示）',
  `oc_extra_map` varchar(500) DEFAULT NULL COMMENT '额外扩展字段，用于存放fund_code等字段，JSON格式',
  `oc_create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `oc_last_updated_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`oc_id`),
  KEY `INDEX_BLOCK` (`oc_status`,`oc_priority`) COMMENT '用于首页按区块优先级排序'
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用于APP首页运营';
/*!40101 SET character_set_client = @saved_cs_client */;

--STATIC_SH300
DROP TABLE IF EXISTS STATIC_SH300;
CREATE TABLE STATIC_SH300
(
   ID                   BIGINT(9) NOT NULL AUTO_INCREMENT,
   TRADING_DATE         DATE,
   OPEN_PRICE           DECIMAL(9,2),
   CLOSE_PRICE          DECIMAL(9,2),
   MAX_PRICE            DECIMAL(9,2),
   MIN_PRICE            DECIMAL(9,2),
   TURNOVER_VOLUME      DECIMAL(18,2),
   DAILY_GROWTH_RATE    DECIMAL(9,2),
   CREATE_DATE          DATETIME NOT NULL,
   PRIMARY KEY (ID)
);
ALTER TABLE STATIC_SH300 COMMENT '深沪300数据，一年数据量预估12*20=240';
ALTER TABLE STATIC_SH300 AUTO_INCREMENT=1001;

--of_order_fund
ALTER TABLE `of_order_fund` 
ADD COLUMN `external_scheduled_protocol_id` VARCHAR(20) NULL COMMENT '定投申购、变更时的定投协议号' AFTER `external_undo_no`;
ALTER TABLE `of_order_fund` 
ADD COLUMN `external_protocol_period_unit` VARCHAR(1) NULL COMMENT '协议周期单位(\'年\',\'月\',\'日\')' AFTER `external_scheduled_protocol_id`,
ADD COLUMN `external_protocol_fix_day` INT(2) NULL COMMENT '定投交易日' AFTER `external_protocol_period_unit`;

--av_app_version
-- ----------------------------
-- 增加唯一约束;
-- ----------------------------
ALTER TABLE av_app_version ADD UNIQUE KEY platorm_identifier_version (av_platform, av_app_identifier, av_version);
-- ----------------------------
-- 增加非空约束;
-- ----------------------------
ALTER TABLE av_app_version MODIFY av_app_identifier char(64) NOT NULL COMMENT 'App 标识';
ALTER TABLE av_app_version MODIFY av_app_name char(64) NOT NULL COMMENT 'App 名称';
ALTER TABLE av_app_version MODIFY av_version char(64) NOT NULL COMMENT 'App 版本';
ALTER TABLE av_app_version MODIFY av_platform char(32) NOT NULL COMMENT 'App 平台';
ALTER TABLE av_app_version MODIFY av_release_notes text NOT NULL COMMENT '发布概况';
ALTER TABLE av_app_version MODIFY av_need_forece_update boolean NOT NULL COMMENT '是否必须升级';
-- ----------------------------
-- Android 1.1.0;
-- ----------------------------
--INSERT INTO av_app_version (av_app_identifier, av_app_name, av_version, av_platform, av_release_notes, av_need_forece_update, av_download_path)
-- VALUES ('com.codiwealth', '科地基金', '1.1.0', 'Android', '主页大排版, 优化性能和使用体验。', FALSE, 'https://cd121.com/download/CodiFund-1.1.0.apk');

 
 
--QRTZ*
DROP TABLE IF EXISTS QRTZ_FIRED_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_PAUSED_TRIGGER_GRPS;
DROP TABLE IF EXISTS QRTZ_SCHEDULER_STATE;
DROP TABLE IF EXISTS QRTZ_LOCKS;
DROP TABLE IF EXISTS QRTZ_SIMPLE_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_SIMPROP_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_CRON_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_BLOB_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_JOB_DETAILS;
DROP TABLE IF EXISTS QRTZ_CALENDARS;

CREATE TABLE QRTZ_JOB_DETAILS(
SCHED_NAME VARCHAR(120) NOT NULL,
JOB_NAME VARCHAR(200) NOT NULL,
JOB_GROUP VARCHAR(200) NOT NULL,
DESCRIPTION VARCHAR(250) NULL,
JOB_CLASS_NAME VARCHAR(250) NOT NULL,
IS_DURABLE VARCHAR(1) NOT NULL,
IS_NONCONCURRENT VARCHAR(1) NOT NULL,
IS_UPDATE_DATA VARCHAR(1) NOT NULL,
REQUESTS_RECOVERY VARCHAR(1) NOT NULL,
JOB_DATA BLOB NULL,
PRIMARY KEY (SCHED_NAME,JOB_NAME,JOB_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
JOB_NAME VARCHAR(200) NOT NULL,
JOB_GROUP VARCHAR(200) NOT NULL,
DESCRIPTION VARCHAR(250) NULL,
NEXT_FIRE_TIME BIGINT(13) NULL,
PREV_FIRE_TIME BIGINT(13) NULL,
PRIORITY INTEGER NULL,
TRIGGER_STATE VARCHAR(16) NOT NULL,
TRIGGER_TYPE VARCHAR(8) NOT NULL,
START_TIME BIGINT(13) NOT NULL,
END_TIME BIGINT(13) NULL,
CALENDAR_NAME VARCHAR(200) NULL,
MISFIRE_INSTR SMALLINT(2) NULL,
JOB_DATA BLOB NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
REFERENCES QRTZ_JOB_DETAILS(SCHED_NAME,JOB_NAME,JOB_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_SIMPLE_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
REPEAT_COUNT BIGINT(7) NOT NULL,
REPEAT_INTERVAL BIGINT(12) NOT NULL,
TIMES_TRIGGERED BIGINT(10) NOT NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_CRON_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
CRON_EXPRESSION VARCHAR(120) NOT NULL,
TIME_ZONE_ID VARCHAR(80),
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_SIMPROP_TRIGGERS
  (          
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    STR_PROP_1 VARCHAR(512) NULL,
    STR_PROP_2 VARCHAR(512) NULL,
    STR_PROP_3 VARCHAR(512) NULL,
    INT_PROP_1 INT NULL,
    INT_PROP_2 INT NULL,
    LONG_PROP_1 BIGINT NULL,
    LONG_PROP_2 BIGINT NULL,
    DEC_PROP_1 NUMERIC(13,4) NULL,
    DEC_PROP_2 NUMERIC(13,4) NULL,
    BOOL_PROP_1 VARCHAR(1) NULL,
    BOOL_PROP_2 VARCHAR(1) NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP) 
    REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_BLOB_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
BLOB_DATA BLOB NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
INDEX (SCHED_NAME,TRIGGER_NAME, TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_CALENDARS (
SCHED_NAME VARCHAR(120) NOT NULL,
CALENDAR_NAME VARCHAR(200) NOT NULL,
CALENDAR BLOB NOT NULL,
PRIMARY KEY (SCHED_NAME,CALENDAR_NAME))
ENGINE=InnoDB;

CREATE TABLE QRTZ_PAUSED_TRIGGER_GRPS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_FIRED_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
ENTRY_ID VARCHAR(95) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
INSTANCE_NAME VARCHAR(200) NOT NULL,
FIRED_TIME BIGINT(13) NOT NULL,
SCHED_TIME BIGINT(13) NOT NULL,
PRIORITY INTEGER NOT NULL,
STATE VARCHAR(16) NOT NULL,
JOB_NAME VARCHAR(200) NULL,
JOB_GROUP VARCHAR(200) NULL,
IS_NONCONCURRENT VARCHAR(1) NULL,
REQUESTS_RECOVERY VARCHAR(1) NULL,
PRIMARY KEY (SCHED_NAME,ENTRY_ID))
ENGINE=InnoDB;

CREATE TABLE QRTZ_SCHEDULER_STATE (
SCHED_NAME VARCHAR(120) NOT NULL,
INSTANCE_NAME VARCHAR(200) NOT NULL,
LAST_CHECKIN_TIME BIGINT(13) NOT NULL,
CHECKIN_INTERVAL BIGINT(13) NOT NULL,
PRIMARY KEY (SCHED_NAME,INSTANCE_NAME))
ENGINE=InnoDB;

CREATE TABLE QRTZ_LOCKS (
SCHED_NAME VARCHAR(120) NOT NULL,
LOCK_NAME VARCHAR(40) NOT NULL,
PRIMARY KEY (SCHED_NAME,LOCK_NAME))
ENGINE=InnoDB;

CREATE INDEX IDX_QRTZ_J_REQ_RECOVERY ON QRTZ_JOB_DETAILS(SCHED_NAME,REQUESTS_RECOVERY);
CREATE INDEX IDX_QRTZ_J_GRP ON QRTZ_JOB_DETAILS(SCHED_NAME,JOB_GROUP);

CREATE INDEX IDX_QRTZ_T_J ON QRTZ_TRIGGERS(SCHED_NAME,JOB_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_T_JG ON QRTZ_TRIGGERS(SCHED_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_T_C ON QRTZ_TRIGGERS(SCHED_NAME,CALENDAR_NAME);
CREATE INDEX IDX_QRTZ_T_G ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_GROUP);
CREATE INDEX IDX_QRTZ_T_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_N_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_N_G_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_GROUP,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_NEXT_FIRE_TIME ON QRTZ_TRIGGERS(SCHED_NAME,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_ST ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_STATE,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_MISFIRE ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_ST_MISFIRE ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_NFT_ST_MISFIRE_GRP ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_GROUP,TRIGGER_STATE);

CREATE INDEX IDX_QRTZ_FT_TRIG_INST_NAME ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,INSTANCE_NAME);
CREATE INDEX IDX_QRTZ_FT_INST_JOB_REQ_RCVRY ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,INSTANCE_NAME,REQUESTS_RECOVERY);
CREATE INDEX IDX_QRTZ_FT_J_G ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,JOB_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_FT_JG ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_FT_T_G ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP);
CREATE INDEX IDX_QRTZ_FT_TG ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,TRIGGER_GROUP);



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
	
--rule_lu_lookup
INSERT INTO `rule_lu_lookup` (`rule_lu_type`, `rule_lu_value`, `rule_lu_text`, rule_lu_component_value,
`rule_lu_status`, `rule_lu_valid`, `rule_create_user_id`, `rule_lu_create_date`, `rule_lu_last_updated_user_id`, `rule_lu_last_updated_date`) VALUES
	('TAACCSTATUS', '0', '正常', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', '1', '新开户', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', '2', '账号登记', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', '5', '正在销户', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', '6', '销户', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', 'A', '挂失', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', 'D', '冻结', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', 'F', '开户失败', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', 'G', '冻结且挂失', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now(),
	('TAACCSTATUS', 'I', '取消登记', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()));
	
INSERT INTO `rule_lu_lookup` (`rule_lu_type`, `rule_lu_value`, `rule_lu_text`, rule_lu_component_value,
`rule_lu_status`, `rule_lu_valid`, `rule_create_user_id`, `rule_lu_create_date`, `rule_lu_last_updated_user_id`, `rule_lu_last_updated_date`) VALUES
	('TDACCSTATUS', '0', '正常', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TDACCSTATUS', '1', '新开户', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TDACCSTATUS', '2', '账号登记', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TDACCSTATUS', '5', '正在销户', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TDACCSTATUS', '6', '销户', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TDACCSTATUS', 'A', '挂失', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TDACCSTATUS', 'D', '冻结', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TDACCSTATUS', 'F', '开户失败', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TDACCSTATUS', 'G', '冻结且挂失', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now());
	
INSERT INTO `rule_lu_lookup` (`rule_lu_type`, `rule_lu_value`, `rule_lu_text`, rule_lu_component_value,
`rule_lu_status`, `rule_lu_valid`, `rule_create_user_id`, `rule_lu_create_date`, `rule_lu_last_updated_user_id`, `rule_lu_last_updated_date`) VALUES
	('TAACCSTATUS', '0', '正常', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', '1', '新开户', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', '2', '账号登记', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', '5', '正在销户', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', '6', '销户', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', 'A', '挂失', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', 'D', '冻结', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', 'F', '开户失败', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', 'G', '冻结且挂失', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('TAACCSTATUS', 'I', '取消登记', '', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now());
	
INSERT INTO `rule_lu_lookup` (`rule_lu_type`, `rule_lu_value`, `rule_lu_text`, rule_lu_component_value,
`rule_lu_status`, `rule_lu_valid`, `rule_create_user_id`, `rule_lu_create_date`, `rule_lu_last_updated_user_id`, `rule_lu_last_updated_date`) VALUES	
	('BUSINAME', '022', '申购', '122', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('BUSINAME', '024', '赎回', '124', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('BUSINAME', '029', '设置分红方式', '129', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('BUSINAME', '053', '撤销申请', '153', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),	
	('BUSINAME', '095', '定投赎回', '195', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('BUSINAME', '091', '定投赎回签订', '191', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('BUSINAME', '094', '定投赎回取消', '194', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),	
	('BUSINAME', '987', '定投赎回修改', '191', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('BUSINAME', '039', '定投申购', '139', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('BUSINAME', '090', '定投协议签订', '159', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('BUSINAME', '988', '定投协议修改', '161', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now()),
	('BUSINAME', '093', '定投协议终止', '193', NULL, b'1', 'SYSTEM', now(), 'SYSTEM', now());
	

	

