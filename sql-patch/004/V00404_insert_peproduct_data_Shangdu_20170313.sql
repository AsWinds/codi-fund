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
-- 正在导出表  codi_dev.pp_peproduct 的数据：~2 rows (大约)
DELETE FROM `pp_peproduct`;
/*!40000 ALTER TABLE `pp_peproduct` DISABLE KEYS */;
INSERT INTO `pp_peproduct` (`pp_product_id`, `pp_product_name`, `pp_product_duration`, `pp_product_status`, `pp_product_thumbnail`, `pp_product_url`, `pp_is_valid`, `pp_create_date`, `pp_create_user_id`, `pp_last_update_date`, `pp_last_update_user_id`) VALUES
	(1, '科地资管5号产业园分级投资基金', '24个月', 1, 'crm/img/icon-cover-5.jpg', 'crm/industrial5.html', b'1', '2017-01-09 23:39:33', NULL, NULL, NULL);
/*!40000 ALTER TABLE `pp_peproduct` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
