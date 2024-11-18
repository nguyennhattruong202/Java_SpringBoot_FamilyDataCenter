-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fdcdb
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `id_number` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updated_date` datetime NOT NULL,
  `created_date` datetime NOT NULL,
  `note` tinytext COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'Lê Thị Rí','Nữ','1954-01-01','0865761892','','072154002560','Ấp Giữa, xã Hiệp Thạnh, huyện Gò Dầu, tỉnh Tây Ninh','2024-11-01 13:57:26','2024-11-01 13:57:26','');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `fullname` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_of_birth` date NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `id` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  `note` tinytext COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'Test 22','Nam','2001-02-21','0909887654',NULL,NULL,NULL,'123456','ROLE_USER','2024-11-02 09:50:20','2024-11-14 12:10:52',NULL),(3,'Test 3','Nữ','2001-08-21','0909887000',NULL,NULL,NULL,'43434343','ROLE_USER','2024-11-02 09:55:54','2024-11-02 09:55:54',NULL),(4,'Test 4','Nam','2005-08-21','0909887088',NULL,NULL,NULL,'43434346','ROLE_USER','2024-11-02 11:31:28','2024-11-02 11:31:28',NULL),(5,'Persion 5','Nam','2002-08-21','0909887087',NULL,NULL,NULL,'43434346','ROLE_USER','2024-11-02 11:33:26','2024-11-02 11:33:26',NULL),(6,'Demo 1','Nam','2002-08-21','0899566789',NULL,NULL,NULL,'12345678','USER','2024-11-11 12:36:23','2024-11-11 12:36:23',NULL),(7,'Demo 2','Nam','2002-08-22','0899566709',NULL,NULL,NULL,'12345678','USER','2024-11-11 13:28:36','2024-11-11 13:28:36',NULL),(9,'Demo 3','Nam','2002-08-22','0899566707',NULL,NULL,NULL,'123456','USER','2024-11-11 14:36:16','2024-11-11 14:36:16',NULL),(10,'Demo 3','Nam','2002-08-22','0899566717',NULL,NULL,NULL,'1234','USER','2024-11-11 14:40:06','2024-11-11 14:40:06',NULL),(11,'Nguyen Nhat Truong','Nam','2001-12-12','0998776112',NULL,NULL,NULL,'123456','USER','2024-11-14 12:06:35','2024-11-14 12:06:35',NULL),(12,'Demo 4','Nam','2001-12-12','0998776165',NULL,NULL,NULL,'$2a$10$5gmjDT5RS9etzBDWYs3uuuQg7hv4Ph0PSQUJUXUSaHVwJk5yHfGiW','USER','2024-11-18 10:46:33','2024-11-18 10:46:33',NULL),(13,'Demo 5','Nam','2001-12-12','0998776167',NULL,NULL,NULL,'$2a$10$xQStz2G/Ngrt0XPMb7cnoulqQ4fFb17sh63Gg9KpKPaUv.p8Gicpm','USER','2024-11-18 11:48:24','2024-11-18 11:48:24',NULL),(14,'admin','Nam','2001-02-20','0865761892','nhattruongnguyen202@gmail.com',NULL,NULL,'$2a$10$W5b/kKupA5ss0b54HGKalO9iDYeuIJnyFLvYKveHhx9p57VOJwCPa','ADMIN','2024-11-18 22:12:19','2024-11-18 22:12:19',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_demo`
--

DROP TABLE IF EXISTS `user_demo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_demo` (
  `id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fullname` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_of_birth` date NOT NULL,
  `email` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_demo`
--

LOCK TABLES `user_demo` WRITE;
/*!40000 ALTER TABLE `user_demo` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_demo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-18 23:01:21
