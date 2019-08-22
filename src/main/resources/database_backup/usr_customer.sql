/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : practice7_spring

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2019-07-09 21:52:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `usr_customer`
-- ----------------------------
DROP TABLE IF EXISTS `usr_customer`;
CREATE TABLE `usr_customer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `telephone` varchar(20) NOT NULL COMMENT '手机号码',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `trueName` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `gender` bit(2) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `region` varchar(255) DEFAULT NULL COMMENT '所在地区',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `postalCode` varchar(20) DEFAULT NULL COMMENT '邮编',
  `state` bit(2) NOT NULL COMMENT '用户状态',
  `activation` bigint(20) DEFAULT NULL COMMENT '激活码',
  `gmtCreate` datetime NOT NULL COMMENT '创建时间',
  `gmtModified` datetime NOT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usr_customer
-- ----------------------------
