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

 Date: 21/06/2021 10:20:04
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_node
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_rule
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_script
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_sentence
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_word
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_node
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_node_user
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_rule
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_rule_user
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of bls_script
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_script_user
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for bls_sentence
-- ----------------------------
DROP TABLE IF EXISTS `bls_sentence`;
CREATE TABLE `bls_sentence` (
  `sentence_id` int NOT NULL AUTO_INCREMENT,
  `name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '句子本身',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '相关描述',
  `paradigm` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '句型的巴克斯范式表示',
  `creator_id` bigint NOT NULL COMMENT '创建者用户ID',
  `editor_id` bigint NOT NULL COMMENT '最近一次编辑者用户ID',
  `update_time` datetime DEFAULT NULL COMMENT '最近一次更新时间',
  `is_type_in` int NOT NULL DEFAULT '0' COMMENT '0:未录入，1：已录入',
  `status` int NOT NULL DEFAULT '1' COMMENT '0:禁用 1：待开发 2： 开发中 3：待审核 4：待发布 5：已发布',
  PRIMARY KEY (`sentence_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of bls_sentence
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用于记录参与创建或修改句型的用户';

-- ----------------------------
-- Records of bls_sentence_user
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_user
-- ----------------------------
BEGIN;
INSERT INTO `bls_user` VALUES (1, 'visitor', '游客', '6cf5481d7250552812ea5596c7f0c248', '4NUJulZ&GrdG', NULL, NULL, NULL, '2021-05-22 15:20:49', '2021-05-22 15:20:53', 1, 1);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='帮语词汇表';

-- ----------------------------
-- Records of bls_word
-- ----------------------------
BEGIN;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用于记录参与创建或修改词汇的用户';

-- ----------------------------
-- Records of bls_word_user
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
