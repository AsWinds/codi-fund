-- --------------------------------------------------------
-- Author:                            Shangdu Lin
-- Date:                        	  2016-11-07
-- Info:                              用户登录的历史表
-- --------------------------------------------------------


-- 新建表 ush_user_session_history 结构
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

