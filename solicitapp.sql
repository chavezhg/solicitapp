-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 09, 2022 at 05:53 AM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `solicitapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `cubiculo`
--

DROP TABLE IF EXISTS `cubiculo`;
CREATE TABLE IF NOT EXISTS `cubiculo` (
  `id_cubi` int NOT NULL AUTO_INCREMENT,
  `cod_cubi` varchar(50) DEFAULT NULL,
  `disp_cubi` enum('Si','No') DEFAULT NULL,
  PRIMARY KEY (`id_cubi`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
CREATE TABLE IF NOT EXISTS `profesor` (
  `id_prof` int NOT NULL AUTO_INCREMENT,
  `id_cubi` int DEFAULT NULL,
  `id_usua` int DEFAULT NULL,
  PRIMARY KEY (`id_prof`),
  KEY `id_cubi` (`id_cubi`),
  KEY `id_usua` (`id_usua`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
CREATE TABLE IF NOT EXISTS `solicitud` (
  `id_soli` int NOT NULL AUTO_INCREMENT,
  `id_prof` int DEFAULT NULL,
  `mat_alumn_soli` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_soli`),
  KEY `id_prof` (`id_prof`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
CREATE TABLE IF NOT EXISTS `turno` (
  `id_turn` int NOT NULL AUTO_INCREMENT,
  `id_soli` int DEFAULT NULL,
  `esta_turn` enum('Pendiente','Aceptada','Rechazada') DEFAULT NULL,
  PRIMARY KEY (`id_turn`),
  KEY `id_soli` (`id_soli`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usua` int NOT NULL AUTO_INCREMENT,
  `nomb_usua` varchar(255) DEFAULT NULL,
  `correo_usua` varchar(255) DEFAULT NULL,
  `contra_usua` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tipo_usua` enum('Profesor','Coordinador') DEFAULT 'Profesor',
  PRIMARY KEY (`id_usua`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id_usua`, `nomb_usua`, `correo_usua`, `contra_usua`, `tipo_usua`) VALUES
(1, 'Ricardo Alexis Mendoza Chávez', 'ricardo.mendoza@uteq.edu.mx', '$2a$10$u0nl5XMXO1XnARryDeRNludzLYo6dl88tANF6quCJMMwQtRy0Kb22', 'Profesor');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
