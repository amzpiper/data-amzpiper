/*
 Navicat Premium Data Transfer

 Source Server         : 301-test-user
 Source Server Type    : PostgreSQL
 Source Server Version : 90204
 Source Host           : 124.70.25.215:3306
 Source Catalog        : adtec
 Source Schema         : workordersystem

 Target Server Type    : PostgreSQL
 Target Server Version : 90204
 File Encoding         : 65001

 Date: 27/10/2021 09:46:48
*/


-- ----------------------------
-- Sequence structure for schedule_job_job_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."schedule_job_job_id_seq";
CREATE SEQUENCE "workordersystem"."schedule_job_job_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for schedule_job_log_log_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."schedule_job_log_log_id_seq";
CREATE SEQUENCE "workordersystem"."schedule_job_log_log_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_config_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_config_id_seq";
CREATE SEQUENCE "workordersystem"."sys_config_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_log_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_log_id_seq";
CREATE SEQUENCE "workordersystem"."sys_log_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_menu_menu_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_menu_menu_id_seq";
CREATE SEQUENCE "workordersystem"."sys_menu_menu_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_oss_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_oss_id_seq";
CREATE SEQUENCE "workordersystem"."sys_oss_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_role_menu_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_role_menu_id_seq";
CREATE SEQUENCE "workordersystem"."sys_role_menu_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_role_role_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_role_role_id_seq";
CREATE SEQUENCE "workordersystem"."sys_role_role_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_user_role_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_user_role_id_seq";
CREATE SEQUENCE "workordersystem"."sys_user_role_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_user_token_user_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_user_token_user_id_seq";
CREATE SEQUENCE "workordersystem"."sys_user_token_user_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_user_user_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_user_user_id_seq";
CREATE SEQUENCE "workordersystem"."sys_user_user_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tb_user_user_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."tb_user_user_id_seq";
CREATE SEQUENCE "workordersystem"."tb_user_user_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."orders";
CREATE TABLE "workordersystem"."orders" (
  "order_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "order_name" varchar(255) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0),
  "update_time" timestamp(0),
  "deflag" varchar(255) COLLATE "pg_catalog"."default",
  "approval" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO "workordersystem"."orders" VALUES ('2', '测试工单2', '测试工单2', '2021-10-25 11:38:51', '2021-10-25 11:38:51', '0', '0');
INSERT INTO "workordersystem"."orders" VALUES ('3', '测试工单3', '测试工单3', '2021-10-25 12:02:27', '2021-10-25 12:02:27', '0', '0');
INSERT INTO "workordersystem"."orders" VALUES ('04b2870bce7cd5e9a5fcc2b526579bb3', '测试工单new', '测试工单new', '2021-10-26 16:56:42', '2021-10-26 16:56:42', '0', '0');
INSERT INTO "workordersystem"."orders" VALUES ('1', '修改后的测试工单1', '修改后的测试工单2', '2021-10-26 17:01:58', '2021-10-26 17:01:58', '0', '1');
INSERT INTO "workordersystem"."orders" VALUES ('4', '测试工单', '测试工单', '2021-10-25 13:13:30', '2021-10-25 13:13:30', '1', '1');

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."qrtz_blob_triggers";
CREATE TABLE "workordersystem"."qrtz_blob_triggers" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "blob_data" bytea
)
;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."qrtz_calendars";
CREATE TABLE "workordersystem"."qrtz_calendars" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "calendar_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "calendar" bytea NOT NULL
)
;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."qrtz_cron_triggers";
CREATE TABLE "workordersystem"."qrtz_cron_triggers" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "cron_expression" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "time_zone_id" varchar(80) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."qrtz_fired_triggers";
CREATE TABLE "workordersystem"."qrtz_fired_triggers" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "entry_id" varchar(95) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "instance_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "fired_time" int8 NOT NULL,
  "sched_time" int8 NOT NULL,
  "priority" int4 NOT NULL,
  "state" varchar(16) COLLATE "pg_catalog"."default" NOT NULL,
  "job_name" varchar(200) COLLATE "pg_catalog"."default",
  "job_group" varchar(200) COLLATE "pg_catalog"."default",
  "is_nonconcurrent" bool,
  "requests_recovery" bool
)
;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."qrtz_job_details";
CREATE TABLE "workordersystem"."qrtz_job_details" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "job_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "job_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "description" varchar(250) COLLATE "pg_catalog"."default",
  "job_class_name" varchar(250) COLLATE "pg_catalog"."default" NOT NULL,
  "is_durable" bool NOT NULL,
  "is_nonconcurrent" bool NOT NULL,
  "is_update_data" bool NOT NULL,
  "requests_recovery" bool NOT NULL,
  "job_data" bytea
)
;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."qrtz_locks";
CREATE TABLE "workordersystem"."qrtz_locks" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "lock_name" varchar(40) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."qrtz_paused_trigger_grps";
CREATE TABLE "workordersystem"."qrtz_paused_trigger_grps" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."qrtz_scheduler_state";
CREATE TABLE "workordersystem"."qrtz_scheduler_state" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "instance_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "last_checkin_time" int8 NOT NULL,
  "checkin_interval" int8 NOT NULL
)
;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."qrtz_simple_triggers";
CREATE TABLE "workordersystem"."qrtz_simple_triggers" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "repeat_count" int8 NOT NULL,
  "repeat_interval" int8 NOT NULL,
  "times_triggered" int8 NOT NULL
)
;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."qrtz_simprop_triggers";
CREATE TABLE "workordersystem"."qrtz_simprop_triggers" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "str_prop_1" varchar(512) COLLATE "pg_catalog"."default",
  "str_prop_2" varchar(512) COLLATE "pg_catalog"."default",
  "str_prop_3" varchar(512) COLLATE "pg_catalog"."default",
  "int_prop_1" int4,
  "int_prop_2" int4,
  "long_prop_1" int8,
  "long_prop_2" int8,
  "dec_prop_1" numeric(13,4),
  "dec_prop_2" numeric(13,4),
  "bool_prop_1" bool,
  "bool_prop_2" bool
)
;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."qrtz_triggers";
CREATE TABLE "workordersystem"."qrtz_triggers" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "job_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "job_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "description" varchar(250) COLLATE "pg_catalog"."default",
  "next_fire_time" int8,
  "prev_fire_time" int8,
  "priority" int4,
  "trigger_state" varchar(16) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_type" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "start_time" int8 NOT NULL,
  "end_time" int8,
  "calendar_name" varchar(200) COLLATE "pg_catalog"."default",
  "misfire_instr" int2,
  "job_data" bytea
)
;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."schedule_job";
CREATE TABLE "workordersystem"."schedule_job" (
  "job_id" int8 NOT NULL DEFAULT nextval('"workordersystem".schedule_job_job_id_seq'::regclass),
  "bean_name" varchar(200) COLLATE "pg_catalog"."default",
  "params" varchar(2000) COLLATE "pg_catalog"."default",
  "cron_expression" varchar(100) COLLATE "pg_catalog"."default",
  "status" int4,
  "remark" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6)
)
;

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO "workordersystem"."schedule_job" VALUES (1, 'testTask', 'renren', '0 0/30 * * * ?', 0, '参数测试', '2016-12-01 23:16:46');

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."schedule_job_log";
CREATE TABLE "workordersystem"."schedule_job_log" (
  "log_id" int8 NOT NULL DEFAULT nextval('"workordersystem".schedule_job_log_log_id_seq'::regclass),
  "job_id" int8 NOT NULL,
  "bean_name" varchar(200) COLLATE "pg_catalog"."default",
  "params" varchar(2000) COLLATE "pg_catalog"."default",
  "status" int4 NOT NULL,
  "error" varchar(2000) COLLATE "pg_catalog"."default",
  "times" int4 NOT NULL,
  "create_time" timestamp(6)
)
;

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO "workordersystem"."schedule_job_log" VALUES (1, 1, 'testTask', 'renren', 0, NULL, 0, '2021-10-26 17:00:00.327');
INSERT INTO "workordersystem"."schedule_job_log" VALUES (2, 1, 'testTask', 'renren', 0, NULL, 0, '2021-10-26 17:30:00.154');

