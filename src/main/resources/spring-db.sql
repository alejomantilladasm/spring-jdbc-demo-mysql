/*
 Navicat Premium Data Transfer

 Source Server         : MySql - Localhost
 Source Server Type    : MySQL
 Source Server Version : 50635
 Source Host           : localhost
 Source Database       : spring-db

 Target Server Type    : MySQL
 Target Server Version : 50635
 File Encoding         : utf-8

 Date: 08/14/2018 11:40:17 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `organization`
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(50) NOT NULL,
  `year_of_incorporation` int(11) NOT NULL,
  `postal_code` varchar(10) NOT NULL,
  `employee_count` int(11) NOT NULL,
  `slogan` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `organization`
-- ----------------------------
BEGIN;
INSERT INTO `organization` VALUES ('1', 'BMW', '1929', '45456', '10000', 'BMW Slogan'), ('2', 'Amazon', '1994', '75757', '20000', 'Amazon Slogan');
COMMIT;

