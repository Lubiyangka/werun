/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : ssm_db

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 13/04/2023 20:17:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for notebook
-- ----------------------------
DROP TABLE IF EXISTS `notebook`;
CREATE TABLE `notebook`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `notebook_title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `notebook_type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `notebook_state` int NOT NULL DEFAULT 0,
  `notebook_created_time` datetime(0) NULL DEFAULT NULL,
  `notebook_content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `notebook_description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notebook
-- ----------------------------
INSERT INTO `notebook` VALUES (1, 'Java程序设计', 'java', 0, '2023-04-08 00:31:31', 'content test changed', 'description test changed');
INSERT INTO `notebook` VALUES (2, 'title0', 'java', 1, '2023-04-08 08:32:11', 'content test', 'description test');
INSERT INTO `notebook` VALUES (3, 'C++ Primer Plus', 'C++', 0, '2023-04-08 08:36:09', 'content test', 'description test');
INSERT INTO `notebook` VALUES (4, 'Spring Data Jpa', 'java', 1, '2023-04-08 12:38:58', 'content test 0', 'description test 0');

-- ----------------------------
-- Table structure for notebook_type
-- ----------------------------
DROP TABLE IF EXISTS `notebook_type`;
CREATE TABLE `notebook_type`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `notebook_type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notebook_type
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `user_password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('test123', '786756');
INSERT INTO `user` VALUES ('test124', '030404');

SET FOREIGN_KEY_CHECKS = 1;
