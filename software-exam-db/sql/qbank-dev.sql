/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : questionbank

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-10-20 21:45:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for analyze
-- ----------------------------
DROP TABLE IF EXISTS `analyze`;
CREATE TABLE `analyze` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `qid` int(5) NOT NULL,
  `detail` varchar(255) NOT NULL,
  `rqid` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of analyze
-- ----------------------------
INSERT INTO `analyze` VALUES ('1', '1', 'cpu执行指令的过程中，会自动修改PC的内容，PC是指令计数器，用来存放将要执行的下一条指令。对于指令寄存器（IR）存放即将执行的指令，指令译码器（ID）对指令中的操作码字段进行分析和解释，地址寄存器（AR），不是我们常用的CPU内部部件，其作用是用来保存当前CPU所要访问的内存单元或I/O设备地址', '0');
INSERT INTO `analyze` VALUES ('2', '2', '非对称加密又称为公开密钥加密，而共享密钥加密指对称加密。常见的对称加密算法有：DES、三重DES、RC-5、IDEA、AES。', '0');
INSERT INTO `analyze` VALUES ('3', '3', '计算机病毒具有隐蔽性、传染性、潜伏性、触发性和破坏性等。因此自毁性不属于计算机病毒的特性。', '0');
INSERT INTO `analyze` VALUES ('4', '0', '运算器：对计算机传输过来的信息进行算术或者逻辑运算。\r\n控制器：负责计算机CPU中指令的执行。\r\n寄存器组：存储计算机运算器传输来的信息和下一条指令地址。 ', '1');
INSERT INTO `analyze` VALUES ('5', '0', '复杂指令集计算机（CISC）：即Complex Instruction Set Computer\r\n将能想到的所有有用的操作都放到CPU硬件中，不必担心有多大、多耗电或使CPU变慢，那么最终得到的就是一个CISC机器。早期的VAX机器，据说包含超过2000个时钟周期的指令。\r\n精简指令集计算机（RISC）：即Reduced Instruction Set Computer', '2');
INSERT INTO `analyze` VALUES ('6', '0', 'cpu执行指令的过程中，会自动修改PC的内容，PC是指令计数器，用来存放将要执行的下一条指令。对于指令寄存器（IR）存放即将执行的指令，指令译码器（ID）对指令中的操作码字段进行分析和解释，地址寄存器（AR），不是我们常用的CPU内部部件，其作用是用来保存当前CPU所要访问的内存单元或I/O设备地址', '3');
INSERT INTO `analyze` VALUES ('7', '0', 'BIOS(基本输入输出系统)是一组固化到计算机内主板上一个ROM芯片上的程序，它保存着计算机最重要的基本输入输出的程序，开机后自检程序和系统自启动程序，它可从CMOS中读写系统设置的具体信息', '4');
INSERT INTO `analyze` VALUES ('8', '0', '在计算机中，n为补码（表示数据位），表示范围是-2n-1~-2n-1-1其中最小值为认为定义，以n=8为例，其中-128的补码是认为定义的1000 0000', '5');
INSERT INTO `analyze` VALUES ('9', '0', '对于奇偶校验，是由若干位有效信息，再加上一个二进制位（校验位）组成校验码，其中奇校验“1”的个数为奇数，而偶校验“1”的个数为偶数。', '6');
INSERT INTO `analyze` VALUES ('10', '0', '本题要求选择不正确的叙述，其中流水线的原理是在某一时刻可以让多个部件同时处理多条指令，避免各部件等待空闲，由此提高了各部件的利用率，也提高了系统的吞吐率。', '7');

