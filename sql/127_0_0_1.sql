-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 25, 2024 at 02:27 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proyecto_poo`
--
CREATE DATABASE IF NOT EXISTS `proyecto_poo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;
USE `proyecto_poo`;

-- --------------------------------------------------------

--
-- Table structure for table `alumno`
--

CREATE TABLE `alumno` (
  `rut` varchar(15) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `fecha_nac` date NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `fono` varchar(15) NOT NULL,
  `observaciones` varchar(200) NOT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `alumno`
--

INSERT INTO `alumno` (`rut`, `nombre`, `fecha_nac`, `direccion`, `fono`, `observaciones`, `is_active`) VALUES
('15345028-0', 'Carolina Cortés', '1983-02-06', '4 norte 675, viña del mar', '1231233', '', 1),
('20987602-7', 'Antonia Munoz', '2002-03-19', '4 norte 675, Viña del Mar', '976950321', '', 1);

-- --------------------------------------------------------

--
-- Table structure for table `contrato_plan`
--

CREATE TABLE `contrato_plan` (
  `id` int(11) NOT NULL,
  `rut_alumno` varchar(15) NOT NULL,
  `plan_mensual_id` int(11) NOT NULL,
  `inicio_mensualidad` date NOT NULL,
  `fin_mensualidad` date NOT NULL,
  `n_dias` int(11) NOT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `plan_mensual`
--

CREATE TABLE `plan_mensual` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `n_clases` int(11) NOT NULL,
  `valor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `plan_mensual`
--

INSERT INTO `plan_mensual` (`id`, `nombre`, `n_clases`, `valor`) VALUES
(1, '4 Clases', 4, 18000),
(2, '8 Clases', 8, 30000),
(3, '12 Clases', 12, 35000),
(4, 'Libre', 31, 40000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`rut`);

--
-- Indexes for table `contrato_plan`
--
ALTER TABLE `contrato_plan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `rut_alumno` (`rut_alumno`),
  ADD KEY `plan_mensual_id` (`plan_mensual_id`);

--
-- Indexes for table `plan_mensual`
--
ALTER TABLE `plan_mensual`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contrato_plan`
--
ALTER TABLE `contrato_plan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `plan_mensual`
--
ALTER TABLE `plan_mensual`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contrato_plan`
--
ALTER TABLE `contrato_plan`
  ADD CONSTRAINT `contrato_plan_ibfk_1` FOREIGN KEY (`plan_mensual_id`) REFERENCES `plan_mensual` (`id`),
  ADD CONSTRAINT `contrato_plan_ibfk_2` FOREIGN KEY (`rut_alumno`) REFERENCES `alumno` (`rut`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
