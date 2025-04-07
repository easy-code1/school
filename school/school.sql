-- MariaDB dump 10.19  Distrib 10.5.11-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: school
-- ------------------------------------------------------
-- Server version	10.5.11-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `community`
--

DROP TABLE IF EXISTS `community`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `community` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `writeday` date DEFAULT NULL,
  `cla` int(11) DEFAULT NULL,
  `readnum` int(11) DEFAULT 0,
  `ofname` varchar(100) DEFAULT NULL,
  `sfname` varchar(100) DEFAULT NULL,
  `userid` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `community_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `teacher` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community`
--

LOCK TABLES `community` WRITE;
/*!40000 ALTER TABLE `community` DISABLE KEYS */;
INSERT INTO `community` VALUES (1,'이번주에 특별 감사가 실시될 예정입니다.','하하하\r\n\r\n모두 열심히 준비하세요','2025-03-31',1,0,NULL,NULL,'admin'),(2,'오늘은 즐거운 월요일입니다.','열심히 공부합시다\r\n\r\n하하하','2025-03-31',2,1,NULL,NULL,'admin'),(3,'MyUtil파일을 올립니다.','참고하세요\r\n\r\n하하하','2025-03-31',3,4,'MyUtil.java','MyUtil.java','admin'),(4,'홍길동이 알려드립니다.','오늘은 월요일입니다.\r\n\r\n하ㅏㅎ하','2025-03-31',2,1,NULL,NULL,'hong'),(5,'홍길동이가 좋아하는 사진입니다.','이쁘죠\r\n\r\n하ㅏ핳','2025-03-31',3,6,'b4.gif','b4.gif','hong'),(6,'배트맨이 알려드립니다.','오늘 점심은 돈까스입니다.\r\n\r\n하하하','2025-03-31',2,0,NULL,NULL,'batman'),(7,'배트맨은 이 사진을 좋아합니다.','천천히!!\r\n\r\n공부도 천천히 열심히!!','2025-03-31',3,6,'b1.jpg','b1.jpg','batman'),(8,'내일은 지각하지 말고 전부 오세요','하하하\r\n\r\n호호호','2025-03-31',1,5,NULL,NULL,'hong'),(9,'putty파일입니다.','리눅스서버에 텔넷으로 접속하는 프로그램입니다','2025-03-31',3,5,'PuTTY_V0.83.msi','PuTTY_V0.83.msi','hong'),(10,'점심 먹고 나니 졸려요','그래도 열심히\r\n\r\n합시다','2025-03-31',2,4,NULL,NULL,'admin'),(11,'날씨가 봄이 되네요!!  ','하하하\r\n \r\n호호호\r\n\r\n ','2025-03-31',2,5,NULL,NULL,'batman'),(12,'aaa','bbb',NULL,NULL,0,NULL,NULL,'hong'),(15,'오늘은 화요일입니다.','ㅎㅎㅎ','2025-04-01',3,2,'b1.jpg','b11743468308710.jpg','hong');
/*!40000 ALTER TABLE `community` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memo`
--

DROP TABLE IF EXISTS `memo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `ofname` varchar(100) DEFAULT NULL,
  `writeday` datetime DEFAULT NULL,
  `seUserid` char(10) DEFAULT NULL,
  `reUserid` char(10) DEFAULT NULL,
  `state` int(11) DEFAULT 0,
  `sfname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `seUserid` (`seUserid`),
  KEY `reUserid` (`reUserid`),
  CONSTRAINT `memo_ibfk_1` FOREIGN KEY (`seUserid`) REFERENCES `teacher` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `memo_ibfk_2` FOREIGN KEY (`reUserid`) REFERENCES `teacher` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memo`
--

LOCK TABLES `memo` WRITE;
/*!40000 ALTER TABLE `memo` DISABLE KEYS */;
INSERT INTO `memo` VALUES (2,'배트맨안녕','즐거운 화요일 ',NULL,'2025-04-01 15:30:54','hong','batman',1,NULL),(3,'java파일을 보낸다','화이팅!! ','MyUtil.java','2025-04-01 15:32:03','hong','batman',1,'MyUtil1743489123030.java'),(4,'뽀로로야 잘지내니','하하하',NULL,'2025-04-01 15:32:18','hong','pororo',0,NULL),(6,'안녕!! 길동아!!','하하하',NULL,'2025-04-01 15:51:23','batman','hong',1,NULL),(9,'뭐해요','학교종이 \r\n땡땡땡 \r\n어서모이자\r\n선생님이\r\n우리를 \r\n기다리신다.',NULL,'2025-04-02 11:31:20','batman','pororo',0,NULL),(10,'사진 보냅니다','하하하\r\n\r\n호호호\r\n\r\n헤헤헤','a3.jpg','2025-04-02 11:31:44','batman','pororo',0,'a3.jpg'),(11,'응 잘먹고 잘 산다','ㅁㄴㅇㄻㄴㅇㄹ',NULL,'2025-04-02 14:51:13','pororo','hong',1,NULL);
/*!40000 ALTER TABLE `memo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ban` int(11) DEFAULT NULL,
  `bunho` int(11) DEFAULT NULL,
  `name` char(10) DEFAULT NULL,
  `phone` char(20) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `delstate` int(11) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (3,1,1,'김순이','010-1346-4646','2007-08-15',0),(4,1,2,'박순기','010-1234-1234','2008-09-07',0),(5,1,3,'박철순','010-4671-4646','2006-09-20',0),(6,1,4,'신나리','010-7979-4646','2006-12-20',0),(7,1,5,'김건우','010-1212-4646','2006-08-03',0),(8,1,6,'박노준','010-1973-4169','2007-10-20',0),(9,1,7,'최동원','010-1474-7914','2008-11-06',0),(10,1,8,'유두열','010-7163-1646','2007-07-05',0),(11,1,9,'이대호','010-7415-6416','2006-12-10',0),(12,1,10,'전준우','010-7444-6767','2007-03-01',0),(13,3,1,'홍명보','','2025-01-01',0),(14,3,2,'차범근','010-7646-1843','2006-04-12',0),(15,3,3,'안정환','010-1111-2222','2007-03-20',0),(16,3,4,'고정운','010-2222-3333','2006-05-09',0),(17,3,5,'서정원','010-7777-8888','2006-10-15',0),(18,3,6,'손흥민','010-7944-7979','2006-10-17',0),(19,3,7,'이강인','010-7171-8181','2006-08-16',0),(20,3,8,'김민재','010-0101-4616','2007-09-11',0),(21,3,9,'황선홍','010-1241-3461','2006-08-18',0),(22,3,10,'박지성','010-1478-5944','2007-05-16',0),(23,2,1,'1루수','010-4646-7979','2006-03-20',0),(24,2,2,'2루수','010-1467-4646','2006-12-27',0),(25,2,3,'3루수','010-7979-4646','2006-11-15',0),(26,2,4,'유격수','010-7777-8888','2007-11-18',0),(27,2,5,'좌익수','010-1144-5566','2006-09-30',0),(28,2,6,'중견수','010-2222-3333','2007-12-04',0),(29,2,7,'우익수','010-5555-7777','2006-03-19',0),(30,2,8,'투수','010-1111-7777','2007-03-04',0),(31,2,9,'포수','010-7979-1311','2006-11-30',0),(32,2,10,'감독','010-7946-1376','2007-07-07',0);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) DEFAULT NULL,
  `ban` int(11) DEFAULT NULL,
  `userid` char(10) NOT NULL,
  `pwd` char(10) DEFAULT NULL,
  `name` char(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` char(20) DEFAULT NULL,
  `writeday` date DEFAULT NULL,
  `delstate` int(11) DEFAULT 0,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,100,0,'admin','1234','관리자','admin@naver.com','010-1111-2222','2025-03-31',0),(3,50,2,'batman','1234','배트맨','batman@naver.com','010-7777-8888','2025-03-31',0),(2,80,1,'hong','1234','홍길동','hong@naver.com','010-1313-4646','2025-03-31',0),(4,50,3,'pororo','1234','뽀로로','pororo@naver.com','010-1234-1234','2025-04-01',0);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-03 15:39:59
