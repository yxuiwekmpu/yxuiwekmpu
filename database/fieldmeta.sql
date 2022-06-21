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

 Date: 17/08/2019 03:47:03
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
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fm_field_entity
-- ----------------------------
INSERT INTO `fm_field_entity` VALUES (1, '2019-08-16 15:35:02', '2019-08-16 17:33:37', NULL, 'id', 'Long', 'id', 0.00, 'bigint', 'ID', NULL, 20, 'no', 'no', 'no', 'yes', 'org.coderfun.common.BaseEntity', 'no', '');
INSERT INTO `fm_field_entity` VALUES (2, '2019-08-16 15:35:03', '2019-08-16 17:33:37', NULL, 'createTime', 'Date', 'create_time', 1.00, 'datetime', '创建时间', NULL, NULL, 'no', 'no', 'yes', 'no', 'org.coderfun.common.BaseEntity', 'no', '');
INSERT INTO `fm_field_entity` VALUES (3, '2019-08-16 17:33:38', '2019-08-16 20:43:39', NULL, 'modifyTime', 'Date', 'modify_time', 2.00, 'datetime', '修改时间', NULL, NULL, 'no', 'no', 'no', 'no', 'org.coderfun.common.BaseEntity', 'no', '');
INSERT INTO `fm_field_entity` VALUES (4, '2019-08-16 22:47:08', '2019-08-16 23:15:18', NULL, 'egVarchar', 'String', 'eg_varchara', 0.00, 'varchar', 'eg_前缀从数据库导入会用到', NULL, 255, 'no', 'no', 'no', 'no', 'codefun_option_field', 'no', 'string');
INSERT INTO `fm_field_entity` VALUES (5, '2019-08-16 22:47:08', '2019-08-16 22:47:08', NULL, 'egText', 'String', 'eg_text', 1.00, 'text', '', NULL, 0, 'no', 'no', 'no', 'no', 'codefun_option_field', 'no', '');
INSERT INTO `fm_field_entity` VALUES (6, '2019-08-16 22:47:08', '2019-08-16 23:15:18', NULL, 'egDecimal', 'BigDecimal', 'eg_decimal', 2.00, 'decimal', '', 4, 22, 'no', 'no', 'no', 'no', 'codefun_option_field', 'no', 'decimal');
INSERT INTO `fm_field_entity` VALUES (7, '2019-08-16 22:57:41', '2019-08-16 23:15:18', NULL, 'egInt', 'Integer', 'eg_int', 3.00, 'int', '', NULL, 11, 'no', 'no', 'no', 'no', 'codefun_option_field', 'no', 'digits');
INSERT INTO `fm_field_entity` VALUES (8, '2019-08-16 22:57:42', '2019-08-16 23:15:18', NULL, 'egBigint', 'Long', 'eg_bigint', 4.00, 'bigint', '', NULL, 20, 'no', 'no', 'no', 'no', 'codefun_option_field', 'no', 'digits');
INSERT INTO `fm_field_entity` VALUES (9, '2019-08-16 22:57:42', '2019-08-16 22:57:42', NULL, 'egDate', 'Date', 'eg_date', 5.00, 'date', '', NULL, NULL, 'no', 'no', 'no', 'no', 'codefun_option_field', 'no', '');
INSERT INTO `fm_field_entity` VALUES (10, '2019-08-16 22:57:42', '2019-08-16 22:57:42', NULL, 'egDatetime', 'Date', 'eg_datetime', 6.00, 'datetime', '', NULL, NULL, 'no', 'no', 'no', 'no', 'codefun_option_field', 'no', '');
INSERT INTO `fm_field_entity` VALUES (11, '2019-08-16 23:19:42', '2019-08-16 23:19:42', NULL, 'remark', 'String', 'remark', 3.00, 'varchar', '备注', NULL, 255, 'no', 'no', 'no', 'no', 'org.coderfun.common.BaseEntity', 'no', 'string');
INSERT INTO `fm_field_entity` VALUES (12, '2019-08-17 01:25:42', '2019-08-17 01:25:42', NULL, 'username', 'String', 'username', 0.00, 'varchar', '', NULL, 255, 'no', 'no', 'no', 'no', 'user', 'no', 'string');
INSERT INTO `fm_field_entity` VALUES (13, '2019-08-17 01:25:42', '2019-08-17 03:43:40', NULL, 'email', 'String', 'email', 1.00, 'text', '', NULL, 0, 'no', 'no', 'no', 'no', 'user', 'no', 'email');
INSERT INTO `fm_field_entity` VALUES (14, '2019-08-17 01:25:42', '2019-08-17 01:25:42', NULL, 'score', 'Integer', 'score', 2.00, 'int', '', NULL, 11, 'no', 'no', 'no', 'no', 'user', 'no', 'digits');

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
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fm_field_page
-- ----------------------------
INSERT INTO `fm_field_page` VALUES (1, 'yes', 'yes', 'yes', '', NULL, '', 'no', 'EQ', 'no', 1, 'complexCol', '', 'org.coderfun.common.BaseEntity', 'input_hidden');
INSERT INTO `fm_field_page` VALUES (2, 'no', 'yes', 'yes', '', NULL, '', 'no', 'BETWEEN', 'no', 2, 'EasyUiDateTime', '', 'org.coderfun.common.BaseEntity', '');
INSERT INTO `fm_field_page` VALUES (3, 'no', 'no', 'no', '', NULL, '', 'no', 'BETWEEN', 'no', 3, 'EasyUiDateTime', '', 'org.coderfun.common.BaseEntity', '');
INSERT INTO `fm_field_page` VALUES (4, 'yes', 'yes', 'no', '', NULL, '', 'no', 'CONTAIN', 'no', 4, 'complexCol', '', 'codefun_option_field', 'input_text');
INSERT INTO `fm_field_page` VALUES (5, 'yes', 'yes', 'no', '', NULL, '', 'no', 'CONTAIN', 'no', 5, 'complexCol', '', 'codefun_option_field', 'input_textarea');
INSERT INTO `fm_field_page` VALUES (6, 'yes', 'yes', 'no', '', NULL, '', 'no', '', 'no', 6, 'complexCol', '', 'codefun_option_field', 'input_text');
INSERT INTO `fm_field_page` VALUES (7, 'yes', 'yes', 'no', '', NULL, '', 'no', '', 'no', 7, 'complexCol', '', 'codefun_option_field', 'input_text');
INSERT INTO `fm_field_page` VALUES (8, 'yes', 'yes', 'no', '', NULL, '', 'no', '', 'no', 8, 'complexCol', '', 'codefun_option_field', 'input_text');
INSERT INTO `fm_field_page` VALUES (9, 'yes', 'yes', 'no', '', NULL, '', 'no', 'BETWEEN', 'no', 9, 'EasyUiDate', '', 'codefun_option_field', '');
INSERT INTO `fm_field_page` VALUES (10, 'yes', 'yes', 'no', '', NULL, '', 'no', 'BETWEEN', 'no', 10, 'EasyUiDateTime', '', 'codefun_option_field', '');
INSERT INTO `fm_field_page` VALUES (11, 'yes', 'yes', 'no', '', NULL, '', 'no', 'CONTAIN', 'no', 11, 'complexCol', '', 'org.coderfun.common.BaseEntity', 'input_textarea');
INSERT INTO `fm_field_page` VALUES (12, 'yes', 'yes', 'no', '', NULL, '', 'no', 'CONTAIN', 'no', 12, 'complexCol', '', 'user', 'input_text');
INSERT INTO `fm_field_page` VALUES (13, 'yes', 'yes', 'no', '', NULL, '', 'no', 'CONTAIN', 'no', 13, 'complexCol', '', 'user', 'input_textarea');
INSERT INTO `fm_field_page` VALUES (14, 'yes', 'yes', 'no', '', NULL, '', 'no', '', 'no', 14, 'complexCol', '', 'user', 'input_text');

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
  `copy_right` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版权信息',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注信息',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKnu8xcw16clet0smpu4lsd1tk3`(`project_id`) USING BTREE,
  CONSTRAINT `FKnu8xcw16clet0smpu4lsd1tk3` FOREIGN KEY (`project_id`) REFERENCES `fm_project` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fm_module
-- ----------------------------
INSERT INTO `fm_module` VALUES (1, 'test', 1, '测试', 'org.coderfun.test', NULL, NULL, NULL, '2019-08-16 23:28:47', '2019-08-16 23:47:31');

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
  `db_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `db_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `db_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fm_project
