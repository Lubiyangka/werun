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

 Date: 24/04/2023 19:39:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for notebook
-- ----------------------------
DROP TABLE IF EXISTS `notebook`;
CREATE TABLE `notebook`  (
  `notebook_title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `notebook_type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `notebook_state` int NOT NULL DEFAULT 0,
  `notebook_created_time` datetime(0) NOT NULL,
  `notebook_content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `notebook_description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`notebook_title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notebook
-- ----------------------------
INSERT INTO `notebook` VALUES ('C p', 'C', 1, '2023-04-18 21:29:00', 'tets0', 'description test 0', 'Fu yang');
INSERT INTO `notebook` VALUES ('C00 plussr', 'C', 0, '2023-04-18 23:08:38', 'content test 0', 'description test 0', 'Fu yang');
INSERT INTO `notebook` VALUES ('C000 plussr', 'C', 1, '2023-04-19 19:45:27', 'content test 0', 'description test 0', 'Fu yang');
INSERT INTO `notebook` VALUES ('Java程序设计', 'java', 0, '2023-04-08 00:31:31', 'content test changed', 'description test changed', 'Zhu wei');
INSERT INTO `notebook` VALUES ('title0', 'java', 0, '2023-04-08 08:32:11', 'content test', 'description test', 'Zhu wei');
INSERT INTO `notebook` VALUES ('面向对象', 'C', 1, '2023-04-23 11:19:31', 'content test 0', 'description test 0', 'Fu yang');

-- ----------------------------
-- Table structure for notebook_type
-- ----------------------------
DROP TABLE IF EXISTS `notebook_type`;
CREATE TABLE `notebook_type`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `notebook_type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notebook_type
-- ----------------------------
INSERT INTO `notebook_type` VALUES (1, 'C', 'Fu yang');
INSERT INTO `notebook_type` VALUES (2, 'go', 'Fu yang');
INSERT INTO `notebook_type` VALUES (3, 'Java', 'Zhu wei');
INSERT INTO `notebook_type` VALUES (4, 'HTML', 'Zhu wei');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('Fu yang', '456');
INSERT INTO `user` VALUES ('He linquan', '031214');
INSERT INTO `user` VALUES ('Zhu wei', '040225');

SET FOREIGN_KEY_CHECKS = 1;