-- ----------------------------
-- Table structure for board
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `tip` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of board
-- ----------------------------
INSERT INTO `board` VALUES ('1', '预计2019下半年福建软考准考证打印时间在考前一周，具体请大家以福建软考办公布为准。', '(1)考试前请您准备好钢笔(水笔)、2B铅笔及橡皮擦。在考试前要把移动通信设备关闭，但要有一个能看时间的工具(如手表等)。');
INSERT INTO `board` VALUES ('2', '0', '(2)由于上次考试有考生使用了假2B铅笔导致阅卷机无法读取答题卡，给考生带来了很大损失。因此，请您一定要注意选购合格的2B铅笔。电脑报远程教育中心介绍几种辨别真假2B铅笔的方法附后。');
INSERT INTO `board` VALUES ('3', '0', '(3)所有级别的上午考试时间为9:00～11:30(2个半小时)，上午试题一共75道小题，每一小题为1分。电脑报远程教育中心专家请您不要提前交卷，尽量将每一道题目都检查好。上午试题答题用的是答题卡，请您注意正确的填涂方式(请仔细阅读答题卡的“填涂注意事项”)，看清楚题号，避免填错答案，造成不必要的遗憾。交卷之前请检查“考生姓名”、“准考证号码”是否填涂正确。');
INSERT INTO `board` VALUES ('4', '0', '(4)上午考试完毕，请您千万不要急于与别人对答案，以免影响心情。要注意中午休息，养好精神，为下午考试做好准备。');
INSERT INTO `board` VALUES ('5', '0', '(5)初级和中级的下午考试时间为14:00～16:30(2个半小时)。下午试题有些题目是选答的，在做选答题的时候请注意用“○”圈好您选答的题号，千万不要将题号和答题位置选错。交卷之前请检查“考生姓名”、“准考证号码”是否填涂正确。');
INSERT INTO `board` VALUES ('6', '0', '(6)根据电脑报远程教育中心专家的经验来看，部分考生的回答字迹十分潦草，几乎无法辨认，因此被判0分。所以，务必请您注意字迹工整、尽量不要涂画。尽量不要提前交卷，认真斟酌每一道题目的答案。');

-- ----------------------------
-- Table structure for choices
-- ----------------------------
DROP TABLE IF EXISTS `choices`;
CREATE TABLE `choices` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `qid` int(5) NOT NULL,
  `status` int(2) NOT NULL,
  `content` varchar(50) NOT NULL,
  `rqid` int(5) DEFAULT NULL COMMENT '真题题目id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of choices
