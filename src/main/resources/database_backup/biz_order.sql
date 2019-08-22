/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : practice7_spring

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2019-08-19 20:15:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `biz_order`
-- ----------------------------
DROP TABLE IF EXISTS `biz_order`;
CREATE TABLE `biz_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gmtCreate` datetime NOT NULL,
  `address` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `consignee` varchar(255) NOT NULL COMMENT '收货人',
  `weight` decimal(10,2) NOT NULL,
  `freight` decimal(10,2) NOT NULL COMMENT '运费',
  `price` decimal(10,2) NOT NULL,
  `sn` varchar(255) NOT NULL,
  `gmtPayment` datetime DEFAULT NULL,
  `status` int(11) NOT NULL,
  `gmtModified` datetime NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `customerId` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `biz_order_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `usr_customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of biz_order
-- ----------------------------
INSERT INTO `biz_order` VALUES ('1', '2019-08-19 01:24:16', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.45', '0.00', '4001.80', '420a5d36cf27403d8aabb3499022f758', null, '1', '2019-08-19 01:24:16', null, '6');
INSERT INTO `biz_order` VALUES ('2', '2019-08-19 01:46:02', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.45', '0.00', '4001.80', 'd6fee8d5e5dd4e6f8f112aee5f54fece', null, '1', '2019-08-19 01:46:02', null, '6');
INSERT INTO `biz_order` VALUES ('3', '2019-08-19 01:47:46', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.45', '0.00', '4001.80', '05b612fae31744bc8f392be4e481ebd4', null, '1', '2019-08-19 01:47:46', null, '6');
INSERT INTO `biz_order` VALUES ('4', '2019-08-19 02:21:25', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.45', '0.00', '4001.80', '95cecb5ef2624235a8fc8cd20f21ecd3', null, '1', '2019-08-19 02:21:25', null, '6');
INSERT INTO `biz_order` VALUES ('5', '2019-08-19 02:24:03', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.45', '0.00', '4001.80', '002b86a3c7bc4552a436ef987adec881', null, '1', '2019-08-19 02:24:03', null, '6');
INSERT INTO `biz_order` VALUES ('6', '2019-08-19 02:28:15', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.45', '0.00', '4001.80', '60cd3ffd0c3c46da87b4b4024e4b1a57', null, '1', '2019-08-19 02:28:15', null, '6');
INSERT INTO `biz_order` VALUES ('7', '2019-08-19 02:33:00', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.45', '0.00', '4001.80', 'f488fdb28138487d94da7a4020450a7c', null, '1', '2019-08-19 02:33:00', null, '6');
INSERT INTO `biz_order` VALUES ('8', '2019-08-19 02:36:44', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.00', '0.00', '3998.00', 'c5fe0c9440744d6ba81645b8d8c315aa', null, '1', '2019-08-19 02:36:44', null, '6');
INSERT INTO `biz_order` VALUES ('9', '2019-08-19 02:44:47', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.00', '0.00', '3998.00', 'dab4ee4bcec947a88648454158b987ae', null, '1', '2019-08-19 02:44:47', null, '6');
INSERT INTO `biz_order` VALUES ('10', '2019-08-19 02:46:58', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.00', '0.00', '3998.00', '2c6c4529eb1d4a78a9829c7162d17b8a', null, '1', '2019-08-19 02:46:58', null, '6');
INSERT INTO `biz_order` VALUES ('11', '2019-08-19 02:47:38', '广州市天河区凌塘村下街南21号', '13237141681', '', '0.45', '0.00', '1.90', '4a930e94862d4fe0a2a73481beb1314a', null, '1', '2019-08-19 02:47:38', null, '6');
INSERT INTO `biz_order` VALUES ('12', '2019-08-19 02:48:09', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.45', '0.00', '4001.80', '4ac4a2a267324e52bb8da18396c98895', null, '1', '2019-08-19 02:48:09', null, '6');
INSERT INTO `biz_order` VALUES ('13', '2019-08-19 02:48:17', '广州市天河区凌塘村下街南21号', '13237141681', '', '0.00', '0.00', '0.00', 'ad8e15f3f6f149a29a5940a039fadddd', null, '1', '2019-08-19 02:48:17', null, '6');
INSERT INTO `biz_order` VALUES ('14', '2019-08-19 02:48:38', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.45', '0.00', '4001.80', 'd630bc4ae4324ab7b0aece245466f2bb', null, '1', '2019-08-19 02:48:38', null, '6');
INSERT INTO `biz_order` VALUES ('15', '2019-08-19 02:50:52', '广州市天河区凌塘村下街南21号', '13237141681', '', '2320.35', '0.00', '8001.70', '0d417377f4fe4302925fbe6ad7a03fb4', null, '1', '2019-08-19 02:50:52', null, '6');
INSERT INTO `biz_order` VALUES ('16', '2019-08-19 19:10:37', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.45', '0.00', '4001.80', '561f1256bc88404bb2fcc7e84f40af86', null, '1', '2019-08-19 19:10:37', null, '6');
INSERT INTO `biz_order` VALUES ('17', '2019-08-19 19:54:52', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.00', '0.00', '3998.00', 'd823af6d9b514bfca4ae7d796ac758d0', null, '1', '2019-08-19 19:54:52', null, '6');
INSERT INTO `biz_order` VALUES ('18', '2019-08-19 19:59:34', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.00', '0.00', '3998.00', 'bbb000e722d346469aa5ce7031b992a2', null, '1', '2019-08-19 19:59:34', null, '6');
INSERT INTO `biz_order` VALUES ('19', '2019-08-19 20:02:54', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.00', '0.00', '3998.00', 'c8417ab204204417a6945e2e17437009', null, '1', '2019-08-19 20:02:54', null, '6');
INSERT INTO `biz_order` VALUES ('20', '2019-08-19 20:12:19', '广州市天河区凌塘村下街南21号', '13237141681', '', '2319.00', '0.00', '3998.00', '514e780a8795473fa14fb5422df8c3b1', null, '1', '2019-08-19 20:12:19', null, '6');
