/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : stuinfosys

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 12/10/2020 10:13:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_game_level
-- ----------------------------
DROP TABLE IF EXISTS `sys_game_level`;
CREATE TABLE `sys_game_level`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `level_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '赛事等级',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_game_level
-- ----------------------------
INSERT INTO `sys_game_level` VALUES (1, '特等奖', NULL);
INSERT INTO `sys_game_level` VALUES (2, '一等奖', NULL);
INSERT INTO `sys_game_level` VALUES (3, '二等奖', NULL);
INSERT INTO `sys_game_level` VALUES (4, '三等奖', NULL);
INSERT INTO `sys_game_level` VALUES (5, '金奖', NULL);
INSERT INTO `sys_game_level` VALUES (6, '银奖', NULL);
INSERT INTO `sys_game_level` VALUES (7, '铜奖', NULL);

-- ----------------------------
-- Table structure for sys_obtain
-- ----------------------------
DROP TABLE IF EXISTS `sys_obtain`;
CREATE TABLE `sys_obtain`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `adviser` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指导老师',
  `card_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号',
  `grade` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年级',
  `level` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '等级',
  `major` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业',
  `obtain_time` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '获奖时间',
  `race_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '竞赛名称',
  `race_scope` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '竞赛范围',
  `student_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `student_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `team_situation` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组队情况',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_race_name
-- ----------------------------
DROP TABLE IF EXISTS `sys_race_name`;
CREATE TABLE `sys_race_name`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `race_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '赛事名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_race_name
-- ----------------------------
INSERT INTO `sys_race_name` VALUES (1, '中国“互联网+”大学生创新创业大赛', NULL);
INSERT INTO `sys_race_name` VALUES (2, '天津市大学生校园微视频大赛', NULL);

-- ----------------------------
-- Table structure for sys_race_scope
-- ----------------------------
DROP TABLE IF EXISTS `sys_race_scope`;
CREATE TABLE `sys_race_scope`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `race_scope` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '赛事范围',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_race_scope
-- ----------------------------
INSERT INTO `sys_race_scope` VALUES (1, '国家级', NULL);
INSERT INTO `sys_race_scope` VALUES (2, '天津市', NULL);
INSERT INTO `sys_race_scope` VALUES (3, '全国分赛区', NULL);

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `parent_id` int(0) NULL DEFAULT NULL COMMENT '资源父ID',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源名称',
  `perms` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识符',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型：0：目录，1：菜单，2：按钮',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES (1, 0, '系统管理', NULL, '0');
