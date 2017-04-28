DROP DATABASE IF EXISTS `otcs` ;


CREATE DATABASE `otcs` /*!40100 DEFAULT CHARACTER SET UTF8 */;
USE `otcs`;
SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `answer` (
    `answer_id` INT(11) NOT NULL AUTO_INCREMENT,
    `description` VARCHAR(255) DEFAULT NULL,
    `isRightAnswer` TINYINT(1) NOT NULL,
    PRIMARY KEY (`answer_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE `question` (
    `question_id` INT(11) NOT NULL AUTO_INCREMENT,
    `description` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (`question_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE `category` (
    `cat_id` INT(11) NOT NULL AUTO_INCREMENT,
    `description` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (`cat_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;




CREATE TABLE `grade` (
    `grade_id` INT(11) NOT NULL AUTO_INCREMENT,
    `grade` VARCHAR(255) DEFAULT NULL,
    `max` FLOAT NOT NULL,
    `min` FLOAT NOT NULL,
    PRIMARY KEY (`grade_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;



CREATE TABLE `role` (
    `role_id` INT(11) NOT NULL AUTO_INCREMENT,
    `role_name` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (`role_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE `sub_category` (
    `sub_cat_id` INT(11) NOT NULL AUTO_INCREMENT,
    `description` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (`sub_cat_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE `test` (
    `test_id` INT(11) NOT NULL AUTO_INCREMENT,
    `session_key` VARCHAR(255) DEFAULT NULL,
    `test_date` DATETIME DEFAULT NULL,
    PRIMARY KEY (`test_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;


CREATE TABLE `test_question` (
    `test_question_id` INT(11) NOT NULL AUTO_INCREMENT,
    `answer` INT(11) NOT NULL,
    `question_id` INT(11) DEFAULT NULL,
    PRIMARY KEY (`test_question_id`),
    KEY `FKA3D9C0F370CE7C7F` (`question_id`),
    CONSTRAINT `FKA3D9C0F370CE7C7F` FOREIGN KEY (`question_id`)
        REFERENCES `question` (`question_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE `user` (
    `user_id` INT(11) NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(255) DEFAULT NULL,
    `first_name` VARCHAR(255) DEFAULT NULL,
    `last_name` VARCHAR(255) DEFAULT NULL,
    `password` VARCHAR(255) DEFAULT NULL,
    `userName` VARCHAR(255) DEFAULT NULL,
    `coach_id` INT(11) DEFAULT NULL,
    PRIMARY KEY (`user_id`),
    KEY `FK285FEBBBE041B0` (`coach_id`),
    CONSTRAINT `FK285FEBBBE041B0` FOREIGN KEY (`coach_id`)
        REFERENCES `user` (`user_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE `user_role` (
    `user_id` INT(11) NOT NULL,
    `role_id` INT(11) NOT NULL,
    KEY `FK143BF46A46DE7CFF` (`role_id`),
    KEY `FK143BF46AEC0940DF` (`user_id`),
    CONSTRAINT `FK143BF46A46DE7CFF` FOREIGN KEY (`role_id`)
        REFERENCES `role` (`role_id`),
    CONSTRAINT `FK143BF46AEC0940DF` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`user_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE `user_test` (
    `user_id` INT(11) NOT NULL,
    `test_id` INT(11) NOT NULL,
    UNIQUE KEY `test_id` (`test_id`),
    KEY `FK143CB886EC0940DF` (`user_id`),
    KEY `FK143CB886A004B77F` (`test_id`),
    CONSTRAINT `FK143CB886A004B77F` FOREIGN KEY (`test_id`)
        REFERENCES `test` (`test_id`),
    CONSTRAINT `FK143CB886EC0940DF` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`user_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE `cat_subcat` (
    `cat_id` INT(11) NOT NULL,
    `sub_cat_id` INT(11) NOT NULL,
    UNIQUE KEY `sub_cat_id` (`sub_cat_id`),
    KEY `FK24A93A1F89BDC9BC` (`sub_cat_id`),
    KEY `FK24A93A1F2E51F3A7` (`cat_id`),
    CONSTRAINT `FK24A93A1F2E51F3A7` FOREIGN KEY (`cat_id`)
        REFERENCES `category` (`cat_id`),
    CONSTRAINT `FK24A93A1F89BDC9BC` FOREIGN KEY (`sub_cat_id`)
        REFERENCES `sub_category` (`sub_cat_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;


CREATE TABLE `question_subcat` (
    `sub_cat_id` INT(11) NOT NULL,
    `question_id` INT(11) NOT NULL,
    UNIQUE KEY `question_id` (`question_id`),
    KEY `FK752FCC0F89BDC9BC` (`sub_cat_id`),
    KEY `FK752FCC0F70CE7C7F` (`question_id`),
    CONSTRAINT `FK752FCC0F70CE7C7F` FOREIGN KEY (`question_id`)
        REFERENCES `question` (`question_id`),
    CONSTRAINT `FK752FCC0F89BDC9BC` FOREIGN KEY (`sub_cat_id`)
        REFERENCES `sub_category` (`sub_cat_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;


CREATE TABLE `question_answer` (
    `question_id` INT(11) NOT NULL,
    `answer_id` INT(11) NOT NULL,
    UNIQUE KEY `answer_id` (`answer_id`),
    KEY `FK561DF2373D152ABF` (`answer_id`),
    KEY `FK561DF23770CE7C7F` (`question_id`),
    CONSTRAINT `FK561DF2373D152ABF` FOREIGN KEY (`answer_id`)
        REFERENCES `answer` (`answer_id`),
    CONSTRAINT `FK561DF23770CE7C7F` FOREIGN KEY (`question_id`)
        REFERENCES `question` (`question_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `test_testquestion` (
    `test_id` INT(11) NOT NULL,
    `test_question_id` INT(11) NOT NULL,
    UNIQUE KEY `test_question_id` (`test_question_id`),
    KEY `FKA570710553867B95` (`test_question_id`),
    KEY `FKA5707105A004B77F` (`test_id`),
    CONSTRAINT `FKA570710553867B95` FOREIGN KEY (`test_question_id`)
        REFERENCES `test_question` (`test_question_id`),
    CONSTRAINT `FKA5707105A004B77F` FOREIGN KEY (`test_id`)
        REFERENCES `test` (`test_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

SET FOREIGN_KEY_CHECKS=1;