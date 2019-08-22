/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : practice7_spring

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2019-08-15 01:01:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pub_category`
-- ----------------------------
DROP TABLE IF EXISTS `pub_category`;
CREATE TABLE `pub_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `isHot` tinyint(3) unsigned NOT NULL,
  `status` int(11) NOT NULL,
  `sortNumber` int(11) NOT NULL,
  `gmtCreate` datetime NOT NULL,
  `gmtModified` datetime NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pub_category
-- ----------------------------
INSERT INTO `pub_category` VALUES ('1', '女装男装', '0', '1', '1', '2019-08-14 18:59:35', '2019-08-14 18:59:38', null);
INSERT INTO `pub_category` VALUES ('2', '鞋靴箱包', '0', '1', '2', '2019-08-14 19:00:22', '2019-08-14 19:00:25', null);
INSERT INTO `pub_category` VALUES ('3', '运动户外', '0', '1', '1', '2019-08-14 19:00:43', '2019-08-14 19:00:46', null);
INSERT INTO `pub_category` VALUES ('4', '珠宝配饰', '0', '1', '3', '2019-08-14 19:01:04', '2019-08-14 19:01:08', null);
INSERT INTO `pub_category` VALUES ('5', '手机数码', '0', '1', '1', '2019-08-14 19:01:36', '2019-08-14 19:01:39', null);
INSERT INTO `pub_category` VALUES ('6', '家电办公', '0', '1', '2', '2019-08-14 19:02:06', '2019-08-14 19:02:09', null);
INSERT INTO `pub_category` VALUES ('7', '护肤彩妆', '0', '1', '2', '2019-08-14 19:02:38', '2019-08-14 19:02:42', null);
