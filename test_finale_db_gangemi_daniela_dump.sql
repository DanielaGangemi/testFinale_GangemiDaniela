-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: test_finale_gangemi_daniela
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id_city` int NOT NULL AUTO_INCREMENT,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `id_weather_forecast` int DEFAULT NULL,
  PRIMARY KEY (`id_city`),
  KEY `id_weather_forecast` (`id_weather_forecast`),
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`id_weather_forecast`) REFERENCES `weather_forecast` (`id_weather_forecast`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,38.1939,15.5526,'Messina',NULL),(2,37.4922,15.0704,'Catania',NULL),(3,38.132,13.3356,'Palermo',NULL);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hourly`
--

DROP TABLE IF EXISTS `hourly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hourly` (
  `id_hourly` int NOT NULL AUTO_INCREMENT,
  `time` date DEFAULT NULL,
  `temperature_2m` double DEFAULT NULL,
  `relative_humidity_2m` int DEFAULT NULL,
  `precipitation_probability` int DEFAULT NULL,
  `id_weather_forecast` int DEFAULT NULL,
  PRIMARY KEY (`id_hourly`),
  KEY `id_weather_forecast` (`id_weather_forecast`),
  CONSTRAINT `hourly_ibfk_1` FOREIGN KEY (`id_weather_forecast`) REFERENCES `weather_forecast` (`id_weather_forecast`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hourly`
--

LOCK TABLES `hourly` WRITE;
/*!40000 ALTER TABLE `hourly` DISABLE KEYS */;
/*!40000 ALTER TABLE `hourly` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hourly_units`
--

DROP TABLE IF EXISTS `hourly_units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hourly_units` (
  `id_hourly_units` int NOT NULL AUTO_INCREMENT,
  `time` varchar(255) DEFAULT NULL,
  `temperature_2m` varchar(255) DEFAULT NULL,
  `relative_humidity_2m` varchar(255) DEFAULT NULL,
  `precipitation_probability` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_hourly_units`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hourly_units`
--

LOCK TABLES `hourly_units` WRITE;
/*!40000 ALTER TABLE `hourly_units` DISABLE KEYS */;
/*!40000 ALTER TABLE `hourly_units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Daniela','Gangemi','danielagangemi@boh.com','b83cb68a006bf684628aaae5775e3794fe4d9ee57bb3d5c9173772b5cd4a4a94');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_city`
--

DROP TABLE IF EXISTS `user_city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_city` (
  `id_user` int NOT NULL,
  `id_city` int NOT NULL,
  PRIMARY KEY (`id_user`,`id_city`),
  KEY `id_city` (`id_city`),
  CONSTRAINT `user_city_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  CONSTRAINT `user_city_ibfk_2` FOREIGN KEY (`id_city`) REFERENCES `city` (`id_city`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_city`
--

LOCK TABLES `user_city` WRITE;
/*!40000 ALTER TABLE `user_city` DISABLE KEYS */;
INSERT INTO `user_city` VALUES (1,1);
/*!40000 ALTER TABLE `user_city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weather_forecast`
--

DROP TABLE IF EXISTS `weather_forecast`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weather_forecast` (
  `id_weather_forecast` int NOT NULL AUTO_INCREMENT,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `generationtime_ms` double DEFAULT NULL,
  `utc_offset_seconds` double DEFAULT NULL,
  `timezone` varchar(255) DEFAULT NULL,
  `timezone_abbreviation` varchar(255) DEFAULT NULL,
  `elevation` int DEFAULT NULL,
  `id_hourly_units` int DEFAULT NULL,
  PRIMARY KEY (`id_weather_forecast`),
  KEY `id_hourly_units` (`id_hourly_units`),
  CONSTRAINT `weather_forecast_ibfk_1` FOREIGN KEY (`id_hourly_units`) REFERENCES `hourly_units` (`id_hourly_units`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weather_forecast`
--

LOCK TABLES `weather_forecast` WRITE;
/*!40000 ALTER TABLE `weather_forecast` DISABLE KEYS */;
/*!40000 ALTER TABLE `weather_forecast` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-14 18:03:15