INSERT INTO `sys_resource` VALUES (2, 1, '用户管理', 'sys:users', '1');
INSERT INTO `sys_resource` VALUES (3, 1, '角色管理', 'sys:roles', '1');
INSERT INTO `sys_resource` VALUES (4, 2, '添加用户', 'sys:user:insert', '2');
INSERT INTO `sys_resource` VALUES (5, 2, '删除用户', 'sys:user:delete', '2');
INSERT INTO `sys_resource` VALUES (6, 2, '修改用户', 'sys:user:update', '2');
INSERT INTO `sys_resource` VALUES (7, 2, '查询用户', 'sys:user:list', '2');
INSERT INTO `sys_resource` VALUES (8, 3, '添加角色', 'sys:role:insert', '2');
INSERT INTO `sys_resource` VALUES (9, 3, '删除角色', 'sys:role:delete', '2');
INSERT INTO `sys_resource` VALUES (10, 3, '修改角色', 'sys:role:update', '2');
INSERT INTO `sys_resource` VALUES (11, 3, '查询角色', 'sys:role:list', '2');
INSERT INTO `sys_resource` VALUES (12, 3, '角色详情', 'sys:role:detail', '2');
INSERT INTO `sys_resource` VALUES (13, 2, '用户详情', 'sys:user:detail', '2');
INSERT INTO `sys_resource` VALUES (14, 2, '赛事等级管理', 'sys:gamelevels', '1');
INSERT INTO `sys_resource` VALUES (15, 3, '查询赛事等级', 'sys:gamelevel:list', '2');
INSERT INTO `sys_resource` VALUES (16, 3, '添加赛事等级', 'sys:gamelevel:insert', '2');
INSERT INTO `sys_resource` VALUES (17, 3, '删除赛事等级', 'sys:gamelevel:delete', '2');
INSERT INTO `sys_resource` VALUES (18, 3, '修改赛事等级', 'sys:gamelevel:update', '2');
INSERT INTO `sys_resource` VALUES (19, 2, '获奖管理', 'sys:obtains', '1');
INSERT INTO `sys_resource` VALUES (20, 3, '查询获奖', 'sys:obtain:list', '2');
INSERT INTO `sys_resource` VALUES (21, 3, '添加获奖', 'sys:obtain:insert', '2');
INSERT INTO `sys_resource` VALUES (22, 3, '修改获奖', 'sys:obtain:update', '2');
INSERT INTO `sys_resource` VALUES (23, 3, '删除获奖', 'sys:obtain:delete', '2');
INSERT INTO `sys_resource` VALUES (24, 2, '赛事名称管理', 'sys:racenames', '1');
INSERT INTO `sys_resource` VALUES (25, 3, '赛事名称添加', 'sys:racename:insert', '2');
INSERT INTO `sys_resource` VALUES (26, 3, '赛事名称删除', 'sys:racename:delete', '2');
INSERT INTO `sys_resource` VALUES (27, 3, '赛事名称查询', 'sys:racename:list', '2');
INSERT INTO `sys_resource` VALUES (28, 3, '赛事名称更新', 'sys:racename:update', '2');
INSERT INTO `sys_resource` VALUES (29, 2, '赛事范围管理', 'sys:racescopes', '1');
INSERT INTO `sys_resource` VALUES (30, 3, '赛事范围添加', 'sys:racescope:insert', '2');
INSERT INTO `sys_resource` VALUES (31, 3, '赛事范围查询', 'sys:racescope:list', '2');
INSERT INTO `sys_resource` VALUES (32, 3, '赛事范围删除', 'sys:racescope:delete', '2');
INSERT INTO `sys_resource` VALUES (33, 3, '赛事范围更新', 'sys:racescope:update', '2');
INSERT INTO `sys_resource` VALUES (34, 2, '学术管理', 'sys:scholarisms', '1');
INSERT INTO `sys_resource` VALUES (35, 3, '学术新增', 'sys:scholarism:insert', '2');
INSERT INTO `sys_resource` VALUES (36, 3, '学术删除', 'sys:scholarism:delete', '2');
INSERT INTO `sys_resource` VALUES (37, 3, '学术更新', 'sys:scholarism:update', '2');
INSERT INTO `sys_resource` VALUES (38, 3, '学术查询', 'sys:scholarism:list', '2');
INSERT INTO `sys_resource` VALUES (39, 3, '赛事等级详情', 'sys:gamelevel:detail', '2');
INSERT INTO `sys_resource` VALUES (40, 3, '获奖详情', 'sys:obtain:detail', '2');
INSERT INTO `sys_resource` VALUES (41, 3, '赛事名称详情', 'sys:racename:detail', '2');
INSERT INTO `sys_resource` VALUES (42, 3, '赛事范围详情', 'sys:racescope:detail', '2');
INSERT INTO `sys_resource` VALUES (43, 3, '学术详情', 'sys:scholarism:detail', '2');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  `grade` tinyint(0) NOT NULL COMMENT '角色等级',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (7, '超级管理员', 1, '超级管理员');

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` int(0) NOT NULL COMMENT '角色id',
  `resource_id` int(0) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO `sys_role_resource` VALUES (3, 7, 1);
INSERT INTO `sys_role_resource` VALUES (4, 7, 2);
INSERT INTO `sys_role_resource` VALUES (5, 7, 3);
INSERT INTO `sys_role_resource` VALUES (6, 7, 4);
INSERT INTO `sys_role_resource` VALUES (7, 7, 5);
INSERT INTO `sys_role_resource` VALUES (8, 7, 6);
INSERT INTO `sys_role_resource` VALUES (9, 7, 7);
INSERT INTO `sys_role_resource` VALUES (10, 7, 8);
INSERT INTO `sys_role_resource` VALUES (11, 7, 9);
INSERT INTO `sys_role_resource` VALUES (12, 7, 10);
INSERT INTO `sys_role_resource` VALUES (13, 7, 11);
INSERT INTO `sys_role_resource` VALUES (14, 7, 12);
INSERT INTO `sys_role_resource` VALUES (15, 7, 13);
INSERT INTO `sys_role_resource` VALUES (16, 7, 14);
INSERT INTO `sys_role_resource` VALUES (17, 7, 15);
INSERT INTO `sys_role_resource` VALUES (18, 7, 16);
INSERT INTO `sys_role_resource` VALUES (19, 7, 17);
INSERT INTO `sys_role_resource` VALUES (20, 7, 18);
INSERT INTO `sys_role_resource` VALUES (21, 7, 19);
INSERT INTO `sys_role_resource` VALUES (22, 7, 20);
INSERT INTO `sys_role_resource` VALUES (23, 7, 21);
INSERT INTO `sys_role_resource` VALUES (24, 7, 22);
INSERT INTO `sys_role_resource` VALUES (25, 7, 23);
INSERT INTO `sys_role_resource` VALUES (26, 7, 24);
INSERT INTO `sys_role_resource` VALUES (27, 7, 25);
INSERT INTO `sys_role_resource` VALUES (28, 7, 26);
INSERT INTO `sys_role_resource` VALUES (29, 7, 27);
INSERT INTO `sys_role_resource` VALUES (30, 7, 28);
INSERT INTO `sys_role_resource` VALUES (31, 7, 29);
INSERT INTO `sys_role_resource` VALUES (32, 7, 30);
INSERT INTO `sys_role_resource` VALUES (33, 7, 31);
INSERT INTO `sys_role_resource` VALUES (34, 7, 32);
INSERT INTO `sys_role_resource` VALUES (35, 7, 33);
INSERT INTO `sys_role_resource` VALUES (36, 7, 34);
INSERT INTO `sys_role_resource` VALUES (37, 7, 35);
INSERT INTO `sys_role_resource` VALUES (38, 7, 36);
INSERT INTO `sys_role_resource` VALUES (39, 7, 37);
INSERT INTO `sys_role_resource` VALUES (40, 7, 38);
INSERT INTO `sys_role_resource` VALUES (41, 7, 39);
INSERT INTO `sys_role_resource` VALUES (42, 7, 40);
INSERT INTO `sys_role_resource` VALUES (43, 7, 41);
INSERT INTO `sys_role_resource` VALUES (44, 7, 42);
INSERT INTO `sys_role_resource` VALUES (45, 7, 43);

-- ----------------------------
-- Table structure for sys_scholarism
-- ----------------------------
DROP TABLE IF EXISTS `sys_scholarism`;
CREATE TABLE `sys_scholarism`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `adviser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `applicant` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `application_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `corresponding_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `first_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paper_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paper_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `patent_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `patent_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `periodical` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `posted_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `serial_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_scholarism
-- ----------------------------
INSERT INTO `sys_scholarism` VALUES (1, NULL, '韦祖杰', '2019', '娃达', '韦祖杰', '大一', '电信', NULL, 'giaogiao', NULL, '智能giao哥', NULL, NULL, '专利', NULL, '17990425');
INSERT INTO `sys_scholarism` VALUES (2, NULL, '哇大无畏的', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `account` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盐',
  `forbidden` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否禁用 0：否；1：是',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (4, 'admin', 'admin', 'd3ce866c2a856303a182c9e595d498f5', '8e7386142591cfa96ef7c293b5dfe72c', '0', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(0) NOT NULL COMMENT '用户ID',
  `role_id` int(0) NOT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (4, 4, 7);

SET FOREIGN_KEY_CHECKS = 1;
