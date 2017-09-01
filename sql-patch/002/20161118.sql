-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 121.40.187.122    Database: codi
-- ------------------------------------------------------
-- Server version	5.6.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `oc_operation_content`
--

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

