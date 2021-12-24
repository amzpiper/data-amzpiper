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

 Date: 17/11/2021 14:09:56
*/


-- ----------------------------
-- Sequence structure for schedule_job_job_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."schedule_job_job_id_seq";
CREATE SEQUENCE "workordersystem"."schedule_job_job_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

-- ----------------------------
-- Sequence structure for schedule_job_log_log_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."schedule_job_log_log_id_seq";
CREATE SEQUENCE "workordersystem"."schedule_job_log_log_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

-- ----------------------------
-- Sequence structure for sys_config_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_config_id_seq";
CREATE SEQUENCE "workordersystem"."sys_config_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

-- ----------------------------
-- Sequence structure for sys_log_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_log_id_seq";
CREATE SEQUENCE "workordersystem"."sys_log_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

-- ----------------------------
-- Sequence structure for sys_menu_menu_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_menu_menu_id_seq";
CREATE SEQUENCE "workordersystem"."sys_menu_menu_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

-- ----------------------------
-- Sequence structure for sys_oss_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_oss_id_seq";
CREATE SEQUENCE "workordersystem"."sys_oss_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

-- ----------------------------
-- Sequence structure for sys_role_menu_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_role_menu_id_seq";
CREATE SEQUENCE "workordersystem"."sys_role_menu_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

-- ----------------------------
-- Sequence structure for sys_role_role_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_role_role_id_seq";
CREATE SEQUENCE "workordersystem"."sys_role_role_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

-- ----------------------------
-- Sequence structure for sys_user_role_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_user_role_id_seq";
CREATE SEQUENCE "workordersystem"."sys_user_role_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

-- ----------------------------
-- Sequence structure for sys_user_token_user_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_user_token_user_id_seq";
CREATE SEQUENCE "workordersystem"."sys_user_token_user_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

-- ----------------------------
-- Sequence structure for sys_user_user_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."sys_user_user_id_seq";
CREATE SEQUENCE "workordersystem"."sys_user_user_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

-- ----------------------------
-- Sequence structure for tb_user_user_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "workordersystem"."tb_user_user_id_seq";
CREATE SEQUENCE "workordersystem"."tb_user_user_id_seq"
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

-- ----------------------------
-- Table structure for alarms
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."alarms";
CREATE TABLE "workordersystem"."alarms"
(
    "id"                varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "alarm_name"        varchar(255) COLLATE "pg_catalog"."default",
    "begintime"         timestamp(0),
    "endtime"           timestamp(0),
    "device_name"       varchar(255) COLLATE "pg_catalog"."default",
    "point_name"        varchar(255) COLLATE "pg_catalog"."default",
    "value"             varchar(255) COLLATE "pg_catalog"."default",
    "description"       varchar(255) COLLATE "pg_catalog"."default",
    "quality"           varchar(255) COLLATE "pg_catalog"."default",
    "alarm_type"        varchar(255) COLLATE "pg_catalog"."default",
    "alarm_level"       varchar(255) COLLATE "pg_catalog"."default",
    "is_alarm_repeat"   varchar(255) COLLATE "pg_catalog"."default",
    "device_describe"   varchar(255) COLLATE "pg_catalog"."default",
    "alarm_action_dec"  varchar(255) COLLATE "pg_catalog"."default",
    "alarm_table_tag"   varchar(255) COLLATE "pg_catalog"."default",
    "data_type"         varchar(255) COLLATE "pg_catalog"."default",
    "adtec_create_date" timestamp(0),
    "adtec_status"      int4,
    "adtec_update_date" timestamp(0)
)
;
COMMENT ON COLUMN "workordersystem"."alarms"."id" IS 'id';
COMMENT ON COLUMN "workordersystem"."alarms"."alarm_name" IS '告警名称';
COMMENT ON COLUMN "workordersystem"."alarms"."begintime" IS '开始时间';
COMMENT ON COLUMN "workordersystem"."alarms"."endtime" IS '结束时间';
COMMENT ON COLUMN "workordersystem"."alarms"."device_name" IS '设备名';
COMMENT ON COLUMN "workordersystem"."alarms"."point_name" IS '设备名.点名';
COMMENT ON COLUMN "workordersystem"."alarms"."value" IS '值';
COMMENT ON COLUMN "workordersystem"."alarms"."description" IS '点描述';
COMMENT ON COLUMN "workordersystem"."alarms"."alarm_type" IS '报警类型';
COMMENT ON COLUMN "workordersystem"."alarms"."alarm_level" IS '报警级别';
COMMENT ON COLUMN "workordersystem"."alarms"."device_describe" IS '设备描述';
COMMENT ON COLUMN "workordersystem"."alarms"."alarm_action_dec" IS '动作描述';
COMMENT ON COLUMN "workordersystem"."alarms"."data_type" IS '数据类型';
COMMENT ON COLUMN "workordersystem"."alarms"."adtec_create_date" IS '本系统创建时间';
COMMENT ON COLUMN "workordersystem"."alarms"."adtec_status" IS '告警状态(0:未处理,1:已处理,2:已忽略)';
COMMENT ON COLUMN "workordersystem"."alarms"."adtec_update_date" IS '更新时间';
COMMENT ON TABLE "workordersystem"."alarms" IS '告警表';


