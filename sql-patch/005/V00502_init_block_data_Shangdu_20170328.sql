-- --------------------------------------------------------
-- 主机:                           121.40.187.122
-- 服务器版本:                        5.6.24-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 正在导出表  codi_dev.oc_operation_content 的数据：~8 rows (大约)
DELETE FROM `oc_operation_content`;
/*!40000 ALTER TABLE `oc_operation_content` DISABLE KEYS */;
INSERT INTO `oc_operation_content` (`oc_id`, `oc_title`, `oc_sub_title`, `oc_description`, `oc_tag`, `oc_style`, `oc_block_name`, `oc_priority`, `oc_indicant`, `oc_indicant_description`, `oc_url`, `oc_status`, `oc_extra_map`, `oc_create_time`, `oc_last_updated_time`,oc_indicant_type,oc_version) VALUES
	(1, '国企改革', '国家战略发展', '交银国企改革灵活配置混合', '指数', '#3890fa', '当前热点', 10, '6', '近半年收益', '', '0', '{\'fundCode\':\'519756\'}', now(), NULL, '6M','1'),
	(2, '医疗健康', '布局医疗改革红利', '信诚中证800医药指数分级', '指数', '#3890fa', '当前热点', 10, '6', '近半年收益', '', '0', '{\'fundCode\':\'165519\'}', now(), NULL, '6M','1'),
	(3, '指数定投', '以指数为标的', '信诚中证500', '策略，指数', '#3890fa', '投资策略', 1, '36', '近三年收益', '', '0', '{\'fundCode\':\'165511\'}', now(), NULL, '3Y','1'),
	(4, '优选债基', '中低风险，收益稳健', '银河收益债券', '策略，债基', '#3890fa', '投资策略', 1, '36', '近三年收益', '', '0', '{\'fundCode\':\'151002\'}', now(), NULL, '3Y','1');
/*!40000 ALTER TABLE `oc_operation_content` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
