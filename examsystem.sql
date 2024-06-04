/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : examsystem

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 28/05/2024 13:41:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminId` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID号',
  `adminName` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '姓名',
  `sex` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '性别',
  `tel` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '电子邮箱',
  `pwd` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '密码',
  `cardId` varchar(18) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '身份证号',
  `role` varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '角色(0管理员，1教师，2学生)',
  PRIMARY KEY (`adminId`) USING BTREE,
  INDEX `sex`(`sex`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9529 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '管理员信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (9527, '管理员', '男', '12345678910', '1253838283@qq.com', '123456', '3132', '0');
INSERT INTO `admin` VALUES (9528, '管理员一号', '女', '123456', '1234567@qq.com', '123', '1234567', '0');
INSERT INTO `admin` VALUES (9529, '管理员一号', '女', '123456', '1234567@qq.com', '123', '1234567', '0');

-- ----------------------------
-- Table structure for exam_manage
-- ----------------------------
DROP TABLE IF EXISTS `exam_manage`;
CREATE TABLE `exam_manage`  (
  `examCode` int(0) NOT NULL AUTO_INCREMENT COMMENT '考试编号',
  `description` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '该次考试介绍',
  `source` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '课程名称',
  `paperId` int(0) NULL DEFAULT NULL COMMENT '试卷编号',
  `examDate` datetime(0) NULL DEFAULT NULL COMMENT '考试日期',
  `totalTime` int(0) NULL DEFAULT NULL COMMENT '持续时长',
  `grade` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '年级',
  `term` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '学期',
  `major` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '专业',
  `institute` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '学院',
  `totalScore` int(0) NULL DEFAULT NULL COMMENT '总分',
  `type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '考试类型',
  `tips` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '考生须知',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `tag` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  PRIMARY KEY (`examCode`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20220021 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '考试管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_manage
-- ----------------------------
INSERT INTO `exam_manage` VALUES (20220001, '2019年上期期末考试', '计算机网络', 1001, '2022-03-06 14:00:00', 120, '2018', '1', '计算机科学与技术', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。', NULL, NULL, NULL);
INSERT INTO `exam_manage` VALUES (20220002, '2019年上期期末考试', '数据库理论', 1002, '2022-03-06 14:00:00', 90, '2018', '2', '网络工程', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。', NULL, NULL, NULL);
INSERT INTO `exam_manage` VALUES (20220003, '2018年下期期末考试', '数据结构', 1003, '2022-03-06 14:00:00', 90, '2017', '1', '软件工程', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。', NULL, NULL, NULL);
INSERT INTO `exam_manage` VALUES (20220005, '2018年上期期末考试', '计算机导论', 1004, '2022-03-06 14:00:00', 90, '2018', '1', '计算机科学与技术', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。', NULL, NULL, NULL);
INSERT INTO `exam_manage` VALUES (20220006, '2017年上期期末考试', '软件工程', 1005, '2022-03-06 14:00:00', 120, '2018', '1', '计算机科学与技术', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。', NULL, NULL, NULL);
INSERT INTO `exam_manage` VALUES (20220007, '2018年上期期末考试', '操作系统', 1006, '2022-03-06 14:00:00', 120, '2018', '2', '计算机科学与技术', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。', NULL, NULL, NULL);
INSERT INTO `exam_manage` VALUES (20220008, '2018年下期期末考试', 'C语言', 1007, '2022-03-06 14:00:00', 120, '2018', '1', '信息工程', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。', NULL, NULL, NULL);
INSERT INTO `exam_manage` VALUES (20220009, '2018年下期期末考试', '高等数学', 1008, '2022-04-07 23:00:00', 120, '2018', '1', '信息工程', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。', NULL, NULL, NULL);
INSERT INTO `exam_manage` VALUES (20220011, '2022上学期期末考试', '线性代数', 1009, '2022-04-10 12:30:00', 150, '2019', '2', '软件工程', '软件工程学院', 100, '期末考试', '不要作弊不要作弊！！！！！！！！！！！！！', NULL, NULL, NULL);
INSERT INTO `exam_manage` VALUES (20220020, '2022上学期期末考试', '计算机网络原理', 1010, '2022-04-15 20:30:00', 90, '2019', '2', '网络工程', '软件工程学院', 100, '期中考试', NULL, NULL, NULL, NULL);
INSERT INTO `exam_manage` VALUES (20220021, '123', '123', 1011, '2022-04-15 20:44:24', NULL, NULL, NULL, NULL, '软件工程学院', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for fill_question
-- ----------------------------
DROP TABLE IF EXISTS `fill_question`;
CREATE TABLE `fill_question`  (
  `questionId` int(0) NOT NULL AUTO_INCREMENT COMMENT '试题编号',
  `subject` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '考试科目',
  `question` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '试题内容',
  `answer` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '正确答案',
  `analysis` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '题目解析',
  `score` int(0) NULL DEFAULT 2 COMMENT '分数',
  `level` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '难度等级',
  `section` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '所属章节',
  `questionType` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '题目类型',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`questionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10024 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '填空题题库' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fill_question
-- ----------------------------
INSERT INTO `fill_question` VALUES (10000, '计算机网络', '从计算机网络系统组成的角度看，计算机网络可以分为()和()', '通信子网资源子网', NULL, 0, '中等', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10001, '计算机网络', '收发电子邮件，属于ISO/OSI RM中 ()层的功能。', '应用', NULL, 0, '容易', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10002, '计算机网络', '在TCP/IP层次模型中与OSI参考模型第四层相对应的主要协议有()和(),其中后者提供无连接的不可靠传输服', 'TCP（传输控制协议） UDP（用户数据报协议） ', NULL, 0, '容易', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10003, '计算机网络', '计算机网络中常用的三种有线媒体是 (),()和 ()', '同轴电缆.双绞线 光纤', NULL, 0, '容易', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10004, '计算机网络', '国内最早的四大网络包括原邮电部的ChinaNet. 原电子部的ChinaGBN. 教育部的()和中科院的CSTnet', 'CERnet (或中国教育科研网)', NULL, 0, '中等', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10005, '计算机网络', '复盖一个国家，地区或几个洲的计算机网络称为()，在同一建筑或复盖几公里内范围的网络称为()，而介于两者之间的是()', ' 广域网       局域网     城域网', NULL, 0, '容易', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10006, '计算机网络', 'Outlook等常用电子邮件软件接收邮件使用的协议是(),发送邮件时使用的协议是()', 'POP3    SMTP    ', NULL, 0, '容易', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10007, '计算机网络', '通信系统中，称调制前的电信号为()信号，调制后的信号为调制信号', '基带', NULL, 0, '容易', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10008, '计算机网络', '按照IPV4标准,IP地址205.3.127.13属于()类地址', 'C', NULL, 0, '容易', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10009, '计算机网络', '计算机网络采用()技术，而传统电话网络则采用()技术', '分组交换电路交换', NULL, 0, '容易', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10010, '计算机网络', '计算机内传输的信号是()，而公用电话系统的传输系统只能传输()', '数字信号模拟信号', NULL, 0, '容易', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10011, '计算机网络', '通信系统中，称调制前的电信号为()，调制后的信号叫()。', '基带信号调制信号', NULL, 0, '容易', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10012, '计算机网络', 'IP地址分()和()两个部分', '网络号主机号', NULL, 0, '容易', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10013, '计算机网络', ' IP地址协议作网间网中()层协议，提供无连接的数据报传输机制，IP数据报也分为()和()两个部分', '网络报头数据区', NULL, 0, '中等', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10014, '计算机网络', '()是一个简单的远程终端协议。', 'TELNET', NULL, 0, '容易', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10015, '计算机网络', '在同一个系统内，相邻层之间交换信息的连接点称之为()，而低层模块向高层提供功能性的支持称之为()。', '接口服务', NULL, 0, '容易', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10016, '计算机网络', 'Internet广泛使用的电子邮件传送协议是()', 'SMTP', NULL, 0, '容易', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10017, '计算机网络', '按交换方式来分类，计算机网络可以分为电路交换网，  报文交换网  和()三种', '分组交换网', NULL, 0, '中等', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10018, '计算机网络', 'Intranet分层结构包括网络、(),应用三个层次。', '服务', NULL, 0, '容易', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10019, '计算机网络', 'WWW上的每一个网页都有一个独立的地址，这些地址称为  ()', '统一资源定位器/URL ', NULL, 0, '中等', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10020, '计算机网络', '分组交换网中，附加信息用来在网络中进行路由选择、() 和流量控制', '差错纠正  ', NULL, 0, '中等', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10021, '计算机网络', '根据IEEE802模型的标准将数据链路层划分为LLC子层和 ()子层。', ' MAC ', NULL, 0, '中等', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10022, '计算机网络', '据交换的路由信息的不同，路由算法可以分为两大类：  ()  和链路状态算法', '距离向量算法', NULL, 0, '中等', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10023, '计算机网络', '假定某信道受奈氏准则限制的最高码元速率为2000码元/秒。如果采用振幅调制，把码元的振幅划分为16个不同等级来传送，那么可以获得的数据率为 () b/s。', '80000 ', NULL, 0, '困难', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');
INSERT INTO `fill_question` VALUES (10024, '计算机网络', '交换型以太网系统中的 ()  ，以其为核心联接站点或者网段，端口之间帧的输入和输出已不再受到CSMA/CD媒体访问控制协议的约束。', '以太网交换器 ', NULL, 0, '困难', NULL, '填空题', '2022-04-06 12:11:20', '2022-04-06 12:14:24');

-- ----------------------------
-- Table structure for judge_question
-- ----------------------------
DROP TABLE IF EXISTS `judge_question`;
CREATE TABLE `judge_question`  (
  `questionId` int(0) NOT NULL AUTO_INCREMENT COMMENT '试题编号',
  `subject` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '考试科目',
  `question` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '试题内容',
  `answer` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '正确答案',
  `analysis` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '题目解析',
  `score` int(0) NULL DEFAULT 2 COMMENT '分数',
  `level` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '难度等级',
  `questionType` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '题目类型',
  `section` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '所属章节',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `answerA` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `answerB` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  PRIMARY KEY (`questionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30014 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '判断题题库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of judge_question
-- ----------------------------
INSERT INTO `judge_question` VALUES (30001, '计算机网络', '与有线网相比,无线网的数据传输率一般相对较慢', 'T', NULL, 0, '容易', '判断题', '', '2022-04-06 12:42:15', '2022-04-06 12:42:15', 'T', 'F');
INSERT INTO `judge_question` VALUES (30002, '计算机网络', 'OSI参考模型中,不同节点的同等层具有不同的功能', 'F', NULL, 0, '容易', '判断题', NULL, '2022-04-06 12:42:15', '2022-04-06 12:42:15', 'T', 'F');
INSERT INTO `judge_question` VALUES (30003, '计算机网络', '普通电脑不能作为服务器', 'F', NULL, 0, '容易', '判断题', NULL, '2022-04-06 12:42:15', '2022-04-06 12:42:15', 'T', 'F');
INSERT INTO `judge_question` VALUES (30004, '计算机网络', '没有网线的电脑不能连入互联网', 'F', NULL, 0, '容易', '判断题', NULL, '2022-04-06 12:42:15', '2022-04-06 12:42:15', 'T', 'F');
INSERT INTO `judge_question` VALUES (30005, '计算机网络', '网卡必须安装驱动程序', 'T', NULL, 0, '中等', '判断题', NULL, '2022-04-06 12:42:15', '2022-04-06 12:42:15', 'T', 'F');
INSERT INTO `judge_question` VALUES (30006, '计算机网络', 'UTP为屏蔽双绞线', 'F', NULL, 0, '中等', '判断题', NULL, '2022-04-06 12:42:15', '2022-04-06 12:42:15', 'T', 'F');
INSERT INTO `judge_question` VALUES (30007, '计算机网络', '网络接口卡又称为网卡,它是构成网络的基本部件', 'T', NULL, 0, '中等', '判断题', NULL, '2022-04-06 12:42:15', '2022-04-06 12:42:15', 'T', 'F');
INSERT INTO `judge_question` VALUES (30008, '计算机网络', '无线AP可以成倍地扩展网络覆盖范围', 'T', NULL, 0, '中等', '判断题', NULL, '2022-04-06 12:42:15', '2022-04-06 12:42:15', 'T', 'F');
INSERT INTO `judge_question` VALUES (30009, '计算机网络', 'SMTP是一组用于由源地址到目的地址传送邮件的协议', 'T', NULL, 0, '困难', '判断题', NULL, '2022-04-06 12:42:15', '2022-04-06 12:42:15', 'T', 'F');
INSERT INTO `judge_question` VALUES (30010, '计算机网络', '任务管理器可以关闭所有的进程', 'F', NULL, 0, '中等', '判断题', NULL, '2022-04-06 12:42:15', '2022-04-06 12:42:15', 'T', 'F');
INSERT INTO `judge_question` VALUES (30011, '计算机网络', '利用BT下载时,用户越多,下载速度越快', 'T', NULL, 0, '中等', '判断题', NULL, '2022-04-06 12:42:15', '2022-04-06 12:42:15', 'T', 'F');
INSERT INTO `judge_question` VALUES (30012, '计算机网络', 'INTERNET上向朋友发送电子邮件,必须知道对方的真实姓名和家庭住址', 'F', NULL, 0, '容易', '判断题', NULL, '2022-04-06 12:42:15', '2022-04-06 12:42:15', 'T', 'F');
INSERT INTO `judge_question` VALUES (30014, '计算机网络', '这是一道测试题吗', 'T', '暂无', 0, '容易', '判断题', '暂无', '2022-04-06 12:42:15', '2022-04-06 12:45:10', 'T', 'F');

-- ----------------------------
-- Table structure for multi_question
-- ----------------------------
DROP TABLE IF EXISTS `multi_question`;
CREATE TABLE `multi_question`  (
  `questionId` int(0) NOT NULL AUTO_INCREMENT COMMENT '试题编号',
  `subject` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '考试科目',
  `question` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '问题题目',
  `answerA` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '选项A',
  `answerB` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '选项B',
  `answerC` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '选项C',
  `answerD` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '选项D',
  `answer` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '正确答案',
  `analysis` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '题目解析',
  `score` int(0) NULL DEFAULT 2 COMMENT '分数',
  `section` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '所属章节',
  `level` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '难度等级',
  `questionType` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '题目类型',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`questionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20034 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '选择题题库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of multi_question
-- ----------------------------
INSERT INTO `multi_question` VALUES (20000, '计算机网络', 'DNS 服务器和DHCP服务器的作用是（）', '将IP地址翻译为计算机名，为客户机分配IP地址', '将IP地址翻译为计算机名、解析计算机的MAC地址', '将计算机名翻译为IP地址、为客户机分配IP地址', '将计算机名翻译为IP地址、解析计算机的MAC地址', 'C', NULL, 0, '应用层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20001, '计算机网络', 'HTTP协议通常使用什么协议进行传输（）', 'ARP', 'DHCP', 'UDP', 'TCP', 'D', NULL, 0, '应用层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20003, '计算机网络', '查看DNS缓存记录的命令（）', 'ipconfig/displaydns', 'nslookup', 'ipconfig/release', 'ipconfig/flushdns', 'A', NULL, 0, '应用层', '中等', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20004, '计算机网络', 'DHCP(        )报文的目的IP地址为255.255.255.255', 'DhcpDisover', 'DhcpOffer', 'DhcpAck', 'DhcpNack', 'A', NULL, 0, '应用层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20005, '计算机网络', '下列地址中，（  ）不是DHCP服务器分配的IP地址', '196.254.109.100', '169.254.12.42', '69.254.48.45', '96.254.54.15', 'B', NULL, 0, '应用层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20006, '计算机网络', 'DHCP通常可以为客户端自动配置哪些网络参数（）', 'IP，掩码，网关，DNS', 'IP，掩码，域名，SMTP', '网关，掩码，浏览器，FTP', 'IP，网关，DNS，服务器', 'A', NULL, 0, '应用层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20007, '计算机网络', 'DNS服务器在名称解析过程中正确的查询顺序为（）', '本地缓存记录→区域记录→转发域名服务器→根域名服务器', '区域记录→本地缓存记录→转发域名服务器→根域名服务器', '本地缓存记录→区域记录→根域名服务器→转发域名服务器', '区域记录→本地缓存记录→根域名服务器→转发域名服务器', 'A', NULL, 0, '应用层', '中等', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20008, '计算机网络', '在TCP/IP协议中，序号小于（  ）的端口称为熟知端口(well-known port)。', '1024', '64', '256', '128', 'A', NULL, 0, '传输层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20009, '计算机网络', '在Internet上用TCP/IP播放视频，想用传输层的最快协议，以减少时延，要使用（ ）', 'UDP协议的低开销特性', 'UDP协议的高开销特性', 'TCP协议的低开销特性', 'TCP协议的高开销特性', 'A', NULL, 0, '传输层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20010, '计算机网络', '在TCP协议中采用（ ）来区分不同的应用进程', '端口号', 'IP地址', '协议类型', 'MAC地址', 'A', NULL, 0, '传输层', '中等', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20011, '计算机网络', '可靠的传输协议中的“可靠”指的是（ ）', '使用面向连接的会话', '使用“尽力而为”的传输', '使用滑动窗口来维持可靠性', '使用确认重传机制来确保传输的数据不丢失', 'D', NULL, 0, '传输层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20012, '计算机网络', '假设拥塞窗口为50KB，接收窗口为80KB，TCP能够发送的最大字节数为（ ）', '50KB', '80KB', '130KB', '30KB', 'A', NULL, 0, '传输层', '困难', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20013, '计算机网络', '主机A向主机B发送一个（SYN=1，seq=2000）的TCP报文，期望与主机B建立连接，若主机B接受连接请求，则主机B发送的正确有TCP报文可能是（ ）', '（SYN=0,ACK=0,seq=2001,ack=2001）', '（SYN=1,ACK=1,seq=2000,ack=2000）', '•	C.（SYN=1,ACK=1,seq=2001,ack=2001）', '（SYN=0,ACK=1,seq=2000,ack=2000）', 'C', NULL, 0, '传输层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20014, '计算机网络', '主机A向主机B连续发送了两个TCP报文段，其序号分别为70和100。试问： （1）第一个报文段携带了（）个字节的数据？', ' 70', '30', '100', '170', 'B', NULL, 0, '传输层', '中等', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20015, '计算机网络', 'PCM脉码调制的过程（ ）', '采样、量化、编码', '量化、编码、采样', '编码、量化、采样', '采样、编码、量化', 'A', NULL, 0, '物理层', '困难', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20016, '计算机网络', '若某采用4相位调制的通信链路的数据传输速率为2400bps，则该链路的波特率为（）', '600Baud', '1200Baud', '4800Baud', '9600Baud', 'B', NULL, 0, '物理层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20017, '计算机网络', '以下关于数据传输速率的描述中，错误的是( )', '数据传输速率表示每秒钟传输构成数据代码的二进制比特数', '对于二进制数据，数据传输速率为S=1/T (bps)', '常用的数据传输速率单位有: 1Mbps=1.024×106bps', '数据传输速率是描述数据传输系统性能的重要技术指标之一', 'C', NULL, 0, '物理层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20018, '计算机网络', '以下关于时分多路复用概念的描述中，错误的是.(  ).', '时分多路复用将线路使用的时间分成多个时间片', '时分多路复用分为同步时分多路复用与统计时分多路复用', '时分多路复用使用“帧”与数据链路层“帧”的概念、作用是不同的', '统计时分多路复用将时间片预先分配给各个信道', 'D', NULL, 0, '物理层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20019, '计算机网络', '1000BASE-T标准支持的传输介质是（）', '双绞线', '同轴电缆', '光纤', '无线电', 'A', NULL, 0, '物理层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20020, '计算机网络', '一个以太网交换机，读取整个数据帧，对数据帧进行差错校验后再转发出去，这种交换方式称为 （）', '直通交换', '无碎片交换', '无差错交换', '存储转发交换', 'D', NULL, 0, '数据链路层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20021, '计算机网络', '关于VLAN，下面的描述中正确的是（）', '一个新的交换机没有配置VLAN', '通过配置VLAN减少了冲突域的数量', '一个VLAN不能跨越多个交换机', '各个VLAN属于不同的广播域', 'D', NULL, 0, '数据链路层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20022, '计算机网络', '以太网协议中使用物理地址作用是什么？', '.用于不同子网中的主机进行通信', '作为第二层设备的唯一标识', '用于区别第二层第三层的协议数据单元', '保存主机可检测未知的远程设备', 'B', NULL, 0, '数据链路层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20023, '计算机网络', '以太网采用的CSMA/CD协议，当冲突发生时要通过二进制指数后退算法计算后退延时， 关于这个算法，以下论述中错误的是 （）', '冲突次数越多，后退的时间越短', '平均后退次数的多少与负载大小有关', '后退时延的平均值与负载大小有关', '重发次数达到一定极限后放弃发送', 'A', NULL, 0, '数据链路层', '中等', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20024, '计算机网络', '以下关于交换机获取与其端口连接设备的MAC地址的叙述中，正确的是（）', '交换机从路由表中提取设备的MAC地址', '交换机检查端口流入分组的源地址', '交换机之间互相交换地址表', '网络管理员手工输入设备的MAC地址', 'B', NULL, 0, '数据链路层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20025, '计算机网络', '如果G (x）为11010010，以下4个CRC校验比特序列中只有哪个可能是正确的 ？', '1101011001', '101011011', '11011011', '1011001', 'B', NULL, 0, '数据链路层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20026, '计算机网络', '以下关于Ethernet物理地址的描述中，错误的是', 'Ethernet物理地址又叫做MAC地址', '48位的Ethernet物理地址允许分配的地址数达到247个', '网卡的物理地址写入主机的EPROM中', '每一块网卡的物理地址在全世界是唯一的', 'C', NULL, 2, '数据链路层', '中等', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20027, '计算机网络', '下列帧类型中，不属于HDLC帧类型的是（）', '信息帧', '确认帧', '监控帧', '无编号帧', 'B', NULL, 2, '数据链路层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20028, '计算机网络', '通过交换机连接的一组站点，关于它们的广播域和冲突域说法正确的是（）', '组成一个冲突域，但不是一个广播域', '组成一个广播域，但不是一个冲突域', '组成一个冲突域，也是一个广播域', '既不一个冲突域，也不是一个广播域', 'B', NULL, 2, '数据链路层', '中等', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20029, '计算机网络', '数据链路层的数据单位是（）', '帧', '字节', '比特', '分组', 'A', NULL, 2, '数据链路层', '容易', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20030, '计算机网络', 'LAN参考模型可分为物理层、（ ）', 'MAC，LLC等三层', 'LLC，MHS等三层', 'MAC，FTAM等三层', 'LLC，VT等三层', 'A', NULL, 2, '数据链路层', '中等', '选择题', '2022-04-06 09:48:09', '2022-04-06 09:48:09');
INSERT INTO `multi_question` VALUES (20034, '计算机网络', '测试题目', '选项A', '选项B', '选项C', '选项D', 'C', '暂无', 0, NULL, '容易', NULL, '2022-04-06 10:13:26', '2022-04-06 10:25:59');

-- ----------------------------
-- Table structure for paper_manage
-- ----------------------------
DROP TABLE IF EXISTS `paper_manage`;
CREATE TABLE `paper_manage`  (
  `paperId` int(0) NULL DEFAULT NULL COMMENT '试卷编号',
  `questionType` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '题目类型(1填空2选择3判断)',
  `questionId` int(0) NULL DEFAULT NULL COMMENT '题目编号',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `score` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '试卷管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper_manage
-- ----------------------------
INSERT INTO `paper_manage` VALUES (1012, '选择题', 20000, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '选择题', 20001, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '选择题', 20004, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '选择题', 20005, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '选择题', 20006, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '选择题', 20003, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '选择题', 20007, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '选择题', 20010, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '选择题', 20012, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '选择题', 20015, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '填空题', 10000, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '填空题', 10004, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '填空题', 10013, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '填空题', 10001, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '填空题', 10002, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '填空题', 10003, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '填空题', 10005, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '填空题', 10006, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '填空题', 10023, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '填空题', 10024, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '判断题', 30001, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '判断题', 30002, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '判断题', 30003, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '判断题', 30004, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1012, '判断题', 30012, '2022-04-15 20:30:32', '2022-04-15 20:30:32', '4');
INSERT INTO `paper_manage` VALUES (1010, '选择题', 20000, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '选择题', 20001, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '选择题', 20003, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '选择题', 20004, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '选择题', 20005, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '选择题', 20006, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '选择题', 20007, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '选择题', 20008, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '选择题', 20009, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '选择题', 20010, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '填空题', 10000, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '填空题', 10001, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '填空题', 10002, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '填空题', 10003, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '填空题', 10004, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '填空题', 10005, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '填空题', 10006, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '填空题', 10007, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '填空题', 10008, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '填空题', 10009, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '判断题', 30001, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '判断题', 30002, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '判断题', 30003, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '判断题', 30004, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');
INSERT INTO `paper_manage` VALUES (1010, '判断题', 30005, '2022-04-15 20:39:16', '2022-04-15 20:39:16', '4');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `scoreId` int(0) NOT NULL AUTO_INCREMENT COMMENT '分数编号',
  `examCode` int(0) NULL DEFAULT NULL COMMENT '考试编号',
  `studentId` int(0) NULL DEFAULT NULL COMMENT '学号',
  `subject` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '课程名称',
  `obScore` int(0) NULL DEFAULT NULL COMMENT '客观题成绩',
  `subScore` int(0) NULL DEFAULT NULL COMMENT '主观题成绩',
  `score` int(0) NULL DEFAULT NULL COMMENT '总成绩',
  `answerDate` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '答题日期',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`scoreId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '成绩管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `studentId` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `studentName` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '姓名',
  `grade` varchar(4) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '年级',
  `major` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '专业',
  `clazz` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '班级',
  `institute` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '学院',
  `tel` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '电子邮件',
  `pwd` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '密码',
  `cardId` varchar(18) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '身份证号',
  `sex` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '性别',
  `role` varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '2' COMMENT '角色(0管理员，1教师，2学生)',
  `icon` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '头像',
  `residence` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '居住地',
  PRIMARY KEY (`studentId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20199003 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '学生信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student_paper
-- ----------------------------
DROP TABLE IF EXISTS `student_paper`;
CREATE TABLE `student_paper`  (
  `studentId` int(0) NOT NULL COMMENT '学生id',
  `questionId` int(0) NULL DEFAULT NULL COMMENT '题目id',
  `studentAnswer` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NULL DEFAULT NULL COMMENT '学生答案',
  `rightAnswer` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NULL DEFAULT NULL COMMENT '正确答案',
  `paperId` int(0) NULL DEFAULT NULL COMMENT '试卷id',
  `question` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NULL DEFAULT NULL COMMENT '题目'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_paper
-- ----------------------------
INSERT INTO `student_paper` VALUES (20195007, 10000, '测试答案', '通信子网资源子网', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 30001, 'T', 'T', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 20000, 'B', 'C', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 30002, 'T', 'F', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 10001, '测试答案', '应用', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 20001, 'B', 'D', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 30003, 'T', 'F', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 10002, '测试答案', 'TCP（传输控制协议） UDP（用户数据报协议） ', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 20003, 'B', 'A', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 30004, 'T', 'F', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 10003, '测试答案', '同轴电缆.双绞线 光纤', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 20004, 'B', 'A', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 10004, '测试答案', 'CERnet (或中国教育科研网)', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 30005, 'T', 'T', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 20005, 'B', 'B', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 10005, '测试答案', ' 广域网       局域网     城域网', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 20006, 'B', 'A', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 10006, '测试答案', 'POP3    SMTP    ', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 20007, 'B', 'A', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 10007, '测试答案', '基带', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 10008, '测试答案', 'C', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 20008, 'B', 'A', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 10009, '测试答案', '分组交换电路交换', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 20009, 'B', 'A', 1010, NULL);
INSERT INTO `student_paper` VALUES (20195007, 20010, 'B', 'A', 1010, NULL);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacherId` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `teacherName` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '姓名',
  `institute` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '学院',
  `sex` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '性别',
  `tel` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '邮箱',
  `pwd` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '密码',
  `cardId` varchar(18) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '身份证号',
  `type` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '职称',
  `role` varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '角色（0管理员，1教师，2学生）',
  `icon` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '头像',
  `residence` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '居住地(湖南省衡阳市)',
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '具体联系地址',
  PRIMARY KEY (`teacherId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20081003 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '教师信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