-- ----------------------------
-- Table structure for order_examine
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."order_examine";
CREATE TABLE "workordersystem"."order_examine"
(
    "id"                  varchar(256) COLLATE "pg_catalog"."default" NOT NULL,
    "questask_id"         varchar(256) COLLATE "pg_catalog"."default",
    "submit_date"         timestamp(6),
    "create_date"         timestamp(6),
    "is_public"           numeric(1),
    "start_date"          timestamp(6),
    "bi_problem_category" varchar(20) COLLATE "pg_catalog"."default",
    "update_date"         timestamp(6),
    "ques_desc"           text COLLATE "pg_catalog"."default",
    "qusetask_state"      numeric(1),
    "emergency_degree"    varchar(256) COLLATE "pg_catalog"."default",
    "contact_address"     varchar(256) COLLATE "pg_catalog"."default",
    "contact_name"        varchar(256) COLLATE "pg_catalog"."default",
    "contact_phone"       varchar(256) COLLATE "pg_catalog"."default",
    "question_type"       varchar(256) COLLATE "pg_catalog"."default",
    "task_source"         varchar(256) COLLATE "pg_catalog"."default",
    "task_type"           int8,
    "state"               numeric(1),
    "house_floor"         varchar(256) COLLATE "pg_catalog"."default",
    "project_id"          varchar(256) COLLATE "pg_catalog"."default",
    "project_name"        varchar(256) COLLATE "pg_catalog"."default",
    "area_id"             numeric(11),
    "area_name"           varchar(256) COLLATE "pg_catalog"."default",
    "room_type"           varchar(256) COLLATE "pg_catalog"."default",
    "room_part_name"      varchar(256) COLLATE "pg_catalog"."default",
    "house_building"      varchar(256) COLLATE "pg_catalog"."default",
    "house_cell"          varchar(256) COLLATE "pg_catalog"."default",
    "house_room"          varchar(256) COLLATE "pg_catalog"."default",
    "maintenance_man"     varchar(256) COLLATE "pg_catalog"."default",
    "send_userid"         varchar(256) COLLATE "pg_catalog"."default",
    "mtain_userid"        varchar(256) COLLATE "pg_catalog"."default",
    "orign_source"        numeric(1),
    "source_type"         numeric(1),
    "house_fix_status"    numeric(1),
    "adtec_create_date"   timestamp(0),
    "examine_status"      int2,
    "source_system"       varchar(256) COLLATE "pg_catalog"."default",
    "target_system"       varchar(256) COLLATE "pg_catalog"."default",
    "adtec_update_date"   timestamp(0)
)
;
COMMENT ON COLUMN "workordersystem"."order_examine"."id" IS 'ID';
COMMENT ON COLUMN "workordersystem"."order_examine"."questask_id" IS '问题任务ID';
COMMENT ON COLUMN "workordersystem"."order_examine"."submit_date" IS '任务提交时间';
COMMENT ON COLUMN "workordersystem"."order_examine"."create_date" IS '创建时间';
COMMENT ON COLUMN "workordersystem"."order_examine"."is_public" IS '是否公共区域';
COMMENT ON COLUMN "workordersystem"."order_examine"."start_date" IS '开始时间';
COMMENT ON COLUMN "workordersystem"."order_examine"."bi_problem_category" IS '任务类型';
COMMENT ON COLUMN "workordersystem"."order_examine"."update_date" IS '更新时间';
COMMENT ON COLUMN "workordersystem"."order_examine"."ques_desc" IS '问题描述';
COMMENT ON COLUMN "workordersystem"."order_examine"."qusetask_state" IS '任务状态';
COMMENT ON COLUMN "workordersystem"."order_examine"."emergency_degree" IS '问题级别';
COMMENT ON COLUMN "workordersystem"."order_examine"."contact_address" IS '联系地址';
COMMENT ON COLUMN "workordersystem"."order_examine"."contact_name" IS '联系人';
COMMENT ON COLUMN "workordersystem"."order_examine"."contact_phone" IS '联系电话';
COMMENT ON COLUMN "workordersystem"."order_examine"."question_type" IS '问题类型';
COMMENT ON COLUMN "workordersystem"."order_examine"."task_source" IS '请求来源';
COMMENT ON COLUMN "workordersystem"."order_examine"."task_type" IS '任务类型';
COMMENT ON COLUMN "workordersystem"."order_examine"."state" IS '状态';
COMMENT ON COLUMN "workordersystem"."order_examine"."house_floor" IS '楼层';
COMMENT ON COLUMN "workordersystem"."order_examine"."project_id" IS '项目Id';
COMMENT ON COLUMN "workordersystem"."order_examine"."project_name" IS '项目名称';
COMMENT ON COLUMN "workordersystem"."order_examine"."area_id" IS '区域主键';
COMMENT ON COLUMN "workordersystem"."order_examine"."area_name" IS '区域名称';
COMMENT ON COLUMN "workordersystem"."order_examine"."room_type" IS '功能分区名称';
COMMENT ON COLUMN "workordersystem"."order_examine"."room_part_name" IS '部位名称';
COMMENT ON COLUMN "workordersystem"."order_examine"."house_building" IS '楼栋名称';
COMMENT ON COLUMN "workordersystem"."order_examine"."house_cell" IS '单元';
COMMENT ON COLUMN "workordersystem"."order_examine"."house_room" IS '房号';
COMMENT ON COLUMN "workordersystem"."order_examine"."maintenance_man" IS '维修人';
COMMENT ON COLUMN "workordersystem"."order_examine"."send_userid" IS '派单人ID';
COMMENT ON COLUMN "workordersystem"."order_examine"."mtain_userid" IS '维修人ID';
COMMENT ON COLUMN "workordersystem"."order_examine"."orign_source" IS '起单来源';
COMMENT ON COLUMN "workordersystem"."order_examine"."source_type" IS '录单系统';
COMMENT ON COLUMN "workordersystem"."order_examine"."house_fix_status" IS '是否房修单';
COMMENT ON COLUMN "workordersystem"."order_examine"."adtec_create_date" IS '本系统创建时间';
COMMENT ON COLUMN "workordersystem"."order_examine"."examine_status" IS '是否审批(0:未审批;1:已审批)';
COMMENT ON COLUMN "workordersystem"."order_examine"."source_system" IS '来源系统';
COMMENT ON COLUMN "workordersystem"."order_examine"."target_system" IS '目标系统';
COMMENT ON COLUMN "workordersystem"."order_examine"."adtec_update_date" IS '更新时间';
COMMENT ON TABLE "workordersystem"."order_examine" IS '工单审核表';



