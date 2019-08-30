/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : practice7_spring

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2019-08-24 01:58:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `usr_manager`
-- ----------------------------
DROP TABLE IF EXISTS `usr_manager`;
CREATE TABLE `usr_manager` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `gender` bit(2) DEFAULT NULL,
  `status` bit(2) NOT NULL,
  `gmtCreate` datetime NOT NULL,
  `gmtModified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usr_manager
-- ----------------------------
INSERT INTO `usr_manager` VALUES ('1', 'admin', 'admin', '13237141681', 'admin@gwwind.cn', '', '', '2019-08-24 01:57:21', '2019-08-24 01:57:24');
