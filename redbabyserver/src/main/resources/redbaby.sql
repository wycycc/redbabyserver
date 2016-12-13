/*
SQLyog Ultimate v8.32 
MySQL - 5.0.22-community-nt : Database - redbaby
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`redbaby` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `redbaby`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(11) NOT NULL auto_increment,
  `address_id` varchar(255) collate utf8_bin default NULL,
  `name` varchar(255) collate utf8_bin default NULL,
  `phonenumber` varchar(255) collate utf8_bin default NULL,
  `fixedtel` varchar(255) collate utf8_bin default NULL,
  `provinceid` varchar(255) collate utf8_bin default NULL,
  `cityid` varchar(255) collate utf8_bin default NULL,
  `area_id` varchar(255) collate utf8_bin default NULL,
  `areadetail` varchar(255) collate utf8_bin default NULL,
  `zipcode` varchar(255) collate utf8_bin default NULL,
  `isdefault` varchar(255) collate utf8_bin default NULL,
  `user_id` varchar(255) collate utf8_bin default NULL,
  `state` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `address` */

insert  into `address`(`id`,`address_id`,`name`,`phonenumber`,`fixedtel`,`provinceid`,`cityid`,`area_id`,`areadetail`,`zipcode`,`isdefault`,`user_id`,`state`) values (1,'1001','肖文','15801477821','010-88496666','102','10203','1020304','闵庄路3号','100195','','30505',NULL),(12,'857a5f12-a15b-4c0b-b31f-0dbbf8fff3d1','?','?','?','?','?','?','?','?',NULL,'?',NULL),(13,'751e43db-3958-469d-9e12-57140ee3d165','?','?','?','?','?','?','?','?',NULL,'?',NULL),(14,'3357b3ac-4045-4543-a3f9-c0e4298606fe','?','?','?','?','?','?','?','?',NULL,'?',NULL),(15,'a5823b8b-44ae-4136-9a89-1c41631dd7d2','?','?','?','?','?','?','?','?',NULL,'?',NULL),(16,'c9039354-acb5-49a1-812b-c5e555590077','?','?','?','?','?','?','?','?',NULL,'?',NULL),(17,'9249edc3-49b9-4a60-804d-736faf920461','?','?','?','?','?','?','?','?',NULL,'?',NULL),(18,'968b32a5-18a5-4ae7-a3f7-0fc4a5227c06','?','?','?','?','?','?','?','?',NULL,'?',NULL),(19,'10816186-ec38-4cca-a8be-802a6cadeb82','?','?','?','?','?','?','?','?',NULL,'?',NULL);

/*Table structure for table `addressarea` */

DROP TABLE IF EXISTS `addressarea`;

CREATE TABLE `addressarea` (
  `id` int(11) NOT NULL auto_increment,
  `area_id` varchar(255) collate utf8_bin default NULL,
  `area` varchar(255) collate utf8_bin default NULL,
  `state` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `addressarea` */

insert  into `addressarea`(`id`,`area_id`,`area`,`state`) values (1,'1020304','北京',NULL);

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) collate utf8_bin default NULL,
  `pic` varchar(255) collate utf8_bin default NULL,
  `brand_id` varchar(255) collate utf8_bin default NULL,
  `keyword` varchar(255) collate utf8_bin default NULL,
  `state` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `brand` */

insert  into `brand`(`id`,`name`,`pic`,`brand_id`,`keyword`,`state`) values (1,'ain',NULL,'1234','孕妇专区',NULL),(2,'ann',NULL,'1234','营养食品',NULL),(3,'11',NULL,'1234','孕妇专区',NULL),(4,'1212',NULL,'1234','营养食品',NULL);

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `id` int(11) NOT NULL auto_increment COMMENT '购物车ID',
  `totalCount` varchar(255) NOT NULL COMMENT '商品总数量',
  `user_id` varchar(255) NOT NULL COMMENT '购物项',
  `totalPrice` varchar(255) NOT NULL COMMENT '商品总金额',
  `totalPoint` varchar(255) NOT NULL COMMENT '品商总积分',
  `state` int(11) NOT NULL default '1',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cart` */

insert  into `cart`(`id`,`totalCount`,`user_id`,`totalPrice`,`totalPoint`,`state`) values (1,'201','1','201','200',1),(2,'100','2','100','300',1),(3,'200','3','200','200',1);

/*Table structure for table `cartitem` */

DROP TABLE IF EXISTS `cartitem`;

CREATE TABLE `cartitem` (
  `id` int(11) NOT NULL auto_increment COMMENT '购物项ID',
  `cart_id` int(11) default NULL,
  `product_id` varchar(255) default NULL COMMENT '商品',
  `property_id` int(11) default NULL,
  `prodNum` int(11) default NULL COMMENT '商品数量',
  `state` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cartitem` */

