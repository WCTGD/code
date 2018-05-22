/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.131_3306
Source Server Version : 50624
Source Host           : 192.168.1.131:3306
Source Database       : asset_management

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-01-17 12:23:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `assets`
-- ----------------------------
DROP TABLE IF EXISTS `assets`;
CREATE TABLE `assets` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资产ID',
  `no` varchar(255) NOT NULL COMMENT '编号',
  `contractor_id` int(128) DEFAULT NULL COMMENT '承包商(外键)',
  `asset_desc` varchar(255) NOT NULL COMMENT '资产描述',
  `way_id` int(16) NOT NULL COMMENT '资产维护方式(外键)',
  `warranty_deadline` date DEFAULT NULL COMMENT '保修截止日期',
  `way_note` varchar(255) DEFAULT NULL COMMENT '维护（保修外包）备注',
  `asset_note` varchar(255) DEFAULT NULL COMMENT '资产备注',
  `position_id` int(11) DEFAULT NULL COMMENT '位置ID',
  `department_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `class_id` int(11) NOT NULL COMMENT '资产类型ID',
  `state_id` int(32) NOT NULL COMMENT '资产状态(外键)',
  `woker_id` int(11) DEFAULT NULL COMMENT '员工ID',
  `type` varchar(64) DEFAULT NULL COMMENT '型号',
  `serial_no` varchar(128) DEFAULT NULL COMMENT '序列号',
  `manufacturer` varchar(255) DEFAULT NULL COMMENT '生产商',
  `supplier_id` int(255) NOT NULL COMMENT '供应商',
  `start_date` date NOT NULL COMMENT '启用日期',
  `asset_value` double DEFAULT NULL COMMENT '资产现值',
  `purchaser_price` double DEFAULT NULL COMMENT '采购价格',
  `life_span` varchar(255) DEFAULT NULL COMMENT '预期寿命',
  `clear_date` date DEFAULT NULL COMMENT '清理日期',
  `public_property` int(8) NOT NULL COMMENT '是否是公共资产（0不是1是）',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `regain_time` datetime DEFAULT NULL COMMENT '从回收站恢复的时间',
  `delete_time` datetime DEFAULT NULL COMMENT '假删时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `show` int(11) NOT NULL DEFAULT '1' COMMENT '是否显示',
  PRIMARY KEY (`id`),
  UNIQUE KEY `no` (`no`) USING HASH,
  KEY `p_id_1` (`position_id`),
  KEY `c_id` (`class_id`),
  KEY `way_id` (`way_id`),
  KEY `supplier_id` (`supplier_id`),
  KEY `state_id` (`state_id`) USING BTREE,
  KEY `contractor_id` (`contractor_id`),
  KEY `assets_ibfk_1` (`woker_id`) USING HASH,
  KEY `d_id` (`department_id`),
  CONSTRAINT `c_id` FOREIGN KEY (`class_id`) REFERENCES `base_asset_class` (`id`),
  CONSTRAINT `contractor_id` FOREIGN KEY (`contractor_id`) REFERENCES `base_contractor` (`id`),
  CONSTRAINT `p_id_1` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`),
  CONSTRAINT `status_id` FOREIGN KEY (`state_id`) REFERENCES `sundry_assets_state` (`id`),
  CONSTRAINT `supplier_id` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
  CONSTRAINT `way_id` FOREIGN KEY (`way_id`) REFERENCES `sundry_assets_way` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assets
-- ----------------------------
INSERT INTO `assets` VALUES ('8', '123', '2', '123', '1', null, '', '', null, null, '2', '7', null, '123', '123', '123', '3', '2016-12-16', null, null, '', null, '1', '4564564647567', null, '2016-12-16 11:45:12', '2016-12-16 11:46:41', '2016-12-19 11:14:05', '1');
INSERT INTO `assets` VALUES ('9', '567', '2', '67', '2', '2016-12-21', 'poi', 'qdw', '26', '7', '6', '2', '124', '529', '516', '615', '3', '2016-12-21', '3', '56', '123', '2016-12-21', '0', '015', '2016-12-21 10:23:13', null, '2016-12-21 10:24:54', '2016-12-29 14:20:57', '1');
INSERT INTO `assets` VALUES ('10', '432', '1', 't3', '2', '2016-12-26', 'fg', 'fd', null, null, '6', '2', null, '435', '345', '543', '3', '2016-12-26', '4', '243', '324', '2016-12-26', '1', 'wre', null, null, '2016-12-26 13:17:21', '2016-12-26 13:17:21', '1');

-- ----------------------------
-- Table structure for `authority`
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `c_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `m_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `name` varchar(255) NOT NULL COMMENT '权限中文名称',
  `url` varchar(10240) NOT NULL,
  `enabled` int(1) NOT NULL DEFAULT '1' COMMENT '是否启用 ，1为启用 0 为不启用',
  `parent_id` bigint(11) DEFAULT NULL COMMENT '父类菜单ID',
  `sign` varchar(255) NOT NULL COMMENT '标识权限,可选为insert,update,del,detail,select',
  `e_name` varchar(255) NOT NULL COMMENT '权限英文名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('26', '2016-12-13 15:45:00', '2016-12-22 09:33:24', '供应商', '/basicData/basicDataListSupplier', '1', '1', 'select', 'supplier');