-- ----------------------------
INSERT INTO `choices` VALUES ('1', '1', '1', '程序计数器', '0');
INSERT INTO `choices` VALUES ('2', '1', '0', '指令寄存器', '0');
INSERT INTO `choices` VALUES ('3', '1', '0', '地址寄存器', '0');
INSERT INTO `choices` VALUES ('4', '1', '0', '指令译码器', '0');
INSERT INTO `choices` VALUES ('5', '2', '1', '共享密钥加密', '0');
INSERT INTO `choices` VALUES ('6', '2', '0', '公开密钥加密', '0');
INSERT INTO `choices` VALUES ('7', '2', '0', '数字签名', '0');
INSERT INTO `choices` VALUES ('8', '2', '0', '认证', '0');
INSERT INTO `choices` VALUES ('9', '3', '1', '自毁性', '0');
INSERT INTO `choices` VALUES ('10', '3', '0', '传染性', '0');
INSERT INTO `choices` VALUES ('11', '3', '0', '触发性', '0');
INSERT INTO `choices` VALUES ('12', '3', '0', '隐蔽性', '0');
INSERT INTO `choices` VALUES ('13', '0', '0', '运算器、控制器和系统总线', '1');
INSERT INTO `choices` VALUES ('14', '0', '1', '运算器、寄存器组和内存储器', '1');
INSERT INTO `choices` VALUES ('15', '0', '1', '运算器、控制器和寄存器组', '1');
INSERT INTO `choices` VALUES ('16', '0', '0', '控制器、指令译码器和寄存器组 ', '1');
INSERT INTO `choices` VALUES ('17', '0', '0', '规模和处理能力', '2');
INSERT INTO `choices` VALUES ('18', '0', '0', '是否通用', '2');
INSERT INTO `choices` VALUES ('19', '0', '1', 'CPU的指令系统架构 ', '2');
INSERT INTO `choices` VALUES ('20', '0', '0', '数据和指令的表示方式', '2');
INSERT INTO `choices` VALUES ('21', '0', '0', '指令寄存器', '3');
INSERT INTO `choices` VALUES ('22', '0', '1', '程序计数器', '3');
INSERT INTO `choices` VALUES ('23', '0', '0', '地址寄存器', '3');
INSERT INTO `choices` VALUES ('24', '0', '0', '指令译码器', '3');
INSERT INTO `choices` VALUES ('25', '0', '1', '主板上的ROM', '4');
INSERT INTO `choices` VALUES ('26', '0', '0', 'CPU的寄存器', '4');
INSERT INTO `choices` VALUES ('27', '0', '0', '主板上的RAM', '4');
INSERT INTO `choices` VALUES ('28', '0', '0', '虚拟存储器', '4');
INSERT INTO `choices` VALUES ('29', '0', '0', '2n', '5');
INSERT INTO `choices` VALUES ('30', '0', '0', '-2n', '5');
INSERT INTO `choices` VALUES ('31', '0', '0', '2n-1', '5');
INSERT INTO `choices` VALUES ('32', '0', '1', '-2n-1', '5');
INSERT INTO `choices` VALUES ('33', '0', '0', '若所有奇数位出错，则可以检测出该错误但无法纠正错误', '6');
INSERT INTO `choices` VALUES ('34', '0', '0', '若所有偶数位出错，则可以检测出该错误并加以纠正', '6');
INSERT INTO `choices` VALUES ('35', '0', '1', '若有奇数个数据位出错，则可以检测出该错误但无法纠正错误', '6');
INSERT INTO `choices` VALUES ('36', '0', '0', '若有偶数个数据位出错，则可以检测出该错误并加以纠正', '6');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `uid` int(5) NOT NULL,
  `qid` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `tid` int(5) NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES ('1', '1', '一个 Java 程序可以认为是一系列对象的集合，而这些对象通过调用彼此的方法来协同工作。下面简要介绍下类、对象、方法和实例变量的概念。\r\n1、对象：对象是类的一个实例，有状态和行为。例如，一条狗是一个对象，它的状态有：颜色、名字、品种；行为有：摇尾巴、叫、吃等。\r\n2、类：类是一个模板，它描述一类对象的行为和状态。\r\n3、方法：方法就是行为，一个类可以有很多方法。逻辑运算、数据修改以及所有动作都是在方法中完成的。\r\n4、实例变量：每个对象都有独特的实例变量，对象的状态由这些实例变量的值决定。');