-- ----------------------------
-- Table structure for sys_captcha
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."sys_captcha";
CREATE TABLE "workordersystem"."sys_captcha" (
  "uuid" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "code" varchar(6) COLLATE "pg_catalog"."default" NOT NULL,
  "expire_time" timestamp(6)
)
;

-- ----------------------------
-- Records of sys_captcha
-- ----------------------------

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."sys_config";
CREATE TABLE "workordersystem"."sys_config" (
  "id" int8 NOT NULL DEFAULT nextval('"workordersystem".sys_config_id_seq'::regclass),
  "param_key" varchar(50) COLLATE "pg_catalog"."default",
  "param_value" varchar(2000) COLLATE "pg_catalog"."default",
  "status" int4 DEFAULT 1,
  "remark" varchar(500) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO "workordersystem"."sys_config" VALUES (1, 'CLOUD_STORAGE_CONFIG_KEY', '{"aliyunAccessKeyId":"","aliyunAccessKeySecret":"","aliyunBucketName":"","aliyunDomain":"","aliyunEndPoint":"","aliyunPrefix":"","qcloudBucketName":"","qcloudDomain":"","qcloudPrefix":"","qcloudSecretId":"","qcloudSecretKey":"","qiniuAccessKey":"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ","qiniuBucketName":"ios-app","qiniuDomain":"http://7xlij2.com1.z0.glb.clouddn.com","qiniuPrefix":"upload","qiniuSecretKey":"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV","type":1}', 0, '云存储配置信息');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."sys_log";
CREATE TABLE "workordersystem"."sys_log" (
  "id" int8 NOT NULL DEFAULT nextval('"workordersystem".sys_log_id_seq'::regclass),
  "username" varchar(50) COLLATE "pg_catalog"."default",
  "operation" varchar(50) COLLATE "pg_catalog"."default",
  "method" varchar(200) COLLATE "pg_catalog"."default",
  "params" varchar(5000) COLLATE "pg_catalog"."default",
  "time" int8 NOT NULL,
  "ip" varchar(64) COLLATE "pg_catalog"."default",
  "create_date" timestamp(6)
)
;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO "workordersystem"."sys_log" VALUES (1, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{"menuId":1,"parentId":0,"name":"系统管理","type":0,"icon":"system","orderNum":1}]', 12, '0:0:0:0:0:0:0:1', '2021-10-26 16:45:53.148');
INSERT INTO "workordersystem"."sys_log" VALUES (2, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{"menuId":33,"parentId":31,"name":"工单审批","url":"orders/ordersmanage","type":1,"icon":"sousuo","orderNum":0}]', 21, '0:0:0:0:0:0:0:1', '2021-10-26 17:21:06.919');
INSERT INTO "workordersystem"."sys_log" VALUES (3, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{"menuId":35,"parentId":0,"name":"告警信息","url":"alert/alertlist","type":1,"icon":"tubiao","orderNum":0}]', 8, '0:0:0:0:0:0:0:1', '2021-10-26 17:22:59.175');
INSERT INTO "workordersystem"."sys_log" VALUES (4, 'admin', '保存用户', 'io.renren.modules.sys.controller.SysUserController.save()', '[{"userId":1453175752023703554,"username":"guoyha","password":"d4baa544ab587f8e6415ef1e9f4f053969889f6eaa18ff0b4beb356ddf869469","salt":"YSEqbzWBABIOQRW9jHcb","email":"13161651120@163.com","mobile":"13161651120","status":1,"roleIdList":[],"createUserId":1,"createTime":"Oct 27, 2021, 9:44:32 AM"}]', 108, '0:0:0:0:0:0:0:1', '2021-10-27 09:44:34.345');
INSERT INTO "workordersystem"."sys_log" VALUES (5, 'admin', '保存角色', 'io.renren.modules.sys.controller.SysRoleController.save()', '[{"roleId":1,"roleName":"操作员","remark":"","createUserId":1,"menuIdList":[31,32,34,33,35,-666666],"createTime":"Oct 27, 2021, 9:45:00 AM"}]', 108, '0:0:0:0:0:0:0:1', '2021-10-27 09:45:00.122');
INSERT INTO "workordersystem"."sys_log" VALUES (6, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{"menuId":1,"parentId":0,"name":"系统管理","type":0,"icon":"system","orderNum":2}]', 12, '0:0:0:0:0:0:0:1', '2021-10-27 09:45:23.493');
INSERT INTO "workordersystem"."sys_log" VALUES (7, 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '[{"menuId":35,"parentId":0,"name":"告警信息","url":"alert/alertlist","type":1,"icon":"tubiao","orderNum":1}]', 10, '0:0:0:0:0:0:0:1', '2021-10-27 09:45:29.802');
INSERT INTO "workordersystem"."sys_log" VALUES (8, 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '[{"menuId":1453176119948050433,"parentId":0,"name":"测试","url":"","perms":"","type":0,"icon":"","orderNum":3}]', 13, '0:0:0:0:0:0:0:1', '2021-10-27 09:46:00.381');
INSERT INTO "workordersystem"."sys_log" VALUES (9, 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '[1453176119948050400]', 50, '0:0:0:0:0:0:0:1', '2021-10-27 09:46:13.965');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."sys_menu";
CREATE TABLE "workordersystem"."sys_menu" (
  "menu_id" int8 NOT NULL DEFAULT nextval('"workordersystem".sys_menu_menu_id_seq'::regclass),
  "parent_id" int8,
  "name" varchar(50) COLLATE "pg_catalog"."default",
  "url" varchar(200) COLLATE "pg_catalog"."default",
  "perms" varchar(500) COLLATE "pg_catalog"."default",
  "type" int4,
  "icon" varchar(50) COLLATE "pg_catalog"."default",
  "order_num" int4
)
;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO "workordersystem"."sys_menu" VALUES (2, 1, '管理员列表', 'sys/user', NULL, 1, 'admin', 1);
INSERT INTO "workordersystem"."sys_menu" VALUES (3, 1, '角色管理', 'sys/role', NULL, 1, 'role', 2);
INSERT INTO "workordersystem"."sys_menu" VALUES (4, 1, '菜单管理', 'sys/menu', NULL, 1, 'menu', 3);
INSERT INTO "workordersystem"."sys_menu" VALUES (5, 1, 'SQL监控', 'http://localhost:8080/renren-fast/druid/sql.html', NULL, 1, 'sql', 4);
INSERT INTO "workordersystem"."sys_menu" VALUES (15, 2, '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (16, 2, '新增', NULL, 'sys:user:save,sys:role:select', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (17, 2, '修改', NULL, 'sys:user:update,sys:role:select', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (18, 2, '删除', NULL, 'sys:user:delete', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (19, 3, '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (20, 3, '新增', NULL, 'sys:role:save,sys:menu:list', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (21, 3, '修改', NULL, 'sys:role:update,sys:menu:list', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (22, 3, '删除', NULL, 'sys:role:delete', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (23, 4, '查看', NULL, 'sys:menu:list,sys:menu:info', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (24, 4, '新增', NULL, 'sys:menu:save,sys:menu:select', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (25, 4, '修改', NULL, 'sys:menu:update,sys:menu:select', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (26, 4, '删除', NULL, 'sys:menu:delete', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (27, 1, '参数管理', 'sys/config', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 1, 'config', 6);
INSERT INTO "workordersystem"."sys_menu" VALUES (29, 1, '系统日志', 'sys/log', 'sys:log:list', 1, 'log', 7);
INSERT INTO "workordersystem"."sys_menu" VALUES (30, 1, '文件上传', 'oss/oss', 'sys:oss:all', 1, 'oss', 6);
INSERT INTO "workordersystem"."sys_menu" VALUES (31, 0, '工单管理', 'orders/ordersmange', NULL, 0, 'config', 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (32, 31, '工单展示', 'orders/orderslist', NULL, 1, 'zhedie', 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (34, 31, '添加工单', 'orders/ordersadd', NULL, 1, 'bianji', 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (33, 31, '工单审批', 'orders/ordersmanage', NULL, 1, 'sousuo', 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (1, 0, '系统管理', NULL, NULL, 0, 'system', 2);
INSERT INTO "workordersystem"."sys_menu" VALUES (35, 0, '告警信息', 'alert/alertlist', NULL, 1, 'tubiao', 1);
INSERT INTO "workordersystem"."sys_menu" VALUES (1453176119948050433, 0, '测试', NULL, NULL, 0, NULL, 3);

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."sys_oss";
CREATE TABLE "workordersystem"."sys_oss" (
  "id" int8 NOT NULL DEFAULT nextval('"workordersystem".sys_oss_id_seq'::regclass),
  "url" varchar(200) COLLATE "pg_catalog"."default",
  "create_date" timestamp(6)
)
;

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."sys_role";
CREATE TABLE "workordersystem"."sys_role" (
  "role_id" int8 NOT NULL DEFAULT nextval('"workordersystem".sys_role_role_id_seq'::regclass),
  "role_name" varchar(100) COLLATE "pg_catalog"."default",
  "remark" varchar(100) COLLATE "pg_catalog"."default",
  "create_user_id" int8,
  "create_time" timestamp(6)
)
;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO "workordersystem"."sys_role" VALUES (1, '操作员', NULL, 1, '2021-10-27 09:45:00.019');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."sys_role_menu";
CREATE TABLE "workordersystem"."sys_role_menu" (
  "id" int8 NOT NULL DEFAULT nextval('"workordersystem".sys_role_menu_id_seq'::regclass),
  "role_id" int8,
  "menu_id" int8
)
;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO "workordersystem"."sys_role_menu" VALUES (1, 1, 31);
INSERT INTO "workordersystem"."sys_role_menu" VALUES (2, 1, 32);
INSERT INTO "workordersystem"."sys_role_menu" VALUES (3, 1, 34);
INSERT INTO "workordersystem"."sys_role_menu" VALUES (4, 1, 33);
INSERT INTO "workordersystem"."sys_role_menu" VALUES (5, 1, 35);
INSERT INTO "workordersystem"."sys_role_menu" VALUES (6, 1, -666666);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."sys_user";
CREATE TABLE "workordersystem"."sys_user" (
  "user_id" int8 NOT NULL DEFAULT nextval('"workordersystem".sys_user_user_id_seq'::regclass),
  "username" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(100) COLLATE "pg_catalog"."default",
  "salt" varchar(20) COLLATE "pg_catalog"."default",
  "email" varchar(100) COLLATE "pg_catalog"."default",
  "mobile" varchar(100) COLLATE "pg_catalog"."default",
  "status" int4,
  "create_user_id" int8,
  "create_time" timestamp(6)
)
;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO "workordersystem"."sys_user" VALUES (1, 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', 1, 1, '2016-11-11 11:11:11');
INSERT INTO "workordersystem"."sys_user" VALUES (1453175752023703554, 'guoyha', 'd4baa544ab587f8e6415ef1e9f4f053969889f6eaa18ff0b4beb356ddf869469', 'YSEqbzWBABIOQRW9jHcb', '13161651120@163.com', '13161651120', 1, 1, '2021-10-27 09:44:32.632');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."sys_user_role";
CREATE TABLE "workordersystem"."sys_user_role" (
  "id" int8 NOT NULL DEFAULT nextval('"workordersystem".sys_user_role_id_seq'::regclass),
  "user_id" int8,
  "role_id" int8
)
;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."sys_user_token";
CREATE TABLE "workordersystem"."sys_user_token" (
  "user_id" int8 NOT NULL DEFAULT nextval('"workordersystem".sys_user_token_user_id_seq'::regclass),
  "token" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "expire_time" timestamp(6),
  "update_time" timestamp(6)
)
;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO "workordersystem"."sys_user_token" VALUES (1, 'bbcda99f40243cef2042abd07ef05dca', '2021-10-27 21:40:23.534', '2021-10-27 09:40:23.534');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."tb_user";
CREATE TABLE "workordersystem"."tb_user" (
  "user_id" int8 NOT NULL DEFAULT nextval('"workordersystem".tb_user_user_id_seq'::regclass),
  "username" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "mobile" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6)
)
;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO "workordersystem"."tb_user" VALUES (1, 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."schedule_job_job_id_seq"
OWNED BY "workordersystem"."schedule_job"."job_id";
SELECT setval('"workordersystem"."schedule_job_job_id_seq"', 2, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."schedule_job_log_log_id_seq"
OWNED BY "workordersystem"."schedule_job_log"."log_id";
SELECT setval('"workordersystem"."schedule_job_log_log_id_seq"', 3, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."sys_config_id_seq"
OWNED BY "workordersystem"."sys_config"."id";
SELECT setval('"workordersystem"."sys_config_id_seq"', 2, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."sys_log_id_seq"
OWNED BY "workordersystem"."sys_log"."id";
SELECT setval('"workordersystem"."sys_log_id_seq"', 10, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."sys_menu_menu_id_seq"
OWNED BY "workordersystem"."sys_menu"."menu_id";
SELECT setval('"workordersystem"."sys_menu_menu_id_seq"', 3, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."sys_oss_id_seq"
OWNED BY "workordersystem"."sys_oss"."id";
SELECT setval('"workordersystem"."sys_oss_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."sys_role_menu_id_seq"
OWNED BY "workordersystem"."sys_role_menu"."id";
SELECT setval('"workordersystem"."sys_role_menu_id_seq"', 7, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."sys_role_role_id_seq"
OWNED BY "workordersystem"."sys_role"."role_id";
SELECT setval('"workordersystem"."sys_role_role_id_seq"', 2, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."sys_user_role_id_seq"
OWNED BY "workordersystem"."sys_user_role"."id";
SELECT setval('"workordersystem"."sys_user_role_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."sys_user_token_user_id_seq"
OWNED BY "workordersystem"."sys_user_token"."user_id";
SELECT setval('"workordersystem"."sys_user_token_user_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."sys_user_user_id_seq"
OWNED BY "workordersystem"."sys_user"."user_id";
SELECT setval('"workordersystem"."sys_user_user_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."tb_user_user_id_seq"
OWNED BY "workordersystem"."tb_user"."user_id";
SELECT setval('"workordersystem"."tb_user_user_id_seq"', 2, true);

-- ----------------------------
-- Primary Key structure for table orders
-- ----------------------------
ALTER TABLE "workordersystem"."orders" ADD CONSTRAINT "orders_pkey" PRIMARY KEY ("order_id");

-- ----------------------------
-- Primary Key structure for table qrtz_blob_triggers
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_blob_triggers" ADD CONSTRAINT "qrtz_blob_triggers_pkey" PRIMARY KEY ("sched_name", "trigger_name", "trigger_group");

-- ----------------------------
-- Primary Key structure for table qrtz_calendars
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_calendars" ADD CONSTRAINT "qrtz_calendars_pkey" PRIMARY KEY ("sched_name", "calendar_name");

-- ----------------------------
-- Primary Key structure for table qrtz_cron_triggers
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_cron_triggers" ADD CONSTRAINT "qrtz_cron_triggers_pkey" PRIMARY KEY ("sched_name", "trigger_name", "trigger_group");

-- ----------------------------
-- Indexes structure for table qrtz_fired_triggers
-- ----------------------------
CREATE INDEX "idx_qrtz_ft_inst_job_req_rcvry" ON "workordersystem"."qrtz_fired_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "instance_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "requests_recovery" "pg_catalog"."bool_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_ft_j_g" ON "workordersystem"."qrtz_fired_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_ft_jg" ON "workordersystem"."qrtz_fired_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_ft_t_g" ON "workordersystem"."qrtz_fired_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_ft_tg" ON "workordersystem"."qrtz_fired_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_ft_trig_inst_name" ON "workordersystem"."qrtz_fired_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "instance_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table qrtz_fired_triggers
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_fired_triggers" ADD CONSTRAINT "qrtz_fired_triggers_pkey" PRIMARY KEY ("sched_name", "entry_id");

-- ----------------------------
-- Indexes structure for table qrtz_job_details
-- ----------------------------
CREATE INDEX "idx_qrtz_j_grp" ON "workordersystem"."qrtz_job_details" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_j_req_recovery" ON "workordersystem"."qrtz_job_details" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "requests_recovery" "pg_catalog"."bool_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table qrtz_job_details
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_job_details" ADD CONSTRAINT "qrtz_job_details_pkey" PRIMARY KEY ("sched_name", "job_name", "job_group");

-- ----------------------------
-- Primary Key structure for table qrtz_locks
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_locks" ADD CONSTRAINT "qrtz_locks_pkey" PRIMARY KEY ("sched_name", "lock_name");

-- ----------------------------
-- Primary Key structure for table qrtz_paused_trigger_grps
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_paused_trigger_grps" ADD CONSTRAINT "qrtz_paused_trigger_grps_pkey" PRIMARY KEY ("sched_name", "trigger_group");

-- ----------------------------
-- Primary Key structure for table qrtz_scheduler_state
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_scheduler_state" ADD CONSTRAINT "qrtz_scheduler_state_pkey" PRIMARY KEY ("sched_name", "instance_name");

-- ----------------------------
-- Primary Key structure for table qrtz_simple_triggers
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_simple_triggers" ADD CONSTRAINT "qrtz_simple_triggers_pkey" PRIMARY KEY ("sched_name", "trigger_name", "trigger_group");

-- ----------------------------
-- Primary Key structure for table qrtz_simprop_triggers
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_simprop_triggers" ADD CONSTRAINT "qrtz_simprop_triggers_pkey" PRIMARY KEY ("sched_name", "trigger_name", "trigger_group");

-- ----------------------------
-- Indexes structure for table qrtz_triggers
-- ----------------------------
CREATE INDEX "idx_qrtz_t_c" ON "workordersystem"."qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "calendar_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_g" ON "workordersystem"."qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_j" ON "workordersystem"."qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_jg" ON "workordersystem"."qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_n_g_state" ON "workordersystem"."qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_state" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_n_state" ON "workordersystem"."qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_state" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_next_fire_time" ON "workordersystem"."qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "next_fire_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_nft_misfire" ON "workordersystem"."qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "misfire_instr" "pg_catalog"."int2_ops" ASC NULLS LAST,
  "next_fire_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_nft_st" ON "workordersystem"."qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_state" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "next_fire_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_nft_st_misfire" ON "workordersystem"."qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "misfire_instr" "pg_catalog"."int2_ops" ASC NULLS LAST,
  "next_fire_time" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "trigger_state" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_nft_st_misfire_grp" ON "workordersystem"."qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "misfire_instr" "pg_catalog"."int2_ops" ASC NULLS LAST,
  "next_fire_time" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "trigger_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_state" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_state" ON "workordersystem"."qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_state" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table qrtz_triggers
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_triggers" ADD CONSTRAINT "qrtz_triggers_pkey" PRIMARY KEY ("sched_name", "trigger_name", "trigger_group");

-- ----------------------------
-- Primary Key structure for table schedule_job
-- ----------------------------
ALTER TABLE "workordersystem"."schedule_job" ADD CONSTRAINT "schedule_job_pkey" PRIMARY KEY ("job_id");

-- ----------------------------
-- Indexes structure for table schedule_job_log
-- ----------------------------
CREATE INDEX "index_job_id" ON "workordersystem"."schedule_job_log" USING btree (
  "job_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table schedule_job_log
-- ----------------------------
ALTER TABLE "workordersystem"."schedule_job_log" ADD CONSTRAINT "schedule_job_log_pkey" PRIMARY KEY ("log_id");

-- ----------------------------
-- Primary Key structure for table sys_captcha
-- ----------------------------
ALTER TABLE "workordersystem"."sys_captcha" ADD CONSTRAINT "sys_captcha_pkey" PRIMARY KEY ("uuid");

-- ----------------------------
-- Uniques structure for table sys_config
-- ----------------------------
ALTER TABLE "workordersystem"."sys_config" ADD CONSTRAINT "sys_config_param_key_key" UNIQUE ("param_key");

-- ----------------------------
-- Primary Key structure for table sys_config
-- ----------------------------
ALTER TABLE "workordersystem"."sys_config" ADD CONSTRAINT "sys_config_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_log
-- ----------------------------
ALTER TABLE "workordersystem"."sys_log" ADD CONSTRAINT "sys_log_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_menu
-- ----------------------------
ALTER TABLE "workordersystem"."sys_menu" ADD CONSTRAINT "sys_menu_pkey" PRIMARY KEY ("menu_id");

-- ----------------------------
-- Primary Key structure for table sys_oss
-- ----------------------------
ALTER TABLE "workordersystem"."sys_oss" ADD CONSTRAINT "sys_oss_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_role
-- ----------------------------
ALTER TABLE "workordersystem"."sys_role" ADD CONSTRAINT "sys_role_pkey" PRIMARY KEY ("role_id");

-- ----------------------------
-- Primary Key structure for table sys_role_menu
-- ----------------------------
ALTER TABLE "workordersystem"."sys_role_menu" ADD CONSTRAINT "sys_role_menu_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table sys_user
-- ----------------------------
ALTER TABLE "workordersystem"."sys_user" ADD CONSTRAINT "sys_user_username_key" UNIQUE ("username");

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE "workordersystem"."sys_user" ADD CONSTRAINT "sys_user_pkey" PRIMARY KEY ("user_id");

-- ----------------------------
-- Primary Key structure for table sys_user_role
-- ----------------------------
ALTER TABLE "workordersystem"."sys_user_role" ADD CONSTRAINT "sys_user_role_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table sys_user_token
-- ----------------------------
ALTER TABLE "workordersystem"."sys_user_token" ADD CONSTRAINT "sys_user_token_token_key" UNIQUE ("token");

-- ----------------------------
-- Primary Key structure for table sys_user_token
-- ----------------------------
ALTER TABLE "workordersystem"."sys_user_token" ADD CONSTRAINT "sys_user_token_pkey" PRIMARY KEY ("user_id");

-- ----------------------------
-- Uniques structure for table tb_user
-- ----------------------------
ALTER TABLE "workordersystem"."tb_user" ADD CONSTRAINT "tb_user_username_key" UNIQUE ("username");

-- ----------------------------
-- Primary Key structure for table tb_user
-- ----------------------------
ALTER TABLE "workordersystem"."tb_user" ADD CONSTRAINT "tb_user_pkey" PRIMARY KEY ("user_id");

-- ----------------------------
-- Foreign Keys structure for table qrtz_blob_triggers
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_blob_triggers" ADD CONSTRAINT "qrtz_blob_triggers_sched_name_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "workordersystem"."qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table qrtz_cron_triggers
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_cron_triggers" ADD CONSTRAINT "qrtz_cron_triggers_sched_name_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "workordersystem"."qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table qrtz_simple_triggers
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_simple_triggers" ADD CONSTRAINT "qrtz_simple_triggers_sched_name_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "workordersystem"."qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table qrtz_simprop_triggers
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_simprop_triggers" ADD CONSTRAINT "qrtz_simprop_triggers_sched_name_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "workordersystem"."qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table qrtz_triggers
-- ----------------------------
ALTER TABLE "workordersystem"."qrtz_triggers" ADD CONSTRAINT "qrtz_triggers_sched_name_fkey" FOREIGN KEY ("sched_name", "job_name", "job_group") REFERENCES "workordersystem"."qrtz_job_details" ("sched_name", "job_name", "job_group") ON DELETE NO ACTION ON UPDATE NO ACTION;