INSERT INTO `authority` VALUES ('27', '2016-12-13 15:45:01', '2016-12-22 09:33:27', '供应商', '/basicData/supplierSelectByOn', '1', '1', 'detail', 'supplier');
INSERT INTO `authority` VALUES ('28', '2016-12-13 15:45:05', '2016-12-22 09:33:21', '供应商', '/basicData/supplierDelectByNo', '1', '1', 'del', 'supplier');
INSERT INTO `authority` VALUES ('30', '2016-12-13 15:45:07', '2016-12-22 09:33:19', '供应商', '/basicData/supplierInsert', '1', '1', 'insert', 'supplier');
INSERT INTO `authority` VALUES ('31', '2016-12-13 15:45:08', '2016-12-22 09:33:17', '供应商', '/basicData/supplierUpdate', '1', '1', 'update', 'supplier');
INSERT INTO `authority` VALUES ('32', '2016-12-13 15:45:11', '2016-12-22 09:33:15', '承包商', '/basicData/basicDataListBaseContractor', '1', '1', 'select', 'contractor');
INSERT INTO `authority` VALUES ('34', '2016-12-13 15:49:22', '2016-12-22 09:33:12', '承包商', '/basicData/baseContractorInsert', '1', '1', 'insert', 'contractor');
INSERT INTO `authority` VALUES ('35', '2016-12-13 15:49:28', '2016-12-22 09:33:10', '承包商', '/basicData/selectBaseContractorByNo', '1', '1', 'select', 'contractor');
INSERT INTO `authority` VALUES ('36', '2016-12-13 15:49:31', '2016-12-22 09:33:07', '承包商', '/basicData/updateBaseContractorByNo', '1', '1', 'del', 'contractor');
INSERT INTO `authority` VALUES ('37', '2016-12-13 15:49:35', '2016-12-22 09:33:05', '承包商', '/basicData/baseContractorUpdate', '1', '1', 'update', 'contractor');
INSERT INTO `authority` VALUES ('53', '2016-12-13 15:52:49', '2016-12-22 09:33:03', '安全操作指导', '/basicData/uploadFile', '1', '1', 'insert', 'file');
INSERT INTO `authority` VALUES ('54', '2016-12-13 15:52:50', '2016-12-22 09:33:00', '安全操作指导', '/basicData/listUploadFile', '1', '1', 'select', 'file');
INSERT INTO `authority` VALUES ('55', '2016-12-13 15:52:51', '2016-12-22 09:32:59', '安全操作指导', '/basicData/deleteSecurityGuidance', '1', '1', 'del', 'file');
INSERT INTO `authority` VALUES ('103', '2016-12-19 16:23:33', '2016-12-22 09:32:11', '基础信息首页', '/basicDataList.html', '1', '1', 'detail', 'basicDataList.html');
INSERT INTO `authority` VALUES ('104', '2016-12-20 15:30:36', '2016-12-22 09:32:14', '综合', '/basicData/sundryWokerorderStatesSelect', '1', '1', 'select', 'multiple');
INSERT INTO `authority` VALUES ('105', '2016-12-20 15:32:14', '2016-12-22 09:32:17', '综合', '/basicData/saveAssetClasses;/basicData/sundryWokerorderStatesInsert;/basicData/sundryWokerorderClassInsert;/basicData/sundryWokerClassInsert\r\n/basicData/deleteAssetClasses;/basicData/sundryWokerorderStatesDelete;/basicData/sundryWokerorderClassDelete;/basicData/sundryWokerClassDelete;\r\n/basicData/sundryAssetsStateDelete;/basicData/sundryAssetsWayDelete;/basicData/sundryUrgencyLevelDelete; /basicData/sundryJobPriorityDelete', '1', '1', 'del', 'multiple');
INSERT INTO `authority` VALUES ('106', '2016-12-20 15:32:38', '2016-12-22 09:32:20', '综合', '/basicData/saveAssetClasses;/basicData/sundryWokerorderStatesInsert;/basicData/sundryWokerorderClassInsert;/basicData/sundryWokerClassInsert\r\n;/basicData/sundryAssetsStateInsert;/basicData/sundryAssetsWayInsert; /basicData/sundryUrgencyLevelInsert;/basicData/sundryJobPriorityInsert', '1', '1', 'insert', 'multiple');
INSERT INTO `authority` VALUES ('107', '2016-12-20 16:26:02', '2016-12-22 09:32:23', '位置', '/basicData/deletePosition;/position/delete', '1', '2', 'del', 'position');
INSERT INTO `authority` VALUES ('108', '2016-12-20 16:26:51', '2016-12-22 09:32:26', '位置', '/position/insert', '1', '2', 'insert', 'position');
INSERT INTO `authority` VALUES ('109', '2016-12-20 16:31:58', '2016-12-22 09:32:29', '位置', '/position/updatePosition', '1', '2', 'update', 'position');
INSERT INTO `authority` VALUES ('110', '2016-12-20 16:34:33', '2016-12-22 09:32:31', '位置', '/position/positionList;/position/lNumber;/position/departmentId', '1', '2', 'select', 'position');
INSERT INTO `authority` VALUES ('111', '2016-12-20 16:39:22', '2016-12-22 11:30:52', '位置首页', '/positionList.html', '1', '2', 'detail', 'position.html');
INSERT INTO `authority` VALUES ('112', '2016-12-20 16:42:54', '2016-12-22 09:32:35', '位置', '/position/selectPlaceById', '1', '2', 'detail', 'position');
INSERT INTO `authority` VALUES ('113', '2016-12-20 16:51:00', '2016-12-22 09:32:37', '资产', '/assets/add;/assets/selectallbaseassetclass;/assets/selectallsundryassetsstate;/assets/selectallsundryassetsway; /assets/selectallbasedepartment;/assets/selectallbasecontractor;/assets/selectallsupplier;/assets/checkno;/assets/changedepartment;/assets/onlychangedepartment;/assets/changeposition', '1', '3', 'insert', 'assets');
INSERT INTO `authority` VALUES ('114', '2016-12-20 16:52:17', '2016-12-22 09:32:39', '资产首页', '/assets.html', '1', '3', 'detail', 'assets.html');
INSERT INTO `authority` VALUES ('115', '2016-12-20 16:52:50', '2016-12-22 09:32:41', '资产', '/assets/deletebypk', '1', '3', 'del', 'assets');
INSERT INTO `authority` VALUES ('116', '2016-12-20 16:54:11', '2016-12-22 09:32:43', '资产', '/assets/update;/assets/selectallbaseassetclass;/assets/selectallsundryassetsstate;/assets/selectallsundryassetsway; /assets/selectallbasedepartment;/assets/selectallbasecontractor;/assets/selectallsupplier;/assets/checkno;/assets/changedepartment;/assets/onlychangedepartment;/assets/changeposition', '1', '3', 'update', 'assets');
INSERT INTO `authority` VALUES ('117', '2016-12-20 16:54:30', '2016-12-22 09:32:46', '资产', '/assets/selectassets', '1', '3', 'select', 'assets');
INSERT INTO `authority` VALUES ('118', '2016-12-20 16:59:49', '2016-12-22 09:32:48', '资产', '/assets/selectbypk', '1', '3', 'detail', 'assets');
INSERT INTO `authority` VALUES ('119', '2016-12-20 17:47:59', '2016-12-22 09:32:51', '工单首页', '/maintain.html', '1', '6', 'detail', 'maintain.html');
INSERT INTO `authority` VALUES ('120', '2016-12-20 17:50:05', '2016-12-22 09:32:53', '工单', '/delete', '1', '6', 'del', 'repairlist');
INSERT INTO `authority` VALUES ('122', '2016-12-28 15:11:56', '2016-12-28 15:15:47', '工单', '/repairlist/selectallsundrywokerorderclass;/repairlist/selectallsundrywokerorderstate;/repairlist/selectallsundryurgencyLevel;/repairlist/selectallworker;/repairlist/selectallposition;/repairlist/selectone;/repairlist/select;/repairlist/selectmax;/repairlist/selectpublicassets', '1', '6', 'select', 'repairlist');
INSERT INTO `authority` VALUES ('123', '2016-12-28 15:15:28', '2016-12-28 15:15:28', '工单', '/repairlist/changeworker;/repairlist/update;/repairlist/changeposition', '1', '6', 'update', 'repairlist');
INSERT INTO `authority` VALUES ('124', '2016-12-28 15:16:46', '2016-12-28 15:16:46', '工单', '/repairlist/add', '1', '6', 'insert', 'repairlist');
INSERT INTO `authority` VALUES ('125', '2016-12-28 15:20:57', '2016-12-28 15:20:57', '维护', '/maintain/select;/maintain/selectone;/maintain/selectmaxno;/maintain/selectpublicassets;/maintain/selectallbasedepartment;/maintain/selectallposition;/maintain/selectalljobclass', '1', '4', 'select', 'maintain');
INSERT INTO `authority` VALUES ('126', '2016-12-28 15:23:23', '2016-12-28 15:23:23', '维护', '/maintain/update', '1', '4', 'update', 'maintain');
INSERT INTO `authority` VALUES ('127', '2016-12-28 15:23:53', '2016-12-28 15:23:53', '维护', '/maintain/delete', '1', '4', 'del', 'maintain');
INSERT INTO `authority` VALUES ('128', '2016-12-28 15:24:51', '2016-12-28 15:24:51', '维护', '/maintain/insert', '1', '4', 'insert', 'maintain');
INSERT INTO `authority` VALUES ('129', '2016-12-28 15:25:56', '2016-12-28 15:25:56', '维护首页', '/maintain.html;/maintainform.html;/maintainlist.html', '1', '4', 'detail', 'maintain.html');

-- ----------------------------
-- Table structure for `base_asset_class`
-- ----------------------------
DROP TABLE IF EXISTS `base_asset_class`;
CREATE TABLE `base_asset_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资产类别ID',
  `asset_category` varchar(255) NOT NULL COMMENT '资产类别',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_asset_class
-- ----------------------------
INSERT INTO `base_asset_class` VALUES ('2', '场地', '2016-10-19 16:19:34', '2016-10-19 16:19:34');
INSERT INTO `base_asset_class` VALUES ('3', '机械', '2016-10-19 16:19:55', '2016-10-19 16:19:55');
INSERT INTO `base_asset_class` VALUES ('4', '电子', '2016-10-19 16:20:05', '2016-10-19 16:20:05');
INSERT INTO `base_asset_class` VALUES ('5', '电器', '2016-10-19 16:20:13', '2016-10-19 16:20:13');
INSERT INTO `base_asset_class` VALUES ('6', '洗涤与清洁', '2016-10-19 16:20:23', '2016-10-19 16:20:23');
INSERT INTO `base_asset_class` VALUES ('7', '办公用品', '2016-10-24 11:04:49', '2016-10-25 15:37:46');
INSERT INTO `base_asset_class` VALUES ('8', '鼠标', '2016-11-28 17:15:22', '2016-11-28 17:15:22');
INSERT INTO `base_asset_class` VALUES ('20', 'PC', '2016-11-30 16:12:14', '2016-11-30 16:12:14');

-- ----------------------------
-- Table structure for `base_contractor`
-- ----------------------------
DROP TABLE IF EXISTS `base_contractor`;
CREATE TABLE `base_contractor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `no` varchar(255) NOT NULL COMMENT '编号',
  `name` varchar(255) NOT NULL COMMENT '承包商描述',
  `contact_name` varchar(16) NOT NULL COMMENT '联系人',
  `email` varchar(25) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `province` varchar(16) DEFAULT NULL COMMENT '省',
  `city` varchar(16) DEFAULT NULL COMMENT '市',
  `telphone` varchar(16) NOT NULL COMMENT '电话',
  `fax` varchar(255) DEFAULT NULL COMMENT '传真',
  `service` varchar(255) NOT NULL COMMENT '服务',
  `flag` int(5) NOT NULL DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_contractor
-- ----------------------------
INSERT INTO `base_contractor` VALUES ('1', '001', '大鸡排', '杨永信', null, null, null, null, '123', null, '电疗', '1', '2016-10-18 17:04:33', '2016-12-06 15:11:22');
INSERT INTO `base_contractor` VALUES ('2', '002', '55', '555', null, null, null, null, '44', null, '66', '1', '2016-12-06 15:12:30', '2016-12-06 15:47:20');
INSERT INTO `base_contractor` VALUES ('3', '003', '陈国', '1', '22', '111', '333', '444', '552', '6666', 'eeee', '0', '2016-12-06 15:47:06', '2017-01-03 10:41:11');

