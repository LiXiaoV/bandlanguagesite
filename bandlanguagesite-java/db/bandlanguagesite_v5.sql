/*
 Navicat Premium Data Transfer

 Source Server         : localMysqlServer
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : bandlanguagesite

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 07/06/2021 09:35:37
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept` VALUES (1, 0, '机构管理', '机构管理场景区，负责帮区机构管理部分的工作', NULL, 0, '2021-05-21 14:45:30', 1);
INSERT INTO `bls_dept` VALUES (2, 0, '功能集成', '功能集成场景区，负责帮区功能集成帮语的工作', NULL, 0, '2021-05-21 14:48:39', 1);
INSERT INTO `bls_dept` VALUES (3, 0, '论文分析', '论文分析场景区，负责帮区论文分析的工作', NULL, 0, '2021-05-22 14:16:43', 1);
INSERT INTO `bls_dept` VALUES (4, 0, '物流管理', '物流管理场景区，负责帮区物流管理的工作', NULL, 0, '2021-05-24 11:31:01', 1);
INSERT INTO `bls_dept` VALUES (5, 0, '服务操作系统', '服务操作系统场景区，负责帮区服务操作系统的工作', NULL, 0, '2021-05-24 11:32:35', 1);
INSERT INTO `bls_dept` VALUES (6, 0, '测试', '用户测试的场景区', NULL, 0, '2021-06-04 20:32:54', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_node
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept_node` VALUES (1, 3, 1, 1);
INSERT INTO `bls_dept_node` VALUES (2, 3, 2, 1);
INSERT INTO `bls_dept_node` VALUES (3, 3, 3, 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_rule
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept_rule` VALUES (1, 3, 1, 1);
INSERT INTO `bls_dept_rule` VALUES (2, 3, 2, 1);
INSERT INTO `bls_dept_rule` VALUES (3, 3, 3, 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_script
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept_script` VALUES (1, 3, 1, 1);
INSERT INTO `bls_dept_script` VALUES (2, 1, 2, 1);
INSERT INTO `bls_dept_script` VALUES (3, 1, 3, 1);
INSERT INTO `bls_dept_script` VALUES (4, 1, 4, 1);
INSERT INTO `bls_dept_script` VALUES (5, 1, 5, 1);
INSERT INTO `bls_dept_script` VALUES (6, 1, 6, 1);
INSERT INTO `bls_dept_script` VALUES (7, 5, 7, 1);
INSERT INTO `bls_dept_script` VALUES (8, 2, 8, 1);
INSERT INTO `bls_dept_script` VALUES (9, 2, 9, 1);
INSERT INTO `bls_dept_script` VALUES (10, 2, 10, 1);
INSERT INTO `bls_dept_script` VALUES (11, 2, 11, 1);
INSERT INTO `bls_dept_script` VALUES (12, 2, 12, 1);
INSERT INTO `bls_dept_script` VALUES (13, 2, 13, 1);
INSERT INTO `bls_dept_script` VALUES (14, 2, 14, 1);
INSERT INTO `bls_dept_script` VALUES (15, 2, 15, 1);
INSERT INTO `bls_dept_script` VALUES (16, 2, 16, 1);
INSERT INTO `bls_dept_script` VALUES (17, 2, 17, 1);
INSERT INTO `bls_dept_script` VALUES (18, 3, 18, 0);
INSERT INTO `bls_dept_script` VALUES (19, 3, 19, 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_sentence
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept_sentence` VALUES (1, 3, 1, 1);
INSERT INTO `bls_dept_sentence` VALUES (2, 3, 2, 1);
INSERT INTO `bls_dept_sentence` VALUES (3, 3, 3, 1);
INSERT INTO `bls_dept_sentence` VALUES (4, 3, 4, 1);
INSERT INTO `bls_dept_sentence` VALUES (5, 3, 5, 0);
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
INSERT INTO `bls_dept_sentence` VALUES (26, 1, 26, 1);
INSERT INTO `bls_dept_sentence` VALUES (27, 1, 27, 1);
INSERT INTO `bls_dept_sentence` VALUES (28, 1, 28, 1);
INSERT INTO `bls_dept_sentence` VALUES (29, 1, 29, 1);
INSERT INTO `bls_dept_sentence` VALUES (30, 1, 30, 1);
INSERT INTO `bls_dept_sentence` VALUES (31, 5, 31, 1);
INSERT INTO `bls_dept_sentence` VALUES (32, 5, 32, 1);
INSERT INTO `bls_dept_sentence` VALUES (33, 5, 33, 1);
INSERT INTO `bls_dept_sentence` VALUES (34, 5, 34, 1);
INSERT INTO `bls_dept_sentence` VALUES (35, 5, 35, 1);
INSERT INTO `bls_dept_sentence` VALUES (36, 2, 36, 1);
INSERT INTO `bls_dept_sentence` VALUES (37, 2, 37, 1);
INSERT INTO `bls_dept_sentence` VALUES (38, 2, 38, 1);
INSERT INTO `bls_dept_sentence` VALUES (39, 2, 39, 1);
INSERT INTO `bls_dept_sentence` VALUES (40, 2, 40, 1);
INSERT INTO `bls_dept_sentence` VALUES (41, 2, 41, 1);
INSERT INTO `bls_dept_sentence` VALUES (42, 2, 42, 1);
INSERT INTO `bls_dept_sentence` VALUES (43, 2, 43, 1);
INSERT INTO `bls_dept_sentence` VALUES (44, 2, 44, 1);
INSERT INTO `bls_dept_sentence` VALUES (45, 2, 45, 1);
INSERT INTO `bls_dept_sentence` VALUES (46, 2, 46, 1);
INSERT INTO `bls_dept_sentence` VALUES (47, 2, 47, 1);
INSERT INTO `bls_dept_sentence` VALUES (48, 2, 48, 1);
INSERT INTO `bls_dept_sentence` VALUES (49, 2, 49, 1);
INSERT INTO `bls_dept_sentence` VALUES (50, 2, 50, 1);
INSERT INTO `bls_dept_sentence` VALUES (51, 2, 51, 1);
INSERT INTO `bls_dept_sentence` VALUES (52, 2, 52, 1);
INSERT INTO `bls_dept_sentence` VALUES (53, 2, 53, 1);
INSERT INTO `bls_dept_sentence` VALUES (54, 2, 54, 1);
INSERT INTO `bls_dept_sentence` VALUES (55, 3, 55, 0);
INSERT INTO `bls_dept_sentence` VALUES (56, 3, 56, 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_word
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept_word` VALUES (1, 3, 6, 1);
INSERT INTO `bls_dept_word` VALUES (2, 3, 7, 1);
INSERT INTO `bls_dept_word` VALUES (3, 3, 8, 1);
INSERT INTO `bls_dept_word` VALUES (5, 3, 10, 1);
INSERT INTO `bls_dept_word` VALUES (6, 3, 11, 1);
INSERT INTO `bls_dept_word` VALUES (7, 1, 12, 1);
INSERT INTO `bls_dept_word` VALUES (8, 1, 13, 1);
INSERT INTO `bls_dept_word` VALUES (9, 1, 14, 1);
INSERT INTO `bls_dept_word` VALUES (10, 1, 15, 1);
INSERT INTO `bls_dept_word` VALUES (11, 1, 16, 1);
INSERT INTO `bls_dept_word` VALUES (12, 1, 17, 1);
INSERT INTO `bls_dept_word` VALUES (13, 1, 18, 1);
INSERT INTO `bls_dept_word` VALUES (14, 1, 19, 1);
INSERT INTO `bls_dept_word` VALUES (15, 1, 20, 1);
INSERT INTO `bls_dept_word` VALUES (16, 1, 21, 1);
INSERT INTO `bls_dept_word` VALUES (17, 1, 22, 1);
INSERT INTO `bls_dept_word` VALUES (18, 1, 23, 1);
INSERT INTO `bls_dept_word` VALUES (19, 1, 24, 1);
INSERT INTO `bls_dept_word` VALUES (20, 1, 25, 1);
INSERT INTO `bls_dept_word` VALUES (21, 1, 26, 1);
INSERT INTO `bls_dept_word` VALUES (22, 1, 27, 1);
INSERT INTO `bls_dept_word` VALUES (23, 1, 28, 1);
INSERT INTO `bls_dept_word` VALUES (24, 5, 29, 1);
INSERT INTO `bls_dept_word` VALUES (25, 5, 30, 1);
INSERT INTO `bls_dept_word` VALUES (26, 5, 31, 1);
INSERT INTO `bls_dept_word` VALUES (27, 5, 32, 1);
INSERT INTO `bls_dept_word` VALUES (28, 5, 33, 1);
INSERT INTO `bls_dept_word` VALUES (29, 5, 34, 1);
INSERT INTO `bls_dept_word` VALUES (30, 5, 35, 1);
INSERT INTO `bls_dept_word` VALUES (31, 5, 36, 1);
INSERT INTO `bls_dept_word` VALUES (32, 5, 37, 1);
INSERT INTO `bls_dept_word` VALUES (33, 2, 38, 1);
INSERT INTO `bls_dept_word` VALUES (34, 2, 39, 1);
INSERT INTO `bls_dept_word` VALUES (35, 2, 40, 1);
INSERT INTO `bls_dept_word` VALUES (36, 2, 41, 1);
INSERT INTO `bls_dept_word` VALUES (37, 2, 42, 1);
INSERT INTO `bls_dept_word` VALUES (38, 2, 43, 1);
INSERT INTO `bls_dept_word` VALUES (39, 2, 44, 1);
INSERT INTO `bls_dept_word` VALUES (40, 2, 45, 1);
INSERT INTO `bls_dept_word` VALUES (41, 2, 46, 1);
INSERT INTO `bls_dept_word` VALUES (42, 2, 47, 1);
INSERT INTO `bls_dept_word` VALUES (43, 2, 48, 1);
INSERT INTO `bls_dept_word` VALUES (44, 2, 49, 1);
INSERT INTO `bls_dept_word` VALUES (45, 2, 50, 1);
INSERT INTO `bls_dept_word` VALUES (46, 2, 51, 1);
INSERT INTO `bls_dept_word` VALUES (47, 2, 52, 1);
INSERT INTO `bls_dept_word` VALUES (48, 2, 53, 1);
INSERT INTO `bls_dept_word` VALUES (49, 2, 54, 1);
INSERT INTO `bls_dept_word` VALUES (50, 2, 55, 1);
INSERT INTO `bls_dept_word` VALUES (51, 2, 56, 1);
INSERT INTO `bls_dept_word` VALUES (52, 2, 57, 1);
INSERT INTO `bls_dept_word` VALUES (53, 2, 58, 1);
INSERT INTO `bls_dept_word` VALUES (54, 2, 59, 1);
INSERT INTO `bls_dept_word` VALUES (55, 2, 60, 1);
INSERT INTO `bls_dept_word` VALUES (56, 2, 61, 1);
INSERT INTO `bls_dept_word` VALUES (57, 2, 62, 1);
INSERT INTO `bls_dept_word` VALUES (58, 2, 63, 1);
INSERT INTO `bls_dept_word` VALUES (59, 2, 64, 1);
INSERT INTO `bls_dept_word` VALUES (60, 2, 65, 1);
INSERT INTO `bls_dept_word` VALUES (61, 2, 66, 1);
INSERT INTO `bls_dept_word` VALUES (62, 2, 67, 1);
INSERT INTO `bls_dept_word` VALUES (63, 2, 68, 1);
INSERT INTO `bls_dept_word` VALUES (64, 2, 69, 1);
INSERT INTO `bls_dept_word` VALUES (65, 2, 70, 1);
INSERT INTO `bls_dept_word` VALUES (66, 2, 71, 1);
INSERT INTO `bls_dept_word` VALUES (67, 2, 72, 1);
INSERT INTO `bls_dept_word` VALUES (68, 2, 73, 1);
INSERT INTO `bls_dept_word` VALUES (69, 2, 74, 1);
INSERT INTO `bls_dept_word` VALUES (70, 2, 75, 1);
INSERT INTO `bls_dept_word` VALUES (71, 2, 76, 1);
INSERT INTO `bls_dept_word` VALUES (72, 2, 77, 1);
INSERT INTO `bls_dept_word` VALUES (73, 2, 78, 1);
INSERT INTO `bls_dept_word` VALUES (74, 2, 79, 1);
INSERT INTO `bls_dept_word` VALUES (75, 2, 80, 1);
INSERT INTO `bls_dept_word` VALUES (76, 2, 81, 1);
INSERT INTO `bls_dept_word` VALUES (77, 2, 82, 1);
INSERT INTO `bls_dept_word` VALUES (78, 2, 83, 1);
INSERT INTO `bls_dept_word` VALUES (79, 3, 84, 0);
INSERT INTO `bls_dept_word` VALUES (80, 2, 85, 0);
INSERT INTO `bls_dept_word` VALUES (81, 3, 86, 1);
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
  `content` text COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `creator_id` int NOT NULL COMMENT '创建者的用户id',
  `editor_id` int NOT NULL COMMENT '最近一次编辑者id',
  `update_time` datetime DEFAULT NULL COMMENT '最近一次更新时间',
  `status` int NOT NULL DEFAULT '1' COMMENT '0:禁用 1：待开发 2： 开发中 3：待审核 4：待发布 5：已发布',
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_node
-- ----------------------------
BEGIN;
INSERT INTO `bls_node` VALUES (1, 'node111111', 'package1', 'node1 code', 2, 2, '2021-06-01 02:15:00', 1);
INSERT INTO `bls_node` VALUES (2, 'node2', 'package2', 'node2 code', 2, 2, '2021-06-01 01:23:19', 1);
INSERT INTO `bls_node` VALUES (3, 'node3', 'package3', 'node3 code..', 2, 2, '2021-06-01 01:24:44', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_node_user
-- ----------------------------
BEGIN;
INSERT INTO `bls_node_user` VALUES (1, 1, 2, '2021-06-01 02:15:00', 1);
INSERT INTO `bls_node_user` VALUES (2, 2, 2, '2021-06-01 01:23:19', 1);
INSERT INTO `bls_node_user` VALUES (3, 3, 2, '2021-06-01 01:24:44', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of bls_paradigm
-- ----------------------------
BEGIN;
INSERT INTO `bls_paradigm` VALUES (1, 1, '创建 字符串 部门', '创建 “测试123” 部门', 123, 123, '2021-05-24 11:01:05', 1);
INSERT INTO `bls_paradigm` VALUES (2, 1, '新建 字符串 部门', '新建 “的地方” 部门', 123, 123, NULL, 1);
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
  `rule` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规则符号',
  `chinese_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '中文名称',
  `express` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规则表达式',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '关于该规则的相关描述',
  `code` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `creator_id` bigint NOT NULL COMMENT '创建者的用户id',
  `editor_id` bigint NOT NULL COMMENT '最近一次编辑者id',
  `update_time` datetime DEFAULT NULL COMMENT '最近一次更新时间',
  `status` int NOT NULL DEFAULT '1' COMMENT '0:禁用 1：待开发 2： 开发中 3：待审核 4：待发布 5：已发布',
  PRIMARY KEY (`rule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_rule
-- ----------------------------
BEGIN;
INSERT INTO `bls_rule` VALUES (1, 'rule1', '规则1', '规则1的表达式', '规则1的描述', '规则1的代码', 2, 2, '2021-06-01 02:23:50', 1);
INSERT INTO `bls_rule` VALUES (2, 'rule2', '规则2', '规则2的表达式', '规则2的相关描述', '规则2的代码', 2, 2, '2021-05-31 16:28:22', 1);
INSERT INTO `bls_rule` VALUES (3, 'rule3', '规则3', '规则3表达式', '规则3的相关描述', '规则3的代码。。', 2, 2, '2021-06-04 14:49:01', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_rule_user
-- ----------------------------
BEGIN;
INSERT INTO `bls_rule_user` VALUES (1, 1, 2, '2021-06-01 02:23:50', 1);
INSERT INTO `bls_rule_user` VALUES (2, 2, 2, '2021-05-31 16:28:22', 1);
INSERT INTO `bls_rule_user` VALUES (3, 3, 2, '2021-06-04 14:49:01', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of bls_script
-- ----------------------------
BEGIN;
INSERT INTO `bls_script` VALUES (1, '剧本1', '剧本内容1', 'aaa', 2, 2, '2021-05-24 10:00:27', 0, 1);
INSERT INTO `bls_script` VALUES (2, '部门中创建子部门', '在 测试开发部 中，创建 ‘运维开发部’ 子部门。', '创建子部门', 4, 4, '2021-05-24 15:22:33', 0, 1);
INSERT INTO `bls_script` VALUES (3, '成员约束', '郭志涛 要出现在 人力资源部 和 外联部 中。', '成员约束', 4, 4, '2021-05-24 15:25:19', 0, 1);
INSERT INTO `bls_script` VALUES (4, '成员岗位更换', '把 王丽 从 护士 更换到 护师 岗位。', '成员岗位更换', 4, 4, '2021-05-24 15:25:55', 0, 1);
INSERT INTO `bls_script` VALUES (5, '公司新员工入职流程', '把 张志斌 拉入到 测试开发部 部门。\n为 张志斌 授予 实习生 岗位，并 设定 有效期 3 个 月。\n把 员工培训部 的 公司规章管理制度文档 发布给 张志斌，并 通知 王秘书 ‘请为张志斌发方入职设备’。\n把 张志斌 拉入到 员工培训部 部门，并 为 张志斌 授予 读者 角色。', '公司新员工入职流程', 4, 4, '2021-05-24 15:26:39', 0, 1);
INSERT INTO `bls_script` VALUES (6, '医院部门合并及人员调动', '把 脑血管外科部 和 心血管外科部 合并为 ‘血管外科部’ 部门。\n为 李忠 授予 血管外科主任 岗位。\n把 吴越 和 张斌 派遣到 血管外科 部门。\n在 血管外科部 中， 创建 仪器管理员 岗位，并 为 吴越 和 张斌 授予 仪器管理员 岗位。\n为 仪器管理员 授予 工者 角色。', '医院部门合并及人员调动', 4, 4, '2021-05-24 15:27:05', 0, 1);
INSERT INTO `bls_script` VALUES (7, '有生人就报警', '如果 B8 有 生人，则 B8 警报 \n=如果 摄像头 B8摄像头 的 图像  的 生人集合 非空， 则 音响 B8音响 发声', '有生人就报警', 5, 5, '2021-05-24 15:54:05', 0, 1);
INSERT INTO `bls_script` VALUES (8, '得到我的通讯录', '执行 通讯录服务，得到 我的通讯录', '执行名为“通讯录服务”的工具，调用它所提供的名为“我的通讯录”的接口。', 3, 3, '2021-05-27 10:24:57', 0, 1);
INSERT INTO `bls_script` VALUES (9, '执行专家查询工具得到名为张三的查询列表', '执行 专家查询工具，其中 姓名 等于 ‘张三’，得到 专家查询列表', '“专家查询工具”所提供的名为“专家查询列表”的接口，在调用时需要传递参数‘姓名’。该例句执行后，便会调用对应接口，传递的参数值为‘张三’。', 3, 3, '2021-05-27 10:27:27', 0, 1);
INSERT INTO `bls_script` VALUES (10, '录入专家张三', '把 专家张三 作为参数，执行 专家管理工具 的 录入专家', '“专家管理工具”对外提供了添加专家的接口，其名称为“录入专家”。该接口所需要的参数在对象“专家张三”中都可以找到。故直接将“专家张三”作为参数，调用该接口。', 3, 3, '2021-05-27 10:37:22', 0, 1);
INSERT INTO `bls_script` VALUES (11, '该论文A作者为张三', '把 论文A 的 作者 改成 ‘张三’', '“论文A”是语境中的一个单一对象。例句的含义则是将它的“作者”属性的具体值，修改成“张三”。如果该单一对象没有这个属性，则为其添加这个属性并赋值。', 3, 3, '2021-05-27 10:38:32', 0, 1);
INSERT INTO `bls_script` VALUES (12, '新建论文A ，设置标题为帮语综述，作者为张三', '新建 论文A ，其中，标题 等于 帮语综述，作者 等于 张三', '执行完成该例句之后，语境中便会存在一个名为“论文A”的对象，它具有两个属性：标题和作者，属性的值依次为“帮语综述”，“张三”。在后续的帮语中可以通过“论文A”一词来代指该对象。', 3, 3, '2021-05-27 10:41:33', 0, 1);
INSERT INTO `bls_script` VALUES (13, '删除论文集合', '删除 论文集合', '例句执行完后，语境中将不再有名为“论文集合”的对象。但若语境中有多个名为“论文集合”的对象，则只会删除最近使用的对象，其他对象依然保留。', 3, 3, '2021-05-27 10:41:59', 0, 1);
INSERT INTO `bls_script` VALUES (14, '在论文集合中去掉作者为‘张三’的论文', '去掉 论文集合 中 作者 为 ‘张三’的 元素', '例句的执行，将会删除“论文集合”这个集合对象中“作者”属性为“张三”的元素。如果删除成功，或者没有这些元素，会通知用户删除成功。如果没有这个集合对象，或者没有“作者”属性，则会执行失败。', 3, 3, '2021-05-27 10:43:05', 0, 1);
INSERT INTO `bls_script` VALUES (15, '根据发表时间将论文集合进行升序排序', '根据 发表时间 将 论文集合 进行 升序排序', '例句执行完成之后，“论文集合”对象中的元素，将按照其“发表时间”的大小，从小到大依次排列。但如果不存在“发表时间”这个属性，则会通知用户执行失败。', 3, 3, '2021-05-27 10:43:41', 0, 1);
INSERT INTO `bls_script` VALUES (16, '将论文集合按照作者进行分组', '将 论文集合 按照 作者 进行分组', '该句执行完后，“论文集合”所对应的集合对象，其中各个元素，将根据属性“作者”的值进行排列，值相同的排列在一起。', 3, 3, '2021-05-27 10:44:24', 0, 1);
INSERT INTO `bls_script` VALUES (17, '把论文集合重命名为18级论文集合', '把 论文集合 重命名为 18级论文集合', '例句执行后，会将语境中的最后一个名为“论文集合”的对象的名称改成“18级论文集合”。如果没找到，会告知用户执行出错。', 3, 3, '2021-05-27 10:44:53', 0, 1);
INSERT INTO `bls_script` VALUES (18, '', '', '', 2, 2, '2021-06-03 16:36:41', 0, 0);
INSERT INTO `bls_script` VALUES (19, '剧本2', '剧本2内容。。', 'ccc', 2, 2, '2021-06-04 01:46:20', 0, 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_script_user
-- ----------------------------
BEGIN;
INSERT INTO `bls_script_user` VALUES (1, 1, 2, '2021-05-24 10:00:27', 1);
INSERT INTO `bls_script_user` VALUES (2, 2, 4, '2021-05-24 15:22:33', 1);
INSERT INTO `bls_script_user` VALUES (3, 3, 4, '2021-05-24 15:25:19', 1);
INSERT INTO `bls_script_user` VALUES (4, 4, 4, '2021-05-24 15:25:55', 1);
INSERT INTO `bls_script_user` VALUES (5, 5, 4, '2021-05-24 15:26:39', 1);
INSERT INTO `bls_script_user` VALUES (6, 6, 4, '2021-05-24 15:27:05', 1);
INSERT INTO `bls_script_user` VALUES (7, 7, 5, '2021-05-24 15:54:05', 1);
INSERT INTO `bls_script_user` VALUES (8, 8, 3, '2021-05-27 10:24:57', 1);
INSERT INTO `bls_script_user` VALUES (9, 9, 3, '2021-05-27 10:27:27', 1);
INSERT INTO `bls_script_user` VALUES (10, 10, 3, '2021-05-27 10:37:22', 1);
INSERT INTO `bls_script_user` VALUES (11, 11, 3, '2021-05-27 10:38:32', 1);
INSERT INTO `bls_script_user` VALUES (12, 12, 3, '2021-05-27 10:41:33', 1);
INSERT INTO `bls_script_user` VALUES (13, 13, 3, '2021-05-27 10:41:59', 1);
INSERT INTO `bls_script_user` VALUES (14, 14, 3, '2021-05-27 10:43:05', 1);
INSERT INTO `bls_script_user` VALUES (15, 15, 3, '2021-05-27 10:43:41', 1);
INSERT INTO `bls_script_user` VALUES (16, 16, 3, '2021-05-27 10:44:24', 1);
INSERT INTO `bls_script_user` VALUES (17, 17, 3, '2021-05-27 10:44:53', 1);
INSERT INTO `bls_script_user` VALUES (18, 18, 2, '2021-06-03 16:36:41', 0);
INSERT INTO `bls_script_user` VALUES (19, 19, 2, '2021-06-04 01:46:20', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of bls_sentence
-- ----------------------------
BEGIN;
INSERT INTO `bls_sentence` VALUES (1, '运行工具句型', '运行某个工具，得到结果', '<创建> <字符串> \"部门\"', 2, 2, '2021-05-24 02:46:15', 0, 1);
INSERT INTO `bls_sentence` VALUES (2, '查看工具', '查看场景区可以运行的工具', 'bbb', 2, 2, '2021-05-24 02:49:05', 0, 1);
INSERT INTO `bls_sentence` VALUES (3, '移除工具', '移除一个场景区的工具', 'ccc', 2, 2, '2021-05-24 02:52:38', 0, 1);
INSERT INTO `bls_sentence` VALUES (4, '句型四', '一个句型', 'ddd', 2, 2, '2021-05-24 02:57:05', 1, 1);
INSERT INTO `bls_sentence` VALUES (5, '句型五', '一个句型', 'eee', 2, 2, '2021-05-24 03:03:21', 0, 0);
INSERT INTO `bls_sentence` VALUES (6, '查看部门', '对机构中的所有部门查看', '<查看部门>::= “显示” <机构名> “的” “所有部门”;', 4, 4, '2021-05-24 14:40:18', 0, 1);
INSERT INTO `bls_sentence` VALUES (7, '创建部门', '创建部门或子部门，创建子部门需要指定在某个部门中，直接通过写出的部门名来定位。', '<创建部门>::=“创建” <部门名> “部门”\r\n| “在” <部门名> “中” “,” “创建” <部门名> “子部门”;', 4, 4, '2021-05-24 14:42:31', 0, 1);
INSERT INTO `bls_sentence` VALUES (8, '修改部门', '对部门的修改管理，主要对部门名称的修改操作', '<修改部门>::=“把” <部门名> “部门” “修改为” <部门名>;', 4, 4, '2021-05-24 14:43:28', 0, 1);
INSERT INTO `bls_sentence` VALUES (9, '移动部门', '对部门的移动表示将前者部门移动到后者中，作为后者的一个子部门。', '<移动部门>::=“把” <部门名> “部门” “移动到” <部门名> “中”;', 4, 4, '2021-05-24 14:44:14', 0, 1);
INSERT INTO `bls_sentence` VALUES (10, '撤消部门', '对机构部门或部门中子部门的撤消操作', '<撤消部门>::=“撤消” <部门名> “部门”;\r\n| “在” <部门名> “中” “,” “撤消” <部门名> “子部门”;', 4, 4, '2021-05-24 14:47:06', 0, 1);
INSERT INTO `bls_sentence` VALUES (11, '合并部门', '将两个部门合并为新部门或把一个部门合并到另一个部门中的操作', '<合并部门>::=“把” <部门名> “和” <部门名> “合并为” <部门名> “部门”\n| “将” <部门名> “部门” “合并到” <部门名>;', 4, 4, '2021-05-24 15:07:55', 0, 1);
INSERT INTO `bls_sentence` VALUES (12, '查看岗位', '对机构或部门中的岗位查看', '<查看岗位>::=“显示” (<机构名> | <部门名>) “的” “所有岗位”;', 4, 4, '2021-05-24 15:08:55', 0, 1);
INSERT INTO `bls_sentence` VALUES (13, '创建岗位', '对岗位的创建操作，不指定部门地点则表示在机构层创建岗位。', '<创建岗位>::=[“在” <部门名> “中” “,”] “创建” <岗位名> “岗位”;', 4, 4, '2021-05-24 15:09:36', 0, 1);
INSERT INTO `bls_sentence` VALUES (14, '修改岗位', '对岗位的修改管理为修改岗位的名称。', '<修改岗位>::=[“在” <部门名> “中”] “把” <岗位名> “岗位” “修改为” <岗位名>;', 4, 4, '2021-05-24 15:10:12', 0, 1);
INSERT INTO `bls_sentence` VALUES (15, '移除岗位', '将岗位从机构或部门中移除，若不指定在某个部门，则表示对机构层的岗位移除。', '<移除岗位>::=[“在” <部门名> “中” “,”] “移除” <岗位名> “岗位”\n| “对” <部门名> “移除” <岗位名> “岗位”;', 4, 4, '2021-05-24 15:10:57', 0, 1);
INSERT INTO `bls_sentence` VALUES (16, '岗位约束', '对机构中的岗位制定约束规则。', '<岗位约束>::=<岗位名> “要出现在” <部门名> “中”;', 4, 4, '2021-05-24 15:11:27', 0, 1);
INSERT INTO `bls_sentence` VALUES (17, '查看成员', '成员管理中的查看成员包括查看机构、部门或岗位中的所有成员。其中对岗位查看成员时，根据岗位是机构岗位还是部门岗位，选择是否需要指定部门地点。', '<查看成员>::=“显示” (<机构名> | <部门名>) “的” “所有成员”\n| [“在” <部门名> “中” “,”] “显示” <岗位名> “的” “所有成员”;', 4, 4, '2021-05-24 15:13:26', 0, 1);
INSERT INTO `bls_sentence` VALUES (18, '添加成员', '对成员的添加操作，若不指定部门则表示对机构添加平台系统中的某个成员。', '<添加成员>::=“把” <成员名> “拉入到” <部门名> “部门”\n| [“在” <部门名> “中” “,”] “添加” “成员” <成员名>;', 4, 4, '2021-05-24 15:13:59', 0, 1);
INSERT INTO `bls_sentence` VALUES (19, '移除成员', '将成员从机构或部门中移除的操作句型。', '<移除成员>::=[“在” <部门名> “中” “,”] “移除” “成员” <成员名>;', 4, 4, '2021-05-24 15:14:31', 0, 1);
INSERT INTO `bls_sentence` VALUES (20, '任命岗位', '为成员在机构或部门中任命某个岗位的管理操作', '<任命岗位>::=[“在” <部门名> “中”] “为” <成员名> “任命” <岗位名> “岗位”;', 4, 4, '2021-05-24 15:15:01', 0, 1);
INSERT INTO `bls_sentence` VALUES (21, '免除岗位', '将成员从某个岗位中免职的操作句型。', '<免除岗位>::=[“在” <部门名> “部门” “中”] “为” <成员名> “免除” <岗位名> “岗位”;', 4, 4, '2021-05-24 15:15:28', 0, 1);
INSERT INTO `bls_sentence` VALUES (22, '更换岗位', '对成员从某个岗位更换到另一个岗位的句型表述。', '<更换岗位>::=“把” <成员名> “从” <岗位名> “更换到” <岗位名> “岗位”;', 4, 4, '2021-05-24 15:16:00', 0, 1);
INSERT INTO `bls_sentence` VALUES (23, '成员派遣', '对机构成员派遣的操作描述。', '<成员派遣>::=“把” <成员名> “派遣到” <部门名> “部门”;', 4, 4, '2021-05-24 15:16:59', 0, 1);
INSERT INTO `bls_sentence` VALUES (24, '成员约束', '对成员出现在部门或岗位中的规则约束。', '<成员约束>::=<成员名> “要出现在” <部门名> “中”;', 4, 4, '2021-05-24 15:17:22', 0, 1);
INSERT INTO `bls_sentence` VALUES (25, '授予权限', '授予权限句型表示对岗位或成员授予某个角色，根据不同业务选择是否指定部门。', '<授予权限>::=[“在” <部门名> “中”] “为” (<岗位名> | <成员名>) “授予” <角色名> “角色”;', 4, 4, '2021-05-24 15:17:57', 0, 1);
INSERT INTO `bls_sentence` VALUES (26, '设定通行证', '授予权限时，设定权限的有效期。', '<设定通行证>::=“设定” “有效期” <时间补语>;', 4, 4, '2021-05-24 15:18:26', 0, 1);
INSERT INTO `bls_sentence` VALUES (27, '移除权限', '对岗位或成员移除某个角色权限的管理操作。', '<移除权限>::=[“在” <部门名> “中”] “为” (<岗位名> | <成员名>) “移除” <角色名> “角色”;', 4, 4, '2021-05-24 15:18:52', 0, 1);
INSERT INTO `bls_sentence` VALUES (28, '权限约束', '对岗位或成员的权限约束。', '<权限约束>::=(<岗位名> | <成员名>) “在” <部门名> “中” “拥有” <角色名> “角色”;', 4, 4, '2021-05-24 15:19:22', 0, 1);
INSERT INTO `bls_sentence` VALUES (29, '资源发布', '发布管理中对资源的发布，表示发布资源给某个成员或某个部门等。', '<资源发布>::=“发布给” (<成员名> | <地点名>) <资源名>\n| “把” <资源名> “发布到” (<成员名> | <地点名>);', 4, 4, '2021-05-24 15:19:59', 0, 1);
INSERT INTO `bls_sentence` VALUES (30, '取消发布', '对已经发布的资源取消，使用动词关键词“取消发布”后接要取消的发布名称。', '<取消发布>::=“取消发布” <发布名称>;', 4, 4, '2021-05-24 15:20:28', 0, 1);
INSERT INTO `bls_sentence` VALUES (31, '显示摄像头图像', '显示摄像头图像', '显示 摄像头 B8摄像头 的 图像', 5, 5, '2021-05-24 15:50:02', 0, 1);
INSERT INTO `bls_sentence` VALUES (32, '显示图像生人熟人集合', '显示图像生人熟人集合', '显示 图像 XXX 的 生人 /熟人集合', 5, 5, '2021-05-24 15:51:10', 0, 1);
INSERT INTO `bls_sentence` VALUES (33, '显示图像是否有生人熟人', '显示图像是否有生人熟人', '显示 图像XXX 是否 有 生人/熟人', 5, 5, '2021-05-24 15:52:02', 0, 1);
INSERT INTO `bls_sentence` VALUES (34, '音响发声', '音响发声', '音响B8音响  发声  ：音响播放默认警铃=B8  警报', 5, 5, '2021-05-24 15:52:36', 0, 1);
INSERT INTO `bls_sentence` VALUES (35, '影像静音', '音响静音', '音响B8音响  静音', 5, 5, '2021-05-24 15:53:03', 0, 1);
INSERT INTO `bls_sentence` VALUES (36, '工具调用句型一', '<工具名称>和<接口名称>是指某个工具以及它所提供的功能接口的中文名称，这些名称在平台中都是唯一的。句型中如果调用的接口不需要参数，则<参数赋值短语>可以省略。', '执行 <工具名称> ，(其中，(<参数赋值短语> ，) + )? 得到 <接口名称> (、<接口名称>)*', 3, 3, '2021-06-03 16:16:17', 0, 1);
INSERT INTO `bls_sentence` VALUES (37, '工具调用句型二', '考虑到对于部分工具接口而言，其所需参数可能较多，如果借助前面的文法来进行描述，则用户需要在<参数赋值短语>中指定大量的参数，这会使得语句过长难以阅读。为此实现了句型二。如果某个接口所需的参数，与某个对象的各属性能够对应，则可以直接指定该对象作为参数，从而完成接口的调用。', '(把 <对象名称> 作为参数，)? 执行 <工具名称> 的 <接口名称> (、<接口名称>)*', 3, 3, '2021-05-27 10:01:29', 0, 1);
INSERT INTO `bls_sentence` VALUES (38, '修改对象的属性值', '该操作只会影响到功能接口返回的数据对象，并不会影响到工具内部的数据。工具内部的数据只能通过工具对外开放的接口才能够进行修改。举例：把 论文A 的 作者 改成 ‘张三’', '把 <对象名称> 的 <属性名称> 改成 <值>', 3, 3, '2021-05-27 10:03:33', 0, 1);
INSERT INTO `bls_sentence` VALUES (39, '新建对象', '在集成帮语中，除了调用工具功能接口来获取对象外，还可以自己创建新对象，以方便进行功能集成。创建的对象也可作为工具接口的输入参数。举例：新建 论文A ，其中，标题 等于 帮语综述，作者 等于 张三', '新建 <对象名称>  ，其中 (，<参数赋值短语>)+', 3, 3, '2021-05-27 10:05:25', 0, 1);
INSERT INTO `bls_sentence` VALUES (40, '删除对象', '如果集成帮语执行过程中某个对象后续不再需要，则可以使用删除操作来删除该对象。举例：删除 论文集合', '删除 <对象名称>', 3, 3, '2021-05-27 10:07:16', 0, 1);
INSERT INTO `bls_sentence` VALUES (41, '删除集合对象中的部分元素', '对于集合对象，集成帮语同样允许用户删除其中符合条件的元素，类似SQL中的delete操作。区别于“删除对象”句型，“删除记录”句型是删除某个集合对象中的部分元素，即使元素全部删除，该对象在语境中依然存在。举例：去掉 论文集合 中 作者 为 ‘张三’的 元素', '去掉 <对象名称> 中 (<条件判断语句>)? 的 元素', 3, 3, '2021-05-27 10:08:18', 0, 1);
INSERT INTO `bls_sentence` VALUES (42, '将集合对象按照某个属性的值进行排序', '举例：根据 发表时间 将 论文集合 进行 升序排序', '根据 <属性名称> 将 <对象名称> 进行 (升序排序 | 降序排序)', 3, 3, '2021-05-27 10:09:07', 0, 1);
INSERT INTO `bls_sentence` VALUES (43, '将集合对象按照某个属性的值进行分组', '该操作完成后所有元素依然在同一个集合对象中，只是属性值相同的会排列在一起。举例：将 论文集合 按照 作者 进行分组', '将 <对象名称> 按照 <属性名称> 进行分组', 3, 3, '2021-05-27 10:11:34', 0, 1);
INSERT INTO `bls_sentence` VALUES (44, '将对象重命名', '工具功能接口所返回的数据，会默认以接口名称为key保存成为对象。如果集成帮语运行过程中有多个key相同的对象，开发者可使用重命名操作修改最近使用的对象的名称。语句执行后会将对象的key修改为新值，但不会修改其实际内容。举例：把 论文集合 重命名为 18级论文集合', '把 <对象名称>  重命名为 <对象名称>', 3, 3, '2021-05-27 10:12:24', 0, 1);
INSERT INTO `bls_sentence` VALUES (45, '将某个单一对象添加到某个集合对象中', '举例：在 论文集合 中 添加 论文A', '在 <集合对象名称> 中 添加 <对象名称>', 3, 3, '2021-05-27 10:13:09', 0, 1);
INSERT INTO `bls_sentence` VALUES (46, '把同类型、同属性的对象合并成为新的对象', '单一对象之间的合并与集合对象之间的合并相类似，故采用一种句型进行实现。实际执行过程中根据对象的类型进行自动判断。举例：把 研一学生 、研二学生、研三学生 合并成为 实验室研究生', '把 <对象名称> (、<对象名称> )+ 合并成为 <对象名称>', 3, 3, '2021-05-27 10:13:57', 0, 1);
INSERT INTO `bls_sentence` VALUES (47, '多个集合对象根据某个属性进行连接，形成新', '举例：把 论文影响力集合 、论文参考文献评分集合 按照 论文标题 合并成为 论文详细信息集合', '把 <对象名称> (、<对象名称> )+ 按照 <属性名称> 合并成为 <对象名称>', 3, 3, '2021-05-27 10:14:59', 0, 1);
INSERT INTO `bls_sentence` VALUES (48, '将对象内容显示在页面上', '举例：显示 B8实验室人数', '显示 <对象名称>  (的 <属性名称>)*', 3, 3, '2021-05-27 10:15:49', 0, 1);
INSERT INTO `bls_sentence` VALUES (49, '查询某个工具所提供的功能接口，或者需要的', '显示 <工具名称> 的 输出部件|输入部件', '举例：显示 专家查询工具 的 输出部件', 3, 3, '2021-05-27 10:16:48', 0, 1);
INSERT INTO `bls_sentence` VALUES (50, '统计某个对象集合中符合某个条件的对象的个', '如果用户希望统计集合中所有元素的数量，则不用写文法中的<条件判断>。目前，帮语的<条件判断>仅支持数字以及字符串之间的简单比较，暂时不支持更为复杂的判断操作。\n举例：统计 论文集合 中 作者 等于 张三 的 元素 的 数量', '统计 <对象名称> 中 (<条件判断语句>)? 的 元素 的 数量', 3, 3, '2021-05-27 10:17:43', 0, 1);
INSERT INTO `bls_sentence` VALUES (51, '查询某个对象集合中符合某些条件的对象', '区别于前面的“统计”句型，该操作会将符合条件的元素集合显示在页面上，而不是显示元素的数量。举例：找出 论文集合 中 发布时间 大于 2018 的 元素', '找出 <对象名称> 中 (<条件判断语句>)? 的 元素', 3, 3, '2021-05-27 10:18:35', 0, 1);
INSERT INTO `bls_sentence` VALUES (52, '求对象集合中某个属性的最大值最小值等特殊', '举例：求 论文集合 中 发表时间 的 最大值', '求 <对象名称> 中 <属性名称> 的 最大值|最小值|平均值|总和', 3, 3, '2021-05-27 10:20:14', 0, 1);
INSERT INTO `bls_sentence` VALUES (53, '设定词汇固定含义', '有时候某一条语句需要多次执行，某个值需要在多个地方使用，为此设计了“设定”句型，为用户提供了类似编程语言中的宏定义的一种操作。句型执行会将对应内容以对象的方式存储在语境中，在后续的语句中可使用对应的对象名称来完成实际内容的引用。举例：设定 ‘成员人数’ 等于 统计 实验室 中 的 记录 的 数量', '设定 字符串 等于 (<语句>|字符串|数字|值)', 3, 3, '2021-05-27 10:21:03', 0, 1);
INSERT INTO `bls_sentence` VALUES (54, '拷贝一份新数据', '在进行数据处理前，为防止后续需要再次使用原始数据，可使用数据拷贝句型将数据拷贝一份。拷贝后集成帮语运行环境中将存在一个新的对象，其内容和原始数据相一致，且不会相互关联。举例：把 论文集合 拷贝一份为 论文集合备份', '把 <对象名称>  拷贝一份为  <对象名称>', 3, 3, '2021-05-27 10:22:26', 0, 1);
INSERT INTO `bls_sentence` VALUES (55, '句型5', '句型5的描述', '', 2, 2, '2021-06-03 16:20:10', 1, 0);
INSERT INTO `bls_sentence` VALUES (56, '句型5', '句型5的描述', 'ttt', 2, 2, '2021-06-04 02:10:20', 1, 1);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_sentence_node
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_sentence_rule
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用于记录参与创建或修改句型的用户';

-- ----------------------------
-- Records of bls_sentence_user
-- ----------------------------
BEGIN;
INSERT INTO `bls_sentence_user` VALUES (1, 1, 2, '2021-05-24 02:46:15', 1);
INSERT INTO `bls_sentence_user` VALUES (2, 2, 2, '2021-05-24 02:49:05', 1);
INSERT INTO `bls_sentence_user` VALUES (3, 3, 2, '2021-05-24 02:52:38', 1);
INSERT INTO `bls_sentence_user` VALUES (4, 4, 2, '2021-05-24 02:57:05', 1);
INSERT INTO `bls_sentence_user` VALUES (5, 5, 2, '2021-05-24 03:03:21', 0);
INSERT INTO `bls_sentence_user` VALUES (6, 6, 4, '2021-05-24 14:40:18', 1);
INSERT INTO `bls_sentence_user` VALUES (7, 7, 4, '2021-05-24 14:42:31', 1);
INSERT INTO `bls_sentence_user` VALUES (8, 8, 4, '2021-05-24 14:43:28', 1);
INSERT INTO `bls_sentence_user` VALUES (9, 9, 4, '2021-05-24 14:44:14', 1);
INSERT INTO `bls_sentence_user` VALUES (10, 10, 4, '2021-05-24 14:47:06', 1);
INSERT INTO `bls_sentence_user` VALUES (11, 11, 4, '2021-05-24 15:07:55', 1);
INSERT INTO `bls_sentence_user` VALUES (12, 12, 4, '2021-05-24 15:08:55', 1);
INSERT INTO `bls_sentence_user` VALUES (13, 13, 4, '2021-05-24 15:09:36', 1);
INSERT INTO `bls_sentence_user` VALUES (14, 14, 4, '2021-05-24 15:10:12', 1);
INSERT INTO `bls_sentence_user` VALUES (15, 15, 4, '2021-05-24 15:10:57', 1);
INSERT INTO `bls_sentence_user` VALUES (16, 16, 4, '2021-05-24 15:11:27', 1);
INSERT INTO `bls_sentence_user` VALUES (17, 17, 4, '2021-05-24 15:13:26', 1);
INSERT INTO `bls_sentence_user` VALUES (18, 18, 4, '2021-05-24 15:13:59', 1);
INSERT INTO `bls_sentence_user` VALUES (19, 19, 4, '2021-05-24 15:14:31', 1);
INSERT INTO `bls_sentence_user` VALUES (20, 20, 4, '2021-05-24 15:15:01', 1);
INSERT INTO `bls_sentence_user` VALUES (21, 21, 4, '2021-05-24 15:15:28', 1);
INSERT INTO `bls_sentence_user` VALUES (22, 22, 4, '2021-05-24 15:16:00', 1);
INSERT INTO `bls_sentence_user` VALUES (23, 23, 4, '2021-05-24 15:16:59', 1);
INSERT INTO `bls_sentence_user` VALUES (24, 24, 4, '2021-05-24 15:17:22', 1);
INSERT INTO `bls_sentence_user` VALUES (25, 25, 4, '2021-05-24 15:17:57', 1);
INSERT INTO `bls_sentence_user` VALUES (26, 26, 4, '2021-05-24 15:18:26', 1);
INSERT INTO `bls_sentence_user` VALUES (27, 27, 4, '2021-05-24 15:18:52', 1);
INSERT INTO `bls_sentence_user` VALUES (28, 28, 4, '2021-05-24 15:19:22', 1);
INSERT INTO `bls_sentence_user` VALUES (29, 29, 4, '2021-05-24 15:19:59', 1);
INSERT INTO `bls_sentence_user` VALUES (30, 30, 4, '2021-05-24 15:20:28', 1);
INSERT INTO `bls_sentence_user` VALUES (31, 31, 5, '2021-05-24 15:50:02', 1);
INSERT INTO `bls_sentence_user` VALUES (32, 32, 5, '2021-05-24 15:51:10', 1);
INSERT INTO `bls_sentence_user` VALUES (33, 33, 5, '2021-05-24 15:52:02', 1);
INSERT INTO `bls_sentence_user` VALUES (34, 34, 5, '2021-05-24 15:52:36', 1);
INSERT INTO `bls_sentence_user` VALUES (35, 35, 5, '2021-05-24 15:53:03', 1);
INSERT INTO `bls_sentence_user` VALUES (36, 36, 3, '2021-06-03 16:16:18', 1);
INSERT INTO `bls_sentence_user` VALUES (37, 37, 3, '2021-05-27 10:01:29', 1);
INSERT INTO `bls_sentence_user` VALUES (38, 38, 3, '2021-05-27 10:03:33', 1);
INSERT INTO `bls_sentence_user` VALUES (39, 39, 3, '2021-05-27 10:05:25', 1);
INSERT INTO `bls_sentence_user` VALUES (40, 40, 3, '2021-05-27 10:07:16', 1);
INSERT INTO `bls_sentence_user` VALUES (41, 41, 3, '2021-05-27 10:08:18', 1);
INSERT INTO `bls_sentence_user` VALUES (42, 42, 3, '2021-05-27 10:09:07', 1);
INSERT INTO `bls_sentence_user` VALUES (43, 43, 3, '2021-05-27 10:11:34', 1);
INSERT INTO `bls_sentence_user` VALUES (44, 44, 3, '2021-05-27 10:12:24', 1);
INSERT INTO `bls_sentence_user` VALUES (45, 45, 3, '2021-05-27 10:13:09', 1);
INSERT INTO `bls_sentence_user` VALUES (46, 46, 3, '2021-05-27 10:13:57', 1);
INSERT INTO `bls_sentence_user` VALUES (47, 47, 3, '2021-05-27 10:14:59', 1);
INSERT INTO `bls_sentence_user` VALUES (48, 48, 3, '2021-05-27 10:15:49', 1);
INSERT INTO `bls_sentence_user` VALUES (49, 49, 3, '2021-05-27 10:16:48', 1);
INSERT INTO `bls_sentence_user` VALUES (50, 50, 3, '2021-05-27 10:17:43', 1);
INSERT INTO `bls_sentence_user` VALUES (51, 51, 3, '2021-05-27 10:18:35', 1);
INSERT INTO `bls_sentence_user` VALUES (52, 52, 3, '2021-05-27 10:20:14', 1);
INSERT INTO `bls_sentence_user` VALUES (53, 53, 3, '2021-05-27 10:21:03', 1);
INSERT INTO `bls_sentence_user` VALUES (54, 54, 3, '2021-05-27 10:22:26', 1);
INSERT INTO `bls_sentence_user` VALUES (55, 55, 2, '2021-06-03 16:20:10', 0);
INSERT INTO `bls_sentence_user` VALUES (56, 56, 2, '2021-06-04 02:10:20', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_user
-- ----------------------------
BEGIN;
INSERT INTO `bls_user` VALUES (1, 'visitor', '游客', '6cf5481d7250552812ea5596c7f0c248', '4NUJulZ&GrdG', NULL, NULL, NULL, '2021-05-22 15:20:49', '2021-05-22 15:20:53', 1, 1);
INSERT INTO `bls_user` VALUES (2, 'liwei', '黎威', '6b63d04f80af99ae5cde482a3559c459', '(UjrELVjqwof', '13387603239', '1011529903@qq.com', NULL, '2021-05-22 15:21:45', '2021-05-22 15:21:47', 17, 1);
INSERT INTO `bls_user` VALUES (3, 'chencongying', '陈聪颖', 'c9da383357b25f5136da98e1a9ef5113', 'GDQ9j#4nBP3)', NULL, NULL, NULL, '2021-05-24 11:26:37', '2021-05-24 11:26:42', 5, 1);
INSERT INTO `bls_user` VALUES (4, 'xujiankang', '徐健康', 'a52d8d5577a09a209759f1950a3a9fad', 'c@8JSeY4969D', NULL, NULL, NULL, '2021-05-24 11:27:34', '2021-05-24 11:27:37', 1, 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='帮语词汇表';

-- ----------------------------
-- Records of bls_word
-- ----------------------------
BEGIN;
INSERT INTO `bls_word` VALUES (6, '分析', '对论文进行一定的思考', '论文分析', 2, '解析', 2, 2, '2021-05-28 19:41:23', 1, 1);
INSERT INTO `bls_word` VALUES (7, '维度', '分析论文的一个方向', '分析维度', 1, '类型', 2, 2, '2021-05-23 23:50:18', 1, 1);
INSERT INTO `bls_word` VALUES (8, '推荐', '想别人推荐论文', '论文推荐', 2, '建议', 2, 2, '2021-05-23 23:59:45', 1, 1);
INSERT INTO `bls_word` VALUES (10, '词汇四', '一个词汇', '啊啊', 1, '词汇1', 2, 2, '2021-05-24 03:00:10', 1, 1);
INSERT INTO `bls_word` VALUES (11, '词汇五', '一个词汇', '丫丫', 1, '词汇四', 2, 2, '2021-05-24 03:01:44', 0, 1);
INSERT INTO `bls_word` VALUES (12, '机构', '表示支撑平台中的机构实体，与支撑平台相关', '创建机构', 1, '', 4, 4, '2021-05-24 11:37:43', 0, 1);
INSERT INTO `bls_word` VALUES (13, '部门', '表示支撑平台中的部门实体，范围上属于机构的子集，是机构的下一级单位。', '创建部门', 1, '', 4, 4, '2021-05-24 11:38:48', 0, 1);
INSERT INTO `bls_word` VALUES (14, '父部门', '是指某个部门的直接上级部门，只有一个，需要以某个部门为基才能定位其父部门。', '某某部门的父部门是什么', 1, '', 4, 4, '2021-05-24 11:41:31', 0, 1);
INSERT INTO `bls_word` VALUES (15, '上级部门', '指某个部门的所有上级部门，即遍历获得父部门的父部门，返回的部门数量可能不止一个。', '某某部门的上级部门是什么', 1, '', 4, 4, '2021-05-24 11:42:14', 0, 1);
INSERT INTO `bls_word` VALUES (16, '子部门', '是指某个部门的下级部门，可能不止一个，所以可能返回空或一个部门或部门集合。', '某某部门的子部门有多少个', 1, '', 4, 4, '2021-05-24 11:43:17', 0, 1);
INSERT INTO `bls_word` VALUES (17, '下级部门', '词法规则名和语义同“子部门”。', '某某部门的下级部门有多少个', 1, '', 4, 4, '2021-05-24 11:43:59', 0, 1);
INSERT INTO `bls_word` VALUES (18, '帮区', '表示支撑平台中的“帮区”实体，属于部门的一个子属性，对部门的各属性管理实质上是在部门的主帮区中进行。', '创建帮区', 1, '', 4, 4, '2021-05-24 11:46:51', 0, 1);
INSERT INTO `bls_word` VALUES (19, '父帮区', '指某个帮区的直接上一级帮区，仅指代直接父帮区，所以返回结果是零或一个帮区，需要以某个帮区为基才能定位其父帮区。', '某某帮区的父帮区是什么', 1, '', 4, 4, '2021-05-24 11:47:30', 0, 1);
INSERT INTO `bls_word` VALUES (20, '子帮区', '是指某个帮区的下级帮区，可能不止一个，所以可能返回空或一个帮区或帮区集合。', '创建子帮区', 1, '', 4, 4, '2021-05-24 11:48:15', 0, 1);
INSERT INTO `bls_word` VALUES (21, '岗位', '岗位实际上是多个成员组成的一个集合，形成了“岗位”实体，岗位存在于机构、部门和帮区中，对岗位的管理实际上就是对属性归成同一类的成员们的管理。', '创建岗位', 1, '', 4, 4, '2021-05-24 11:51:15', 0, 1);
INSERT INTO `bls_word` VALUES (22, '成员', '成员是机构、部门和帮区里的人员，对于成员的管理通常有添加、移除等操作。具体的管理操作也是需要在语句中和谓语动词结合才能确定。', '添加成员', 1, '', 4, 4, '2021-05-24 11:51:52', 0, 1);
INSERT INTO `bls_word` VALUES (23, '工具', '工具是属于帮区中的一个属性，是构成帮区所必不可少的元素。对“工具”词汇的使用通常是调用运行，或指定工具中的具体运行部件后得到返回结果。', '查看工具', 1, '', 4, 4, '2021-05-24 11:54:30', 0, 1);
INSERT INTO `bls_word` VALUES (24, '创建', '在机构管理场景下，通常指对一个实体的创建，是从无到有的一个概念，其后通常跟说明名称的标识符和一个实体名词，对应一次创建并命名实体的动作。', '创建子部门', 2, '新建', 4, 4, '2021-05-24 11:55:59', 0, 1);
INSERT INTO `bls_word` VALUES (25, '添加', '是对用户添加到机构或部门等平台实体的动作，对支撑平台中已存在的实体的操作，需要搭配用户和要拉入的地点标识符才能对整个动作补全。实际映射在底层数据库中是对库表新增一条字段。', '添加人员', 2, '加入', 4, 4, '2021-05-24 11:56:50', 0, 1);
INSERT INTO `bls_word` VALUES (26, '删除', '删除一个实体或实体属性的动作，映射在数据库中是删除某条字段或字段中的数据。', '删除子部门', 2, '移除', 4, 4, '2021-05-24 11:57:50', 0, 1);
INSERT INTO `bls_word` VALUES (27, '移除', '词法规则名和语义同“删除”。', '移除子部门', 2, '去除', 4, 4, '2021-05-24 11:58:30', 0, 1);
INSERT INTO `bls_word` VALUES (28, '授予', '对权限的操作，通常是给用户或岗位授予某个角色的动作。', '授予管理员权限', 2, '', 4, 4, '2021-05-24 11:59:19', 0, 1);
INSERT INTO `bls_word` VALUES (29, '摄像头', '摄像头', '显示 摄像头 B8摄像头 的 图像', 1, '', 5, 5, '2021-05-24 15:42:49', 0, 1);
INSERT INTO `bls_word` VALUES (30, '图像', '图像', '显示 摄像头 B8摄像头 的 图像', 1, '', 5, 5, '2021-05-24 15:44:16', 0, 1);
INSERT INTO `bls_word` VALUES (31, '出现', '出现', '出现生人', 2, '', 5, 5, '2021-05-24 15:45:03', 0, 1);
INSERT INTO `bls_word` VALUES (32, '生人', '陌生人', '出现陌生人', 1, '陌生人', 5, 5, '2021-05-24 15:45:34', 0, 1);
INSERT INTO `bls_word` VALUES (33, '熟人', '经常出现的人', '出现熟人', 1, '', 5, 5, '2021-05-24 15:46:07', 0, 1);
INSERT INTO `bls_word` VALUES (34, '音响', '音响', '音响发声', 1, '', 5, 5, '2021-05-24 15:47:33', 0, 1);
INSERT INTO `bls_word` VALUES (35, '发声', '发出声音', '音响发声', 2, '', 5, 5, '2021-05-24 15:48:01', 0, 1);
INSERT INTO `bls_word` VALUES (36, '警报', '警示别人的声音', '发出警报', 1, '', 5, 5, '2021-05-24 15:48:46', 0, 1);
INSERT INTO `bls_word` VALUES (37, '静音', '不出声', '影像静音', 2, '', 5, 5, '2021-05-24 15:49:14', 0, 1);
INSERT INTO `bls_word` VALUES (38, '显示', '将后面跟随的词汇所表示的内容显示到页面上', '显示 所有成员', 2, '', 3, 3, '2021-05-28 17:15:44', 0, 1);
INSERT INTO `bls_word` VALUES (39, '得到', '表明要获取哪些功能接口的返回结果', '', 2, '', 3, 3, '2021-05-24 16:02:42', 0, 1);
INSERT INTO `bls_word` VALUES (40, '设定', '对于某个词汇进行定义，用于设定句型', '', 2, '', 3, 3, '2021-05-24 16:03:56', 0, 1);
INSERT INTO `bls_word` VALUES (41, '改成', '将某个属性修改为某个值', '', 2, '', 3, 3, '2021-05-24 16:04:15', 0, 1);
INSERT INTO `bls_word` VALUES (42, '新建', '创建一个对象', '', 2, '', 3, 3, '2021-05-24 16:04:38', 0, 1);
INSERT INTO `bls_word` VALUES (43, '重命名为', '将某个对象进行重命名', '', 2, '', 3, 3, '2021-05-24 16:04:56', 0, 1);
INSERT INTO `bls_word` VALUES (44, '找出', '在某个集合中查询出符合条件的记录', '', 2, '', 3, 3, '2021-05-24 16:05:14', 0, 1);
INSERT INTO `bls_word` VALUES (45, '去掉', '在某个集合中删除那些符合条件的记录', '', 2, '', 3, 3, '2021-05-24 16:05:33', 0, 1);
INSERT INTO `bls_word` VALUES (46, '统计', '统计某个集合中符合条件的对象的数量，并显示到页面上', '', 2, '', 3, 3, '2021-05-24 16:05:52', 0, 1);
INSERT INTO `bls_word` VALUES (47, '删除', '删除后面跟的词所代表的对象', '', 2, '', 3, 3, '2021-05-24 16:06:09', 0, 1);
INSERT INTO `bls_word` VALUES (48, '进行分组', '将集合对象按照某个属性进行分组，分组之后的记录，属性相同的会存放在一起', '', 2, '', 3, 3, '2021-05-24 16:06:25', 0, 1);
INSERT INTO `bls_word` VALUES (49, '合并成为', '将若干个对象合并成为一个对象', '', 2, '', 3, 3, '2021-05-24 16:06:42', 0, 1);
INSERT INTO `bls_word` VALUES (50, '添加', '往某个集合对象中添加单个对象', '', 2, '', 3, 3, '2021-05-24 16:07:02', 0, 1);
INSERT INTO `bls_word` VALUES (51, '执行', '执行某个工具或者某条语句', '', 2, '', 3, 3, '2021-05-24 16:07:18', 0, 1);
INSERT INTO `bls_word` VALUES (52, '升序排序', '对于集合对象按照数字大小由小到大进行排序', '', 2, '', 3, 3, '2021-05-24 16:07:34', 0, 1);
INSERT INTO `bls_word` VALUES (53, '降序排序', '对于集合对象按照数字大小由大到小进行排序', '', 2, '', 3, 3, '2021-05-24 16:07:51', 0, 1);
INSERT INTO `bls_word` VALUES (54, '拷贝一份为', '拷贝某个对象，形成新的对象', '', 2, '', 3, 3, '2021-05-24 16:08:11', 0, 1);
INSERT INTO `bls_word` VALUES (55, '输入部件', '代指调用工具功能接口需要的参数以及这些参数所表示的含义。', '', 1, '', 3, 3, '2021-05-24 16:08:51', 0, 1);
INSERT INTO `bls_word` VALUES (56, '输出部件', '代指工具功能接口所提供的功能、返回结果的含义以及所需要的参数', '', 1, '', 3, 3, '2021-05-24 16:09:14', 0, 1);
INSERT INTO `bls_word` VALUES (57, '元素', '代指集合中的单个对象', '', 1, '', 3, 3, '2021-05-24 16:09:29', 0, 1);
INSERT INTO `bls_word` VALUES (58, '记录', '同‘元素’一样', '', 1, '', 3, 3, '2021-05-24 16:09:42', 0, 1);
INSERT INTO `bls_word` VALUES (59, '数量', '一般和‘元素’搭配，表明元素的具体数量', '', 1, '', 3, 3, '2021-05-24 16:10:00', 0, 1);
INSERT INTO `bls_word` VALUES (60, '最大值', '数字集合中最大的数字', '', 1, '', 3, 3, '2021-05-24 16:10:29', 0, 1);
INSERT INTO `bls_word` VALUES (61, '最小值', '数字集合中最小的数字', '', 1, '', 3, 3, '2021-05-24 16:10:44', 0, 1);
INSERT INTO `bls_word` VALUES (62, '平均值', '表示根据某个数字集合，求出其平均值', '', 1, '', 3, 3, '2021-05-24 16:11:00', 0, 1);
INSERT INTO `bls_word` VALUES (63, '总和', '某个数字集合进行累加的最终结果', '', 1, '', 3, 3, '2021-05-24 16:11:14', 0, 1);
INSERT INTO `bls_word` VALUES (64, '等于', '等于有三种含义。一种是在判断句型中，表示判断它前后两个对象是否相等。一种是在“调用工具”句型中，表示对于参数进行赋值。一种是在“设定”句型中充当连接词，表明后者是前者的实际含义', '', 3, '', 3, 3, '2021-05-24 16:19:28', 0, 1);
INSERT INTO `bls_word` VALUES (65, '为', '等同于“等于”', '', 3, '', 3, 3, '2021-05-24 16:19:49', 0, 1);
INSERT INTO `bls_word` VALUES (66, '不等于', '表示两者不相等', '', 3, '', 3, 3, '2021-05-24 16:20:06', 0, 1);
INSERT INTO `bls_word` VALUES (67, '大于', '表示前者的值大于后者的值', '', 3, '', 3, 3, '2021-05-24 16:20:24', 0, 1);
INSERT INTO `bls_word` VALUES (68, '不大于', '表示前者的值小于等于后者的值', '', 3, '', 3, 3, '2021-05-24 16:20:43', 0, 1);
INSERT INTO `bls_word` VALUES (69, '小于', '表示前者的值小于后者的值', '', 3, '', 3, 3, '2021-05-24 16:20:57', 0, 1);
INSERT INTO `bls_word` VALUES (70, '不小于', '表示前者的值大于等于后者的值', '', 3, '', 3, 3, '2021-05-24 16:21:13', 0, 1);
INSERT INTO `bls_word` VALUES (71, '[0-9]+', '词汇所对应的具体数字', '', 5, '', 3, 3, '2021-05-24 16:21:33', 0, 1);
INSERT INTO `bls_word` VALUES (72, '被引号包裹的字符串', '引号内部的字符串', '', 12, '', 3, 3, '2021-05-24 16:21:57', 0, 1);
INSERT INTO `bls_word` VALUES (73, '未被引号包裹的字符串', '代表着某一个对象，又或者某个对象的某个属性。具体代指什么需要结合上下文来进行分析', '', 12, '', 3, 3, '2021-05-24 16:22:25', 0, 1);
INSERT INTO `bls_word` VALUES (74, '把', '用于指定操作对象，同时充当“把”字句的标识符', '', 10, '', 3, 3, '2021-05-24 16:24:49', 0, 1);
INSERT INTO `bls_word` VALUES (75, '的', '一般用于连接两个名词或者对象名称，从而表明后者是属于前者的这种关系。除此之外，也用于句子成分之间的连接，使得语句通顺', '** 的 **', 10, '', 3, 3, '2021-05-24 16:25:18', 0, 1);
INSERT INTO `bls_word` VALUES (76, '其中', '在“调用工具”句型中，用于连接两个句子成分，表示后面的语句是对于前面语句的进一步说明', '***，其中，***', 10, '', 3, 3, '2021-05-24 16:25:41', 0, 1);
INSERT INTO `bls_word` VALUES (77, '作为参数', '和“把”一起在“调用工具”句型中用于指定参数', '把 ** 作为参数', 10, '', 3, 3, '2021-05-24 16:26:09', 0, 1);
INSERT INTO `bls_word` VALUES (78, '中', '与名词组合在一起充当句子的状语，限定其他句子成分的描述范围', '*** 中', 10, '', 3, 3, '2021-05-24 16:26:36', 0, 1);
INSERT INTO `bls_word` VALUES (79, '根据', '在“排序”句型中，表示是根据它后面的词所表示的属性来将某个集合进行排序', '根据 ** 进行 ***', 10, '', 3, 3, '2021-05-24 16:26:58', 0, 1);
INSERT INTO `bls_word` VALUES (80, '将', '和“把”类似', '将 ** 合并成为', 10, '', 3, 3, '2021-05-24 16:27:28', 0, 1);
INSERT INTO `bls_word` VALUES (81, '进行', '根据 ** 进行 ***', '无特殊含义，在“排序”句型中，起到联系上下文的作用', 10, '', 3, 3, '2021-05-24 16:28:12', 0, 1);
INSERT INTO `bls_word` VALUES (82, '求', '在“求值”句型中，充当该句型的标识', '求 *** 的 最大值', 10, '', 3, 3, '2021-05-24 16:28:38', 0, 1);
INSERT INTO `bls_word` VALUES (83, '基于', '一般后面跟随属性名称，在“属性合并”句型中起到说明合并条件的作用', '基于 ** 进行', 10, '', 3, 3, '2021-05-24 16:29:00', 0, 1);
INSERT INTO `bls_word` VALUES (84, '词汇六', '词汇六描述', '词汇六例子', 1, '', 2, 2, '2021-05-27 09:54:21', 0, 0);
INSERT INTO `bls_word` VALUES (85, '显示', '将后面跟随的词汇所表示的内容显示到页面上', '显示 所有成员', 1, '', 3, 3, '2021-05-28 17:04:34', 0, 0);
INSERT INTO `bls_word` VALUES (86, '词汇7', '词汇7的描述', '', 1, NULL, 2, 2, '2021-06-03 09:49:56', 1, 1);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_word_node
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_word_rule
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用于记录参与创建或修改词汇的用户';

-- ----------------------------
-- Records of bls_word_user
-- ----------------------------
BEGIN;
INSERT INTO `bls_word_user` VALUES (1, 6, 2, '2021-05-28 19:41:23', 1);
INSERT INTO `bls_word_user` VALUES (2, 7, 2, '2021-05-23 23:50:18', 1);
INSERT INTO `bls_word_user` VALUES (3, 8, 2, '2021-05-23 23:59:45', 1);
INSERT INTO `bls_word_user` VALUES (4, 10, 2, '2021-05-24 03:00:10', 1);
INSERT INTO `bls_word_user` VALUES (5, 11, 2, '2021-05-24 03:01:44', 1);
INSERT INTO `bls_word_user` VALUES (6, 12, 4, '2021-05-24 11:37:43', 1);
INSERT INTO `bls_word_user` VALUES (7, 13, 4, '2021-05-24 11:38:48', 1);
INSERT INTO `bls_word_user` VALUES (8, 14, 4, '2021-05-24 11:41:31', 1);
INSERT INTO `bls_word_user` VALUES (9, 15, 4, '2021-05-24 11:42:14', 1);
INSERT INTO `bls_word_user` VALUES (10, 16, 4, '2021-05-24 11:43:17', 1);
INSERT INTO `bls_word_user` VALUES (11, 17, 4, '2021-05-24 11:43:59', 1);
INSERT INTO `bls_word_user` VALUES (12, 18, 4, '2021-05-24 11:46:51', 1);
INSERT INTO `bls_word_user` VALUES (13, 19, 4, '2021-05-24 11:47:30', 1);
INSERT INTO `bls_word_user` VALUES (14, 20, 4, '2021-05-24 11:48:15', 1);
INSERT INTO `bls_word_user` VALUES (15, 21, 4, '2021-05-24 11:51:15', 1);
INSERT INTO `bls_word_user` VALUES (16, 22, 4, '2021-05-24 11:51:52', 1);
INSERT INTO `bls_word_user` VALUES (17, 23, 4, '2021-05-24 11:54:30', 1);
INSERT INTO `bls_word_user` VALUES (18, 24, 4, '2021-05-24 11:55:59', 1);
INSERT INTO `bls_word_user` VALUES (19, 25, 4, '2021-05-24 11:56:50', 1);
INSERT INTO `bls_word_user` VALUES (20, 26, 4, '2021-05-24 11:57:50', 1);
INSERT INTO `bls_word_user` VALUES (21, 27, 4, '2021-05-24 11:58:30', 1);
INSERT INTO `bls_word_user` VALUES (22, 28, 4, '2021-05-24 11:59:19', 1);
INSERT INTO `bls_word_user` VALUES (23, 29, 5, '2021-05-24 15:42:49', 1);
INSERT INTO `bls_word_user` VALUES (24, 30, 5, '2021-05-24 15:44:16', 1);
INSERT INTO `bls_word_user` VALUES (25, 31, 5, '2021-05-24 15:45:03', 1);
INSERT INTO `bls_word_user` VALUES (26, 32, 5, '2021-05-24 15:45:34', 1);
INSERT INTO `bls_word_user` VALUES (27, 33, 5, '2021-05-24 15:46:07', 1);
INSERT INTO `bls_word_user` VALUES (28, 34, 5, '2021-05-24 15:47:33', 1);
INSERT INTO `bls_word_user` VALUES (29, 35, 5, '2021-05-24 15:48:01', 1);
INSERT INTO `bls_word_user` VALUES (30, 36, 5, '2021-05-24 15:48:46', 1);
INSERT INTO `bls_word_user` VALUES (31, 37, 5, '2021-05-24 15:49:14', 1);
INSERT INTO `bls_word_user` VALUES (32, 38, 3, '2021-05-28 17:15:44', 1);
INSERT INTO `bls_word_user` VALUES (33, 39, 3, '2021-05-24 16:02:42', 1);
INSERT INTO `bls_word_user` VALUES (34, 40, 3, '2021-05-24 16:03:56', 1);
INSERT INTO `bls_word_user` VALUES (35, 41, 3, '2021-05-24 16:04:15', 1);
INSERT INTO `bls_word_user` VALUES (36, 42, 3, '2021-05-24 16:04:38', 1);
INSERT INTO `bls_word_user` VALUES (37, 43, 3, '2021-05-24 16:04:56', 1);
INSERT INTO `bls_word_user` VALUES (38, 44, 3, '2021-05-24 16:05:14', 1);
INSERT INTO `bls_word_user` VALUES (39, 45, 3, '2021-05-24 16:05:33', 1);
INSERT INTO `bls_word_user` VALUES (40, 46, 3, '2021-05-24 16:05:52', 1);
INSERT INTO `bls_word_user` VALUES (41, 47, 3, '2021-05-24 16:06:09', 1);
INSERT INTO `bls_word_user` VALUES (42, 48, 3, '2021-05-24 16:06:25', 1);
INSERT INTO `bls_word_user` VALUES (43, 49, 3, '2021-05-24 16:06:42', 1);
INSERT INTO `bls_word_user` VALUES (44, 50, 3, '2021-05-24 16:07:02', 1);
INSERT INTO `bls_word_user` VALUES (45, 51, 3, '2021-05-24 16:07:18', 1);
INSERT INTO `bls_word_user` VALUES (46, 52, 3, '2021-05-24 16:07:34', 1);
INSERT INTO `bls_word_user` VALUES (47, 53, 3, '2021-05-24 16:07:51', 1);
INSERT INTO `bls_word_user` VALUES (48, 54, 3, '2021-05-24 16:08:11', 1);
INSERT INTO `bls_word_user` VALUES (49, 55, 3, '2021-05-24 16:08:51', 1);
INSERT INTO `bls_word_user` VALUES (50, 56, 3, '2021-05-24 16:09:14', 1);
INSERT INTO `bls_word_user` VALUES (51, 57, 3, '2021-05-24 16:09:29', 1);
INSERT INTO `bls_word_user` VALUES (52, 58, 3, '2021-05-24 16:09:42', 1);
INSERT INTO `bls_word_user` VALUES (53, 59, 3, '2021-05-24 16:10:00', 1);
INSERT INTO `bls_word_user` VALUES (54, 60, 3, '2021-05-24 16:10:29', 1);
INSERT INTO `bls_word_user` VALUES (55, 61, 3, '2021-05-24 16:10:44', 1);
INSERT INTO `bls_word_user` VALUES (56, 62, 3, '2021-05-24 16:11:00', 1);
INSERT INTO `bls_word_user` VALUES (57, 63, 3, '2021-05-24 16:11:14', 1);
INSERT INTO `bls_word_user` VALUES (58, 64, 3, '2021-05-24 16:19:28', 1);
INSERT INTO `bls_word_user` VALUES (59, 65, 3, '2021-05-24 16:19:49', 1);
INSERT INTO `bls_word_user` VALUES (60, 66, 3, '2021-05-24 16:20:06', 1);
INSERT INTO `bls_word_user` VALUES (61, 67, 3, '2021-05-24 16:20:24', 1);
INSERT INTO `bls_word_user` VALUES (62, 68, 3, '2021-05-24 16:20:43', 1);
INSERT INTO `bls_word_user` VALUES (63, 69, 3, '2021-05-24 16:20:57', 1);
INSERT INTO `bls_word_user` VALUES (64, 70, 3, '2021-05-24 16:21:13', 1);
INSERT INTO `bls_word_user` VALUES (65, 71, 3, '2021-05-24 16:21:33', 1);
INSERT INTO `bls_word_user` VALUES (66, 72, 3, '2021-05-24 16:21:57', 1);
INSERT INTO `bls_word_user` VALUES (67, 73, 3, '2021-05-24 16:22:25', 1);
INSERT INTO `bls_word_user` VALUES (68, 74, 3, '2021-05-24 16:24:49', 1);
INSERT INTO `bls_word_user` VALUES (69, 75, 3, '2021-05-24 16:25:18', 1);
INSERT INTO `bls_word_user` VALUES (70, 76, 3, '2021-05-24 16:25:41', 1);
INSERT INTO `bls_word_user` VALUES (71, 77, 3, '2021-05-24 16:26:09', 1);
INSERT INTO `bls_word_user` VALUES (72, 78, 3, '2021-05-24 16:26:36', 1);
INSERT INTO `bls_word_user` VALUES (73, 79, 3, '2021-05-24 16:26:58', 1);
INSERT INTO `bls_word_user` VALUES (74, 80, 3, '2021-05-24 16:27:28', 1);
INSERT INTO `bls_word_user` VALUES (75, 81, 3, '2021-05-24 16:28:12', 1);
INSERT INTO `bls_word_user` VALUES (76, 82, 3, '2021-05-24 16:28:38', 1);
INSERT INTO `bls_word_user` VALUES (77, 83, 3, '2021-05-24 16:29:00', 1);
INSERT INTO `bls_word_user` VALUES (78, 84, 2, '2021-05-27 09:54:21', 0);
INSERT INTO `bls_word_user` VALUES (79, 85, 3, '2021-05-28 17:04:34', 0);
INSERT INTO `bls_word_user` VALUES (80, 86, 2, '2021-06-03 09:49:56', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
