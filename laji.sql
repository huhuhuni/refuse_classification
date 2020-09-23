/*
SQLyog Ultimate v12.3.1 (32 bit)
MySQL - 5.7.21 : Database - laji
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`laji` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `laji`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `tel` varchar(56) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`name`,`password`,`email`,`tel`) values 
(1,'huni','3a3795bb61d5377545b4f345ff223e3d','huhuhuni@yeah.net',NULL);

/*Table structure for table `bulletin` */

DROP TABLE IF EXISTS `bulletin`;

CREATE TABLE `bulletin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `bulletin_type` varchar(64) DEFAULT NULL,
  `content` mediumtext,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `bulletin` */

insert  into `bulletin`(`id`,`title`,`bulletin_type`,`content`,`create_time`,`deleted`) values 
(1,'测试公告',NULL,'2017年3月18日 国务院办公厅关于转发国家发展改革委、住房城乡建设部生活垃圾分类制度实施方案的通知\r\n\r\n2017年10月18日 国家机关事务管理局、住房城乡建设部、发展改革委、中宣部、中直管理局印发了《关于推进党政机关等公共机构生活垃圾分类工作的通知》\r\n\r\n2017年12月20日 住房城乡建设部《关于加快推进部分重点城市生活垃圾分类工作的通知》\r\n\r\n二省级垃圾分类有关政策文件\r\n\r\n1、华南地区：广东省、广西自治区、海南省\r\n\r\n2017年3月29日 广东省住房和城乡建设厅关于印发《广东省农村生活垃圾分类处理指引》的通知\r\n\r\n2015年9月25日 《广东省城乡生活垃圾处理条例》\r\n\r\n2017年11月23日 广西壮族自治区人民政府办公厅关于转发自治区发展改革委、住房城乡建设厅《广西生活垃圾分类制度工作方案的通知》\r\n\r\n2017年8月18日 海南省法制办公室关于公布《海南省生活垃圾分类管理条例(送审稿)》征求意见的通告\r\n\r\n2、西南地区：四川省、重庆市、贵州省、云南省\r\n\r\n2017年11月3日 重庆市人民政府办公厅《关于印发重庆市生活垃圾分类制度实施方案的通知》\r\n\r\n2017年11月29日 四川省机关事务管理局《关于开展公共机构生活垃圾强制分类工作考核的通知》\r\n\r\n2017年11月27日 贵州省省人民政府办公厅关于转发省发展改革委省住房城乡建设厅《贵州省生活垃圾分类制度实施方案的通知》\r\n\r\n2017年3月14日 云南省住房和城乡建设厅关于转发住房城乡建设部《关于推广金华市农村生活垃圾分类和资源化利用经验的通知的通知》',NULL,''),
(2,'第二个公告',NULL,'第二个公告的内容',NULL,'\0'),
(3,'测试','政策','2017年3月18日 国务院办公厅关于转发国家发展改革委、住房城乡建设部生活垃圾分类制度实施方案的通知\r\n\r\n2017年10月18日 国家机关事务管理局、住房城乡建设部、发展改革委、中宣部、中直管理局印发了《关于推进党政机关等公共机构生活垃圾分类工作的通知》\r\n\r\n2017年12月20日 住房城乡建设部《关于加快推进部分重点城市生活垃圾分类工作的通知》\r\n\r\n二省级垃圾分类有关政策文件\r\n\r\n1、华南地区：广东省、广西自治区、海南省\r\n\r\n2017年3月29日 广东省住房和城乡建设厅关于印发《广东省农村生活垃圾分类处理指引》的通知\r\n\r\n2015年9月25日 《广东省城乡生活垃圾处理条例》\r\n\r\n2017年11月23日 广西壮族自治区人民政府办公厅关于转发自治区发展改革委、住房城乡建设厅《广西生活垃圾分类制度工作方案的通知》\r\n\r\n2017年8月18日 海南省法制办公室关于公布《海南省生活垃圾分类管理条例(送审稿)》征求意见的通告\r\n\r\n2、西南地区：四川省、重庆市、贵州省、云南省\r\n\r\n2017年11月3日 重庆市人民政府办公厅《关于印发重庆市生活垃圾分类制度实施方案的通知》\r\n\r\n2017年11月29日 四川省机关事务管理局《关于开展公共机构生活垃圾强制分类工作考核的通知》\r\n\r\n2017年11月27日 贵州省省人民政府办公厅关于转发省发展改革委省住房城乡建设厅《贵州省生活垃圾分类制度实施方案的通知》\r\n\r\n2017年3月14日 云南省住房和城乡建设厅关于转发住房城乡建设部《关于推广金华市农村生活垃圾分类和资源化利用经验的通知的通知》','2020-05-03 21:15:44','\0'),
(4,'测试公告','政策','2017年3月18日 国务院办公厅关于转发国家发展改革委、住房城乡建设部生活垃圾分类制度实施方案的通知\r\n\r\n2017年10月18日 国家机关事务管理局、住房城乡建设部、发展改革委、中宣部、中直管理局印发了《关于推进党政机关等公共机构生活垃圾分类工作的通知》\r\n\r\n2017年12月20日 住房城乡建设部《关于加快推进部分重点城市生活垃圾分类工作的通知》\r\n\r\n二省级垃圾分类有关政策文件\r\n\r\n1、华南地区：广东省、广西自治区、海南省\r\n\r\n2017年3月29日 广东省住房和城乡建设厅关于印发《广东省农村生活垃圾分类处理指引》的通知\r\n\r\n2015年9月25日 《广东省城乡生活垃圾处理条例》\r\n\r\n2017年11月23日 广西壮族自治区人民政府办公厅关于转发自治区发展改革委、住房城乡建设厅《广西生活垃圾分类制度工作方案的通知》\r\n\r\n2017年8月18日 海南省法制办公室关于公布《海南省生活垃圾分类管理条例(送审稿)》征求意见的通告\r\n\r\n2、西南地区：四川省、重庆市、贵州省、云南省\r\n\r\n2017年11月3日 重庆市人民政府办公厅《关于印发重庆市生活垃圾分类制度实施方案的通知》\r\n\r\n2017年11月29日 四川省机关事务管理局《关于开展公共机构生活垃圾强制分类工作考核的通知》\r\n\r\n2017年11月27日 贵州省省人民政府办公厅关于转发省发展改革委省住房城乡建设厅《贵州省生活垃圾分类制度实施方案的通知》\r\n\r\n2017年3月14日 云南省住房和城乡建设厅关于转发住房城乡建设部《关于推广金华市农村生活垃圾分类和资源化利用经验的通知的通知》','2020-05-03 21:26:15','\0'),
(5,'fa','社区新闻','2017年3月18日 国务院办公厅关于转发国家发展改革委、住房城乡建设部生活垃圾分类制度实施方案的通知\r\n\r\n2017年10月18日 国家机关事务管理局、住房城乡建设部、发展改革委、中宣部、中直管理局印发了《关于推进党政机关等公共机构生活垃圾分类工作的通知》\r\n\r\n2017年12月20日 住房城乡建设部《关于加快推进部分重点城市生活垃圾分类工作的通知》\r\n\r\n二省级垃圾分类有关政策文件\r\n\r\n1、华南地区：广东省、广西自治区、海南省\r\n\r\n2017年3月29日 广东省住房和城乡建设厅关于印发《广东省农村生活垃圾分类处理指引》的通知\r\n\r\n2015年9月25日 《广东省城乡生活垃圾处理条例》\r\n\r\n2017年11月23日 广西壮族自治区人民政府办公厅关于转发自治区发展改革委、住房城乡建设厅《广西生活垃圾分类制度工作方案的通知》\r\n\r\n2017年8月18日 海南省法制办公室关于公布《海南省生活垃圾分类管理条例(送审稿)》征求意见的通告\r\n\r\n2、西南地区：四川省、重庆市、贵州省、云南省\r\n\r\n2017年11月3日 重庆市人民政府办公厅《关于印发重庆市生活垃圾分类制度实施方案的通知》\r\n\r\n2017年11月29日 四川省机关事务管理局《关于开展公共机构生活垃圾强制分类工作考核的通知》\r\n\r\n2017年11月27日 贵州省省人民政府办公厅关于转发省发展改革委省住房城乡建设厅《贵州省生活垃圾分类制度实施方案的通知》\r\n\r\n2017年3月14日 云南省住房和城乡建设厅关于转发住房城乡建设部《关于推广金华市农村生活垃圾分类和资源化利用经验的通知的通知》','2020-05-03 22:22:37','\0'),
(6,'浅析 java多线程','其他','2017年3月18日 国务院办公厅关于转发国家发展改革委、住房城乡建设部生活垃圾分类制度实施方案的通知\r\n\r\n2017年10月18日 国家机关事务管理局、住房城乡建设部、发展改革委、中宣部、中直管理局印发了《关于推进党政机关等公共机构生活垃圾分类工作的通知》\r\n\r\n2017年12月20日 住房城乡建设部《关于加快推进部分重点城市生活垃圾分类工作的通知》\r\n\r\n二省级垃圾分类有关政策文件\r\n\r\n1、华南地区：广东省、广西自治区、海南省\r\n\r\n2017年3月29日 广东省住房和城乡建设厅关于印发《广东省农村生活垃圾分类处理指引》的通知\r\n\r\n2015年9月25日 《广东省城乡生活垃圾处理条例》\r\n\r\n2017年11月23日 广西壮族自治区人民政府办公厅关于转发自治区发展改革委、住房城乡建设厅《广西生活垃圾分类制度工作方案的通知》\r\n\r\n2017年8月18日 海南省法制办公室关于公布《海南省生活垃圾分类管理条例(送审稿)》征求意见的通告\r\n\r\n2、西南地区：四川省、重庆市、贵州省、云南省\r\n\r\n2017年11月3日 重庆市人民政府办公厅《关于印发重庆市生活垃圾分类制度实施方案的通知》\r\n\r\n2017年11月29日 四川省机关事务管理局《关于开展公共机构生活垃圾强制分类工作考核的通知》\r\n\r\n2017年11月27日 贵州省省人民政府办公厅关于转发省发展改革委省住房城乡建设厅《贵州省生活垃圾分类制度实施方案的通知》\r\n\r\n2017年3月14日 云南省住房和城乡建设厅关于转发住房城乡建设部《关于推广金华市农村生活垃圾分类和资源化利用经验的通知的通知》','2020-05-03 22:23:46','\0');

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `content` mediumtext,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`id`,`post_id`,`user_id`,`content`,`create_time`,`deleted`) values 
(1,NULL,3,'测试评论',NULL,'\0'),
(2,1,3,'测试评论',NULL,'\0'),
(3,1,3,'再次测试评论',NULL,'\0'),
(4,2,3,'我要评论你',NULL,'\0');

/*Table structure for table `order_order` */

DROP TABLE IF EXISTS `order_order`;

CREATE TABLE `order_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `o_type` varchar(128) DEFAULT NULL,
  `u_id` bigint(20) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `tel` varchar(128) DEFAULT NULL,
  `price` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `o_status` varchar(64) DEFAULT NULL COMMENT '状态',
  `remark` text COMMENT '备注',
  `service_time` datetime DEFAULT NULL COMMENT '订单服务时间',
  `undertake_u_id` bigint(20) DEFAULT NULL COMMENT '接单用户id',
  `deleted` bit(11) DEFAULT b'0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `user` (`u_id`),
  KEY `undertake_user` (`undertake_u_id`),
  CONSTRAINT `undertake_user` FOREIGN KEY (`undertake_u_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_order` */

/*Table structure for table `post` */

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `title` varchar(128) DEFAULT NULL,
  `content` mediumtext,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`post_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `post` */

insert  into `post`(`post_id`,`user_id`,`title`,`content`,`create_time`,`deleted`) values 
(1,3,'测试标题','测试内容','2020-05-02 20:52:26',''),
(2,3,'发个帖子','内容是就没有内容','2020-05-02 22:31:02','\0');

/*Table structure for table `rubbish` */

DROP TABLE IF EXISTS `rubbish`;

CREATE TABLE `rubbish` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(128) DEFAULT NULL COMMENT '名称',
  `r_type` varchar(64) DEFAULT NULL COMMENT '类别',
  `push` varchar(128) DEFAULT NULL COMMENT '投放要求',
  `views` bigint(24) DEFAULT '0' COMMENT '总查询次数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `deleted` bit(1) DEFAULT b'0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `rubbish` */

insert  into `rubbish`(`id`,`name`,`r_type`,`push`,`views`,`create_time`,`deleted`) values 
(1,'纸制品','干垃圾',NULL,0,NULL,'\0'),
(2,'纸巾','干垃圾',NULL,0,NULL,'\0'),
(3,'12','12','12',0,NULL,''),
(4,'塑料包装袋','可回收垃圾','',0,'2020-05-04 16:31:36','\0'),
(5,'手机壳','可回收垃圾','',0,'2020-05-04 20:00:00','');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL COMMENT '0-男，1-女',
  `email` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(11) DEFAULT b'0' COMMENT '0-未删除，1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`sex`,`email`,`create_time`,`deleted`) values 
(3,'huni','123',0,'15842819856@163.com','2020-04-27 21:08:09','\0\0'),
(4,'jack','123',0,'huhuhuni@yeah.net','2020-05-01 21:02:18','\0\0'),
(5,'22','22',1,'fsdgs@11.com',NULL,'\0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