insert  into `cartitem`(`id`,`cart_id`,`product_id`,`property_id`,`prodNum`,`state`) values (1,1,'1200001',1,2,NULL),(2,1,'1200002',1,3,NULL),(3,2,'1200001',3,3,NULL),(4,2,'1200004',NULL,4,NULL),(5,1,'1200001',1,1,1),(6,1,'1200001',1,1,1);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL auto_increment,
  `isLeafNode` varchar(11) default NULL,
  `name` varchar(255) default NULL,
  `parentId` int(11) default NULL,
  `pic` varchar(255) default NULL,
  `tag` varchar(255) default NULL,
  `version` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`isLeafNode`,`name`,`parentId`,`pic`,`tag`,`version`) values (1,'false','奶粉',0,NULL,NULL,'1.0'),(2,'false','随便',0,NULL,NULL,'1.1.1'),(3,'false','12244',0,NULL,NULL,'1.2'),(4,'false','3435',0,NULL,NULL,'1.0.2'),(5,'false','122323',0,NULL,NULL,'1.1'),(11,'false','雅培奶粉',1,NULL,NULL,'1.1'),(12,'false','aaaaa',1,NULL,NULL,'1.1'),(111,'true','奶粉奶粉',11,NULL,NULL,'1.1');

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL default '0',
  `title` varchar(255) default NULL,
  `content` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  `time` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `pro_id` varchar(255) default NULL,
  `state` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

/*Table structure for table `deliveryinfo` */

DROP TABLE IF EXISTS `deliveryinfo`;

