/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.18 : Database - upload_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`upload_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `upload_db`;

/*Table structure for table `t_file` */

DROP TABLE IF EXISTS `t_file`;

CREATE TABLE `t_file` (
  `id` varchar(32) NOT NULL,
  `create_time` varchar(25) DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL,
  `url` text,
  `key_from` text,
  `file_type` int(11) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `storage_location` text,
  `file_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_file` */

insert  into `t_file`(`id`,`create_time`,`file_size`,`url`,`key_from`,`file_type`,`user_id`,`storage_location`,`file_name`) values ('ce6a19f1c465495cbe55e46116e8d7cd','2018-07-15 22:27:41',240857,'http://localhost:88/images/20180715/fe3a2b5bac0547ca831e1cc8457cf62e.jpg',NULL,1,NULL,'D:\\upload\\images\\20180715\\fe3a2b5bac0547ca831e1cc8457cf62e.jpg','fe3a2b5bac0547ca831e1cc8457cf62e.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
