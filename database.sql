/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 10.1.35-MariaDB : Database - d3
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`d3` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `d3`;

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` date DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `invoice` */

insert  into `invoice`(`id`,`created_date`,`amount`) values 
(1,'2019-11-18',NULL),
(2,'2019-11-18',1471.00);

/*Table structure for table `invoice_item` */

DROP TABLE IF EXISTS `invoice_item`;

CREATE TABLE `invoice_item` (
  `invoice_id` bigint(20) NOT NULL,
  `order_no` bigint(20) NOT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `product_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`invoice_id`,`order_no`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `invoice_item_ibfk_1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`),
  CONSTRAINT `invoice_item_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `invoice_item` */

insert  into `invoice_item`(`invoice_id`,`order_no`,`quantity`,`price`,`product_id`) values 
(1,1,1,16.00,2),
(1,2,1,150.00,1),
(2,1,1,150.00,1),
(2,2,1,1321.00,5);

/*Table structure for table `manufacturer` */

DROP TABLE IF EXISTS `manufacturer`;

CREATE TABLE `manufacturer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `manufacturer` */

insert  into `manufacturer`(`id`,`name`) values 
(1,'Manufacturer_1'),
(2,'Manufacturer with id 2');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_manufacturer` bigint(20) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `measurement_unit` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `product` */

insert  into `product`(`id`,`name`,`description`,`id_manufacturer`,`price`,`measurement_unit`) values 
(1,'product','safa',2,150,'KG'),
(2,'prod','asfasg',2,16,'KG'),
(3,'prod','asfas',2,1,'KG'),
(4,'prod','asfsaf',2,150,'KG'),
(5,'asf','asfas',2,1321,'KG'),
(6,'asfas','safasf',1,154,'L'),
(7,'p2','safas',1,15,'PCS'),
(9,'prod8','saf',2,8,'KG');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`firstname`,`lastname`,`username`,`password`,`email`) values 
(1,'Pera','Peric','pera','pera','pera@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
