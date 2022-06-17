/*
 Navicat Premium Data Transfer

 Source Server         : dev-mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : 47.98.129.217:3306
 Source Schema         : fieldmeta

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 16/08/2019 01:17:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fm_field_entity
-- ----------------------------
DROP TABLE IF EXISTS `fm_field_entity`;
CREATE TABLE `fm_field_entity`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `attr_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attr_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `column_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `column_sort` decimal(19, 2) NULL DEFAULT NULL,
  `column_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comments` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `decimal_places` bigint(20) NULL DEFAULT NULL,
  `length` bigint(20) NULL DEFAULT NULL,
  `not_insert_restrict` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `not_null_restrict` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `not_update_restrict` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pk_restrict` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `table_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unique_restrict` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `field_valid_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fm_field_page
-- ----------------------------
DROP TABLE IF EXISTS `fm_field_page`;
CREATE TABLE `fm_field_page`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `can_edit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `can_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `can_query` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grid_row_col` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `need_new_line` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `query_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `required` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `entity_field_id` bigint(20) NULL DEFAULT NULL,
  `field_formatter` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `field_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `table_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `form_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKsemyad4g5cyqqbx5lclqccg63`(`entity_field_id`) USING BTREE,
  CONSTRAINT `FKsemyad4g5cyqqbx5lclqccg63` FOREIGN KEY (`entity_field_id`) REFERENCES `fm_field_entity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fm_module
-- ----------------------------
DROP TABLE IF EXISTS `fm_module`;
CREATE TABLE `fm_module`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块名称',
  `project_id` bigint(20) NULL DEFAULT NULL COMMENT '所属项目',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块描述',
  `package_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块包名',
  `gen_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成路径',
  `copy_right` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版权信息',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注信息',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKnu8xcw16clet0smpu4lsd1tk3`(`project_id`) USING BTREE,
  CONSTRAINT `FKnu8xcw16clet0smpu4lsd1tk3` FOREIGN KEY (`project_id`) REFERENCES `fm_project` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fm_project
-- ----------------------------
DROP TABLE IF EXISTS `fm_project`;
CREATE TABLE `fm_project`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `java_template_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'java模板类型',
  `page_template_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '页面模板类型，codeclass',
  `is_default_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否默认，codeclass\r\n',
  `sql_dialect_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库类型，codeclass',
  `db_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `db_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `db_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fm_tablemeta
-- ----------------------------
DROP TABLE IF EXISTS `fm_tablemeta`;
CREATE TABLE `fm_tablemeta`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `table_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `entity_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实体类名称',
  `business_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务名，建议仅用在权限',
  `function_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `simple_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成功能名（简写）',
  `parent_table_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联父表的表名',
  `parent_table_fk_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本表关联父表的外键名',
  `options` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '其它生成选项',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `can_delete` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除功能，code',
  `can_edit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编辑功能，code',
  `entity_super_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实体基类',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_gen_table_ptn`(`parent_table_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代码生成表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fm_template_file
-- ----------------------------
DROP TABLE IF EXISTS `fm_template_file`;
CREATE TABLE `fm_template_file`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `gen_filekey_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gen_filekey_pattern` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gen_filekey_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uuid_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fm_type_mapping
-- ----------------------------
DROP TABLE IF EXISTS `fm_type_mapping`;
CREATE TABLE `fm_type_mapping`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sql_dialect_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方言',
  `sql_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'sql类型',
  `java_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'java类型',
  `full_java_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'java全类型',
  `need_join_column_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否需要Join Column',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_sql_type`(`sql_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fm_type_mapping
-- ----------------------------
INSERT INTO `fm_type_mapping` VALUES (1, 'mysql', 'varchar', 'String', 'java.lang.String', 'no', NULL, '2018-05-18 23:46:18', '2018-05-22 13:40:10');
INSERT INTO `fm_type_mapping` VALUES (2, 'mysql', 'text', 'String', 'java.lang.String', 'no', NULL, '2018-05-22 13:41:15', '2018-05-22 13:41:15');
INSERT INTO `fm_type_mapping` VALUES (3, 'mysql', 'decimal', 'BigDecimal', 'java.math.BigDecimal', 'no', NULL, '2018-05-22 13:42:12', '2018-05-22 13:42:12');
INSERT INTO `fm_type_mapping` VALUES (4, 'mysql', 'int', 'Integer', 'java.lang.Integer', 'no', NULL, '2018-05-22 13:56:32', '2018-05-22 13:56:32');
INSERT INTO `fm_type_mapping` VALUES (5, 'mysql', 'bigint', 'Long', 'java.lang.long', 'no', NULL, '2018-05-22 13:57:09', '2018-05-22 13:57:09');
INSERT INTO `fm_type_mapping` VALUES (6, 'mysql', 'datetime', 'Date', 'java.util.Date', 'no', NULL, '2018-05-22 13:58:23', '2018-05-22 13:58:23');
INSERT INTO `fm_type_mapping` VALUES (7, 'mysql', 'date', 'Date', 'java.util.Date', 'no', NULL, '2018-05-22 13:58:43', '2018-05-22 13:58:43');

-- ----------------------------
-- Table structure for fm_validation
-- ----------------------------
DROP TABLE IF EXISTS `fm_validation`;
CREATE TABLE `fm_validation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '代码',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `js_valid` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'js校验正则',
  `java_valid` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'java校验正则',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '校验消息',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_code`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fm_validation
-- ----------------------------
INSERT INTO `fm_validation` VALUES (1, '邮箱', 'email', NULL, 'email', '@Email', 'asdf', '2018-05-18 22:57:57', '2019-08-16 00:37:06', NULL);

-- ----------------------------
-- Table structure for sys_codeclass
-- ----------------------------
DROP TABLE IF EXISTS `sys_codeclass`;
CREATE TABLE `sys_codeclass`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '代码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值',
  `module_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属模块',
  `is_sys` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否系统内置，0否，1是',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `order_num` double(11, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code_class_unique`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_codeclass
-- ----------------------------
INSERT INTO `sys_codeclass` VALUES (15, 'module_code', '所属模块', NULL, 'sys', 'yes', '2018-06-13 14:03:25', '2019-08-15 00:17:13', NULL, 3.00);
INSERT INTO `sys_codeclass` VALUES (16, 'yes_or_no', '是否', NULL, 'sys', 'yes', '2018-06-13 14:03:48', '2019-08-15 00:17:19', NULL, 2.00);
INSERT INTO `sys_codeclass` VALUES (17, 'sql_dialect_code', '数据库方言', NULL, 'fieldmeta', 'yes', '2018-06-13 14:05:00', '2019-08-15 00:29:52', NULL, NULL);
INSERT INTO `sys_codeclass` VALUES (18, 'entity_super_class', '实体基类', NULL, 'fieldmeta', 'no', '2018-06-13 14:05:53', '2018-06-13 14:06:01', NULL, NULL);
INSERT INTO `sys_codeclass` VALUES (19, 'form_field_type', '表单类型', NULL, 'fieldmeta', 'no', '2018-06-13 14:06:31', '2018-06-13 14:06:31', NULL, NULL);
INSERT INTO `sys_codeclass` VALUES (20, 'grid_row_col', '表单栅格', NULL, 'fieldmeta', 'no', '2018-06-13 14:07:00', '2018-06-13 14:07:00', NULL, NULL);
INSERT INTO `sys_codeclass` VALUES (22, 'java_type', 'javaType', NULL, 'fieldmeta', 'no', '2018-06-13 14:08:43', '2019-08-15 00:38:27', '建议只新增', NULL);
INSERT INTO `sys_codeclass` VALUES (24, 'query_type', '查询方式', NULL, 'fieldmeta', 'no', '2018-06-13 14:09:34', '2018-06-13 14:10:01', NULL, NULL);
INSERT INTO `sys_codeclass` VALUES (25, 'gen_filekey_type', '生成路径方式', NULL, 'fieldmeta', 'yes', '2019-08-13 20:04:55', '2019-08-15 00:16:53', '不可修改', 1.00);

-- ----------------------------
-- Table structure for sys_codeitem
-- ----------------------------
DROP TABLE IF EXISTS `sys_codeitem`;
CREATE TABLE `sys_codeitem`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `class_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属分类',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '代码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值',
  `extension` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '扩展，json',
  `pinyin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '汉语拼音',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `order_num` double(11, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_codeitem
-- ----------------------------
INSERT INTO `sys_codeitem` VALUES (1, 'yes_or_no', 'yes', '是', NULL, NULL, NULL, '2018-05-14 13:44:32', NULL, NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (2, 'yes_or_no', 'no', '否', NULL, NULL, NULL, '2018-05-14 13:44:32', '2018-05-18 21:57:11', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (3, 'module_code', 'sys', '系统', NULL, NULL, NULL, '2018-05-14 14:22:03', NULL, NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (7, 'module_code', 'fieldmeta', '字段元', NULL, NULL, NULL, NULL, '2018-05-14 21:19:18', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (12, 'sql_dialect_code', 'mysql', 'mysql', NULL, NULL, NULL, '2018-05-14 21:20:51', NULL, NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (13, 'entity_super_class', 'base_entity', 'BaseEntity', 'org.coderfun.common.BaseEntity', NULL, NULL, '2018-05-21 12:17:51', '2018-05-31 00:43:05', NULL, 10.00);
INSERT INTO `sys_codeitem` VALUES (14, 'java_type', 'Long', 'Long', 'java.lang.Long', NULL, NULL, '2018-05-21 12:45:00', '2019-08-15 00:37:54', '不可修改', 10.00);
INSERT INTO `sys_codeitem` VALUES (15, 'java_type', 'String', 'String', 'java.lang.String', NULL, NULL, '2018-05-21 12:45:52', '2019-08-15 00:38:02', '不可修改', 8.00);
INSERT INTO `sys_codeitem` VALUES (16, 'java_type', 'BigDecimal', 'BigDecimal', 'java.math.BigDecimal', NULL, NULL, '2018-05-21 12:46:49', '2018-05-21 12:46:49', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (17, 'java_type', 'Integer', 'Integer', 'java.lang.Integer', NULL, NULL, '2018-05-21 12:47:22', '2019-08-15 00:37:59', '不可修改', 9.00);
INSERT INTO `sys_codeitem` VALUES (18, 'java_type', 'Date', 'Date', 'java.util.Date', NULL, NULL, '2018-05-21 12:48:43', '2018-05-21 12:48:43', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (20, 'query_type', 'EQ', '=', NULL, NULL, NULL, '2018-05-21 13:44:38', '2018-05-21 13:48:38', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (21, 'query_type', 'CONTAIN', 'contain', NULL, NULL, NULL, '2018-05-21 13:46:58', '2018-05-21 13:51:16', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (22, 'query_type', 'NE', '!=', NULL, NULL, NULL, '2018-05-21 13:50:13', '2018-05-21 13:50:13', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (23, 'query_type', 'BETWEEN', 'between', NULL, NULL, NULL, '2018-05-21 13:50:58', '2018-05-21 13:50:58', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (24, 'grid_row_col', '6/4/8', '6/4/8', NULL, NULL, NULL, '2018-05-25 17:36:32', '2018-05-25 17:36:32', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (25, 'grid_row_col', '12/2/10', '12/2/10', NULL, NULL, NULL, '2018-05-25 17:37:27', '2018-05-25 17:37:27', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (26, 'grid_row_col', '12/2/5', '12/2/5', NULL, NULL, NULL, '2018-05-25 17:37:58', '2018-05-25 17:37:58', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (27, 'grid_row_col', '12/2/8', '12/2/8', NULL, NULL, NULL, '2018-05-25 17:38:09', '2018-05-25 17:38:09', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (28, 'form_field_type', 'input_hidden', '表单隐藏域', NULL, NULL, NULL, '2018-05-29 23:31:18', '2018-05-29 23:31:18', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (29, 'form_field_type', 'input_text', '单行文本框', NULL, NULL, NULL, '2018-05-29 23:31:37', '2018-05-29 23:33:20', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (30, 'form_field_type', 'input_textarea', '多行文本框', NULL, NULL, NULL, '2018-05-29 23:32:37', '2018-05-29 23:32:37', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (31, 'entity_super_class', 'version_entity', 'VersionEntity', 'org.coderfun.common.VersionEntity', NULL, NULL, '2018-05-30 02:03:39', '2018-05-31 00:43:27', NULL, 8.00);
INSERT INTO `sys_codeitem` VALUES (33, 'entity_super_class', 'order_entity', 'OrderEntity', 'org.coderfun.common.OrderEntity', NULL, NULL, '2018-05-30 16:01:55', '2018-05-31 00:43:19', NULL, 9.00);
INSERT INTO `sys_codeitem` VALUES (40, 'gen_filekey_type', 'package_path', '模块包路径', NULL, NULL, NULL, '2019-08-13 20:05:59', '2019-08-13 20:07:41', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (41, 'gen_filekey_type', 'module_name', '模块名', NULL, NULL, NULL, '2019-08-13 20:06:26', '2019-08-15 00:26:02', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (42, 'entity_super_class', 'Object', '无', 'java.lang.Object', NULL, NULL, '2019-08-15 22:32:20', '2019-08-15 22:32:20', NULL, NULL);

-- ----------------------------
-- Table structure for sys_menu_tree
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_tree`;
CREATE TABLE `sys_menu_tree`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `parent_node_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `node_level` int(11) NULL DEFAULT NULL,
  `node_degree` int(11) NULL DEFAULT NULL,
  `node_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `order_num` double NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `version` bigint(20) NULL DEFAULT NULL,
  `iconCls` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `perm_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu_tree
-- ----------------------------
INSERT INTO `sys_menu_tree` VALUES (1, NULL, ',', 1, 2, '14:41:42', '2018-06-09 14:41:43', '2018-06-09 14:42:36', NULL, 100, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_tree` VALUES (2, 3, ',1,3,', 3, 1, '14:41:43', '2018-06-09 14:41:44', '2018-06-09 15:22:41', NULL, 100, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_tree` VALUES (3, 1, ',1,', 2, 3, '14:42:33', '2018-06-09 14:42:35', '2018-06-09 15:22:41', NULL, 100, NULL, 5, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_tree` VALUES (4, 1, ',1,', 2, 0, '14:42:36', '2018-06-09 14:42:36', '2018-06-09 14:42:36', NULL, 200, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_tree` VALUES (5, 2, ',2,', 2, 0, '14:43:12', '2018-06-09 14:43:13', '2018-06-09 15:15:44', NULL, 100, NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_tree` VALUES (6, 3, ',1,3,', 3, 0, '14:43:13', '2018-06-09 14:43:14', '2018-06-11 11:26:53', NULL, 200, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_tree` VALUES (7, 3, ',1,3,', 3, 0, '14:43:14', '2018-06-09 14:43:15', '2018-06-09 14:43:15', NULL, 300, NULL, 0, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
