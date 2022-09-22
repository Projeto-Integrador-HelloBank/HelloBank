-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: localhost    Database: hellobank
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.20.04.2

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
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cidade` varchar(50) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `telefone` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jgra977gi05fur83l225x4qkr` (`cpf`),
  UNIQUE KEY `UK_ir2m70agseiyyajtaxq7wsw20` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` VALUES (1,'Salvador','644.425.060-94','lazarin@email.com','Pelorinho 165','BA','Lázaro Ramos','(11) 9 9999-9999'),(2,'Salvador','449.658.890-02','vaguin@email.com','Rua das peneiras','BA','Vagner Moura','(11) 9 9999-9999');
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_conta`
--

DROP TABLE IF EXISTS `tb_conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_conta` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `agencia` varchar(10) DEFAULT NULL,
  `data_criacao` datetime(6) DEFAULT NULL,
  `numero_conta` varchar(50) DEFAULT NULL,
  `saldo` decimal(9,2) DEFAULT NULL,
  `tipo_conta` varchar(20) DEFAULT NULL,
  `cliente_id` bigint DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK9o1x8ukef2hxvck5nrbavv12b` (`cliente_id`),
  CONSTRAINT `FK9o1x8ukef2hxvck5nrbavv12b` FOREIGN KEY (`cliente_id`) REFERENCES `tb_cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_conta`
--

LOCK TABLES `tb_conta` WRITE;
/*!40000 ALTER TABLE `tb_conta` DISABLE KEYS */;
INSERT INTO `tb_conta` VALUES (1,'4567','2022-09-21 22:11:34.000000','123456789',2150000.00,'Poupança',1),(2,'4567','2022-09-21 22:11:51.000000','12345',2150000.00,'Poupança',2);
/*!40000 ALTER TABLE `tb_conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_transacao`
--

DROP TABLE IF EXISTS `tb_transacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_transacao` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `data_transacao` datetime(6) DEFAULT NULL,
  `tipo_transacao` varchar(255) NOT NULL,
  `valor_transacao` decimal(9,2) DEFAULT NULL,
  `conta_destino` bigint DEFAULT NULL,
  `conta_origem` bigint DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKn8xmb14fuo3dr1auysflonoib` (`conta_destino`),
  KEY `FKqhfxkikw9h33og8issborj28u` (`conta_origem`),
  CONSTRAINT `FKn8xmb14fuo3dr1auysflonoib` FOREIGN KEY (`conta_destino`) REFERENCES `tb_conta` (`codigo`),
  CONSTRAINT `FKqhfxkikw9h33og8issborj28u` FOREIGN KEY (`conta_origem`) REFERENCES `tb_conta` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_transacao`
--

LOCK TABLES `tb_transacao` WRITE;
/*!40000 ALTER TABLE `tb_transacao` DISABLE KEYS */;
INSERT INTO `tb_transacao` VALUES (1,'2022-09-21 22:13:49.000000','TRANSFERENCIA',2150.00,1,2),(2,'2022-09-21 22:13:52.000000','SAQUE',850.00,NULL,1),(3,'2022-09-21 22:14:01.000000','DEPOSITO',150.00,1,NULL);
/*!40000 ALTER TABLE `tb_transacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'hellobank'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-22  1:05:54