-- ----------------------------
-- Table structure for `base_department`
-- ----------------------------
DROP TABLE IF EXISTS `base_department`;
CREATE TABLE `base_department` (
  `id` int(11) NOT NULL COMMENT '部门ID',
  `no` varchar(255) NOT NULL COMMENT '编号',
  `department` varchar(32) NOT NULL DEFAULT '' COMMENT '部门描述',
  `p_id` int(5) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_department
-- ----------------------------
INSERT INTO `base_department` VALUES ('1', '', '集团总部', '0', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('2', '', '杭州基地', '0', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('3', '', '金华基地', '0', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('4', '', '宁波基地', '0', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('5', '', '嘉兴基地', '0', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('6', 'D0001', '公司领导', '1', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('7', 'D0002', '总经办', '1', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('8', 'D0003', '技术部', '1', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('9', 'D0004', '市场部', '1', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('10', 'D0005', '招商部', '1', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('11', 'D0006', '仓配物流部', '1', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('12', 'D0007', '法务部', '1', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('13', 'D0008', '大数据中心', '1', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('14', 'D0009', '人事行政部', '1', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('15', 'D0010', '财务中心', '1', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('16', 'D0011', '基地领导', '2', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('17', 'D0012', '仓配中心', '2', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('18', 'D0013', '运营中心', '2', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('19', 'D0014', '行政督导部', '2', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('20', 'D0015', '财务部', '2', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('21', 'D0016', '技术线', '8', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('22', 'D0017', '产品线', '8', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('23', 'D0018', '运维组', '21', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('24', 'D0019', 'ABAP组', '21', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('25', 'D0020', 'PHP组', '21', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('26', 'D0021', 'JAVA组', '21', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('27', 'D0022', 'web前端组', '21', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('28', 'D0023', '测试组', '22', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('29', 'D0024', 'ERP业务组', '22', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('30', 'D0025', '市场拓展组', '9', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('31', 'D0026', '文案策划组', '9', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('32', 'D0027', '平面设计组', '9', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('33', 'D0028', '招聘组', '14', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('34', 'D0029', '培训组', '14', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('35', 'D0030', '绩效组', '14', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('36', 'D0031', '薪酬组', '14', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('37', 'D0032', '员工关系组', '14', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('38', 'D0033', '行政组', '14', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('39', 'D0034', '入库组-四楼', '17', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('40', 'D0035', '内仓组-四楼', '17', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('41', 'D0036', '单据组', '17', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('42', 'D0037', '外仓组-四楼', '17', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('43', 'D0038', '维护组-四楼', '17', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('44', 'D0039', '招商业务组', '18', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('45', 'D0040', '运营服务组', '18', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('46', 'D0041', '系统服务组', '18', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('47', 'D0042', '聚客服组', '18', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('48', 'D0043', '人事组', '19', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('49', 'D0044', '投诉组', '19', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('50', 'D0045', '基地领导', '3', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('51', 'D0046', '行政组', '19', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('52', 'D0047', '仓配中心', '3', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('53', 'D0048', '运营中心', '3', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('54', 'D0049', '行政督导部', '3', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('55', 'D0050', '财务部', '3', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('56', 'D0051', '质检组', '52', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('57', 'D0052', '外仓组', '52', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('58', 'D0053', '单据组', '52', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('59', 'D0054', '内仓组', '52', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('60', 'D0055', '入库组', '52', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('61', 'D0056', '聚客服组', '53', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('62', 'D0057', '系统服务组', '53', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('63', 'D0058', '运营服务组', '53', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('64', 'D0059', '招商业务组', '53', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('65', 'D0060', '人事组', '54', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('66', 'D0061', '行政组', '54', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('67', 'D0062', '投诉组', '54', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('68', 'D0063', '基地领导', '4', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('69', 'D0064', '仓配中心', '4', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('70', 'D0065', '运营中心', '4', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('71', 'D0066', '行政督导部', '4', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('72', 'D0067', '财务部', '4', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('73', 'D0068', '财务部', '5', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('74', 'D0069', '行政督导部', '5', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('75', 'D0070', '运营中心', '5', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('76', 'D0071', '仓配中心', '5', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('77', 'D0072', '基地领导', '5', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('78', 'D0073', '人事组', '71', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('79', 'D0074', '行政组', '71', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('80', 'D0075', '投诉组', '71', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('81', 'D0076', '人事组', '74', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('82', 'D0077', '行政组', '74', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('83', 'D0078', '投诉组', '74', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('84', 'D0079', '聚客服组', '75', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('85', 'D0080', '系统服务组', '75', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('86', 'D0081', '运营服务组', '75', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('87', 'D0082', '招商业务组', '75', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('88', 'D0083', '质检组', '76', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('89', 'D0084', '外仓组', '76', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('90', 'D0085', '单据组', '76', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('91', 'D0086', '内仓组', '76', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('92', 'D0087', '入库组', '76', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('93', 'D0088', '质检组', '69', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('94', 'D0089', '外仓组', '69', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('95', 'D0090', '单据组', '69', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('96', 'D0091', '内仓组', '69', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('97', 'D0092', '入库组', '69', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('98', 'D0093', '聚客服组', '70', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('99', 'D0094', '系统服务组', '70', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('100', 'D0095', '运营服务组', '70', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('101', 'D0096', '招商业务组', '70', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('102', 'D0097', '输入法额特特', '83', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('103', 'D0098', '聚客服', '1', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('104', 'D0099', '入库组-五楼', '17', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('105', 'D0100', '内仓组-五楼', '17', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('106', 'D0101', '外仓组-五楼', '17', '2016-12-20 09:47:27', '2016-12-20 09:47:27');
INSERT INTO `base_department` VALUES ('107', 'D0102', '维护组-五楼', '17', '2016-12-20 09:47:27', '2016-12-20 09:47:27');

-- ----------------------------
-- Table structure for `base_supplier`
-- ----------------------------
DROP TABLE IF EXISTS `base_supplier`;
CREATE TABLE `base_supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商ID',
  `no` varchar(255) NOT NULL COMMENT '编号',
  `supplier_name` varchar(128) NOT NULL COMMENT '供应商名称',
  `country` varchar(64) DEFAULT NULL COMMENT '国家',
  `province` varchar(16) DEFAULT NULL COMMENT '省',
  `city` varchar(16) DEFAULT NULL COMMENT '市',
  `zip_code` char(6) DEFAULT NULL COMMENT '邮编',
  `telphone` varchar(16) NOT NULL COMMENT '电话',
  `fax` varchar(16) DEFAULT NULL COMMENT '传真号码',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `contact_name` varchar(16) NOT NULL COMMENT '联系人',
  `contact_job` varchar(64) DEFAULT NULL COMMENT '联系人职位',
  `contact_address` varchar(255) DEFAULT NULL COMMENT '联系人地址',
  `service` varchar(255) NOT NULL COMMENT '服务',
  `flag` int(6) NOT NULL DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_supplier
-- ----------------------------

-- ----------------------------
-- Table structure for `maintain`
-- ----------------------------
DROP TABLE IF EXISTS `maintain`;
CREATE TABLE `maintain` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) NOT NULL COMMENT '编号',
  `name` varchar(255) NOT NULL COMMENT '维护名称',
  `unit` varchar(5) DEFAULT NULL COMMENT '频率单位',
  `frequency` int(255) DEFAULT NULL COMMENT '频率',
  `daynum` int(255) DEFAULT NULL COMMENT '天数',
  `startdate` date NOT NULL,
  `enddate` date NOT NULL,
  `last_date` date DEFAULT NULL COMMENT '上次维护日期',
  `workday` int(255) DEFAULT NULL COMMENT '工作周期天',
  `p_id` int(255) DEFAULT NULL COMMENT '位置外键',
  `job_id` int(255) NOT NULL,
  `a_id` int(255) DEFAULT NULL COMMENT '资产外键',
  `workerorder_state_id` int(255) NOT NULL COMMENT '（外键）工单类型',
  `plan` int(6) DEFAULT NULL COMMENT '计划0/工单1',
  `flag` int(5) NOT NULL DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no` (`no`),
  KEY `as_id` (`a_id`),
  KEY `po_id` (`p_id`),
  KEY `job_id` (`job_id`),
  KEY `ows` (`workerorder_state_id`),
  CONSTRAINT `as_id` FOREIGN KEY (`a_id`) REFERENCES `assets` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_id` FOREIGN KEY (`job_id`) REFERENCES `sundry_job_class` (`id`),
  CONSTRAINT `ows` FOREIGN KEY (`workerorder_state_id`) REFERENCES `sundry_wokerorder_state` (`id`),
  CONSTRAINT `po_id` FOREIGN KEY (`p_id`) REFERENCES `position` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of maintain
-- ----------------------------
INSERT INTO `maintain` VALUES ('1', '000001', '124', '7', '56', '392', '2016-12-21', '2016-12-22', null, '1', '26', '1', '9', '4', '0', '1', '2016-12-21 10:30:48', '2016-12-21 10:30:48');
INSERT INTO `maintain` VALUES ('2', '000002', '123', null, null, null, '2016-12-21', '2016-12-30', null, '9', null, '1', '8', '3', '1', '1', '2016-12-21 11:47:21', '2016-12-21 14:10:54');
INSERT INTO `maintain` VALUES ('3', '000003', '123', null, null, null, '2016-12-09', '2016-12-21', null, '12', '27', '1', null, '3', '1', '1', '2016-12-21 11:47:53', '2016-12-22 17:09:13');
INSERT INTO `maintain` VALUES ('4', '000004', '456', null, null, null, '2016-12-17', '2016-12-22', '2016-12-21', '5', '26', '1', '9', '1', '0', '1', '2016-12-22 14:47:56', '2016-12-22 14:47:56');
INSERT INTO `maintain` VALUES ('16', '5411', '1655', null, null, '365', '2016-12-30', '2017-12-21', '2016-12-21', '356', null, '1', '8', '3', '1', '1', '2016-12-23 16:46:06', '2016-12-23 16:46:06');

-- ----------------------------
-- Table structure for `position`
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '位置ID',
  `no` varchar(255) NOT NULL,
  `d_id` int(11) NOT NULL COMMENT '部门ID',
  `position` varchar(64) NOT NULL COMMENT '位置描述',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `flag` varchar(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `d_id1` (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('25', 'ZJB-001', '7', '总经办001号', '总经办理', '2016-12-16 16:48:05', '2016-12-21 14:09:28', '1');
INSERT INTO `position` VALUES ('26', 'SCB-003', '7', '总经办002号', '总经办理', '2016-12-16 16:51:53', '2016-12-30 10:32:49', '0');
INSERT INTO `position` VALUES ('27', 'YYZX-001', '8', '技术部001号', '技术部', '2016-12-19 13:50:37', '2016-12-21 14:09:42', '1');

-- ----------------------------
-- Table structure for `recycle`
-- ----------------------------
DROP TABLE IF EXISTS `recycle`;
CREATE TABLE `recycle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_id` int(11) NOT NULL,
  `tb_name` varchar(255) NOT NULL,
  `operation` varchar(255) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `type` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recycle
-- ----------------------------
INSERT INTO `recycle` VALUES ('5', '26', 'position', '222', '2016-12-30 10:32:41', '位置');
INSERT INTO `recycle` VALUES ('6', '5', 'supplier', '222', '2016-12-30 11:43:41', '供应商');
INSERT INTO `recycle` VALUES ('7', '3', 'base_contractor', '333', '2017-01-03 10:41:42', '承包商');

-- ----------------------------
-- Table structure for `repair_list`
-- ----------------------------
DROP TABLE IF EXISTS `repair_list`;
CREATE TABLE `repair_list` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) NOT NULL,
  `workerorder_state_id` int(255) NOT NULL COMMENT '工单状态id',
  `worker_id` int(255) NOT NULL COMMENT '请求员工ID(外键)',
  `launchworker_id` int(255) NOT NULL COMMENT '发起员工(外键)',
  `workerorder_class_id` int(255) NOT NULL COMMENT '工单类型(外键)',
  `asset_id` int(255) NOT NULL COMMENT '资产ID（外键）',
  `level_id` int(255) DEFAULT NULL COMMENT '紧急程度(外键)',
  `finish_time` date NOT NULL COMMENT '完成日期',
  `real_finish_time` datetime DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `launch_time` datetime NOT NULL COMMENT '发起时间',
  `note` varchar(255) DEFAULT NULL COMMENT '问题描述',
  `flag` int(6) NOT NULL DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no` (`no`) USING HASH,
  KEY `re_workerorder_class_id` (`workerorder_class_id`),
  KEY `re_level_id` (`level_id`),
  KEY `re_asset_id` (`asset_id`),
  KEY `re_workerorderstatus_id` (`workerorder_state_id`),
  KEY `re_worker_id12` (`launchworker_id`),
  KEY `re_worker_id615` (`worker_id`),
  CONSTRAINT `re_asset_id` FOREIGN KEY (`asset_id`) REFERENCES `assets` (`id`),
  CONSTRAINT `re_level_id` FOREIGN KEY (`level_id`) REFERENCES `sundry_urgency_level` (`id`),
  CONSTRAINT `re_workerorder_class_id` FOREIGN KEY (`workerorder_class_id`) REFERENCES `sundry_wokerorder_class` (`id`),
  CONSTRAINT `re_workerorderstatus_id` FOREIGN KEY (`workerorder_state_id`) REFERENCES `sundry_wokerorder_state` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair_list
-- ----------------------------
INSERT INTO `repair_list` VALUES ('6', '1000001', '1', '30', '1', '2', '9', '2', '2016-12-16', null, '2016-12-29 15:43:28', '2016-12-16 13:58:04', '45615615165651516516651165156165', '1', '2016-12-16 13:59:52', '2016-12-28 17:22:27');
INSERT INTO `repair_list` VALUES ('7', '1000002', '7', '9', '154', '4', '9', '2', '2016-12-16', '2016-12-22 14:41:16', '2016-12-22 14:41:45', '2016-12-16 15:30:06', '234', '1', '2016-12-22 14:42:58', '2016-12-28 17:22:29');

-- ----------------------------
-- Table structure for `role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `role_authority`;
CREATE TABLE `role_authority` (
  `rid` int(6) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `aid` bigint(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`rid`,`aid`),
  KEY `authority_id` (`aid`),
  CONSTRAINT `authority_id` FOREIGN KEY (`aid`) REFERENCES `authority` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_authority
-- ----------------------------
INSERT INTO `role_authority` VALUES ('4', '26');
INSERT INTO `role_authority` VALUES ('4', '27');
INSERT INTO `role_authority` VALUES ('4', '31');
INSERT INTO `role_authority` VALUES ('4', '35');
INSERT INTO `role_authority` VALUES ('4', '54');
INSERT INTO `role_authority` VALUES ('4', '103');
INSERT INTO `role_authority` VALUES ('4', '104');

-- ----------------------------
-- Table structure for `sundry_assets_state`
-- ----------------------------
DROP TABLE IF EXISTS `sundry_assets_state`;
CREATE TABLE `sundry_assets_state` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `information` varchar(255) NOT NULL COMMENT '资产状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sundry_assets_state
-- ----------------------------
INSERT INTO `sundry_assets_state` VALUES ('2', '闲置');
INSERT INTO `sundry_assets_state` VALUES ('3', '报废');
INSERT INTO `sundry_assets_state` VALUES ('4', '入库');
INSERT INTO `sundry_assets_state` VALUES ('5', '丢失');
INSERT INTO `sundry_assets_state` VALUES ('7', '维修中');

-- ----------------------------
-- Table structure for `sundry_assets_way`
-- ----------------------------
DROP TABLE IF EXISTS `sundry_assets_way`;
CREATE TABLE `sundry_assets_way` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `information` varchar(255) NOT NULL COMMENT '资产保修方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sundry_assets_way
-- ----------------------------
INSERT INTO `sundry_assets_way` VALUES ('1', '无');
INSERT INTO `sundry_assets_way` VALUES ('2', '保修');
INSERT INTO `sundry_assets_way` VALUES ('6', '加急');

-- ----------------------------
-- Table structure for `sundry_job_class`
-- ----------------------------
DROP TABLE IF EXISTS `sundry_job_class`;
CREATE TABLE `sundry_job_class` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `information` varchar(255) NOT NULL COMMENT '工作类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sundry_job_class
-- ----------------------------
INSERT INTO `sundry_job_class` VALUES ('1', '打扫');

-- ----------------------------
-- Table structure for `sundry_job_priority`
-- ----------------------------
DROP TABLE IF EXISTS `sundry_job_priority`;
CREATE TABLE `sundry_job_priority` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `information` varchar(255) NOT NULL COMMENT '工作优先级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sundry_job_priority
-- ----------------------------
INSERT INTO `sundry_job_priority` VALUES ('1', '优先');

-- ----------------------------
-- Table structure for `sundry_urgency_level`
-- ----------------------------
DROP TABLE IF EXISTS `sundry_urgency_level`;
CREATE TABLE `sundry_urgency_level` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `information` varchar(255) NOT NULL COMMENT '紧急程度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sundry_urgency_level
-- ----------------------------
INSERT INTO `sundry_urgency_level` VALUES ('1', '普通');
INSERT INTO `sundry_urgency_level` VALUES ('2', '常规');

-- ----------------------------
-- Table structure for `sundry_wokerorder_class`
-- ----------------------------
DROP TABLE IF EXISTS `sundry_wokerorder_class`;
CREATE TABLE `sundry_wokerorder_class` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `information` varchar(255) NOT NULL COMMENT '工单类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sundry_wokerorder_class
-- ----------------------------
INSERT INTO `sundry_wokerorder_class` VALUES ('1', '完成');
INSERT INTO `sundry_wokerorder_class` VALUES ('2', 'bb');
INSERT INTO `sundry_wokerorder_class` VALUES ('3', 'cc');
INSERT INTO `sundry_wokerorder_class` VALUES ('4', 'dd');
INSERT INTO `sundry_wokerorder_class` VALUES ('5', 'ee');
INSERT INTO `sundry_wokerorder_class` VALUES ('6', 'ff');
INSERT INTO `sundry_wokerorder_class` VALUES ('8', 'hh');

-- ----------------------------
-- Table structure for `sundry_wokerorder_state`
-- ----------------------------
DROP TABLE IF EXISTS `sundry_wokerorder_state`;
CREATE TABLE `sundry_wokerorder_state` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `information` varchar(255) NOT NULL COMMENT '工单状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sundry_wokerorder_state
-- ----------------------------
INSERT INTO `sundry_wokerorder_state` VALUES ('1', '打开');
INSERT INTO `sundry_wokerorder_state` VALUES ('3', '取消');
INSERT INTO `sundry_wokerorder_state` VALUES ('4', '等待配件');
INSERT INTO `sundry_wokerorder_state` VALUES ('5', '等待审核');
INSERT INTO `sundry_wokerorder_state` VALUES ('6', '等待评估');
INSERT INTO `sundry_wokerorder_state` VALUES ('7', '完成');
INSERT INTO `sundry_wokerorder_state` VALUES ('8', '关闭');

-- ----------------------------
-- Table structure for `sundry_worker_class`
-- ----------------------------
DROP TABLE IF EXISTS `sundry_worker_class`;
CREATE TABLE `sundry_worker_class` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `information` varchar(255) NOT NULL COMMENT '员工类型',
  `c_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `e_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `enable` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sundry_worker_class
-- ----------------------------
INSERT INTO `sundry_worker_class` VALUES ('4', '大佬', '2016-12-16 10:58:27', '2016-12-16 10:58:27', '1');

-- ----------------------------
-- Table structure for `supplier`
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商ID',
  `no` varchar(255) NOT NULL COMMENT '编号',
  `supplier_name` varchar(128) NOT NULL COMMENT '供应商名称',
  `country` varchar(64) DEFAULT NULL COMMENT '国家',
  `province` varchar(16) DEFAULT NULL COMMENT '省',
  `city` varchar(16) DEFAULT NULL COMMENT '市',
  `zip_code` char(6) DEFAULT NULL COMMENT '邮编',
  `telphone` varchar(16) NOT NULL COMMENT '电话',
  `fax` varchar(16) DEFAULT NULL COMMENT '传真号码',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `contact_name` varchar(16) NOT NULL COMMENT '联系人',
  `contact_job` varchar(64) DEFAULT NULL COMMENT '联系人职位',
  `contact_address` varchar(255) DEFAULT NULL COMMENT '联系人地址',
  `service` varchar(255) NOT NULL COMMENT '服务',
  `flag` int(6) NOT NULL DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', '001', '哇哈哈有限公司', null, null, null, null, '454645613', null, 'qdwqwdd', '娃儿没', '没工作', 'ong', '提供哇哈哈行动', '1', '2016-10-18 17:08:00', '2016-12-06 13:32:33');
INSERT INTO `supplier` VALUES ('2', '002', '333', '444', '555', '777', '66', '888', '999', 'fffff', 'gggg', 'hhh', 'jjj', 'ddddd', '1', '2016-11-30 14:47:32', '2016-12-29 14:54:24');
INSERT INTO `supplier` VALUES ('3', '003', 'eeee', 'rrrr', 'www', 'qqqq', 'eee', 'dddd', null, 'yyyy', 'rrrr', 'tttt', 'eeeew', 'ffffff', '1', '2016-12-01 10:02:01', '2016-12-01 10:02:01');
INSERT INTO `supplier` VALUES ('5', '004', 'ww', '44444444', '555', '666', '33', '22222', null, '333', '11', '222', '444', 'ww', '0', '2016-12-01 10:06:40', '2016-12-01 11:00:33');
INSERT INTO `supplier` VALUES ('7', '006', '222', 'g', '44', 'd', 'df', 'h', null, 'eee', 'dfdf', 'rrr', 'sw', 'sa', '1', '2016-12-01 10:15:37', '2016-12-01 10:15:37');
INSERT INTO `supplier` VALUES ('8', '007', 'qqq', 'dad', '3', '4', 'as', 'asf', '', 'ads', 'ew', 'dsa', 'asdff', 'adsa', '1', '2016-12-01 10:17:22', '2016-12-01 14:19:56');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `c_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `u_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `menu_name` varchar(255) NOT NULL COMMENT '菜单名称',
  `menu_url` varchar(255) NOT NULL COMMENT '菜单url',
  `menu_img1` varchar(255) DEFAULT NULL,
  `menu_img2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '2016-12-19 13:53:29', '2016-12-19 13:59:11', '基础数据', '/basicDataList.html', null, null);
INSERT INTO `sys_menu` VALUES ('2', '2016-12-19 13:59:08', '2016-12-19 13:59:08', '位置', '/positionList.html', null, null);
INSERT INTO `sys_menu` VALUES ('3', '2016-12-19 14:00:53', '2016-12-19 14:00:53', '资产', '/assets.html', null, null);
INSERT INTO `sys_menu` VALUES ('4', '2016-12-19 14:01:34', '2016-12-19 14:01:34', '维护', '/maintain.html', null, null);
INSERT INTO `sys_menu` VALUES ('5', '2016-12-19 14:01:41', '2016-12-19 14:01:41', '维修', '/repairlist.html', null, null);
INSERT INTO `sys_menu` VALUES ('6', '2016-12-19 14:01:57', '2016-12-19 14:01:57', '工单', '/reportform.html', null, null);

-- ----------------------------
-- Table structure for `upload_file`
-- ----------------------------
DROP TABLE IF EXISTS `upload_file`;
CREATE TABLE `upload_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `operator_name` varchar(50) DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of upload_file
-- ----------------------------
INSERT INTO `upload_file` VALUES ('4', 'a.xlsx', 'D:\\workspeace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp3\\wtpwebapps\\asset\\file\\a.xlsx', '2016-12-23 11:33:03', '2016-12-23 11:33:03', null, '001');
INSERT INTO `upload_file` VALUES ('5', '早見沙織、東山奈央 - エブリデイワールド.mp3', 'D:\\workspeace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp3\\wtpwebapps\\asset\\file\\早見沙織、東山奈央 - エブリデイワールド.mp3', '2016-12-23 11:35:31', '2016-12-23 11:35:31', null, '002');

-- ----------------------------
-- Table structure for `user_authority`
-- ----------------------------
DROP TABLE IF EXISTS `user_authority`;
CREATE TABLE `user_authority` (
  `uid` int(11) NOT NULL COMMENT '用户id',
  `aid` bigint(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`uid`,`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_authority
-- ----------------------------
INSERT INTO `user_authority` VALUES ('167', '28');
INSERT INTO `user_authority` VALUES ('167', '30');
INSERT INTO `user_authority` VALUES ('167', '34');
INSERT INTO `user_authority` VALUES ('167', '36');
INSERT INTO `user_authority` VALUES ('167', '37');
INSERT INTO `user_authority` VALUES ('167', '53');
INSERT INTO `user_authority` VALUES ('167', '55');
INSERT INTO `user_authority` VALUES ('167', '105');
INSERT INTO `user_authority` VALUES ('167', '106');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` int(6) NOT NULL COMMENT '用户id',
  `rid` bigint(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`uid`,`rid`),
  KEY `rid` (`rid`),
  CONSTRAINT `wo_id` FOREIGN KEY (`uid`) REFERENCES `worker` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('167', '4');

-- ----------------------------
-- Table structure for `worker`
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `home_phone` varchar(255) DEFAULT NULL,
  `mobile_phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `p_id` (`p_id`),
  KEY `worker_class_id` (`c_id`),
  KEY `worker_ibfk_1` (`d_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES ('1', '管理员', '123', '13003699793', 'jhkhjkhjkjhk', '管理员', null, null, '27', null, '2016-12-28 16:57:35', '2016-12-28 16:57:35');
INSERT INTO `worker` VALUES ('2', '谢树济', '', '', null, '总经理', '', null, '27', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('3', '李国勉', '', '13641019592', null, '技术总监', 'ligm@xyb2c.com', null, '3', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('4', '刘清', '', '13396567055', null, '副总', 'liuqin@xyb2c.com', null, '86', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('5', '王杰', '', '13811126960', null, '常务副总', 'wangjie@xyb2c.com', null, '28', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('6', '卢荣荣', '', '15990044227', null, '总经办主任', 'lrr@xyb2c.com', null, '5', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('7', '周青芝', '', '18958091133', null, '常务副总', 'zhouqz@xyb2c.com', null, '31', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('8', '黄林（黄金珠）', '', '13735459368', null, '数据分析专员', 'bdtony@xyb2c.com', null, '82', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('9', '高远', '0571-87678370-8009', '13989487431', null, '总经理助理', 'gaoyuan@xyb2c.com', null, '5', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('10', '邵立斌', '', '13186992270', null, '网络管理员', 'shaolibin@xyb2c.com', null, '3', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('11', '吴佳', '', '15158161860', null, '人事主管', 'wujia@xyb2c.com', null, '23', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('13', '张婷', '', '13967121180', null, '网络运维助理', 'zhangting@xyb2c.com', null, '244', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('14', '方磊', '', '13806826388', null, '行政主管', 'fanglei@xyb2c.com', null, '32', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('15', '张端强', '', '18058759930', null, '副总', 'zhangdq@xyb2c.com', null, '31', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('19', '徐益芬', '', '13675856185', null, '单据组组长', 'xuyf@xyb2c.com', null, '95', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('20', '童海刚', '', '13758196451', null, '主管', 'tonghg@xyb2c.com', null, '172', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('22', '朱小虎', '18958026142', '13456745190', null, '招商业务部主管', 'zhuxh@xyb2c.com', null, '179', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('23', '崔文娟', '', '15079127805', null, '服务专员', 'cuiwj@xyb2c.com', null, '169', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('24', '赵梦瑶', '', '18867507934', null, '服务专员', 'zhaomy@xyb2c.com', null, '169', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('25', '王亚军', '1815140757', '18767169731', null, '业务组组长', 'wangyj@xyb2c.com', null, '198', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('26', '王文冉', '', '13456892755', null, '运营专员', 'wangwr@xyb2c.com', null, '7', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('30', '杨纯建', '', '18258415703', null, '网页设计师', 'yangcj@xyb2c.com', null, '3', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('32', '吕健', '', '15198953903', null, '云客服专员', 'lvj@xyb2c.com', null, '176', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('33', '陈晨', '', '15757188009', null, '云客服专员', 'chenc@xyb2c.com', null, '176', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('38', '胡尧', '', '15168256181', null, '云客服专员', 'hur@xyb2c.com', null, '176', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('39', '方鹏', '', '15188350613', null, '云客服专员', 'fangp@xyb2c.com', null, '176', null, '2016-12-21 14:36:03', '2016-12-21 14:36:03');
INSERT INTO `worker` VALUES ('42', '项增钢', '', '13750882228', null, '云客服主管', 'xiangzg@xyb2c.com', null, '176', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('44', '魏剑', '', '18258436370', null, '数据专员', 'weij@xyb2c.com', null, '82', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('46', '李芳', '', '13758151397', null, '出纳', 'lif@xyb2c.com', null, '72', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('50', '王元晨', '', '18658218617', null, '副总', 'wangyc@xyb2c.com', null, '61', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('51', '林陈簪', '', '15397012852', null, '业务专员', 'lincz@xyb2c.com', null, '179', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('53', '赵梓君', '', '18758311614', null, '程序管理员', 'zhaozj@xyb2c.com', null, '118', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('54', '罗学云', '18969141951', '18657180356', null, '业务专员', 'luoxy@xyb2c.com', null, '179', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('55', '代新虎', '18969141952', '18856101081', null, '业务专员', 'daixh@xyb2c.com', null, '179', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('56', '张文明', '', '15551201349', null, '业务专员', 'zhangwm@xyb2c.com', null, '33', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('57', '王旭岚', '', '18657475285', null, '人事行政主管', 'wangxl@xyb2c.com', null, '30', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('59', '郑凯睿', '', '15268105887', null, '业务主管', 'zhengkairui@jhszkq.com', null, '136', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('60', '朱高飞', '', '18806713331', null, '业务专员', 'zhugf@xyb2c.com', null, '179', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('61', '周诚晋', '', '15867149980', null, '业务专员', 'zhoucj@xyb2c.com', null, '179', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('62', '王康宁', '', '15729380090', null, '业务专员', 'wangkn@xyb2c.com', null, '179', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('63', '周晨', '', '18367189582', null, '人事专员', 'zhouchen@jhszkq.com', null, '98', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('66', '张勇', '', '15178502368', null, '主管', 'zhangy@xyb2c.com', null, '95', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('67', '周海霞', '', '18072747779', null, '云客服专员', 'zhouhx@xyb2c.com', null, '176', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('68', '汪媛媛', '', '15968198084', null, '服务专员', 'wangyuanyuan@jhszkq.com', null, '106', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('71', '周晓丽', '', '13221265588', null, '人事主管', 'zhouxiaoli@jhszkq.com', null, '98', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('72', '靖伟', '', '13646842495', null, 'Java开发工程师', 'jingwei@xyb2c.com', null, '3', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('73', '张鹏宇', '', '13285896609', null, '运营副主管', 'zhangpengyu@jhszkq.com', null, '103', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('74', '朱翠微', '', '13588103347', null, '行政人事副经理', 'zhucw@xyb2c.com', null, '23', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('75', '马玲', '', '18969966354', null, '技术支持', 'maling@xyb2c.com', null, '198', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('76', '王锐', '', '13566779008', null, '仓储中心主管', 'wangrui@jhszkq.com', null, '102', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('78', '柳秀宝', '', '13600629284', null, '保洁阿姨', '', null, '141', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('79', '徐航海', '', '18768137934', null, 'Java开发工程师', 'xuhh@xyb2c.com', null, '3', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('80', '吴学谦', '', '15058523366', null, '网络管理员', 'wuxueqian@jhszkq.com', null, '98', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('81', '章加波', '', '18957146037', null, 'PHP开发工程师', 'zhangjb@xyb2c.com', null, '3', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('82', '陈铭', '', '18268268735', null, 'Java开发工程师', 'chenming@xyb2c.com', null, '3', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('83', '张小龙', '', '13003699793', null, 'PHP开发工程师', 'zhangxl@xyb2c.com', null, '3', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('85', '钟莉倩', '', '18857993215', null, '仓配中心员工', 'zhongliqian@jhszkq.com', null, '28', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('86', '徐志宁', '', '18767969057', null, '业务组长', 'xuzhining@jhszkq.com', null, '136', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('87', '冯龙飞', '', '15088200792', null, '业务组长', 'fenglongfei@jhszkq.com', null, '136', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('88', '吴霞', '', '15058516793', null, '仓配中心员工', 'wuxia@jhszkq.com', null, '28', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('91', '郑江源', '', '13735673561', null, '业务主管', 'zhengjiangyuan@jhszkq.com', null, '136', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('93', '晏丽华', '', '13857448190', null, '运营中心主管', 'yanlh@xyb2c.com', null, '111', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('94', '赵俊', '', '15067078469', null, '仓库组长', 'zhaojun@jhszkq.com', null, '28', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('95', '宗文涛', '', '15058502624', null, 'E店宝系统维护', 'zongwentao@jhszkq.com', null, '28', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('100', '张学斌', '', '13424363900', null, '运营中心副主管', '', null, '111', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('101', '郑爱宏', '', '13735699632', null, '出纳', 'zhengaihong@jhszkq.com', null, '216', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('102', '郑凯璐', '', '', null, '园区前台', '', null, '119', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('103', '于增利', '', '13735668189', null, '仓库组长', 'yuzengli@jhszkq.com', null, '28', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('105', '阮梦彬', '', '13248662898', null, '系统维护专员', '447552593@qq.com', null, '115', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('107', '黄婕', '', '18257018697', null, '结算员', 'huangjie@jhszkq.com', null, '216', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('108', '许珊', '', '15858138429', null, 'Web前端开发', 'xus@xyb2c.com', null, '3', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('111', '姚一飞', '', '18657245395', null, '资深策划', 'yaoyf@xyb2c.com', null, '244', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('113', '孙玲玉', '', '15851254259', null, '业务服务专员', 'sunly@xyb2c.com', null, '117', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('116', '林阳晴', '', '15990020798', null, '市场部总监', 'linyq@xyb2c.com', null, '7', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('121', '向明园', '', '1356635977', null, '业务服务专员', 'xiangmy@xyb2c.com', null, '111', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('123', '方晓艺', '', '15867946499', null, '仓库客服', 'fangxiaoyi@jhszkq.com', null, '28', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('124', '刘冬玲', '', '15888811662', null, '平面设计师', 'liudl@xyb2c.com', null, '7', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('125', '黄伟丽', '', '15868459825', null, 'Abap开发工程师', 'huangwl@xyb2c.com', null, '3', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('126', '董伟强', '', '15167943102', null, '业务专员', 'dongweiqiang@jhszkq.com', null, '136', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('129', '方聪聪', '', '15268635025', null, '业务专员', 'fangcongcong@jhszkq.com', null, '136', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('132', '王浩', '', '13155544487', null, '业务顾问', 'wanghao@xyb2c.com', null, '198', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('133', '章增华', '', '13958482411', null, '仓库组长', 'zhangzenghua@jhszkq.com', null, '28', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('136', '王建春', '', '18258947998', null, '业务专员', 'wangjianchun@jhszkq.com', null, '28', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('138', '周培杰', '', '13116672171', null, '业务服务专员', '', null, '117', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('146', '黄均香', '', '15967150263', null, '项目主管', 'huangjx@xyb2c.com', null, '7', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('149', '朱丹妮', '', '15168209159', null, '服务专员', '', null, '103', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('150', '齐康然', '', '18966490306', null, 'Java开发工程师', 'qikr@xyb2c.com', null, '3', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('153', '马鑫本', '', '13777937497', null, '仓配中心主管', 'maxb@xyb2c.com', null, '110', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('154', '朱志峰', '', '18357174498', null, 'Java开发工程师', 'zhuzf@xyb2c.com', null, '3', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('156', '郭士松', '', '13486391963', null, '副总', 'guoss@xyb2c.com', null, '31', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('157', '余锦希', '', '15219584004', null, '系统客服', '', null, '116', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('158', '李春', '', '13586996472', null, '业务专员', '', null, '136', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('159', '林浩', '', '15580570778', null, 'Java开发工程师', 'linh@xyb2c.com', null, '3', null, '2016-12-21 14:36:04', '2016-12-21 14:36:04');
INSERT INTO `worker` VALUES ('160', '黄欢', '', '13967897090', null, '出纳', '', null, '217', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('163', '盛红', '', '13566009477', null, '会计', '', null, '217', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('164', '杨成', '', '15991156916', null, '工程监理', 'yangc@xyb2c.com', null, '7', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('167', '陈浩', '', '15394278513', null, 'Java开发工程师', 'chenhao@xyb2c.com', null, '3', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('168', '桂敏瑞', '', '18757556388', null, 'Java开发工程师', '1251640657@qq.com', null, '3', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('169', '方水刚', '', '13750923902', null, '业务副总', 'fangshuigang@jhszkq.com', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('174', '李旭强', '', '13958463582', null, '业务专员', '', null, '136', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('181', '王莉', '', '13738036157', null, '技术助理', 'wangl@xyb2c.com', null, '3', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('184', '陈胜', '', '15905899287', null, '仓配中心员工', 'chensheng@jhszkq.com', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('185', '张连英', '', '13857985793', null, '仓配中心员工', 'zhanglianying@jhszkq.com', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('186', '项智强', '', '15868995930', null, '副主管', 'xiangzhiqiang@jhszkq.com', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('187', '翁甜', '', '15267302559', null, '业务专员', 'wengtian@jhszkq.com', null, '103', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('191', '祝群超', '13372418752', '15988422401', null, '人事副主管', 'zhuqc@xyb2c.com', null, '90', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('192', '金孝聪', '', '18329066152', null, '业务专员', '', null, '137', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('195', '赵磊', '', '13028981470', null, '业务服务专员', '', null, '117', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('196', '李来军', '', '15356061025', null, '云客服中心主管', 'rock', null, '112', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('197', '梁兴鹏', '', '18358240091', null, '仓配中心员工', '', null, '116', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('198', '范慕昕', '', '15882199497', null, '仓配中心员工', '', null, '116', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('199', '陈美琳', '', '13868944841', null, '业务专员', '', null, '103', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('201', '林阳晴', '', '', null, '总经理助理', 'linyq@xyb2c.com', null, '5', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('202', '金一伟', '', '13165949986', null, '副总', 'jinyw@xyb2c.com', null, '61', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('203', '巴津阳子', '', '18395970119', null, '人事专员', 'bajinyangzi@jhszkq.com', null, '98', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('204', '黄超德', '', '13586945743', null, '仓配中心员工', '', null, '116', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('206', '王惠', '', '13819812182', null, '仓配中心员工', '', null, '116', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('207', '肖文兰', '', '13600626646', null, '仓配中心员工', '', null, '116', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('208', '黄凯', '', '13116673021', null, '仓配中心员工', '', null, '116', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('209', '黎银银', '', '18094740152', null, '仓配中心员工', '', null, '116', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('210', '俞志萍', '', '15558376918', null, '仓配中心员工', '', null, '116', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('211', '胡天逸', '', '15888581621', null, '仓配中心员工', '', null, '116', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('212', '屠磊', '', '13989301669', null, '仓配中心员工', '', null, '116', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('216', '章肖尹', '', '15888929186', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('217', '项燕', '', '18358031696', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('219', '傅明雅', '', '13515796140', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('220', '陈旭聪', '', '18657996079', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('222', '吴淼燕', '', '15858178547', null, '资深运营', 'wuxy@xyb2c.com', null, '7', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('223', '江浩', '', '13586995161', null, '仓配中心员工', 'http://mail.hichina.com/alimail/auth/login?custom_', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('224', '金晓鹏', '', '15057839292', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('225', '陈美婵', '', '13967975061', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('226', '余芬', '', '13967485983', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('227', '徐佳恒', '', '18266963603', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('228', '潘春灿', '', '18257962642', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('229', '祝向阳', '', '15058526892', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('231', '伊康俊', '', '18967408079', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('232', '赵小梅', '', '13857996203', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('233', '叶宇杰', '', '13646898574', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('234', '秦振群', '', '15058522320', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('236', '姜日成', '', '13516954807', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('237', '周旭峰', '', '15067592886', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('238', '吴江', '', '15558689518', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('239', '潘恒军', '', '15057830710', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('240', '包松军', '', '15167856247', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('241', '钱静', '', '15088205677', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('242', '王燕', '', '18768596310', null, '业务服务专员', '', null, '117', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('243', '陈洁', '', '13666686265', null, '资深运营', 'chenjie@xyb2c.com', null, '7', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('245', '林晓琴', '', '13566776317', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('247', '周看成', '', '15867949859', null, '业务专员', '', null, '136', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('248', '王迪', '', '18696155981', null, 'PHP开发工程师', 'wangdi@xyb2c.com', null, '3', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('249', '陆慧', '', '15906894064', null, '业务专员', '', null, '103', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('250', '李思韵', '', '13588703671', null, '行政专员', '', null, '103', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('251', '姜哲', '', '15669031153', null, '云客服专员', '', null, '104', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('252', '嵇敏燕', '', '13968084004', null, '数据分析专员', 'jimy@xyb2c.com', null, '21', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('253', '王坤建', '', '15988404864', null, '软件测试员', 'wangkj@xyb2c.com', null, '199', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('254', '周青芝', '', '', null, '数据部经理', '', null, '21', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('255', '刘勇', '', '18329059772', null, '云客服专员', 'liuyong@xyb2c.com', null, '176', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('256', '陈琳', '', '13216226692', null, '运营专员', '956749413@qq.com', null, '103', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('257', '官昭郡', '', '13959290047', null, '云客服专员', '', null, '104', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('258', '徐涨波', '', '13750855594', null, '美工', 'xuzb@xyb2c.com', null, '7', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('259', '朱文刚', '无', '18657909092', null, '云客服专员', '449362588@qq.com', null, '104', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('260', '彭梦洁', '', '13260595215', null, '部门助理', 'pengmj@xyb2c.com', null, '244', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('263', '叶一群', '', '15988599813', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('264', '杜欣华', '', '13923819657', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('266', '戴雪芳', '', '15067061237', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:05', '2016-12-21 14:36:05');
INSERT INTO `worker` VALUES ('267', '陈晓俊', '', '15058513215', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('268', '周俊', '', '13588816123', null, '副总经理助理', 'zhoujun@xyb2c.com', null, '246', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('269', '平平', '', '15267304460', null, '行政专员', '', null, '103', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('270', '胡雪丹', '', '15157929570', null, '服务专员', '', null, '103', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('271', '陈志有', '', '18858902623', null, '仓配中心员工', '', null, '28', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('272', '胡庭', '', '15325884945', null, '产品经理', 'huting@xyb2c.com', null, '197', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('274', '杨云丹', '', '15058515818', null, '云客服专员', '240540111@qq.com', null, '104', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('275', '金淑珍', '27879615', '13456158518', null, '行政专员', '3175038410@qq.com', null, '113', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('276', '邓茜', '', '15559136689', null, '云客服专员', '284893121@qq.com', null, '120', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('277', '王一科', '', '18967877594', null, '云客服专员', '', null, '120', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('280', '陈涛', '', '18867921578', null, '业务专员', '', null, '136', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('282', '虞慧芳', '', '18367315035', null, '软件测试员', 'yuhf@xyb2c.com', null, '199', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('283', '刘冰', '', '18712129552', null, '入库组组长', 'liub@xyb2c.com', null, '95', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('284', '陈国芝', '', '18758135456', null, '外仓组组长', 'chengz@xyb2c.com', null, '95', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('289', '孟慧', '', '18768485605', null, '人事专员', '', null, '90', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('290', '江德平', '', '15990446765', null, '网络管理员', '315020273@qq.com', null, '32', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('291', '庞志华', '', '13634220143', null, '外仓组组长', 'pangzh@xyb2c.com', null, '172', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('293', '鲍建阳', '', '15268621813', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('294', '黄起超', '', '18267917526', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('295', '王俊', '', '', null, '仓配中心副主管', 'wangjun@xyb2c.com', null, '60', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('296', '王利平', '', '18960505360', null, '内仓组组长', 'zhuqc@xyb2c.com', null, '172', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('297', '曾建春', '', '', null, '财务经理', '', null, '8', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('298', '刘佳玲', '', '13735690557', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('299', '汪国芳', '', '13757979491', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('300', '张丽淋', '', '15067063392', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('301', '王钢', '', '13735798575', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('302', '钱根明', '', '18368649060', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('303', '李新昌', '', '13185199567', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('305', '余文霞', '', '15067073103', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('306', '张俊炜', '', '18757809425', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('307', '周日成', '', '15267940002', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('308', '钱小雄', '', '15958994591', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('309', '傅直华', '', '15990620842', null, '云客服专员', '86924822@qq.com', null, '104', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('310', '江晨昱', '', '13967478512', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('311', '陈顺金', '', '13967443929', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('313', '陈都凌', '', '15168334734', null, '商家顾问', 'chendl@xyb2c.com', null, '169', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('316', '刘持增', '', '18357987890', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('317', '戴淑珍', '', '13157935178', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('318', '李秋苗', '', '13957954722', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('319', '沈旭亮', '', '15258994985', null, '云客服专员', '', null, '104', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('320', '肖玉梅', '', '13867910438', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('321', '郭帅杰', '', '', null, '云客服专员', '', null, '176', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('323', '谢江', '', '13215590761', null, '云客服专员', '', null, '176', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('327', '薛子明', '', '15201900015', null, '物流经理', 'xuezm@xyb2c.com', null, '60', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('328', '卢伟伟', '', '18868892903', null, '出纳', 'luww@xyb2c.com', null, '216', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('329', '周俊', '', '11111111111', null, '运营经理', '', null, '169', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('330', '张端强', '', '1111111', null, '副总', '', null, '60', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('331', '陈勇', '', '15858110190', null, '行政人事经理', '', null, '23', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('332', '金燕红', '', '15158192432', null, '总部会计', 'jinyh@xyb2c.com', null, '8', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('333', '秦志林', '', '13335965037', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('336', '楼妙兰', '', '15058515750', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('337', '陈子琴', '', '18395977102', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('338', '李凤娥', '', '13486967716', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('339', '吕建平', '', '13957964237', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('341', '卿华', '', '13372524101', null, '服务专员', '', null, '169', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('343', '柳宁', '', '13216602083', null, '仓配中心员工', '', null, '116', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('344', '翁晓科', '', '15158117356', null, '会计', 'wenxk@xyb2c.com', null, '175', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('345', '孙环', '', '18110830612', null, '业务专员', 'sunh@xyb2c.com', null, '179', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('346', '孙小春', '18969148185', '15967105256', null, '业务专员', 'sunxc@xyb2c.com', null, '179', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('347', '石樱', '', '13626746749', null, '人事主管', '', null, '30', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('349', '金川', '', '15088268310', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('350', '侍崇科', '', '13967477835', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('352', '陈红', '', '13750819382', null, '行政专员', '', null, '98', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('353', '方向正', '', '15325967237', null, '云客服专员', '', null, '104', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('357', '俞君', '', '15905890282', null, '客服', '', null, '104', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('358', '王茹', '', '18297953353', null, '投诉专员', '', null, '98', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('359', '马萌', '', '13429079557', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('363', '陈钇成', '', '13757849501', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('364', '金丽晓', '', '18505797396', null, '仓配中心制单', '', null, '102', null, '2016-12-21 14:36:06', '2016-12-21 14:36:06');
INSERT INTO `worker` VALUES ('365', '郑荣林', '', '13819976489', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('366', '包程', '', '15068046631', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('367', '华金虎', '', '13957983835', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('368', '黄建英', '', '15167955731', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('369', '邵凯瑞', '', '13735732961', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('370', '高彩奶', '', '13655795748', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('371', '熊琼', '', '18267915570', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('372', '李冬林', '', '13967449945', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('373', '季慧', '', '13758967880', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('374', '朱丽惠', '', '13857980244', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('375', '陈丽琴', '', '15957924882', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('376', '陆芳娟', '', '15958960874', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('377', '黄巧萍', '', '18395967913', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('379', '刘琴', '', '18258997547', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('380', '李亭江', '', '18868595571', null, '仓配中心员工', '', null, '102', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('381', '周颖', '', '18271849292', null, '行政前台', 'zhouying@xyb2c.com', null, '23', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('382', '堵静云', '', '13456711121', null, '人事专员', '', null, '23', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('383', '李婷婷', '', '15990058105', null, '运营专员', '', null, '106', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('384', '吴鸿洲', '', '13754327370', null, '业务专员', '', null, '179', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('389', '汪青青', '0574-27875939', '18657431361', null, '出纳', 'wangqq@xyb2c.com', null, '217', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('390', '林晶晶', '', '15858180201', null, '行政前台', 'linjj@xyb2c.com', null, '43', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('391', '周立斌', '', '13626598909', null, '云客服专员', 'zhoulb@xyb2c.com', null, '215', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('392', '周士贵', '85004814', '13735895466', null, '客服专员', 'zhousg@xyb2c.com', null, '215', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('393', '黄群', '', '18967563275', null, '运营助理', '', null, '103', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('394', '黄瑞桓', '', '15088759164', null, '资深运营', 'huangrh@xyb2c.com', null, '7', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('395', '徐云云', '', '13291580804', null, '运营专员', '', null, '103', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('396', '沈伟楠', '', '13958042879', null, '客服专员', 'shenwn@xyb2c.com', null, '215', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('397', '许玉娟', '', '18021643610', null, 'sap开发专员', 'xuyj@xyb2c.com', null, '3', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('398', '黄天成', '', '18046724338', null, '客服专员', 'huangtc@xyb2c.com', null, '176', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('399', '邹群鑫', '', '18395999619', null, '客服专员', 'zouqx@xyb2c.com', null, '176', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('400', '吴南南', '', '15381161418', null, '招商主管', 'wunn@xyb2c.com', null, '179', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('401', '黄尚德', '', '15356575413', null, '销售数据分析专员', 'huangsd@xyb2c.com', null, '246', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('402', '黄前前', '', '15068856590', null, '淘宝客服实习生', 'huangqq@xyb2c.com', null, '215', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('403', '岑细列', '', '18386635091', null, '客服专员', 'cenxl@xyb2c.com', null, '215', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('404', '汤瑜', '', '18770819186', null, '客服专员', 'tangy@xyb2c.com', null, '215', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('405', '胡志明', '', '13761989340', null, '客服专员', 'huzm@xyb2c.com', null, '215', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');
INSERT INTO `worker` VALUES ('406', '程妹珍', '', '18868520117', null, '云客服', '', null, '104', null, '2016-12-21 14:36:07', '2016-12-21 14:36:07');

-- ----------------------------
-- Table structure for `新版oa的部门架构`
-- ----------------------------
DROP TABLE IF EXISTS `新版oa的部门架构`;
CREATE TABLE `新版oa的部门架构` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '父级ID',
  `dept_no` varchar(20) NOT NULL DEFAULT '' COMMENT '部门编号',
  `dept_grade_id` int(11) NOT NULL DEFAULT '0' COMMENT '部门等级ID',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `short` varchar(20) NOT NULL DEFAULT '' COMMENT '简称',
  `sort` varchar(20) NOT NULL DEFAULT '' COMMENT '排序',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `is_del` tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `is_use` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 新版oa的部门架构
-- ----------------------------
INSERT INTO `新版oa的部门架构` VALUES ('1', '0', '', '0', '集团总部', '', '1', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('2', '0', '', '0', '杭州基地', '', '2', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('3', '0', '', '0', '金华基地', '', '3', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('4', '0', '', '0', '宁波基地', '', '4', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('5', '0', '', '0', '嘉兴基地', '', '5', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('6', '1', 'D0001', '0', '公司领导', '', '1', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('7', '1', 'D0002', '0', '总经办', '', '2', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('8', '1', 'D0003', '0', '技术部', '', '4', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('9', '1', 'D0004', '0', '市场部', '', '5', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('10', '1', 'D0005', '0', '招商部', '', '7', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('11', '1', 'D0006', '0', '仓配物流部', '', '8', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('12', '1', 'D0007', '0', '法务部', '', '9', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('13', '1', 'D0008', '0', '大数据中心', '', '9', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('14', '1', 'D0009', '0', '人事行政部', '', '3', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('15', '1', 'D0010', '0', '财务中心', '', '6', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('16', '2', 'D0011', '0', '基地领导', '', '1', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('17', '2', 'D0012', '0', '仓配中心', '', '2', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('18', '2', 'D0013', '0', '运营中心', '', '3', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('19', '2', 'D0014', '0', '行政督导部', '', '4', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('20', '2', 'D0015', '0', '财务部', '', '5', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('21', '8', 'D0016', '0', '技术线', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('22', '8', 'D0017', '0', '产品线', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('23', '21', 'D0018', '0', '运维组', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('24', '21', 'D0019', '0', 'ABAP组', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('25', '21', 'D0020', '0', 'PHP组', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('26', '21', 'D0021', '0', 'JAVA组', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('27', '21', 'D0022', '0', 'web前端组', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('28', '22', 'D0023', '0', '测试组', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('29', '22', 'D0024', '0', 'ERP业务组', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('30', '9', 'D0025', '0', '市场拓展组', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('31', '9', 'D0026', '0', '文案策划组', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('32', '9', 'D0027', '0', '平面设计组', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('33', '14', 'D0028', '0', '招聘组', '', '1', '', '1', '1');
INSERT INTO `新版oa的部门架构` VALUES ('34', '14', 'D0029', '0', '培训组', '', '3', '', '1', '1');
INSERT INTO `新版oa的部门架构` VALUES ('35', '14', 'D0030', '0', '绩效组', '', '4', '', '1', '1');
INSERT INTO `新版oa的部门架构` VALUES ('36', '14', 'D0031', '0', '薪酬组', '', '2', '', '1', '1');
INSERT INTO `新版oa的部门架构` VALUES ('37', '14', 'D0032', '0', '员工关系组', '', '5', '', '1', '1');
INSERT INTO `新版oa的部门架构` VALUES ('38', '14', 'D0033', '0', '行政组', '', '6', '', '1', '1');
INSERT INTO `新版oa的部门架构` VALUES ('39', '17', 'D0034', '0', '入库组-四楼', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('40', '17', 'D0035', '0', '内仓组-四楼', '', '4', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('41', '17', 'D0036', '0', '单据组', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('42', '17', 'D0037', '0', '外仓组-四楼', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('43', '17', 'D0038', '0', '维护组-四楼', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('44', '18', 'D0039', '0', '招商业务组', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('45', '18', 'D0040', '0', '运营服务组', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('46', '18', 'D0041', '0', '系统服务组', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('47', '18', 'D0042', '0', '聚客服组', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('48', '19', 'D0043', '0', '人事组', '', '1', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('49', '19', 'D0044', '0', '投诉组', '', '3', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('50', '3', 'D0045', '0', '基地领导', '', '1', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('51', '19', 'D0046', '0', '行政组', '', '2', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('52', '3', 'D0047', '0', '仓配中心', '', '2', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('53', '3', 'D0048', '0', '运营中心', '', '3', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('54', '3', 'D0049', '0', '行政督导部', '', '4', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('55', '3', 'D0050', '0', '财务部', '', '5', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('56', '52', 'D0051', '0', '质检组', '', '1', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('57', '52', 'D0052', '0', '外仓组', '', '2', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('58', '52', 'D0053', '0', '单据组', '', '3', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('59', '52', 'D0054', '0', '内仓组', '', '4', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('60', '52', 'D0055', '0', '入库组', '', '5', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('61', '53', 'D0056', '0', '聚客服组', '', '1', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('62', '53', 'D0057', '0', '系统服务组', '', '2', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('63', '53', 'D0058', '0', '运营服务组', '', '3', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('64', '53', 'D0059', '0', '招商业务组', '', '4', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('65', '54', 'D0060', '0', '人事组', '', '1', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('66', '54', 'D0061', '0', '行政组', '', '2', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('67', '54', 'D0062', '0', '投诉组', '', '3', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('68', '4', 'D0063', '0', '基地领导', '', '1', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('69', '4', 'D0064', '0', '仓配中心', '', '2', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('70', '4', 'D0065', '0', '运营中心', '', '3', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('71', '4', 'D0066', '0', '行政督导部', '', '4', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('72', '4', 'D0067', '0', '财务部', '', '5', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('73', '5', 'D0068', '0', '财务部', '', '5', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('74', '5', 'D0069', '0', '行政督导部', '', '4', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('75', '5', 'D0070', '0', '运营中心', '', '3', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('76', '5', 'D0071', '0', '仓配中心', '', '2', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('77', '5', 'D0072', '0', '基地领导', '', '1', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('78', '71', 'D0073', '0', '人事组', '', '1', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('79', '71', 'D0074', '0', '行政组', '', '2', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('80', '71', 'D0075', '0', '投诉组', '', '3', '', '1', '1');
INSERT INTO `新版oa的部门架构` VALUES ('81', '74', 'D0076', '0', '人事组', '', '1', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('82', '74', 'D0077', '0', '行政组', '', '2', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('83', '74', 'D0078', '0', '投诉组', '', '3', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('84', '75', 'D0079', '0', '聚客服组', '', '1', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('85', '75', 'D0080', '0', '系统服务组', '', '2', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('86', '75', 'D0081', '0', '运营服务组', '', '3', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('87', '75', 'D0082', '0', '招商业务组', '', '4', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('88', '76', 'D0083', '0', '质检组', '', '1', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('89', '76', 'D0084', '0', '外仓组', '', '2', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('90', '76', 'D0085', '0', '单据组', '', '3', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('91', '76', 'D0086', '0', '内仓组', '', '4', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('92', '76', 'D0087', '0', '入库组', '', '5', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('93', '69', 'D0088', '0', '质检组', '', '1', '', '1', '1');
INSERT INTO `新版oa的部门架构` VALUES ('94', '69', 'D0089', '0', '外仓组', '', '2', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('95', '69', 'D0090', '0', '单据组', '', '3', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('96', '69', 'D0091', '0', '内仓组', '', '4', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('97', '69', 'D0092', '0', '入库组', '', '5', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('98', '70', 'D0093', '0', '聚客服组', '', '1', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('99', '70', 'D0094', '0', '系统服务组', '', '2', '', '1', '1');
INSERT INTO `新版oa的部门架构` VALUES ('100', '70', 'D0095', '0', '运营服务组', '', '3', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('101', '70', 'D0096', '0', '招商业务组', '', '4', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('102', '83', 'D0097', '1', '输入法额特特', '', '1', '', '1', '1');
INSERT INTO `新版oa的部门架构` VALUES ('103', '1', 'D0098', '1', '聚客服', '', '91', '', '0', '0');
INSERT INTO `新版oa的部门架构` VALUES ('104', '17', 'D0099', '1', '入库组-五楼', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('105', '17', 'D0100', '1', '内仓组-五楼', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('106', '17', 'D0101', '1', '外仓组-五楼', '', '', '', '0', '1');
INSERT INTO `新版oa的部门架构` VALUES ('107', '17', 'D0102', '1', '维护组-五楼', '', '', '', '0', '1');
