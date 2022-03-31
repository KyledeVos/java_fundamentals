CREATE DATABASE  IF NOT EXISTS `air_travel` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `air_travel`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: air_travel
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `airlines`
--

DROP TABLE IF EXISTS `airlines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airlines` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airlines`
--

LOCK TABLES `airlines` WRITE;
/*!40000 ALTER TABLE `airlines` DISABLE KEYS */;
INSERT INTO `airlines` VALUES (1,'Qatar Airways'),(2,'Virgin Atlantic Airways'),(3,'British Airways'),(4,'South African Airways'),(5,'Korean Air'),(6,'Thai Airways'),(7,'Emirates'),(8,'Delta');
/*!40000 ALTER TABLE `airlines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flights`
--

DROP TABLE IF EXISTS `flights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flights` (
  `id` int NOT NULL AUTO_INCREMENT,
  `start_id` int NOT NULL,
  `end_id` int NOT NULL,
  `airline_id` int NOT NULL,
  `flight_time` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `start_id_idx` (`start_id`),
  KEY `end_id_idx` (`end_id`),
  KEY `airline_id_idx` (`airline_id`),
  CONSTRAINT `airline_id` FOREIGN KEY (`airline_id`) REFERENCES `airlines` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `end_id` FOREIGN KEY (`end_id`) REFERENCES `locations` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `start_id` FOREIGN KEY (`start_id`) REFERENCES `locations` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flights`
--

LOCK TABLES `flights` WRITE;
/*!40000 ALTER TABLE `flights` DISABLE KEYS */;
INSERT INTO `flights` VALUES (1,1,4,7,'2022-03-01'),(2,1,3,7,'2022-03-01'),(3,6,17,8,'2022-03-01'),(4,9,1,8,'2022-03-01'),(5,21,25,2,'2022-03-01'),(6,6,17,8,'2022-03-01'),(7,5,24,4,'2022-03-02'),(8,20,11,5,'2022-03-02'),(9,16,1,4,'2022-03-02'),(10,16,19,6,'2022-03-02'),(11,18,1,6,'2022-03-02'),(12,22,8,1,'2022-03-03'),(13,22,8,1,'2022-03-03'),(14,7,9,8,'2022-03-03'),(15,15,25,1,'2022-03-03'),(16,23,12,6,'2022-03-03'),(17,19,18,4,'2022-03-03'),(18,24,3,8,'2022-03-03'),(19,11,17,7,'2022-03-04'),(20,25,21,8,'2022-03-04'),(21,5,1,4,'2022-03-04'),(22,22,23,2,'2022-03-06'),(23,1,2,4,'2022-05-01'),(24,4,8,7,'2022-05-07'),(25,24,14,6,'2022-05-23'),(26,25,9,8,'2022-06-15'),(27,16,12,5,'2022-06-15'),(28,22,7,5,'2022-06-15'),(29,25,5,7,'2022-06-17'),(30,21,1,3,'2022-07-01');
/*!40000 ALTER TABLE `flights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'Johannesburg'),(2,'Paris'),(3,'New York'),(4,'Sydney'),(5,'Cape Town'),(6,'Cairo'),(7,'Beijing'),(8,'Rio De Janerio'),(9,'Washington DC'),(10,'Tokyo'),(11,'London'),(12,'Moscow'),(13,'Kiev'),(14,'Amsterdam'),(15,'Harare'),(16,'Perth'),(17,'Frankfurt'),(18,'Durban'),(19,'Glasgow'),(20,'Gaborone'),(21,'Mexico City'),(22,'Mauritius'),(23,'Dubai'),(24,' Toronto'),(25,'Miami');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passengers`
--

DROP TABLE IF EXISTS `passengers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passengers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(300) NOT NULL,
  `last_name` varchar(300) NOT NULL,
  `email` varchar(300) NOT NULL,
  `meal_pref` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passengers`
--

LOCK TABLES `passengers` WRITE;
/*!40000 ALTER TABLE `passengers` DISABLE KEYS */;
INSERT INTO `passengers` VALUES (1,'kyle','Lally','klally@gmail.com','chicken'),(2,'Ivan','Barry','ibar@gmail.com','beef'),(3,'Graeme','Backson','gback@outlook.com','vegetarian'),(4,'Amanda','Libya','alib@googleMail.org','veafood'),(5,'Homer','Simpson','homer@fox.com','beef'),(6,'Lisa','Simpson','lisa@fox.com','vegetarian'),(7,'Marge','Simpson','marge@gmail.com','chicken'),(8,'Bart','Simpson','bart@fox.com','chicken'),(9,'Dipper','Pines','dipper@disney.com','seafood'),(10,'Mable','Pines','mable@disney.com','beef'),(11,'Stan','Pines','stan@disney.com','chicken'),(12,'Tony','Stark','tony@avengers.com','chicken'),(13,'Steve',' Rodgers','steve@avengers.com','beef'),(14,'Natasha','Romanoff','natasha@avengers.com','chicken'),(15,'Clint','Barton','clint@avengers.com','seafood'),(16,'Yelena','Belova','yelena@avengers,com','chicken'),(17,'Harry','Potter','harry@hogwarts.com','beef'),(18,'Hermoine','Granger','hermoine@hogwarts.com','chicken'),(19,'Ron','Weasley','ron@hogwarts.com','beef'),(20,'Albus','Dumbledoor','albus@hogwarts.com','vegetarian');
/*!40000 ALTER TABLE `passengers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `passenger_id` int NOT NULL,
  `flight_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `passenger_id_idx` (`passenger_id`),
  KEY `flight_id_idx` (`flight_id`),
  CONSTRAINT `flight_id` FOREIGN KEY (`flight_id`) REFERENCES `flights` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `passenger_id` FOREIGN KEY (`passenger_id`) REFERENCES `passengers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (1,1,2),(2,3,4),(3,2,7),(4,1,24),(5,10,5),(6,11,5),(7,12,5),(8,2,24),(9,18,14),(10,19,14),(11,6,7),(12,10,22),(13,4,1),(14,5,2),(15,7,3),(16,8,30),(17,11,27),(18,15,28),(19,16,28),(20,13,13),(21,13,29),(22,14,29),(23,14,1),(24,15,30),(25,20,8),(26,19,9),(27,18,22),(28,17,22),(29,19,30);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'air_travel'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-31 20:00:57
