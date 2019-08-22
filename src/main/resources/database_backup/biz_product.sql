/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : practice7_spring

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2019-08-15 01:02:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `biz_product`
-- ----------------------------
DROP TABLE IF EXISTS `biz_product`;
CREATE TABLE `biz_product` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `marketPrice` decimal(10,2) NOT NULL COMMENT '商场价',
  `sellingPrice` decimal(10,2) NOT NULL COMMENT '划线价',
  `discount` decimal(3,2) NOT NULL,
  `description` varchar(500) NOT NULL,
  `imgthumb` varchar(255) NOT NULL COMMENT '商品图片',
  `stock` int(11) NOT NULL COMMENT '库存',
  `sku` varchar(255) NOT NULL COMMENT '库存单位（如件、箱）',
  `serialNumber` varchar(255) NOT NULL COMMENT '商品编号',
  `upc` varchar(255) NOT NULL COMMENT '条形码',
  `brand` varchar(255) NOT NULL,
  `madeIn` varchar(255) NOT NULL COMMENT '产地',
  `shelfLife` date NOT NULL COMMENT '保质期',
  `weight` decimal(10,2) NOT NULL COMMENT '重量',
  `isHot` tinyint(4) NOT NULL COMMENT '是否热门',
  `status` int(11) NOT NULL,
  `sortNumber` int(11) NOT NULL,
  `gmtCreate` datetime NOT NULL,
  `gmtModified` datetime NOT NULL,
  `subcategoryId` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `subcategoryId` (`subcategoryId`),
  CONSTRAINT `biz_product_ibfk_1` FOREIGN KEY (`subcategoryId`) REFERENCES `pub_subcategory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of biz_product
-- ----------------------------
