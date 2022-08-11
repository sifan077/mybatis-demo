/*
Navicat MySQL Data Transfer

Source Server         : hao
Source Server Version : 80026
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 80026
File Encoding         : 65001

Date: 2022-08-11 21:46:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'mybatis学习',
  `name` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '18');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cid` int NOT NULL AUTO_INCREMENT COMMENT 'mybatis学习',
  `cname` varchar(255) DEFAULT NULL,
  `cpassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', 'jack', '124124124');
INSERT INTO `customer` VALUES ('2', 'jerry', '124124');
INSERT INTO `customer` VALUES ('3', 'kome', '4135');
INSERT INTO `customer` VALUES ('4', 'ppaw', '24124124');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int NOT NULL AUTO_INCREMENT COMMENT 'mybatis学习',
  `oname` varchar(255) DEFAULT NULL,
  `cid` int DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `orders_ibfk_1` (`cid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`) ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '电脑', '1');
INSERT INTO `orders` VALUES ('2', '平板', '1');
INSERT INTO `orders` VALUES ('3', '手机', '2');
INSERT INTO `orders` VALUES ('4', '耳机', '3');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'mybatis学习',
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'Tom', '123456');
INSERT INTO `student` VALUES ('2', 'Jerry', '123777');
INSERT INTO `student` VALUES ('3', 'Black', '1541324');
INSERT INTO `student` VALUES ('4', 'Kom1', '1234567');
INSERT INTO `student` VALUES ('5', 'Test1', '123456');
INSERT INTO `student` VALUES ('6', 'Test2', '123456');
INSERT INTO `student` VALUES ('7', 'Test3', '123456');
INSERT INTO `student` VALUES ('8', 'Test4', '123456');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'mybatis学习',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '思凡', '123456');
INSERT INTO `user` VALUES ('2', '神荼', '81327468');
INSERT INTO `user` VALUES ('3', '苦涩', '87315468');
INSERT INTO `user` VALUES ('7', '张三', '123456');
