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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course_student_table` */

/*Table structure for table `course_table` */

DROP TABLE IF EXISTS `course_table`;

CREATE TABLE `course_table` (
  `course_id` varchar(20) NOT NULL,
  `course_name` varchar(20) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course_table` */

/*Table structure for table `course_teacher_table` */

DROP TABLE IF EXISTS `course_teacher_table`;

CREATE TABLE `course_teacher_table` (
  `pri_id` int(8) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(20) NOT NULL,
  `teacher_id` varchar(20) NOT NULL,
  PRIMARY KEY (`pri_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course_teacher_table` */

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
  `student_answer` varchar(200) NOT NULL,
  `student_score` int(8) NOT NULL,
  PRIMARY KEY (`pri_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `exam_history_table` */

/*Table structure for table `exam_question_table` */

DROP TABLE IF EXISTS `exam_question_table`;

CREATE TABLE `exam_question_table` (
  `pri_id` int(8) NOT NULL AUTO_INCREMENT,
  `exam_id` varchar(20) NOT NULL,
  `course_id` varchar(20) NOT NULL,
  `question_id` int(8) NOT NULL,
  PRIMARY KEY (`pri_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `exam_question_table` */

/*Table structure for table `exam_table` */

DROP TABLE IF EXISTS `exam_table`;

CREATE TABLE `exam_table` (
  `exam_id` varchar(20) NOT NULL,
  `course_id` varchar(20) NOT NULL,
  `exam_classroom` varchar(20) NOT NULL,
  `teacher_id` varchar(20) NOT NULL,
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `exam_table` */

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
  `course_name` varchar(20) NOT NULL,
  `teacher_name` varchar(20) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `question_table` */

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

insert  into `user_table`(`user_id`,`user_name`,`user_password`,`user_group`) values ('A0001','于乃夫','yunaifu','admin'),('A0002','汪清瀛','wangqingying','admin'),('S0001','何一夫','heyifu','student'),('S0002','万一鸣','wanyiming','student'),('S0003','高祖琛','gaozuchen','student'),('S0004','任永鹏','renyongpeng','student'),('S0005','曾钰城','zengyucheng','student'),('S0006','黄项宇轩','huangxiangyuxuan','student'),('S0007','张锦航','zhangjinhang','student'),('S0008','杜子健','duzijian','student'),('S0009','王腾','wangteng','student'),('T0001','刘伟','liuwei','teacher'),('T0002','王忠杰','wangzhongjie','teacher'),('T0003','徐汉川','xuhanchuan','teacher'),('T0004','吴锐','wurui','teacher'),('T0005','刘宏伟','liuhongwei','teacher'),('T0006','史先俊','shixianjun','teacher');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
