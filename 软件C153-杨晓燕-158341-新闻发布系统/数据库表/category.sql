/*
 Navicat Premium Data Transfer

 Source Server         : yxy
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : news

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 22/11/2018 18:31:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` VALUES (1, '社会');
INSERT INTO `category` VALUES (2, '军事');
INSERT INTO `category` VALUES (3, '娱乐');
INSERT INTO `category` VALUES (4, '体育');
INSERT INTO `category` VALUES (5, '互联网');
INSERT INTO `category` VALUES (6, '财经');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
