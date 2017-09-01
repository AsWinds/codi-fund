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
  `oc_id` bigint(9) NOT NULL AUTO_INCREMENT COMMENT '����������',
  `oc_title` varchar(45) NOT NULL COMMENT '����',
  `oc_sub_title` varchar(45) DEFAULT NULL COMMENT '������',
  `oc_description` varchar(200) DEFAULT NULL COMMENT '˵��',
  `oc_tag` varchar(45) DEFAULT NULL COMMENT '��ǩ',
  `oc_style` varchar(500) DEFAULT NULL COMMENT '��ʽ,JSON��ʽ  ���ӣ�{''tagColor'': ''#fff''}',
  `oc_block_name` varchar(45) DEFAULT NULL COMMENT '����',
  `oc_priority` int(5) DEFAULT '0' COMMENT '���ȼ�����������ֵԽ��Խ��ǰ',
  `oc_indicant` varchar(45) DEFAULT NULL COMMENT 'ָ��ֵ',
  `oc_indicant_description` varchar(45) DEFAULT NULL COMMENT 'ָ��˵��',
  `oc_url` varchar(500) DEFAULT NULL COMMENT '��ת��ҳ��URL',
  `oc_status` varchar(2) DEFAULT '0' COMMENT '״̬��0��������ʾ��1������ʾ��',
  `oc_extra_map` varchar(500) DEFAULT NULL COMMENT '������չ�ֶΣ����ڴ��fund_code���ֶΣ�JSON��ʽ',
  `oc_create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `oc_last_updated_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`oc_id`),
  KEY `INDEX_BLOCK` (`oc_status`,`oc_priority`) COMMENT '������ҳ���������ȼ�����'
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='����APP��ҳ��Ӫ';
/*!40101 SET character_set_client = @saved_cs_client */;

