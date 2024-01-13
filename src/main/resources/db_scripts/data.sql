SET FOREIGN_KEY_CHECKS=0;

--
-- Dumping data for table `authorities`
--
LOCK TABLES `authorities` WRITE;
INSERT INTO `authorities` VALUES
('admin','ROLE_ADMIN'),
('user','ROLE_CLIENT'),
('user2','ROLE_CLIENT'),
('victor','ROLE_DENTIST');
UNLOCK TABLES;

--
-- Dumping data for table `dentist`
--
LOCK TABLES `dentist` WRITE;
INSERT INTO `dentist` VALUES
(1,'ВІКТОР','/img/team1.jpg',1),
(2,'ЛЕСЯ','/img/team2.jpg',1),
(3,'ДАНИЛО','/img/team3.jpg',1),
(4,'МАРІЯ','/img/team4.jpg',0),
(5,'ІРИНА','/img/team5.jpg',0),
(6,'ЮЛІЯ','/img/team6.jpg',0);
UNLOCK TABLES;

--
-- Dumping data for table `journal`
--
LOCK TABLES `journal` WRITE;
INSERT INTO `journal` VALUES
(1,'2023-05-04 10:00:00.000000',1,NULL,1,2),
(2,'2023-04-05 13:00:00.000000',1,NULL,1,2),
(3,'2023-04-03 10:00:00.000000',1,NULL,3,8),
(4,'2023-04-28 18:00:00.000000',1,NULL,2,4),
(5,'2023-04-26 11:00:00.000000',1,NULL,3,1);
UNLOCK TABLES;

--
-- Dumping data for table `patient`
--
LOCK TABLES `patient` WRITE;
INSERT INTO `patient` VALUES
(1,'Олег','1234567890','user'),
(2,'Віталій','1234567890','user2');
UNLOCK TABLES;

--
-- Dumping data for table `service`
--
LOCK TABLES `service` WRITE;
INSERT INTO `service` VALUES
(1,1,'Цифрова стоматологія CEREC'),
(2,1,'Лікування зубів'),
(3,1,'Пародонтологія'),
(4,1,'Хірургія'),
(5,1,'Протезування'),
(6,1,'Дитяча стоматологія'),
(7,1,'Ортодонтія'),
(8,1,'Відбілювання'),
(9,1,'Імплантація');
UNLOCK TABLES;

--
-- Dumping data for table `users`
--
LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES
('admin','$2a$10$lWd3CbJu1Q1JZsfgUH1QG.2J9mPXlaW6fJn.m5nU/F3A4TC22PxDW',1),
('user','$2a$10$lWd3CbJu1Q1JZsfgUH1QG.2J9mPXlaW6fJn.m5nU/F3A4TC22PxDW',1),
('user2','$2a$10$lWd3CbJu1Q1JZsfgUH1QG.2J9mPXlaW6fJn.m5nU/F3A4TC22PxDW',1),
('victor','$2a$10$lWd3CbJu1Q1JZsfgUH1QG.2J9mPXlaW6fJn.m5nU/F3A4TC22PxDW',1);
UNLOCK TABLES;


LOCK TABLES `dentistCalendar` WRITE;
INSERT INTO `dentistCalendar` VALUES
(1,'2023-06-01 10:00:00.000000',1),
(2,'2023-06-01 11:00:00.000000',1),
(3,'2023-06-01 12:00:00.000000',1),
(4,'2023-06-01 13:00:00.000000',1),
(5,'2023-06-01 14:00:00.000000',1),
(6,'2023-06-02 10:00:00.000000',1),
(7,'2023-06-02 11:00:00.000000',1),
(8,'2023-06-02 12:00:00.000000',1),
(9,'2023-06-02 13:00:00.000000',1),
(10,'2023-06-02 14:00:00.000000',1),
(11,'2023-06-03 10:00:00.000000',1),
(12,'2023-06-03 11:00:00.000000',1),
(13,'2023-06-03 12:00:00.000000',1),
(14,'2023-06-03 13:00:00.000000',1),
(15,'2023-06-03 14:00:00.000000',1);
UNLOCK TABLES;


---- ------------------------------------------------------------------
----
---- Dumping data for table `dentist_seq`
----
--LOCK TABLES `dentist_seq` WRITE;
--INSERT INTO `dentist_seq` VALUES (7);
--UNLOCK TABLES;
--
----
---- Dumping data for table `journal_seq`
----
--LOCK TABLES `journal_seq` WRITE;
--INSERT INTO `journal_seq` VALUES (6);
--UNLOCK TABLES;
--
----
---- Dumping data for table `patient_seq`
----
--LOCK TABLES `patient_seq` WRITE;
--INSERT INTO `patient_seq` VALUES (3);
--UNLOCK TABLES;

SET FOREIGN_KEY_CHECKS=1;
