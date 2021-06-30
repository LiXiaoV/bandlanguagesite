/*
 Navicat Premium Data Transfer

 Source Server         : oldComputer
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 192.168.88.116:33306
 Source Schema         : bandlanguagesite

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 26/06/2021 21:32:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bls_dept
-- ----------------------------
DROP TABLE IF EXISTS `bls_dept`;
CREATE TABLE `bls_dept` (
  `dept_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '场景区id',
  `parent_id` bigint NOT NULL COMMENT '父场景区id，没有统一为0',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '场景区名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '场景的相关描述',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '场景区图标',
  `band_obj_id` bigint NOT NULL DEFAULT '0' COMMENT '场景区对应的帮区bandObjId',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态 0：禁用，1：正常',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept` VALUES (1, 0, '机构管理', '机构管理场景区，负责帮区机构管理部分的工作', NULL, 0, '2021-05-21 14:45:30', 1);
INSERT INTO `bls_dept` VALUES (2, 0, '功能集成', '功能集成场景区，负责帮区功能集成帮语的工作', NULL, 0, '2021-05-21 14:48:39', 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_dept_node
-- ----------------------------
DROP TABLE IF EXISTS `bls_dept_node`;
CREATE TABLE `bls_dept_node` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dept_id` bigint NOT NULL COMMENT '场景区id',
  `node_id` bigint NOT NULL COMMENT '节点id',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态  0：禁用  1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_node
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept_node` VALUES (1, 1, 1, 1);
INSERT INTO `bls_dept_node` VALUES (2, 1, 2, 1);
INSERT INTO `bls_dept_node` VALUES (3, 1, 3, 1);
INSERT INTO `bls_dept_node` VALUES (4, 1, 4, 1);
INSERT INTO `bls_dept_node` VALUES (5, 1, 5, 1);
INSERT INTO `bls_dept_node` VALUES (6, 1, 6, 1);
INSERT INTO `bls_dept_node` VALUES (7, 1, 7, 1);
INSERT INTO `bls_dept_node` VALUES (8, 1, 8, 1);
INSERT INTO `bls_dept_node` VALUES (9, 1, 9, 1);
INSERT INTO `bls_dept_node` VALUES (10, 1, 10, 1);
INSERT INTO `bls_dept_node` VALUES (11, 1, 11, 1);
INSERT INTO `bls_dept_node` VALUES (12, 1, 12, 1);
INSERT INTO `bls_dept_node` VALUES (13, 1, 13, 1);
INSERT INTO `bls_dept_node` VALUES (14, 1, 14, 1);
INSERT INTO `bls_dept_node` VALUES (15, 1, 15, 1);
INSERT INTO `bls_dept_node` VALUES (16, 1, 16, 1);
INSERT INTO `bls_dept_node` VALUES (17, 1, 17, 1);
INSERT INTO `bls_dept_node` VALUES (18, 1, 18, 1);
INSERT INTO `bls_dept_node` VALUES (19, 1, 19, 1);
INSERT INTO `bls_dept_node` VALUES (20, 1, 20, 1);
INSERT INTO `bls_dept_node` VALUES (21, 1, 21, 1);
INSERT INTO `bls_dept_node` VALUES (22, 1, 22, 1);
INSERT INTO `bls_dept_node` VALUES (23, 1, 23, 1);
INSERT INTO `bls_dept_node` VALUES (24, 1, 24, 1);
INSERT INTO `bls_dept_node` VALUES (25, 1, 25, 1);
INSERT INTO `bls_dept_node` VALUES (26, 1, 26, 1);
INSERT INTO `bls_dept_node` VALUES (27, 1, 27, 1);
INSERT INTO `bls_dept_node` VALUES (28, 1, 28, 1);
INSERT INTO `bls_dept_node` VALUES (29, 1, 29, 1);
INSERT INTO `bls_dept_node` VALUES (30, 1, 30, 1);
INSERT INTO `bls_dept_node` VALUES (31, 1, 31, 1);
INSERT INTO `bls_dept_node` VALUES (32, 1, 32, 1);
INSERT INTO `bls_dept_node` VALUES (33, 1, 33, 1);
INSERT INTO `bls_dept_node` VALUES (34, 1, 34, 1);
INSERT INTO `bls_dept_node` VALUES (35, 1, 35, 1);
INSERT INTO `bls_dept_node` VALUES (36, 1, 36, 1);
INSERT INTO `bls_dept_node` VALUES (37, 1, 37, 1);
INSERT INTO `bls_dept_node` VALUES (38, 1, 38, 1);
INSERT INTO `bls_dept_node` VALUES (39, 1, 39, 1);
INSERT INTO `bls_dept_node` VALUES (40, 1, 40, 1);
INSERT INTO `bls_dept_node` VALUES (41, 1, 41, 1);
INSERT INTO `bls_dept_node` VALUES (42, 1, 42, 1);
INSERT INTO `bls_dept_node` VALUES (43, 1, 43, 1);
INSERT INTO `bls_dept_node` VALUES (44, 1, 44, 1);
INSERT INTO `bls_dept_node` VALUES (45, 1, 45, 1);
INSERT INTO `bls_dept_node` VALUES (46, 1, 46, 1);
INSERT INTO `bls_dept_node` VALUES (47, 1, 47, 1);
INSERT INTO `bls_dept_node` VALUES (48, 1, 48, 1);
INSERT INTO `bls_dept_node` VALUES (49, 1, 49, 1);
INSERT INTO `bls_dept_node` VALUES (50, 1, 50, 1);
INSERT INTO `bls_dept_node` VALUES (51, 1, 51, 1);
INSERT INTO `bls_dept_node` VALUES (52, 1, 52, 1);
INSERT INTO `bls_dept_node` VALUES (53, 1, 53, 1);
INSERT INTO `bls_dept_node` VALUES (54, 1, 54, 1);
INSERT INTO `bls_dept_node` VALUES (55, 1, 55, 1);
INSERT INTO `bls_dept_node` VALUES (56, 1, 56, 1);
INSERT INTO `bls_dept_node` VALUES (57, 1, 57, 1);
INSERT INTO `bls_dept_node` VALUES (58, 1, 58, 1);
INSERT INTO `bls_dept_node` VALUES (59, 1, 59, 1);
INSERT INTO `bls_dept_node` VALUES (60, 1, 60, 1);
INSERT INTO `bls_dept_node` VALUES (61, 1, 61, 1);
INSERT INTO `bls_dept_node` VALUES (62, 1, 62, 1);
INSERT INTO `bls_dept_node` VALUES (63, 1, 63, 1);
INSERT INTO `bls_dept_node` VALUES (64, 1, 64, 1);
INSERT INTO `bls_dept_node` VALUES (65, 1, 65, 1);
INSERT INTO `bls_dept_node` VALUES (66, 1, 66, 1);
INSERT INTO `bls_dept_node` VALUES (67, 1, 67, 1);
INSERT INTO `bls_dept_node` VALUES (68, 2, 68, 1);
INSERT INTO `bls_dept_node` VALUES (69, 2, 69, 1);
INSERT INTO `bls_dept_node` VALUES (70, 2, 70, 1);
INSERT INTO `bls_dept_node` VALUES (71, 2, 71, 1);
INSERT INTO `bls_dept_node` VALUES (72, 1, 72, 1);
INSERT INTO `bls_dept_node` VALUES (73, 2, 73, 1);
INSERT INTO `bls_dept_node` VALUES (74, 1, 74, 1);
INSERT INTO `bls_dept_node` VALUES (75, 1, 75, 1);
INSERT INTO `bls_dept_node` VALUES (76, 2, 76, 1);
INSERT INTO `bls_dept_node` VALUES (77, 1, 77, 1);
INSERT INTO `bls_dept_node` VALUES (78, 2, 78, 1);
INSERT INTO `bls_dept_node` VALUES (79, 1, 79, 1);
INSERT INTO `bls_dept_node` VALUES (80, 2, 80, 1);
INSERT INTO `bls_dept_node` VALUES (81, 1, 81, 1);
INSERT INTO `bls_dept_node` VALUES (82, 1, 82, 1);
INSERT INTO `bls_dept_node` VALUES (83, 1, 83, 1);
INSERT INTO `bls_dept_node` VALUES (84, 2, 84, 1);
INSERT INTO `bls_dept_node` VALUES (85, 2, 85, 1);
INSERT INTO `bls_dept_node` VALUES (86, 2, 86, 1);
INSERT INTO `bls_dept_node` VALUES (87, 2, 87, 1);
INSERT INTO `bls_dept_node` VALUES (88, 2, 88, 1);
INSERT INTO `bls_dept_node` VALUES (89, 2, 89, 1);
INSERT INTO `bls_dept_node` VALUES (90, 2, 90, 1);
INSERT INTO `bls_dept_node` VALUES (91, 2, 91, 1);
INSERT INTO `bls_dept_node` VALUES (92, 2, 92, 1);
INSERT INTO `bls_dept_node` VALUES (93, 2, 93, 1);
INSERT INTO `bls_dept_node` VALUES (94, 2, 94, 1);
INSERT INTO `bls_dept_node` VALUES (95, 2, 95, 1);
INSERT INTO `bls_dept_node` VALUES (96, 2, 96, 1);
INSERT INTO `bls_dept_node` VALUES (97, 2, 97, 1);
INSERT INTO `bls_dept_node` VALUES (98, 2, 98, 1);
INSERT INTO `bls_dept_node` VALUES (99, 2, 99, 1);
INSERT INTO `bls_dept_node` VALUES (100, 2, 100, 1);
INSERT INTO `bls_dept_node` VALUES (101, 2, 101, 1);
INSERT INTO `bls_dept_node` VALUES (102, 2, 102, 1);
INSERT INTO `bls_dept_node` VALUES (103, 2, 103, 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_dept_rule
-- ----------------------------
DROP TABLE IF EXISTS `bls_dept_rule`;
CREATE TABLE `bls_dept_rule` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dept_id` bigint NOT NULL COMMENT '场景区id',
  `rule_id` bigint NOT NULL COMMENT '规则id',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态  0：禁用  1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_rule
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept_rule` VALUES (1, 1, 1, 1);
INSERT INTO `bls_dept_rule` VALUES (2, 1, 2, 1);
INSERT INTO `bls_dept_rule` VALUES (3, 1, 3, 1);
INSERT INTO `bls_dept_rule` VALUES (4, 1, 4, 1);
INSERT INTO `bls_dept_rule` VALUES (5, 1, 5, 1);
INSERT INTO `bls_dept_rule` VALUES (6, 1, 6, 1);
INSERT INTO `bls_dept_rule` VALUES (7, 1, 7, 1);
INSERT INTO `bls_dept_rule` VALUES (8, 1, 8, 1);
INSERT INTO `bls_dept_rule` VALUES (9, 1, 9, 1);
INSERT INTO `bls_dept_rule` VALUES (10, 1, 10, 1);
INSERT INTO `bls_dept_rule` VALUES (11, 1, 11, 1);
INSERT INTO `bls_dept_rule` VALUES (12, 1, 12, 1);
INSERT INTO `bls_dept_rule` VALUES (13, 1, 13, 1);
INSERT INTO `bls_dept_rule` VALUES (14, 1, 14, 1);
INSERT INTO `bls_dept_rule` VALUES (15, 1, 15, 1);
INSERT INTO `bls_dept_rule` VALUES (16, 1, 16, 1);
INSERT INTO `bls_dept_rule` VALUES (17, 1, 17, 1);
INSERT INTO `bls_dept_rule` VALUES (18, 1, 18, 1);
INSERT INTO `bls_dept_rule` VALUES (19, 1, 19, 1);
INSERT INTO `bls_dept_rule` VALUES (20, 1, 20, 1);
INSERT INTO `bls_dept_rule` VALUES (21, 1, 21, 1);
INSERT INTO `bls_dept_rule` VALUES (22, 1, 22, 1);
INSERT INTO `bls_dept_rule` VALUES (23, 1, 23, 1);
INSERT INTO `bls_dept_rule` VALUES (24, 1, 24, 1);
INSERT INTO `bls_dept_rule` VALUES (25, 1, 25, 1);
INSERT INTO `bls_dept_rule` VALUES (26, 1, 26, 1);
INSERT INTO `bls_dept_rule` VALUES (27, 1, 27, 1);
INSERT INTO `bls_dept_rule` VALUES (28, 1, 28, 1);
INSERT INTO `bls_dept_rule` VALUES (29, 1, 29, 1);
INSERT INTO `bls_dept_rule` VALUES (30, 1, 30, 1);
INSERT INTO `bls_dept_rule` VALUES (31, 1, 31, 1);
INSERT INTO `bls_dept_rule` VALUES (32, 1, 32, 1);
INSERT INTO `bls_dept_rule` VALUES (33, 1, 33, 1);
INSERT INTO `bls_dept_rule` VALUES (34, 1, 34, 1);
INSERT INTO `bls_dept_rule` VALUES (35, 1, 35, 1);
INSERT INTO `bls_dept_rule` VALUES (36, 1, 36, 1);
INSERT INTO `bls_dept_rule` VALUES (37, 1, 37, 1);
INSERT INTO `bls_dept_rule` VALUES (38, 1, 38, 1);
INSERT INTO `bls_dept_rule` VALUES (39, 1, 39, 1);
INSERT INTO `bls_dept_rule` VALUES (40, 1, 40, 1);
INSERT INTO `bls_dept_rule` VALUES (41, 1, 41, 1);
INSERT INTO `bls_dept_rule` VALUES (42, 1, 42, 1);
INSERT INTO `bls_dept_rule` VALUES (43, 1, 43, 1);
INSERT INTO `bls_dept_rule` VALUES (44, 1, 44, 1);
INSERT INTO `bls_dept_rule` VALUES (45, 1, 45, 1);
INSERT INTO `bls_dept_rule` VALUES (46, 1, 46, 1);
INSERT INTO `bls_dept_rule` VALUES (47, 1, 47, 1);
INSERT INTO `bls_dept_rule` VALUES (48, 1, 48, 1);
INSERT INTO `bls_dept_rule` VALUES (49, 1, 49, 1);
INSERT INTO `bls_dept_rule` VALUES (50, 1, 50, 1);
INSERT INTO `bls_dept_rule` VALUES (51, 1, 51, 1);
INSERT INTO `bls_dept_rule` VALUES (52, 1, 52, 1);
INSERT INTO `bls_dept_rule` VALUES (53, 1, 53, 1);
INSERT INTO `bls_dept_rule` VALUES (54, 1, 54, 1);
INSERT INTO `bls_dept_rule` VALUES (55, 1, 55, 1);
INSERT INTO `bls_dept_rule` VALUES (56, 1, 56, 1);
INSERT INTO `bls_dept_rule` VALUES (57, 1, 57, 1);
INSERT INTO `bls_dept_rule` VALUES (58, 1, 58, 1);
INSERT INTO `bls_dept_rule` VALUES (59, 1, 59, 1);
INSERT INTO `bls_dept_rule` VALUES (60, 1, 60, 1);
INSERT INTO `bls_dept_rule` VALUES (61, 1, 61, 1);
INSERT INTO `bls_dept_rule` VALUES (62, 1, 62, 1);
INSERT INTO `bls_dept_rule` VALUES (63, 1, 63, 1);
INSERT INTO `bls_dept_rule` VALUES (64, 1, 64, 1);
INSERT INTO `bls_dept_rule` VALUES (65, 1, 65, 1);
INSERT INTO `bls_dept_rule` VALUES (66, 1, 66, 1);
INSERT INTO `bls_dept_rule` VALUES (67, 1, 67, 1);
INSERT INTO `bls_dept_rule` VALUES (68, 1, 68, 1);
INSERT INTO `bls_dept_rule` VALUES (69, 1, 69, 1);
INSERT INTO `bls_dept_rule` VALUES (70, 2, 70, 1);
INSERT INTO `bls_dept_rule` VALUES (71, 1, 71, 1);
INSERT INTO `bls_dept_rule` VALUES (72, 1, 72, 1);
INSERT INTO `bls_dept_rule` VALUES (73, 1, 73, 1);
INSERT INTO `bls_dept_rule` VALUES (74, 1, 74, 1);
INSERT INTO `bls_dept_rule` VALUES (75, 1, 75, 1);
INSERT INTO `bls_dept_rule` VALUES (76, 1, 76, 1);
INSERT INTO `bls_dept_rule` VALUES (77, 1, 77, 1);
INSERT INTO `bls_dept_rule` VALUES (78, 1, 78, 1);
INSERT INTO `bls_dept_rule` VALUES (79, 1, 79, 1);
INSERT INTO `bls_dept_rule` VALUES (80, 1, 80, 1);
INSERT INTO `bls_dept_rule` VALUES (81, 1, 81, 1);
INSERT INTO `bls_dept_rule` VALUES (82, 1, 82, 1);
INSERT INTO `bls_dept_rule` VALUES (83, 1, 83, 1);
INSERT INTO `bls_dept_rule` VALUES (84, 1, 84, 1);
INSERT INTO `bls_dept_rule` VALUES (85, 1, 85, 1);
INSERT INTO `bls_dept_rule` VALUES (86, 1, 86, 1);
INSERT INTO `bls_dept_rule` VALUES (87, 1, 87, 1);
INSERT INTO `bls_dept_rule` VALUES (88, 2, 88, 1);
INSERT INTO `bls_dept_rule` VALUES (89, 1, 89, 1);
INSERT INTO `bls_dept_rule` VALUES (90, 2, 90, 1);
INSERT INTO `bls_dept_rule` VALUES (91, 2, 91, 1);
INSERT INTO `bls_dept_rule` VALUES (92, 1, 92, 1);
INSERT INTO `bls_dept_rule` VALUES (93, 1, 93, 1);
INSERT INTO `bls_dept_rule` VALUES (94, 1, 94, 1);
INSERT INTO `bls_dept_rule` VALUES (95, 2, 95, 1);
INSERT INTO `bls_dept_rule` VALUES (96, 2, 96, 1);
INSERT INTO `bls_dept_rule` VALUES (97, 2, 97, 1);
INSERT INTO `bls_dept_rule` VALUES (98, 2, 98, 1);
INSERT INTO `bls_dept_rule` VALUES (99, 1, 99, 1);
INSERT INTO `bls_dept_rule` VALUES (100, 2, 100, 1);
INSERT INTO `bls_dept_rule` VALUES (101, 2, 101, 1);
INSERT INTO `bls_dept_rule` VALUES (102, 2, 102, 1);
INSERT INTO `bls_dept_rule` VALUES (103, 2, 103, 1);
INSERT INTO `bls_dept_rule` VALUES (104, 2, 104, 1);
INSERT INTO `bls_dept_rule` VALUES (105, 2, 105, 1);
INSERT INTO `bls_dept_rule` VALUES (106, 2, 106, 1);
INSERT INTO `bls_dept_rule` VALUES (107, 2, 107, 1);
INSERT INTO `bls_dept_rule` VALUES (108, 2, 108, 1);
INSERT INTO `bls_dept_rule` VALUES (109, 2, 109, 1);
INSERT INTO `bls_dept_rule` VALUES (110, 2, 110, 1);
INSERT INTO `bls_dept_rule` VALUES (111, 2, 111, 1);
INSERT INTO `bls_dept_rule` VALUES (112, 2, 112, 1);
INSERT INTO `bls_dept_rule` VALUES (113, 2, 113, 1);
INSERT INTO `bls_dept_rule` VALUES (114, 2, 114, 1);
INSERT INTO `bls_dept_rule` VALUES (115, 2, 115, 1);
INSERT INTO `bls_dept_rule` VALUES (116, 2, 116, 1);
INSERT INTO `bls_dept_rule` VALUES (117, 2, 117, 1);
INSERT INTO `bls_dept_rule` VALUES (118, 2, 118, 1);
INSERT INTO `bls_dept_rule` VALUES (119, 2, 119, 1);
INSERT INTO `bls_dept_rule` VALUES (120, 2, 120, 1);
INSERT INTO `bls_dept_rule` VALUES (121, 2, 121, 1);
INSERT INTO `bls_dept_rule` VALUES (122, 2, 122, 1);
INSERT INTO `bls_dept_rule` VALUES (123, 2, 123, 1);
INSERT INTO `bls_dept_rule` VALUES (124, 2, 124, 1);
INSERT INTO `bls_dept_rule` VALUES (125, 2, 125, 1);
INSERT INTO `bls_dept_rule` VALUES (126, 2, 126, 1);
INSERT INTO `bls_dept_rule` VALUES (127, 2, 127, 1);
INSERT INTO `bls_dept_rule` VALUES (128, 2, 128, 1);
INSERT INTO `bls_dept_rule` VALUES (129, 2, 129, 1);
INSERT INTO `bls_dept_rule` VALUES (130, 2, 130, 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_dept_script
-- ----------------------------
DROP TABLE IF EXISTS `bls_dept_script`;
CREATE TABLE `bls_dept_script` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dept_id` bigint NOT NULL COMMENT '场景区id',
  `script_id` bigint NOT NULL COMMENT '剧本id',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态  0：禁用  1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_script
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept_script` VALUES (1, 1, 1, 1);
INSERT INTO `bls_dept_script` VALUES (2, 1, 2, 1);
INSERT INTO `bls_dept_script` VALUES (3, 1, 3, 1);
INSERT INTO `bls_dept_script` VALUES (4, 1, 4, 1);
INSERT INTO `bls_dept_script` VALUES (5, 1, 5, 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_dept_sentence
-- ----------------------------
DROP TABLE IF EXISTS `bls_dept_sentence`;
CREATE TABLE `bls_dept_sentence` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dept_id` bigint NOT NULL COMMENT '场景区ID',
  `sentence_id` bigint NOT NULL COMMENT '句型ID',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态  0：禁用  1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_sentence
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept_sentence` VALUES (1, 1, 1, 1);
INSERT INTO `bls_dept_sentence` VALUES (2, 1, 2, 1);
INSERT INTO `bls_dept_sentence` VALUES (3, 1, 3, 1);
INSERT INTO `bls_dept_sentence` VALUES (4, 1, 4, 1);
INSERT INTO `bls_dept_sentence` VALUES (5, 1, 5, 1);
INSERT INTO `bls_dept_sentence` VALUES (6, 1, 6, 1);
INSERT INTO `bls_dept_sentence` VALUES (7, 1, 7, 1);
INSERT INTO `bls_dept_sentence` VALUES (8, 1, 8, 1);
INSERT INTO `bls_dept_sentence` VALUES (9, 1, 9, 1);
INSERT INTO `bls_dept_sentence` VALUES (10, 1, 10, 1);
INSERT INTO `bls_dept_sentence` VALUES (11, 1, 11, 1);
INSERT INTO `bls_dept_sentence` VALUES (12, 1, 12, 1);
INSERT INTO `bls_dept_sentence` VALUES (13, 1, 13, 1);
INSERT INTO `bls_dept_sentence` VALUES (14, 1, 14, 1);
INSERT INTO `bls_dept_sentence` VALUES (15, 1, 15, 1);
INSERT INTO `bls_dept_sentence` VALUES (16, 1, 16, 1);
INSERT INTO `bls_dept_sentence` VALUES (17, 1, 17, 1);
INSERT INTO `bls_dept_sentence` VALUES (18, 1, 18, 1);
INSERT INTO `bls_dept_sentence` VALUES (19, 1, 19, 1);
INSERT INTO `bls_dept_sentence` VALUES (20, 1, 20, 1);
INSERT INTO `bls_dept_sentence` VALUES (21, 1, 21, 1);
INSERT INTO `bls_dept_sentence` VALUES (22, 1, 22, 1);
INSERT INTO `bls_dept_sentence` VALUES (23, 1, 23, 1);
INSERT INTO `bls_dept_sentence` VALUES (24, 1, 24, 1);
INSERT INTO `bls_dept_sentence` VALUES (25, 1, 25, 1);
INSERT INTO `bls_dept_sentence` VALUES (26, 2, 26, 1);
INSERT INTO `bls_dept_sentence` VALUES (27, 2, 27, 1);
INSERT INTO `bls_dept_sentence` VALUES (28, 2, 28, 1);
INSERT INTO `bls_dept_sentence` VALUES (29, 2, 29, 1);
INSERT INTO `bls_dept_sentence` VALUES (30, 2, 30, 1);
INSERT INTO `bls_dept_sentence` VALUES (31, 2, 31, 1);
INSERT INTO `bls_dept_sentence` VALUES (32, 2, 32, 1);
INSERT INTO `bls_dept_sentence` VALUES (33, 2, 33, 1);
INSERT INTO `bls_dept_sentence` VALUES (34, 2, 34, 1);
INSERT INTO `bls_dept_sentence` VALUES (35, 2, 35, 1);
INSERT INTO `bls_dept_sentence` VALUES (36, 2, 36, 1);
INSERT INTO `bls_dept_sentence` VALUES (37, 2, 37, 1);
INSERT INTO `bls_dept_sentence` VALUES (38, 2, 38, 1);
INSERT INTO `bls_dept_sentence` VALUES (39, 2, 39, 1);
INSERT INTO `bls_dept_sentence` VALUES (40, 2, 40, 1);
INSERT INTO `bls_dept_sentence` VALUES (41, 2, 41, 1);
INSERT INTO `bls_dept_sentence` VALUES (42, 2, 42, 1);
INSERT INTO `bls_dept_sentence` VALUES (43, 2, 43, 1);
INSERT INTO `bls_dept_sentence` VALUES (44, 2, 44, 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_dept_word
-- ----------------------------
DROP TABLE IF EXISTS `bls_dept_word`;
CREATE TABLE `bls_dept_word` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dept_id` bigint NOT NULL COMMENT '场景区id',
  `word_id` bigint NOT NULL COMMENT '词id',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态  0：禁用  1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_word
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept_word` VALUES (1, 1, 1, 1);
INSERT INTO `bls_dept_word` VALUES (2, 1, 2, 1);
INSERT INTO `bls_dept_word` VALUES (3, 1, 3, 1);
INSERT INTO `bls_dept_word` VALUES (4, 1, 4, 1);
INSERT INTO `bls_dept_word` VALUES (5, 1, 5, 1);
INSERT INTO `bls_dept_word` VALUES (6, 1, 6, 1);
INSERT INTO `bls_dept_word` VALUES (7, 1, 7, 1);
INSERT INTO `bls_dept_word` VALUES (8, 1, 8, 1);
INSERT INTO `bls_dept_word` VALUES (9, 1, 9, 1);
INSERT INTO `bls_dept_word` VALUES (10, 1, 10, 1);
INSERT INTO `bls_dept_word` VALUES (11, 1, 11, 1);
INSERT INTO `bls_dept_word` VALUES (12, 1, 12, 1);
INSERT INTO `bls_dept_word` VALUES (13, 1, 13, 1);
INSERT INTO `bls_dept_word` VALUES (14, 1, 14, 1);
INSERT INTO `bls_dept_word` VALUES (15, 1, 15, 1);
INSERT INTO `bls_dept_word` VALUES (16, 1, 16, 1);
INSERT INTO `bls_dept_word` VALUES (17, 1, 17, 1);
INSERT INTO `bls_dept_word` VALUES (18, 1, 18, 1);
INSERT INTO `bls_dept_word` VALUES (19, 1, 19, 1);
INSERT INTO `bls_dept_word` VALUES (20, 1, 20, 1);
INSERT INTO `bls_dept_word` VALUES (21, 1, 21, 1);
INSERT INTO `bls_dept_word` VALUES (22, 1, 22, 1);
INSERT INTO `bls_dept_word` VALUES (23, 1, 23, 1);
INSERT INTO `bls_dept_word` VALUES (24, 1, 24, 1);
INSERT INTO `bls_dept_word` VALUES (25, 1, 25, 1);
INSERT INTO `bls_dept_word` VALUES (26, 1, 26, 1);
INSERT INTO `bls_dept_word` VALUES (27, 1, 27, 1);
INSERT INTO `bls_dept_word` VALUES (28, 1, 28, 1);
INSERT INTO `bls_dept_word` VALUES (29, 1, 29, 1);
INSERT INTO `bls_dept_word` VALUES (30, 1, 30, 1);
INSERT INTO `bls_dept_word` VALUES (31, 1, 31, 1);
INSERT INTO `bls_dept_word` VALUES (32, 1, 32, 1);
INSERT INTO `bls_dept_word` VALUES (33, 1, 33, 1);
INSERT INTO `bls_dept_word` VALUES (34, 1, 34, 1);
INSERT INTO `bls_dept_word` VALUES (35, 1, 35, 1);
INSERT INTO `bls_dept_word` VALUES (36, 1, 36, 1);
INSERT INTO `bls_dept_word` VALUES (37, 1, 37, 1);
INSERT INTO `bls_dept_word` VALUES (38, 1, 38, 1);
INSERT INTO `bls_dept_word` VALUES (39, 1, 39, 1);
INSERT INTO `bls_dept_word` VALUES (40, 1, 40, 1);
INSERT INTO `bls_dept_word` VALUES (41, 1, 41, 1);
INSERT INTO `bls_dept_word` VALUES (42, 1, 42, 1);
INSERT INTO `bls_dept_word` VALUES (43, 1, 43, 1);
INSERT INTO `bls_dept_word` VALUES (44, 1, 44, 1);
INSERT INTO `bls_dept_word` VALUES (45, 1, 45, 1);
INSERT INTO `bls_dept_word` VALUES (46, 1, 46, 1);
INSERT INTO `bls_dept_word` VALUES (47, 1, 47, 1);
INSERT INTO `bls_dept_word` VALUES (48, 1, 48, 1);
INSERT INTO `bls_dept_word` VALUES (49, 1, 49, 1);
INSERT INTO `bls_dept_word` VALUES (50, 1, 50, 1);
INSERT INTO `bls_dept_word` VALUES (51, 1, 51, 1);
INSERT INTO `bls_dept_word` VALUES (52, 1, 52, 1);
INSERT INTO `bls_dept_word` VALUES (53, 1, 53, 1);
INSERT INTO `bls_dept_word` VALUES (54, 1, 54, 1);
INSERT INTO `bls_dept_word` VALUES (55, 1, 55, 1);
INSERT INTO `bls_dept_word` VALUES (56, 1, 56, 1);
INSERT INTO `bls_dept_word` VALUES (57, 1, 57, 1);
INSERT INTO `bls_dept_word` VALUES (58, 1, 58, 1);
INSERT INTO `bls_dept_word` VALUES (59, 1, 59, 1);
INSERT INTO `bls_dept_word` VALUES (60, 1, 60, 1);
INSERT INTO `bls_dept_word` VALUES (61, 1, 61, 1);
INSERT INTO `bls_dept_word` VALUES (62, 1, 62, 1);
INSERT INTO `bls_dept_word` VALUES (63, 1, 63, 1);
INSERT INTO `bls_dept_word` VALUES (64, 1, 64, 1);
INSERT INTO `bls_dept_word` VALUES (65, 1, 65, 1);
INSERT INTO `bls_dept_word` VALUES (66, 1, 66, 1);
INSERT INTO `bls_dept_word` VALUES (67, 1, 67, 1);
INSERT INTO `bls_dept_word` VALUES (68, 1, 68, 1);
INSERT INTO `bls_dept_word` VALUES (69, 1, 69, 1);
INSERT INTO `bls_dept_word` VALUES (70, 1, 70, 1);
INSERT INTO `bls_dept_word` VALUES (71, 1, 71, 1);
INSERT INTO `bls_dept_word` VALUES (72, 1, 72, 1);
INSERT INTO `bls_dept_word` VALUES (73, 1, 73, 1);
INSERT INTO `bls_dept_word` VALUES (74, 1, 74, 1);
INSERT INTO `bls_dept_word` VALUES (75, 1, 75, 1);
INSERT INTO `bls_dept_word` VALUES (76, 1, 76, 1);
INSERT INTO `bls_dept_word` VALUES (77, 1, 77, 1);
INSERT INTO `bls_dept_word` VALUES (78, 1, 78, 1);
INSERT INTO `bls_dept_word` VALUES (79, 1, 79, 1);
INSERT INTO `bls_dept_word` VALUES (80, 1, 80, 1);
INSERT INTO `bls_dept_word` VALUES (81, 1, 81, 1);
INSERT INTO `bls_dept_word` VALUES (82, 1, 82, 1);
INSERT INTO `bls_dept_word` VALUES (83, 1, 83, 1);
INSERT INTO `bls_dept_word` VALUES (84, 1, 84, 1);
INSERT INTO `bls_dept_word` VALUES (85, 1, 85, 1);
INSERT INTO `bls_dept_word` VALUES (86, 1, 86, 1);
INSERT INTO `bls_dept_word` VALUES (87, 1, 87, 1);
INSERT INTO `bls_dept_word` VALUES (88, 1, 88, 1);
INSERT INTO `bls_dept_word` VALUES (89, 1, 89, 1);
INSERT INTO `bls_dept_word` VALUES (90, 1, 90, 1);
INSERT INTO `bls_dept_word` VALUES (91, 1, 91, 1);
INSERT INTO `bls_dept_word` VALUES (92, 1, 92, 1);
INSERT INTO `bls_dept_word` VALUES (93, 1, 93, 1);
INSERT INTO `bls_dept_word` VALUES (94, 1, 94, 1);
INSERT INTO `bls_dept_word` VALUES (95, 1, 95, 1);
INSERT INTO `bls_dept_word` VALUES (96, 1, 96, 1);
INSERT INTO `bls_dept_word` VALUES (97, 1, 97, 1);
INSERT INTO `bls_dept_word` VALUES (98, 1, 98, 1);
INSERT INTO `bls_dept_word` VALUES (99, 1, 99, 1);
INSERT INTO `bls_dept_word` VALUES (100, 1, 100, 1);
INSERT INTO `bls_dept_word` VALUES (101, 1, 101, 1);
INSERT INTO `bls_dept_word` VALUES (102, 1, 102, 1);
INSERT INTO `bls_dept_word` VALUES (103, 1, 103, 1);
INSERT INTO `bls_dept_word` VALUES (104, 1, 104, 1);
INSERT INTO `bls_dept_word` VALUES (105, 1, 105, 1);
INSERT INTO `bls_dept_word` VALUES (106, 1, 106, 1);
INSERT INTO `bls_dept_word` VALUES (107, 1, 107, 1);
INSERT INTO `bls_dept_word` VALUES (108, 1, 108, 1);
INSERT INTO `bls_dept_word` VALUES (109, 1, 109, 1);
INSERT INTO `bls_dept_word` VALUES (110, 1, 110, 1);
INSERT INTO `bls_dept_word` VALUES (111, 1, 111, 1);
INSERT INTO `bls_dept_word` VALUES (112, 1, 112, 1);
INSERT INTO `bls_dept_word` VALUES (113, 1, 113, 1);
INSERT INTO `bls_dept_word` VALUES (114, 1, 114, 1);
INSERT INTO `bls_dept_word` VALUES (115, 1, 115, 1);
INSERT INTO `bls_dept_word` VALUES (116, 1, 116, 1);
INSERT INTO `bls_dept_word` VALUES (117, 2, 117, 1);
INSERT INTO `bls_dept_word` VALUES (118, 2, 118, 1);
INSERT INTO `bls_dept_word` VALUES (119, 2, 119, 1);
INSERT INTO `bls_dept_word` VALUES (120, 2, 120, 1);
INSERT INTO `bls_dept_word` VALUES (121, 2, 121, 1);
INSERT INTO `bls_dept_word` VALUES (122, 2, 122, 1);
INSERT INTO `bls_dept_word` VALUES (123, 2, 123, 1);
INSERT INTO `bls_dept_word` VALUES (124, 2, 124, 1);
INSERT INTO `bls_dept_word` VALUES (125, 2, 125, 1);
INSERT INTO `bls_dept_word` VALUES (126, 2, 126, 1);
INSERT INTO `bls_dept_word` VALUES (127, 2, 127, 1);
INSERT INTO `bls_dept_word` VALUES (128, 2, 128, 1);
INSERT INTO `bls_dept_word` VALUES (129, 2, 129, 1);
INSERT INTO `bls_dept_word` VALUES (130, 2, 130, 1);
INSERT INTO `bls_dept_word` VALUES (131, 2, 131, 1);
INSERT INTO `bls_dept_word` VALUES (132, 2, 132, 1);
INSERT INTO `bls_dept_word` VALUES (133, 2, 133, 1);
INSERT INTO `bls_dept_word` VALUES (134, 2, 134, 1);
INSERT INTO `bls_dept_word` VALUES (135, 2, 135, 1);
INSERT INTO `bls_dept_word` VALUES (136, 2, 136, 1);
INSERT INTO `bls_dept_word` VALUES (137, 2, 137, 1);
INSERT INTO `bls_dept_word` VALUES (138, 2, 138, 1);
INSERT INTO `bls_dept_word` VALUES (139, 2, 139, 1);
INSERT INTO `bls_dept_word` VALUES (140, 2, 140, 1);
INSERT INTO `bls_dept_word` VALUES (141, 2, 141, 1);
INSERT INTO `bls_dept_word` VALUES (142, 2, 142, 1);
INSERT INTO `bls_dept_word` VALUES (143, 2, 143, 1);
INSERT INTO `bls_dept_word` VALUES (144, 2, 144, 1);
INSERT INTO `bls_dept_word` VALUES (145, 2, 145, 1);
INSERT INTO `bls_dept_word` VALUES (146, 2, 146, 1);
INSERT INTO `bls_dept_word` VALUES (147, 2, 147, 1);
INSERT INTO `bls_dept_word` VALUES (148, 2, 148, 1);
INSERT INTO `bls_dept_word` VALUES (149, 2, 149, 1);
INSERT INTO `bls_dept_word` VALUES (150, 2, 150, 1);
INSERT INTO `bls_dept_word` VALUES (151, 2, 151, 1);
INSERT INTO `bls_dept_word` VALUES (152, 2, 152, 1);
INSERT INTO `bls_dept_word` VALUES (153, 2, 153, 1);
INSERT INTO `bls_dept_word` VALUES (154, 2, 154, 1);
INSERT INTO `bls_dept_word` VALUES (155, 2, 155, 1);
INSERT INTO `bls_dept_word` VALUES (156, 2, 156, 1);
INSERT INTO `bls_dept_word` VALUES (157, 2, 157, 1);
INSERT INTO `bls_dept_word` VALUES (158, 2, 158, 1);
INSERT INTO `bls_dept_word` VALUES (159, 2, 159, 1);
INSERT INTO `bls_dept_word` VALUES (160, 2, 160, 1);
INSERT INTO `bls_dept_word` VALUES (161, 1, 161, 1);
INSERT INTO `bls_dept_word` VALUES (162, 1, 162, 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_menu
-- ----------------------------
DROP TABLE IF EXISTS `bls_menu`;
CREATE TABLE `bls_menu` (
  `menu_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '表唯一标识',
  `parent_id` bigint NOT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int NOT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单图标',
  `status` int NOT NULL DEFAULT '1' COMMENT '0：禁用 1：正常',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_menu
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for bls_node
-- ----------------------------
DROP TABLE IF EXISTS `bls_node`;
CREATE TABLE `bls_node` (
  `node_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '该节点的类名',
  `package_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '该类所在的路径、包名',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `creator_id` int NOT NULL COMMENT '创建者的用户id',
  `editor_id` int NOT NULL COMMENT '最近一次编辑者id',
  `update_time` datetime DEFAULT NULL COMMENT '最近一次更新时间',
  `status` int NOT NULL DEFAULT '1' COMMENT '0:禁用 1：待开发 2： 开发中 3：待审核 4：待发布 5：已发布',
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_node
-- ----------------------------
BEGIN;
INSERT INTO `bls_node` VALUES (1, 'Organization', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\npublic class Organization extends Noun {\n    public String text;\n\n    public Organization(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 14:32:35', 1);
INSERT INTO `bls_node` VALUES (2, 'Department', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\npublic class Department extends Noun {\n\n    public String text;\n\n    public Department(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 14:36:10', 1);
INSERT INTO `bls_node` VALUES (3, 'ParentDepartment', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\npublic class ParentDepartment extends Noun {\n\n    public String text;\n\n    public ParentDepartment(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 14:38:54', 1);
INSERT INTO `bls_node` VALUES (4, 'SuperiorDepartment', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\npublic class SuperiorDepartment extends Noun {\n\n    public String text;\n\n    public SuperiorDepartment(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 14:41:57', 1);
INSERT INTO `bls_node` VALUES (5, 'SubDepartment', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\npublic class SubDepartment extends Noun {\n\n    public String text;\n\n    public SubDepartment(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 14:45:37', 1);
INSERT INTO `bls_node` VALUES (6, 'Band', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\npublic class Band extends Noun {\n    public String text;\n\n    public Band(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 14:47:25', 1);
INSERT INTO `bls_node` VALUES (7, 'ParentBand', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\npublic class ParentBand extends Noun {\n\n    public String text;\n\n    public ParentBand(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 14:49:15', 1);
INSERT INTO `bls_node` VALUES (8, 'SubBand', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\npublic class SubBand extends Noun {\n\n    public String text;\n\n    public SubBand(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 14:52:09', 1);
INSERT INTO `bls_node` VALUES (9, 'Position', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\npublic class Position extends Noun {\n\n    public String text;\n\n    public Position(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 14:54:24', 1);
INSERT INTO `bls_node` VALUES (10, 'Member', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\npublic class Member extends Noun {\n    public String text;\n\n    public Member(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 14:57:04', 1);
INSERT INTO `bls_node` VALUES (11, 'Tool', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\npublic class Tool extends Noun {\n    public String text;\n\n    public Tool(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 14:59:16', 1);
INSERT INTO `bls_node` VALUES (12, 'Role', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\npublic class Role extends Noun {\n\n    public String text;\n\n    public Role(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 15:00:53', 1);
INSERT INTO `bls_node` VALUES (13, 'Authority', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\npublic class Authority extends Noun {\n\n    public String text;\n\n    public Authority(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 15:03:23', 1);
INSERT INTO `bls_node` VALUES (14, 'Speaker', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;\n\npublic class Speaker extends Noun {\n\n    public String text;\n\n    public Speaker(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        Integer type = 0;//言者类型\n        Environment.environment.put(\"Noun\", type);\n        return true;\n    }\n}', 4, 4, '2021-06-22 15:06:40', 1);
INSERT INTO `bls_node` VALUES (15, 'Reader', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;\n\npublic class Reader extends Noun {\n    public String text;\n\n    public Reader(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        Integer type = 1;//读者类型\n        Environment.environment.put(\"Noun\", type);\n        return true;\n    }\n}', 4, 4, '2021-06-22 15:08:48', 1);
INSERT INTO `bls_node` VALUES (16, 'Writer', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;\n\npublic class Writer extends Noun {\n    public String text;\n\n    public Writer(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        Integer type = 2;//写者类型\n        Environment.environment.put(\"Noun\", type);\n        return true;\n    }\n}', 4, 4, '2021-06-22 15:19:20', 1);
INSERT INTO `bls_node` VALUES (17, 'Worker', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;\n\npublic class Worker extends Noun {\n\n    public String text;\n\n    public Worker(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        Integer type = 3;//工者类型\n        Environment.environment.put(\"Noun\", type);\n        return true;\n    }\n}', 4, 4, '2021-06-22 15:24:28', 1);
INSERT INTO `bls_node` VALUES (18, 'Administrator', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\npublic class Administrator extends Noun {\n\n    public String text;\n\n    public Administrator(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 15:26:06', 1);
INSERT INTO `bls_node` VALUES (19, 'Drama', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;\n\npublic class Drama extends Noun {\n\n    public String text;\n\n    public Drama(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 15:28:04', 1);
INSERT INTO `bls_node` VALUES (20, 'File', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'public class File extends Noun{\n\n    public String text;\n\n    public File(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 16:14:07', 1);
INSERT INTO `bls_node` VALUES (21, 'Chatroom', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Chatroom', 'public class Chatroom extends Noun{\n\n    public String text;\n\n    public Chatroom(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 16:26:20', 1);
INSERT INTO `bls_node` VALUES (22, 'MaxAuthority', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'public class MaxAuthority extends Noun {\n    public String text;\n\n    public MaxAuthority(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 16:27:38', 1);
INSERT INTO `bls_node` VALUES (23, 'MinAuthority', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'public class MinAuthority extends Noun {\n\n    public String text;\n\n    public MinAuthority(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 16:28:42', 1);
INSERT INTO `bls_node` VALUES (24, 'Deadline', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'public class Deadline extends Noun {\n\n    public String text;\n\n    public Deadline(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 16:29:42', 1);
INSERT INTO `bls_node` VALUES (25, 'NewStaff', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'public class NewStaff extends Noun{\n\n    public String text;\n\n    public NewStaff(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 16:32:54', 1);
INSERT INTO `bls_node` VALUES (26, 'SeniorStaff', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'public class SeniorStaffextends Noun{\n\n    public String text;\n\n    public SeniorStaff(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 16:33:57', 1);
INSERT INTO `bls_node` VALUES (27, 'Show', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'public class Show extends Verb{\n    public String text;\n\n    public Show(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 16:46:39', 1);
INSERT INTO `bls_node` VALUES (28, 'Establish', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.fy.bl.environment.Environment;//包路径需要更改\n\npublic class Establish extends Verb{\n\n    public String text;\n\n    public Establish(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object object = Environment.environment.get(\"Object\");\n        if (object instanceof String){\n            switch(object.toString()){\n                case \"部门\":\n                    System.out.println(\"创建部门\");\n                    Environment.envStack.push(\"createDepartment\");\n                    break;\n                case \"子部门\":\n                    System.out.println(\"创建子部门\");\n                    Environment.envStack.push(\"createDepartment\");\n                    break;\n                case \"岗位\":\n                    System.out.println(\"创建岗位\");\n                    Environment.envStack.push(\"createPosition\");\n                    break;\n                default:\n                    res = false;\n                    System.out.println(\"语义不正确\");\n                    break;\n            }\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-22 17:07:26', 1);
INSERT INTO `bls_node` VALUES (29, 'Join', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.fy.bl.environment.Environment;////\n\npublic class Join extends Verb{\n\n    public String text;\n\n    public Join(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object object = Environment.environment.get(\"Attribute\");\n        Environment.envStack.push(\"addUsersToDepartment\");\n        return res;\n    }\n}', 4, 4, '2021-06-22 17:09:43', 1);
INSERT INTO `bls_node` VALUES (30, 'Revoke', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'public class Revoke extends Verb{\n    public String text;\n\n    public Revoke(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 17:17:13', 1);
INSERT INTO `bls_node` VALUES (31, 'Set', ' com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'public class Set extends Verb{\n    public String text;\n\n    public Set(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 17:18:07', 1);
INSERT INTO `bls_node` VALUES (32, 'Change', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.fy.bl.environment.Environment;\n\npublic class Change extends Verb{\n    public String text;\n\n    public Change(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object object = Environment.environment.get(\"Object\");\n        //\n        if (object instanceof String){\n            switch (object.toString()){\n                case \"岗位\":\n                    System.out.println(\"更换到 ** 岗位\");\n                    break;\n                default:\n                    res = false;\n                    System.out.println(\"语义有误\");\n                    break;\n            }\n        }\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 17:19:04', 1);
INSERT INTO `bls_node` VALUES (33, 'Edit', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.fy.bl.environment.Environment;\n\npublic class Edit extends Verb{\n    public String text;\n\n    public Edit(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object attribute = Environment.environment.get(\"Attribute\");\n        Object prepos = Environment.environment.get(\"PrePos\");\n        Object obj = Environment.environment.get(\"Object\");\n        if (attribute == null){\n            System.out.println(\"原岗位错误\");\n            res = false;\n        }else{\n            switch (prepos.toString()){\n                case \"部门\":\n                    System.out.println(\"修改部门\");\n                    break;\n                case \"岗位\":\n                    System.out.println(\"修改岗位\");\n                    break;\n                default:\n                    res = false;\n                    break;\n            }\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-22 17:20:47', 1);
INSERT INTO `bls_node` VALUES (34, 'Delete', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.language.environment.Environment;\n\npublic class Delete extends Verb{\n    public String text;\n\n    public Delete(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object object = Environment.environment.get(\"Object\");\n        if (object instanceof String){\n            switch(object.toString()){\n                case \"岗位\":\n                    System.out.println(\"移除岗位\");\n                    break;\n                default:\n                    res = false;\n                    System.out.println(\"语义不正确\");\n                    break;\n            }\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-22 17:24:11', 1);
INSERT INTO `bls_node` VALUES (35, 'Merge', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'public class Merge extends Verb{\n    public String text;\n\n    public Merge(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}\n', 4, 4, '2021-06-22 17:25:18', 1);
INSERT INTO `bls_node` VALUES (36, 'Move', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'public class Move extends Verb{\n    public String text;\n\n    public Move(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 17:27:35', 1);
INSERT INTO `bls_node` VALUES (37, 'Appoint', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.fy.bl.environment.Environment;\n\npublic class Appoint extends Verb{\n    public String text;\n\n    public Appoint(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object object = Environment.environment.get(\"Object\");\n        Object attribute = Environment.environment.get(\"Attribute\");\n        Object adverbial = Environment.environment.get(\"Adverbial\");\n        if (object instanceof String){\n            switch (object.toString()){\n                case \"岗位\":\n                    System.out.println(\"为 ** 任命 **\");\n                    Environment.envStack.push(\"addUsersToPosition\");\n                    break;\n                default:\n                    res = false;\n                    System.out.println(\"语义有误\");\n                    break;\n            }\n        }\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 17:28:20', 1);
INSERT INTO `bls_node` VALUES (38, 'Relieve', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'public class Relieve extends Verb{\n    public String text;\n\n    public Relieve(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 17:29:11', 1);
INSERT INTO `bls_node` VALUES (39, 'Grant', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.fy.bl.environment.Environment;\n\npublic class Grant extends Verb{\n\n    public String text;\n\n    public Grant(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object object = Environment.environment.get(\"Object\");\n        if (object instanceof String){\n            switch(object.toString()){\n                case \"岗位\":\n                    System.out.println(\"授予岗位\");\n                    break;\n                default:\n                    res = false;\n                    System.out.println(\"语义不正确\");\n                    break;\n            }\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-22 17:29:53', 1);
INSERT INTO `bls_node` VALUES (40, 'Disable', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.fy.bl.environment.Environment;\n\npublic class Disable extends Verb{\n    public String text;\n\n    public Disable(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object object = Environment.environment.get(\"Object\");\n        Object attribute = Environment.environment.get(\"Attribute\");\n        if (attribute == null){\n            System.out.println(\"禁用工具\" + object.toString());\n        }else {\n            switch(object.toString()){\n                case \"工具\":\n                    System.out.println(\"禁用工具ID为\" + attribute.toString());\n                    break;\n                default:\n                    res = false;\n                    System.out.println(\"语义不正确\");\n                    break;\n            }\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-22 17:30:38', 1);
INSERT INTO `bls_node` VALUES (41, 'Enable', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.fy.bl.environment.Environment;\n\npublic class Enable extends Verb{\n    public String text;\n\n    public Enable(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object object = Environment.environment.get(\"Object\");\n        Object attribute = Environment.environment.get(\"Attribute\");\n        if (attribute == null){\n            System.out.println(\"启用工具\" + object.toString());\n        }else {\n            switch(object.toString()){\n                case \"工具\":\n                    System.out.println(\"启用工具ID为\" + attribute.toString());\n                    break;\n                default:\n                    res = false;\n                    System.out.println(\"语义不正确\");\n                    break;\n            }\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-22 17:32:00', 1);
INSERT INTO `bls_node` VALUES (42, 'SendMsg', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.fy.bl.environment.Environment;\n\npublic class SendMsg extends Verb{\n    public String text;\n\n    public SendMsg(String text) {\n        this.text = text;\n    }\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object object = Environment.environment.get(\"Object\");\n        Object attribute = Environment.environment.get(\"Attribute\");\n        System.out.println(\"通知/发消息** ***\");\n        return res;\n    }\n}', 4, 4, '2021-06-22 17:33:26', 1);
INSERT INTO `bls_node` VALUES (43, 'Accept', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.fy.bl.environment.Environment;\n\npublic class Accept extends Verb{\n    public String text;\n\n    public Accept(String text){\n        this.text = text;\n    }\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object object = Environment.environment.get(\"Object\");\n        Object adverbial = Environment.environment.get(\"Adverbial\");\n        System.out.println(\"调用拉人接口\");\n        return res;\n    }\n}', 4, 4, '2021-06-22 17:34:36', 1);
INSERT INTO `bls_node` VALUES (44, 'Dispatch', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.fy.bl.environment.Environment;\n\npublic class Dispatch extends Verb{\n    public String text;\n\n    public Dispatch(String text) {\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object object = Environment.environment.get(\"Object\");\n        if (object instanceof String){\n            switch(object.toString()){\n                case \"部门\":\n                    System.out.println(\"派遣成员到部门\");\n                    break;\n                case \"子部门\":\n                    System.out.println(\"派遣成员到子部门\");\n                    break;\n                default:\n                    res = false;\n                    System.out.println(\"语义不正确\");\n                    break;\n            }\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-22 17:36:48', 1);
INSERT INTO `bls_node` VALUES (45, 'Publish', ' com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.fy.bl.environment.Environment;\n\npublic class Publish extends Verb{\n    public String text;\n\n    public Publish(String text) {\n        this.text = text;\n    }\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object object = Environment.environment.get(\"Object\");\n        if (Environment.environment.get(\"Adverbial\") != null) {\n            Object adverbial = Environment.environment.get(\"Adverbial\");\n            System.out.println(\"把**发布到**\");\n        }else {\n            Object attribute = Environment.environment.get(\"Attribute\");\n            System.out.println(\"发布给** ***\");\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-22 17:37:39', 1);
INSERT INTO `bls_node` VALUES (46, 'CancelPub', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.fy.bl.environment.Environment;\n\npublic class CancelPub extends Verb{\n    public String text;\n\n    public CancelPub(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object object = Environment.environment.get(\"Object\");\n        System.out.println(\"取消发布***\");\n        return res;\n    }\n}\n', 4, 4, '2021-06-22 17:38:28', 1);
INSERT INTO `bls_node` VALUES (47, 'Exist', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'public class Exist extends Verb{\n    public String text;\n\n    public Exist(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 17:39:12', 1);
INSERT INTO `bls_node` VALUES (48, 'NotExist', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'public class NotExist extends Verb{\n    public String text;\n\n    public NotExist(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 17:40:30', 1);
INSERT INTO `bls_node` VALUES (49, 'Appear', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.fy.bl.environment.Environment;\n\nimport java.util.List;\n\npublic class Appear extends Verb{\n    public String text;\n\n    public Appear(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object object = Environment.environment.get(\"Object\");\n        Object subject = Environment.environment.get(\"Subject\");\n        if (object instanceof List) {\n            System.out.println(\"出现在 ** 和 ** 中\");\n        }else{\n            System.out.println(\"出现在 *** 中\");\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-22 17:41:24', 1);
INSERT INTO `bls_node` VALUES (50, 'Have', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'import com.fy.bl.environment.Environment;\n\npublic class Have extends Verb{\n    public String text;\n\n    public Have(String text){\n        this.text = text;\n    }\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object subject = Environment.environment.get(\"Subject\");\n        Object adverbial = Environment.environment.get(\"Adverbial\");\n        Object attribute = Environment.environment.get(\"Attribute\");\n        Object obj = Environment.environment.get(\"Object\");\n        if (subject != null && adverbial != null && attribute != null && obj != null){\n            switch (obj.toString()){\n                case \"角色\":\n                    System.out.println(\"要拥有的角色类型\" + attribute.toString());\n                    break;\n                default:\n                    res = false;\n                    break;\n            }\n        }else{\n            res = false;\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-22 17:42:21', 1);
INSERT INTO `bls_node` VALUES (51, 'Incumbent', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.adjective', 'public class Incumbent extends Adjective{\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}\n', 4, 4, '2021-06-22 17:44:43', 1);
INSERT INTO `bls_node` VALUES (52, 'Leaved', ' com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.adjective', 'public class Leaved extends Adjective{\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-22 17:45:36', 1);
INSERT INTO `bls_node` VALUES (53, 'Script', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.script', 'public class Script implements Node {\n\n    public List<Stmt> stmtList = new ArrayList<>();\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        for (Stmt stmt: stmtList) {\n            if(res){\n                res = stmt.run(\"\");\n            }\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-23 15:45:57', 1);
INSERT INTO `bls_node` VALUES (54, 'Stmt', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.Script', 'import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.Node;\n\npublic class Stmt implements Node{\n\n    @Override\n    public boolean run(String methodName) {\n        return false;\n    }\n}', 4, 4, '2021-06-23 15:49:47', 1);
INSERT INTO `bls_node` VALUES (55, 'SimpleStmt', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.script', 'public class SimpleStmt extends Stmt{\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-23 15:49:37', 1);
INSERT INTO `bls_node` VALUES (56, 'SubPreAttrObjStmt', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.sentence.simpleStmt', 'import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Attribute;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Obj;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Predicate;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Subject;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.script.SimpleStmt;\n\npublic class SubPreAttrObjStmt extends SimpleStmt {\n\n    public Subject subject;\n    public Predicate predicate;\n    public Attribute attribute;\n    public Obj obj;\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        if (subject != null){\n            res = subject.run(methodName);\n        }\n        if (res){\n            res = obj.run(methodName);\n        }\n        if (res){\n            res = attribute.run(methodName);\n        }\n        if (res){\n            res = predicate.run(methodName);\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-25 16:15:23', 1);
INSERT INTO `bls_node` VALUES (57, 'Subject', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element', 'import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.common.Identifier;\n\npublic class Subject extends Element{\n\n    public Long loginUser;\n    public Identifier identifier;\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        if (identifier != null) {\n            res = identifier.run(methodName);\n            if (res){\n                Environment.environment.put(\"Subject\", Environment.environment.get(\"Identifier\"));\n            }\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-25 16:26:07', 1);
INSERT INTO `bls_node` VALUES (58, 'Predicate', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element', 'public class Predicate extends Element{\n\n    public Verb verb;\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = false;\n        res = verb.run(methodName);\n        return res;\n    }\n}', 4, 4, '2021-06-25 16:27:22', 1);
INSERT INTO `bls_node` VALUES (59, 'Attribute', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element', 'import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.adjective.Adjective;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.common.Identifier;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.common.Str;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Noun;\n\npublic class Attribute extends Element{\n\n    public Adjective adjective;\n    public Str str;\n    public Identifier identifier;\n    public Noun noun;\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = false;\n        String s = \"\";\n        if (adjective != null){\n            res = adjective.run(methodName);\n            s = \"Adjective\";\n        }\n        if (str != null){\n            res = str.run(methodName);\n            s = \"Str\";\n        }\n        if (identifier != null){\n            res = identifier.run(methodName);\n            s = \"Identifier\";\n        }\n        if (noun != null){\n            res = noun.run(methodName);\n            s = \"Noun\";\n        }\n        if(res){\n            Object o = Environment.environment.get(s);\n            Environment.environment.put(\"Attribute\", o);\n            Environment.environment.remove(s);\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-25 16:29:09', 1);
INSERT INTO `bls_node` VALUES (60, 'Obj', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element', 'public class Obj extends Element{\n\n    public ObjOfObj objOfObj;\n    public ObjWithObj objWithObj;\n    public Num num;\n    public Str str;\n    public Identifier identifier;\n    public Noun noun;\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = false;\n        String s = \"\";\n        if (objOfObj != null){\n            res = objOfObj.run(methodName);\n            s = \"ObjOfObj\";\n        }\n        if (objWithObj != null){\n            res = objWithObj.run(methodName);\n            s = \"ObjWithObj\";\n        }\n        if (num != null){\n            res = num.run(methodName);\n            s = \"Num\";\n        }\n        if (str != null){\n            res = str.run(methodName);\n            s = \"Str\";\n        }\n        if (identifier != null){\n            res = identifier.run(methodName);\n            s = \"Identifier\";\n        }\n        if (noun != null){\n            res = noun.run(methodName);\n            s = \"Noun\";\n        }\n        if(res){\n            Object o = Environment.environment.get(s);\n            Environment.environment.put(\"Object\", o);//o environmentobject\n            Environment.environment.remove(s);\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-25 16:30:10', 1);
INSERT INTO `bls_node` VALUES (61, 'Verb', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb', 'public class Verb extends Word {\n\n    @Override\n    public boolean run(String methodName) {\n        return true;\n    }\n}', 4, 4, '2021-06-25 16:31:58', 1);
INSERT INTO `bls_node` VALUES (62, 'Noun', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun', 'import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.Word;\n\npublic class Noun extends Word {\n\n    @Override\n    public boolean run(String methodName) {\n        Environment.environment.put(\"Noun\", super.text);\n        return true;\n    }\n}', 4, 4, '2021-06-25 16:33:17', 1);
INSERT INTO `bls_node` VALUES (63, 'Adjective', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.adjective', 'import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.Word;\n\npublic class Adjective extends Word {\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-25 16:34:33', 1);
INSERT INTO `bls_node` VALUES (64, 'SubAdvPreAttrObjStmt', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.sentence.simpleStmt', 'import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.*;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.script.SimpleStmt;\n\npublic class SubAdvPreAttrObjStmt extends SimpleStmt {\n\n    public Subject subject;\n    public Adverbial adverbial;\n    public Predicate predicate;\n    public Attribute attribute;\n    public Obj obj;\n\n    @Override\n    public boolean run(String methodName) {\n        //ignore methodName\n        boolean res = false;\n        res = adverbial.run(methodName);\n        if (res){\n            if (subject != null){\n                res = subject.run(methodName);\n            }\n            res = obj.run(methodName);\n\n            if (attribute != null){\n                res = attribute.run(methodName);\n            }\n            if (res){\n                res = predicate.run(methodName);\n            }\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-25 16:37:16', 1);
INSERT INTO `bls_node` VALUES (65, 'Adverbial', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element', 'import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.phrase.PlaceAdv;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.phrase.PreposObj;\n\npublic class Adverbial extends Element{\n\n    public PlaceAdv placeAdv;\n    public PreposObj preposObj;\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = false;\n        if (placeAdv != null){\n            res = placeAdv.run(methodName);\n\n        }\n        if (preposObj != null){\n            res = preposObj.run(methodName);\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-25 16:38:41', 1);
INSERT INTO `bls_node` VALUES (66, 'PlaceAdv', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.phrase', 'import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Adverbial;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Obj;\n\npublic class PlaceAdv extends Adverbial {\n\n    public Obj obj;\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = false;\n        res = obj.run(methodName);\n        if (res){\n            Environment.environment.put(\"Adverbial\", Environment.environment.get(\"Object\"));\n            Environment.environment.remove(\"Object\");\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-25 16:40:40', 1);
INSERT INTO `bls_node` VALUES (67, 'PreposObj', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.phrase', 'import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Adverbial;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Attribute;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Obj;\n\npublic class PreposObj extends Adverbial {\n\n    public PlaceAdv placeAdv;\n    public Attribute attribute;\n    public Obj obj;\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        if (placeAdv != null){\n            res = placeAdv.run(methodName);\n            Environment.environment.put(\"PlaceAdv\", Environment.environment.get(\"Adverbial\"));\n            Environment.environment.remove(\"Adverbial\");\n        }\n        if (attribute != null){\n            res = attribute.run(methodName);\n        }\n        res = obj.run(methodName);\n        Environment.environment.put(\"PrePos\", Environment.environment.get(\"Object\"));\n        Environment.environment.remove(\"Object\");\n        return res;\n    }\n}', 4, 4, '2021-06-25 16:41:58', 1);
INSERT INTO `bls_node` VALUES (68, 'Show', 'com.fy.bandlanguage.node.word.real.verb', 'package com.fy.bandlanguage.node.word.real.verb;\n\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\n//\'显示\'\npublic class Show extends Verb {\n    @Override\n    public boolean run(String methodName) {\n        return show();\n    }\n\n    private boolean show(){\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj obj = environment.findWithDelete(\"宾语\");\n        if(obj == null){\n            return false;\n        }else {\n            obj = (BLObj)obj.value;\n        }\n        boolean res = environment.showForUser.add(obj.value.toString());\n        return res;\n    }\n}\n', 3, 3, '2021-06-25 16:46:14', 1);
INSERT INTO `bls_node` VALUES (69, 'Get', 'com.fy.bandlanguage.node.word.real.verb', 'package com.fy.bandlanguage.node.word.real.verb;\n\n\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\n//\'得到\'\npublic class Get extends Verb {\n    @Override\n    public boolean run(String methodName) {\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj obj = environment.findWithDelete(\"宾语\");\n        if(obj == null){\n            return false;\n        }else {\n            obj = (BLObj)obj.value;\n            environment.add(\"结果\",obj.value,obj.type, EnvironmentType.STACK);\n            return true;\n        }\n    }\n}\n', 3, 3, '2021-06-25 16:54:12', 1);
INSERT INTO `bls_node` VALUES (70, 'Set', 'com.fy.bandlanguage.node.word.real.verb', 'package com.fy.bandlanguage.node.word.real.verb;\n\n\n//\'设定\'\npublic class Set  extends Verb{\n    @Override\n    public boolean run(String methodName) {\n        return set();\n    }\n\n    /**\n     * 暂时没有在简单句中用到\n     * @return\n     */\n    private boolean set(){\n        return false;\n    }\n}\n', 3, 3, '2021-06-25 16:54:52', 1);
INSERT INTO `bls_node` VALUES (71, 'Change', 'com.fy.bandlanguage.node.word.real.verb', 'package com.fy.bandlanguage.node.word.real.verb;\n\npublic class Change extends Verb {\n}\n', 3, 3, '2021-06-25 16:55:42', 1);
INSERT INTO `bls_node` VALUES (72, 'Conjunction', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.conjunction', 'public class Conjunction extends Word {\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-25 16:58:27', 1);
INSERT INTO `bls_node` VALUES (73, 'NewObj', 'com.fy.bandlanguage.node.word.real.verb', 'package com.fy.bandlanguage.node.word.real.verb;\n\npublic class NewObj  extends Verb {\n}\n', 3, 3, '2021-06-25 16:58:40', 1);
INSERT INTO `bls_node` VALUES (74, 'And', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.conjunction', 'public class And extends Conjunction{\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}', 4, 4, '2021-06-25 16:58:49', 1);
INSERT INTO `bls_node` VALUES (75, 'Or', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.conjunction', 'public class Or extends Conjunction{\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);\n    }\n}\n', 4, 4, '2021-06-25 16:59:09', 1);
INSERT INTO `bls_node` VALUES (76, 'Rename', 'com.fy.bandlanguage.node.word.real.verb', 'package com.fy.bandlanguage.node.word.real.verb;\n\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\npublic class Rename extends Verb {\n\n    @Override\n    public boolean run(String methodName) {\n        return rename();\n    }\n\n    public boolean rename(){\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj object = environment.findWithDelete(\"宾语\");\n        BLObj target = environment.findWithDelete(\"目标\");\n        object = (BLObj)object.value;\n        object.key = target.value.toString();\n        return true;\n    }\n}\n', 3, 3, '2021-06-25 16:59:25', 1);
INSERT INTO `bls_node` VALUES (77, 'Num', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.common', 'import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.Word;\n\npublic class Num extends Word {\n\n    public int number;\n\n    @Override\n    public boolean run(String methodName) {\n        return super.run(methodName);//暂未作处理，需补充\n    }\n}', 4, 4, '2021-06-25 16:59:54', 1);
INSERT INTO `bls_node` VALUES (78, 'Find', 'com.fy.bandlanguage.node.word.real.verb', 'package com.fy.bandlanguage.node.word.real.verb;\n\n\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\n//\'找出\'\npublic class Find extends Verb{\n    @Override\n    public boolean run(String methodName) {\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj obj = environment.findWithDelete(\"宾语\");\n        if(obj == null){\n            return false;\n        }else {\n            obj = (BLObj)obj.value;\n        }\n        boolean res = environment.showForUser.add(obj.value.toString());\n        return res;\n    }\n}\n', 3, 3, '2021-06-25 17:00:17', 1);
INSERT INTO `bls_node` VALUES (79, 'Str', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.common', 'import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.Word;\n\npublic class Str extends Word {\n\n    public String text;\n\n    @Override\n    public boolean run(String methodName) {\n        Environment.environment.put(\"Str\", text.replace(\"‘\", \"\").replace(\"’\", \"\"));\n        return true;\n    }\n}', 4, 4, '2021-06-25 17:00:33', 1);
INSERT INTO `bls_node` VALUES (80, 'Remove', 'com.fy.bandlanguage.node.word.real.verb', 'package com.fy.bandlanguage.node.word.real.verb;\n\n\nimport com.alibaba.fastjson.JSONArray;\nimport com.alibaba.fastjson.JSONObject;\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\n//\'去掉\'\npublic class Remove extends Verb {\n\n    @Override\n    public boolean run(String methodName) {\n        return remove();\n    }\n\n    /**\n     * 如果有状语，则是在状语中删除对应的数据\n     * 没有状语，则在语境中删除宾语所值的对象\n     * @return\n     */\n    private boolean remove(){\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj bing = environment.findWithDelete(\"宾语\");\n        BLObj zhuang = environment.findWithDelete(\"状语\");\n        //没有宾语\n        if(bing == null){\n            return false;\n        }else {\n            bing = (BLObj)bing.value;\n        }\n        if(zhuang == null){\n            //没有状语，则是删除语境中宾语所对应的具体内容\n            boolean delete = false;\n            //如果删除成功则后面的删除不会执行\n            delete = environment.delete(bing.key, EnvironmentType.MEMORY)\n                    || environment.delete(bing.key, EnvironmentType.BAND)\n                    || environment.delete(bing.key, EnvironmentType.ORGANIZATION);\n            return delete;\n        }else{\n            //有状语，一般是在状语所指定的对象中，删除和后面宾语相同的部分数据\n            zhuang = (BLObj)zhuang.value;\n            if(zhuang.type == BLObjType.RESULT_JSONARRAY){\n                if(bing.type == BLObjType.RESULT_JSONARRAY){\n                    //两者都是数组，则是删除记录\n                    try {\n                        JSONArray all = JSONArray.parseArray(zhuang.value.toString());\n                        JSONArray part = JSONArray.parseArray(bing.value.toString());\n                        all = deleteRecordInArray(all,part);\n                        return environment.update(zhuang.key,zhuang.key,all,BLObjType.RESULT_JSONARRAY,null);\n                    }catch (Exception e){\n                        return false;\n                    }\n                }else if(bing.type == BLObjType.RESULT_STRING){\n                    //原对象是数组，宾语是字符串，则是删除属性\n                    try {\n                        JSONArray all = JSONArray.parseArray(zhuang.value.toString());\n                        all = deleteAttrInArray(all,bing.value.toString());\n                        return environment.update(zhuang.key,zhuang.key,all,BLObjType.RESULT_JSONARRAY,null);\n                    }catch (Exception e){\n                        return false;\n                    }\n                }else {\n                    //暂时没有其他情况\n                    return false;\n                }\n            }else if(zhuang.type == BLObjType.RESULT_JSONOBJECT){\n                //如果是对象，则只能是删除属性\n                if(bing.type == BLObjType.RESULT_STRING){\n                    try {\n                        JSONObject all = JSONObject.parseObject(zhuang.value.toString());\n                        all.remove(bing.value.toString());\n                        return environment.update(zhuang.key,zhuang.key,all,BLObjType.RESULT_JSONOBJECT,null);\n                    }catch (Exception e){\n                        return false;\n                    }\n                }else {\n                    //暂时没有其他情况\n                    return false;\n                }\n            }else {\n                //状语不是上面两种\n                return false;\n            }\n        }\n    }\n\n    /**\n     * 在数组集合中，删除部分记录\n     * @param all 原数组\n     * @param part 待删除数组\n     * @return\n     */\n    private JSONArray deleteRecordInArray(JSONArray all, JSONArray part){\n        if(all == null || part == null){\n            return all;\n        }\n        for (JSONObject a : part.toJavaList(JSONObject.class)){\n            all.remove(a);\n        }\n        return all;\n    }\n\n    /**\n     * 在数组集合中，删除某个属性\n     * @param all 原数组\n     * @param attribute 待删除的属性\n     * @return\n     */\n    private JSONArray deleteAttrInArray(JSONArray all, String attribute){\n        if(all == null || attribute == null){\n            return all;\n        }\n        for (JSONObject a : all.toJavaList(JSONObject.class)){\n            a.remove(attribute);\n        }\n        return all;\n    }\n}\n', 3, 3, '2021-06-25 17:00:57', 1);
INSERT INTO `bls_node` VALUES (81, 'Identifier', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.common', 'import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;\nimport com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.Word;\n\npublic class Identifier extends Word {\n\n    public String text;\n\n    @Override\n    public boolean run(String methodName) {\n        boolean res = true;\n        Object o = Environment.environment.get(text);\n        if (o == null || o.toString().equals(\"\")){\n            System.out.println(\"从语境获取失败\");\n            res = false;\n        }else {\n            Environment.environment.put(\"Identifier\", o);\n        }\n        return res;\n    }\n}', 4, 4, '2021-06-25 17:02:05', 1);
INSERT INTO `bls_node` VALUES (82, 'Word', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word', 'import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.Node;\n\npublic class Word implements Node {\n    public String text;\n    @Override\n    public boolean run(String methodName) {\n        return false;\n    }\n}', 4, 4, '2021-06-25 17:03:06', 1);
INSERT INTO `bls_node` VALUES (83, 'Node', 'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node', 'public interface Node {\n\n    boolean run(String methodName);\n}\n', 4, 4, '2021-06-25 17:03:33', 1);
INSERT INTO `bls_node` VALUES (84, 'Count', 'com.fy.bandlanguage.node.word.real.verb', 'package com.fy.bandlanguage.node.word.real.verb;\n\n\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\n//\'统计\'\npublic class Count extends Verb {\n    @Override\n    public boolean run(String methodName) {\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj obj = environment.findWithDelete(\"宾语\");\n        if(obj == null){\n            return false;\n        }else {\n            obj = (BLObj)obj.value;\n        }\n        boolean res = environment.showForUser.add(obj.value.toString());\n        return res;\n    }\n}\n', 3, 3, '2021-06-26 15:51:16', 1);
INSERT INTO `bls_node` VALUES (85, 'Group', 'com.fy.bandlanguage.node.word.real.verb', 'package com.fy.bandlanguage.node.word.real.verb;\n\n//\'进行分组\'\npublic class Group extends Verb {\n}\n', 3, 3, '2021-06-26 16:14:24', 1);
INSERT INTO `bls_node` VALUES (86, 'Merge', 'com.fy.bandlanguage.node.word.real.verb', 'package com.fy.bandlanguage.node.word.real.verb;\n\nimport com.alibaba.fastjson.JSONArray;\nimport com.alibaba.fastjson.JSONObject;\nimport com.fy.bandlanguage.antlrfile.BLParser;\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\nimport jdk.nashorn.internal.scripts.JS;\n\nimport java.util.HashMap;\nimport java.util.HashSet;\nimport java.util.LinkedList;\nimport java.util.List;\n\npublic class Merge extends Verb {\n    @Override\n    public boolean run(String methodName) {\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj object = environment.findWithDelete(\"宾语\");\n        //没有宾语\n        if(object == null){\n            return false;\n        }\n        object = (BLObj) object.value;\n        //不是多个对象\n        if(object.type != BLObjType.RESULT_JSONARRAY){\n            return false;\n        }\n        JSONArray objects = (JSONArray)object.value;\n        BLObj target = environment.findWithDelete(\"目标\");\n        String newName = target.value.toString();\n        BLObj condition = environment.findWithDelete(\"条件\");\n        String cond = null;\n        if(condition != null){\n            cond = condition.value.toString();\n        }\n        return merge(objects,newName,cond);\n    }\n\n    private boolean merge(JSONArray objects,String name,String condition){\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj one = (BLObj) objects.get(0);\n        //暂时不考虑类型不一致，数据错误等问题\n        if(one.type == BLObjType.RESULT_JSONARRAY){\n            //集合之间的合并\n            if(condition == null){\n                //直接增加\n                JSONArray res = new JSONArray();\n                for (int i=0;i<objects.size();i++){\n                    BLObj obji = (BLObj)objects.get(i);\n                    res.addAll((JSONArray)obji.value);\n                }\n                environment.add(name,res,BLObjType.RESULT_JSONARRAY, EnvironmentType.MEMORY);\n                return true;\n            }else {\n                //连接\n                List<HashSet<String>> listSet = new LinkedList<>();\n                for (int i=0;i<objects.size();i++){\n                    HashSet<String> a = new HashSet<>();\n                    BLObj obji = (BLObj)objects.get(i);\n                    JSONArray va = (JSONArray)obji.value;\n                    for(int j=0;j<va.size();j++){\n                        a.add(((JSONObject)va.get(j)).get(condition).toString());\n                    }\n                    listSet.add(a);\n                }\n                for(int i=1;i<listSet.size();i++){\n                    HashSet<String> first = listSet.get(0);\n                    HashSet<String> second = listSet.get(i);\n                    first.retainAll(second);\n                }\n                HashSet<String> all = listSet.get(0); //所有集合都包含的属性值\n                HashMap<String,JSONObject> res = new HashMap<>();\n                BLObj obji = (BLObj)objects.get(0);\n                JSONArray va = (JSONArray)obji.value;\n                for(int j=0;j<va.size();j++){\n                    JSONObject oneObj = (JSONObject)va.get(j);\n                    if(all.contains(oneObj.getString(condition))){\n                        res.put(oneObj.getString(condition),oneObj);\n                    }\n                }\n                for (int i=1;i<objects.size();i++){\n                    BLObj x = (BLObj)objects.get(i);\n                    JSONArray y = (JSONArray)x.value;\n                    for(int j=0;j<y.size();j++){\n                        JSONObject yj = (JSONObject)y.get(j);\n                        if(all.contains(yj.getString(condition))){\n                            JSONObject aa = res.get(yj.getString(condition));\n                            aa.putAll(yj);\n                            res.put(yj.getString(condition),aa);\n                        }\n                    }\n                }\n                JSONArray jsonArray = new JSONArray();\n                for(String a : res.keySet()){\n                    jsonArray.add(res.get(a));\n                }\n                environment.add(name,jsonArray,BLObjType.RESULT_JSONARRAY, EnvironmentType.MEMORY);\n                return true;\n            }\n        }else if(one.type == BLObjType.RESULT_JSONOBJECT){\n            //单一对象之间的合并\n            JSONObject res = new JSONObject();\n            for (int i=0;i<objects.size();i++){\n                BLObj obji = (BLObj)objects.get(i);\n                res.putAll((JSONObject)obji.value);\n            }\n            environment.add(name,res,BLObjType.RESULT_JSONOBJECT, EnvironmentType.MEMORY);\n            return true;\n        }else {\n            return false;\n        }\n    }\n}', 3, 3, '2021-06-26 16:26:06', 1);
INSERT INTO `bls_node` VALUES (87, 'Execute', 'com.fy.bandlanguage.node.word.real.verb', 'package com.fy.bandlanguage.node.word.real.verb;\n\n\nimport com.alibaba.fastjson.JSONArray;\nimport com.alibaba.fastjson.JSONObject;\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\nimport com.fy.bandlanguage.node.script.Stmt;\n\nimport java.util.LinkedList;\nimport java.util.List;\n\n//\'执行\'\npublic class Execute extends Verb {\n    @Override\n    public boolean run(String methodName) {\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj obj = environment.findWithDelete(\"宾语\");\n        if(obj == null ){\n            return false;\n        }else {\n            obj = (BLObj)obj.value;\n        }\n        //如果是设定的剧本\n        if(obj.type == BLObjType.Node){\n            try {\n                Stmt script = (Stmt)obj.value;\n                return script.run(null);\n            }catch (Exception e){\n                return false;\n            }\n        }\n\n        //如果是工具ID\n        if(obj.type == BLObjType.TOOLID){\n            String toolID = obj.value.toString();\n            //判断是否有设定参数\n            BLObj params = environment.find(\"参数\", EnvironmentType.STACK);\n            JSONObject pa = null;\n            if(params != null && params.type == BLObjType.RESULT_JSONOBJECT){\n                pa = JSONObject.parseObject(params.value.toString());\n            }\n            //判断是否有设定具体执行哪些\n            BLObj toolPart = environment.find(\"指定接口\", EnvironmentType.STACK);\n            LinkedList<String> to = new LinkedList<String>();\n            if(toolPart != null){\n                if(toolPart.type == BLObjType.RESULT_JSONARRAY){\n                    //是数组，则表明指定了多个接口\n                    JSONArray jsonArray = JSONArray.parseArray(toolPart.value.toString());\n                    for (BLObj a : jsonArray.toJavaList(BLObj.class)){\n                        if(a.type == BLObjType.RESULT_STRING){\n                            //如果是string类型，则认为是指定的要获取的结果的名称\n                            to.add(a.value.toString());\n                        }\n                    }\n                }\n                if(toolPart.type == BLObjType.RESULT_STRING){\n                    //是字符串，则是仅指定一个\n                    to.add(toolPart.value.toString());\n                }\n\n            }\n\n            try {\n                return runTool(toolID,pa,to);\n            }catch (Exception e){\n                return false;\n            }\n        }\n        //如果是其他情况，暂时返回false\n        return false;\n    }\n\n    /**\n     * 根据工具ID和参数列表，执行工具，得到的结果先放在栈中\n     * @param toolID 工具ID\n     * @param params 参数列表\n     * @param params 用户可能指定的具体接口\n     * @return\n     */\n    public boolean runTool(String toolID, JSONObject params, List<String> toolPart){\n        Environment environment = EnvironmentConst.environment.get();\n        if(toolID.equals(\"专家查询工具\") && params.containsKey(\"姓名\")){\n            //返回查询的专家列表\n            JSONArray array = new JSONArray();\n            JSONObject a1 = new JSONObject();\n            a1.put(\"姓名\",\"张三\");\n            a1.put(\"id\",\"123\");\n            a1.put(\"所属机构\",\"学校A\");\n            array.add(a1);\n\n            JSONObject a2 = new JSONObject();\n            a2.put(\"姓名\",\"张三1\");\n            a2.put(\"id\",\"001\");\n            a2.put(\"所属机构\",\"学校B\");\n            array.add(a2);\n\n            JSONObject a3 = new JSONObject();\n            a3.put(\"姓名\",\"张三2\");\n            a3.put(\"id\",\"002\");\n            a3.put(\"所属机构\",\"学校C\");\n            array.add(a3);\n            environment.add(toolPart.get(0),array,BLObjType.RESULT_JSONARRAY,EnvironmentType.MEMORY);\n            return true;\n        }\n        if(toolID.equals(\"专家查询工具\") && params.containsKey(\"ID\")){\n            JSONObject a1 = new JSONObject();\n            a1.put(\"姓名\",\"张三\");\n            a1.put(\"id\",\"123\");\n            a1.put(\"所属机构\",\"学校A\");\n            JSONArray paper = new JSONArray();\n            JSONObject p1 = new JSONObject();\n            p1.put(\"标题\",\"论文A标题\");\n            p1.put(\"链接\",\"论文A链接\");\n            paper.add(p1);\n            JSONObject p2 = new JSONObject();\n            p2.put(\"标题\",\"论文B标题\");\n            p2.put(\"链接\",\"论文B链接\");\n            paper.add(p2);\n            a1.put(\"论文成果\",paper);\n            environment.add(toolPart.get(0),a1,BLObjType.RESULT_JSONOBJECT,EnvironmentType.MEMORY);\n            return true;\n        }\n\n        if(toolID.equals(\"论文查询工具\") && params.containsKey(\"关键字\")){\n            JSONArray array = new JSONArray();\n            JSONObject a1 = new JSONObject();\n            a1.put(\"论文ID\",1);\n            a1.put(\"论文标题\",\"论文A\");\n            a1.put(\"论文链接\",\"论文A链接\");\n            array.add(a1);\n\n            JSONObject a2 = new JSONObject();\n            a2.put(\"论文ID\",2);\n            a2.put(\"论文标题\",\"论文B\");\n            a2.put(\"论文链接\",\"论文B链接\");\n            array.add(a2);\n\n            JSONObject a3 = new JSONObject();\n            a3.put(\"论文ID\",3);\n            a3.put(\"论文标题\",\"论文C\");\n            a3.put(\"论文链接\",\"论文C链接\");\n            array.add(a3);\n            environment.add(toolPart.get(0),array,BLObjType.RESULT_JSONARRAY,EnvironmentType.MEMORY);\n            return true;\n        }\n\n        if(toolID.equals(\"科技论文影响力指数查看工具\") && params.containsKey(\"论文标题\")){\n            JSONArray array = new JSONArray();\n            JSONObject a1 = new JSONObject();\n            a1.put(\"论文标题\",\"论文A\");\n            a1.put(\"被引量\",27);\n            a1.put(\"影响力\",0);\n            array.add(a1);\n\n            JSONObject a2 = new JSONObject();\n            a2.put(\"论文标题\",\"论文B\");\n            a2.put(\"被引量\",12);\n            a2.put(\"影响力\",10);\n            array.add(a2);\n\n            JSONObject a3 = new JSONObject();\n            a3.put(\"论文标题\",\"论文C\");\n            a3.put(\"被引量\",21);\n            a3.put(\"影响力\",12);\n            array.add(a3);\n            environment.add(toolPart.get(0),array,BLObjType.RESULT_JSONARRAY,EnvironmentType.MEMORY);\n            return true;\n        }\n\n        if(toolID.equals(\"论文参考文献评价分析工具\") && params.containsKey(\"论文标题\")){\n            JSONArray array = new JSONArray();\n            JSONObject a1 = new JSONObject();\n            a1.put(\"论文标题\",\"论文A\");\n            a1.put(\"参考文献得分\",7);\n            array.add(a1);\n\n            JSONObject a2 = new JSONObject();\n            a2.put(\"论文标题\",\"论文B\");\n            a2.put(\"参考文献得分\",7);\n            array.add(a2);\n\n            JSONObject a3 = new JSONObject();\n            a3.put(\"论文标题\",\"论文C\");\n            a3.put(\"参考文献得分\",5);\n            array.add(a3);\n            environment.add(toolPart.get(0),array,BLObjType.RESULT_JSONARRAY,EnvironmentType.MEMORY);\n            return true;\n        }\n\n        if(toolID.equals(\"消息通知工具\") && params.containsKey(\"用户ID\")){\n            JSONObject a1 = new JSONObject();\n            a1.put(\"发送结果\",\"发送成功\");\n            environment.add(toolPart.get(0),a1,BLObjType.RESULT_JSONOBJECT,EnvironmentType.MEMORY);\n            return true;\n        }\n        if(toolID.equals(\"绩效考核工具\")){\n            JSONArray array = new JSONArray();\n            JSONObject a1 = new JSONObject();\n            a1.put(\"员工ID\",1);\n            a1.put(\"配送快递数量\",15);\n            array.add(a1);\n\n            JSONObject a2 = new JSONObject();\n            a2.put(\"员工ID\",2);\n            a2.put(\"配送快递数量\",7);\n            array.add(a2);\n\n            JSONObject a3 = new JSONObject();\n            a3.put(\"员工ID\",3);\n            a3.put(\"配送快递数量\",12);\n            array.add(a3);\n            environment.add(toolPart.get(0),array,BLObjType.RESULT_JSONARRAY,EnvironmentType.MEMORY);\n            return true;\n        }\n        if(toolID.equals(\"快递管理工具\")){\n            JSONArray array = new JSONArray();\n            JSONObject a1 = new JSONObject();\n            a1.put(\"快递单号\",1);\n            a1.put(\"入库时间\",\"2021-3-11\");\n            array.add(a1);\n\n            JSONObject a2 = new JSONObject();\n            a2.put(\"快递单号\",2);\n            a2.put(\"入库时间\",\"2021-3-9\");\n            array.add(a2);\n            environment.add(toolPart.get(0),array,BLObjType.RESULT_JSONARRAY,EnvironmentType.MEMORY);\n            return true;\n        }\n        if(toolID.equals(\"任务分配工具\") && params.containsKey(\"员工ID\") && params.containsKey(\"快递单号\")){\n            JSONObject a1 = new JSONObject();\n            a1.put(\"任务新建结果\",\"成功\");\n            environment.add(toolPart.get(0),a1,BLObjType.RESULT_JSONOBJECT,EnvironmentType.MEMORY);\n            return true;\n        }\n\n        if(toolID.equals(\"任务分配工具\") && params.containsKey(\"员工ID\")){\n            JSONArray array = new JSONArray();\n            JSONObject a1 = new JSONObject();\n            a1.put(\"员工ID\",1);\n            a1.put(\"任务领取情况\", JSONArray.parse(\"[{\\\"领取时间\\\":\\\"2021-3-17\\\",\\\"任务ID\\\":3},{\\\"领取时间\\\":\\\"2021-3-12\\\",\\\"任务ID\\\":1},{\\\"领取时间\\\":\\\"2021-3-14\\\",\\\"任务ID\\\":2}]\"));\n            array.add(a1);\n\n            JSONObject a2 = new JSONObject();\n            a2.put(\"员工ID\",2);\n            a2.put(\"任务领取情况\", JSONArray.parse(\"[{\\\"领取时间\\\":\\\"2021-3-11\\\",\\\"任务ID\\\":4},{\\\"领取时间\\\":\\\"2021-3-1\\\",\\\"任务ID\\\":6},{\\\"领取时间\\\":\\\"2021-3-19\\\",\\\"任务ID\\\":5}]\"));\n            array.add(a2);\n            environment.add(toolPart.get(0),array,BLObjType.RESULT_JSONARRAY,EnvironmentType.MEMORY);\n            return true;\n        }\n\n\n        if(toolID.equals(\"摄像头工具\")){\n            environment.add(toolPart.get(0),\"图像\",BLObjType.RESULT_STRING,EnvironmentType.MEMORY);\n            return true;\n        }\n        if(toolID.equals(\"人脸识别工具\")){\n            JSONObject a = new JSONObject();\n            a.put(\"是否包含人脸\",true);\n            a.put(\"人脸数量\",2);\n            environment.add(toolPart.get(0),a,BLObjType.RESULT_JSONOBJECT,EnvironmentType.MEMORY);\n            return true;\n        }\n        return false;\n    }\n}', 3, 3, '2021-06-26 16:28:56', 1);
INSERT INTO `bls_node` VALUES (88, 'SortAscending', 'com.fy.bandlanguage.node.word.real.verb.sort', 'package com.fy.bandlanguage.node.word.real.verb.sort;\n\n\nimport com.fy.bandlanguage.node.word.real.verb.Verb;\n\n//\'升序排序\'\npublic class SortAscending extends Verb {\n}\n', 3, 3, '2021-06-26 16:31:50', 1);
INSERT INTO `bls_node` VALUES (89, 'SortDescending', 'com.fy.bandlanguage.node.word.real.verb.sort', 'package com.fy.bandlanguage.node.word.real.verb.sort;\n\n\nimport com.fy.bandlanguage.node.word.real.verb.Verb;\n\n//\'降序排序\'\npublic class SortDescending extends Verb {\n}', 3, 3, '2021-06-26 17:43:48', 1);
INSERT INTO `bls_node` VALUES (90, 'InputPart', 'com.fy.bandlanguage.node.word.real.noun', 'package com.fy.bandlanguage.node.word.real.noun;\n\n\nimport com.alibaba.fastjson.JSONObject;\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\n//\'输入部件\'\npublic class InputPart extends Noun {\n    @Override\n    public boolean run(String methodName) {\n        return inputPart();\n    }\n\n    private boolean inputPart(){\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj obj = environment.find(\"宾语\");\n        if(obj == null){\n            return false;\n        }else {\n            obj = (BLObj)obj.value;\n            if(obj.type != BLObjType.TOOLID){\n                return false;\n            }\n        }\n        String toolID = obj.value.toString();\n\n        JSONObject outPutPart = getInPutPart(toolID);\n        environment.add(this.text,outPutPart,BLObjType.RESULT_JSONOBJECT, EnvironmentType.STACK);\n        return true;\n    }\n\n    //调用帮区接口来得到相关信息\n    private JSONObject getInPutPart(String toolID){\n        return new JSONObject();\n    }\n}', 3, 3, '2021-06-26 17:47:27', 1);
INSERT INTO `bls_node` VALUES (91, 'OutputPart', 'com.fy.bandlanguage.node.word.real.noun', 'package com.fy.bandlanguage.node.word.real.noun;\n\n\nimport com.alibaba.fastjson.JSONObject;\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\n//\'输入部件\'\n//一般用到这个词，都是已经在前面指定是哪个工具了\n//用这个词的目的就是获取这个工具的所有输出部件的相关信息\npublic class OutputPart extends Noun {\n\n    @Override\n    public boolean run(String methodName) {\n        return outputPart();\n    }\n\n    private boolean outputPart(){\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj obj = environment.find(\"宾语\");\n        if(obj == null){\n            return false;\n        }else {\n            obj = (BLObj)obj.value;\n            if(obj.type != BLObjType.TOOLID){\n                return false;\n            }\n        }\n        String toolID = obj.value.toString();\n\n        JSONObject outPutPart = getOutPutPart(toolID);\n        environment.add(this.text,outPutPart,BLObjType.RESULT_JSONOBJECT, EnvironmentType.STACK);\n        return true;\n    }\n\n    //调用帮区接口来得到相关信息\n    private JSONObject getOutPutPart(String toolID){\n        return new JSONObject();\n    }\n\n}', 3, 3, '2021-06-26 17:48:56', 1);
INSERT INTO `bls_node` VALUES (92, 'Element', 'com.fy.bandlanguage.node.word.real.noun', 'package com.fy.bandlanguage.node.word.real.noun;\n\n\nimport com.alibaba.fastjson.JSONArray;\nimport com.alibaba.fastjson.JSONObject;\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\nimport com.fy.bandlanguage.node.Node;\n\n//\'元素\'\npublic class Element extends Noun {\n    @Override\n    public boolean run(String methodName) {\n        return getElement();\n    }\n\n    private boolean getElement(){\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj zhuang = environment.find(\"状语\", EnvironmentType.STACK);\n        //没有或者类型不对\n        if(zhuang == null || zhuang.type != BLObjType.BLObj){\n            return false;\n        }else {\n            zhuang = (BLObj)zhuang.value;\n            if(zhuang.type != BLObjType.RESULT_JSONARRAY){\n                return false;\n            }\n        }\n        JSONArray val = JSONArray.parseArray(zhuang.value.toString());\n\n        BLObj obj = environment.find(\"定语\",EnvironmentType.STACK);\n\n        //如果有定语，一般是要将宾语进行过滤的\n        if(obj != null){\n            obj = (BLObj)obj.value;\n            Node ding = (Node)obj.value;\n            JSONArray newVal = new JSONArray();\n            for (int i=0;i<val.size();i++){\n                JSONObject a = val.getJSONObject(i);\n                BLObj jl = new BLObj(this.text,a,BLObjType.RESULT_JSONOBJECT);\n                environment.add(\"宾语\",jl,BLObjType.BLObj,EnvironmentType.STACK);\n                boolean runRes = ding.run(\"compare\");\n                if(!runRes){\n                    return false;\n                }\n                BLObj res = environment.findWithDelete(\"结果\");\n                if(res == null || res.type != BLObjType.RESULT_BOOLEAN){\n                    return false;\n                }\n                if((Boolean)res.value){\n                    newVal.add(a);\n                }\n                environment.delete(\"宾语\",EnvironmentType.STACK);\n            }\n            val = newVal;\n        }\n        environment.add(this.text,val,BLObjType.RESULT_JSONARRAY, EnvironmentType.STACK);\n        return true;\n    }\n\n}', 3, 3, '2021-06-26 17:51:14', 1);
INSERT INTO `bls_node` VALUES (93, 'Amount', 'com.fy.bandlanguage.node.word.real.noun', 'package com.fy.bandlanguage.node.word.real.noun;\n\n\nimport com.alibaba.fastjson.JSONArray;\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\n//\'数量\'\npublic class Amount extends Noun {\n    @Override\n    public boolean run(String methodName) {\n        return getAmount();\n    }\n\n    private boolean getAmount(){\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj obj = environment.find(\"宾语\");\n        obj = (BLObj)obj.value;\n        //没有或者类型不对\n        if(obj == null || obj.type != BLObjType.RESULT_JSONARRAY){\n            return false;\n        }\n\n        try {\n            JSONArray res = JSONArray.parseArray(obj.value.toString());\n            environment.add(this.text,res.size(),BLObjType.RESULT_INTEGER, EnvironmentType.STACK);\n            return true;\n        }catch (Exception e){\n            return false;\n        }\n\n    }\n}', 3, 3, '2021-06-26 17:53:42', 1);
INSERT INTO `bls_node` VALUES (94, 'Max', 'com.fy.bandlanguage.node.word.real.noun', 'package com.fy.bandlanguage.node.word.real.noun;\n\n\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\nimport java.util.ArrayList;\nimport java.util.Comparator;\nimport java.util.LinkedList;\nimport java.util.List;\n\n//\'最大值\'\npublic class Max extends Noun {\n    @Override\n    public boolean run(String methodName) {\n        return min();\n    }\n\n    private boolean min(){\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj obj = environment.find(\"宾语\");\n        if(obj == null){\n            return false;\n        }else {\n            obj = (BLObj)obj.value;\n            if(obj.type != BLObjType.RESULT_LIST){\n                return false;\n            }\n        }\n        List<Integer> list = new LinkedList<>();\n\n        //判断是否是数字列表\n        if (obj.value instanceof ArrayList<?>) {\n            try {\n                list = (List<Integer>) obj.value;\n            }catch (Exception e){\n                //不能转换为数字\n                return false;\n            }\n        }else {\n            return false;\n        }\n        list.sort(new Comparator<Integer>() {\n            @Override\n            public int compare(Integer o1, Integer o2) {\n                if(o1 > o2){\n                    return -1;\n                }else if(o1 == o2){\n                    return 0;\n                }else {\n                    return 1;\n                }\n\n            }\n        });\n        environment.add(this.text,list.get(0), BLObjType.RESULT_INTEGER, EnvironmentType.STACK);\n        return true;\n    }\n}', 3, 3, '2021-06-26 17:55:18', 1);
INSERT INTO `bls_node` VALUES (95, 'Min', 'com.fy.bandlanguage.node.word.real.noun', 'package com.fy.bandlanguage.node.word.real.noun;\n\n\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\nimport java.util.ArrayList;\nimport java.util.Comparator;\nimport java.util.LinkedList;\nimport java.util.List;\n\n//\'最小值\'\npublic class Min extends Noun {\n\n    @Override\n    public boolean run(String methodName) {\n        return min();\n    }\n\n    private boolean min(){\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj obj = environment.find(\"宾语\");\n        if(obj == null){\n            return false;\n        }else {\n            obj = (BLObj)obj.value;\n            if(obj.type != BLObjType.RESULT_LIST){\n                return false;\n            }\n        }\n        List<Integer> list = new LinkedList<>();\n\n        //判断是否是数字列表\n        if (obj.value instanceof ArrayList<?>) {\n            try {\n                list = (List<Integer>) obj.value;\n            }catch (Exception e){\n                //不能转换为数字\n                return false;\n            }\n        }else {\n            return false;\n        }\n        list.sort(new Comparator<Integer>() {\n            @Override\n            public int compare(Integer o1, Integer o2) {\n                if(o1 > o2){\n                    return 1;\n                }else if(o1 == o2){\n                    return 0;\n                }else {\n                    return -1;\n                }\n\n            }\n        });\n        environment.add(this.text,list.get(0),BLObjType.RESULT_INTEGER, EnvironmentType.STACK);\n        return true;\n    }\n}', 3, 3, '2021-06-26 17:56:37', 1);
INSERT INTO `bls_node` VALUES (96, 'Average', 'com.fy.bandlanguage.node.word.real.noun', 'package com.fy.bandlanguage.node.word.real.noun;\n\n\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\nimport java.util.ArrayList;\nimport java.util.LinkedList;\nimport java.util.List;\n\n//\'平均值\'\npublic class Average extends Noun {\n\n    @Override\n    public boolean run(String methodName) {\n        return avg();\n    }\n\n    private boolean avg(){\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj obj = environment.find(\"宾语\");\n        if(obj == null || obj.type != BLObjType.BLObj){\n            return false;\n        }\n        obj = (BLObj)obj.value;\n        if(obj == null || obj.type != BLObjType.RESULT_LIST){\n            return false;\n        }\n        List<Integer> list = new LinkedList<>();\n\n        //判断是否是数字列表\n        if (obj.value instanceof ArrayList<?>) {\n            try {\n                list = (List<Integer>) obj.value;\n            }catch (Exception e){\n                //不能转换为数字\n                return false;\n            }\n        }else {\n            return false;\n        }\n        int total = 0;\n        for(Integer a : list){\n            total += a;\n        }\n        total = total/list.size();\n        environment.add(this.text,total, BLObjType.RESULT_INTEGER, EnvironmentType.STACK);\n        return true;\n    }\n\n}', 3, 3, '2021-06-26 17:57:55', 1);
INSERT INTO `bls_node` VALUES (97, 'NoEquals', 'com.fy.bandlanguage.node.word.real.compare', 'package com.fy.bandlanguage.node.word.real.compare;\n\n\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\n//\'不等于\'\npublic class NoEquals extends CompareWord {\n    @Override\n    public boolean run(String methodName) {\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj left = environment.findWithDelete(\"左值\");\n        BLObj right = environment.findWithDelete(\"右值\");\n        if(left == null || right == null){\n            return false;\n        }\n        left = (BLObj)left.value;\n        right = (BLObj)right.value;\n        //全部转换为字符串进行比较\n        if(!left.value.toString().equals(right.value.toString())){\n            environment.add(\"结果\",true, BLObjType.RESULT_BOOLEAN, EnvironmentType.STACK);\n        }else {\n            environment.add(\"结果\",false, BLObjType.RESULT_BOOLEAN,EnvironmentType.STACK);\n        }\n        return true;\n    }\n}', 3, 3, '2021-06-26 20:51:35', 1);
INSERT INTO `bls_node` VALUES (98, 'MoreThan', 'com.fy.bandlanguage.node.word.real.compare', 'package com.fy.bandlanguage.node.word.real.compare;\n\n\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\n//\'大于\'\npublic class MoreThan extends CompareWord {\n\n    @Override\n    public boolean run(String methodName) {\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj left = environment.findWithDelete(\"左值\");\n        BLObj right = environment.findWithDelete(\"右值\");\n        if(left == null || right == null){\n            return false;\n        }\n        left = (BLObj)left.value;\n        right = (BLObj)right.value;\n        Integer l,r;\n        try {\n            l = Integer.valueOf(left.value.toString());\n            r = Integer.valueOf(right.value.toString());\n        }catch (Exception e){\n            //不能转换为数字\n            return false;\n        }\n\n        if(l>r){\n            environment.add(\"结果\",true, BLObjType.RESULT_BOOLEAN, EnvironmentType.STACK);\n        }else {\n            environment.add(\"结果\",false, BLObjType.RESULT_BOOLEAN,EnvironmentType.STACK);\n        }\n        return true;\n    }\n}', 3, 3, '2021-06-26 20:53:09', 1);
INSERT INTO `bls_node` VALUES (99, 'NoMoreThan', 'com.fy.bandlanguage.node.word.real.compare', 'package com.fy.bandlanguage.node.word.real.compare;\n\n\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\n//\'不大于\'\npublic class NoMoreThan extends CompareWord {\n\n    @Override\n    public boolean run(String methodName) {\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj left = environment.findWithDelete(\"左值\");\n        BLObj right = environment.findWithDelete(\"右值\");\n        if(left == null || right == null){\n            return false;\n        }\n        left = (BLObj)left.value;\n        right = (BLObj)right.value;\n        Integer l,r;\n        try {\n            l = Integer.valueOf(left.value.toString());\n            r = Integer.valueOf(right.value.toString());\n        }catch (Exception e){\n            //不能转换为数字\n            return false;\n        }\n\n        if(l<=r){\n            environment.add(\"结果\",true, BLObjType.RESULT_BOOLEAN, EnvironmentType.STACK);\n        }else {\n            environment.add(\"结果\",false, BLObjType.RESULT_BOOLEAN,EnvironmentType.STACK);\n        }\n        return true;\n    }\n\n}', 3, 3, '2021-06-26 20:54:25', 1);
INSERT INTO `bls_node` VALUES (100, 'LessThan', 'com.fy.bandlanguage.node.word.real.compare', 'package com.fy.bandlanguage.node.word.real.compare;\n\n\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\n//\'小于\'\npublic class LessThan extends CompareWord {\n    @Override\n    public boolean run(String methodName) {\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj left = environment.findWithDelete(\"左值\");\n        BLObj right = environment.findWithDelete(\"右值\");\n        if(left == null || right == null){\n            return false;\n        }\n        left = (BLObj)left.value;\n        right = (BLObj)right.value;\n        Integer l,r;\n        try {\n            l = Integer.valueOf(left.value.toString());\n            r = Integer.valueOf(right.value.toString());\n        }catch (Exception e){\n            //不能转换为数字\n            return false;\n        }\n\n        if(l<r){\n            environment.add(\"结果\",true, BLObjType.RESULT_BOOLEAN, EnvironmentType.STACK);\n        }else {\n            environment.add(\"结果\",false, BLObjType.RESULT_BOOLEAN,EnvironmentType.STACK);\n        }\n        return true;\n    }\n}', 3, 3, '2021-06-26 20:55:37', 1);
INSERT INTO `bls_node` VALUES (101, 'NoLessThan', 'com.fy.bandlanguage.node.word.real.compare', 'package com.fy.bandlanguage.node.word.real.compare;\n\n\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\nimport com.fy.bandlanguage.environment.wetoband.BLObj;\n\n//\'不小于\'\npublic class NoLessThan extends CompareWord {\n\n    @Override\n    public boolean run(String methodName) {\n        Environment environment = EnvironmentConst.environment.get();\n        BLObj left = environment.findWithDelete(\"左值\");\n        BLObj right = environment.findWithDelete(\"右值\");\n        if(left == null || right == null){\n            return false;\n        }\n        left = (BLObj)left.value;\n        right = (BLObj)right.value;\n\n        Integer l,r;\n        try {\n            l = Integer.valueOf(left.value.toString());\n            r = Integer.valueOf(right.value.toString());\n        }catch (Exception e){\n            //不能转换为数字\n            return false;\n        }\n\n        if(l>=r){\n            environment.add(\"结果\",true, BLObjType.RESULT_BOOLEAN, EnvironmentType.STACK);\n        }else {\n            environment.add(\"结果\",false, BLObjType.RESULT_BOOLEAN,EnvironmentType.STACK);\n        }\n        return true;\n    }\n\n}', 3, 3, '2021-06-26 20:57:01', 1);
INSERT INTO `bls_node` VALUES (102, 'Number', 'com.fy.bandlanguage.node.word.real.numerals', 'package com.fy.bandlanguage.node.word.real.numerals;\n\n\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\n\n//\'数字\'\npublic class Number extends Numerals {\n\n    @Override\n    public boolean run(String methodName) {\n        Environment environment = EnvironmentConst.environment.get();\n        try {\n            Integer num = Integer.valueOf(this.text);\n            if (num != null){\n                environment.add(this.text,num, BLObjType.RESULT_INTEGER, EnvironmentType.STACK);\n                return true;\n            }else {\n                return false;\n            }\n        }catch (Exception e){\n            return false;\n        }\n    }\n}', 3, 3, '2021-06-26 20:59:59', 1);
INSERT INTO `bls_node` VALUES (103, 'Str', 'com.fy.bandlanguage.node.word', 'package com.fy.bandlanguage.node.word;\n\nimport com.fy.bandlanguage.environment.Environment;\nimport com.fy.bandlanguage.environment.EnvironmentConst;\nimport com.fy.bandlanguage.environment.staticMessage.BLObjType;\nimport com.fy.bandlanguage.environment.staticMessage.EnvironmentType;\n\n//字符串\npublic class Str extends Word {\n    @Override\n    public boolean run(String methodName) {\n        Environment environment = EnvironmentConst.environment.get();\n        String word = this.text.substring(1,this.text.length()-1);\n        environment.add(this.text,word, BLObjType.RESULT_STRING, EnvironmentType.STACK);\n        return true;\n//\n//        if(this.text. charAt(0) == \'‘\' && this.text.charAt(this.text.length()-1) == \'’\'){\n//            //如果是被中文单引号包含，则认为是取字符串本身\n//\n//        }\n//        BLObj blObj = environment.find(this.text);\n//        if(blObj == null){\n//            environment.showForUser.add(\"在语境中未找到:\"+this.text);\n//            return false;\n//        }else {\n//            environment.add(this.text,blObj.value,blObj.type, EnvironmentType.STACK);\n//            return true;\n//        }\n    }\n}', 3, 3, '2021-06-26 21:03:32', 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_node_user
-- ----------------------------
DROP TABLE IF EXISTS `bls_node_user`;
CREATE TABLE `bls_node_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `node_id` bigint NOT NULL COMMENT '节点id',
  `user_id` bigint NOT NULL COMMENT '参与创建或修改的用户ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态：0：禁用，1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_node_user
-- ----------------------------
BEGIN;
INSERT INTO `bls_node_user` VALUES (1, 1, 4, '2021-06-22 14:32:35', 1);
INSERT INTO `bls_node_user` VALUES (2, 2, 4, '2021-06-22 14:36:10', 1);
INSERT INTO `bls_node_user` VALUES (3, 3, 4, '2021-06-22 14:38:54', 1);
INSERT INTO `bls_node_user` VALUES (4, 4, 4, '2021-06-22 14:41:57', 1);
INSERT INTO `bls_node_user` VALUES (5, 5, 4, '2021-06-22 14:45:37', 1);
INSERT INTO `bls_node_user` VALUES (6, 6, 4, '2021-06-22 14:47:25', 1);
INSERT INTO `bls_node_user` VALUES (7, 7, 4, '2021-06-22 14:49:15', 1);
INSERT INTO `bls_node_user` VALUES (8, 8, 4, '2021-06-22 14:52:09', 1);
INSERT INTO `bls_node_user` VALUES (9, 9, 4, '2021-06-22 14:54:24', 1);
INSERT INTO `bls_node_user` VALUES (10, 10, 4, '2021-06-22 14:57:04', 1);
INSERT INTO `bls_node_user` VALUES (11, 11, 4, '2021-06-22 14:59:16', 1);
INSERT INTO `bls_node_user` VALUES (12, 12, 4, '2021-06-22 15:00:53', 1);
INSERT INTO `bls_node_user` VALUES (13, 13, 4, '2021-06-22 15:03:23', 1);
INSERT INTO `bls_node_user` VALUES (14, 14, 4, '2021-06-22 15:06:40', 1);
INSERT INTO `bls_node_user` VALUES (15, 15, 4, '2021-06-22 15:08:48', 1);
INSERT INTO `bls_node_user` VALUES (16, 16, 4, '2021-06-22 15:19:20', 1);
INSERT INTO `bls_node_user` VALUES (17, 17, 4, '2021-06-22 15:24:28', 1);
INSERT INTO `bls_node_user` VALUES (18, 18, 4, '2021-06-22 15:26:06', 1);
INSERT INTO `bls_node_user` VALUES (19, 19, 4, '2021-06-22 15:28:04', 1);
INSERT INTO `bls_node_user` VALUES (20, 20, 4, '2021-06-22 16:14:07', 1);
INSERT INTO `bls_node_user` VALUES (21, 21, 4, '2021-06-22 16:26:20', 1);
INSERT INTO `bls_node_user` VALUES (22, 22, 4, '2021-06-22 16:27:38', 1);
INSERT INTO `bls_node_user` VALUES (23, 23, 4, '2021-06-22 16:28:42', 1);
INSERT INTO `bls_node_user` VALUES (24, 24, 4, '2021-06-22 16:29:42', 1);
INSERT INTO `bls_node_user` VALUES (25, 25, 4, '2021-06-22 16:32:54', 1);
INSERT INTO `bls_node_user` VALUES (26, 26, 4, '2021-06-22 16:33:57', 1);
INSERT INTO `bls_node_user` VALUES (27, 27, 4, '2021-06-22 16:46:39', 1);
INSERT INTO `bls_node_user` VALUES (28, 28, 4, '2021-06-22 17:07:26', 1);
INSERT INTO `bls_node_user` VALUES (29, 29, 4, '2021-06-22 17:09:43', 1);
INSERT INTO `bls_node_user` VALUES (30, 30, 4, '2021-06-22 17:17:13', 1);
INSERT INTO `bls_node_user` VALUES (31, 31, 4, '2021-06-22 17:18:07', 1);
INSERT INTO `bls_node_user` VALUES (32, 32, 4, '2021-06-22 17:19:04', 1);
INSERT INTO `bls_node_user` VALUES (33, 33, 4, '2021-06-22 17:20:47', 1);
INSERT INTO `bls_node_user` VALUES (34, 34, 4, '2021-06-22 17:24:11', 1);
INSERT INTO `bls_node_user` VALUES (35, 35, 4, '2021-06-22 17:25:18', 1);
INSERT INTO `bls_node_user` VALUES (36, 36, 4, '2021-06-22 17:27:35', 1);
INSERT INTO `bls_node_user` VALUES (37, 37, 4, '2021-06-22 17:28:20', 1);
INSERT INTO `bls_node_user` VALUES (38, 38, 4, '2021-06-22 17:29:11', 1);
INSERT INTO `bls_node_user` VALUES (39, 39, 4, '2021-06-22 17:29:53', 1);
INSERT INTO `bls_node_user` VALUES (40, 40, 4, '2021-06-22 17:30:38', 1);
INSERT INTO `bls_node_user` VALUES (41, 41, 4, '2021-06-22 17:32:00', 1);
INSERT INTO `bls_node_user` VALUES (42, 42, 4, '2021-06-22 17:33:26', 1);
INSERT INTO `bls_node_user` VALUES (43, 43, 4, '2021-06-22 17:34:36', 1);
INSERT INTO `bls_node_user` VALUES (44, 44, 4, '2021-06-22 17:36:48', 1);
INSERT INTO `bls_node_user` VALUES (45, 45, 4, '2021-06-22 17:37:39', 1);
INSERT INTO `bls_node_user` VALUES (46, 46, 4, '2021-06-22 17:38:28', 1);
INSERT INTO `bls_node_user` VALUES (47, 47, 4, '2021-06-22 17:39:12', 1);
INSERT INTO `bls_node_user` VALUES (48, 48, 4, '2021-06-22 17:40:30', 1);
INSERT INTO `bls_node_user` VALUES (49, 49, 4, '2021-06-22 17:41:24', 1);
INSERT INTO `bls_node_user` VALUES (50, 50, 4, '2021-06-22 17:42:21', 1);
INSERT INTO `bls_node_user` VALUES (51, 51, 4, '2021-06-22 17:44:43', 1);
INSERT INTO `bls_node_user` VALUES (52, 52, 4, '2021-06-22 17:45:36', 1);
INSERT INTO `bls_node_user` VALUES (53, 53, 4, '2021-06-23 15:45:57', 1);
INSERT INTO `bls_node_user` VALUES (54, 54, 4, '2021-06-23 15:49:47', 1);
INSERT INTO `bls_node_user` VALUES (55, 55, 4, '2021-06-23 15:49:38', 1);
INSERT INTO `bls_node_user` VALUES (56, 56, 4, '2021-06-25 16:15:23', 1);
INSERT INTO `bls_node_user` VALUES (57, 57, 4, '2021-06-25 16:26:07', 1);
INSERT INTO `bls_node_user` VALUES (58, 58, 4, '2021-06-25 16:27:22', 1);
INSERT INTO `bls_node_user` VALUES (59, 59, 4, '2021-06-25 16:29:09', 1);
INSERT INTO `bls_node_user` VALUES (60, 60, 4, '2021-06-25 16:30:10', 1);
INSERT INTO `bls_node_user` VALUES (61, 61, 4, '2021-06-25 16:31:58', 1);
INSERT INTO `bls_node_user` VALUES (62, 62, 4, '2021-06-25 16:33:17', 1);
INSERT INTO `bls_node_user` VALUES (63, 63, 4, '2021-06-25 16:34:33', 1);
INSERT INTO `bls_node_user` VALUES (64, 64, 4, '2021-06-25 16:37:16', 1);
INSERT INTO `bls_node_user` VALUES (65, 65, 4, '2021-06-25 16:38:41', 1);
INSERT INTO `bls_node_user` VALUES (66, 66, 4, '2021-06-25 16:40:40', 1);
INSERT INTO `bls_node_user` VALUES (67, 67, 4, '2021-06-25 16:41:58', 1);
INSERT INTO `bls_node_user` VALUES (68, 68, 3, '2021-06-25 16:46:15', 1);
INSERT INTO `bls_node_user` VALUES (69, 69, 3, '2021-06-25 16:54:12', 1);
INSERT INTO `bls_node_user` VALUES (70, 70, 3, '2021-06-25 16:54:52', 1);
INSERT INTO `bls_node_user` VALUES (71, 71, 3, '2021-06-25 16:55:42', 1);
INSERT INTO `bls_node_user` VALUES (72, 72, 4, '2021-06-25 16:58:27', 1);
INSERT INTO `bls_node_user` VALUES (73, 73, 3, '2021-06-25 16:58:40', 1);
INSERT INTO `bls_node_user` VALUES (74, 74, 4, '2021-06-25 16:58:49', 1);
INSERT INTO `bls_node_user` VALUES (75, 75, 4, '2021-06-25 16:59:09', 1);
INSERT INTO `bls_node_user` VALUES (76, 76, 3, '2021-06-25 16:59:25', 1);
INSERT INTO `bls_node_user` VALUES (77, 77, 4, '2021-06-25 16:59:54', 1);
INSERT INTO `bls_node_user` VALUES (78, 78, 3, '2021-06-25 17:00:17', 1);
INSERT INTO `bls_node_user` VALUES (79, 79, 4, '2021-06-25 17:00:33', 1);
INSERT INTO `bls_node_user` VALUES (80, 80, 3, '2021-06-25 17:00:57', 1);
INSERT INTO `bls_node_user` VALUES (81, 81, 4, '2021-06-25 17:02:05', 1);
INSERT INTO `bls_node_user` VALUES (82, 82, 4, '2021-06-25 17:03:07', 1);
INSERT INTO `bls_node_user` VALUES (83, 83, 4, '2021-06-25 17:03:33', 1);
INSERT INTO `bls_node_user` VALUES (84, 84, 3, '2021-06-26 15:51:16', 1);
INSERT INTO `bls_node_user` VALUES (85, 85, 3, '2021-06-26 16:14:24', 1);
INSERT INTO `bls_node_user` VALUES (86, 86, 3, '2021-06-26 16:26:06', 1);
INSERT INTO `bls_node_user` VALUES (87, 87, 3, '2021-06-26 16:28:56', 1);
INSERT INTO `bls_node_user` VALUES (88, 88, 3, '2021-06-26 16:31:50', 1);
INSERT INTO `bls_node_user` VALUES (89, 89, 3, '2021-06-26 17:43:48', 1);
INSERT INTO `bls_node_user` VALUES (90, 90, 3, '2021-06-26 17:47:27', 1);
INSERT INTO `bls_node_user` VALUES (91, 91, 3, '2021-06-26 17:48:56', 1);
INSERT INTO `bls_node_user` VALUES (92, 92, 3, '2021-06-26 17:51:14', 1);
INSERT INTO `bls_node_user` VALUES (93, 93, 3, '2021-06-26 17:53:42', 1);
INSERT INTO `bls_node_user` VALUES (94, 94, 3, '2021-06-26 17:55:18', 1);
INSERT INTO `bls_node_user` VALUES (95, 95, 3, '2021-06-26 17:56:37', 1);
INSERT INTO `bls_node_user` VALUES (96, 96, 3, '2021-06-26 17:57:55', 1);
INSERT INTO `bls_node_user` VALUES (97, 97, 3, '2021-06-26 20:51:35', 1);
INSERT INTO `bls_node_user` VALUES (98, 98, 3, '2021-06-26 20:53:09', 1);
INSERT INTO `bls_node_user` VALUES (99, 99, 3, '2021-06-26 20:54:25', 1);
INSERT INTO `bls_node_user` VALUES (100, 100, 3, '2021-06-26 20:55:37', 1);
INSERT INTO `bls_node_user` VALUES (101, 101, 3, '2021-06-26 20:57:01', 1);
INSERT INTO `bls_node_user` VALUES (102, 102, 3, '2021-06-26 20:59:59', 1);
INSERT INTO `bls_node_user` VALUES (103, 103, 3, '2021-06-26 21:03:32', 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_paradigm
-- ----------------------------
DROP TABLE IF EXISTS `bls_paradigm`;
CREATE TABLE `bls_paradigm` (
  `paradigm_id` bigint NOT NULL AUTO_INCREMENT,
  `sentence_id` bigint NOT NULL COMMENT '该范式所对应的句型ID',
  `easy_paradigm` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '中间范式的形式',
  `example` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '这个范式的相关举例',
  `creator_id` bigint NOT NULL COMMENT '创建者的用户ID',
  `editor_id` bigint NOT NULL COMMENT '最近一次修改者的用户ID',
  `update_time` datetime DEFAULT NULL COMMENT '最近一次修改的修改时间',
  `status` int NOT NULL DEFAULT '1' COMMENT '0：禁用 1：正常',
  PRIMARY KEY (`paradigm_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of bls_paradigm
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for bls_role
-- ----------------------------
DROP TABLE IF EXISTS `bls_role`;
CREATE TABLE `bls_role` (
  `role_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一区分帮语网站角色',
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `dept_id` bigint NOT NULL COMMENT '场景区id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态  0：禁用，1：正常',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_role
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for bls_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `bls_role_dept`;
CREATE TABLE `bls_role_dept` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '表唯一标识',
  `role_id` bigint NOT NULL COMMENT '角色id',
  `dept_id` bigint NOT NULL COMMENT '部门id(场景区id)',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态  0：禁用  1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_role_dept
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for bls_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `bls_role_menu`;
CREATE TABLE `bls_role_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '表唯一标识',
  `role_id` bigint NOT NULL COMMENT '角色id',
  `menu_id` bigint NOT NULL COMMENT '菜单id',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态  0：禁用  1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_role_menu
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for bls_rule
-- ----------------------------
DROP TABLE IF EXISTS `bls_rule`;
CREATE TABLE `bls_rule` (
  `rule_id` bigint NOT NULL AUTO_INCREMENT,
  `rule` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规则符号',
  `chinese_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '中文名称',
  `express` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规则表达式',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '关于该规则的相关描述',
  `code` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `creator_id` bigint NOT NULL COMMENT '创建者的用户id',
  `editor_id` bigint NOT NULL COMMENT '最近一次编辑者id',
  `update_time` datetime DEFAULT NULL COMMENT '最近一次更新时间',
  `status` int NOT NULL DEFAULT '1' COMMENT '0:禁用 1：待开发 2： 开发中 3：待审核 4：待发布 5：已发布',
  PRIMARY KEY (`rule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_rule
-- ----------------------------
BEGIN;
INSERT INTO `bls_rule` VALUES (1, 'Organization', '机构', '\'机构\'', '词汇规则-机构', 'wordMap.put(\'机构\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Organization\');', 4, 4, '2021-06-22 14:26:39', 1);
INSERT INTO `bls_rule` VALUES (2, 'Department', '部门', '\'部门\'', '词汇规则-部门', 'wordMap.put(\'部门\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Department\');', 4, 4, '2021-06-22 14:35:05', 1);
INSERT INTO `bls_rule` VALUES (3, 'ParentDepartment', '父部门', '\'父部门\'', '词汇规则-父部门', 'wordMap.put(\'父部门\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.ParentDepartment\');', 4, 4, '2021-06-22 14:38:19', 1);
INSERT INTO `bls_rule` VALUES (4, 'SuperiorDepartment', '上级部门', '\'上级部门\'', '词汇规则-上级部门', 'wordMap.put(\'上级部门\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.SuperiorDepartment\');', 4, 4, '2021-06-22 14:41:07', 1);
INSERT INTO `bls_rule` VALUES (5, 'SubDepartment', '子部门', '\'子部门\' | \'下级部门\'', '词汇规则-子部门', 'wordMap.put(\'子部门\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.SubDepartment\');', 4, 4, '2021-06-22 14:45:21', 1);
INSERT INTO `bls_rule` VALUES (6, 'Band', '帮区', '\'帮区\'', '词汇规则-帮区', 'wordMap.put(\'帮区\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Band\');', 4, 4, '2021-06-22 14:46:51', 1);
INSERT INTO `bls_rule` VALUES (7, 'ParentBand', '父帮区', '\'父帮区\'', '词汇规则-父帮区', 'wordMap.put(\'父帮区\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.ParentBand\');', 4, 4, '2021-06-22 14:48:41', 1);
INSERT INTO `bls_rule` VALUES (8, 'SubBand', '子帮区', '\'子帮区\'', '词汇规则-子帮区', 'wordMap.put(\'子帮区\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.SubBand\');', 4, 4, '2021-06-22 14:51:39', 1);
INSERT INTO `bls_rule` VALUES (9, 'Position', '岗位', '\'岗位\'', '词汇规则-岗位', 'wordMap.put(\'岗位\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Position\');', 4, 4, '2021-06-22 14:53:50', 1);
INSERT INTO `bls_rule` VALUES (10, 'Member', '成员', '\'成员\'', '词汇规则-成员', 'wordMap.put(\'成员\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Member\');', 4, 4, '2021-06-22 14:55:49', 1);
INSERT INTO `bls_rule` VALUES (11, 'Tool', '工具', '\'工具\'', '词汇规则-工具', 'wordMap.put(\'工具\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Tool\');', 4, 4, '2021-06-22 14:58:44', 1);
INSERT INTO `bls_rule` VALUES (12, 'Role', '角色', '\'角色\'', '词汇规则-角色', 'wordMap.put(\'角色\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Role\');', 4, 4, '2021-06-22 15:00:27', 1);
INSERT INTO `bls_rule` VALUES (13, 'Authority', '权限', '\'权限\'', '词汇规则-权限', 'wordMap.put(\'权限\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Authority\');', 4, 4, '2021-06-22 15:02:45', 1);
INSERT INTO `bls_rule` VALUES (14, 'Speaker', '言者', '\'言者\'', '词汇规则-言者', 'wordMap.put(\'言者\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Speaker\');', 4, 4, '2021-06-22 15:05:58', 1);
INSERT INTO `bls_rule` VALUES (15, 'Reader', '读者', '\'读者\'', '词汇规则-读者', 'wordMap.put(\'读者\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Reader\');', 4, 4, '2021-06-22 15:08:11', 1);
INSERT INTO `bls_rule` VALUES (16, 'Writer', '写者', '\'写者\'', '词汇规则-写者', 'wordMap.put(\'写者\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Writer\');', 4, 4, '2021-06-22 15:10:09', 1);
INSERT INTO `bls_rule` VALUES (17, 'Worker', '工者', '\'工者\'', '词汇规则-工者', 'wordMap.put(\'工者\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Worker\');', 4, 4, '2021-06-22 15:24:01', 1);
INSERT INTO `bls_rule` VALUES (18, 'Administrator', '管理员', '\'管理员\'', '词汇规则-管理员', 'wordMap.put(\'管理员\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Administrator\');', 4, 4, '2021-06-22 15:25:36', 1);
INSERT INTO `bls_rule` VALUES (19, 'Drama', '剧本', '\'剧本\'', '词汇规则-剧本', 'wordMap.put(\'剧本\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Drama\');', 4, 4, '2021-06-22 15:27:19', 1);
INSERT INTO `bls_rule` VALUES (20, 'File', '文档', '\'文档\'', '词汇规则-文档', 'wordMap.put(\'文档\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.File\');', 4, 4, '2021-06-22 16:13:03', 1);
INSERT INTO `bls_rule` VALUES (21, 'Chatroom', '消息板', '\'消息板\'', '词汇规则-消息板', 'wordMap.put(\'消息板\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Chatroom\');', 4, 4, '2021-06-22 16:25:49', 1);
INSERT INTO `bls_rule` VALUES (22, 'MaxAuthority', '最大权限', '\'最高权限\' | \'最大权限\'', '词汇规则-\'最高权限\'', 'wordMap.put(\'最大权限\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.MaxAuthority\');', 4, 4, '2021-06-22 16:27:13', 1);
INSERT INTO `bls_rule` VALUES (23, 'MinAuthority', '最小权限', '\'最小权限\' | \'最低权限\'', '最小权限', 'wordMap.put(\'最小权限\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.MinAuthority\');', 4, 4, '2021-06-22 16:28:15', 1);
INSERT INTO `bls_rule` VALUES (24, 'Deadline', '有效期', '\'有效期\' | \'有效时长\'', '有效期', 'wordMap.put(\'有效期\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Deadline\');', 4, 4, '2021-06-22 16:29:17', 1);
INSERT INTO `bls_rule` VALUES (25, 'NewStaff', '新员工', '\'新员工\'', '新员工', 'wordMap.put(\'新员工\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.NewStaff\');\n', 4, 4, '2021-06-22 16:31:53', 1);
INSERT INTO `bls_rule` VALUES (26, 'SeniorStaff', '老员工', '\'老员工\'', '老员工', 'wordMap.put(\'老员工\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.SeniorStaff\');', 4, 4, '2021-06-22 16:33:30', 1);
INSERT INTO `bls_rule` VALUES (27, 'Show', '显示', '\'显示\' | \'列出\' | \'查看\'', '显示', 'wordMap.put(\'显示\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Show\');', 4, 1, '2021-06-23 15:59:12', 1);
INSERT INTO `bls_rule` VALUES (28, 'Establish', '创建', '\'创建\' | \'新建\' | \'新增\'', '创建', 'wordMap.put(\'创建\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Establish\');', 4, 4, '2021-06-22 16:51:25', 1);
INSERT INTO `bls_rule` VALUES (29, 'Join', '添加', '\'添加\' | \'加入\' | \'加入到\' | \'拉入\' | \'拉入到\'', '添加', 'wordMap.put(\'添加\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Join\');', 4, 4, '2021-06-22 17:08:31', 1);
INSERT INTO `bls_rule` VALUES (30, 'Revoke', '撤消', '\'撤消\' | \'撤消掉\'', '撤消', 'wordMap.put(\'撤消\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Revoke\');', 4, 4, '2021-06-22 17:10:26', 1);
INSERT INTO `bls_rule` VALUES (31, 'Set', '设定', '\'设定\'', '设定', 'wordMap.put(\'设定\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Set\');', 4, 4, '2021-06-22 17:17:54', 1);
INSERT INTO `bls_rule` VALUES (32, 'Change', '更换', '\'更换\' | \'更换到\'', '更换', 'wordMap.put(\'更换\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Change\');', 4, 4, '2021-06-22 17:18:42', 1);
INSERT INTO `bls_rule` VALUES (33, 'Edit', '修改', '\'修改\' | \'修改为\'', '修改', 'wordMap.put(\'修改\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Edit\');', 4, 4, '2021-06-22 17:20:28', 1);
INSERT INTO `bls_rule` VALUES (34, 'Delete', '删除', '\'移除\' | \'删除\' | \'剔除\' | \'去除\' | \'删掉\'', '删除', 'wordMap.put(\'删除\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Delete\');', 4, 4, '2021-06-22 17:23:48', 1);
INSERT INTO `bls_rule` VALUES (35, 'Merge', '合并', '\'合并\' | \'合并为\' | \'合并到\'', '合并', 'wordMap.put(\'合并\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Merge\');', 4, 4, '2021-06-22 17:25:01', 1);
INSERT INTO `bls_rule` VALUES (36, 'Move', '移动', '\'移动\' | \'移动到\'', '移动', 'wordMap.put(\'移动\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Move\');', 4, 4, '2021-06-22 17:26:03', 1);
INSERT INTO `bls_rule` VALUES (37, 'Appoint', '任命', '\'任命\' | \'安排\'', '任命', 'wordMap.put(\'任命\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Appoint\');', 4, 4, '2021-06-22 17:28:04', 1);
INSERT INTO `bls_rule` VALUES (38, 'Relieve', '免除', '\'免除\'', '免除', 'wordMap.put(\'免除\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Relieve\');', 4, 4, '2021-06-22 17:28:52', 1);
INSERT INTO `bls_rule` VALUES (39, 'Grant', '授予', '\'授予\'', '授予', 'wordMap.put(\'授予\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Grant\');', 4, 4, '2021-06-22 17:29:40', 1);
INSERT INTO `bls_rule` VALUES (40, 'Disable', '停用', '\'停用\'', '停用', 'wordMap.put(\'停用\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Disable\');', 4, 4, '2021-06-22 17:30:23', 1);
INSERT INTO `bls_rule` VALUES (41, 'Enable', '启用', '\'启用\'', '启用', 'wordMap.put(\'启用\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Enable\');', 4, 4, '2021-06-22 17:31:36', 1);
INSERT INTO `bls_rule` VALUES (42, 'SendMsg', '发消息', '\'发消息\' | \'通知\'', '发消息', 'wordMap.put(\'发消息\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.SendMsg\');', 4, 4, '2021-06-22 17:33:11', 1);
INSERT INTO `bls_rule` VALUES (43, 'Accept', '吸收', '\'吸收\' | \'接纳\'', '吸收', 'wordMap.put(\'吸收\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Accept\');', 4, 4, '2021-06-22 17:34:13', 1);
INSERT INTO `bls_rule` VALUES (44, 'Dispatch', '派遣到', '\'派遣到\' | \'分派到\'', '派遣到', 'wordMap.put(\'派遣到\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Dispatch\');', 4, 4, '2021-06-22 17:36:34', 1);
INSERT INTO `bls_rule` VALUES (45, 'Publish', '发布', '\'发布\' | \'发布到\' | \'发布给\'', '发布', 'wordMap.put(\'发布\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Publish\');', 4, 4, '2021-06-22 17:37:21', 1);
INSERT INTO `bls_rule` VALUES (46, 'CancelPub', '取消发布', '\'取消发布\'', '取消发布', 'wordMap.put(\'取消发布\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.CancelPub\');', 4, 4, '2021-06-22 17:38:11', 1);
INSERT INTO `bls_rule` VALUES (47, 'Exist', '存在', '\'存在\'', '存在', 'wordMap.put(\'存在\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Exist\');', 4, 4, '2021-06-22 17:38:56', 1);
INSERT INTO `bls_rule` VALUES (48, 'NotExist', '不存在', '\'不存在\'', '不存在', 'wordMap.put(\'不存在\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.NotExist\');', 4, 4, '2021-06-22 17:40:14', 1);
INSERT INTO `bls_rule` VALUES (49, 'Appear', '出现', '\'出现\' | \'出现在\' | \'要出现在\'', '出现', 'wordMap.put(\'出现\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Appear\');', 4, 4, '2021-06-22 17:41:01', 1);
INSERT INTO `bls_rule` VALUES (50, 'Have', '拥有', '\'拥有\' | \'要拥有\'', '拥有', 'wordMap.put(\'拥有\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Have\');', 4, 4, '2021-06-22 17:42:07', 1);
INSERT INTO `bls_rule` VALUES (51, 'Incumbent', '在职的', '\'在职的\'', '在职的', 'wordMap.put(\'在职的\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.adjective.Incumbent\');', 4, 4, '2021-06-22 17:44:15', 1);
INSERT INTO `bls_rule` VALUES (52, 'Leaved', '离职的', '\'离职的\'', '离职的', 'wordMap.put(\'离职的\', \'com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.adjective.Leaved\');', 4, 4, '2021-06-22 17:45:15', 1);
INSERT INTO `bls_rule` VALUES (53, 'script', '剧本', '(stmt Dot?)+', '最顶层文法', '@Override\n    public Node visitScript(LanguageParser.ScriptContext ctx) {\n        Script script = new Script();\n        List<Stmt> tempList = new ArrayList<>();\n        for (int i = 0; i < ctx.stmt().size(); i++) {\n            tempList.add((Stmt) ctx.stmt(i).accept(this));\n        }\n        script.stmtList = tempList;\n        return script;\n    }', 4, 4, '2021-06-23 15:43:59', 1);
INSERT INTO `bls_rule` VALUES (54, 'stmt', '语句', 'simpleStmt | complexStmt', '语句包括简单句和复杂句', '@Override\n    public Node visitStmt(LanguageParser.StmtContext ctx) {\n        return ctx.getChild(0).accept(this);\n    }', 4, 4, '2021-06-23 15:46:42', 1);
INSERT INTO `bls_rule` VALUES (55, 'simpleStmt', '简单句', 'subject_predicate_object_stmt |\n            subject_predicate_attribute_object_stmt |\n            subject_adverbial_predicate_attribute_object_stmt |\n            subject_adverbial_predicate_complement_attribute_object_stmt |\n            judgeStmt;', '简单句包括了几种句式结构。', '@Override\n    public Node visitSimpleStmt(LanguageParser.SimpleStmtContext ctx) {\n        return ctx.getChild(0).accept(this);\n    }', 4, 4, '2021-06-23 15:49:05', 1);
INSERT INTO `bls_rule` VALUES (56, 'subject_predicate_attribute_object_stmt', '主谓定宾句', 'subject? predicate attribute object', '主语成分可省略', '@Override\n    public Node visitSubject_predicate_attribute_object_stmt(LanguageParser.Subject_predicate_attribute_object_stmtContext ctx) {\n        SubPreAttrObjStmt subPreAttrObjStmt = new SubPreAttrObjStmt();\n        if (ctx.subject() != null){\n            subPreAttrObjStmt.subject = (Subject) ctx.subject().accept(this);\n        }\n        subPreAttrObjStmt.predicate = (Predicate) ctx.predicate().accept(this);\n        subPreAttrObjStmt.attribute = (Attribute) ctx.attribute().accept(this);\n        subPreAttrObjStmt.obj = (Obj) ctx.object().accept(this);\n        return subPreAttrObjStmt;\n    }', 4, 4, '2021-06-25 16:13:36', 1);
INSERT INTO `bls_rule` VALUES (57, 'subject', '主语', 'Me | Identifier', '主语规则', '@Override\n    public Node visitSubject(LanguageParser.SubjectContext ctx) {\n        Subject subject = new Subject();\n        if (ctx.Identifier() != null){\n            subject.identifier = (Identifier) ctx.Identifier().accept(this);\n        }else{\n            subject.loginUser = 4032L;//暂时写死的\n        }\n        return subject;\n    }', 4, 4, '2021-06-25 16:25:02', 1);
INSERT INTO `bls_rule` VALUES (58, 'predicate', '谓语', 'verb', '谓语规则', '@Override\n    public Node visitPredicate(LanguageParser.PredicateContext ctx) {\n        Predicate predicate = new Predicate();\n        predicate.verb = (Verb) ctx.getChild(0).accept(this);\n        return predicate;\n    }', 4, 4, '2021-06-25 16:26:48', 1);
INSERT INTO `bls_rule` VALUES (59, 'attribute', '定语', 'adjective | String | Identifier | noun', '定语规则', '@Override\n    public Node visitAttribute(LanguageParser.AttributeContext ctx) {\n        Attribute attribute = new Attribute();\n        if (ctx.adjective() != null){\n            attribute.adjective = (Adjective) ctx.adjective().accept(this);\n        }else if (ctx.String() != null){\n            attribute.str = (Str) ctx.String().accept(this);\n        }else if(ctx.Identifier() != null){\n            attribute.identifier = (Identifier) ctx.Identifier().accept(this);\n        }else if(ctx.noun() != null){\n            attribute.noun = (Noun) ctx.noun().accept(this);\n        }\n        return attribute;\n    }', 4, 4, '2021-06-25 16:27:56', 1);
INSERT INTO `bls_rule` VALUES (60, 'object', '宾语', 'object With object |\n        object Of object |\n        Number | String | Identifier |\n        noun', '宾语规则', '@Override\n    public Node visitObject(LanguageParser.ObjectContext ctx) {\n        if (ctx.With() != null){\n            Obj obj = new Obj();\n            ObjWithObj objWithObj = new ObjWithObj();\n            for (int i = 0; i < ctx.object().size(); i++) {\n                objWithObj.objList.add((Obj) ctx.object(i).accept(this));\n            }\n            obj.objWithObj = objWithObj;\n            //objConjObj.conjunction = (Conjunction) ctx.conjunction().accept(this);\n            return obj;\n        }else if (ctx.Of() != null){\n            Obj obj = new Obj();\n            for (int i = 0; i < ctx.object().size(); i++) {\n                obj.objOfObj.objList.add((Obj) ctx.object(i).accept(this));\n            }\n            return obj;\n        }else if (ctx.noun() != null){\n            Obj obj = new Obj();\n            obj.noun = (Noun) ctx.noun().accept(this);\n            return obj;\n        }else{\n            Obj obj = new Obj();\n            if (ctx.Number() != null)\n                obj.num = (Num) ctx.Number().accept(this);\n            else if (ctx.String() != null)\n                obj.str = (Str) ctx.String().accept(this);\n            else\n                obj.identifier = (Identifier) ctx.Identifier().accept(this);\n            return obj;\n        }\n\n    }', 4, 4, '2021-06-25 16:29:42', 1);
INSERT INTO `bls_rule` VALUES (61, 'verb', '动词', 'Establish | Join | Delete | Accept | Grant | Publish | Dispatch | SendMsg | Show | Edit | Disable | Enable | Appear | Have | Merge |\n      Change | Set | Move | Revoke | CancelPub | Appoint | Login', '动词规则', '@Override\n    public Node visitVerb(LanguageParser.VerbContext ctx) {\n        return ctx.getChild(0).accept(this);\n    }', 4, 4, '2021-06-25 16:31:25', 1);
INSERT INTO `bls_rule` VALUES (62, 'noun', '名词', 'Organization | Department | SubDepartment | Band | Position | Role | Member | Tool | MaxAuthority | MinAuthority | Deadline | Reader |\n      Writer | Speaker | Worker | Administrator | Drama | File | Chatroom | SuperiorDepartment | ParentDepartment | ParentBand | SubBand |\n      Authority | NewStaff | SeniorStaff', '名词规则', '@Override\n    public Node visitNoun(LanguageParser.NounContext ctx) {\n        return ctx.getChild(0).accept(this);\n    }', 4, 4, '2021-06-25 16:32:29', 1);
INSERT INTO `bls_rule` VALUES (63, 'adjective', '形容词', 'Incumbent | Leaved', '形容词规则', '@Override\n    public Node visitAdjective(LanguageParser.AdjectiveContext ctx) {\n        return null;\n    }', 4, 4, '2021-06-25 16:34:01', 1);
INSERT INTO `bls_rule` VALUES (64, 'subject_adverbial_predicate_attribute_object_stmt', '主状谓定宾句', 'adverbial Comma subject? predicate attribute? object |\n                                                   subject? adverbial predicate attribute? object', '主状谓定宾句规则', '@Override\n    public Node visitSubject_adverbial_predicate_attribute_object_stmt(LanguageParser.Subject_adverbial_predicate_attribute_object_stmtContext ctx) {\n        SubAdvPreAttrObjStmt subAdvPreAttrObjStmt = new SubAdvPreAttrObjStmt();\n        if (ctx.subject() != null){\n            subAdvPreAttrObjStmt.subject = (Subject) ctx.subject().accept(this);\n        }\n        if (ctx.attribute() != null){\n            subAdvPreAttrObjStmt.attribute = (Attribute) ctx.attribute().accept(this);\n        }\n        subAdvPreAttrObjStmt.adverbial = (Adverbial) ctx.adverbial().accept(this);\n        subAdvPreAttrObjStmt.predicate = (Predicate) ctx.predicate().accept(this);\n        subAdvPreAttrObjStmt.obj = (Obj) ctx.object().accept(this);\n        return subAdvPreAttrObjStmt;\n    }', 4, 4, '2021-06-25 16:36:22', 1);
INSERT INTO `bls_rule` VALUES (65, 'adverbial', '状语', 'place_adverbial | preposition_object', '状语规则', '@Override\n    public Node visitAdverbial(LanguageParser.AdverbialContext ctx) {\n        Adverbial adverbial = new Adverbial();\n        if (ctx.place_adverbial() != null){\n            adverbial.placeAdv = (PlaceAdv) ctx.place_adverbial().accept(this);\n        }else{\n            adverbial.preposObj = (PreposObj) ctx.preposition_object().accept(this);\n        }\n        return adverbial;\n    }', 4, 4, '2021-06-25 16:37:54', 1);
INSERT INTO `bls_rule` VALUES (66, 'place_adverbial', '地点状语', 'preposition object direction?', '地点状语规则', '@Override\n    public Node visitPlace_adverbial(LanguageParser.Place_adverbialContext ctx) {\n        PlaceAdv placeAdv = new PlaceAdv();\n        placeAdv.obj = (Obj) ctx.object().accept(this);\n        return placeAdv;\n    }', 4, 4, '2021-06-25 16:39:57', 1);
INSERT INTO `bls_rule` VALUES (67, 'preposition_object', '介宾短句', 'place_adverbial? preposition attribute? object', '介宾短句', '@Override\n    public Node visitPreposition_object(LanguageParser.Preposition_objectContext ctx) {\n        PreposObj preposObj = new PreposObj();\n        if (ctx.place_adverbial() != null){\n            preposObj.placeAdv = (PlaceAdv) ctx.place_adverbial().accept(this);\n        }\n        if (ctx.attribute() != null){\n            preposObj.attribute = (Attribute) ctx.attribute().accept(this);\n        }\n        preposObj.obj = (Obj) ctx.object().accept(this);\n        return preposObj;\n    }', 4, 4, '2021-06-25 16:41:14', 1);
INSERT INTO `bls_rule` VALUES (68, 'preposition', '介词', 'At | Make | From', '介词规则', '@Override\n    public Node visitPreposition(LanguageParser.PrepositionContext ctx) {\n        return null;\n    }', 4, 4, '2021-06-25 16:42:32', 1);
INSERT INTO `bls_rule` VALUES (69, 'direction', '方位词', 'Inside', '方位词规则', '@Override\n    public Node visitDirection(LanguageParser.DirectionContext ctx) {\n        return null;\n    }', 4, 4, '2021-06-25 16:44:11', 1);
INSERT INTO `bls_rule` VALUES (70, 'Show', '显示', 'Show:\'显示\';', '', '无', 3, 3, '2021-06-25 16:45:42', 1);
INSERT INTO `bls_rule` VALUES (71, 'At', '在', '\'在\' | \'于\'', '在', 'return null;', 4, 4, '2021-06-25 16:45:43', 1);
INSERT INTO `bls_rule` VALUES (72, 'Make', '把', '\'把\' | \'将\' | \'为\' | \'对\' | \'给\'', '把', 'return null;', 4, 4, '2021-06-25 16:46:09', 1);
INSERT INTO `bls_rule` VALUES (73, 'From', '从', '\'从\'', '从', 'return null;', 4, 4, '2021-06-25 16:46:37', 1);
INSERT INTO `bls_rule` VALUES (74, 'Quantifier', '个', '\'个\' | \'次\' | \'条\'', '个', 'return null;', 4, 4, '2021-06-25 16:47:03', 1);
INSERT INTO `bls_rule` VALUES (75, 'TimeUnit', '分钟', '\'分钟\' | \'小时\' | \'天\' | \'月\' | \'年\'', '分钟', 'return null;', 4, 4, '2021-06-25 16:47:24', 1);
INSERT INTO `bls_rule` VALUES (76, 'MoreThan', '大于大于等于', '\'大于\' | \'大于等于\'', '大于大于等于', 'return null;', 4, 4, '2021-06-25 16:47:51', 1);
INSERT INTO `bls_rule` VALUES (77, 'LessThan', '小于小于等于', '\'小于\' | \'小于等于\'', '小于小于等于', 'return null;', 4, 4, '2021-06-25 16:48:17', 1);
INSERT INTO `bls_rule` VALUES (78, 'Equals', '等于', '\'等于\'', '等于', 'return null;', 4, 4, '2021-06-25 16:48:43', 1);
INSERT INTO `bls_rule` VALUES (79, 'Or', '或', '\'或\'', '或', 'return null;', 4, 4, '2021-06-25 16:49:08', 1);
INSERT INTO `bls_rule` VALUES (80, 'And', '且', '\'且\'', '且', 'return null;', 4, 4, '2021-06-25 16:49:32', 1);
INSERT INTO `bls_rule` VALUES (81, 'Inside', '中', '\'里\' | \'内\' | \'中\'', '中', 'return null;', 4, 4, '2021-06-25 16:49:54', 1);
INSERT INTO `bls_rule` VALUES (82, 'If', '如果', '\'如果\' | \'假如\'', '如果', 'return null;', 4, 4, '2021-06-25 16:50:14', 1);
INSERT INTO `bls_rule` VALUES (83, 'Then', '则', '\'则\' | \'那么\'', '则', 'return null;', 4, 4, '2021-06-25 16:50:46', 1);
INSERT INTO `bls_rule` VALUES (84, 'Else', '否则', '\'否则\'', '否则', 'return null;', 4, 4, '2021-06-25 16:51:05', 1);
INSERT INTO `bls_rule` VALUES (85, 'Concurrent', '同时', '\'同时\' | \'并\'', '同时', 'return null;', 4, 4, '2021-06-25 16:51:28', 1);
INSERT INTO `bls_rule` VALUES (86, 'With', '和', '\'和\'', '和', 'return null;', 4, 4, '2021-06-25 16:52:43', 1);
INSERT INTO `bls_rule` VALUES (87, 'Of', '的', '\'的\'', '的', 'return null;', 4, 4, '2021-06-25 16:53:29', 1);
INSERT INTO `bls_rule` VALUES (88, 'Get', '得到', 'Get:\'得到\';', '', '无', 3, 3, '2021-06-25 16:53:56', 1);
INSERT INTO `bls_rule` VALUES (89, 'Comma', '逗号', '\',\' | \'，\'', '逗号 规则', 'return null;', 4, 4, '2021-06-25 16:55:17', 1);
INSERT INTO `bls_rule` VALUES (90, 'Set', '设定', 'Set:\'设定\';', '', '无', 3, 3, '2021-06-25 16:54:37', 1);
INSERT INTO `bls_rule` VALUES (91, 'Change', '改成', 'Change:\'改成\';', '', '无', 3, 3, '2021-06-25 16:55:20', 1);
INSERT INTO `bls_rule` VALUES (92, 'Dot', '句号', '\'.\'|\'。\'', '句号', 'return null;', 4, 4, '2021-06-25 16:55:45', 1);
INSERT INTO `bls_rule` VALUES (93, 'Number', '数字', '[0-9]+', '数字', 'reuturn null;', 4, 4, '2021-06-25 16:56:15', 1);
INSERT INTO `bls_rule` VALUES (94, 'String', '字符串', '\'‘\' (.)*? \'’\'', '用‘’包裹', 'return null;', 4, 4, '2021-06-25 16:56:45', 1);
INSERT INTO `bls_rule` VALUES (95, 'New', '新建', 'New:\'新建\';', '', '无', 3, 3, '2021-06-25 16:58:21', 1);
INSERT INTO `bls_rule` VALUES (96, 'Rename', '重命名为', 'Rename:\'重命名为\';', '', '无', 3, 3, '2021-06-25 16:59:07', 1);
INSERT INTO `bls_rule` VALUES (97, 'Find', '找出', 'Find:\'找出\';', '', '无', 3, 3, '2021-06-25 16:59:47', 1);
INSERT INTO `bls_rule` VALUES (98, 'Remove', '去掉', 'Remove:\'去掉\';', '', '无', 3, 3, '2021-06-25 17:00:39', 1);
INSERT INTO `bls_rule` VALUES (99, 'Identifier', '标识符', '([a-zA-Z0-9$_] | [\\u4E00-\\u9FA5])+', '不能被识别到的词都最后识别为标识符', 'return null;', 4, 4, '2021-06-25 17:01:23', 1);
INSERT INTO `bls_rule` VALUES (100, 'verb', '动词', 'Show|Execute|Get|Find|Remove|Qiu\n    |Set|Count|CarryOut|sort|Group|Change\n    |New|Rename|Merge', '', '@Override\npublic Node visitVerb(BLParser.VerbContext ctx) {\n    return ctx.getChild(0).accept(this);\n}', 3, 3, '2021-06-26 16:27:53', 1);
INSERT INTO `bls_rule` VALUES (101, 'Count', '统计', '\'统计\'', '', '无', 3, 3, '2021-06-26 15:50:11', 1);
INSERT INTO `bls_rule` VALUES (102, 'Group', '进行分组', '\'进行分组\'', '', '无', 3, 3, '2021-06-26 16:13:31', 1);
INSERT INTO `bls_rule` VALUES (103, 'Merge', '合并成为', '\'合并成为\'', '', '无', 3, 3, '2021-06-26 16:25:30', 1);
INSERT INTO `bls_rule` VALUES (104, 'Execute', '执行', '\'执行\'', '', '无', 3, 3, '2021-06-26 16:28:21', 1);
INSERT INTO `bls_rule` VALUES (105, 'sort', '排序', 'SortDescending|SortAscending', '', '无', 3, 3, '2021-06-26 17:42:19', 1);
INSERT INTO `bls_rule` VALUES (106, 'SortAscending', '升序排序', '\'升序排序\'', '', '无', 3, 3, '2021-06-26 16:31:13', 1);
INSERT INTO `bls_rule` VALUES (107, 'SortDescending', '降序排序', '\'降序排序\'', '', '无', 3, 3, '2021-06-26 17:42:59', 1);
INSERT INTO `bls_rule` VALUES (108, 'noun', '名词', 'InputPart|OutputPart|Element|Amount|Data|Max|Min|Average', '', '无', 3, 3, '2021-06-26 17:56:56', 1);
INSERT INTO `bls_rule` VALUES (109, 'InputPart', '输入部件', '\'输入部件\'', '', '无', 3, 3, '2021-06-26 17:46:49', 1);
INSERT INTO `bls_rule` VALUES (110, 'OutputPart', '输出部件', '\'输出部件\'', '', '无', 3, 3, '2021-06-26 17:48:19', 1);
INSERT INTO `bls_rule` VALUES (111, 'Element', '元素', '\'元素\'|\'记录\'', '', '无', 3, 3, '2021-06-26 17:50:35', 1);
INSERT INTO `bls_rule` VALUES (112, 'Amount', '数量', '\'数量\'', '', '无', 3, 3, '2021-06-26 17:53:08', 1);
INSERT INTO `bls_rule` VALUES (113, 'Max', '最大值', '\'最大值\'', '', '无', 3, 3, '2021-06-26 17:54:31', 1);
INSERT INTO `bls_rule` VALUES (114, 'Min', '最小值', '\'最小值\'', '', '无', 3, 3, '2021-06-26 17:56:11', 1);
INSERT INTO `bls_rule` VALUES (115, 'Average', '平均值', '\'平均值\'', '', '无', 3, 3, '2021-06-26 17:57:18', 1);
INSERT INTO `bls_rule` VALUES (116, 'compareWord', '比较词', 'Equals|NoEquals|MoreThan|NoMoreThan|LessThan|NoLessThan', '', '无', 3, 3, '2021-06-26 20:56:05', 1);
INSERT INTO `bls_rule` VALUES (117, 'NoEquals', '不等于', '\'不等于\'|\'!=\'', '', '无', 3, 3, '2021-06-26 20:50:58', 1);
INSERT INTO `bls_rule` VALUES (118, 'MoreThan', '大于', '\'大于\'|\'>\'', '', '无', 3, 3, '2021-06-26 20:52:39', 1);
INSERT INTO `bls_rule` VALUES (119, 'NoMoreThan', '不大于', '\'不大于\'|\'<=\'', '', '无', 3, 3, '2021-06-26 20:53:53', 1);
INSERT INTO `bls_rule` VALUES (120, 'LessThan', '小于', '\'小于\'|\'<\'', '', '无', 3, 3, '2021-06-26 20:55:06', 1);
INSERT INTO `bls_rule` VALUES (121, 'NoLessThan', '不小于', '\'不小于\'|\'>=\'', '', '无', 3, 3, '2021-06-26 20:56:30', 1);
INSERT INTO `bls_rule` VALUES (122, 'numerals', '数词', 'Number', '', '无', 3, 3, '2021-06-26 20:58:10', 1);
INSERT INTO `bls_rule` VALUES (123, 'Number', '数字', '[0-9]+', '', '无', 3, 3, '2021-06-26 20:58:42', 1);
INSERT INTO `bls_rule` VALUES (124, 'Str', '字符串', '(\'‘\' ) (([a-zA-Z0-9$_] | [\\u4E00-\\u9FA5])+) (\'’\')', '', '无', 3, 3, '2021-06-26 21:02:35', 1);
INSERT INTO `bls_rule` VALUES (125, 'Jiang', '将', '\'将\'|\'把\'', '', '无', 3, 3, '2021-06-26 21:07:43', 1);
INSERT INTO `bls_rule` VALUES (126, 'De', '的', '\'的\'', '', '无', 3, 3, '2021-06-26 21:06:27', 1);
INSERT INTO `bls_rule` VALUES (127, 'In', '中', '\'中\'', '', '无', 3, 3, '2021-06-26 21:06:57', 1);
INSERT INTO `bls_rule` VALUES (128, 'According', '根据', '\'根据\'|\'按照\'', '', '无', 3, 3, '2021-06-26 21:07:29', 1);
INSERT INTO `bls_rule` VALUES (129, 'ObjName', '对象名称', '(([a-zA-Z0-9$_] | [\\u4E00-\\u9FA5])+)', '', '无', 3, 3, '2021-06-26 21:08:48', 1);
INSERT INTO `bls_rule` VALUES (130, 'Among', '其中', '\'其中\'', '', '无', 3, 3, '2021-06-26 21:09:15', 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_rule_user
-- ----------------------------
DROP TABLE IF EXISTS `bls_rule_user`;
CREATE TABLE `bls_rule_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rule_id` bigint NOT NULL COMMENT '规则ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态：0：禁用，1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_rule_user
-- ----------------------------
BEGIN;
INSERT INTO `bls_rule_user` VALUES (1, 1, 4, '2021-06-22 14:26:39', 1);
INSERT INTO `bls_rule_user` VALUES (2, 2, 4, '2021-06-22 14:35:05', 1);
INSERT INTO `bls_rule_user` VALUES (3, 3, 4, '2021-06-22 14:38:19', 1);
INSERT INTO `bls_rule_user` VALUES (4, 4, 4, '2021-06-22 14:41:07', 1);
INSERT INTO `bls_rule_user` VALUES (5, 5, 4, '2021-06-22 14:45:21', 1);
INSERT INTO `bls_rule_user` VALUES (6, 6, 4, '2021-06-22 14:46:51', 1);
INSERT INTO `bls_rule_user` VALUES (7, 7, 4, '2021-06-22 14:48:41', 1);
INSERT INTO `bls_rule_user` VALUES (8, 8, 4, '2021-06-22 14:51:39', 1);
INSERT INTO `bls_rule_user` VALUES (9, 9, 4, '2021-06-22 14:53:50', 1);
INSERT INTO `bls_rule_user` VALUES (10, 10, 4, '2021-06-22 14:55:49', 1);
INSERT INTO `bls_rule_user` VALUES (11, 11, 4, '2021-06-22 14:58:44', 1);
INSERT INTO `bls_rule_user` VALUES (12, 12, 4, '2021-06-22 15:00:27', 1);
INSERT INTO `bls_rule_user` VALUES (13, 13, 4, '2021-06-22 15:02:45', 1);
INSERT INTO `bls_rule_user` VALUES (14, 14, 4, '2021-06-22 15:05:58', 1);
INSERT INTO `bls_rule_user` VALUES (15, 15, 4, '2021-06-22 15:08:11', 1);
INSERT INTO `bls_rule_user` VALUES (16, 16, 4, '2021-06-22 15:10:09', 1);
INSERT INTO `bls_rule_user` VALUES (17, 17, 4, '2021-06-22 15:24:01', 1);
INSERT INTO `bls_rule_user` VALUES (18, 18, 4, '2021-06-22 15:25:36', 1);
INSERT INTO `bls_rule_user` VALUES (19, 19, 4, '2021-06-22 15:27:19', 1);
INSERT INTO `bls_rule_user` VALUES (20, 20, 4, '2021-06-22 16:13:03', 1);
INSERT INTO `bls_rule_user` VALUES (21, 21, 4, '2021-06-22 16:25:49', 1);
INSERT INTO `bls_rule_user` VALUES (22, 22, 4, '2021-06-22 16:27:13', 1);
INSERT INTO `bls_rule_user` VALUES (23, 23, 4, '2021-06-22 16:28:15', 1);
INSERT INTO `bls_rule_user` VALUES (24, 24, 4, '2021-06-22 16:29:17', 1);
INSERT INTO `bls_rule_user` VALUES (25, 25, 4, '2021-06-22 16:31:53', 1);
INSERT INTO `bls_rule_user` VALUES (26, 26, 4, '2021-06-22 16:33:30', 1);
INSERT INTO `bls_rule_user` VALUES (27, 27, 4, '2021-06-22 16:46:00', 1);
INSERT INTO `bls_rule_user` VALUES (28, 28, 4, '2021-06-22 16:51:25', 1);
INSERT INTO `bls_rule_user` VALUES (29, 29, 4, '2021-06-22 17:08:31', 1);
INSERT INTO `bls_rule_user` VALUES (30, 30, 4, '2021-06-22 17:10:26', 1);
INSERT INTO `bls_rule_user` VALUES (31, 31, 4, '2021-06-22 17:17:54', 1);
INSERT INTO `bls_rule_user` VALUES (32, 32, 4, '2021-06-22 17:18:42', 1);
INSERT INTO `bls_rule_user` VALUES (33, 33, 4, '2021-06-22 17:20:28', 1);
INSERT INTO `bls_rule_user` VALUES (34, 34, 4, '2021-06-22 17:23:48', 1);
INSERT INTO `bls_rule_user` VALUES (35, 35, 4, '2021-06-22 17:25:01', 1);
INSERT INTO `bls_rule_user` VALUES (36, 36, 4, '2021-06-22 17:26:03', 1);
INSERT INTO `bls_rule_user` VALUES (37, 37, 4, '2021-06-22 17:28:04', 1);
INSERT INTO `bls_rule_user` VALUES (38, 38, 4, '2021-06-22 17:28:52', 1);
INSERT INTO `bls_rule_user` VALUES (39, 39, 4, '2021-06-22 17:29:40', 1);
INSERT INTO `bls_rule_user` VALUES (40, 40, 4, '2021-06-22 17:30:23', 1);
INSERT INTO `bls_rule_user` VALUES (41, 41, 4, '2021-06-22 17:31:36', 1);
INSERT INTO `bls_rule_user` VALUES (42, 42, 4, '2021-06-22 17:33:11', 1);
INSERT INTO `bls_rule_user` VALUES (43, 43, 4, '2021-06-22 17:34:13', 1);
INSERT INTO `bls_rule_user` VALUES (44, 44, 4, '2021-06-22 17:36:34', 1);
INSERT INTO `bls_rule_user` VALUES (45, 45, 4, '2021-06-22 17:37:21', 1);
INSERT INTO `bls_rule_user` VALUES (46, 46, 4, '2021-06-22 17:38:11', 1);
INSERT INTO `bls_rule_user` VALUES (47, 47, 4, '2021-06-22 17:38:56', 1);
INSERT INTO `bls_rule_user` VALUES (48, 48, 4, '2021-06-22 17:40:14', 1);
INSERT INTO `bls_rule_user` VALUES (49, 49, 4, '2021-06-22 17:41:01', 1);
INSERT INTO `bls_rule_user` VALUES (50, 50, 4, '2021-06-22 17:42:07', 1);
INSERT INTO `bls_rule_user` VALUES (51, 51, 4, '2021-06-22 17:44:15', 1);
INSERT INTO `bls_rule_user` VALUES (52, 52, 4, '2021-06-22 17:45:15', 1);
INSERT INTO `bls_rule_user` VALUES (53, 53, 4, '2021-06-23 15:43:59', 1);
INSERT INTO `bls_rule_user` VALUES (54, 54, 4, '2021-06-23 15:46:42', 1);
INSERT INTO `bls_rule_user` VALUES (55, 55, 4, '2021-06-23 15:49:05', 1);
INSERT INTO `bls_rule_user` VALUES (56, 27, 1, '2021-06-23 15:59:12', 1);
INSERT INTO `bls_rule_user` VALUES (57, 56, 4, '2021-06-25 16:13:36', 1);
INSERT INTO `bls_rule_user` VALUES (58, 57, 4, '2021-06-25 16:25:02', 1);
INSERT INTO `bls_rule_user` VALUES (59, 58, 4, '2021-06-25 16:26:48', 1);
INSERT INTO `bls_rule_user` VALUES (60, 59, 4, '2021-06-25 16:27:56', 1);
INSERT INTO `bls_rule_user` VALUES (61, 60, 4, '2021-06-25 16:29:42', 1);
INSERT INTO `bls_rule_user` VALUES (62, 61, 4, '2021-06-25 16:31:25', 1);
INSERT INTO `bls_rule_user` VALUES (63, 62, 4, '2021-06-25 16:32:29', 1);
INSERT INTO `bls_rule_user` VALUES (64, 63, 4, '2021-06-25 16:34:01', 1);
INSERT INTO `bls_rule_user` VALUES (65, 64, 4, '2021-06-25 16:36:22', 1);
INSERT INTO `bls_rule_user` VALUES (66, 65, 4, '2021-06-25 16:37:54', 1);
INSERT INTO `bls_rule_user` VALUES (67, 66, 4, '2021-06-25 16:39:57', 1);
INSERT INTO `bls_rule_user` VALUES (68, 67, 4, '2021-06-25 16:41:14', 1);
INSERT INTO `bls_rule_user` VALUES (69, 68, 4, '2021-06-25 16:42:32', 1);
INSERT INTO `bls_rule_user` VALUES (70, 69, 4, '2021-06-25 16:44:11', 1);
INSERT INTO `bls_rule_user` VALUES (71, 70, 3, '2021-06-25 16:45:42', 1);
INSERT INTO `bls_rule_user` VALUES (72, 71, 4, '2021-06-25 16:45:43', 1);
INSERT INTO `bls_rule_user` VALUES (73, 72, 4, '2021-06-25 16:46:09', 1);
INSERT INTO `bls_rule_user` VALUES (74, 73, 4, '2021-06-25 16:46:37', 1);
INSERT INTO `bls_rule_user` VALUES (75, 74, 4, '2021-06-25 16:47:03', 1);
INSERT INTO `bls_rule_user` VALUES (76, 75, 4, '2021-06-25 16:47:24', 1);
INSERT INTO `bls_rule_user` VALUES (77, 76, 4, '2021-06-25 16:47:51', 1);
INSERT INTO `bls_rule_user` VALUES (78, 77, 4, '2021-06-25 16:48:17', 1);
INSERT INTO `bls_rule_user` VALUES (79, 78, 4, '2021-06-25 16:48:43', 1);
INSERT INTO `bls_rule_user` VALUES (80, 79, 4, '2021-06-25 16:49:08', 1);
INSERT INTO `bls_rule_user` VALUES (81, 80, 4, '2021-06-25 16:49:32', 1);
INSERT INTO `bls_rule_user` VALUES (82, 81, 4, '2021-06-25 16:49:54', 1);
INSERT INTO `bls_rule_user` VALUES (83, 82, 4, '2021-06-25 16:50:14', 1);
INSERT INTO `bls_rule_user` VALUES (84, 83, 4, '2021-06-25 16:50:46', 1);
INSERT INTO `bls_rule_user` VALUES (85, 84, 4, '2021-06-25 16:51:05', 1);
INSERT INTO `bls_rule_user` VALUES (86, 85, 4, '2021-06-25 16:51:28', 1);
INSERT INTO `bls_rule_user` VALUES (87, 86, 4, '2021-06-25 16:52:43', 1);
INSERT INTO `bls_rule_user` VALUES (88, 87, 4, '2021-06-25 16:53:29', 1);
INSERT INTO `bls_rule_user` VALUES (89, 88, 3, '2021-06-25 16:53:56', 1);
INSERT INTO `bls_rule_user` VALUES (90, 89, 4, '2021-06-25 16:55:17', 1);
INSERT INTO `bls_rule_user` VALUES (91, 90, 3, '2021-06-25 16:54:37', 1);
INSERT INTO `bls_rule_user` VALUES (92, 91, 3, '2021-06-25 16:55:20', 1);
INSERT INTO `bls_rule_user` VALUES (93, 92, 4, '2021-06-25 16:55:45', 1);
INSERT INTO `bls_rule_user` VALUES (94, 93, 4, '2021-06-25 16:56:15', 1);
INSERT INTO `bls_rule_user` VALUES (95, 94, 4, '2021-06-25 16:56:45', 1);
INSERT INTO `bls_rule_user` VALUES (96, 95, 3, '2021-06-25 16:58:21', 1);
INSERT INTO `bls_rule_user` VALUES (97, 96, 3, '2021-06-25 16:59:07', 1);
INSERT INTO `bls_rule_user` VALUES (98, 97, 3, '2021-06-25 16:59:47', 1);
INSERT INTO `bls_rule_user` VALUES (99, 98, 3, '2021-06-25 17:00:39', 1);
INSERT INTO `bls_rule_user` VALUES (100, 99, 4, '2021-06-25 17:01:23', 1);
INSERT INTO `bls_rule_user` VALUES (101, 100, 3, '2021-06-26 16:27:53', 1);
INSERT INTO `bls_rule_user` VALUES (102, 101, 3, '2021-06-26 15:50:11', 1);
INSERT INTO `bls_rule_user` VALUES (103, 102, 3, '2021-06-26 16:13:31', 1);
INSERT INTO `bls_rule_user` VALUES (104, 103, 3, '2021-06-26 16:25:30', 1);
INSERT INTO `bls_rule_user` VALUES (105, 104, 3, '2021-06-26 16:28:21', 1);
INSERT INTO `bls_rule_user` VALUES (106, 105, 3, '2021-06-26 17:42:19', 1);
INSERT INTO `bls_rule_user` VALUES (107, 106, 3, '2021-06-26 16:31:13', 1);
INSERT INTO `bls_rule_user` VALUES (108, 107, 3, '2021-06-26 17:42:59', 1);
INSERT INTO `bls_rule_user` VALUES (109, 108, 3, '2021-06-26 17:56:56', 1);
INSERT INTO `bls_rule_user` VALUES (110, 109, 3, '2021-06-26 17:46:49', 1);
INSERT INTO `bls_rule_user` VALUES (111, 110, 3, '2021-06-26 17:48:19', 1);
INSERT INTO `bls_rule_user` VALUES (112, 111, 3, '2021-06-26 17:50:35', 1);
INSERT INTO `bls_rule_user` VALUES (113, 112, 3, '2021-06-26 17:53:08', 1);
INSERT INTO `bls_rule_user` VALUES (114, 113, 3, '2021-06-26 17:54:31', 1);
INSERT INTO `bls_rule_user` VALUES (115, 114, 3, '2021-06-26 17:56:11', 1);
INSERT INTO `bls_rule_user` VALUES (116, 115, 3, '2021-06-26 17:57:18', 1);
INSERT INTO `bls_rule_user` VALUES (117, 116, 3, '2021-06-26 20:56:05', 1);
INSERT INTO `bls_rule_user` VALUES (118, 117, 3, '2021-06-26 20:50:59', 1);
INSERT INTO `bls_rule_user` VALUES (119, 118, 3, '2021-06-26 20:52:40', 1);
INSERT INTO `bls_rule_user` VALUES (120, 119, 3, '2021-06-26 20:53:53', 1);
INSERT INTO `bls_rule_user` VALUES (121, 120, 3, '2021-06-26 20:55:06', 1);
INSERT INTO `bls_rule_user` VALUES (122, 121, 3, '2021-06-26 20:56:30', 1);
INSERT INTO `bls_rule_user` VALUES (123, 122, 3, '2021-06-26 20:58:10', 1);
INSERT INTO `bls_rule_user` VALUES (124, 123, 3, '2021-06-26 20:58:42', 1);
INSERT INTO `bls_rule_user` VALUES (125, 124, 3, '2021-06-26 21:02:35', 1);
INSERT INTO `bls_rule_user` VALUES (126, 125, 3, '2021-06-26 21:07:43', 1);
INSERT INTO `bls_rule_user` VALUES (127, 126, 3, '2021-06-26 21:06:27', 1);
INSERT INTO `bls_rule_user` VALUES (128, 127, 3, '2021-06-26 21:06:57', 1);
INSERT INTO `bls_rule_user` VALUES (129, 128, 3, '2021-06-26 21:07:29', 1);
INSERT INTO `bls_rule_user` VALUES (130, 129, 3, '2021-06-26 21:08:48', 1);
INSERT INTO `bls_rule_user` VALUES (131, 130, 3, '2021-06-26 21:09:15', 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_script
-- ----------------------------
DROP TABLE IF EXISTS `bls_script`;
CREATE TABLE `bls_script` (
  `script_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `creator_id` bigint NOT NULL COMMENT '创建者用户ID',
  `editor_id` bigint NOT NULL DEFAULT '0' COMMENT '最近一次编辑者用户ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `run_times` bigint DEFAULT '0' COMMENT '运行次数',
  `status` int NOT NULL DEFAULT '1' COMMENT '0:禁用 1：待开发 2： 开发中 3：待审核 4：待发布 5：已发布',
  PRIMARY KEY (`script_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of bls_script
-- ----------------------------
BEGIN;
INSERT INTO `bls_script` VALUES (1, '部门中创建子部门', '在 测试开发部 中，创建 ‘运维开发部’ 子部门。', '部门中创建子部门', 4, 4, '2021-06-22 10:57:31', 0, 1);
INSERT INTO `bls_script` VALUES (2, '成员约束', '郭志涛 要出现在 人力资源部 和 外联部 中。', '成员约束', 4, 4, '2021-06-22 10:58:00', 0, 1);
INSERT INTO `bls_script` VALUES (3, '成员岗位更换', '把 王丽 从 护士 更换到 护师 岗位。', '成员岗位更换', 4, 4, '2021-06-22 10:58:19', 0, 1);
INSERT INTO `bls_script` VALUES (4, '公司新员工入职流程', '把 张志斌 拉入到 测试开发部 部门。\n为 张志斌 授予 实习生 岗位，并 设定 有效期 3 个 月。\n把 员工培训部 的 公司规章管理制度文档 发布给 张志斌，并 通知 王秘书 ‘请为张志斌发方入职设备’。\n把 张志斌 拉入到 员工培训部 部门，并 为 张志斌 授予 读者 角色。', '公司新员工入职流程', 4, 4, '2021-06-22 10:58:39', 0, 1);
INSERT INTO `bls_script` VALUES (5, '医院部门合并及人员调动', '把 脑血管外科部 和 心血管外科部 合并为 ‘血管外科部’ 部门。\n为 李忠 授予 血管外科主任 岗位。\n把 吴越 和 张斌 派遣到 血管外科 部门。\n在 血管外科部 中， 创建 仪器管理员 岗位，并 为 吴越 和 张斌 授予 仪器管理员 岗位。\n为 仪器管理员 授予 工者 角色。', '医院部门合并及人员调动', 4, 4, '2021-06-22 10:59:01', 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_script_user
-- ----------------------------
DROP TABLE IF EXISTS `bls_script_user`;
CREATE TABLE `bls_script_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `script_id` bigint NOT NULL COMMENT '剧本ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态：0：禁用，1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_script_user
-- ----------------------------
BEGIN;
INSERT INTO `bls_script_user` VALUES (1, 1, 4, '2021-06-22 10:57:31', 1);
INSERT INTO `bls_script_user` VALUES (2, 2, 4, '2021-06-22 10:58:00', 1);
INSERT INTO `bls_script_user` VALUES (3, 3, 4, '2021-06-22 10:58:19', 1);
INSERT INTO `bls_script_user` VALUES (4, 4, 4, '2021-06-22 10:58:39', 1);
INSERT INTO `bls_script_user` VALUES (5, 5, 4, '2021-06-22 10:59:01', 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_sentence
-- ----------------------------
DROP TABLE IF EXISTS `bls_sentence`;
CREATE TABLE `bls_sentence` (
  `sentence_id` int NOT NULL AUTO_INCREMENT,
  `name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '句子本身',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '相关描述',
  `paradigm` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '句型的巴科斯范式表示',
  `creator_id` bigint NOT NULL COMMENT '创建者用户ID',
  `editor_id` bigint NOT NULL COMMENT '最近一次编辑者用户ID',
  `update_time` datetime DEFAULT NULL COMMENT '最近一次更新时间',
  `is_type_in` int NOT NULL DEFAULT '0' COMMENT '0:未录入，1：已录入',
  `status` int NOT NULL DEFAULT '1' COMMENT '0:禁用 1：待开发 2： 开发中 3：待审核 4：待发布 5：已发布',
  PRIMARY KEY (`sentence_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of bls_sentence
-- ----------------------------
BEGIN;
INSERT INTO `bls_sentence` VALUES (1, '查看部门', '表示对机构中的所有部门查看。', '<查看部门>::= “显示” <机构名> “的” “所有部门”;', 4, 4, '2021-06-22 10:26:57', 1, 1);
INSERT INTO `bls_sentence` VALUES (2, '创建部门', '表示创建部门或子部门，创建子部门需要指定在某个部门中，直接通过写出的部门名来定位。', '<创建部门>::=“创建” <部门名> “部门”\n| “在” <部门名> “中” “,” “创建” <部门名> “子部门”;', 4, 4, '2021-06-22 10:27:49', 1, 1);
INSERT INTO `bls_sentence` VALUES (3, '修改部门', '对部门的修改管理，主要对部门名称的修改操作。', '<修改部门>::=“把” <部门名> “部门” “修改为” <部门名>;', 4, 4, '2021-06-22 10:28:26', 0, 1);
INSERT INTO `bls_sentence` VALUES (4, '移动部门', '对部门的移动表示将前者部门移动到后者中，作为后者的一个子部门。', '<移动部门>::=“把” <部门名> “部门” “移动到” <部门名> “中”;', 4, 4, '2021-06-22 10:28:58', 0, 1);
INSERT INTO `bls_sentence` VALUES (5, '撤消部门', '表示对机构部门或部门中子部门的撤消操作。', '<撤消部门>::=“撤消” <部门名> “部门”;\n| “在” <部门名> “中” “,” “撤消” <部门名> “子部门”;', 4, 4, '2021-06-22 10:29:30', 0, 1);
INSERT INTO `bls_sentence` VALUES (6, '合并部门', '表示将两个部门合并为新部门或把一个部门合并到另一个部门中的操作。', '<合并部门>::=“把” <部门名> “和” <部门名> “合并为” <部门名> “部门”\n| “将” <部门名> “部门” “合并到” <部门名>;', 4, 4, '2021-06-22 10:30:11', 0, 1);
INSERT INTO `bls_sentence` VALUES (7, '查看岗位', '此句型表示对机构或部门中的岗位查看。', '<查看岗位>::=“显示” (<机构名> | <部门名>) “的” “所有岗位”;', 4, 4, '2021-06-22 10:30:46', 0, 1);
INSERT INTO `bls_sentence` VALUES (8, '创建岗位', '此句型表示对岗位的创建操作，不指定部门地点则表示在机构层创建岗位。', '<创建岗位>::=[“在” <部门名> “中” “,”] “创建” <岗位名> “岗位”;', 4, 4, '2021-06-22 10:31:23', 0, 1);
INSERT INTO `bls_sentence` VALUES (9, '修改岗位', '对岗位的修改管理为修改岗位的名称。', '<修改岗位>::=[“在” <部门名> “中”] “把” <岗位名> “岗位” “修改为” <岗位名>;', 4, 4, '2021-06-22 10:32:05', 0, 1);
INSERT INTO `bls_sentence` VALUES (10, '移除岗位', '此句型为将岗位从机构或部门中移除，若不指定在某个部门，则表示对机构层的岗位移除。', '<移除岗位>::=[“在” <部门名> “中” “,”] “移除” <岗位名> “岗位”\n| “对” <部门名> “移除” <岗位名> “岗位”;', 4, 4, '2021-06-22 10:32:44', 0, 1);
INSERT INTO `bls_sentence` VALUES (11, '岗位约束', '此句型为对机构中的岗位制定约束规则。', '<岗位约束>::=<岗位名> “要出现在” <部门名> “中”;', 4, 4, '2021-06-22 10:33:15', 0, 1);
INSERT INTO `bls_sentence` VALUES (12, '查看成员', '成员管理中的查看成员包括查看机构、部门或岗位中的所有成员。其中对岗位查看成员时，根据岗位是机构岗位还是部门岗位，选择是否需要指定部门地点。', '<查看成员>::=“显示” (<机构名> | <部门名>) “的” “所有成员”\n| [“在” <部门名> “中” “,”] “显示” <岗位名> “的” “所有成员”;', 4, 4, '2021-06-22 10:34:00', 0, 1);
INSERT INTO `bls_sentence` VALUES (13, '添加成员', '此句型表示对成员的添加操作，若不指定部门则表示对机构添加平台系统中的某个成员。', '<添加成员>::=“把” <成员名> “拉入到” <部门名> “部门”\n| [“在” <部门名> “中” “,”] “添加” “成员” <成员名>;', 4, 4, '2021-06-22 10:34:40', 0, 1);
INSERT INTO `bls_sentence` VALUES (14, '移除成员', '将成员从机构或部门中移除的操作句型。', '<移除成员>::=[“在” <部门名> “中” “,”] “移除” “成员” <成员名>;', 4, 4, '2021-06-22 10:35:20', 0, 1);
INSERT INTO `bls_sentence` VALUES (15, '任命岗位', '为成员在机构或部门中任命某个岗位的管理操作。', '<任命岗位>::=[“在” <部门名> “中”] “为” <成员名> “任命” <岗位名> “岗位”;', 4, 4, '2021-06-22 10:35:53', 0, 1);
INSERT INTO `bls_sentence` VALUES (16, '免除岗位', '将成员从某个岗位中免职的操作句型。', '<免除岗位>::=[“在” <部门名> “部门” “中”] “为” <成员名> “免除” <岗位名> “岗位”;', 4, 4, '2021-06-22 10:36:27', 0, 1);
INSERT INTO `bls_sentence` VALUES (17, '更换岗位', '对成员从某个岗位更换到另一个岗位的句型表述。', '<更换岗位>::=“把” <成员名> “从” <岗位名> “更换到” <岗位名> “岗位”;', 4, 4, '2021-06-22 10:37:02', 0, 1);
INSERT INTO `bls_sentence` VALUES (18, '成员派遣', '此句型为对机构成员派遣的操作描述。', '<成员派遣>::=“把” <成员名> “派遣到” <部门名> “部门”;', 4, 4, '2021-06-22 10:37:30', 0, 1);
INSERT INTO `bls_sentence` VALUES (19, '成员约束', '此句型表示对成员出现在部门或岗位中的规则约束。', '<成员约束>::=<成员名> “要出现在” <部门名> “中”;', 4, 4, '2021-06-22 10:37:59', 0, 1);
INSERT INTO `bls_sentence` VALUES (20, '授予权限', '授予权限句型表示对岗位或成员授予某个角色，根据不同业务选择是否指定部门。', '<授予权限>::=[“在” <部门名> “中”] “为” (<岗位名> | <成员名>) “授予” <角色名> “角色”;', 4, 4, '2021-06-22 10:38:49', 0, 1);
INSERT INTO `bls_sentence` VALUES (21, '设定通行证', '此句型为授予权限时，设定权限的有效期。', '<设定通行证>::=“设定” “有效期” <时间补语>;', 4, 4, '2021-06-22 10:39:22', 0, 1);
INSERT INTO `bls_sentence` VALUES (22, '移除权限', '<移除权限>::=[“在” <部门名> “中”] “为” (<岗位名> | <成员名>) “移除” <角色名> “角色”;', '此句型表示对岗位或成员移除某个角色权限的管理操作。', 4, 4, '2021-06-22 10:39:52', 0, 1);
INSERT INTO `bls_sentence` VALUES (23, '权限约束', '此句型表示对岗位或成员的权限约束。', '<权限约束>::=(<岗位名> | <成员名>) “在” <部门名> “中” “拥有” <角色名> “角色”;', 4, 4, '2021-06-22 10:40:22', 0, 1);
INSERT INTO `bls_sentence` VALUES (24, '资源发布', '发布管理中对资源的发布，表示发布资源给某个成员或某个部门等。', '<资源发布>::=“发布给” (<成员名> | <地点名>) <资源名>\n| “把” <资源名> “发布到” (<成员名> | <地点名>);', 4, 4, '2021-06-22 10:40:58', 0, 1);
INSERT INTO `bls_sentence` VALUES (25, '取消发布', '<取消发布>::=“取消发布” <发布名称>;', '对已经发布的资源取消，使用动词关键词“取消发布”后接要取消的发布名称。', 4, 4, '2021-06-22 10:41:35', 0, 1);
INSERT INTO `bls_sentence` VALUES (26, '工具调用类句型一', '调用工具，获取对应接口返回结果的句型', '执行 <工具名称> ，(其中，(<参数赋值短语> ，) + )? 得到 <接口名称> (、<接口名称>)*', 3, 3, '2021-06-25 16:25:18', 0, 1);
INSERT INTO `bls_sentence` VALUES (27, '工具调用类句型二', '同工具调用类句型一', '(把 <对象名称> 作为参数，)? 执行 <工具名称> 的 <接口名称> (、<接口名称>)*', 3, 3, '2021-06-25 16:25:49', 0, 1);
INSERT INTO `bls_sentence` VALUES (28, '修改对象的属性值', '该操作只会影响到功能接口返回的数据对象，并不会影响到工具内部的数据。工具内部的数据只能通过工具对外开放的接口才能够进行修改。', '把 <对象名称> 的 <属性名称> 改成 <值>', 3, 3, '2021-06-25 16:26:18', 0, 1);
INSERT INTO `bls_sentence` VALUES (29, '新建对象', '在集成帮语中，除了调用工具功能接口来获取对象外，还可以自己创建新对象，以方便进行功能集成。创建的对象也可作为工具接口的输入参数。', '新建 <对象名称>  ，其中 (，<参数赋值短语>)+', 3, 3, '2021-06-25 16:26:33', 0, 1);
INSERT INTO `bls_sentence` VALUES (30, '删除对象', '如果集成帮语执行过程中某个对象后续不再需要，则可以使用删除操作来删除该对象。', '删除 <对象名称>', 3, 3, '2021-06-25 16:26:54', 0, 1);
INSERT INTO `bls_sentence` VALUES (31, '删除集合对象中的部分元素', '对于集合对象，集成帮语同样允许用户删除其中符合条件的元素，类似SQL中的delete操作。区别于“删除对象”句型，“删除记录”句型是删除某个集合对象中的部分元素，即使元素全部删除，该对象在语境中依然存在。', '去掉 <对象名称> 中 (<条件判断语句>)? 的 元素', 3, 3, '2021-06-25 16:28:14', 0, 1);
INSERT INTO `bls_sentence` VALUES (32, '集合排序', '排序', '根据 <属性名称> 将 <对象名称> 进行 (升序排序 | 降序排序)', 3, 3, '2021-06-25 16:28:32', 0, 1);
INSERT INTO `bls_sentence` VALUES (33, '集合分组', '该操作完成后所有元素依然在同一个集合对象中，只是属性值相同的会排列在一起。', '将 <对象名称> 按照 <属性名称> 进行分组', 3, 3, '2021-06-25 16:28:53', 0, 1);
INSERT INTO `bls_sentence` VALUES (34, '将对象重命名', '工具功能接口所返回的数据，会默认以接口名称为key保存成为对象。如果集成帮语运行过程中有多个key相同的对象，开发者可使用重命名操作修改最近使用的对象的名称。语句执行后会将对象的key修改为新值，但不会修改其实际内容。', '把 <对象名称>  重命名为 <对象名称>', 3, 3, '2021-06-25 16:29:25', 0, 1);
INSERT INTO `bls_sentence` VALUES (35, '结果合并类句型一', '将某个单一对象添加到某个集合对象中', '在 <集合对象名称> 中 添加 <对象名称>', 3, 3, '2021-06-25 16:30:00', 0, 1);
INSERT INTO `bls_sentence` VALUES (36, '结果合并类句型二', '把同类型、同属性的对象合并成为新的对象', '把 <对象名称> (、<对象名称> )+ 合并成为 <对象名称>', 3, 3, '2021-06-25 16:30:53', 0, 1);
INSERT INTO `bls_sentence` VALUES (37, '结果合并类句型三', '多个集合对象根据某个属性进行连接，形成新对象', '把 <对象名称> (、<对象名称> )+ 按照 <属性名称> 合并成为 <对象名称>', 3, 3, '2021-06-25 16:31:13', 0, 1);
INSERT INTO `bls_sentence` VALUES (38, '显示对象', '将对象内容显示在页面上', '显示 <对象名称>  (的 <属性名称>)*', 3, 3, '2021-06-25 16:32:20', 0, 1);
INSERT INTO `bls_sentence` VALUES (39, '工具接口查询', '查询某个工具所提供的功能接口，或者需要的参数信息', '显示 <工具名称> 的 输出部件|输入部件', 3, 3, '2021-06-25 16:32:43', 0, 1);
INSERT INTO `bls_sentence` VALUES (40, '统计集合中元素数量', '统计某个对象集合中符合某个条件的对象的个数', '统计 <对象名称> 中 (<条件判断语句>)? 的 元素 的 数量', 3, 3, '2021-06-25 16:33:08', 0, 1);
INSERT INTO `bls_sentence` VALUES (41, '条件查询', '查询某个对象集合中符合某些条件的对象', '找出 <对象名称> 中 (<条件判断语句>)? 的 元素', 3, 3, '2021-06-25 16:34:21', 0, 1);
INSERT INTO `bls_sentence` VALUES (42, '集合求值', '求对象集合中某个属性的最大值最小值等特殊值', '求 <对象名称> 中 <属性名称> 的 最大值|最小值|平均值|总和', 3, 3, '2021-06-25 16:34:57', 0, 1);
INSERT INTO `bls_sentence` VALUES (43, '设定词汇固定含义', '有时候某一条语句需要多次执行，某个值需要在多个地方使用，为此设计了“设定”句型，为用户提供了类似编程语言中的宏定义的一种操作。句型执行会将对应内容以对象的方式存储在语境中，在后续的语句中可使用对应的对象名称来完成实际内容的引用。', '设定 字符串 等于 (<语句>|字符串|数字|值)', 3, 3, '2021-06-25 16:35:44', 0, 1);
INSERT INTO `bls_sentence` VALUES (44, '拷贝一份新数据', '在进行数据处理前，为防止后续需要再次使用原始数据，可使用数据拷贝句型将数据拷贝一份。拷贝后集成帮语运行环境中将存在一个新的对象，其内容和原始数据相一致，且不会相互关联', '把 <对象名称>  拷贝一份为  <对象名称>', 3, 3, '2021-06-25 16:36:26', 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_sentence_node
-- ----------------------------
DROP TABLE IF EXISTS `bls_sentence_node`;
CREATE TABLE `bls_sentence_node` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `sentence_id` bigint NOT NULL COMMENT '句型ID',
  `node_id` bigint NOT NULL COMMENT '节点ID',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态  0：禁用  1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_sentence_node
-- ----------------------------
BEGIN;
INSERT INTO `bls_sentence_node` VALUES (1, 1, 53, 1);
INSERT INTO `bls_sentence_node` VALUES (2, 1, 54, 1);
INSERT INTO `bls_sentence_node` VALUES (3, 1, 55, 1);
INSERT INTO `bls_sentence_node` VALUES (4, 1, 56, 1);
INSERT INTO `bls_sentence_node` VALUES (5, 1, 57, 1);
INSERT INTO `bls_sentence_node` VALUES (6, 1, 58, 1);
INSERT INTO `bls_sentence_node` VALUES (7, 1, 59, 1);
INSERT INTO `bls_sentence_node` VALUES (8, 1, 60, 1);
INSERT INTO `bls_sentence_node` VALUES (9, 1, 61, 1);
INSERT INTO `bls_sentence_node` VALUES (10, 1, 62, 1);
INSERT INTO `bls_sentence_node` VALUES (11, 1, 63, 1);
INSERT INTO `bls_sentence_node` VALUES (12, 2, 64, 1);
INSERT INTO `bls_sentence_node` VALUES (13, 2, 65, 1);
INSERT INTO `bls_sentence_node` VALUES (14, 2, 66, 1);
INSERT INTO `bls_sentence_node` VALUES (15, 2, 67, 1);
INSERT INTO `bls_sentence_node` VALUES (16, 1, 72, 1);
INSERT INTO `bls_sentence_node` VALUES (17, 1, 74, 1);
INSERT INTO `bls_sentence_node` VALUES (18, 1, 75, 1);
INSERT INTO `bls_sentence_node` VALUES (19, 1, 77, 1);
INSERT INTO `bls_sentence_node` VALUES (20, 1, 79, 1);
INSERT INTO `bls_sentence_node` VALUES (21, 1, 81, 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_sentence_rule
-- ----------------------------
DROP TABLE IF EXISTS `bls_sentence_rule`;
CREATE TABLE `bls_sentence_rule` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `sentence_id` bigint NOT NULL COMMENT '句型id',
  `rule_id` bigint NOT NULL COMMENT '规则id',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态  0：禁用  1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_sentence_rule
-- ----------------------------
BEGIN;
INSERT INTO `bls_sentence_rule` VALUES (1, 1, 53, 1);
INSERT INTO `bls_sentence_rule` VALUES (2, 1, 54, 1);
INSERT INTO `bls_sentence_rule` VALUES (3, 1, 55, 1);
INSERT INTO `bls_sentence_rule` VALUES (4, 1, 56, 1);
INSERT INTO `bls_sentence_rule` VALUES (5, 1, 57, 1);
INSERT INTO `bls_sentence_rule` VALUES (6, 1, 58, 1);
INSERT INTO `bls_sentence_rule` VALUES (7, 1, 59, 1);
INSERT INTO `bls_sentence_rule` VALUES (8, 1, 60, 1);
INSERT INTO `bls_sentence_rule` VALUES (9, 1, 61, 1);
INSERT INTO `bls_sentence_rule` VALUES (10, 1, 62, 1);
INSERT INTO `bls_sentence_rule` VALUES (11, 1, 63, 1);
INSERT INTO `bls_sentence_rule` VALUES (12, 2, 64, 1);
INSERT INTO `bls_sentence_rule` VALUES (13, 2, 65, 1);
INSERT INTO `bls_sentence_rule` VALUES (14, 2, 66, 1);
INSERT INTO `bls_sentence_rule` VALUES (15, 2, 67, 1);
INSERT INTO `bls_sentence_rule` VALUES (16, 2, 68, 1);
INSERT INTO `bls_sentence_rule` VALUES (17, 2, 69, 1);
INSERT INTO `bls_sentence_rule` VALUES (18, 2, 89, 0);
INSERT INTO `bls_sentence_rule` VALUES (19, 1, 89, 1);
INSERT INTO `bls_sentence_rule` VALUES (20, 1, 92, 1);
INSERT INTO `bls_sentence_rule` VALUES (21, 1, 93, 1);
INSERT INTO `bls_sentence_rule` VALUES (22, 1, 94, 1);
INSERT INTO `bls_sentence_rule` VALUES (23, 1, 99, 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_sentence_user
-- ----------------------------
DROP TABLE IF EXISTS `bls_sentence_user`;
CREATE TABLE `bls_sentence_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `sentence_id` bigint NOT NULL COMMENT '句型ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态：0：禁用，1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用于记录参与创建或修改句型的用户';

-- ----------------------------
-- Records of bls_sentence_user
-- ----------------------------
BEGIN;
INSERT INTO `bls_sentence_user` VALUES (1, 1, 4, '2021-06-22 10:26:57', 1);
INSERT INTO `bls_sentence_user` VALUES (2, 2, 4, '2021-06-22 10:27:49', 1);
INSERT INTO `bls_sentence_user` VALUES (3, 3, 4, '2021-06-22 10:28:26', 1);
INSERT INTO `bls_sentence_user` VALUES (4, 4, 4, '2021-06-22 10:28:58', 1);
INSERT INTO `bls_sentence_user` VALUES (5, 5, 4, '2021-06-22 10:29:30', 1);
INSERT INTO `bls_sentence_user` VALUES (6, 6, 4, '2021-06-22 10:30:11', 1);
INSERT INTO `bls_sentence_user` VALUES (7, 7, 4, '2021-06-22 10:30:46', 1);
INSERT INTO `bls_sentence_user` VALUES (8, 8, 4, '2021-06-22 10:31:23', 1);
INSERT INTO `bls_sentence_user` VALUES (9, 9, 4, '2021-06-22 10:32:05', 1);
INSERT INTO `bls_sentence_user` VALUES (10, 10, 4, '2021-06-22 10:32:44', 1);
INSERT INTO `bls_sentence_user` VALUES (11, 11, 4, '2021-06-22 10:33:15', 1);
INSERT INTO `bls_sentence_user` VALUES (12, 12, 4, '2021-06-22 10:34:00', 1);
INSERT INTO `bls_sentence_user` VALUES (13, 13, 4, '2021-06-22 10:34:40', 1);
INSERT INTO `bls_sentence_user` VALUES (14, 14, 4, '2021-06-22 10:35:20', 1);
INSERT INTO `bls_sentence_user` VALUES (15, 15, 4, '2021-06-22 10:35:53', 1);
INSERT INTO `bls_sentence_user` VALUES (16, 16, 4, '2021-06-22 10:36:27', 1);
INSERT INTO `bls_sentence_user` VALUES (17, 17, 4, '2021-06-22 10:37:02', 1);
INSERT INTO `bls_sentence_user` VALUES (18, 18, 4, '2021-06-22 10:37:30', 1);
INSERT INTO `bls_sentence_user` VALUES (19, 19, 4, '2021-06-22 10:37:59', 1);
INSERT INTO `bls_sentence_user` VALUES (20, 20, 4, '2021-06-22 10:38:49', 1);
INSERT INTO `bls_sentence_user` VALUES (21, 21, 4, '2021-06-22 10:39:22', 1);
INSERT INTO `bls_sentence_user` VALUES (22, 22, 4, '2021-06-22 10:39:52', 1);
INSERT INTO `bls_sentence_user` VALUES (23, 23, 4, '2021-06-22 10:40:22', 1);
INSERT INTO `bls_sentence_user` VALUES (24, 24, 4, '2021-06-22 10:40:58', 1);
INSERT INTO `bls_sentence_user` VALUES (25, 25, 4, '2021-06-22 10:41:35', 1);
INSERT INTO `bls_sentence_user` VALUES (26, 26, 3, '2021-06-25 16:25:18', 1);
INSERT INTO `bls_sentence_user` VALUES (27, 27, 3, '2021-06-25 16:25:49', 1);
INSERT INTO `bls_sentence_user` VALUES (28, 28, 3, '2021-06-25 16:26:18', 1);
INSERT INTO `bls_sentence_user` VALUES (29, 29, 3, '2021-06-25 16:26:33', 1);
INSERT INTO `bls_sentence_user` VALUES (30, 30, 3, '2021-06-25 16:26:55', 1);
INSERT INTO `bls_sentence_user` VALUES (31, 31, 3, '2021-06-25 16:28:14', 1);
INSERT INTO `bls_sentence_user` VALUES (32, 32, 3, '2021-06-25 16:28:32', 1);
INSERT INTO `bls_sentence_user` VALUES (33, 33, 3, '2021-06-25 16:28:53', 1);
INSERT INTO `bls_sentence_user` VALUES (34, 34, 3, '2021-06-25 16:29:25', 1);
INSERT INTO `bls_sentence_user` VALUES (35, 35, 3, '2021-06-25 16:30:00', 1);
INSERT INTO `bls_sentence_user` VALUES (36, 36, 3, '2021-06-25 16:30:53', 1);
INSERT INTO `bls_sentence_user` VALUES (37, 37, 3, '2021-06-25 16:31:13', 1);
INSERT INTO `bls_sentence_user` VALUES (38, 38, 3, '2021-06-25 16:32:20', 1);
INSERT INTO `bls_sentence_user` VALUES (39, 39, 3, '2021-06-25 16:32:43', 1);
INSERT INTO `bls_sentence_user` VALUES (40, 40, 3, '2021-06-25 16:33:08', 1);
INSERT INTO `bls_sentence_user` VALUES (41, 41, 3, '2021-06-25 16:34:21', 1);
INSERT INTO `bls_sentence_user` VALUES (42, 42, 3, '2021-06-25 16:34:57', 1);
INSERT INTO `bls_sentence_user` VALUES (43, 43, 3, '2021-06-25 16:35:44', 1);
INSERT INTO `bls_sentence_user` VALUES (44, 44, 3, '2021-06-25 16:36:26', 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_user
-- ----------------------------
DROP TABLE IF EXISTS `bls_user`;
CREATE TABLE `bls_user` (
  `user_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一标识帮语用户',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
  `salt` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码加的盐',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户手机号',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户邮箱',
  `head` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户头像',
  `register_date` datetime DEFAULT NULL COMMENT '用户注册时间',
  `last_login_date` datetime DEFAULT NULL COMMENT '上一次登陆时间',
  `login_count` int DEFAULT '0' COMMENT '登陆次数',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态  0：禁用  1：正常',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_user
-- ----------------------------
BEGIN;
INSERT INTO `bls_user` VALUES (1, 'visitor', '游客', '6cf5481d7250552812ea5596c7f0c248', '4NUJulZ&GrdG', NULL, NULL, NULL, '2021-05-22 15:20:49', '2021-05-22 15:20:53', 1, 1);
INSERT INTO `bls_user` VALUES (2, 'liwei', '黎威', '6b63d04f80af99ae5cde482a3559c459', '(UjrELVjqwof', '13387603239', '1011529903@qq.com', NULL, '2021-05-22 15:21:45', '2021-05-22 15:21:47', 17, 1);
INSERT INTO `bls_user` VALUES (3, 'chencongying', '陈聪颖', 'c9da383357b25f5136da98e1a9ef5113', 'GDQ9j#4nBP3)', NULL, NULL, NULL, '2021-05-24 11:26:37', '2021-05-24 11:26:42', 6, 1);
INSERT INTO `bls_user` VALUES (4, 'xujiankang', '徐健康', 'a52d8d5577a09a209759f1950a3a9fad', 'c@8JSeY4969D', NULL, NULL, NULL, '2021-05-24 11:27:34', '2021-05-24 11:27:37', 6, 1);
INSERT INTO `bls_user` VALUES (5, 'liangzihao', '梁子豪', 'e045a1eef350ef21d4f9e30c08d4b49c', 'UsBpvRyvXpIY', NULL, NULL, NULL, '2021-05-24 11:28:02', '2021-05-24 11:28:05', 1, 1);
INSERT INTO `bls_user` VALUES (6, 'liuyuemei', '刘月梅', 'ed5acbd5973a8cafd7f1b2aee4b657df', '0wvzsXW)mgPD', NULL, NULL, NULL, '2021-05-24 11:28:30', '2021-05-24 11:28:33', 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_user_role
-- ----------------------------
DROP TABLE IF EXISTS `bls_user_role`;
CREATE TABLE `bls_user_role` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '表唯一标识',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `role_id` bigint NOT NULL COMMENT '角色id',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态  0：禁用  1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_user_role
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for bls_word
-- ----------------------------
DROP TABLE IF EXISTS `bls_word`;
CREATE TABLE `bls_word` (
  `word_id` bigint NOT NULL AUTO_INCREMENT,
  `name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '词本身',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '相关描述',
  `example` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '关于该词的相关举例',
  `type` int DEFAULT NULL COMMENT '类别：1：名词 2：动词 3：形容词 4：副词 5：数词 6：量词 7：代词 8：叹词  9：拟声词 10：介词 11：连词 12：助词',
  `synonym` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '同义词，表示同一个含义的词，仅取一个作为word保存，其他的全部放到这里',
  `creator_id` bigint NOT NULL COMMENT '创建者用户ID',
  `editor_id` bigint NOT NULL COMMENT '最近一次修改者用户ID',
  `update_time` datetime DEFAULT NULL COMMENT '最近一次修改时间',
  `is_type_in` int NOT NULL DEFAULT '0' COMMENT '0:未录入，1：已录入',
  `status` int NOT NULL DEFAULT '1' COMMENT '0:禁用 1：待开发 2： 开发中 3：待审核 4：待发布 5：已发布',
  PRIMARY KEY (`word_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='帮语词汇表';

-- ----------------------------
-- Records of bls_word
-- ----------------------------
BEGIN;
INSERT INTO `bls_word` VALUES (1, '机构', '表示支撑平台中的机构实体，与支撑平台相关，属于名词词汇。', '创建机构', 1, NULL, 4, 4, '2021-06-22 00:28:27', 1, 1);
INSERT INTO `bls_word` VALUES (2, '部门', '表示支撑平台中的部门实体，范围上属于机构的子集，是机构的下一级单位。', '创建部门', 1, NULL, 4, 4, '2021-06-22 00:33:31', 1, 1);
INSERT INTO `bls_word` VALUES (3, '父部门', '是指某个部门的直接上级部门，只有一个，需要以某个部门为基才能定位其父部门。', '', 1, NULL, 4, 4, '2021-06-22 00:34:38', 1, 1);
INSERT INTO `bls_word` VALUES (4, '上级部门', '指某个部门的所有上级部门，即遍历获得父部门的父部门，返回的部门数量可能不止一个。', '', 1, NULL, 4, 4, '2021-06-22 00:35:03', 1, 1);
INSERT INTO `bls_word` VALUES (5, '子部门', '是指某个部门的下级部门，可能不止一个，所以可能返回空或一个部门或部门集合。', '', 1, NULL, 4, 4, '2021-06-22 00:35:38', 1, 1);
INSERT INTO `bls_word` VALUES (6, '下级部门', '词法规则名和语义同“子部门”。', '', 1, NULL, 4, 4, '2021-06-22 00:36:04', 1, 1);
INSERT INTO `bls_word` VALUES (7, '帮区', '表示支撑平台中的“帮区”实体，属于部门的一个子属性，对部门的各属性管理实质上是在部门的主帮区中进行。', '', 1, NULL, 4, 4, '2021-06-22 00:36:59', 1, 1);
INSERT INTO `bls_word` VALUES (8, '父帮区', '指某个帮区的直接上一级帮区，仅指代直接父帮区，所以返回结果是零或一个帮区，需要以某个帮区为基才能定位其父帮区。', '', 1, NULL, 4, 4, '2021-06-22 00:37:29', 1, 1);
INSERT INTO `bls_word` VALUES (9, '子帮区', '是指某个帮区的下级帮区，可能不止一个，所以可能返回空或一个帮区或帮区集合。', '', 1, NULL, 4, 4, '2021-06-22 00:41:03', 1, 1);
INSERT INTO `bls_word` VALUES (10, '岗位', '岗位实际上是多个成员组成的一个集合，形成了“岗位”实体，岗位存在于机构、部门和帮区中，对岗位的管理实际上就是对属性归成同一类的成员们的管理。', '', 1, NULL, 4, 4, '2021-06-22 00:41:53', 1, 1);
INSERT INTO `bls_word` VALUES (11, '成员', '成员是机构、部门和帮区里的人员，对于成员的管理通常有添加、移除等操作。具体的管理操作也是需要在语句中和谓语动词结合才能确定。', '', 1, NULL, 4, 4, '2021-06-22 00:43:05', 1, 1);
INSERT INTO `bls_word` VALUES (12, '工具', '工具是属于帮区中的一个属性，是构成帮区所必不可少的元素。对“工具”词汇的使用通常是调用运行，或指定工具中的具体运行部件后得到返回结果。', '', 1, NULL, 4, 4, '2021-06-22 00:43:51', 1, 1);
INSERT INTO `bls_word` VALUES (13, '角色', '权限在支撑平台的体现具体在对角色的定义上，不同角色拥有不同的权限。对用户或岗位添加角色，即对其授予了角色对应的权限。', '', 1, NULL, 4, 4, '2021-06-22 00:44:16', 1, 1);
INSERT INTO `bls_word` VALUES (14, '权限', '权限即是指用户在支撑平台能够活动的权力，需要和具体的角色词汇搭配，使用该词汇通常就是对用户和岗位在平台上的权限控制，如授予权限或移除权限。', '', 1, NULL, 4, 4, '2021-06-22 00:44:38', 1, 1);
INSERT INTO `bls_word` VALUES (15, '言者', '指言者角色，在支撑平台上意指“speak”的只可发言，没有读写文档、运行工具的其他权限。在语句中使用时，通常表示对用户和岗位在言者角色上进行有关管理操作。', '', 1, NULL, 4, 4, '2021-06-22 00:45:45', 1, 1);
INSERT INTO `bls_word` VALUES (16, '读者', '指读者角色，在言者角色的基础上多了可读文档的权限，在支撑平台上意指“speak ,read”的可发言和可读文档权限。在语句中使用时，通常表示要对用户和岗位在读者角色进行有关管理操作。', '', 1, NULL, 4, 4, '2021-06-22 00:46:14', 1, 1);
INSERT INTO `bls_word` VALUES (17, '写者', '指写者角色，在读者角色的基础上多了写的权限，在支撑平台上意指“speak ,read ,write”的可发言、可读写文档的权限。在语句中使用时，通常表示要对用户和岗位在写者角色进行有关管理操作。', '', 1, NULL, 4, 4, '2021-06-22 00:46:43', 1, 1);
INSERT INTO `bls_word` VALUES (18, '工者', '指工者角色，在写者角色的基础上多了可在帮区内运行工具的权限，在支撑平台上意指“speak, read ,write, execute”的可发言、可读写文档和可运行工具权限。在语句中使用时，通常表示要对用户和岗位在工者角色进行有关管理操作。', '', 1, NULL, 4, 4, '2021-06-22 00:49:41', 1, 1);
INSERT INTO `bls_word` VALUES (19, '管理员', '指在机构中拥有最高管理权限的用户，或称作机构管理员。', '', 1, NULL, 4, 4, '2021-06-22 00:50:21', 1, 1);
INSERT INTO `bls_word` VALUES (20, '剧本', '剧本是帮语运行的基本元素，用帮语描述出可运行的一句话就可保存为一个剧本。使用该词汇时，常涉及到对剧本实体的相关操作，如保存剧本、运行剧本等。', '', 1, NULL, 4, 4, '2021-06-22 00:50:54', 1, 1);
INSERT INTO `bls_word` VALUES (21, '文档', '指支撑平台中帮区的主要组成元素之一，使用该词汇即表示要对帮区资料柜中文档的相关操作。', '', 1, NULL, 4, 4, '2021-06-22 00:51:20', 1, 1);
INSERT INTO `bls_word` VALUES (22, '消息板', '指支撑平台中帮区的主要组成元素，是用户在帮区中交流的一个聊天室。', '', 1, NULL, 4, 4, '2021-06-22 00:51:44', 1, 1);
INSERT INTO `bls_word` VALUES (23, '最大权限', '是指在对用户或岗位授权时，和机构管理员有同等级别的管理权限。', '', 1, NULL, 4, 4, '2021-06-22 00:52:12', 1, 1);
INSERT INTO `bls_word` VALUES (24, '最高权限', '词法规则名和语义同“最大权限”。', '', 1, NULL, 4, 4, '2021-06-22 00:52:32', 0, 1);
INSERT INTO `bls_word` VALUES (25, '最小权限', '机构中的普通用户且在角色授权上只有言者的权限。', '', 1, NULL, 4, 4, '2021-06-22 00:52:53', 1, 1);
INSERT INTO `bls_word` VALUES (26, '最低权限', '词法规则名和语义同“最小权限”。', '', 1, NULL, 4, 4, '2021-06-22 00:53:18', 0, 1);
INSERT INTO `bls_word` VALUES (27, '有效期', '与授权的操作语句有关，限定权限的生效时长，过期则失效。', '', 1, NULL, 4, 4, '2021-06-22 00:53:41', 1, 1);
INSERT INTO `bls_word` VALUES (28, '有效时长', '词法规则名和语义同“有效期”。', '', 1, NULL, 4, 4, '2021-06-22 00:54:01', 0, 1);
INSERT INTO `bls_word` VALUES (29, '新员工', '表示机构成员中刚入职，工作期限不超过规定时长的成员，是一类成员的集合。', '', 1, NULL, 4, 4, '2021-06-22 00:54:21', 1, 1);
INSERT INTO `bls_word` VALUES (30, '老员工', '表示工作期限超过一定时长，且仍然在职的员工，也是属于成员的集合。', '', 1, NULL, 4, 4, '2021-06-22 00:54:41', 1, 1);
INSERT INTO `bls_word` VALUES (31, '显示', '意指要显示一些内容给用户看，实际是在接口中对数据库的查询操作，需要结合其后跟随的宾语内容，将查询到或返回的结果显示给用户。显示的格式可以是文本字符串、JSON数据等。通常执行完之后会在语境的结果显示栈中压入返回结果，最终将栈中的结果显示给用户。', '', 2, NULL, 4, 4, '2021-06-22 00:55:14', 1, 1);
INSERT INTO `bls_word` VALUES (32, '列出', '词法规则名和语义同“显示”。', '', 2, NULL, 4, 4, '2021-06-22 01:01:39', 1, 1);
INSERT INTO `bls_word` VALUES (33, '查看', '词法规则名和语义同“显示”。', '', 2, NULL, 4, 4, '2021-06-22 00:56:20', 1, 1);
INSERT INTO `bls_word` VALUES (34, '创建', '在机构管理场景下，通常指对一个实体的创建，是从无到有的一个概念，其后通常跟说明名称的标识符和一个实体名词，对应一次创建并命名实体的动作。', '', 2, NULL, 4, 4, '2021-06-22 00:56:45', 1, 1);
INSERT INTO `bls_word` VALUES (35, '新建', '词法规则名和语义同“创建”。', '', 2, NULL, 4, 4, '2021-06-22 00:57:12', 0, 1);
INSERT INTO `bls_word` VALUES (36, '新增', '词法规则名和语义同“创建”。', '', 2, NULL, 4, 4, '2021-06-22 00:57:34', 0, 1);
INSERT INTO `bls_word` VALUES (37, '添加', '是对用户添加到机构或部门等平台实体的动作，对支撑平台中已存在的实体的操作，需要搭配用户和要拉入的地点标识符才能对整个动作补全。实际映射在底层数据库中是对库表新增一条字段。', '', 2, NULL, 4, 4, '2021-06-22 00:58:00', 1, 1);
INSERT INTO `bls_word` VALUES (38, '加入', '词法规则名和语义同“添加”。', '', 2, NULL, 4, 4, '2021-06-22 01:01:22', 0, 1);
INSERT INTO `bls_word` VALUES (39, '加入到', '词法规则名和语义同“添加”。', '', 2, NULL, 4, 4, '2021-06-22 00:59:35', 0, 1);
INSERT INTO `bls_word` VALUES (40, '拉入', '词法规则名和语义同“添加”。', '', 2, NULL, 4, 4, '2021-06-22 01:00:50', 0, 1);
INSERT INTO `bls_word` VALUES (41, '拉入到', '词法规则名和语义同“添加”。', '', 2, NULL, 4, 4, '2021-06-22 01:00:18', 0, 1);
INSERT INTO `bls_word` VALUES (42, '撤消', '表示对部门的管理操作，把部门从机构中撤消掉。', '', 2, NULL, 4, 4, '2021-06-22 01:02:23', 1, 1);
INSERT INTO `bls_word` VALUES (43, '撤消掉', '词法规则名和语义同“撤消”。', '', 2, NULL, 4, 4, '2021-06-22 01:02:43', 0, 1);
INSERT INTO `bls_word` VALUES (44, '设定', '表示设定一个属性的动词，在机构基本管理场景中常用于设定权限的有效期。', '', 2, NULL, 4, 4, '2021-06-22 01:03:02', 1, 1);
INSERT INTO `bls_word` VALUES (45, '更换', '常用于更换岗位，成员从一个岗位更换为另一个岗位。', '', 2, NULL, 4, 4, '2021-06-22 01:03:22', 1, 1);
INSERT INTO `bls_word` VALUES (46, '更换到', '词法规则名和语义同“更换”。', '', 2, NULL, 4, 4, '2021-06-22 01:03:57', 0, 1);
INSERT INTO `bls_word` VALUES (47, '修改', '修改一个实体或属性的动作，映射在数据库中是对某个字段数据的修改。', '', 2, NULL, 4, 4, '2021-06-22 01:04:19', 1, 1);
INSERT INTO `bls_word` VALUES (48, '修改为', '词法规则名和语义同“修改”。', '', 2, NULL, 4, 4, '2021-06-22 01:04:40', 0, 1);
INSERT INTO `bls_word` VALUES (49, '删除', '删除一个实体或实体属性的动作，映射在数据库中是删除某条字段或字段中的数据。', '', 2, NULL, 4, 4, '2021-06-22 01:05:10', 1, 1);
INSERT INTO `bls_word` VALUES (50, '剔除', '词法规则名和语义同“删除”。', '', 2, NULL, 4, 4, '2021-06-22 01:05:38', 0, 1);
INSERT INTO `bls_word` VALUES (51, '移除', '词法规则名和语义同“删除”。', '', 2, NULL, 4, 4, '2021-06-22 01:05:57', 0, 1);
INSERT INTO `bls_word` VALUES (52, '去除', '词法规则名和语义同“删除”。', '', 2, NULL, 4, 4, '2021-06-22 01:06:16', 0, 1);
INSERT INTO `bls_word` VALUES (53, '删掉', '词法规则名和语义同“删除”。', '', 2, NULL, 4, 4, '2021-06-22 01:06:38', 0, 1);
INSERT INTO `bls_word` VALUES (54, '合并', '对部门的管理，表示将两个部门合并为一个。', '', 2, NULL, 4, 4, '2021-06-22 01:06:58', 1, 1);
INSERT INTO `bls_word` VALUES (55, '合并为', '词法规则名和语义同“合并”。', '', 2, NULL, 4, 4, '2021-06-22 01:07:17', 0, 1);
INSERT INTO `bls_word` VALUES (56, '合并到', '词法规则名和语义同“合并”。', '', 2, NULL, 4, 4, '2021-06-22 01:07:37', 0, 1);
INSERT INTO `bls_word` VALUES (57, '移动', '表示将部门移动到另一个部门中，作为其下的子部门。', '', 2, NULL, 4, 4, '2021-06-22 01:08:00', 1, 1);
INSERT INTO `bls_word` VALUES (58, '移动到', '词法规则名和语义同“移动”。', '', 2, NULL, 4, 4, '2021-06-22 01:08:19', 0, 1);
INSERT INTO `bls_word` VALUES (59, '任命', '表示对某个成员任命岗位。', '', 2, NULL, 4, 4, '2021-06-22 01:08:39', 1, 1);
INSERT INTO `bls_word` VALUES (60, '安排', '词法规则名和语义同“任命”。', '', 2, NULL, 4, 4, '2021-06-22 01:09:01', 0, 1);
INSERT INTO `bls_word` VALUES (61, '免除', '对成员的岗位管理操作，表示免除成员的岗位。', '', 2, NULL, 4, 4, '2021-06-22 01:09:20', 1, 1);
INSERT INTO `bls_word` VALUES (62, '授予', '对权限的操作，通常是给用户或岗位授予某个角色的动作。', '', 2, NULL, 4, 4, '2021-06-22 01:09:43', 1, 1);
INSERT INTO `bls_word` VALUES (63, '停用', '对工具的操作，在帮区中对工具停用，暂停工具使用，需要指定帮区地点和要停用的工具。', '', 2, NULL, 4, 4, '2021-06-22 01:10:08', 1, 1);
INSERT INTO `bls_word` VALUES (64, '启用', '对工具的操作，和停用相反，是在帮区实体中对工具启用，恢复工具的正常运行使用。', '', 2, NULL, 4, 4, '2021-06-22 01:10:29', 1, 1);
INSERT INTO `bls_word` VALUES (65, '发消息', '调用支撑平台发消息接口，在某个消息板中发送一条消息。', '', 2, NULL, 4, 4, '2021-06-22 01:10:51', 1, 1);
INSERT INTO `bls_word` VALUES (66, '通知', '词法规则名和语义同“发消息”。', '', 2, NULL, 4, 4, '2021-06-22 01:11:16', 0, 1);
INSERT INTO `bls_word` VALUES (67, '吸收', '对人员的接收，属于对人员添加的另一种表述，在语句的描述结构上略有不同。', '', 2, NULL, 4, 4, '2021-06-22 01:11:37', 1, 1);
INSERT INTO `bls_word` VALUES (68, '接纳', '词法规则名和语义同“吸收”。', '', 2, NULL, 4, 4, '2021-06-22 01:12:00', 0, 1);
INSERT INTO `bls_word` VALUES (69, '派遣到', '属于对人员派驻到某地工作，不会对其所在原部门或岗位造成影响。描述形式上为“把人员派遣到某处”。', '', 2, NULL, 4, 4, '2021-06-22 01:12:20', 1, 1);
INSERT INTO `bls_word` VALUES (70, '分派到', '词法规则名和语义同“派遣到”。', '', 2, NULL, 4, 4, '2021-06-22 01:12:43', 0, 1);
INSERT INTO `bls_word` VALUES (71, '发布', '属于支撑平台的发布操作，对帮区中的资源如文档的发布。', '', 2, NULL, 4, 4, '2021-06-22 01:13:02', 1, 1);
INSERT INTO `bls_word` VALUES (72, '发布到', '词法规则名和语义同“发布”。', '', 2, NULL, 4, 4, '2021-06-22 01:13:22', 0, 1);
INSERT INTO `bls_word` VALUES (73, '发布给', '词法规则名和语义同“发布”。', '', 2, NULL, 4, 4, '2021-06-22 01:13:50', 0, 1);
INSERT INTO `bls_word` VALUES (74, '取消发布', '对资源的取消发布，其后跟发布的名称。', '', 2, NULL, 4, 4, '2021-06-22 01:14:09', 1, 1);
INSERT INTO `bls_word` VALUES (75, '存在', '表示对实体对象的判断，在支撑平台中是否拥有该对象。', '', 2, NULL, 4, 4, '2021-06-22 01:14:30', 1, 1);
INSERT INTO `bls_word` VALUES (76, '不存在', '表示对实体对象的判断，在支撑平台中是否不存在该对象。', '', 2, NULL, 4, 4, '2021-06-22 01:14:51', 1, 1);
INSERT INTO `bls_word` VALUES (77, '出现', '对成员和岗位的约束，约定其在某些部门必须出现。', '', 2, NULL, 4, 4, '2021-06-22 01:15:13', 1, 1);
INSERT INTO `bls_word` VALUES (78, '出现在', '词法规则名和语义同“出现”。', '', 2, NULL, 4, 4, '2021-06-22 01:15:34', 0, 1);
INSERT INTO `bls_word` VALUES (79, '要出现在', '词法规则名和语义同“出现”。', '', 2, NULL, 4, 4, '2021-06-22 01:15:52', 0, 1);
INSERT INTO `bls_word` VALUES (80, '拥有', '是对实体对象的一种授予动作，其后接宾语表示主语对象必须要包含该宾语属性。', '', 2, NULL, 4, 4, '2021-06-22 01:16:31', 1, 1);
INSERT INTO `bls_word` VALUES (81, '要拥有', '词法规则名和语义同“拥有”。', '', 2, NULL, 4, 4, '2021-06-22 01:17:25', 0, 1);
INSERT INTO `bls_word` VALUES (82, '在职的', '目前仍在机构中的人员即是在职状态，修饰机构中的人员。', '', 3, NULL, 4, 4, '2021-06-22 09:51:13', 1, 1);
INSERT INTO `bls_word` VALUES (83, '离职的', '和“在职的”相反，不在机构中受命的即是已离职。', '', 3, NULL, 4, 4, '2021-06-22 09:52:20', 1, 1);
INSERT INTO `bls_word` VALUES (84, '在', '方位介词，和表示地点或时间的标识符构成状语短语。', '', 10, NULL, 4, 4, '2021-06-22 09:52:58', 1, 1);
INSERT INTO `bls_word` VALUES (85, '于', '词法规则名和语义同“在”。', '', 10, NULL, 4, 4, '2021-06-22 09:53:41', 0, 1);
INSERT INTO `bls_word` VALUES (86, '把', '介词，表示要指向的实体对象。', '', 10, NULL, 4, 4, '2021-06-22 09:54:09', 1, 1);
INSERT INTO `bls_word` VALUES (87, '将', '词法规则名和语义同“把”。', '', 10, NULL, 4, 4, '2021-06-22 09:54:37', 0, 1);
INSERT INTO `bls_word` VALUES (88, '为', '词法规则名和语义同“把”。', '', 10, NULL, 4, 4, '2021-06-22 09:55:15', 0, 1);
INSERT INTO `bls_word` VALUES (89, '对', '词法规则名和语义同“把”。', '', 10, NULL, 4, 4, '2021-06-22 09:55:53', 0, 1);
INSERT INTO `bls_word` VALUES (90, '给', '词法规则名和语义同“把”。', '', 10, NULL, 4, 4, '2021-06-22 09:56:21', 0, 1);
INSERT INTO `bls_word` VALUES (91, '从', '介词，表示从某处，其后接标识符。', '', 10, NULL, 4, 4, '2021-06-22 09:56:45', 1, 1);
INSERT INTO `bls_word` VALUES (92, '个', '和数字搭配使用的量词，表示次数。', '', 6, NULL, 4, 4, '2021-06-22 09:57:17', 1, 1);
INSERT INTO `bls_word` VALUES (93, '条', '常和数字搭配使用的量词，表示数量。词法规则名同“个”。', '', 6, NULL, 4, 4, '2021-06-22 09:57:42', 0, 1);
INSERT INTO `bls_word` VALUES (94, '次', '常和数字搭配使用的量词，表示次数。词法规则名同“个”。', '', 6, NULL, 4, 4, '2021-06-22 09:58:17', 0, 1);
INSERT INTO `bls_word` VALUES (95, '分钟', '时间单位，和数字组合表示时长。', '', 6, NULL, 4, 4, '2021-06-22 10:03:09', 1, 1);
INSERT INTO `bls_word` VALUES (96, '小时', '以小时为时间单位，词法规则名同“分钟”。', '', 6, NULL, 4, 4, '2021-06-22 10:03:35', 0, 1);
INSERT INTO `bls_word` VALUES (97, '天', '以天为时间单位，词法规则名同“分钟”。', '', 6, NULL, 4, 4, '2021-06-22 10:05:28', 0, 1);
INSERT INTO `bls_word` VALUES (98, '月', '以月为时间单位，词法规则名同“分钟”。', '', 6, NULL, 4, 4, '2021-06-22 10:07:26', 0, 1);
INSERT INTO `bls_word` VALUES (99, '年', '以年为时间单位，词法规则名同“分钟”。', '', 6, NULL, 4, 4, '2021-06-22 10:08:20', 0, 1);
INSERT INTO `bls_word` VALUES (100, '大于', '表示对两个对象的属性值进行比较，前者比后者大则为真返回True。', '', 2, NULL, 4, 4, '2021-06-22 10:14:44', 1, 1);
INSERT INTO `bls_word` VALUES (101, '大于等于', '两者比较同时包含相等的情况。词法规则名同“大于”。', '', 2, NULL, 4, 4, '2021-06-22 10:15:12', 0, 1);
INSERT INTO `bls_word` VALUES (102, '小于', '表示对两个对象的属性值进行比较，前者比后者小则为真返回True。', '', 2, NULL, 4, 4, '2021-06-22 10:15:36', 1, 1);
INSERT INTO `bls_word` VALUES (103, '小于等于', '两者比较同时包含相等的情况。词法规则名同“小于”。', '', 2, NULL, 4, 4, '2021-06-22 10:15:58', 0, 1);
INSERT INTO `bls_word` VALUES (104, '等于', '表示对两个对象的属性值或直接对具体值进行比较，两者相等则为真返回True。', '', 2, NULL, 4, 4, '2021-06-22 10:16:22', 1, 1);
INSERT INTO `bls_word` VALUES (105, '或', '表示连接的两个逻辑判断满足其一即为真。', '', 11, NULL, 4, 4, '2021-06-22 10:20:25', 1, 1);
INSERT INTO `bls_word` VALUES (106, '且', '表示连接的两个逻辑判断必须全部满足才为真。', '', 11, NULL, 4, 4, '2021-06-22 10:20:52', 1, 1);
INSERT INTO `bls_word` VALUES (107, '中', '表示方位的介词，可以和“在”加上表示地点的标识符构成状语短语。', '', 10, NULL, 4, 4, '2021-06-22 10:21:18', 1, 1);
INSERT INTO `bls_word` VALUES (108, '里', '词法规则名和语义同“中”。', '', 10, NULL, 4, 4, '2021-06-22 10:21:45', 0, 1);
INSERT INTO `bls_word` VALUES (109, '内', '词法规则名和语义同“中”。', '', 10, NULL, 4, 4, '2021-06-22 10:22:10', 0, 1);
INSERT INTO `bls_word` VALUES (110, '如果', '关系连词，其后连接子句，表示对该句的条件判断，在帮语中形成复合句“如果…，则…”句式。', '', 11, NULL, 4, 4, '2021-06-22 10:22:39', 1, 1);
INSERT INTO `bls_word` VALUES (111, '假如', '词法规则名和语义同“如果”。', '', 11, NULL, 4, 4, '2021-06-22 10:23:09', 0, 1);
INSERT INTO `bls_word` VALUES (112, '则', '通常和“如果”搭配，当“如果”的子句条件判断满足，才执行“则”连接的子句。', '', 11, NULL, 4, 4, '2021-06-22 10:23:37', 1, 1);
INSERT INTO `bls_word` VALUES (113, '那么', '词法规则名和语义同“则”。', '', 11, NULL, 4, 4, '2021-06-22 10:24:00', 0, 1);
INSERT INTO `bls_word` VALUES (114, '否则', '表示子句间的连接关系，和“如果”“则”连词搭配，当“如果”后的子句判断条件不满足时，不执行“则”后的子句，而执行“否则”分支的语句。', '', 11, NULL, 4, 4, '2021-06-22 10:24:30', 1, 1);
INSERT INTO `bls_word` VALUES (115, '同时', '连接两个句子的连接词，句子间没有约束关系，都要对其执行。', '', 11, NULL, 4, 4, '2021-06-22 10:25:14', 1, 1);
INSERT INTO `bls_word` VALUES (116, '并', '词法规则名和语义同“同时”。', '', 11, NULL, 4, 4, '2021-06-22 10:25:36', 0, 1);
INSERT INTO `bls_word` VALUES (117, '显示', '将后面跟随的词汇所表示的内容显示到页面上', '显示 张三 的 姓名', 2, NULL, 3, 3, '2021-06-25 16:01:59', 1, 1);
INSERT INTO `bls_word` VALUES (118, '得到', '表明要获取哪些功能接口的返回结果', '执行 通讯录工具 ， 得到 我的通讯录', 2, NULL, 3, 3, '2021-06-25 16:03:18', 1, 1);
INSERT INTO `bls_word` VALUES (119, '设定	', '对于某个词汇进行定义，用于设定句型', '设定 姓名 = 张三', 2, NULL, 3, 3, '2021-06-25 16:03:51', 1, 1);
INSERT INTO `bls_word` VALUES (120, '改成', '将某个属性修改为某个值', '将 张三 的 年龄 改成  18', 2, NULL, 3, 3, '2021-06-25 16:04:23', 1, 1);
INSERT INTO `bls_word` VALUES (121, '新建', '创建一个对象', '新建 对象A', 2, NULL, 3, 3, '2021-06-25 16:05:12', 1, 1);
INSERT INTO `bls_word` VALUES (122, '重命名为	', '将某个对象进行重命名', '将 我的通讯录 重命名为 通讯录', 2, NULL, 3, 3, '2021-06-25 16:05:44', 1, 1);
INSERT INTO `bls_word` VALUES (123, '找出	', '在某个集合中查询出符合条件的记录', '找出 通讯录 中 年龄 大于 10 的 元素', 2, NULL, 3, 3, '2021-06-25 16:06:25', 1, 1);
INSERT INTO `bls_word` VALUES (124, '去掉	', '在某个集合中删除那些符合条件的记录', '去掉 通讯录 中 年龄 大于 10 的 元素', 2, NULL, 3, 3, '2021-06-25 16:07:01', 1, 1);
INSERT INTO `bls_word` VALUES (125, '统计', '统计某个集合中符合条件的对象的数量，并显示到页面上', '统计 通讯录 的 数量', 2, NULL, 3, 3, '2021-06-25 16:07:30', 1, 1);
INSERT INTO `bls_word` VALUES (126, '删除', '删除后面跟的词所代表的对象', '删除 通讯录', 2, NULL, 3, 3, '2021-06-25 16:07:50', 1, 1);
INSERT INTO `bls_word` VALUES (127, '进行分组', '将集合对象按照某个属性进行分组，分组之后的记录，属性相同的会存放在一起', '将 通讯录 按照 性别 进行分组', 2, NULL, 3, 3, '2021-06-25 16:08:23', 1, 1);
INSERT INTO `bls_word` VALUES (128, '合并成为', '将若干个对象合并成为一个对象', '将 通讯录A 、通讯录B 合并成为 通讯录', 2, NULL, 3, 3, '2021-06-25 16:08:54', 1, 1);
INSERT INTO `bls_word` VALUES (129, '添加', '往某个集合对象中添加单个对象', '在 通讯录 中 添加 张三联系方式', 2, NULL, 3, 3, '2021-06-25 16:09:28', 0, 1);
INSERT INTO `bls_word` VALUES (130, '执行', '执行某个工具或者某条语句', '执行 通讯录工具', 2, NULL, 3, 3, '2021-06-25 16:10:11', 1, 1);
INSERT INTO `bls_word` VALUES (131, '升序排序', '对于集合对象按照数字大小由小到大进行排序', '将 通讯录 按照 年龄 进行 升序排序', 2, NULL, 3, 3, '2021-06-25 16:10:39', 1, 1);
INSERT INTO `bls_word` VALUES (132, '降序排序', '对于集合对象按照数字大小由大到小进行排序', '将 通讯录 按照 年龄 进行 降序排序', 2, NULL, 3, 3, '2021-06-25 16:11:09', 1, 1);
INSERT INTO `bls_word` VALUES (133, '拷贝一份为	', '拷贝某个对象，形成新的对象', '将 通讯录 拷贝一份为 通讯录备份', 2, NULL, 3, 3, '2021-06-25 16:11:43', 0, 1);
INSERT INTO `bls_word` VALUES (134, '输入部件', '代指调用工具功能接口需要的参数以及这些参数所表示的含义', '通讯录工具 的 输入部件', 1, NULL, 3, 3, '2021-06-25 16:12:31', 1, 1);
INSERT INTO `bls_word` VALUES (135, '输出部件', '代指工具功能接口所提供的功能、返回结果的含义以及所需要的参数', '通讯录工具 的 输出部件', 1, NULL, 3, 3, '2021-06-25 16:12:54', 1, 1);
INSERT INTO `bls_word` VALUES (136, '元素	', '代指集合中的单个对象', '通讯录 中 年龄 大于 10  的 元素', 1, NULL, 3, 3, '2021-06-25 16:13:29', 1, 1);
INSERT INTO `bls_word` VALUES (137, '数量', '一般和‘元素’搭配，表明元素的具体数量', '元素 的 数量', 1, NULL, 3, 3, '2021-06-25 16:13:57', 1, 1);
INSERT INTO `bls_word` VALUES (138, '最大值', '数字集合中最大的数字', '通讯录 中 年龄 的最大值', 1, NULL, 3, 3, '2021-06-25 16:14:21', 1, 1);
INSERT INTO `bls_word` VALUES (139, '最小值', '数字集合中最小的数字', '通讯录 中 年龄 的最小值', 1, NULL, 3, 3, '2021-06-25 16:14:43', 1, 1);
INSERT INTO `bls_word` VALUES (140, '平均值', '某个数字集合进行累加的最终结果', '通讯录 中 年龄 的 平均值', 1, NULL, 3, 3, '2021-06-25 16:15:01', 1, 1);
INSERT INTO `bls_word` VALUES (141, '总和', '某个数字集合进行累加的最终结果', '通讯录 中  年龄 的 总和', 1, NULL, 3, 3, '2021-06-25 16:15:34', 0, 1);
INSERT INTO `bls_word` VALUES (142, '某个数字集合进行累加的最终结果', '等于有三种含义。一种是在判断句型中，表示判断它前后两个对象是否相等。一种是在“调用工具”句型中，表示对于参数进行赋值。一种是在“设定”句型中充当连接词，表明后者是前者的实际含义', '年龄 等于 10', 11, NULL, 3, 3, '2021-06-25 16:16:06', 0, 1);
INSERT INTO `bls_word` VALUES (143, '不等于', '不等于', '年龄 不等于 10', 11, NULL, 3, 3, '2021-06-25 16:16:25', 1, 1);
INSERT INTO `bls_word` VALUES (144, '大于	', '表示前者的值大于后者的值', '年龄 大于 10', 11, NULL, 3, 3, '2021-06-25 16:16:46', 1, 1);
INSERT INTO `bls_word` VALUES (145, '不大于	', '表示前者的值小于等于后者的值', '年龄 不大于 10', 11, NULL, 3, 3, '2021-06-25 16:17:06', 1, 1);
INSERT INTO `bls_word` VALUES (146, '小于	', '表示前者的值小于后者的值', '年龄 小于 10', 11, NULL, 3, 3, '2021-06-25 16:17:39', 1, 1);
INSERT INTO `bls_word` VALUES (147, '不小于	', '表示前者的值大于等于后者的值', '年龄 不小于 10', 11, NULL, 3, 3, '2021-06-25 16:18:05', 1, 1);
INSERT INTO `bls_word` VALUES (148, '数字', '词汇所对应的具体数字', '12  1', 5, NULL, 3, 3, '2021-06-25 16:18:41', 1, 1);
INSERT INTO `bls_word` VALUES (149, '字符串', '字符串', '‘阿斯顿’', 1, NULL, 3, 3, '2021-06-25 16:19:03', 1, 1);
INSERT INTO `bls_word` VALUES (150, '对象名称', '代表着某一个对象，又或者某个对象的某个属性。具体代指什么需要结合上下文来进行分析', '通讯录  、 张三', 1, NULL, 3, 3, '2021-06-25 16:19:25', 1, 1);
INSERT INTO `bls_word` VALUES (151, '把', '用于指定操作对象，同时充当“把”字句的标识符', '把 ** 按照/根据', 10, NULL, 3, 3, '2021-06-25 16:20:38', 1, 1);
INSERT INTO `bls_word` VALUES (152, '的', '一般用于连接两个名词或者对象名称，从而表明后者是属于前者的这种关系。除此之外，也用于句子成分之间的连接，使得语句通顺', '** 的 **', 10, NULL, 3, 3, '2021-06-25 16:20:58', 1, 1);
INSERT INTO `bls_word` VALUES (153, '其中', '在“调用工具”句型中，用于连接两个句子成分，表示后面的语句是对于前面语句的进一步说明', '***，其中，***', 10, NULL, 3, 3, '2021-06-25 16:21:15', 1, 1);
INSERT INTO `bls_word` VALUES (154, '作为参数', '和“把”一起在“调用工具”句型中用于指定参数', '把 ** 作为参数', 10, NULL, 3, 3, '2021-06-25 16:21:31', 0, 1);
INSERT INTO `bls_word` VALUES (155, '中', '与名词组合在一起充当句子的状语，限定其他句子成分的描述范围', '*** 中', 10, NULL, 3, 3, '2021-06-25 16:21:48', 1, 1);
INSERT INTO `bls_word` VALUES (156, '根据', '在“排序”句型中，表示是根据它后面的词所表示的属性来将某个集合进行排序', '根据 ** 进行 ***', 10, NULL, 3, 3, '2021-06-25 16:23:13', 1, 1);
INSERT INTO `bls_word` VALUES (157, '将	', '和“把”类似', '将 ** 合并成为	', 10, NULL, 3, 3, '2021-06-25 16:23:26', 1, 1);
INSERT INTO `bls_word` VALUES (158, '进行', '无特殊含义，在“排序”句型中，起到联系上下文的作用', '根据 ** 进行 ***', 10, NULL, 3, 3, '2021-06-25 16:23:51', 0, 1);
INSERT INTO `bls_word` VALUES (159, '求', '在“求值”句型中，充当该句型的标识', '求 *** 的 最大值', 10, NULL, 3, 3, '2021-06-25 16:24:08', 0, 1);
INSERT INTO `bls_word` VALUES (160, '基于', '一般后面跟随属性名称，在“属性合并”句型中起到说明合并条件的作用', '基于 ** 进行', 10, NULL, 3, 3, '2021-06-25 16:24:26', 0, 1);
INSERT INTO `bls_word` VALUES (161, '和', '和', '张三和李四', 11, NULL, 3, 3, '2021-06-25 16:52:46', 1, 1);
INSERT INTO `bls_word` VALUES (162, '的', '的', '部门的岗位', 11, NULL, 3, 3, '2021-06-25 16:53:30', 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_word_node
-- ----------------------------
DROP TABLE IF EXISTS `bls_word_node`;
CREATE TABLE `bls_word_node` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `word_id` bigint NOT NULL COMMENT '词汇ID',
  `node_id` bigint NOT NULL COMMENT '节点ID',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态  0：禁用  1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_word_node
-- ----------------------------
BEGIN;
INSERT INTO `bls_word_node` VALUES (1, 1, 1, 1);
INSERT INTO `bls_word_node` VALUES (2, 2, 2, 1);
INSERT INTO `bls_word_node` VALUES (3, 3, 3, 1);
INSERT INTO `bls_word_node` VALUES (4, 4, 4, 1);
INSERT INTO `bls_word_node` VALUES (5, 5, 5, 1);
INSERT INTO `bls_word_node` VALUES (6, 6, 5, 1);
INSERT INTO `bls_word_node` VALUES (7, 7, 6, 1);
INSERT INTO `bls_word_node` VALUES (8, 8, 7, 1);
INSERT INTO `bls_word_node` VALUES (9, 9, 8, 1);
INSERT INTO `bls_word_node` VALUES (10, 10, 9, 1);
INSERT INTO `bls_word_node` VALUES (11, 11, 10, 1);
INSERT INTO `bls_word_node` VALUES (12, 12, 11, 1);
INSERT INTO `bls_word_node` VALUES (13, 13, 12, 1);
INSERT INTO `bls_word_node` VALUES (14, 14, 13, 1);
INSERT INTO `bls_word_node` VALUES (15, 15, 14, 1);
INSERT INTO `bls_word_node` VALUES (16, 16, 15, 1);
INSERT INTO `bls_word_node` VALUES (17, 17, 16, 1);
INSERT INTO `bls_word_node` VALUES (18, 18, 17, 1);
INSERT INTO `bls_word_node` VALUES (19, 19, 18, 1);
INSERT INTO `bls_word_node` VALUES (20, 20, 19, 1);
INSERT INTO `bls_word_node` VALUES (21, 21, 20, 1);
INSERT INTO `bls_word_node` VALUES (22, 22, 21, 1);
INSERT INTO `bls_word_node` VALUES (23, 23, 22, 1);
INSERT INTO `bls_word_node` VALUES (24, 25, 23, 1);
INSERT INTO `bls_word_node` VALUES (25, 27, 24, 1);
INSERT INTO `bls_word_node` VALUES (26, 29, 25, 1);
INSERT INTO `bls_word_node` VALUES (27, 30, 26, 1);
INSERT INTO `bls_word_node` VALUES (28, 31, 27, 1);
INSERT INTO `bls_word_node` VALUES (29, 34, 28, 1);
INSERT INTO `bls_word_node` VALUES (30, 37, 29, 1);
INSERT INTO `bls_word_node` VALUES (31, 42, 30, 1);
INSERT INTO `bls_word_node` VALUES (32, 44, 31, 1);
INSERT INTO `bls_word_node` VALUES (33, 45, 32, 1);
INSERT INTO `bls_word_node` VALUES (34, 47, 33, 1);
INSERT INTO `bls_word_node` VALUES (35, 49, 34, 1);
INSERT INTO `bls_word_node` VALUES (36, 54, 35, 1);
INSERT INTO `bls_word_node` VALUES (37, 57, 36, 1);
INSERT INTO `bls_word_node` VALUES (38, 59, 37, 1);
INSERT INTO `bls_word_node` VALUES (39, 61, 38, 1);
INSERT INTO `bls_word_node` VALUES (40, 62, 39, 1);
INSERT INTO `bls_word_node` VALUES (41, 63, 40, 1);
INSERT INTO `bls_word_node` VALUES (42, 64, 41, 1);
INSERT INTO `bls_word_node` VALUES (43, 65, 42, 1);
INSERT INTO `bls_word_node` VALUES (44, 67, 43, 1);
INSERT INTO `bls_word_node` VALUES (45, 69, 44, 1);
INSERT INTO `bls_word_node` VALUES (46, 71, 45, 1);
INSERT INTO `bls_word_node` VALUES (47, 74, 46, 1);
INSERT INTO `bls_word_node` VALUES (48, 75, 47, 1);
INSERT INTO `bls_word_node` VALUES (49, 76, 48, 1);
INSERT INTO `bls_word_node` VALUES (50, 77, 49, 1);
INSERT INTO `bls_word_node` VALUES (51, 80, 50, 1);
INSERT INTO `bls_word_node` VALUES (52, 82, 51, 1);
INSERT INTO `bls_word_node` VALUES (53, 83, 52, 1);
INSERT INTO `bls_word_node` VALUES (54, 117, 68, 1);
INSERT INTO `bls_word_node` VALUES (55, 118, 69, 1);
INSERT INTO `bls_word_node` VALUES (56, 119, 70, 1);
INSERT INTO `bls_word_node` VALUES (57, 120, 71, 1);
INSERT INTO `bls_word_node` VALUES (58, 121, 73, 1);
INSERT INTO `bls_word_node` VALUES (59, 122, 76, 1);
INSERT INTO `bls_word_node` VALUES (60, 123, 78, 1);
INSERT INTO `bls_word_node` VALUES (61, 124, 80, 1);
INSERT INTO `bls_word_node` VALUES (62, 1, 82, 1);
INSERT INTO `bls_word_node` VALUES (63, 1, 83, 1);
INSERT INTO `bls_word_node` VALUES (64, 125, 84, 1);
INSERT INTO `bls_word_node` VALUES (65, 127, 85, 1);
INSERT INTO `bls_word_node` VALUES (66, 128, 86, 1);
INSERT INTO `bls_word_node` VALUES (67, 130, 87, 1);
INSERT INTO `bls_word_node` VALUES (68, 131, 88, 1);
INSERT INTO `bls_word_node` VALUES (69, 132, 89, 1);
INSERT INTO `bls_word_node` VALUES (70, 134, 90, 1);
INSERT INTO `bls_word_node` VALUES (71, 135, 91, 1);
INSERT INTO `bls_word_node` VALUES (72, 136, 92, 1);
INSERT INTO `bls_word_node` VALUES (73, 137, 93, 1);
INSERT INTO `bls_word_node` VALUES (74, 138, 94, 1);
INSERT INTO `bls_word_node` VALUES (75, 139, 95, 1);
INSERT INTO `bls_word_node` VALUES (76, 140, 96, 1);
INSERT INTO `bls_word_node` VALUES (77, 143, 97, 1);
INSERT INTO `bls_word_node` VALUES (78, 144, 98, 1);
INSERT INTO `bls_word_node` VALUES (79, 145, 99, 1);
INSERT INTO `bls_word_node` VALUES (80, 146, 100, 1);
INSERT INTO `bls_word_node` VALUES (81, 147, 101, 1);
INSERT INTO `bls_word_node` VALUES (82, 148, 102, 1);
INSERT INTO `bls_word_node` VALUES (83, 149, 103, 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_word_rule
-- ----------------------------
DROP TABLE IF EXISTS `bls_word_rule`;
CREATE TABLE `bls_word_rule` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `word_id` bigint NOT NULL COMMENT '词汇id',
  `rule_id` bigint NOT NULL COMMENT '规则id',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态  0：禁用  1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_word_rule
-- ----------------------------
BEGIN;
INSERT INTO `bls_word_rule` VALUES (1, 1, 1, 1);
INSERT INTO `bls_word_rule` VALUES (2, 2, 2, 1);
INSERT INTO `bls_word_rule` VALUES (3, 3, 3, 1);
INSERT INTO `bls_word_rule` VALUES (4, 4, 4, 1);
INSERT INTO `bls_word_rule` VALUES (5, 5, 5, 1);
INSERT INTO `bls_word_rule` VALUES (6, 6, 5, 1);
INSERT INTO `bls_word_rule` VALUES (7, 7, 6, 1);
INSERT INTO `bls_word_rule` VALUES (8, 8, 7, 1);
INSERT INTO `bls_word_rule` VALUES (9, 9, 8, 1);
INSERT INTO `bls_word_rule` VALUES (10, 10, 9, 1);
INSERT INTO `bls_word_rule` VALUES (11, 11, 10, 1);
INSERT INTO `bls_word_rule` VALUES (12, 12, 11, 1);
INSERT INTO `bls_word_rule` VALUES (13, 13, 12, 1);
INSERT INTO `bls_word_rule` VALUES (14, 14, 13, 1);
INSERT INTO `bls_word_rule` VALUES (15, 15, 14, 1);
INSERT INTO `bls_word_rule` VALUES (16, 16, 15, 1);
INSERT INTO `bls_word_rule` VALUES (17, 17, 16, 1);
INSERT INTO `bls_word_rule` VALUES (18, 18, 17, 1);
INSERT INTO `bls_word_rule` VALUES (19, 19, 18, 1);
INSERT INTO `bls_word_rule` VALUES (20, 20, 19, 1);
INSERT INTO `bls_word_rule` VALUES (21, 21, 20, 1);
INSERT INTO `bls_word_rule` VALUES (22, 22, 21, 1);
INSERT INTO `bls_word_rule` VALUES (23, 23, 22, 1);
INSERT INTO `bls_word_rule` VALUES (24, 25, 23, 1);
INSERT INTO `bls_word_rule` VALUES (25, 27, 24, 1);
INSERT INTO `bls_word_rule` VALUES (26, 29, 25, 1);
INSERT INTO `bls_word_rule` VALUES (27, 30, 26, 1);
INSERT INTO `bls_word_rule` VALUES (28, 31, 27, 1);
INSERT INTO `bls_word_rule` VALUES (29, 34, 28, 1);
INSERT INTO `bls_word_rule` VALUES (30, 37, 29, 1);
INSERT INTO `bls_word_rule` VALUES (31, 42, 30, 1);
INSERT INTO `bls_word_rule` VALUES (32, 44, 31, 1);
INSERT INTO `bls_word_rule` VALUES (33, 45, 32, 1);
INSERT INTO `bls_word_rule` VALUES (34, 47, 33, 1);
INSERT INTO `bls_word_rule` VALUES (35, 49, 34, 1);
INSERT INTO `bls_word_rule` VALUES (36, 54, 35, 1);
INSERT INTO `bls_word_rule` VALUES (37, 57, 36, 1);
INSERT INTO `bls_word_rule` VALUES (38, 59, 37, 1);
INSERT INTO `bls_word_rule` VALUES (39, 61, 38, 1);
INSERT INTO `bls_word_rule` VALUES (40, 62, 39, 1);
INSERT INTO `bls_word_rule` VALUES (41, 63, 40, 1);
INSERT INTO `bls_word_rule` VALUES (42, 64, 41, 1);
INSERT INTO `bls_word_rule` VALUES (43, 65, 42, 1);
INSERT INTO `bls_word_rule` VALUES (44, 67, 43, 1);
INSERT INTO `bls_word_rule` VALUES (45, 69, 44, 1);
INSERT INTO `bls_word_rule` VALUES (46, 71, 45, 1);
INSERT INTO `bls_word_rule` VALUES (47, 74, 46, 1);
INSERT INTO `bls_word_rule` VALUES (48, 75, 47, 1);
INSERT INTO `bls_word_rule` VALUES (49, 76, 48, 1);
INSERT INTO `bls_word_rule` VALUES (50, 77, 49, 1);
INSERT INTO `bls_word_rule` VALUES (51, 80, 50, 1);
INSERT INTO `bls_word_rule` VALUES (52, 82, 51, 1);
INSERT INTO `bls_word_rule` VALUES (53, 83, 52, 1);
INSERT INTO `bls_word_rule` VALUES (54, 32, 27, 1);
INSERT INTO `bls_word_rule` VALUES (55, 33, 27, 1);
INSERT INTO `bls_word_rule` VALUES (56, 117, 70, 1);
INSERT INTO `bls_word_rule` VALUES (57, 84, 71, 1);
INSERT INTO `bls_word_rule` VALUES (58, 86, 72, 1);
INSERT INTO `bls_word_rule` VALUES (59, 91, 73, 1);
INSERT INTO `bls_word_rule` VALUES (60, 92, 74, 1);
INSERT INTO `bls_word_rule` VALUES (61, 95, 75, 1);
INSERT INTO `bls_word_rule` VALUES (62, 100, 76, 1);
INSERT INTO `bls_word_rule` VALUES (63, 102, 77, 1);
INSERT INTO `bls_word_rule` VALUES (64, 104, 78, 1);
INSERT INTO `bls_word_rule` VALUES (65, 105, 79, 1);
INSERT INTO `bls_word_rule` VALUES (66, 106, 80, 1);
INSERT INTO `bls_word_rule` VALUES (67, 107, 81, 1);
INSERT INTO `bls_word_rule` VALUES (68, 110, 82, 1);
INSERT INTO `bls_word_rule` VALUES (69, 112, 83, 1);
INSERT INTO `bls_word_rule` VALUES (70, 114, 84, 1);
INSERT INTO `bls_word_rule` VALUES (71, 115, 85, 1);
INSERT INTO `bls_word_rule` VALUES (72, 118, 88, 1);
INSERT INTO `bls_word_rule` VALUES (73, 119, 90, 1);
INSERT INTO `bls_word_rule` VALUES (74, 120, 91, 1);
INSERT INTO `bls_word_rule` VALUES (75, 121, 95, 1);
INSERT INTO `bls_word_rule` VALUES (76, 122, 96, 1);
INSERT INTO `bls_word_rule` VALUES (77, 123, 97, 1);
INSERT INTO `bls_word_rule` VALUES (78, 124, 98, 1);
INSERT INTO `bls_word_rule` VALUES (79, 125, 100, 1);
INSERT INTO `bls_word_rule` VALUES (80, 125, 101, 1);
INSERT INTO `bls_word_rule` VALUES (81, 126, 100, 1);
INSERT INTO `bls_word_rule` VALUES (82, 127, 100, 1);
INSERT INTO `bls_word_rule` VALUES (83, 127, 102, 1);
INSERT INTO `bls_word_rule` VALUES (84, 128, 100, 1);
INSERT INTO `bls_word_rule` VALUES (85, 128, 103, 1);
INSERT INTO `bls_word_rule` VALUES (86, 130, 100, 1);
INSERT INTO `bls_word_rule` VALUES (87, 130, 104, 1);
INSERT INTO `bls_word_rule` VALUES (88, 131, 105, 1);
INSERT INTO `bls_word_rule` VALUES (89, 131, 106, 1);
INSERT INTO `bls_word_rule` VALUES (90, 132, 105, 1);
INSERT INTO `bls_word_rule` VALUES (91, 132, 107, 1);
INSERT INTO `bls_word_rule` VALUES (92, 134, 108, 1);
INSERT INTO `bls_word_rule` VALUES (93, 134, 109, 1);
INSERT INTO `bls_word_rule` VALUES (94, 135, 108, 1);
INSERT INTO `bls_word_rule` VALUES (95, 135, 110, 1);
INSERT INTO `bls_word_rule` VALUES (96, 136, 108, 1);
INSERT INTO `bls_word_rule` VALUES (97, 136, 111, 1);
INSERT INTO `bls_word_rule` VALUES (98, 137, 108, 1);
INSERT INTO `bls_word_rule` VALUES (99, 137, 112, 1);
INSERT INTO `bls_word_rule` VALUES (100, 138, 108, 1);
INSERT INTO `bls_word_rule` VALUES (101, 138, 113, 1);
INSERT INTO `bls_word_rule` VALUES (102, 139, 108, 1);
INSERT INTO `bls_word_rule` VALUES (103, 139, 114, 1);
INSERT INTO `bls_word_rule` VALUES (104, 140, 108, 1);
INSERT INTO `bls_word_rule` VALUES (105, 140, 115, 1);
INSERT INTO `bls_word_rule` VALUES (106, 143, 116, 1);
INSERT INTO `bls_word_rule` VALUES (107, 143, 117, 1);
INSERT INTO `bls_word_rule` VALUES (108, 144, 116, 1);
INSERT INTO `bls_word_rule` VALUES (109, 144, 118, 1);
INSERT INTO `bls_word_rule` VALUES (110, 145, 116, 1);
INSERT INTO `bls_word_rule` VALUES (111, 145, 119, 1);
INSERT INTO `bls_word_rule` VALUES (112, 146, 116, 1);
INSERT INTO `bls_word_rule` VALUES (113, 146, 120, 1);
INSERT INTO `bls_word_rule` VALUES (114, 147, 116, 1);
INSERT INTO `bls_word_rule` VALUES (115, 147, 121, 1);
INSERT INTO `bls_word_rule` VALUES (116, 148, 122, 1);
INSERT INTO `bls_word_rule` VALUES (117, 148, 123, 1);
INSERT INTO `bls_word_rule` VALUES (118, 149, 124, 1);
INSERT INTO `bls_word_rule` VALUES (119, 151, 125, 1);
INSERT INTO `bls_word_rule` VALUES (120, 152, 126, 1);
INSERT INTO `bls_word_rule` VALUES (121, 155, 127, 1);
INSERT INTO `bls_word_rule` VALUES (122, 156, 128, 1);
INSERT INTO `bls_word_rule` VALUES (123, 157, 125, 1);
INSERT INTO `bls_word_rule` VALUES (124, 150, 129, 1);
INSERT INTO `bls_word_rule` VALUES (125, 153, 130, 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_word_user
-- ----------------------------
DROP TABLE IF EXISTS `bls_word_user`;
CREATE TABLE `bls_word_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `word_id` bigint NOT NULL COMMENT '词汇ID',
  `user_id` bigint NOT NULL COMMENT '参与创建或修改的用户ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态：0：禁用，1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用于记录参与创建或修改词汇的用户';

-- ----------------------------
-- Records of bls_word_user
-- ----------------------------
BEGIN;
INSERT INTO `bls_word_user` VALUES (1, 1, 4, '2021-06-22 00:28:27', 1);
INSERT INTO `bls_word_user` VALUES (2, 2, 4, '2021-06-22 00:33:32', 1);
INSERT INTO `bls_word_user` VALUES (3, 3, 4, '2021-06-22 00:34:38', 1);
INSERT INTO `bls_word_user` VALUES (4, 4, 4, '2021-06-22 00:35:04', 1);
INSERT INTO `bls_word_user` VALUES (5, 5, 4, '2021-06-22 00:35:40', 1);
INSERT INTO `bls_word_user` VALUES (6, 6, 4, '2021-06-22 00:36:05', 1);
INSERT INTO `bls_word_user` VALUES (7, 7, 4, '2021-06-22 00:37:00', 1);
INSERT INTO `bls_word_user` VALUES (8, 8, 4, '2021-06-22 00:37:30', 1);
INSERT INTO `bls_word_user` VALUES (9, 9, 4, '2021-06-22 00:41:04', 1);
INSERT INTO `bls_word_user` VALUES (10, 10, 4, '2021-06-22 00:41:53', 1);
INSERT INTO `bls_word_user` VALUES (11, 11, 4, '2021-06-22 00:43:06', 1);
INSERT INTO `bls_word_user` VALUES (12, 12, 4, '2021-06-22 00:43:52', 1);
INSERT INTO `bls_word_user` VALUES (13, 13, 4, '2021-06-22 00:44:17', 1);
INSERT INTO `bls_word_user` VALUES (14, 14, 4, '2021-06-22 00:44:39', 1);
INSERT INTO `bls_word_user` VALUES (15, 15, 4, '2021-06-22 00:45:46', 1);
INSERT INTO `bls_word_user` VALUES (16, 16, 4, '2021-06-22 00:46:14', 1);
INSERT INTO `bls_word_user` VALUES (17, 17, 4, '2021-06-22 00:46:44', 1);
INSERT INTO `bls_word_user` VALUES (18, 18, 4, '2021-06-22 00:49:41', 1);
INSERT INTO `bls_word_user` VALUES (19, 19, 4, '2021-06-22 00:50:22', 1);
INSERT INTO `bls_word_user` VALUES (20, 20, 4, '2021-06-22 00:50:54', 1);
INSERT INTO `bls_word_user` VALUES (21, 21, 4, '2021-06-22 00:51:20', 1);
INSERT INTO `bls_word_user` VALUES (22, 22, 4, '2021-06-22 00:51:45', 1);
INSERT INTO `bls_word_user` VALUES (23, 23, 4, '2021-06-22 00:52:12', 1);
INSERT INTO `bls_word_user` VALUES (24, 24, 4, '2021-06-22 00:52:33', 1);
INSERT INTO `bls_word_user` VALUES (25, 25, 4, '2021-06-22 00:52:54', 1);
INSERT INTO `bls_word_user` VALUES (26, 26, 4, '2021-06-22 00:53:18', 1);
INSERT INTO `bls_word_user` VALUES (27, 27, 4, '2021-06-22 00:53:41', 1);
INSERT INTO `bls_word_user` VALUES (28, 28, 4, '2021-06-22 00:54:02', 1);
INSERT INTO `bls_word_user` VALUES (29, 29, 4, '2021-06-22 00:54:21', 1);
INSERT INTO `bls_word_user` VALUES (30, 30, 4, '2021-06-22 00:54:41', 1);
INSERT INTO `bls_word_user` VALUES (31, 31, 4, '2021-06-22 00:55:14', 1);
INSERT INTO `bls_word_user` VALUES (32, 32, 4, '2021-06-22 01:01:39', 1);
INSERT INTO `bls_word_user` VALUES (33, 33, 4, '2021-06-22 00:56:20', 1);
INSERT INTO `bls_word_user` VALUES (34, 34, 4, '2021-06-22 00:56:45', 1);
INSERT INTO `bls_word_user` VALUES (35, 35, 4, '2021-06-22 00:57:13', 1);
INSERT INTO `bls_word_user` VALUES (36, 36, 4, '2021-06-22 00:57:35', 1);
INSERT INTO `bls_word_user` VALUES (37, 37, 4, '2021-06-22 00:58:00', 1);
INSERT INTO `bls_word_user` VALUES (38, 38, 4, '2021-06-22 01:01:23', 1);
INSERT INTO `bls_word_user` VALUES (39, 39, 4, '2021-06-22 00:59:35', 1);
INSERT INTO `bls_word_user` VALUES (40, 40, 4, '2021-06-22 01:00:50', 1);
INSERT INTO `bls_word_user` VALUES (41, 41, 4, '2021-06-22 01:00:19', 1);
INSERT INTO `bls_word_user` VALUES (42, 42, 4, '2021-06-22 01:02:23', 1);
INSERT INTO `bls_word_user` VALUES (43, 43, 4, '2021-06-22 01:02:43', 1);
INSERT INTO `bls_word_user` VALUES (44, 44, 4, '2021-06-22 01:03:02', 1);
INSERT INTO `bls_word_user` VALUES (45, 45, 4, '2021-06-22 01:03:23', 1);
INSERT INTO `bls_word_user` VALUES (46, 46, 4, '2021-06-22 01:03:57', 1);
INSERT INTO `bls_word_user` VALUES (47, 47, 4, '2021-06-22 01:04:20', 1);
INSERT INTO `bls_word_user` VALUES (48, 48, 4, '2021-06-22 01:04:41', 1);
INSERT INTO `bls_word_user` VALUES (49, 49, 4, '2021-06-22 01:05:11', 1);
INSERT INTO `bls_word_user` VALUES (50, 50, 4, '2021-06-22 01:05:38', 1);
INSERT INTO `bls_word_user` VALUES (51, 51, 4, '2021-06-22 01:05:57', 1);
INSERT INTO `bls_word_user` VALUES (52, 52, 4, '2021-06-22 01:06:17', 1);
INSERT INTO `bls_word_user` VALUES (53, 53, 4, '2021-06-22 01:06:39', 1);
INSERT INTO `bls_word_user` VALUES (54, 54, 4, '2021-06-22 01:06:58', 1);
INSERT INTO `bls_word_user` VALUES (55, 55, 4, '2021-06-22 01:07:18', 1);
INSERT INTO `bls_word_user` VALUES (56, 56, 4, '2021-06-22 01:07:38', 1);
INSERT INTO `bls_word_user` VALUES (57, 57, 4, '2021-06-22 01:08:00', 1);
INSERT INTO `bls_word_user` VALUES (58, 58, 4, '2021-06-22 01:08:20', 1);
INSERT INTO `bls_word_user` VALUES (59, 59, 4, '2021-06-22 01:08:40', 1);
INSERT INTO `bls_word_user` VALUES (60, 60, 4, '2021-06-22 01:09:02', 1);
INSERT INTO `bls_word_user` VALUES (61, 61, 4, '2021-06-22 01:09:21', 1);
INSERT INTO `bls_word_user` VALUES (62, 62, 4, '2021-06-22 01:09:44', 1);
INSERT INTO `bls_word_user` VALUES (63, 63, 4, '2021-06-22 01:10:08', 1);
INSERT INTO `bls_word_user` VALUES (64, 64, 4, '2021-06-22 01:10:30', 1);
INSERT INTO `bls_word_user` VALUES (65, 65, 4, '2021-06-22 01:10:52', 1);
INSERT INTO `bls_word_user` VALUES (66, 66, 4, '2021-06-22 01:11:16', 1);
INSERT INTO `bls_word_user` VALUES (67, 67, 4, '2021-06-22 01:11:37', 1);
INSERT INTO `bls_word_user` VALUES (68, 68, 4, '2021-06-22 01:12:00', 1);
INSERT INTO `bls_word_user` VALUES (69, 69, 4, '2021-06-22 01:12:20', 1);
INSERT INTO `bls_word_user` VALUES (70, 70, 4, '2021-06-22 01:12:44', 1);
INSERT INTO `bls_word_user` VALUES (71, 71, 4, '2021-06-22 01:13:02', 1);
INSERT INTO `bls_word_user` VALUES (72, 72, 4, '2021-06-22 01:13:23', 1);
INSERT INTO `bls_word_user` VALUES (73, 73, 4, '2021-06-22 01:13:50', 1);
INSERT INTO `bls_word_user` VALUES (74, 74, 4, '2021-06-22 01:14:10', 1);
INSERT INTO `bls_word_user` VALUES (75, 75, 4, '2021-06-22 01:14:30', 1);
INSERT INTO `bls_word_user` VALUES (76, 76, 4, '2021-06-22 01:14:51', 1);
INSERT INTO `bls_word_user` VALUES (77, 77, 4, '2021-06-22 01:15:13', 1);
INSERT INTO `bls_word_user` VALUES (78, 78, 4, '2021-06-22 01:15:34', 1);
INSERT INTO `bls_word_user` VALUES (79, 79, 4, '2021-06-22 01:15:53', 1);
INSERT INTO `bls_word_user` VALUES (80, 80, 4, '2021-06-22 01:16:32', 1);
INSERT INTO `bls_word_user` VALUES (81, 81, 4, '2021-06-22 01:17:26', 1);
INSERT INTO `bls_word_user` VALUES (82, 82, 4, '2021-06-22 09:51:13', 1);
INSERT INTO `bls_word_user` VALUES (83, 83, 4, '2021-06-22 09:52:20', 1);
INSERT INTO `bls_word_user` VALUES (84, 84, 4, '2021-06-22 09:52:58', 1);
INSERT INTO `bls_word_user` VALUES (85, 85, 4, '2021-06-22 09:53:41', 1);
INSERT INTO `bls_word_user` VALUES (86, 86, 4, '2021-06-22 09:54:09', 1);
INSERT INTO `bls_word_user` VALUES (87, 87, 4, '2021-06-22 09:54:37', 1);
INSERT INTO `bls_word_user` VALUES (88, 88, 4, '2021-06-22 09:55:15', 1);
INSERT INTO `bls_word_user` VALUES (89, 89, 4, '2021-06-22 09:55:53', 1);
INSERT INTO `bls_word_user` VALUES (90, 90, 4, '2021-06-22 09:56:21', 1);
INSERT INTO `bls_word_user` VALUES (91, 91, 4, '2021-06-22 09:56:45', 1);
INSERT INTO `bls_word_user` VALUES (92, 92, 4, '2021-06-22 09:57:17', 1);
INSERT INTO `bls_word_user` VALUES (93, 93, 4, '2021-06-22 09:57:42', 1);
INSERT INTO `bls_word_user` VALUES (94, 94, 4, '2021-06-22 09:58:17', 1);
INSERT INTO `bls_word_user` VALUES (95, 95, 4, '2021-06-22 10:03:09', 1);
INSERT INTO `bls_word_user` VALUES (96, 96, 4, '2021-06-22 10:03:35', 1);
INSERT INTO `bls_word_user` VALUES (97, 97, 4, '2021-06-22 10:05:28', 1);
INSERT INTO `bls_word_user` VALUES (98, 98, 4, '2021-06-22 10:07:26', 1);
INSERT INTO `bls_word_user` VALUES (99, 99, 4, '2021-06-22 10:08:20', 1);
INSERT INTO `bls_word_user` VALUES (100, 100, 4, '2021-06-22 10:14:44', 1);
INSERT INTO `bls_word_user` VALUES (101, 101, 4, '2021-06-22 10:15:12', 1);
INSERT INTO `bls_word_user` VALUES (102, 102, 4, '2021-06-22 10:15:36', 1);
INSERT INTO `bls_word_user` VALUES (103, 103, 4, '2021-06-22 10:15:58', 1);
INSERT INTO `bls_word_user` VALUES (104, 104, 4, '2021-06-22 10:16:22', 1);
INSERT INTO `bls_word_user` VALUES (105, 105, 4, '2021-06-22 10:20:25', 1);
INSERT INTO `bls_word_user` VALUES (106, 106, 4, '2021-06-22 10:20:52', 1);
INSERT INTO `bls_word_user` VALUES (107, 107, 4, '2021-06-22 10:21:18', 1);
INSERT INTO `bls_word_user` VALUES (108, 108, 4, '2021-06-22 10:21:45', 1);
INSERT INTO `bls_word_user` VALUES (109, 109, 4, '2021-06-22 10:22:10', 1);
INSERT INTO `bls_word_user` VALUES (110, 110, 4, '2021-06-22 10:22:39', 1);
INSERT INTO `bls_word_user` VALUES (111, 111, 4, '2021-06-22 10:23:09', 1);
INSERT INTO `bls_word_user` VALUES (112, 112, 4, '2021-06-22 10:23:37', 1);
INSERT INTO `bls_word_user` VALUES (113, 113, 4, '2021-06-22 10:24:00', 1);
INSERT INTO `bls_word_user` VALUES (114, 114, 4, '2021-06-22 10:24:30', 1);
INSERT INTO `bls_word_user` VALUES (115, 115, 4, '2021-06-22 10:25:14', 1);
INSERT INTO `bls_word_user` VALUES (116, 116, 4, '2021-06-22 10:25:36', 1);
INSERT INTO `bls_word_user` VALUES (117, 117, 3, '2021-06-25 16:01:59', 1);
INSERT INTO `bls_word_user` VALUES (118, 118, 3, '2021-06-25 16:03:18', 1);
INSERT INTO `bls_word_user` VALUES (119, 119, 3, '2021-06-25 16:03:51', 1);
INSERT INTO `bls_word_user` VALUES (120, 120, 3, '2021-06-25 16:04:23', 1);
INSERT INTO `bls_word_user` VALUES (121, 121, 3, '2021-06-25 16:05:12', 1);
INSERT INTO `bls_word_user` VALUES (122, 122, 3, '2021-06-25 16:05:44', 1);
INSERT INTO `bls_word_user` VALUES (123, 123, 3, '2021-06-25 16:06:25', 1);
INSERT INTO `bls_word_user` VALUES (124, 124, 3, '2021-06-25 16:07:01', 1);
INSERT INTO `bls_word_user` VALUES (125, 125, 3, '2021-06-25 16:07:30', 1);
INSERT INTO `bls_word_user` VALUES (126, 126, 3, '2021-06-25 16:07:50', 1);
INSERT INTO `bls_word_user` VALUES (127, 127, 3, '2021-06-25 16:08:23', 1);
INSERT INTO `bls_word_user` VALUES (128, 128, 3, '2021-06-25 16:08:54', 1);
INSERT INTO `bls_word_user` VALUES (129, 129, 3, '2021-06-25 16:09:28', 1);
INSERT INTO `bls_word_user` VALUES (130, 130, 3, '2021-06-25 16:10:11', 1);
INSERT INTO `bls_word_user` VALUES (131, 131, 3, '2021-06-25 16:10:39', 1);
INSERT INTO `bls_word_user` VALUES (132, 132, 3, '2021-06-25 16:11:09', 1);
INSERT INTO `bls_word_user` VALUES (133, 133, 3, '2021-06-25 16:11:43', 1);
INSERT INTO `bls_word_user` VALUES (134, 134, 3, '2021-06-25 16:12:31', 1);
INSERT INTO `bls_word_user` VALUES (135, 135, 3, '2021-06-25 16:12:54', 1);
INSERT INTO `bls_word_user` VALUES (136, 136, 3, '2021-06-25 16:13:29', 1);
INSERT INTO `bls_word_user` VALUES (137, 137, 3, '2021-06-25 16:13:57', 1);
INSERT INTO `bls_word_user` VALUES (138, 138, 3, '2021-06-25 16:14:21', 1);
INSERT INTO `bls_word_user` VALUES (139, 139, 3, '2021-06-25 16:14:43', 1);
INSERT INTO `bls_word_user` VALUES (140, 140, 3, '2021-06-25 16:15:01', 1);
INSERT INTO `bls_word_user` VALUES (141, 141, 3, '2021-06-25 16:15:34', 1);
INSERT INTO `bls_word_user` VALUES (142, 142, 3, '2021-06-25 16:16:06', 1);
INSERT INTO `bls_word_user` VALUES (143, 143, 3, '2021-06-25 16:16:25', 1);
INSERT INTO `bls_word_user` VALUES (144, 144, 3, '2021-06-25 16:16:46', 1);
INSERT INTO `bls_word_user` VALUES (145, 145, 3, '2021-06-25 16:17:06', 1);
INSERT INTO `bls_word_user` VALUES (146, 146, 3, '2021-06-25 16:17:39', 1);
INSERT INTO `bls_word_user` VALUES (147, 147, 3, '2021-06-25 16:18:05', 1);
INSERT INTO `bls_word_user` VALUES (148, 148, 3, '2021-06-25 16:18:41', 1);
INSERT INTO `bls_word_user` VALUES (149, 149, 3, '2021-06-25 16:19:03', 1);
INSERT INTO `bls_word_user` VALUES (150, 150, 3, '2021-06-25 16:19:25', 1);
INSERT INTO `bls_word_user` VALUES (151, 151, 3, '2021-06-25 16:20:38', 1);
INSERT INTO `bls_word_user` VALUES (152, 152, 3, '2021-06-25 16:20:58', 1);
INSERT INTO `bls_word_user` VALUES (153, 153, 3, '2021-06-25 16:21:15', 1);
INSERT INTO `bls_word_user` VALUES (154, 154, 3, '2021-06-25 16:21:31', 1);
INSERT INTO `bls_word_user` VALUES (155, 155, 3, '2021-06-25 16:21:48', 1);
INSERT INTO `bls_word_user` VALUES (156, 156, 3, '2021-06-25 16:23:13', 1);
INSERT INTO `bls_word_user` VALUES (157, 157, 3, '2021-06-25 16:23:26', 1);
INSERT INTO `bls_word_user` VALUES (158, 158, 3, '2021-06-25 16:23:51', 1);
INSERT INTO `bls_word_user` VALUES (159, 159, 3, '2021-06-25 16:24:08', 1);
INSERT INTO `bls_word_user` VALUES (160, 160, 3, '2021-06-25 16:24:26', 1);
INSERT INTO `bls_word_user` VALUES (161, 161, 3, '2021-06-25 16:52:46', 1);
INSERT INTO `bls_word_user` VALUES (162, 162, 3, '2021-06-25 16:53:30', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
