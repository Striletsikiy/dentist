DROP DATABASE IF EXISTS `dentist`;
CREATE DATABASE `dentist` CHARACTER SET utf8mb4;
USE `dentist`;



--
-- Table structure for table `users`
--
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `authorities`
--
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `dentist`
--
DROP TABLE IF EXISTS `dentist`;
CREATE TABLE `dentist` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `service`
--
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `id` bigint NOT NULL,
  `active` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `patient`
--
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `journal`
--
DROP TABLE IF EXISTS `journal`;
CREATE TABLE `journal` (
  `id` bigint NOT NULL,
  `date` datetime(6) NOT NULL,
  `patient_id` bigint NOT NULL,
  `dentist_id` bigint NOT NULL,
  `service_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `patient` (`patient_id`),
  KEY `dentist` (`dentist_id`),
  KEY `service` (`service_id`),
  CONSTRAINT `dentist` FOREIGN KEY (`dentist_id`) REFERENCES `dentist` (`id`),
  CONSTRAINT `service` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`),
  CONSTRAINT `patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `dentistCalendar`;
CREATE TABLE `dentistCalendar` (
  `id` bigint NOT NULL,
  `date` datetime(6) NOT NULL,
  `dentist_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `dentist` FOREIGN KEY (`dentist_id`) REFERENCES `dentist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

----
---- Table structure for table `dentist_seq`
----
--DROP TABLE IF EXISTS `dentist_seq`;
--CREATE TABLE `dentist_seq` (
--  `next_val` bigint DEFAULT NULL
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
----
---- Table structure for table `journal_seq`
----
--DROP TABLE IF EXISTS `journal_seq`;
--CREATE TABLE `journal_seq` (
--  `next_val` bigint DEFAULT NULL
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
--DROP TABLE IF EXISTS `patient_seq`;
--CREATE TABLE `patient_seq` (
--  `next_val` bigint DEFAULT NULL
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
----
---- Table structure for table `service_seq`
----
--DROP TABLE IF EXISTS `service_seq`;
--CREATE TABLE `service_seq` (
--  `next_val` bigint DEFAULT NULL
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
