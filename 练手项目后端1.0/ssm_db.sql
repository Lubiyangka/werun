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

 Date: 19/04/2023 21:52:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for notebook
-- ----------------------------
DROP TABLE IF EXISTS `notebook`;
CREATE TABLE `notebook`  (
  `notebook_title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `notebook_type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `notebook_state` int NOT NULL DEFAULT 0,
  `notebook_created_time` datetime(0) NOT NULL,
  `notebook_content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `notebook_description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`notebook_title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notebook
-- ----------------------------
INSERT INTO `notebook` VALUES ('C p', 'C', 1, '2023-04-18 21:29:00', 'tets0', 'description test 0', 'Fu yang');
INSERT INTO `notebook` VALUES ('C00 plussr', 'C', 0, '2023-04-18 23:08:38', 'content test 0', 'description test 0', 'Fu yang');
INSERT INTO `notebook` VALUES ('C000 plussr', 'C', 1, '2023-04-19 19:45:27', 'content test 0', 'description test 0', 'Fu yang');
INSERT INTO `notebook` VALUES ('Java程序设计', 'java', 0, '2023-04-08 00:31:31', 'content test changed', 'description test changed', '');
INSERT INTO `notebook` VALUES ('title0', 'java', 0, '2023-04-08 08:32:11', 'content test', 'description test', '');

-- ----------------------------
-- Table structure for notebook_type
-- ----------------------------
DROP TABLE IF EXISTS `notebook_type`;
CREATE TABLE `notebook_type`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `notebook_type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notebook_type
-- ----------------------------
INSERT INTO `notebook_type` VALUES (1, 'Java', 'Fu yang');
INSERT INTO `notebook_type` VALUES (2, 'Java', 'Fu yang');
INSERT INTO `notebook_type` VALUES (3, 'C', 'Fu yang');
INSERT INTO `notebook_type` VALUES (4, 'Go', 'Fu yang');
INSERT INTO `notebook_type` VALUES (5, 'Go', 'Fu yang');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('Fu yang', '456');
INSERT INTO `user` VALUES ('Jin le', '234');
INSERT INTO `user` VALUES ('John Six', '123');
INSERT INTO `user` VALUES ('Lu yang', '234');
INSERT INTO `user` VALUES ('Sun wen', '234');
INSERT INTO `user` VALUES ('test123', '786756');
INSERT INTO `user` VALUES ('test124', '030404');
INSERT INTO `user` VALUES ('Zhu ', '250');
INSERT INTO `user` VALUES ('Zhu Shengfang', '250');

SET FOREIGN_KEY_CHECKS = 1;