-- ----------------------------
INSERT INTO `fm_project` VALUES (1, 'test', NULL, NULL, 'yes', 'jdbc:MySQL://47.98.129.217:3306/fieldmeta', 'root', 'klguang@mysql', NULL, '2019-08-16 23:27:52', '2019-08-16 23:27:52');

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代码生成表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fm_tablemeta
-- ----------------------------
INSERT INTO `fm_tablemeta` VALUES (1, 'test', 'user', 'User', 'user', NULL, '用户', NULL, NULL, NULL, '2019-08-16 23:49:50', '2019-08-16 23:49:50', NULL, 'yes', 'yes', 'BaseEntity');

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fm_template_file
-- ----------------------------
INSERT INTO `fm_template_file` VALUES (1, '2019-08-16 23:24:56', '2019-08-17 03:01:15', NULL, '/src/main/java/', '#{enp}.java', 'package_path', 'Entity.java.ftl', '2ad22be1-225d-4993-be42-42f34768db8e.ftl');

-- ----------------------------
-- Table structure for fm_type_mapping
-- ----------------------------
DROP TABLE IF EXISTS `fm_type_mapping`;
CREATE TABLE `fm_type_mapping`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sql_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'sql类型',
  `java_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'java类型',
  `full_java_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'java全类型',
  `options` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '是否需要Join Column',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_sql_type`(`sql_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fm_type_mapping
