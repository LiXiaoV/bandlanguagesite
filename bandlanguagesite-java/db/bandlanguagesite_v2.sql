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

 Date: 27/05/2021 15:25:20
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept` VALUES (1, 0, '机构管理', '机构管理场景区，负责帮区机构管理部分的工作', NULL, 0, '2021-05-21 14:45:30', 1);
INSERT INTO `bls_dept` VALUES (2, 0, '功能集成', '功能集成场景区，负责帮区功能集成帮语的工作', NULL, 0, '2021-05-21 14:48:39', 1);
INSERT INTO `bls_dept` VALUES (3, 0, '论文分析', '论文分析场景区，负责帮区论文分析的工作', NULL, 0, '2021-05-22 14:16:43', 1);
INSERT INTO `bls_dept` VALUES (4, 0, '物流管理', '物流管理场景区，负责帮区物流管理的工作', NULL, 0, '2021-05-24 11:31:01', 1);
INSERT INTO `bls_dept` VALUES (5, 0, '服务操作系统', '服务操作系统场景区，负责帮区服务操作系统的工作', NULL, 0, '2021-05-24 11:32:35', 1);
COMMIT;

-- ----------------------------
-- Table structure for bls_dept_script
-- ----------------------------
DROP TABLE IF EXISTS `bls_dept_script`;
CREATE TABLE `bls_dept_script` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dept_id` bigint NOT NULL COMMENT '场景区id',
  `script_id` bigint NOT NULL COMMENT '剧本id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_script
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept_script` VALUES (1, 3, 1);
INSERT INTO `bls_dept_script` VALUES (2, 1, 2);
INSERT INTO `bls_dept_script` VALUES (3, 1, 3);
INSERT INTO `bls_dept_script` VALUES (4, 1, 4);
INSERT INTO `bls_dept_script` VALUES (5, 1, 5);
INSERT INTO `bls_dept_script` VALUES (6, 1, 6);
INSERT INTO `bls_dept_script` VALUES (7, 5, 7);
COMMIT;

-- ----------------------------
-- Table structure for bls_dept_sentence
-- ----------------------------
DROP TABLE IF EXISTS `bls_dept_sentence`;
CREATE TABLE `bls_dept_sentence` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dept_id` bigint NOT NULL,
  `sentence_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_sentence
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept_sentence` VALUES (1, 3, 1);
INSERT INTO `bls_dept_sentence` VALUES (2, 3, 2);
INSERT INTO `bls_dept_sentence` VALUES (3, 3, 3);
INSERT INTO `bls_dept_sentence` VALUES (4, 3, 4);
INSERT INTO `bls_dept_sentence` VALUES (5, 3, 5);
INSERT INTO `bls_dept_sentence` VALUES (6, 1, 6);
INSERT INTO `bls_dept_sentence` VALUES (7, 1, 7);
INSERT INTO `bls_dept_sentence` VALUES (8, 1, 8);
INSERT INTO `bls_dept_sentence` VALUES (9, 1, 9);
INSERT INTO `bls_dept_sentence` VALUES (10, 1, 10);
INSERT INTO `bls_dept_sentence` VALUES (11, 1, 11);
INSERT INTO `bls_dept_sentence` VALUES (12, 1, 12);
INSERT INTO `bls_dept_sentence` VALUES (13, 1, 13);
INSERT INTO `bls_dept_sentence` VALUES (14, 1, 14);
INSERT INTO `bls_dept_sentence` VALUES (15, 1, 15);
INSERT INTO `bls_dept_sentence` VALUES (16, 1, 16);
INSERT INTO `bls_dept_sentence` VALUES (17, 1, 17);
INSERT INTO `bls_dept_sentence` VALUES (18, 1, 18);
INSERT INTO `bls_dept_sentence` VALUES (19, 1, 19);
INSERT INTO `bls_dept_sentence` VALUES (20, 1, 20);
INSERT INTO `bls_dept_sentence` VALUES (21, 1, 21);
INSERT INTO `bls_dept_sentence` VALUES (22, 1, 22);
INSERT INTO `bls_dept_sentence` VALUES (23, 1, 23);
INSERT INTO `bls_dept_sentence` VALUES (24, 1, 24);
INSERT INTO `bls_dept_sentence` VALUES (25, 1, 25);
INSERT INTO `bls_dept_sentence` VALUES (26, 1, 26);
INSERT INTO `bls_dept_sentence` VALUES (27, 1, 27);
INSERT INTO `bls_dept_sentence` VALUES (28, 1, 28);
INSERT INTO `bls_dept_sentence` VALUES (29, 1, 29);
INSERT INTO `bls_dept_sentence` VALUES (30, 1, 30);
INSERT INTO `bls_dept_sentence` VALUES (31, 5, 31);
INSERT INTO `bls_dept_sentence` VALUES (32, 5, 32);
INSERT INTO `bls_dept_sentence` VALUES (33, 5, 33);
INSERT INTO `bls_dept_sentence` VALUES (34, 5, 34);
INSERT INTO `bls_dept_sentence` VALUES (35, 5, 35);
COMMIT;

