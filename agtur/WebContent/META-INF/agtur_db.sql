-- MySQL dump 10.13  Distrib 5.7.9, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: agtur_db
-- ------------------------------------------------------
-- Server version	5.7.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Escursao`
--

DROP TABLE IF EXISTS `Escursao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Escursao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `destino` varchar(255) DEFAULT NULL,
  `partida` datetime DEFAULT NULL,
  `retorno` datetime DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `agente_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_c4nfhj5jli1i91rpwts7haqoq` (`agente_id`),
  CONSTRAINT `FK_c4nfhj5jli1i91rpwts7haqoq` FOREIGN KEY (`agente_id`) REFERENCES `Usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Escursao`
--

LOCK TABLES `Escursao` WRITE;
/*!40000 ALTER TABLE `Escursao` DISABLE KEYS */;
INSERT INTO `Escursao` VALUES (5,'Salvador ','2016-05-13 19:12:00','2016-05-27 19:12:00',450,3),(6,'Palhoça','2016-05-13 19:12:00','2016-05-27 19:09:00',45,3),(9,'Palhoça - SC','2016-05-29 16:34:00','2016-06-05 16:34:00',450,3),(10,'Sto Amaro da Imperatriz','2016-06-12 15:59:00','2016-06-27 15:59:00',320,3);
/*!40000 ALTER TABLE `Escursao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Escursao_Usuario`
--

DROP TABLE IF EXISTS `Escursao_Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Escursao_Usuario` (
  `Escursao_id` bigint(20) NOT NULL,
  `clientesEscursao_id` bigint(20) NOT NULL,
  KEY `FK_5c03yrnjmdmfoyjxtrhe4xppp` (`clientesEscursao_id`),
  KEY `FK_l10p9f7ant1bjandjjcwbp0sr` (`Escursao_id`),
  CONSTRAINT `FK_5c03yrnjmdmfoyjxtrhe4xppp` FOREIGN KEY (`clientesEscursao_id`) REFERENCES `Usuario` (`id`),
  CONSTRAINT `FK_l10p9f7ant1bjandjjcwbp0sr` FOREIGN KEY (`Escursao_id`) REFERENCES `Escursao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Escursao_Usuario`
--

LOCK TABLES `Escursao_Usuario` WRITE;
/*!40000 ALTER TABLE `Escursao_Usuario` DISABLE KEYS */;
INSERT INTO `Escursao_Usuario` VALUES (9,4),(10,5);
/*!40000 ALTER TABLE `Escursao_Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Imagem`
--

DROP TABLE IF EXISTS `Imagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Imagem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `escursao_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_okqvh5a320ootuii9eob1kfyg` (`escursao_id`),
  CONSTRAINT `FK_okqvh5a320ootuii9eob1kfyg` FOREIGN KEY (`escursao_id`) REFERENCES `Escursao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Imagem`
--

LOCK TABLES `Imagem` WRITE;
/*!40000 ALTER TABLE `Imagem` DISABLE KEYS */;
/*!40000 ALTER TABLE `Imagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nascimento` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `perfil` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (3,'ana@mail.com',NULL,'ana','ADMIN','ana',NULL),(4,'ze@mail.com',NULL,'Ze','ADMIN','ze',NULL),(5,'maria@mail.com',NULL,'maria','CLIENTE','maria',NULL);
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `caixa_escursoes`
--

DROP TABLE IF EXISTS `caixa_escursoes`;
/*!50001 DROP VIEW IF EXISTS `caixa_escursoes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `caixa_escursoes` AS SELECT 
 1 AS `escursao_id`,
 1 AS `destino`,
 1 AS `data`,
 1 AS `clientes`,
 1 AS `total`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `caixa_escursoes`
--

/*!50001 DROP VIEW IF EXISTS `caixa_escursoes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `caixa_escursoes` AS select `e`.`id` AS `escursao_id`,`e`.`destino` AS `destino`,`e`.`partida` AS `data`,count(0) AS `clientes`,sum(`e`.`valor`) AS `total` from (`Escursao` `e` join `Escursao_Usuario` `eu` on((`e`.`id` = `eu`.`Escursao_id`))) group by `e`.`id`,`e`.`destino`,`e`.`partida` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-13 21:10:46
