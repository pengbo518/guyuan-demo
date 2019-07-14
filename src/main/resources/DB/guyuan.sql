/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : guyuan

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2019-07-14 16:36:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_repair
-- ----------------------------
DROP TABLE IF EXISTS `tb_repair`;
CREATE TABLE `tb_repair` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `deleted` bit(1) DEFAULT b'0' COMMENT '是否删除；0-未删除；1-已删除',
  `gmt_created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  `attributes` varchar(255) DEFAULT NULL COMMENT '扩展字段',
  `user_id` bigint(20) DEFAULT NULL COMMENT '外键，用户id',
  `type` varchar(255) DEFAULT NULL COMMENT '报修类型',
  `remark` varchar(255) DEFAULT NULL COMMENT '报修原因',
  `status` int(10) DEFAULT '0' COMMENT '报修流转状态：0-申请中，1-审批通过，2-存档',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_repair
-- ----------------------------

-- ----------------------------
-- Table structure for tb_repair_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_repair_type`;
CREATE TABLE `tb_repair_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` int(10) DEFAULT NULL COMMENT '报修类型',
  `name` varchar(255) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_repair_type
-- ----------------------------
INSERT INTO `tb_repair_type` VALUES ('1', '1', '报修类型一');
INSERT INTO `tb_repair_type` VALUES ('2', '2', '报修类型二');
INSERT INTO `tb_repair_type` VALUES ('3', '3', '保修类型三');
INSERT INTO `tb_repair_type` VALUES ('4', '4', '保修类型四');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `deleted` bit(1) DEFAULT b'0' COMMENT '是否删除；默认0-未删除，1-删除',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  `attributes` varchar(255) DEFAULT NULL COMMENT '扩展字段',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号（账号）',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `type` int(10) DEFAULT '0' COMMENT '用户类型；0-用户，1-管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
