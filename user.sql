/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : code

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-11-02 18:17:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `phone` varchar(255) DEFAULT '' COMMENT '电话',
  `email` varchar(255) DEFAULT '' COMMENT '邮件',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '13999999999', '123@123.com', '123456');
INSERT INTO `user` VALUES ('2', '王五', '13999999999', '123@123.com', '123456');
INSERT INTO `user` VALUES ('3', '李四', '13999999999', '123@123.com', '123456');
