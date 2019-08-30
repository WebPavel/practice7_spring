/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : practice7_spring

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2019-08-15 01:01:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pub_subcategory`
-- ----------------------------
DROP TABLE IF EXISTS `pub_subcategory`;
CREATE TABLE `pub_subcategory` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `isHot` tinyint(3) unsigned NOT NULL,
  `status` int(11) NOT NULL,
  `sortNumber` int(11) NOT NULL,
  `gmtCreate` datetime NOT NULL,
  `gmtModified` datetime NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `categoryId` bigint(20) unsigned,
  PRIMARY KEY (`id`),
  KEY `categoryId` (`categoryId`),
  CONSTRAINT `pub_subcategory_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `pub_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pub_subcategory
-- ----------------------------
INSERT INTO `pub_subcategory` VALUES ('1', '潮流女装', '0', '1', '1', '2019-08-15 00:41:56', '2019-08-15 00:41:58', null, '1');
INSERT INTO `pub_subcategory` VALUES ('2', '初冬羽绒', '0', '1', '2', '2019-08-15 00:45:10', '2019-08-15 00:45:14', null, '1');
INSERT INTO `pub_subcategory` VALUES ('3', '精选男装', '1', '1', '1', '2019-08-15 00:45:54', '2019-08-15 00:45:56', null, '1');
INSERT INTO `pub_subcategory` VALUES ('4', '冬季外套', '1', '1', '1', '2019-08-15 00:46:42', '2019-08-15 00:46:47', null, '1');
INSERT INTO `pub_subcategory` VALUES ('5', '温暖毛衣', '1', '1', '1', '2019-08-15 00:47:14', '2019-08-15 00:47:17', null, '1');
INSERT INTO `pub_subcategory` VALUES ('6', '女鞋', '1', '1', '1', '2019-08-15 00:47:37', '2019-08-15 00:47:40', null, '2');
INSERT INTO `pub_subcategory` VALUES ('7', '短靴', '1', '1', '1', '2019-08-15 00:48:08', '2019-08-15 00:48:11', null, '2');
INSERT INTO `pub_subcategory` VALUES ('8', '男鞋', '1', '1', '1', '2019-08-15 00:48:35', '2019-08-15 00:48:38', null, '2');
INSERT INTO `pub_subcategory` VALUES ('9', '女包', '1', '1', '1', '2019-08-15 00:48:56', '2019-08-15 00:48:59', null, '2');
INSERT INTO `pub_subcategory` VALUES ('10', '男包', '0', '1', '2', '2019-08-15 00:49:20', '2019-08-15 00:49:23', null, '2');
INSERT INTO `pub_subcategory` VALUES ('11', '运动鞋', '1', '1', '1', '2019-08-15 00:50:03', '2019-08-15 00:50:07', null, '3');
INSERT INTO `pub_subcategory` VALUES ('12', '运动服', '0', '1', '3', '2019-08-15 00:50:44', '2019-08-15 00:50:47', null, '3');
INSERT INTO `pub_subcategory` VALUES ('13', '户外运动', '1', '1', '2', '2019-08-15 00:51:19', '2019-08-15 00:51:22', null, '3');
INSERT INTO `pub_subcategory` VALUES ('14', '健身装备', '1', '1', '1', '2019-08-15 00:51:45', '2019-08-15 00:51:48', null, '3');
INSERT INTO `pub_subcategory` VALUES ('15', '骑行装备', '0', '1', '2', '2019-08-15 00:52:17', '2019-08-15 00:52:20', null, '3');
INSERT INTO `pub_subcategory` VALUES ('16', '珠宝首饰', '0', '1', '2', '2019-08-15 00:52:46', '2019-08-15 00:52:49', null, '4');
INSERT INTO `pub_subcategory` VALUES ('17', '时尚饰品', '1', '1', '2', '2019-08-15 00:53:15', '2019-08-15 00:53:18', null, '4');
INSERT INTO `pub_subcategory` VALUES ('18', '品牌手表', '0', '1', '3', '2019-08-15 00:53:52', '2019-08-15 00:53:54', null, '4');
INSERT INTO `pub_subcategory` VALUES ('19', '眼镜配饰', '0', '1', '4', '2019-08-15 00:54:24', '2019-08-15 00:54:27', null, '4');
INSERT INTO `pub_subcategory` VALUES ('20', '手机', '1', '1', '1', '2019-08-15 00:54:45', '2019-08-15 00:54:47', null, '5');
INSERT INTO `pub_subcategory` VALUES ('21', '平板', '1', '1', '1', '2019-08-15 00:55:10', '2019-08-15 00:55:14', null, '5');
INSERT INTO `pub_subcategory` VALUES ('22', '电脑', '1', '1', '1', '2019-08-15 00:55:32', '2019-08-15 00:55:34', null, '5');
INSERT INTO `pub_subcategory` VALUES ('23', '相机', '0', '1', '2', '2019-08-15 00:56:31', '2019-08-15 00:56:33', null, '5');
INSERT INTO `pub_subcategory` VALUES ('24', '厨房电器', '0', '1', '3', '2019-08-15 00:57:08', '2019-08-15 00:57:11', null, '6');
INSERT INTO `pub_subcategory` VALUES ('25', '生活电器', '1', '1', '2', '2019-08-15 00:57:34', '2019-08-15 00:57:37', null, '6');
INSERT INTO `pub_subcategory` VALUES ('26', '办公耗材', '0', '1', '3', '2019-08-15 00:58:04', '2019-08-15 00:58:08', null, '6');
INSERT INTO `pub_subcategory` VALUES ('27', '美容护肤', '1', '1', '2', '2019-08-15 00:58:35', '2019-08-15 00:58:39', null, '7');
INSERT INTO `pub_subcategory` VALUES ('28', '强效保养', '0', '1', '3', '2019-08-15 00:59:24', '2019-08-15 00:59:27', null, '7');
INSERT INTO `pub_subcategory` VALUES ('29', '超值彩妆', '1', '1', '1', '2019-08-15 00:59:52', '2019-08-15 00:59:55', null, '7');
INSERT INTO `pub_subcategory` VALUES ('30', '换季护肤', '1', '1', '2', '2019-08-15 01:00:20', '2019-08-15 01:00:24', null, '7');
