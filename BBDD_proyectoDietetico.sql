CREATE DATABASE  IF NOT EXISTS `programanutricion` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `programanutricion`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: programanutricion
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `calorias`
--

DROP TABLE IF EXISTS `calorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `calorias` (
  `nombre` varchar(45) NOT NULL,
  `c_mantener` float DEFAULT NULL,
  `c_perder` float DEFAULT NULL,
  `c_ganar` float NOT NULL,
  PRIMARY KEY (`nombre`),
  CONSTRAINT `fk_datos_usuario1` FOREIGN KEY (`nombre`) REFERENCES `datos_usuario1` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calorias`
--

LOCK TABLES `calorias` WRITE;
/*!40000 ALTER TABLE `calorias` DISABLE KEYS */;
INSERT INTO `calorias` VALUES ('daniiiiiel',2293,1793,2793),('ejemplodaw',2293,1793,2793),('ejemplodos',2202,1702,2702),('ejemplouno',2654,2154,3154),('fheggfdcbvdb',1992,1492,2492),('pruebatres',2032,1532,2532),('pruebauno',2032,1532,2532);
/*!40000 ALTER TABLE `calorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_usuario1`
--

DROP TABLE IF EXISTS `datos_usuario1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `datos_usuario1` (
  `usuario` varchar(45) NOT NULL,
  `pass` varchar(45) DEFAULT NULL,
  `altura` int(11) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='			';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_usuario1`
--

LOCK TABLES `datos_usuario1` WRITE;
/*!40000 ALTER TABLE `datos_usuario1` DISABLE KEYS */;
INSERT INTO `datos_usuario1` VALUES ('danielguerrero','22222222',155,32),('daniiiiiel','11111111',155,33),('ejemplodaw','11111111',155,55),('ejemplodos','55555555',155,32),('ejemplouno','22222222',160,32),('fheggfdcbvdb','aaaaaaaa',222,22),('pruebatres','11111111',150,22),('pruebauno','11111111',155,22);
/*!40000 ALTER TABLE `datos_usuario1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dieta`
--

DROP TABLE IF EXISTS `dieta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dieta` (
  `nombre_dieta` varchar(45) DEFAULT NULL,
  `desayuno` varchar(45) DEFAULT NULL,
  `almuerzo` varchar(45) DEFAULT NULL,
  `merienda` varchar(45) DEFAULT NULL,
  `cena` varchar(45) DEFAULT NULL,
  `f_inicio` timestamp NULL DEFAULT NULL,
  `f_fin` timestamp NULL DEFAULT NULL,
  `nombre_usu` varchar(45) NOT NULL,
  KEY `fk_usu_idx` (`nombre_usu`),
  CONSTRAINT `fk_usu` FOREIGN KEY (`nombre_usu`) REFERENCES `datos_usuario1` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieta`
--

LOCK TABLES `dieta` WRITE;
/*!40000 ALTER TABLE `dieta` DISABLE KEYS */;
INSERT INTO `dieta` VALUES ('Mi dieta 1','Patata con espinacas','Patata con merluza','Patata con brocoli','Patata con pavo','2019-09-30 23:00:00','2019-10-24 23:00:00','pruebauno');
/*!40000 ALTER TABLE `dieta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-01 17:51:07