-- ----------------------------
INSERT INTO `fm_type_mapping` VALUES (1, 'varchar', 'String', 'java.lang.String', 'no', NULL, '2018-05-18 23:46:18', '2018-05-22 13:40:10');
INSERT INTO `fm_type_mapping` VALUES (2, 'text', 'String', 'java.lang.String', 'no', NULL, '2018-05-22 13:41:15', '2018-05-22 13:41:15');
INSERT INTO `fm_type_mapping` VALUES (3, 'decimal', 'BigDecimal', 'java.math.BigDecimal', 'no', NULL, '2018-05-22 13:42:12', '2018-05-22 13:42:12');
INSERT INTO `fm_type_mapping` VALUES (4, 'int', 'Integer', 'java.lang.Integer', 'no', NULL, '2018-05-22 13:56:32', '2018-05-22 13:56:32');
INSERT INTO `fm_type_mapping` VALUES (5, 'bigint', 'Long', 'java.lang.long', 'no', NULL, '2018-05-22 13:57:09', '2018-05-22 13:57:09');
INSERT INTO `fm_type_mapping` VALUES (6, 'datetime', 'Date', 'java.util.Date', 'no', NULL, '2018-05-22 13:58:23', '2018-05-22 13:58:23');
INSERT INTO `fm_type_mapping` VALUES (7, 'date', 'Date', 'java.util.Date', 'no', NULL, '2018-05-22 13:58:43', '2018-05-22 13:58:43');

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fm_validation
-- ----------------------------
INSERT INTO `fm_validation` VALUES (1, '邮箱', 'email', NULL, 'email', '@Email', 'asdf', '2018-05-18 22:57:57', '2019-08-16 00:37:06', NULL);
INSERT INTO `fm_validation` VALUES (2, '整数', 'digits', NULL, 'digits', NULL, NULL, '2019-08-16 23:05:06', '2019-08-16 23:05:06', NULL);
INSERT INTO `fm_validation` VALUES (3, '小数', 'decimal', NULL, 'intOrFloat', NULL, NULL, '2019-08-16 23:06:07', '2019-08-16 23:06:07', NULL);
INSERT INTO `fm_validation` VALUES (4, '字符串', 'string', NULL, 'maxLength[255]', '@Length(max=255)', NULL, '2019-08-16 23:10:39', '2019-08-16 23:10:39', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `sys_codeclass` VALUES (26, 'field_formatter', '字段显示格式', NULL, 'fieldmeta', 'yes', '2019-08-16 16:33:00', '2019-08-16 16:33:31', NULL, NULL);
INSERT INTO `sys_codeclass` VALUES (27, 'field_code_class', '字典', NULL, 'sys', 'yes', '2019-08-16 17:10:23', '2019-08-16 17:10:23', NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_codeitem
-- ----------------------------
INSERT INTO `sys_codeitem` VALUES (1, 'yes_or_no', 'yes', '是', NULL, NULL, NULL, '2018-05-14 13:44:32', NULL, NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (2, 'yes_or_no', 'no', '否', NULL, NULL, NULL, '2018-05-14 13:44:32', '2018-05-18 21:57:11', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (3, 'module_code', 'sys', '系统', NULL, NULL, NULL, '2018-05-14 14:22:03', NULL, NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (7, 'module_code', 'fieldmeta', '字段元', NULL, NULL, NULL, NULL, '2018-05-14 21:19:18', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (12, 'sql_dialect_code', 'mysql', 'mysql', NULL, NULL, NULL, '2018-05-14 21:20:51', NULL, NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (13, 'entity_super_class', 'BaseEntity', 'BaseEntity', 'org.coderfun.common.BaseEntity', NULL, NULL, '2018-05-21 12:17:51', '2019-08-17 03:20:36', NULL, 10.00);
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
INSERT INTO `sys_codeitem` VALUES (31, 'entity_super_class', 'VersionEntity', 'VersionEntity', 'org.coderfun.common.VersionEntity', NULL, NULL, '2018-05-30 02:03:39', '2019-08-17 03:20:55', NULL, 8.00);
INSERT INTO `sys_codeitem` VALUES (33, 'entity_super_class', 'OrderEntity', 'OrderEntity', 'org.coderfun.common.OrderEntity', NULL, NULL, '2018-05-30 16:01:55', '2019-08-17 03:20:47', NULL, 9.00);
INSERT INTO `sys_codeitem` VALUES (40, 'gen_filekey_type', 'package_path', '模块包路径', NULL, NULL, NULL, '2019-08-13 20:05:59', '2019-08-13 20:07:41', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (41, 'gen_filekey_type', 'module_name', '模块名', NULL, NULL, NULL, '2019-08-13 20:06:26', '2019-08-15 00:26:02', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (42, 'entity_super_class', 'Object', '无', 'java.lang.Object', NULL, NULL, '2019-08-15 22:32:20', '2019-08-15 22:32:20', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (43, 'form_field_type', 'input_code', '数据字典', NULL, NULL, NULL, '2019-08-16 15:37:29', '2019-08-16 15:37:29', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (44, 'field_formatter', 'complexCol', '通用', NULL, NULL, NULL, '2019-08-16 16:36:12', '2019-08-16 16:36:12', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (45, 'field_formatter', 'codeCol', '数据字典', NULL, NULL, NULL, '2019-08-16 16:37:57', '2019-08-16 16:37:57', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (46, 'field_formatter', 'EasyUiDateTime', '时间', NULL, NULL, NULL, '2019-08-16 16:38:24', '2019-08-16 16:38:24', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (47, 'field_code_class', 'user_gender', '性别', NULL, NULL, NULL, '2019-08-16 17:16:53', '2019-08-16 17:17:26', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (48, 'field_code_class', 'user_state', '用户状态', NULL, NULL, NULL, '2019-08-16 17:17:19', '2019-08-16 17:17:19', NULL, NULL);
INSERT INTO `sys_codeitem` VALUES (49, 'field_formatter', 'EasyUiDate', '日期', NULL, NULL, NULL, '2019-08-16 23:15:04', '2019-08-16 23:15:04', NULL, NULL);

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