INSERT INTO `content` VALUES ('2', '2', '构造方法的定义：“构造方法是一种特殊的方法，它是一个与类同名且返回值类型为同名类类型的方法。对象的创建就是通过构造方法来完成，其功能主要是完成对象的初始化。当类实例化一个对象时会自动调用构造方法。构造方法和其他方法一样也可以重载。”');
INSERT INTO `content` VALUES ('3', '3', '多态：1.多态定义：同一操作作用于不同的对象，可以有不同的解释，产生不同的执行结果，这就是多态性。简单的说:就是用基类的引用指向子类的对象。\r\n2.如何实现多态：C++中的多态只能通过指向基类类型的指针和引用来调用对象的虚函数来实现。\r\n实现多态有三种方式：虚方法，抽象方法，接口。');
INSERT INTO `content` VALUES ('4', '4', 'Java使用Thread类代表线程，所有的线程对象都必须是Thread类或其子类的实例。Java可以用四种方式来创建线程，如下所示：\r\n\r\n1）继承Thread类创建线程\r\n\r\n2）实现Runnable接口创建线程\r\n\r\n3）使用Callable和Future创建线程\r\n\r\n4）使用线程池例如用Executor框架');
INSERT INTO `content` VALUES ('5', '5', 'StringBuilder 、StringBuffer  和  String String区别：string：字符串常量\r\n   StringBuffer：字符串变量；线程安全的\r\n　StringBuilder：字符串变量；线程非安全的\r\n   三者执行速度比较：StringBuilder >  StringBuffer  >  String');
INSERT INTO `content` VALUES ('6', '6', '1、List（有序、可重复）\r\nList里存放的对象是有序的，同时也是可以重复的，List关注的是索引，拥有一系列和索引相关的方法，查询速度快，所有插入删除数据速度慢。\r\n2、Set（无序、不能重复）\r\nSet里存放的对象是无序，不能重复的，集合中的对象不按特定的方式排序，只是简单地把对象加入集合中。\r\n3、Map（键值对、键唯一、值不唯一）\r\n根据键得到值，对map集合遍历时先得到键的set集合，对set集合进行遍历，得到相应的值。');
INSERT INTO `content` VALUES ('7', '7', '字节流和字符流区别：1、字节流操作的基本单元是字节；字符流操作的基本单元为Unicode码元。\r\n2、字节流在操作的时候本身不会用到缓冲区的，是与文件本身直接操作的；而字符流在操作的时候使用到缓冲区的所有文件的存储都是字节(byte)的存储，在磁盘上保留的是字节。\r\n3、在使用字节流操作中，即使没有关闭资源（close方法），也能输出；而字符流不使用clode方法的话，不会输出任何内容。');

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('1', '2016上半年程序员考试上午真题汇总', '2016上半年');
INSERT INTO `paper` VALUES ('2', '2016下半年程序员考试上午真题汇总', '2016下半年');
INSERT INTO `paper` VALUES ('3', '2017上半年程序员考试上午真题汇总', '2017上半年');
INSERT INTO `paper` VALUES ('4', '2017下半年程序员考试上午真题汇总', '2017下半年');
INSERT INTO `paper` VALUES ('5', '2018上半年程序员考试上午真题汇总', '2018上半年');
INSERT INTO `paper` VALUES ('6', '2018下半年程序员考试上午真题汇总', '2018下半年');

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `lid` int(5) DEFAULT NULL,
  `cid` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES ('1', 'CPU在执行指令的过程中，会自动修改（  ）的内容，以使其保存的总是将要执行的下一条指令的地址', '2', '1');
INSERT INTO `questions` VALUES ('2', 'DES是（  ）算法', '2', '6');
INSERT INTO `questions` VALUES ('3', '计算机病毒的特征不包括（  ）', '2', '6');

-- ----------------------------
-- Table structure for real_questions
-- ----------------------------
DROP TABLE IF EXISTS `real_questions`;
CREATE TABLE `real_questions` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `lid` int(5) NOT NULL,
  `cid` int(5) NOT NULL,
  `pid` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of real_questions
-- ----------------------------
INSERT INTO `real_questions` VALUES ('1', ' CPU是一块超大规模的集成电路，主要包含（  ）等部件。', '1', '9', '1');
INSERT INTO `real_questions` VALUES ('2', ' 按照（  ），可将计算机分为RISC（精简指令集计算机）和CISC（复杂指令集计算机）。', '1', '8', '1');
INSERT INTO `real_questions` VALUES ('3', 'CPU在执行指令的过程中，会自动修改（  ）的内容，以使其保存的总是将要执行的下一条指令的地址。', '1', '7', '6');
INSERT INTO `real_questions` VALUES ('4', ' 在微机系统中，BIOS（基本输入输出系统）保存在（  ）中。', '1', '9', '6');
INSERT INTO `real_questions` VALUES ('5', '采用n位补码（包含一个符号位）表示数据，可以直接表示数值（  ）', '1', '6', '6');
INSERT INTO `real_questions` VALUES ('6', '以下关于采用一位奇校验方法的叙述中，正确的是（  ）。', '1', '5', '6');
INSERT INTO `real_questions` VALUES ('7', '下列关于流水线方式执行指令的叙述中，不正确的是（  ）', '1', '4', '6');