-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."qrtz_blob_triggers";
CREATE TABLE "workordersystem"."qrtz_blob_triggers"
(
    "sched_name"    varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
    "trigger_name"  varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
    "trigger_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
    "blob_data"     bytea
)
;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."qrtz_calendars";
CREATE TABLE "workordersystem"."qrtz_calendars"
(
    "sched_name"    varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
    "calendar_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
    "calendar"      bytea                                       NOT NULL
)
;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."qrtz_cron_triggers";
CREATE TABLE "workordersystem"."qrtz_cron_triggers"
(
    "sched_name"      varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
    "trigger_name"    varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
    "trigger_group"   varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
    "cron_expression" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
    "time_zone_id"    varchar(80) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO "workordersystem"."qrtz_cron_triggers"
VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');
INSERT INTO "workordersystem"."qrtz_cron_triggers"
VALUES ('RenrenScheduler', 'TASK_2', 'DEFAULT', '0 0/29 * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS "workordersystem"."qrtz_fired_triggers";
CREATE TABLE "workordersystem"."qrtz_fired_triggers"
(
    "sched_name"        varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
    "entry_id"          varchar(95) COLLATE "pg_catalog"."default"  NOT NULL,
    "trigger_name"      varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
    "trigger_group"     varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
    "instance_name"     varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
    "fired_time"        int8                                        NOT NULL,
    "sched_time"        int8                                        NOT NULL,
    "priority"          int4                                        NOT NULL,
    "state"             varchar(16) COLLATE "pg_catalog"."default"  NOT NULL,
    "job_name"          varchar(200) COLLATE "pg_catalog"."default",
    "job_group"         varchar(200) COLLATE "pg_catalog"."default",
    "is_nonconcurrent"  bool,
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
CREATE TABLE "workordersystem"."qrtz_job_details"
(
    "sched_name"        varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
    "job_name"          varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
    "job_group"         varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
    "description"       varchar(250) COLLATE "pg_catalog"."default",
    "job_class_name"    varchar(250) COLLATE "pg_catalog"."default" NOT NULL,
    "is_durable"        bool                                        NOT NULL,
    "is_nonconcurrent"  bool                                        NOT NULL,
    "is_update_data"    bool                                        NOT NULL,
    "requests_recovery" bool                                        NOT NULL,
    "job_data"          bytea
)
;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO "workordersystem"."qrtz_job_details"
VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', NULL, 'io.renren.modules.job.utils.ScheduleJob', 'f', 'f',
        'f', 'f', E'\\254\\355\\000\\005sr\\000\\025org.quartz.JobDataMap\\237\\260\\203\\350\\277\\251\\260\\313\\002\\000\\000xr\\000&org.quartz.utils.StringKeyDirtyFlagMap\\202\\010\\350\\303\\373\\305](\\002\\000\\001Z\\000\\023allowsTransientDataxr\\000\\035org.quartz.utils.DirtyFlagMap\\023\\346.\\255(v\\012\\316\\002\\000\\002Z\\000\\005dirtyL\\000\\003mapt\\000\\017Ljava/util/Map;xp\\001sr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\014w\\010\\000\\000\\000\\020\\000\\000\\000\\001t\\000\\015JOB_PARAM_KEYsr\\000.io.renren.modules.job.entity.ScheduleJobEntity\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007L\\000\\010beanNamet\\000\\022Ljava/lang/String;L\\000\\012createTimet\\000\\020Ljava/util/Date;L\\000\\016cronExpressionq\\000~\\000\\011L\\000\\005jobIdt\\000\\020Ljava/lang/Long;L\\000\\006paramsq\\000~\\000\\011L\\000\\006remarkq\\000~\\000\\011L\\000\\006statust\\000\\023Ljava/lang/Integer;xpt\\000\\010testTasksr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001X\\272\\365\\2230xt\\000\\0160 0/30 * * * ?sr\\000\\016java.lang.Long;\\213\\344\\220\\314\\217#\\337\\002\\000\\001J\\000\\005valuexr\\000\\020java.lang.Number\\206\\254\\225\\035\\013\\224\\340\\213\\002\\000\\000xp\\000\\000\\000\\000\\000\\000\\000\\001t\\000\\006renrent\\000\\014\\345\\217\\202\\346\\225\\260\\346\\265\\213\\350\\257\\225sr\\000\\021java.lang.Integer\\022\\342\\240\\244\\367\\201\\2078\\002\\000\\001I\\000\\005valuexq\\000~\\000\\023\\000\\000\\000\\000x\\000');
INSERT INTO "workordersystem"."qrtz_job_details" VALUES ('RenrenScheduler', 'TASK_2', 'DEFAULT', NULL, 'io.renren.modules.job.utils.ScheduleJob', 'f', 'f', 'f', 'f', E'\\254\\355\\000\\005sr\\000\\025org.quartz.JobDataMap\\237\\260\\203\\350\\277\\251\\260\\313\\002\\000\\000xr\\000&org.quartz.utils.StringKeyDirtyFlagMap\\202\\010\\350\\303\\373\\305](\\002\\000\\001Z\\000\\023allowsTransientDataxr\\000\\035org.quartz.utils.DirtyFlagMap\\023\\346.\\255(v\\012\\316\\002\\000\\002Z\\000\\005dirtyL\\000\\003mapt\\000\\017Ljava/util/Map;xp\\001sr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\014w\\010\\000\\000\\000\\020\\000\\000\\000\\001t\\000\\015JOB_PARAM_KEYsr\\000.io.renren.modules.job.entity.ScheduleJobEntity\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007L\\000\\010beanNamet\\000\\022Ljava/lang/String;L\\000\\012createTimet\\000\\020Ljava/util/Date;L\\000\\016cronExpressionq\\000~\\000\\011L\\000\\005jobIdt\\000\\020Ljava/lang/Long;L\\000\\006paramsq\\000~\\000\\011L\\000\\006remarkq\\000~\\000\\011L\\000\\006statust\\000\\023Ljava/lang/Integer;xpt\\000\\034coralWebSocketClientUtilTasksr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001}+\\336\\037\\274xt\\000\\0160 0/30 * * * ?sr\\000\\016java.lang.Long;\\213\\344\\220\\314\\217#\\337\\002\\000\\001J\\000\\005valuexr\\000\\020java.lang.Number\\206\\254\\225\\035\\013\\224\\340\\213\\002\\000\\000xp\\000\\000\\000\\000\\000\\000\\000\\002t\\000\\000t\\000\\\\\\350\\277\\236\\346\\216\\245coral\\347\\232\\204websocket\\347\\232\\204\\345\\256\\242\\346\\210\\267\\347\\253\\257\\350\\277\\236\\346\\216\\245,30\\351\\207\\215\\346\\226\\260\\350\\277\\236\\346\\216\\245\\344\\270\\200\\346\\254\\241(\\345\\233\\240\\344\\270\\272token30\\345\\210\\206\\345\\220\\216\\344\\274\\232\\350\\277\\207\\346\\234\\237)sr\\000\\021java.lang.Integer\\022\\342\\240\\244\\367\\201\\2078\\002\\000\\001I\\000\\005valuexq\\000~\\000\\023\\000\\000\\000\\000x\\000');

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
INSERT INTO "workordersystem"."qrtz_locks" VALUES ('RenrenScheduler', 'TRIGGER_ACCESS');
INSERT INTO "workordersystem"."qrtz_locks" VALUES ('RenrenScheduler', 'STATE_ACCESS');

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
INSERT INTO "workordersystem"."qrtz_scheduler_state" VALUES ('RenrenScheduler', 'DESKTOP-IBKH1S51637125737437', 1637129319291, 15000);

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
INSERT INTO "workordersystem"."qrtz_triggers" VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', NULL, 1637116200000, -1, 5, 'PAUSED', 'CRON', 1637115129000, 0, NULL, 2, E'\\254\\355\\000\\005sr\\000\\025org.quartz.JobDataMap\\237\\260\\203\\350\\277\\251\\260\\313\\002\\000\\000xr\\000&org.quartz.utils.StringKeyDirtyFlagMap\\202\\010\\350\\303\\373\\305](\\002\\000\\001Z\\000\\023allowsTransientDataxr\\000\\035org.quartz.utils.DirtyFlagMap\\023\\346.\\255(v\\012\\316\\002\\000\\002Z\\000\\005dirtyL\\000\\003mapt\\000\\017Ljava/util/Map;xp\\001sr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\014w\\010\\000\\000\\000\\020\\000\\000\\000\\001t\\000\\015JOB_PARAM_KEYsr\\000.io.renren.modules.job.entity.ScheduleJobEntity\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007L\\000\\010beanNamet\\000\\022Ljava/lang/String;L\\000\\012createTimet\\000\\020Ljava/util/Date;L\\000\\016cronExpressionq\\000~\\000\\011L\\000\\005jobIdt\\000\\020Ljava/lang/Long;L\\000\\006paramsq\\000~\\000\\011L\\000\\006remarkq\\000~\\000\\011L\\000\\006statust\\000\\023Ljava/lang/Integer;xpt\\000\\010testTasksr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001X\\272\\365\\2230xt\\000\\0160 0/30 * * * ?sr\\000\\016java.lang.Long;\\213\\344\\220\\314\\217#\\337\\002\\000\\001J\\000\\005valuexr\\000\\020java.lang.Number\\206\\254\\225\\035\\013\\224\\340\\213\\002\\000\\000xp\\000\\000\\000\\000\\000\\000\\000\\001t\\000\\004testt\\000\\014\\345\\217\\202\\346\\225\\260\\346\\265\\213\\350\\257\\225sr\\000\\021java.lang.Integer\\022\\342\\240\\244\\367\\201\\2078\\002\\000\\001I\\000\\005valuexq\\000~\\000\\023\\000\\000\\000\\001x\\000');
INSERT INTO "workordersystem"."qrtz_triggers" VALUES ('RenrenScheduler', 'TASK_2', 'DEFAULT', 'TASK_2', 'DEFAULT', NULL, 1637130540000, 1637128800000, 5, 'WAITING', 'CRON', 1637118517000, 0, NULL, 2, E'\\254\\355\\000\\005sr\\000\\025org.quartz.JobDataMap\\237\\260\\203\\350\\277\\251\\260\\313\\002\\000\\000xr\\000&org.quartz.utils.StringKeyDirtyFlagMap\\202\\010\\350\\303\\373\\305](\\002\\000\\001Z\\000\\023allowsTransientDataxr\\000\\035org.quartz.utils.DirtyFlagMap\\023\\346.\\255(v\\012\\316\\002\\000\\002Z\\000\\005dirtyL\\000\\003mapt\\000\\017Ljava/util/Map;xp\\001sr\\000\\021java.util.HashMap\\005\\007\\332\\301\\303\\026`\\321\\003\\000\\002F\\000\\012loadFactorI\\000\\011thresholdxp?@\\000\\000\\000\\000\\000\\014w\\010\\000\\000\\000\\020\\000\\000\\000\\001t\\000\\015JOB_PARAM_KEYsr\\000.io.renren.modules.job.entity.ScheduleJobEntity\\000\\000\\000\\000\\000\\000\\000\\001\\002\\000\\007L\\000\\010beanNamet\\000\\022Ljava/lang/String;L\\000\\012createTimet\\000\\020Ljava/util/Date;L\\000\\016cronExpressionq\\000~\\000\\011L\\000\\005jobIdt\\000\\020Ljava/lang/Long;L\\000\\006paramsq\\000~\\000\\011L\\000\\006remarkq\\000~\\000\\011L\\000\\006statust\\000\\023Ljava/lang/Integer;xpt\\000\\034coralWebSocketClientUtilTasksr\\000\\016java.util.Datehj\\201\\001KYt\\031\\003\\000\\000xpw\\010\\000\\000\\001}+\\336\\037\\274xt\\000\\0160 0/29 * * * ?sr\\000\\016java.lang.Long;\\213\\344\\220\\314\\217#\\337\\002\\000\\001J\\000\\005valuexr\\000\\020java.lang.Number\\206\\254\\225\\035\\013\\224\\340\\213\\002\\000\\000xp\\000\\000\\000\\000\\000\\000\\000\\002pt\\000\\\\\\350\\277\\236\\346\\216\\245coral\\347\\232\\204websocket\\347\\232\\204\\345\\256\\242\\346\\210\\267\\347\\253\\257\\350\\277\\236\\346\\216\\245,30\\351\\207\\215\\346\\226\\260\\350\\277\\236\\346\\216\\245\\344\\270\\200\\346\\254\\241(\\345\\233\\240\\344\\270\\272token30\\345\\210\\206\\345\\220\\216\\344\\274\\232\\350\\277\\207\\346\\234\\237)sr\\000\\021java.lang.Integer\\022\\342\\240\\244\\367\\201\\2078\\002\\000\\001I\\000\\005valuexq\\000~\\000\\023\\000\\000\\000\\000x\\000');

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
INSERT INTO "workordersystem"."schedule_job" VALUES (1, 'testTask', 'test', '0 0/30 * * * ?', 1, '参数测试', '2016-12-01 23:16:46');
INSERT INTO "workordersystem"."schedule_job" VALUES (2, 'coralWebSocketClientUtilTask', NULL, '0 0/29 * * * ?', 1, '连接coral的websocket的客户端连接,30重新连接一次(因为token30分后会过期)', '2021-11-17 11:08:37.18');

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
INSERT INTO "workordersystem"."sys_config" VALUES (3, '自动处理', '1', 1, '1：开启，0：关闭');
INSERT INTO "workordersystem"."sys_config" VALUES (2, '自动审批', '1', 1, '1：开启，0：关闭');
INSERT INTO "workordersystem"."sys_config" VALUES (4, 'coral-username', 'rtcs', 1, 'coral平台账号');
INSERT INTO "workordersystem"."sys_config" VALUES (5, 'coral-password', 'Aa58221086!', 1, 'coral平台密码');
INSERT INTO "workordersystem"."sys_config" VALUES (6, 'coral-host', 'coral.anjieservice.com', 1, '请求地址');
INSERT INTO "workordersystem"."sys_config" VALUES (7, 'coral-url', 'https://coral.anjieservice.com', 1, 'coral的url地址');
INSERT INTO "workordersystem"."sys_config" VALUES (8, 'orderAlarmData', 'rtdcbd', 1, '订阅报警数据列表,以 , (英文)分割');

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
INSERT INTO "workordersystem"."sys_menu" VALUES (30, 1, '文件上传', 'oss/oss', 'sys:oss:all', 1, 'oss', 6);
INSERT INTO "workordersystem"."sys_menu" VALUES (31, 0, '工单管理', 'orders/ordersmange', NULL, 0, 'config', 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (1, 0, '系统管理', NULL, NULL, 0, 'system', 2);
INSERT INTO "workordersystem"."sys_menu" VALUES (34, 31, '提报工单', 'orders/ordersadd', NULL, 1, 'bianji', 2);
INSERT INTO "workordersystem"."sys_menu" VALUES (35, 0, '告警信息', 'alert/alertlist', NULL, 1, 'tixing', 1);
INSERT INTO "workordersystem"."sys_menu" VALUES (32, 31, '工单展示', 'orders/orderslist', NULL, 1, 'editor', 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (33, 31, '工单审批', 'orders/ordersmanage', NULL, 1, 'sousuo', 1);
INSERT INTO "workordersystem"."sys_menu" VALUES (29, 1, '操作日志', 'sys/log', 'sys:log:list', 1, 'log', 7);
INSERT INTO "workordersystem"."sys_menu" VALUES (5, 1, 'SQL监控', 'http://localhost:8999/druid/sql.html', NULL, 1, 'sql', 6);
INSERT INTO "workordersystem"."sys_menu" VALUES (27, 1, '系统参数', 'sys/config', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 1, 'config', 4);
INSERT INTO "workordersystem"."sys_menu" VALUES (4, 1, '菜单管理', 'sys/menu', NULL, 1, 'menu', 5);
INSERT INTO "workordersystem"."sys_menu" VALUES (6, 1, '定时任务', 'job/schedule', NULL, 1, 'job', 5);
INSERT INTO "workordersystem"."sys_menu" VALUES (7, 6, '查看', NULL, 'sys:schedule:list,sys:schedule:info', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (8, 6, '新增', NULL, 'sys:schedule:save', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (9, 6, '修改', NULL, 'sys:schedule:update', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (10, 6, '删除', NULL, 'sys:schedule:delete', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (11, 6, '暂停', NULL, 'sys:schedule:pause', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (12, 6, '恢复', NULL, 'sys:schedule:resume', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (13, 6, '立即执行', NULL, 'sys:schedule:run', 2, NULL, 0);
INSERT INTO "workordersystem"."sys_menu" VALUES (14, 6, '日志列表', NULL, 'sys:schedule:log', 2, NULL, 0);

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
INSERT INTO "workordersystem"."sys_user" VALUES (1, 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'root@adtec.io', '13612345678', 1, 1, '2016-11-11 11:11:11');

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
SELECT setval('"workordersystem"."schedule_job_job_id_seq"', 3, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."schedule_job_log_log_id_seq"
OWNED BY "workordersystem"."schedule_job_log"."log_id";
SELECT setval('"workordersystem"."schedule_job_log_log_id_seq"', 1, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."sys_config_id_seq"
OWNED BY "workordersystem"."sys_config"."id";
SELECT setval('"workordersystem"."sys_config_id_seq"', 9, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."sys_log_id_seq"
OWNED BY "workordersystem"."sys_log"."id";
SELECT setval('"workordersystem"."sys_log_id_seq"', 1, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."sys_menu_menu_id_seq"
OWNED BY "workordersystem"."sys_menu"."menu_id";
SELECT setval('"workordersystem"."sys_menu_menu_id_seq"', 36, true);

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
SELECT setval('"workordersystem"."sys_role_menu_id_seq"', 1, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "workordersystem"."sys_role_role_id_seq"
OWNED BY "workordersystem"."sys_role"."role_id";
SELECT setval('"workordersystem"."sys_role_role_id_seq"', 3, true);

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
-- Primary Key structure for table alarms
-- ----------------------------
ALTER TABLE "workordersystem"."alarms" ADD CONSTRAINT "alarms_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table order_examine
-- ----------------------------
ALTER TABLE "workordersystem"."order_examine" ADD CONSTRAINT "order_examine_pkey" PRIMARY KEY ("id");

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
