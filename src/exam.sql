/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.27 : Database - neusoft_online_exam
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`neusoft_online_exam` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `neusoft_online_exam`;

/*Table structure for table `course_student_table` */

DROP TABLE IF EXISTS `course_student_table`;

CREATE TABLE `course_student_table` (
  `pri_id` int(8) NOT NULL AUTO_INCREMENT,
  `crs_tch_id` int(8) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  PRIMARY KEY (`pri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `course_student_table` */

insert  into `course_student_table`(`pri_id`,`crs_tch_id`,`student_id`) values (9,12,'S0001');

/*Table structure for table `course_table` */

DROP TABLE IF EXISTS `course_table`;

CREATE TABLE `course_table` (
  `course_id` varchar(20) NOT NULL,
  `course_name` varchar(20) NOT NULL,
  `course_intro` varchar(1000) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course_table` */

insert  into `course_table`(`course_id`,`course_name`,`course_intro`) values ('CS31905','软件构造','《软件构造》是计算机大类/软件工程大类的一门重要的专业基础课程，目的是使学生在高级语言程序设计的基础上，认识软件构造的质量标准与目标，学习软件构造的基本过程，深入学习抽象数据类型与面向对象编程（OOP），初步掌握面向关键质量目标（可理解性、可维护性、可复用性、健壮性、性能）的软件构造基本技术，了解软件代码重构和面向更复杂软件系统的高级构造技术，从而具备程序设计与实现的能力，表达和沟通的能力，利用OO进行软件建模与分析的能力，系统分析与评价的能力，利用现代软件构造工具进行高质量和高效率软件开发与测试的能力。'),('CS32122','计算机系统','这是计算机系统的简介'),('CS34901','企业短期实训','Java和嵌入式二选一'),('CS34902','独立学习与技术交流','这是一门充满爱的课');

/*Table structure for table `course_teacher_table` */

DROP TABLE IF EXISTS `course_teacher_table`;

CREATE TABLE `course_teacher_table` (
  `pri_id` int(8) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(20) NOT NULL,
  `teacher_id` varchar(20) NOT NULL,
  PRIMARY KEY (`pri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `course_teacher_table` */

insert  into `course_teacher_table`(`pri_id`,`course_id`,`teacher_id`) values (12,'CS34901','T0001'),(13,'CS31905','T0001');

/*Table structure for table `exam_history_table` */

DROP TABLE IF EXISTS `exam_history_table`;

CREATE TABLE `exam_history_table` (
  `pri_id` int(8) NOT NULL AUTO_INCREMENT,
  `exam_id` varchar(100) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  `mult_answer` varchar(2000) DEFAULT NULL,
  `subj_answer` varchar(2000) DEFAULT NULL,
  `mult_result` varchar(2000) DEFAULT NULL,
  `subj_result` varchar(2000) DEFAULT NULL,
  `mult_score` int(8) DEFAULT NULL,
  `subj_score` int(8) unsigned zerofill DEFAULT NULL,
  `is_reviewed` varchar(20) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `exam_history_table` */

insert  into `exam_history_table`(`pri_id`,`exam_id`,`student_id`,`mult_answer`,`subj_answer`,`mult_result`,`subj_result`,`mult_score`,`subj_score`,`is_reviewed`,`start_time`,`end_time`) values (7,'2019-08-01-22-02-CS34901','S0001','[{\"question_id\":15,\"question_type\":\"mult\",\"student_answer\":\"B\",\"student_mark\":0},{\"question_id\":17,\"question_type\":\"mult\",\"student_answer\":\"B\",\"student_mark\":0},{\"question_id\":14,\"question_type\":\"mult\",\"student_answer\":\"B\",\"student_mark\":0},{\"question_id\":11,\"question_type\":\"mult\",\"student_answer\":\"B\",\"student_mark\":0}]','[{\"question_id\":18,\"question_type\":\"subj\",\"student_answer\":\"2\",\"student_mark\":0},{\"question_id\":19,\"question_type\":\"subj\",\"student_answer\":\"2\",\"student_mark\":0}]','[{\"question_id\":15,\"question_type\":\"\",\"student_answer\":\"\",\"student_mark\":2},{\"question_id\":17,\"question_type\":\"\",\"student_answer\":\"\",\"student_mark\":0},{\"question_id\":14,\"question_type\":\"\",\"student_answer\":\"\",\"student_mark\":0},{\"question_id\":11,\"question_type\":\"\",\"student_answer\":\"\",\"student_mark\":0}]','[{\"question_id\":18,\"question_type\":\"\",\"student_answer\":\"\",\"student_mark\":5},{\"question_id\":19,\"question_type\":\"\",\"student_answer\":\"\",\"student_mark\":7}]',2,00000012,'true','2019-08-01 22:28:52','2019-08-01 22:43:52');

/*Table structure for table `exam_question_table` */

DROP TABLE IF EXISTS `exam_question_table`;

CREATE TABLE `exam_question_table` (
  `pri_id` int(8) NOT NULL AUTO_INCREMENT,
  `exam_id` varchar(100) NOT NULL,
  `course_id` varchar(20) NOT NULL,
  `question_id` int(8) NOT NULL,
  PRIMARY KEY (`pri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

/*Data for the table `exam_question_table` */

insert  into `exam_question_table`(`pri_id`,`exam_id`,`course_id`,`question_id`) values (78,'2019-08-01-22-02-CS34901','CS34901',15),(79,'2019-08-01-22-02-CS34901','CS34901',17),(81,'2019-08-01-22-02-CS34901','CS34901',14),(82,'2019-08-01-22-02-CS34901','CS34901',11),(84,'2019-08-01-22-02-CS34901','CS34901',18),(85,'2019-08-01-22-02-CS34901','CS34901',19),(87,'2019-08-01-22-03-CS34901','CS34901',17),(88,'2019-08-01-22-03-CS34901','CS34901',16),(90,'2019-08-01-22-03-CS34901','CS34901',12),(91,'2019-08-01-22-03-CS34901','CS34901',11),(93,'2019-08-01-22-03-CS34901','CS34901',18),(94,'2019-08-01-22-03-CS34901','CS34901',19);

/*Table structure for table `exam_table` */

DROP TABLE IF EXISTS `exam_table`;

CREATE TABLE `exam_table` (
  `exam_id` varchar(100) NOT NULL,
  `course_id` varchar(20) NOT NULL,
  `teacher_id` varchar(20) NOT NULL,
  `easy` int(8) unsigned zerofill NOT NULL,
  `midd` int(8) unsigned zerofill NOT NULL,
  `hard` int(8) unsigned zerofill NOT NULL,
  `exam_time_start` datetime NOT NULL,
  `exam_time_end` datetime NOT NULL,
  `exam_length` int(8) NOT NULL,
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `exam_table` */

insert  into `exam_table`(`exam_id`,`course_id`,`teacher_id`,`easy`,`midd`,`hard`,`exam_time_start`,`exam_time_end`,`exam_length`) values ('2019-08-01-22-02-CS34901','CS34901','T0001',00000002,00000002,00000002,'2019-08-01 00:00:00','2019-08-03 00:00:00',15),('2019-08-01-22-03-CS34901','CS34901','T0001',00000002,00000002,00000002,'2019-01-01 00:00:00','2020-01-01 00:00:00',15);

/*Table structure for table `notice_table` */

DROP TABLE IF EXISTS `notice_table`;

CREATE TABLE `notice_table` (
  `notice_id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `course_id` varchar(20) DEFAULT NULL,
  `notice_body` varchar(1000) NOT NULL,
  `notice_type` varchar(20) NOT NULL,
  `notice_time` datetime NOT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `notice_table` */

insert  into `notice_table`(`notice_id`,`user_id`,`course_id`,`notice_body`,`notice_type`,`notice_time`) values (3,'T0001','CS34901','何一夫你企业实训挂了','student','2019-08-01 22:40:32'),(4,'T0001','CS34901','你企业实训挂了','student','2019-08-01 22:40:53'),(5,'T0001','CS34901','企业实训考试已发送','student','2019-08-01 22:41:07'),(8,'A0001',NULL,'管理员测试','student','2019-08-01 23:08:15');

/*Table structure for table `question_table` */

DROP TABLE IF EXISTS `question_table`;

CREATE TABLE `question_table` (
  `question_id` int(8) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(20) NOT NULL,
  `teacher_id` varchar(20) NOT NULL,
  `question_rate` varchar(20) NOT NULL,
  `question_mark` int(8) NOT NULL,
  `question_type` varchar(20) NOT NULL,
  `question_body` varchar(1000) NOT NULL,
  `question_a` varchar(1000) DEFAULT NULL,
  `question_b` varchar(1000) DEFAULT NULL,
  `question_c` varchar(1000) DEFAULT NULL,
  `question_d` varchar(1000) DEFAULT NULL,
  `question_answer` varchar(1000) NOT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `question_table` */

insert  into `question_table`(`question_id`,`course_id`,`teacher_id`,`question_rate`,`question_mark`,`question_type`,`question_body`,`question_a`,`question_b`,`question_c`,`question_d`,`question_answer`) values (11,'CS34901','T0001','midd',3,'D','中国共产党第十九次全国代表大会，是在全面建成小康社会决胜阶段、中国特色社会主义进入_____的关键时期召开的一次十分重要的大会。','新时期','新阶段','新征程','新时代','答案：D'),(12,'CS34901','T0001','midd',3,'B','十九大的主题是：不忘初心，____，高举中国特色社会主义伟大旗帜，决胜全面建成小康社会，夺取新时代中国特色社会主义伟大胜利，为实现中华民族伟大复兴的中国梦不懈奋斗','继续前进','牢记使命','方得始终','砥砺前行','B'),(14,'CS34901','T0001','midd',3,'A','不忘初心________。中国共产党人的初心和使命，就是为中国人民 ，为中华民族 。','方得始终 谋幸福 谋复兴','方得始终 谋生活 谋未来','牢记使命 谋幸福 谋复兴','牢记使命 谋生活 谋未来','A'),(15,'CS34901','T0001','easy',2,'B','2017年10月18日，习近平总书记在中国共产党第十九次全国代表大会上是代表 中央委员会作报告。','第十七届','第十八届','第十九届','第二十届','B'),(16,'CS34901','T0001','easy',2,'B','当前，国内外形势正在发生深刻复杂变化，我国发展仍处于重要战略 ，前景十分光明，挑战也十分严峻。','发展期','机遇期','挑战期','攻坚期','B'),(17,'CS34901','T0001','easy',2,'A','创新驱动发展战略大力实施，创新型国家建设成果丰硕， 等重大科技成果相继问世。','天宫、蛟龙、天眼、悟空、墨子、大飞机','天宫、蛟龙、天眼、神州、墨子、大飞机','天宫、蛟龙、天眼、神州、量子、大飞机','天宫、蛟龙、天眼、悟空、量子、大飞机','A'),(18,'CS34901','T0001','hard',11,'subj','说明积极发展混合所有制经济的重要意义。','null','null','null','null','首先，混合所有制为盘活国有资产存量、促进 国民经济快速增长，找到了有效的途径。把国有经济发展与民营经济发展有机结合起来形成合力。其次，混合所有制为实现政企分开，创造了产权条件。再次，混合所有制为资金大规模聚合运作以及生产要素最优配置，拓展了广阔的空间。有助于市场真正发挥配置资源的决定性作用；最后，混合所有制为国有企业顺利转型提供了有利的契机。这也有助于整个市场机制调节作用统一性的形成，改变国有经济和民营经济各自为政、市场割裂的局面，有助于市场机制更为充分地发挥调节作用。有助于抑制社会资金的投机倾向，推动实体经济调整和发展'),(19,'CS34901','T0001','hard',9,'subj','说明发展混合所有制经济的现实路径。','null','null','null','null','要允许更多国有经济和其他所有制经济发展成为混合所有制经济，国有资本投资项目允许非国有资本参股。鼓励发展非公有资本控股的混合所有制企业。允许混合所有制经济实行企业员工持股，形成资本所有者和劳动者利益共同体。'),(20,'CS31905','T0001','easy',3,'A','第一题题干','选我','选A','听B的','我错了','A'),(22,'CS31905','T0001','midd',3,'B','第二题题干','错误选项','正确选项','错误选项','错误选项','B'),(23,'CS31905','T0001','easy',3,'A','第三题题干','选A','选A','选A','选A','A');

/*Table structure for table `user_table` */

DROP TABLE IF EXISTS `user_table`;

CREATE TABLE `user_table` (
  `user_id` varchar(20) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_group` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_table` */

insert  into `user_table`(`user_id`,`user_name`,`user_password`,`user_group`) values ('A0001','于乃夫','yunaifu','admin'),('A0002','汪清瀛','wangqingying','admin'),('S0001','何一夫','yifuhe','student'),('S0002','万一鸣','wanyiming','student'),('S0003','高祖琛','gaozuchen','student'),('S0004','任永鹏','renyongpeng','student'),('S0005','曾钰城','zengyucheng','student'),('S0006','黄项宇轩','huangxiangyuxuan','student'),('S0007','张锦航','zhangjinhang','student'),('S0008','杜子健','duzijian','student'),('S0009','王腾','wangteng','student'),('T0001','刘伟','liuwei','teacher'),('T0002','王忠杰','wangzhongjie','teacher'),('T0003','徐汉川','xuhanchuan','teacher'),('T0004','吴锐','wurui','teacher'),('T0005','刘宏伟','liuhongwei','teacher'),('T0006','史先俊','shixianjun','teacher');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
