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

/*Table structure for table `classroom_table` */

DROP TABLE IF EXISTS `classroom_table`;

CREATE TABLE `classroom_table` (
  `exam_classroom` varchar(20) NOT NULL,
  `classroom_size` int(8) NOT NULL,
  `is_used` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`exam_classroom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `classroom_table` */

insert  into `classroom_table`(`exam_classroom`,`classroom_size`,`is_used`) values ('B205',30,NULL),('B207',50,NULL),('B210',45,NULL);

/*Table structure for table `comment_table` */

DROP TABLE IF EXISTS `comment_table`;

CREATE TABLE `comment_table` (
  `comment_id` int(8) NOT NULL AUTO_INCREMENT,
  `question_id` int(8) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  `comment_body` varchar(100) NOT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comment_table` */

/*Table structure for table `course_student_table` */

DROP TABLE IF EXISTS `course_student_table`;

CREATE TABLE `course_student_table` (
  `pri_id` int(8) NOT NULL AUTO_INCREMENT,
  `crs_tch_id` int(8) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  PRIMARY KEY (`pri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `course_student_table` */

insert  into `course_student_table`(`pri_id`,`crs_tch_id`,`student_id`) values (6,9,'S0001'),(7,7,'S0002');

/*Table structure for table `course_table` */

DROP TABLE IF EXISTS `course_table`;

CREATE TABLE `course_table` (
  `course_id` varchar(20) NOT NULL,
  `course_name` varchar(20) NOT NULL,
  `course_intro` varchar(100) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course_table` */

insert  into `course_table`(`course_id`,`course_name`,`course_intro`) values ('1','test1','1111'),('2','test2','2222'),('3','test3','3333'),('4','test4','4444');

/*Table structure for table `course_teacher_table` */

DROP TABLE IF EXISTS `course_teacher_table`;

CREATE TABLE `course_teacher_table` (
  `pri_id` int(8) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(20) NOT NULL,
  `teacher_id` varchar(20) NOT NULL,
  PRIMARY KEY (`pri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `course_teacher_table` */

insert  into `course_teacher_table`(`pri_id`,`course_id`,`teacher_id`) values (7,'1','T0001'),(8,'2','T0001'),(9,'1','T0003');

/*Table structure for table `error_question_table` */

DROP TABLE IF EXISTS `error_question_table`;

CREATE TABLE `error_question_table` (
  `pri_id` int(8) NOT NULL AUTO_INCREMENT,
  `question_id` int(8) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  `error_question_closed` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pri_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `error_question_table` */

/*Table structure for table `exam_history_table` */

DROP TABLE IF EXISTS `exam_history_table`;

CREATE TABLE `exam_history_table` (
  `pri_id` int(8) NOT NULL AUTO_INCREMENT,
  `exam_id` varchar(20) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `exam_history_table` */

insert  into `exam_history_table`(`pri_id`,`exam_id`,`student_id`,`mult_answer`,`subj_answer`,`mult_result`,`subj_result`,`mult_score`,`subj_score`,`is_reviewed`,`start_time`,`end_time`) values (1,'2019-07-31-20-30-1','S0001','[{\"question_id\":1,\"question_type\":\"mult\",\"student_answer\":\"A\"},{\"question_id\":6,\"question_type\":\"mult\",\"student_answer\":\"B\"},{\"question_id\":7,\"question_type\":\"mult\",\"student_answer\":\"C\"},{\"question_id\":5,\"question_type\":\"mult\",\"student_answer\":\"B\"}]','[{\"question_id\":3,\"question_type\":\"subj\",\"student_answer\":\"qwert\"},{\"question_id\":2,\"question_type\":\"subj\",\"student_answer\":\"sdfghj\"},{\"question_id\":9,\"question_type\":\"subj\",\"student_answer\":\"xcv11111555556661111111111118684456156165168461615116546284551255211111111111bnm\"},{\"question_id\":10,\"question_type\":\"subj\",\"student_answer\":\"tgyhujik\"}]','[{\"1\":0,\"5\":4,\"6\":0,\"7\":0}]',NULL,4,NULL,NULL,'2019-07-31 20:30:31','2019-07-31 20:33:31'),(2,'2019-07-31-20-30-1','S0002','[{\"question_id\":1,\"question_type\":\"mult\",\"student_answer\":\"A\"},{\"question_id\":6,\"question_type\":\"mult\",\"student_answer\":\"B\"},{\"question_id\":7,\"question_type\":\"mult\",\"student_answer\":\"C\"},{\"question_id\":5,\"question_type\":\"mult\",\"student_answer\":\"C\"}]','[{\"question_id\":3,\"question_type\":\"subj\",\"student_answer\":\"qwertyui\"},{\"question_id\":2,\"question_type\":\"subj\",\"student_answer\":\"SDFGHJKL\"},{\"question_id\":9,\"question_type\":\"subj\",\"student_answer\":\"XCVBNM,.\"},{\"question_id\":10,\"question_type\":\"subj\",\"student_answer\":\"DFGHJKL;\"}]','[{\"1\":0,\"5\":0,\"6\":0,\"7\":0}]',NULL,0,NULL,NULL,'2019-07-31 21:06:14','2019-07-31 21:09:14');

/*Table structure for table `exam_question_table` */

DROP TABLE IF EXISTS `exam_question_table`;

CREATE TABLE `exam_question_table` (
  `pri_id` int(8) NOT NULL AUTO_INCREMENT,
  `exam_id` varchar(20) NOT NULL,
  `course_id` varchar(20) NOT NULL,
  `question_id` int(8) NOT NULL,
  PRIMARY KEY (`pri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

/*Data for the table `exam_question_table` */

insert  into `exam_question_table`(`pri_id`,`exam_id`,`course_id`,`question_id`) values (59,'2019-07-30-1','1',3),(60,'2019-07-30-1','1',5),(61,'2019-07-30-1','1',10),(62,'2019-07-31-16-33-1','1',4),(63,'2019-07-31-16-33-1','1',8),(65,'2019-07-31-16-33-1','1',6),(66,'2019-07-31-16-33-1','1',9),(67,'2019-07-31-16-41-1','1',8),(68,'2019-07-31-16-41-1','1',7),(69,'2019-07-31-16-41-1','1',10),(70,'2019-07-31-20-30-1','1',3),(71,'2019-07-31-20-30-1','1',2),(72,'2019-07-31-20-30-1','1',1),(73,'2019-07-31-20-30-1','1',6),(74,'2019-07-31-20-30-1','1',7),(75,'2019-07-31-20-30-1','1',5),(76,'2019-07-31-20-30-1','1',9),(77,'2019-07-31-20-30-1','1',10);

/*Table structure for table `exam_table` */

DROP TABLE IF EXISTS `exam_table`;

CREATE TABLE `exam_table` (
  `exam_id` varchar(20) NOT NULL,
  `course_id` varchar(20) NOT NULL,
  `exam_classroom` varchar(20) NOT NULL,
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

insert  into `exam_table`(`exam_id`,`course_id`,`exam_classroom`,`teacher_id`,`easy`,`midd`,`hard`,`exam_time_start`,`exam_time_end`,`exam_length`) values ('2019-07-31-16-41-1','1','B205','T0001',00000001,00000001,00000001,'2019-08-01 00:00:00','2019-08-02 00:00:00',10),('2019-07-31-20-30-1','1','B205','T0001',00000003,00000003,00000003,'2019-01-01 00:00:00','2020-01-01 00:00:00',3);

/*Table structure for table `notice_table` */

DROP TABLE IF EXISTS `notice_table`;

CREATE TABLE `notice_table` (
  `notice_id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `course_id` varchar(20) DEFAULT NULL,
  `notice_body` varchar(100) NOT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `notice_table` */

/*Table structure for table `question_table` */

DROP TABLE IF EXISTS `question_table`;

CREATE TABLE `question_table` (
  `question_id` int(8) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(20) NOT NULL,
  `teacher_id` varchar(20) NOT NULL,
  `question_rate` varchar(20) NOT NULL,
  `question_mark` int(8) NOT NULL,
  `question_type` varchar(20) NOT NULL,
  `question_body` varchar(100) NOT NULL,
  `question_a` varchar(100) DEFAULT NULL,
  `question_b` varchar(100) DEFAULT NULL,
  `question_c` varchar(100) DEFAULT NULL,
  `question_d` varchar(100) DEFAULT NULL,
  `question_answer` varchar(100) NOT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `question_table` */

insert  into `question_table`(`question_id`,`course_id`,`teacher_id`,`question_rate`,`question_mark`,`question_type`,`question_body`,`question_a`,`question_b`,`question_c`,`question_d`,`question_answer`) values (1,'1','T0001','easy',3,'B','123123','321','432','345','456','123456'),(2,'1','T0001','easy',5,'subj','12341234','null','null','null','null','123412341'),(3,'1','T0001','easy',5,'subj','135','null','null','null','null','2345234523452'),(4,'1','T0001','easy',5,'A','123','234','345','4567','5647','ferg'),(5,'1','T0001','midd',4,'B','234','234','345','4567','5647','qwer'),(6,'1','T0001','midd',5,'C','345','456','23542','34234','234234','WERWRF'),(7,'1','T0001','midd',5,'D','23424','FGER','WRGW','ERG','ERG','ERG'),(8,'1','T0001','easy',10,'subj','123124','null','null','null','null','SGHET'),(9,'1','T0001','hard',12,'subj','UGIGJKH','null','null','null','null','FGTRGW'),(10,'1','T0001','hard',13,'subj','QWE3QWDQ','null','null','null','null','456345');

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

insert  into `user_table`(`user_id`,`user_name`,`user_password`,`user_group`) values ('A0001','于乃夫','yunaifu','admin'),('A0002','汪清瀛','wangqingying','admin'),('S0001','何一夫','234','student'),('S0002','万一鸣','234','student'),('S0003','高祖琛','gaozuchen','student'),('S0004','任永鹏','renyongpeng','student'),('S0005','曾钰城','zengyucheng','student'),('S0006','黄项宇轩','huangxiangyuxuan','student'),('S0007','张锦航','zhangjinhang','student'),('S0008','杜子健','duzijian','student'),('S0009','王腾','wangteng','student'),('T0001','刘伟','123','teacher'),('T0002','王忠杰','wangzhongjie','teacher'),('T0003','徐汉川','xuhanchuan','teacher'),('T0004','吴锐','wurui','teacher'),('T0005','刘宏伟','liuhongwei','teacher'),('T0006','史先俊','shixianjun','teacher');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
