/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50515
 Source Host           : localhost:3306
 Source Schema         : appointment

 Target Server Type    : MySQL
 Target Server Version : 50515
 File Encoding         : 65001

 Date: 27/03/2020 19:34:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_time
-- ----------------------------
DROP TABLE IF EXISTS `tb_time`;
CREATE TABLE `tb_time`  (
  `tid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表主键',
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户主键',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预约地点',
  `starttime` datetime NOT NULL COMMENT '开始时间',
  `endtime` datetime NOT NULL COMMENT '结束时间',
  `schedule` int(1) NULL DEFAULT NULL COMMENT '是否被预约，0表示没有，1表示有',
  `schedule_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预约用户ID',
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预约描述',
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_time
-- ----------------------------
INSERT INTO `tb_time` VALUES ('2C47F8D3749A44AD92D53817C50BF597', '3AF3A383261D408982B48C4DC20F05C4', '教授profession', '2020-03-27 08:00:00', '2020-03-27 09:00:00', 1, 'C673463130E4421FBC636EF79B93B93C', '心理咨询');
INSERT INTO `tb_time` VALUES ('4BDE43619FE84278908B319D80708E92', 'B8B6F64FE6EB4971BF7138ECE6104F83', '教师teacher001', '2020-03-28 10:00:00', '2020-03-28 10:30:00', 1, '617F020038014F17A09491F0FA775DCD', '晓得撒范德萨');
INSERT INTO `tb_time` VALUES ('8CA64B6EE0164BE08F142ECAAE7D4B05', '0260F2453B364BAFBB68C72BA950DB58', '测试修改', '2020-03-27 08:00:00', '2020-03-27 08:30:00', 1, '617F020038014F17A09491F0FA775DCD', '有点事');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表主键，用户主键',
  `user_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账户，为手机号码',
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `user_age` int(3) NOT NULL COMMENT '用户年龄',
  `user_sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户性别',
  `user_position` int(1) NOT NULL COMMENT '用户职位：0学生，1老师，2教授，3校长',
  `checked` int(1) NULL DEFAULT NULL COMMENT '用户审核：校长审核教师用户，0表是未审核，1表示已审核',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('0260F2453B364BAFBB68C72BA950DB58', 'admin', 'admin', 'jack', 18, '男', 3, 0);
INSERT INTO `tb_user` VALUES ('3AF3A383261D408982B48C4DC20F05C4', 'profession001', '123456', 'Brown', 34, '男', 2, 1);
INSERT INTO `tb_user` VALUES ('617F020038014F17A09491F0FA775DCD', 'student002', '123456', '小红', 18, '男', 0, 0);
INSERT INTO `tb_user` VALUES ('B8B6F64FE6EB4971BF7138ECE6104F83', 'teacher001', '123456', 'Green', 20, '男', 1, 1);
INSERT INTO `tb_user` VALUES ('C673463130E4421FBC636EF79B93B93C', 'student001', '123456', '小明', 18, '男', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
