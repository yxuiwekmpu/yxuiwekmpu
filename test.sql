/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2018-03-05 21:39:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for logrole
-- ----------------------------
DROP TABLE IF EXISTS `logrole`;
CREATE TABLE `logrole` (
  `logRoleId` int(11) NOT NULL AUTO_INCREMENT,
  `logRoleName` varchar(50) DEFAULT NULL,
  `logRoleRight` int(11) DEFAULT NULL,
  `r1` varchar(255) DEFAULT NULL,
  `r2` varchar(255) DEFAULT NULL,
  `r3` varchar(255) DEFAULT NULL,
  `r4` varchar(255) DEFAULT NULL,
  `r5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`logRoleId`),
  UNIQUE KEY `logRoleName` (`logRoleName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logrole
-- ----------------------------
INSERT INTO `logrole` VALUES ('1', 'admin', '3', null, null, null, null, null);
INSERT INTO `logrole` VALUES ('2', 'admin1', '1', null, null, null, null, null);
INSERT INTO `logrole` VALUES ('3', '学生', '0', '', '', '', '', '');
INSERT INTO `logrole` VALUES ('4', 'aaa', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `nickName` varchar(50) DEFAULT NULL,
  `isInOffice` int(11) DEFAULT NULL,
  `allowedIP` varchar(255) DEFAULT NULL,
  `logRoleId` int(11) DEFAULT NULL,
  `r1` varchar(255) DEFAULT NULL,
  `r2` varchar(255) DEFAULT NULL,
  `r3` varchar(255) DEFAULT NULL,
  `r4` varchar(255) DEFAULT NULL,
  `r5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `account` (`account`),
  UNIQUE KEY `userName` (`userName`),
  KEY `FK36EBCB9BF1C03B` (`logRoleId`),
  CONSTRAINT `FK5r34egmp5914vtonecn26n7rh` FOREIGN KEY (`logRoleId`) REFERENCES `logrole` (`logRoleId`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`logRoleId`) REFERENCES `logrole` (`logRoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', 'admin', null, '0', '111.116.17', '1', null, null, null, null, null);
INSERT INTO `user` VALUES ('2', 'klguang1', 'klguang1', 'hehe1', null, '1', null, '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('6', null, null, '王书广', null, '1', '111.116.14', '4', null, null, null, null, null);
INSERT INTO `user` VALUES ('7', null, null, '君君', null, '0', '111.116.14', '4', null, null, null, null, null);
INSERT INTO `user` VALUES ('8', null, null, '你好', null, '1', '111.116.14', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('9', null, null, '阿三地方', null, '0', '111.116.14', '4', null, null, null, null, null);
INSERT INTO `user` VALUES ('10', null, null, '111', null, '0', '111.116.14', '4', null, null, null, null, null);
INSERT INTO `user` VALUES ('12', null, null, 'asdfsd', null, '0', 'asdf', '4', null, null, null, null, null);
INSERT INTO `user` VALUES ('13', null, null, 'sadf', null, '0', 'asdf', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('14', null, null, 'sdf', null, '0', 'asdf', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('15', null, null, 'asd', null, '0', 'asd', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('16', null, null, 'df', null, '0', 'asdf', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('17', null, null, 'asdfasdfasd', null, '0', 'asdf', '4', null, null, null, null, null);
INSERT INTO `user` VALUES ('18', null, null, 'sdfgasdfg', null, '0', 'asdf', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('19', null, null, 'asdfasdfasdf', null, '0', 'asdf', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('20', null, null, 'dsafg', null, '0', 'asdf', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('21', null, null, 'asdfasdf', null, '0', 'asdfasdf', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('25', null, null, 'asfd', null, '0', 'asdf', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('26', null, null, 'safd', null, '0', 'asdf', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('27', null, null, '你好asdf', null, '0', '111.116.14', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('28', null, null, '你好sdfg asf', null, '0', '111.116.14', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('30', null, null, 'aaaaa', null, '0', 'fffffffff', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('31', null, null, 'BBBBB', null, '0', 'fffffffff', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('32', null, null, '阿三', null, '0', '阿斯顿', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('33', null, null, '啊2222', null, '0', '啊22', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('34', null, null, '啊速度', null, '0', '啊 非非', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('45', 'transaction', null, null, null, '0', null, '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('51', 'kkkkklll', null, 'kkkkkll', null, '0', null, '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('56', 'GG-A-1', null, 'gg-n-1', null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('57', 'GG-A-2', null, 'gg-n-2', null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('58', null, null, null, null, null, null, '4', null, null, null, null, null);
INSERT INTO `user` VALUES ('60', 'GGGG', null, null, null, null, null, null, null, null, null, null, null);
