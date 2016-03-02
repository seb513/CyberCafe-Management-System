-- MySQL dump 10.13  Distrib 5.6.21, for Win32 (x86)
--
-- Host: localhost    Database: cybercafe
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Current Database: `cybercafe`
--

/*!40000 DROP DATABASE IF EXISTS `cybercafe`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `cybercafe` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `cybercafe`;

--
-- Table structure for table `tbl_cabin`
--

DROP TABLE IF EXISTS `tbl_cabin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_cabin` (
  `c_id` int(3) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) NOT NULL,
  `status` enum('Free','Occupied') NOT NULL,
  PRIMARY KEY (`c_id`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cabin`
--

LOCK TABLES `tbl_cabin` WRITE;
/*!40000 ALTER TABLE `tbl_cabin` DISABLE KEYS */;
INSERT INTO `tbl_cabin` VALUES (6,'PC1','Free'),(7,'PC2','Free'),(8,'PC3','Free'),(10,'PC4','Free'),(11,'PC5','Free'),(12,'PC6','Free'),(13,'PC7','Free'),(14,'PC8','Free');
/*!40000 ALTER TABLE `tbl_cabin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_cust_info`
--

DROP TABLE IF EXISTS `tbl_cust_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_cust_info` (
  `ci_id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`ci_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cust_info`
--

LOCK TABLES `tbl_cust_info` WRITE;
/*!40000 ALTER TABLE `tbl_cust_info` DISABLE KEYS */;
INSERT INTO `tbl_cust_info` VALUES (51,'aaa'),(52,'hdskfd');
/*!40000 ALTER TABLE `tbl_cust_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_customer`
--

DROP TABLE IF EXISTS `tbl_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_customer` (
  `cu_id` int(3) NOT NULL AUTO_INCREMENT,
  `a_id` int(3) DEFAULT NULL,
  `c_id` int(3) NOT NULL,
  `ci_id` int(3) DEFAULT NULL,
  `start_time` varchar(30) DEFAULT NULL,
  `end_time` varchar(30) DEFAULT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`cu_id`),
  KEY `t_id` (`a_id`),
  KEY `c_id` (`c_id`),
  KEY `a_id` (`a_id`),
  KEY `ci_id` (`ci_id`),
  CONSTRAINT `tbl_customer_ibfk_2` FOREIGN KEY (`c_id`) REFERENCES `tbl_cabin` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tbl_customer_ibfk_3` FOREIGN KEY (`a_id`) REFERENCES `tbl_member` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tbl_customer_ibfk_4` FOREIGN KEY (`ci_id`) REFERENCES `tbl_cust_info` (`ci_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customer`
--

LOCK TABLES `tbl_customer` WRITE;
/*!40000 ALTER TABLE `tbl_customer` DISABLE KEYS */;
INSERT INTO `tbl_customer` VALUES (79,NULL,7,51,'11:33:24','11:40:57','2015-01-10'),(80,NULL,8,52,'12:36:28','12:36:39','2015-01-10'),(81,7,10,NULL,'12:46:41','12:46:48','2015-01-10'),(82,9,12,NULL,'13:58:01','13:58:08','2015-01-10');
/*!40000 ALTER TABLE `tbl_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_member`
--

DROP TABLE IF EXISTS `tbl_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_member` (
  `m_id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_member`
--

LOCK TABLES `tbl_member` WRITE;
/*!40000 ALTER TABLE `tbl_member` DISABLE KEYS */;
INSERT INTO `tbl_member` VALUES (7,'shiva','M','9841','seb@gmail.com','ktm','2015-01-07'),(8,'bik','M','955555555','454555','ktm','2015-01-07'),(9,'rajan','M','3336597864','rajan@hotmail.com','hello','2015-01-08'),(11,'abc','M','9841157024','s@gmail.com','ktm','2015-01-09'),(12,'ajdslk','M','9874545478','seb@gmail.com','kktkkt','2015-01-09'),(13,'shivashrestha','M','9841157024','seb.513@hotmail.com','ktm, Nepal	','2015-01-10'),(14,'mike','M','9841157878','mike@hotmail.com','pkh, Nepal','2015-01-11');
/*!40000 ALTER TABLE `tbl_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tariff`
--

DROP TABLE IF EXISTS `tbl_tariff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_tariff` (
  `t_id` int(3) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) NOT NULL,
  `amount` int(3) NOT NULL,
  `reg_fee` int(3) NOT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tariff`
--

LOCK TABLES `tbl_tariff` WRITE;
/*!40000 ALTER TABLE `tbl_tariff` DISABLE KEYS */;
INSERT INTO `tbl_tariff` VALUES (3,'Member',20,350),(4,'Regular',25,0);
/*!40000 ALTER TABLE `tbl_tariff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user` (
  `u_id` int(3) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `status` varchar(5) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (4,'admin','pass','admin'),(5,'seb','pass','user');
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-23  2:24:08
