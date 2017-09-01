
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_news
-- ----------------------------
DROP TABLE IF EXISTS `sys_news`;
CREATE TABLE `sys_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `brief_title` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `content` text,
  `source` varchar(255) DEFAULT NULL,
  `from_url` varchar(1024) DEFAULT NULL,
  `publish_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `modify_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `location` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  `keyword` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;
