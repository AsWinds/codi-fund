
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_affiche
-- ----------------------------
DROP TABLE IF EXISTS `sys_affiche`;
CREATE TABLE `sys_affiche` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text,
  `link` varchar(1024) DEFAULT NULL,
  `is_up` bit(1) NOT NULL,
  `publish_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `end_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `publisher` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;