-- ----------------------------
-- Table structure for second_title
-- ----------------------------
DROP TABLE IF EXISTS `second_title`;
CREATE TABLE `second_title` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `cid` int(5) NOT NULL,
  `second_title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of second_title
-- ----------------------------
INSERT INTO `second_title` VALUES ('1', '2', 'java编程基础');
INSERT INTO `second_title` VALUES ('2', '2', '面向对象（上）');
INSERT INTO `second_title` VALUES ('3', '2', '面向对象（下）');
INSERT INTO `second_title` VALUES ('4', '2', '多线程');
INSERT INTO `second_title` VALUES ('5', '2', 'java api');
INSERT INTO `second_title` VALUES ('6', '2', '集合类');
INSERT INTO `second_title` VALUES ('7', '2', 'I/O（输入输出）');

-- ----------------------------
-- Table structure for sort_course
-- ----------------------------
DROP TABLE IF EXISTS `sort_course`;
CREATE TABLE `sort_course` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `status` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sort_course
-- ----------------------------
INSERT INTO `sort_course` VALUES ('1', '计算机导论', '0');
INSERT INTO `sort_course` VALUES ('2', 'Java基础入门', '0');
INSERT INTO `sort_course` VALUES ('3', '算法与数据结构', '0');
INSERT INTO `sort_course` VALUES ('4', '编译原理', '0');
INSERT INTO `sort_course` VALUES ('5', '计算机操作系统', '0');
INSERT INTO `sort_course` VALUES ('6', '计算机网络', '0');
INSERT INTO `sort_course` VALUES ('7', 'C Primer Plus', '0');
INSERT INTO `sort_course` VALUES ('8', '数据库系统概论', '0');
INSERT INTO `sort_course` VALUES ('9', '计算机组成', '0');

-- ----------------------------
-- Table structure for sort_level
-- ----------------------------
DROP TABLE IF EXISTS `sort_level`;
CREATE TABLE `sort_level` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `status` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sort_level
-- ----------------------------
INSERT INTO `sort_level` VALUES ('1', '初级', '0');
INSERT INTO `sort_level` VALUES ('2', '中级', '0');
INSERT INTO `sort_level` VALUES ('3', '高级', '0');

-- ----------------------------
-- Table structure for wrong_questions
-- ----------------------------
DROP TABLE IF EXISTS `wrong_questions`;
CREATE TABLE `wrong_questions` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `uid` int(5) NOT NULL,
  `qid` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wrong_questions
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(63) NOT NULL COMMENT '用户名称',
  `password` varchar(63) NOT NULL DEFAULT '' COMMENT '用户密码',
  `gender` tinyint(3) NOT NULL DEFAULT '0' COMMENT '性别：0 未知， 1男， 1 女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `last_login_time` datetime DEFAULT NULL COMMENTlogs '最近一次登录时间',
  `last_login_ip` varchar(63) NOT NULL DEFAULT '' COMMENT '最近一次登录IP地址',
  `nickname` varchar(63) NOT NULL DEFAULT '' COMMENT '用户昵称或网络名称',
  `mobile` varchar(20) NOT NULL DEFAULT '' COMMENT '用户手机号码',
  `avatar` varchar(255) NOT NULL DEFAULT '' COMMENT '用户头像图片',
  `weixin_openid` varchar(63) NOT NULL DEFAULT '' COMMENT '微信登录openid',
  `session_key` varchar(100) NOT NULL DEFAULT '' COMMENT '微信登录会话KEY',
  `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0 可用, 1 禁用, 2 注销',
  `add_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

