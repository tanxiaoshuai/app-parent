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
  `key_form_path` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_file` */

insert  into `t_file`(`id`,`create_time`,`file_size`,`url`,`key_from`,`file_type`,`user_id`,`storage_location`,`file_name`,`key_form_path`) values ('dc9f1b2fdb0c4cc9bdf138fced04483d','2018-07-16 22:54:20',278977,'http://localhost:88/videos/20180716/f2bbef7f389f4b0bb71af16bd2189994.mp4','http://localhost:88/videos/20180716/b16ca0f4802a428d8cbf14225d1784b4.jpg',3,'881a5581e7f14435ba771621981696e','D:\\upload\\videos\\20180716\\f2bbef7f389f4b0bb71af16bd2189994.mp4','f2bbef7f389f4b0bb71af16bd2189994.mp4','D:\\upload\\videos\\20180716\\b16ca0f4802a428d8cbf14225d1784b4.jpg'),('febbe592ea794180b67c507d47af6476','2018-07-16 22:49:13',240857,'http://localhost:88/images/20180716/94d23cb160864c2195fa9eaeff9406fd.jpg','http://localhost:88/images/20180716/be83c752c5ae435aa0f9cce8ab4dabc1.jpg',1,'881a5581e7f14435ba771621981696e','D:\\upload\\images\\20180716\\94d23cb160864c2195fa9eaeff9406fd.jpg','94d23cb160864c2195fa9eaeff9406fd.jpg','D:\\upload\\images\\20180716\\be83c752c5ae435aa0f9cce8ab4dabc1.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