CREATE TABLE `deliveryinfo` (
  `id` int(11) NOT NULL auto_increment,
  `code` varchar(255) collate utf8_bin default NULL,
  `deliverytime` varchar(255) collate utf8_bin default NULL,
  `state` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `deliveryinfo` */

insert  into `deliveryinfo`(`id`,`code`,`deliverytime`,`state`) values (1,'1','周一到周五送货',1),(2,'2','双休日及公众假期送货',1),(3,'3','时间不限，工作日、双休日及公众假期均可送货',NULL);

/*Table structure for table `favorites` */

DROP TABLE IF EXISTS `favorites`;

CREATE TABLE `favorites` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` varchar(255) collate utf8_bin default NULL,
  `product_id` varchar(255) collate utf8_bin default NULL,
  `state` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `favorites_ibfk_1` (`user_id`),
  KEY `favorites_ibfk_2` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `favorites` */

insert  into `favorites`(`id`,`user_id`,`product_id`,`state`) values (1,'30505','111',NULL),(2,'30505','222',NULL);

/*Table structure for table `filter` */

DROP TABLE IF EXISTS `filter`;

CREATE TABLE `filter` (
  `id` int(30) NOT NULL auto_increment,
  `property_id` varchar(255) collate utf8_bin default NULL,
  `product_id` varchar(255) collate utf8_bin default NULL,
  `state` varchar(30) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `filter` */

insert  into `filter`(`id`,`property_id`,`product_id`,`state`) values (1,'1','1200001','1'),(2,'2','1200001','1'),(3,'3','1200001','1'),(4,'4','1200002','1'),(5,'1','1200002','1');

/*Table structure for table `logistics` */

DROP TABLE IF EXISTS `logistics`;

CREATE TABLE `logistics` (
  `id` int(11) NOT NULL auto_increment,
  `order_id` varchar(255) default NULL,
  `listaddr` varchar(255) default NULL,
  `expressway` varchar(255) default NULL,
  `logisticscorp` varchar(255) default NULL,
  `logisticsid` varchar(255) default NULL,
  `state` int(11) NOT NULL default '0',
  `userid` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `logistics` */

insert  into `logistics`(`id`,`order_id`,`listaddr`,`expressway`,`logisticscorp`,`logisticsid`,`state`,`userid`) values (1,'de71f9b1-da44-4ec6-ae84-29a4bc3e74d1','上海','快递','顺丰','23332',1,'1');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(11) NOT NULL auto_increment,
  `order_uuid` varchar(255) collate utf8_bin default NULL,
  `type` varchar(255) collate utf8_bin default NULL,
  `status` varchar(255) collate utf8_bin default NULL,
  `time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `price` varchar(255) collate utf8_bin default NULL,
  `flag` varchar(255) collate utf8_bin default NULL,
  `payment_info_code` varchar(255) collate utf8_bin default NULL,
  `delivery_info_code` varchar(255) collate utf8_bin default NULL,
  `total_count` varchar(255) collate utf8_bin default NULL,
  `total_point` varchar(255) collate utf8_bin default NULL,
  `freight` varchar(255) collate utf8_bin default NULL,
  `prom_cut` varchar(255) collate utf8_bin default NULL,
  `total_price` varchar(255) collate utf8_bin default NULL,
  `invoicetitle` varchar(255) collate utf8_bin default NULL,
  `invoicecontent` varchar(255) collate utf8_bin default NULL,
  `userid` varchar(255) collate utf8_bin default NULL,
  `state` int(11) NOT NULL default '0',
  `invoicetype` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `order` */

insert  into `order`(`id`,`order_uuid`,`type`,`status`,`time`,`price`,`flag`,`payment_info_code`,`delivery_info_code`,`total_count`,`total_point`,`freight`,`prom_cut`,`total_price`,`invoicetitle`,`invoicecontent`,`userid`,`state`,`invoicetype`) values (1,'c54754e8-de0c-4f94-a82b-c370e431fc6f','1','aaaaaaa','2014-03-13 20:12:34','1','1','paymentid','deliveryid','1111','111111','10','20','22222','invoicetitle','invoicecontent','12',1,'type'),(2,'de71f9b1-da44-4ec6-ae84-29a4bc3e74d1','1','qqqqqqqqqq','2014-03-14 11:13:26','200.0','1','paymentid','deliveryid','200','200','10','20','200.0','invoicetitle','invoicecontent','1',1,'invoicetype');

/*Table structure for table `paymentinfo` */

DROP TABLE IF EXISTS `paymentinfo`;

CREATE TABLE `paymentinfo` (
  `id` int(11) NOT NULL auto_increment,
  `code` varchar(255) collate utf8_bin default NULL,
  `paytype` varchar(255) collate utf8_bin default NULL,
  `state` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `paymentinfo` */

insert  into `paymentinfo`(`id`,`code`,`paytype`,`state`) values (1,'1','货到付款',1),(2,'2','货到POS机',1),(3,'3','支付宝',1);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) collate utf8_bin default NULL,
  `pic` varchar(255) collate utf8_bin default NULL,
  `marketPrice` varchar(255) collate utf8_bin default NULL,
  `price` varchar(255) collate utf8_bin default NULL,
  `limitPrice` varchar(255) collate utf8_bin default NULL,
  `score` varchar(255) collate utf8_bin default NULL,
  `available` varchar(255) collate utf8_bin default NULL,
  `buyLimit` varchar(255) collate utf8_bin default NULL,
  `productProm` varchar(255) collate utf8_bin default NULL,
  `inventoryArea` varchar(255) collate utf8_bin default NULL,
  `bigPic` varchar(255) collate utf8_bin default NULL,
  `shelvesTime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `salesNum` varchar(255) collate utf8_bin default NULL,
  `leftTime` int(255) default NULL,
  `cate_id` varchar(255) collate utf8_bin default NULL,
  `brand_id` varchar(255) collate utf8_bin default NULL,
  `state` int(11) default NULL,
  `isNew` varchar(255) collate utf8_bin default NULL,
  `isHot` varchar(255) collate utf8_bin default NULL,
  `commentCount` int(11) default NULL,
  `description` varchar(255) collate utf8_bin default NULL,
  `topic_id` varchar(255) collate utf8_bin default NULL,
  `isGift` varchar(255) collate utf8_bin default NULL,
  `pro_id` varchar(255) collate utf8_bin default NULL,
  `proCount` varchar(30) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `product` */

insert  into `product`(`id`,`name`,`pic`,`marketPrice`,`price`,`limitPrice`,`score`,`available`,`buyLimit`,`productProm`,`inventoryArea`,`bigPic`,`shelvesTime`,`salesNum`,`leftTime`,`cate_id`,`brand_id`,`state`,`isNew`,`isHot`,`commentCount`,`description`,`topic_id`,`isGift`,`pro_id`,`proCount`) values (1,'雅培金装a',NULL,'79','78','78',NULL,NULL,NULL,NULL,NULL,NULL,'2014-03-14 14:55:09','5',7200,'111','1234',NULL,NULL,NULL,124,NULL,NULL,NULL,'1200001',NULL),(2,'雅培银装a',NULL,'66','66','88',NULL,NULL,NULL,NULL,NULL,NULL,'2014-03-14 14:55:03','4',3600,'111','1234',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1200002',NULL),(3,'优选',NULL,'99','88','66',NULL,NULL,NULL,NULL,NULL,NULL,'2014-03-14 14:55:02','3',7200,'111','1234',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1200003',NULL);

/*Table structure for table `property` */

DROP TABLE IF EXISTS `property`;

CREATE TABLE `property` (
  `id` int(11) NOT NULL,
  `key` varchar(255) collate utf8_bin NOT NULL,
  `value` varchar(255) collate utf8_bin NOT NULL,
  `state` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `property` */

insert  into `property`(`id`,`key`,`value`,`state`) values (1,'颜色','红色',1),(2,'颜色','白色',1),(3,'大小','M',1),(4,'大小','L',1),(5,'大小','S',1),(6,'大小','XL',1),(7,'大小','XXL',1),(8,'颜色','黑色',1),(9,'颜色','绿色',1),(10,'颜色','黄色',1),(11,'颜色','蓝色',1);

/*Table structure for table `recommend` */

DROP TABLE IF EXISTS `recommend`;

CREATE TABLE `recommend` (
  `id` int(11) NOT NULL auto_increment,
  `keywords` varchar(255) character set gbk default NULL,
  `state` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `recommend` */

insert  into `recommend`(`id`,`keywords`,`state`) values (1,'adidas',NULL),(2,'361',NULL),(3,'nike',NULL);

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(100) collate utf8_bin default NULL,
  `pic` varchar(100) character set gbk default NULL,
  `state` int(11) default NULL COMMENT '内容是否有效:0无效、1有效',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `topic` */

insert  into `topic`(`id`,`title`,`pic`,`state`) values (1,'活动1','http://localhost/1.png',NULL),(2,'活动2','http://localhost/2.png',NULL),(3,'活动3','http://localhost/3.png',NULL);

/*Table structure for table `topicpro` */

DROP TABLE IF EXISTS `topicpro`;

CREATE TABLE `topicpro` (
  `id` int(11) NOT NULL auto_increment,
  `topic_id` varchar(100) character set gbk default NULL,
  `pro_id` varchar(40) character set gbk default NULL,
  `state` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `topicpro` */

insert  into `topicpro`(`id`,`topic_id`,`pro_id`,`state`) values (1,'1234','111',NULL),(2,'1234','222',NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) collate utf8_bin default NULL,
  `password` varchar(255) collate utf8_bin default NULL,
  `userid` varchar(255) collate utf8_bin default NULL,
  `bonus` int(11) default NULL COMMENT '会员等级',
  `level` varchar(255) collate utf8_bin default NULL,
  `usersession` varchar(255) collate utf8_bin default NULL,
  `ordercount` int(11) default NULL,
  `favoritescount` int(11) default NULL,
  `status` varchar(11) collate utf8_bin default NULL,
  `state` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`userid`,`bonus`,`level`,`usersession`,`ordercount`,`favoritescount`,`status`,`state`) values (1,'test','test','30505',3002,'金卡','MD5',20,12,'0',NULL),(2,'test1','test1',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL),(3,'test2','test2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'test3','test3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'test6','test6',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'test7','test7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'test8','test8',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'test9','test9',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'test10','test10',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'test11','test11',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'test13','test13',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'test12','test13',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'test14','test14',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'test15','test15',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'test16','test16',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,'test17','test17',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,'test18','test18',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,'test19','test19',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,'test20','test20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,'test21','test21',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,'test22','test22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(57,'test23','test23',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `version` */

DROP TABLE IF EXISTS `version`;

CREATE TABLE `version` (
  `id` int(11) NOT NULL auto_increment,
  `isnew` varchar(255) collate utf8_bin default NULL,
  `version` varchar(255) collate utf8_bin default NULL,
  `force` varchar(255) collate utf8_bin default NULL,
  `url` varchar(255) collate utf8_bin default NULL,
  `state` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `version` */

insert  into `version`(`id`,`isnew`,`version`,`force`,`url`,`state`) values (1,'true','1.1','false','http://',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
