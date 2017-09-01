
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_fund_course
-- ----------------------------
DROP TABLE IF EXISTS `sys_fund_course`;
CREATE TABLE `sys_fund_course` (
  `fc_course_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fc_course_title` varchar(150) NOT NULL,
  `fc_course_type` int(11) NOT NULL,
  `fc_course_content` text NOT NULL,
  `fc_create_date` datetime NOT NULL,
  `fc_create_user_id` varchar(50) DEFAULT NULL,
  `fc_last_updated_date` datetime DEFAULT NULL,
  `fc_last_updated_user_id` varchar(50) DEFAULT NULL,
  `fc_publish_date` datetime DEFAULT NULL,
  `fc_publisher` varchar(50) DEFAULT NULL,
  `fc_is_deleted` bit(1) NOT NULL,
  PRIMARY KEY (`fc_course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;
