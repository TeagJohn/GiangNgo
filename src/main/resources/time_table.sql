-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 27, 2022 at 08:55 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29
CREATE DATABASE EMPDB
USE EMPDB
GO
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `time_table`
--

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE subject (
  subject_id nvarchar(20) primary key NOT NULL,
  subject_name nvarchar(20) NOT NULL,
  number_period int NOT NULL,
  teacher_id nvarchar(20) NOT NULL,
  time_id nvarchar(20) NOT NULL
)
DROP TABLE subject
INSERT INTO subject VALUES('MH01',N'Toán',3,'GV01',N'Nhung')
INSERT INTO subject VALUES('MH02',N'Toán',3,'GV01',N'Nhung')
INSERT INTO subject VALUES('MH03',N'Toán',3,'GV01',N'Nhung')
