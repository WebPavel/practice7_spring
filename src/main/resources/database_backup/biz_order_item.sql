/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : practice7_spring

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2019-08-18 23:44:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `biz_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `biz_order_item`;
CREATE TABLE `biz_order_item` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `productId` bigint(20) unsigned NOT NULL,
  `orderId` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `productId` (`productId`),
  KEY `orderId` (`orderId`),
  CONSTRAINT `biz_order_item_ibfk_2` FOREIGN KEY (`orderId`) REFERENCES `biz_order` (`id`),
  CONSTRAINT `biz_order_item_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `biz_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of biz_order_item
-- ----------------------------