-- ----------------------------
-- Table structure for bls_dept_word
-- ----------------------------
DROP TABLE IF EXISTS `bls_dept_word`;
CREATE TABLE `bls_dept_word` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dept_id` bigint NOT NULL COMMENT '场景区id',
  `word_id` bigint NOT NULL COMMENT '词id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_dept_word
-- ----------------------------
BEGIN;
INSERT INTO `bls_dept_word` VALUES (1, 3, 6);
INSERT INTO `bls_dept_word` VALUES (2, 3, 7);
INSERT INTO `bls_dept_word` VALUES (3, 3, 8);
INSERT INTO `bls_dept_word` VALUES (5, 3, 10);
INSERT INTO `bls_dept_word` VALUES (6, 3, 11);
INSERT INTO `bls_dept_word` VALUES (7, 1, 12);
INSERT INTO `bls_dept_word` VALUES (8, 1, 13);
INSERT INTO `bls_dept_word` VALUES (9, 1, 14);
INSERT INTO `bls_dept_word` VALUES (10, 1, 15);
INSERT INTO `bls_dept_word` VALUES (11, 1, 16);
INSERT INTO `bls_dept_word` VALUES (12, 1, 17);
INSERT INTO `bls_dept_word` VALUES (13, 1, 18);
INSERT INTO `bls_dept_word` VALUES (14, 1, 19);
INSERT INTO `bls_dept_word` VALUES (15, 1, 20);
INSERT INTO `bls_dept_word` VALUES (16, 1, 21);
INSERT INTO `bls_dept_word` VALUES (17, 1, 22);
INSERT INTO `bls_dept_word` VALUES (18, 1, 23);
INSERT INTO `bls_dept_word` VALUES (19, 1, 24);
INSERT INTO `bls_dept_word` VALUES (20, 1, 25);
INSERT INTO `bls_dept_word` VALUES (21, 1, 26);
INSERT INTO `bls_dept_word` VALUES (22, 1, 27);
INSERT INTO `bls_dept_word` VALUES (23, 1, 28);
INSERT INTO `bls_dept_word` VALUES (24, 5, 29);
INSERT INTO `bls_dept_word` VALUES (25, 5, 30);
INSERT INTO `bls_dept_word` VALUES (26, 5, 31);
INSERT INTO `bls_dept_word` VALUES (27, 5, 32);
INSERT INTO `bls_dept_word` VALUES (28, 5, 33);
INSERT INTO `bls_dept_word` VALUES (29, 5, 34);
INSERT INTO `bls_dept_word` VALUES (30, 5, 35);
INSERT INTO `bls_dept_word` VALUES (31, 5, 36);
INSERT INTO `bls_dept_word` VALUES (32, 5, 37);
INSERT INTO `bls_dept_word` VALUES (33, 2, 38);
INSERT INTO `bls_dept_word` VALUES (34, 2, 39);
INSERT INTO `bls_dept_word` VALUES (35, 2, 40);
INSERT INTO `bls_dept_word` VALUES (36, 2, 41);
INSERT INTO `bls_dept_word` VALUES (37, 2, 42);
INSERT INTO `bls_dept_word` VALUES (38, 2, 43);
INSERT INTO `bls_dept_word` VALUES (39, 2, 44);
INSERT INTO `bls_dept_word` VALUES (40, 2, 45);
INSERT INTO `bls_dept_word` VALUES (41, 2, 46);
INSERT INTO `bls_dept_word` VALUES (42, 2, 47);
INSERT INTO `bls_dept_word` VALUES (43, 2, 48);
INSERT INTO `bls_dept_word` VALUES (44, 2, 49);
INSERT INTO `bls_dept_word` VALUES (45, 2, 50);
INSERT INTO `bls_dept_word` VALUES (46, 2, 51);
INSERT INTO `bls_dept_word` VALUES (47, 2, 52);
INSERT INTO `bls_dept_word` VALUES (48, 2, 53);
INSERT INTO `bls_dept_word` VALUES (49, 2, 54);
INSERT INTO `bls_dept_word` VALUES (50, 2, 55);
INSERT INTO `bls_dept_word` VALUES (51, 2, 56);
INSERT INTO `bls_dept_word` VALUES (52, 2, 57);
INSERT INTO `bls_dept_word` VALUES (53, 2, 58);
INSERT INTO `bls_dept_word` VALUES (54, 2, 59);
INSERT INTO `bls_dept_word` VALUES (55, 2, 60);
INSERT INTO `bls_dept_word` VALUES (56, 2, 61);
INSERT INTO `bls_dept_word` VALUES (57, 2, 62);
INSERT INTO `bls_dept_word` VALUES (58, 2, 63);
INSERT INTO `bls_dept_word` VALUES (59, 2, 64);
INSERT INTO `bls_dept_word` VALUES (60, 2, 65);
INSERT INTO `bls_dept_word` VALUES (61, 2, 66);
INSERT INTO `bls_dept_word` VALUES (62, 2, 67);
INSERT INTO `bls_dept_word` VALUES (63, 2, 68);
INSERT INTO `bls_dept_word` VALUES (64, 2, 69);
INSERT INTO `bls_dept_word` VALUES (65, 2, 70);
INSERT INTO `bls_dept_word` VALUES (66, 2, 71);
INSERT INTO `bls_dept_word` VALUES (67, 2, 72);
INSERT INTO `bls_dept_word` VALUES (68, 2, 73);
INSERT INTO `bls_dept_word` VALUES (69, 2, 74);
INSERT INTO `bls_dept_word` VALUES (70, 2, 75);
INSERT INTO `bls_dept_word` VALUES (71, 2, 76);
INSERT INTO `bls_dept_word` VALUES (72, 2, 77);
INSERT INTO `bls_dept_word` VALUES (73, 2, 78);
INSERT INTO `bls_dept_word` VALUES (74, 2, 79);
INSERT INTO `bls_dept_word` VALUES (75, 2, 80);
INSERT INTO `bls_dept_word` VALUES (76, 2, 81);
INSERT INTO `bls_dept_word` VALUES (77, 2, 82);
INSERT INTO `bls_dept_word` VALUES (78, 2, 83);
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
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '表唯一标识',
  `role_id` bigint NOT NULL COMMENT '角色id',
  `menu_id` bigint NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_role_menu
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
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `creator_id` bigint NOT NULL COMMENT '创建者用户ID',
  `editor_id` bigint NOT NULL DEFAULT '0' COMMENT '最近一次编辑者用户ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `run_times` bigint DEFAULT '0' COMMENT '运行次数',
  `status` int NOT NULL DEFAULT '1' COMMENT '0:禁用 1：待开发 2： 开发中 3：待审核 4：待发布 5：已发布',
  PRIMARY KEY (`script_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

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
  `status` int NOT NULL DEFAULT '1' COMMENT '0:禁用 1：待开发 2： 开发中 3：待审核 4：待发布 5：已发布',
  PRIMARY KEY (`sentence_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of bls_sentence
-- ----------------------------
BEGIN;
INSERT INTO `bls_sentence` VALUES (1, '运行工具句型', '运行某个工具，得到结果', '<创建> <字符串> \"部门\"', 2, 2, '2021-05-24 02:46:15', 1);
INSERT INTO `bls_sentence` VALUES (2, '查看工具', '查看场景区可以运行的工具', 'bbb', 2, 2, '2021-05-24 02:49:05', 1);
INSERT INTO `bls_sentence` VALUES (3, '移除工具', '移除一个场景区的工具', 'ccc', 2, 2, '2021-05-24 02:52:38', 1);
INSERT INTO `bls_sentence` VALUES (4, '句型四', '一个句型', 'ddd', 2, 2, '2021-05-24 02:57:05', 1);
INSERT INTO `bls_sentence` VALUES (5, '句型五', '一个句型', 'eee', 2, 2, '2021-05-24 03:03:21', 1);
INSERT INTO `bls_sentence` VALUES (6, '查看部门', '对机构中的所有部门查看', '<查看部门>::= “显示” <机构名> “的” “所有部门”;', 4, 4, '2021-05-24 14:40:18', 1);
INSERT INTO `bls_sentence` VALUES (7, '创建部门', '创建部门或子部门，创建子部门需要指定在某个部门中，直接通过写出的部门名来定位。', '<创建部门>::=“创建” <部门名> “部门”\r\n| “在” <部门名> “中” “,” “创建” <部门名> “子部门”;', 4, 4, '2021-05-24 14:42:31', 1);
INSERT INTO `bls_sentence` VALUES (8, '修改部门', '对部门的修改管理，主要对部门名称的修改操作', '<修改部门>::=“把” <部门名> “部门” “修改为” <部门名>;', 4, 4, '2021-05-24 14:43:28', 1);
INSERT INTO `bls_sentence` VALUES (9, '移动部门', '对部门的移动表示将前者部门移动到后者中，作为后者的一个子部门。', '<移动部门>::=“把” <部门名> “部门” “移动到” <部门名> “中”;', 4, 4, '2021-05-24 14:44:14', 1);
INSERT INTO `bls_sentence` VALUES (10, '撤消部门', '对机构部门或部门中子部门的撤消操作', '<撤消部门>::=“撤消” <部门名> “部门”;\r\n| “在” <部门名> “中” “,” “撤消” <部门名> “子部门”;', 4, 4, '2021-05-24 14:47:06', 1);
INSERT INTO `bls_sentence` VALUES (11, '合并部门', '将两个部门合并为新部门或把一个部门合并到另一个部门中的操作', '<合并部门>::=“把” <部门名> “和” <部门名> “合并为” <部门名> “部门”\n| “将” <部门名> “部门” “合并到” <部门名>;', 4, 4, '2021-05-24 15:07:55', 1);
INSERT INTO `bls_sentence` VALUES (12, '查看岗位', '对机构或部门中的岗位查看', '<查看岗位>::=“显示” (<机构名> | <部门名>) “的” “所有岗位”;', 4, 4, '2021-05-24 15:08:55', 1);
INSERT INTO `bls_sentence` VALUES (13, '创建岗位', '对岗位的创建操作，不指定部门地点则表示在机构层创建岗位。', '<创建岗位>::=[“在” <部门名> “中” “,”] “创建” <岗位名> “岗位”;', 4, 4, '2021-05-24 15:09:36', 1);
INSERT INTO `bls_sentence` VALUES (14, '修改岗位', '对岗位的修改管理为修改岗位的名称。', '<修改岗位>::=[“在” <部门名> “中”] “把” <岗位名> “岗位” “修改为” <岗位名>;', 4, 4, '2021-05-24 15:10:12', 1);
INSERT INTO `bls_sentence` VALUES (15, '移除岗位', '将岗位从机构或部门中移除，若不指定在某个部门，则表示对机构层的岗位移除。', '<移除岗位>::=[“在” <部门名> “中” “,”] “移除” <岗位名> “岗位”\n| “对” <部门名> “移除” <岗位名> “岗位”;', 4, 4, '2021-05-24 15:10:57', 1);
INSERT INTO `bls_sentence` VALUES (16, '岗位约束', '对机构中的岗位制定约束规则。', '<岗位约束>::=<岗位名> “要出现在” <部门名> “中”;', 4, 4, '2021-05-24 15:11:27', 1);
INSERT INTO `bls_sentence` VALUES (17, '查看成员', '成员管理中的查看成员包括查看机构、部门或岗位中的所有成员。其中对岗位查看成员时，根据岗位是机构岗位还是部门岗位，选择是否需要指定部门地点。', '<查看成员>::=“显示” (<机构名> | <部门名>) “的” “所有成员”\n| [“在” <部门名> “中” “,”] “显示” <岗位名> “的” “所有成员”;', 4, 4, '2021-05-24 15:13:26', 1);
INSERT INTO `bls_sentence` VALUES (18, '添加成员', '对成员的添加操作，若不指定部门则表示对机构添加平台系统中的某个成员。', '<添加成员>::=“把” <成员名> “拉入到” <部门名> “部门”\n| [“在” <部门名> “中” “,”] “添加” “成员” <成员名>;', 4, 4, '2021-05-24 15:13:59', 1);
INSERT INTO `bls_sentence` VALUES (19, '移除成员', '将成员从机构或部门中移除的操作句型。', '<移除成员>::=[“在” <部门名> “中” “,”] “移除” “成员” <成员名>;', 4, 4, '2021-05-24 15:14:31', 1);
INSERT INTO `bls_sentence` VALUES (20, '任命岗位', '为成员在机构或部门中任命某个岗位的管理操作', '<任命岗位>::=[“在” <部门名> “中”] “为” <成员名> “任命” <岗位名> “岗位”;', 4, 4, '2021-05-24 15:15:01', 1);
INSERT INTO `bls_sentence` VALUES (21, '免除岗位', '将成员从某个岗位中免职的操作句型。', '<免除岗位>::=[“在” <部门名> “部门” “中”] “为” <成员名> “免除” <岗位名> “岗位”;', 4, 4, '2021-05-24 15:15:28', 1);
INSERT INTO `bls_sentence` VALUES (22, '更换岗位', '对成员从某个岗位更换到另一个岗位的句型表述。', '<更换岗位>::=“把” <成员名> “从” <岗位名> “更换到” <岗位名> “岗位”;', 4, 4, '2021-05-24 15:16:00', 1);
INSERT INTO `bls_sentence` VALUES (23, '成员派遣', '对机构成员派遣的操作描述。', '<成员派遣>::=“把” <成员名> “派遣到” <部门名> “部门”;', 4, 4, '2021-05-24 15:16:59', 1);
INSERT INTO `bls_sentence` VALUES (24, '成员约束', '对成员出现在部门或岗位中的规则约束。', '<成员约束>::=<成员名> “要出现在” <部门名> “中”;', 4, 4, '2021-05-24 15:17:22', 1);
INSERT INTO `bls_sentence` VALUES (25, '授予权限', '授予权限句型表示对岗位或成员授予某个角色，根据不同业务选择是否指定部门。', '<授予权限>::=[“在” <部门名> “中”] “为” (<岗位名> | <成员名>) “授予” <角色名> “角色”;', 4, 4, '2021-05-24 15:17:57', 1);
INSERT INTO `bls_sentence` VALUES (26, '设定通行证', '授予权限时，设定权限的有效期。', '<设定通行证>::=“设定” “有效期” <时间补语>;', 4, 4, '2021-05-24 15:18:26', 1);
INSERT INTO `bls_sentence` VALUES (27, '移除权限', '对岗位或成员移除某个角色权限的管理操作。', '<移除权限>::=[“在” <部门名> “中”] “为” (<岗位名> | <成员名>) “移除” <角色名> “角色”;', 4, 4, '2021-05-24 15:18:52', 1);
INSERT INTO `bls_sentence` VALUES (28, '权限约束', '对岗位或成员的权限约束。', '<权限约束>::=(<岗位名> | <成员名>) “在” <部门名> “中” “拥有” <角色名> “角色”;', 4, 4, '2021-05-24 15:19:22', 1);
INSERT INTO `bls_sentence` VALUES (29, '资源发布', '发布管理中对资源的发布，表示发布资源给某个成员或某个部门等。', '<资源发布>::=“发布给” (<成员名> | <地点名>) <资源名>\n| “把” <资源名> “发布到” (<成员名> | <地点名>);', 4, 4, '2021-05-24 15:19:59', 1);
INSERT INTO `bls_sentence` VALUES (30, '取消发布', '对已经发布的资源取消，使用动词关键词“取消发布”后接要取消的发布名称。', '<取消发布>::=“取消发布” <发布名称>;', 4, 4, '2021-05-24 15:20:28', 1);
INSERT INTO `bls_sentence` VALUES (31, '显示摄像头图像', '显示摄像头图像', '显示 摄像头 B8摄像头 的 图像', 5, 5, '2021-05-24 15:50:02', 1);
INSERT INTO `bls_sentence` VALUES (32, '显示图像生人熟人集合', '显示图像生人熟人集合', '显示 图像 XXX 的 生人 /熟人集合', 5, 5, '2021-05-24 15:51:10', 1);
INSERT INTO `bls_sentence` VALUES (33, '显示图像是否有生人熟人', '显示图像是否有生人熟人', '显示 图像XXX 是否 有 生人/熟人', 5, 5, '2021-05-24 15:52:02', 1);
INSERT INTO `bls_sentence` VALUES (34, '音响发声', '音响发声', '音响B8音响  发声  ：音响播放默认警铃=B8  警报', 5, 5, '2021-05-24 15:52:36', 1);
INSERT INTO `bls_sentence` VALUES (35, '影像静音', '音响静音', '音响B8音响  静音', 5, 5, '2021-05-24 15:53:03', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bls_user
-- ----------------------------
BEGIN;
INSERT INTO `bls_user` VALUES (1, 'visitor', '游客', '6cf5481d7250552812ea5596c7f0c248', '4NUJulZ&GrdG', NULL, NULL, NULL, '2021-05-22 15:20:49', '2021-05-22 15:20:53', 1, 1);
INSERT INTO `bls_user` VALUES (2, 'liwei', '黎威', '6b63d04f80af99ae5cde482a3559c459', '(UjrELVjqwof', '13387603239', '1011529903@qq.com', NULL, '2021-05-22 15:21:45', '2021-05-22 15:21:47', 7, 1);
INSERT INTO `bls_user` VALUES (3, 'chencongying', '陈聪颖', 'c9da383357b25f5136da98e1a9ef5113', 'GDQ9j#4nBP3)', NULL, NULL, NULL, '2021-05-24 11:26:37', '2021-05-24 11:26:42', 1, 1);
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
  `status` int NOT NULL DEFAULT '1' COMMENT '0:禁用 1：待开发 2： 开发中 3：待审核 4：待发布 5：已发布',
  PRIMARY KEY (`word_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='帮语词汇表';

-- ----------------------------
-- Records of bls_word
-- ----------------------------
BEGIN;
INSERT INTO `bls_word` VALUES (6, '分析', '对论文进行一定的思考', '论文分析', 2, '解析', 2, 2, '2021-05-23 23:37:54', 1);
INSERT INTO `bls_word` VALUES (7, '维度', '分析论文的一个方向', '分析维度', 1, '类型', 2, 2, '2021-05-23 23:50:18', 1);
INSERT INTO `bls_word` VALUES (8, '推荐', '想别人推荐论文', '论文推荐', 2, '建议', 2, 2, '2021-05-23 23:59:45', 1);
INSERT INTO `bls_word` VALUES (10, '词汇四', '一个词汇', '啊啊', 1, '词汇1', 2, 2, '2021-05-24 03:00:10', 1);
INSERT INTO `bls_word` VALUES (11, '词汇五', '一个词汇', '丫丫', 1, '词汇四', 2, 2, '2021-05-24 03:01:44', 1);
INSERT INTO `bls_word` VALUES (12, '机构', '表示支撑平台中的机构实体，与支撑平台相关', '创建机构', 1, '', 4, 4, '2021-05-24 11:37:43', 1);
INSERT INTO `bls_word` VALUES (13, '部门', '表示支撑平台中的部门实体，范围上属于机构的子集，是机构的下一级单位。', '创建部门', 1, '', 4, 4, '2021-05-24 11:38:48', 1);
INSERT INTO `bls_word` VALUES (14, '父部门', '是指某个部门的直接上级部门，只有一个，需要以某个部门为基才能定位其父部门。', '某某部门的父部门是什么', 1, '', 4, 4, '2021-05-24 11:41:31', 1);
INSERT INTO `bls_word` VALUES (15, '上级部门', '指某个部门的所有上级部门，即遍历获得父部门的父部门，返回的部门数量可能不止一个。', '某某部门的上级部门是什么', 1, '', 4, 4, '2021-05-24 11:42:14', 1);
INSERT INTO `bls_word` VALUES (16, '子部门', '是指某个部门的下级部门，可能不止一个，所以可能返回空或一个部门或部门集合。', '某某部门的子部门有多少个', 1, '', 4, 4, '2021-05-24 11:43:17', 1);
INSERT INTO `bls_word` VALUES (17, '下级部门', '词法规则名和语义同“子部门”。', '某某部门的下级部门有多少个', 1, '', 4, 4, '2021-05-24 11:43:59', 1);
INSERT INTO `bls_word` VALUES (18, '帮区', '表示支撑平台中的“帮区”实体，属于部门的一个子属性，对部门的各属性管理实质上是在部门的主帮区中进行。', '创建帮区', 1, '', 4, 4, '2021-05-24 11:46:51', 1);
INSERT INTO `bls_word` VALUES (19, '父帮区', '指某个帮区的直接上一级帮区，仅指代直接父帮区，所以返回结果是零或一个帮区，需要以某个帮区为基才能定位其父帮区。', '某某帮区的父帮区是什么', 1, '', 4, 4, '2021-05-24 11:47:30', 1);
INSERT INTO `bls_word` VALUES (20, '子帮区', '是指某个帮区的下级帮区，可能不止一个，所以可能返回空或一个帮区或帮区集合。', '创建子帮区', 1, '', 4, 4, '2021-05-24 11:48:15', 1);
INSERT INTO `bls_word` VALUES (21, '岗位', '岗位实际上是多个成员组成的一个集合，形成了“岗位”实体，岗位存在于机构、部门和帮区中，对岗位的管理实际上就是对属性归成同一类的成员们的管理。', '创建岗位', 1, '', 4, 4, '2021-05-24 11:51:15', 1);
INSERT INTO `bls_word` VALUES (22, '成员', '成员是机构、部门和帮区里的人员，对于成员的管理通常有添加、移除等操作。具体的管理操作也是需要在语句中和谓语动词结合才能确定。', '添加成员', 1, '', 4, 4, '2021-05-24 11:51:52', 1);
INSERT INTO `bls_word` VALUES (23, '工具', '工具是属于帮区中的一个属性，是构成帮区所必不可少的元素。对“工具”词汇的使用通常是调用运行，或指定工具中的具体运行部件后得到返回结果。', '查看工具', 1, '', 4, 4, '2021-05-24 11:54:30', 1);
INSERT INTO `bls_word` VALUES (24, '创建', '在机构管理场景下，通常指对一个实体的创建，是从无到有的一个概念，其后通常跟说明名称的标识符和一个实体名词，对应一次创建并命名实体的动作。', '创建子部门', 2, '新建', 4, 4, '2021-05-24 11:55:59', 1);
INSERT INTO `bls_word` VALUES (25, '添加', '是对用户添加到机构或部门等平台实体的动作，对支撑平台中已存在的实体的操作，需要搭配用户和要拉入的地点标识符才能对整个动作补全。实际映射在底层数据库中是对库表新增一条字段。', '添加人员', 2, '加入', 4, 4, '2021-05-24 11:56:50', 1);
INSERT INTO `bls_word` VALUES (26, '删除', '删除一个实体或实体属性的动作，映射在数据库中是删除某条字段或字段中的数据。', '删除子部门', 2, '移除', 4, 4, '2021-05-24 11:57:50', 1);
INSERT INTO `bls_word` VALUES (27, '移除', '词法规则名和语义同“删除”。', '移除子部门', 2, '去除', 4, 4, '2021-05-24 11:58:30', 1);
INSERT INTO `bls_word` VALUES (28, '授予', '对权限的操作，通常是给用户或岗位授予某个角色的动作。', '授予管理员权限', 2, '', 4, 4, '2021-05-24 11:59:19', 1);
INSERT INTO `bls_word` VALUES (29, '摄像头', '摄像头', '显示 摄像头 B8摄像头 的 图像', 1, '', 5, 5, '2021-05-24 15:42:49', 1);
INSERT INTO `bls_word` VALUES (30, '图像', '图像', '显示 摄像头 B8摄像头 的 图像', 1, '', 5, 5, '2021-05-24 15:44:16', 1);
INSERT INTO `bls_word` VALUES (31, '出现', '出现', '出现生人', 2, '', 5, 5, '2021-05-24 15:45:03', 1);
INSERT INTO `bls_word` VALUES (32, '生人', '陌生人', '出现陌生人', 1, '陌生人', 5, 5, '2021-05-24 15:45:34', 1);
INSERT INTO `bls_word` VALUES (33, '熟人', '经常出现的人', '出现熟人', 1, '', 5, 5, '2021-05-24 15:46:07', 1);
INSERT INTO `bls_word` VALUES (34, '音响', '音响', '音响发声', 1, '', 5, 5, '2021-05-24 15:47:33', 1);
INSERT INTO `bls_word` VALUES (35, '发声', '发出声音', '音响发声', 2, '', 5, 5, '2021-05-24 15:48:01', 1);
INSERT INTO `bls_word` VALUES (36, '警报', '警示别人的声音', '发出警报', 1, '', 5, 5, '2021-05-24 15:48:46', 1);
INSERT INTO `bls_word` VALUES (37, '静音', '不出声', '影像静音', 2, '', 5, 5, '2021-05-24 15:49:14', 1);
INSERT INTO `bls_word` VALUES (38, '显示', '将后面跟随的词汇所表示的内容显示到页面上', '显示 所有成员', 2, '', 3, 3, '2021-05-24 16:00:51', 1);
INSERT INTO `bls_word` VALUES (39, '得到', '表明要获取哪些功能接口的返回结果', '', 2, '', 3, 3, '2021-05-24 16:02:42', 1);
INSERT INTO `bls_word` VALUES (40, '设定', '对于某个词汇进行定义，用于设定句型', '', 2, '', 3, 3, '2021-05-24 16:03:56', 1);
INSERT INTO `bls_word` VALUES (41, '改成', '将某个属性修改为某个值', '', 2, '', 3, 3, '2021-05-24 16:04:15', 1);
INSERT INTO `bls_word` VALUES (42, '新建', '创建一个对象', '', 2, '', 3, 3, '2021-05-24 16:04:38', 1);
INSERT INTO `bls_word` VALUES (43, '重命名为', '将某个对象进行重命名', '', 2, '', 3, 3, '2021-05-24 16:04:56', 1);
INSERT INTO `bls_word` VALUES (44, '找出', '在某个集合中查询出符合条件的记录', '', 2, '', 3, 3, '2021-05-24 16:05:14', 1);
INSERT INTO `bls_word` VALUES (45, '去掉', '在某个集合中删除那些符合条件的记录', '', 2, '', 3, 3, '2021-05-24 16:05:33', 1);
INSERT INTO `bls_word` VALUES (46, '统计', '统计某个集合中符合条件的对象的数量，并显示到页面上', '', 2, '', 3, 3, '2021-05-24 16:05:52', 1);
INSERT INTO `bls_word` VALUES (47, '删除', '删除后面跟的词所代表的对象', '', 2, '', 3, 3, '2021-05-24 16:06:09', 1);
INSERT INTO `bls_word` VALUES (48, '进行分组', '将集合对象按照某个属性进行分组，分组之后的记录，属性相同的会存放在一起', '', 2, '', 3, 3, '2021-05-24 16:06:25', 1);
INSERT INTO `bls_word` VALUES (49, '合并成为', '将若干个对象合并成为一个对象', '', 2, '', 3, 3, '2021-05-24 16:06:42', 1);
INSERT INTO `bls_word` VALUES (50, '添加', '往某个集合对象中添加单个对象', '', 2, '', 3, 3, '2021-05-24 16:07:02', 1);
INSERT INTO `bls_word` VALUES (51, '执行', '执行某个工具或者某条语句', '', 2, '', 3, 3, '2021-05-24 16:07:18', 1);
INSERT INTO `bls_word` VALUES (52, '升序排序', '对于集合对象按照数字大小由小到大进行排序', '', 2, '', 3, 3, '2021-05-24 16:07:34', 1);
INSERT INTO `bls_word` VALUES (53, '降序排序', '对于集合对象按照数字大小由大到小进行排序', '', 2, '', 3, 3, '2021-05-24 16:07:51', 1);
INSERT INTO `bls_word` VALUES (54, '拷贝一份为', '拷贝某个对象，形成新的对象', '', 2, '', 3, 3, '2021-05-24 16:08:11', 1);
INSERT INTO `bls_word` VALUES (55, '输入部件', '代指调用工具功能接口需要的参数以及这些参数所表示的含义。', '', 1, '', 3, 3, '2021-05-24 16:08:51', 1);
INSERT INTO `bls_word` VALUES (56, '输出部件', '代指工具功能接口所提供的功能、返回结果的含义以及所需要的参数', '', 1, '', 3, 3, '2021-05-24 16:09:14', 1);
INSERT INTO `bls_word` VALUES (57, '元素', '代指集合中的单个对象', '', 1, '', 3, 3, '2021-05-24 16:09:29', 1);
INSERT INTO `bls_word` VALUES (58, '记录', '同‘元素’一样', '', 1, '', 3, 3, '2021-05-24 16:09:42', 1);
INSERT INTO `bls_word` VALUES (59, '数量', '一般和‘元素’搭配，表明元素的具体数量', '', 1, '', 3, 3, '2021-05-24 16:10:00', 1);
INSERT INTO `bls_word` VALUES (60, '最大值', '数字集合中最大的数字', '', 1, '', 3, 3, '2021-05-24 16:10:29', 1);
INSERT INTO `bls_word` VALUES (61, '最小值', '数字集合中最小的数字', '', 1, '', 3, 3, '2021-05-24 16:10:44', 1);
INSERT INTO `bls_word` VALUES (62, '平均值', '表示根据某个数字集合，求出其平均值', '', 1, '', 3, 3, '2021-05-24 16:11:00', 1);
INSERT INTO `bls_word` VALUES (63, '总和', '某个数字集合进行累加的最终结果', '', 1, '', 3, 3, '2021-05-24 16:11:14', 1);
INSERT INTO `bls_word` VALUES (64, '等于', '等于有三种含义。一种是在判断句型中，表示判断它前后两个对象是否相等。一种是在“调用工具”句型中，表示对于参数进行赋值。一种是在“设定”句型中充当连接词，表明后者是前者的实际含义', '', 3, '', 3, 3, '2021-05-24 16:19:28', 1);
INSERT INTO `bls_word` VALUES (65, '为', '等同于“等于”', '', 3, '', 3, 3, '2021-05-24 16:19:49', 1);
INSERT INTO `bls_word` VALUES (66, '不等于', '表示两者不相等', '', 3, '', 3, 3, '2021-05-24 16:20:06', 1);
INSERT INTO `bls_word` VALUES (67, '大于', '表示前者的值大于后者的值', '', 3, '', 3, 3, '2021-05-24 16:20:24', 1);
INSERT INTO `bls_word` VALUES (68, '不大于', '表示前者的值小于等于后者的值', '', 3, '', 3, 3, '2021-05-24 16:20:43', 1);
INSERT INTO `bls_word` VALUES (69, '小于', '表示前者的值小于后者的值', '', 3, '', 3, 3, '2021-05-24 16:20:57', 1);
INSERT INTO `bls_word` VALUES (70, '不小于', '表示前者的值大于等于后者的值', '', 3, '', 3, 3, '2021-05-24 16:21:13', 1);
INSERT INTO `bls_word` VALUES (71, '[0-9]+', '词汇所对应的具体数字', '', 5, '', 3, 3, '2021-05-24 16:21:33', 1);
INSERT INTO `bls_word` VALUES (72, '被引号包裹的字符串', '引号内部的字符串', '', 12, '', 3, 3, '2021-05-24 16:21:57', 1);
INSERT INTO `bls_word` VALUES (73, '未被引号包裹的字符串', '代表着某一个对象，又或者某个对象的某个属性。具体代指什么需要结合上下文来进行分析', '', 12, '', 3, 3, '2021-05-24 16:22:25', 1);
INSERT INTO `bls_word` VALUES (74, '把', '用于指定操作对象，同时充当“把”字句的标识符', '', 10, '', 3, 3, '2021-05-24 16:24:49', 1);
INSERT INTO `bls_word` VALUES (75, '的', '一般用于连接两个名词或者对象名称，从而表明后者是属于前者的这种关系。除此之外，也用于句子成分之间的连接，使得语句通顺', '** 的 **', 10, '', 3, 3, '2021-05-24 16:25:18', 1);
INSERT INTO `bls_word` VALUES (76, '其中', '在“调用工具”句型中，用于连接两个句子成分，表示后面的语句是对于前面语句的进一步说明', '***，其中，***', 10, '', 3, 3, '2021-05-24 16:25:41', 1);
INSERT INTO `bls_word` VALUES (77, '作为参数', '和“把”一起在“调用工具”句型中用于指定参数', '把 ** 作为参数', 10, '', 3, 3, '2021-05-24 16:26:09', 1);
INSERT INTO `bls_word` VALUES (78, '中', '与名词组合在一起充当句子的状语，限定其他句子成分的描述范围', '*** 中', 10, '', 3, 3, '2021-05-24 16:26:36', 1);
INSERT INTO `bls_word` VALUES (79, '根据', '在“排序”句型中，表示是根据它后面的词所表示的属性来将某个集合进行排序', '根据 ** 进行 ***', 10, '', 3, 3, '2021-05-24 16:26:58', 1);
INSERT INTO `bls_word` VALUES (80, '将', '和“把”类似', '将 ** 合并成为', 10, '', 3, 3, '2021-05-24 16:27:28', 1);
INSERT INTO `bls_word` VALUES (81, '进行', '根据 ** 进行 ***', '无特殊含义，在“排序”句型中，起到联系上下文的作用', 10, '', 3, 3, '2021-05-24 16:28:12', 1);
INSERT INTO `bls_word` VALUES (82, '求', '在“求值”句型中，充当该句型的标识', '求 *** 的 最大值', 10, '', 3, 3, '2021-05-24 16:28:38', 1);
INSERT INTO `bls_word` VALUES (83, '基于', '一般后面跟随属性名称，在“属性合并”句型中起到说明合并条件的作用', '基于 ** 进行', 10, '', 3, 3, '2021-05-24 16:29:00', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
