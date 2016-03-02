-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 09, 2015 at 04:46 PM
-- Server version: 5.6.25
-- PHP Version: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cybercafe`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cabin`
--

CREATE TABLE IF NOT EXISTS `tbl_cabin` (
  `c_id` int(3) NOT NULL,
  `title` varchar(30) NOT NULL,
  `status` enum('Free','Occupied') NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_cabin`
--

INSERT INTO `tbl_cabin` (`c_id`, `title`, `status`) VALUES
(6, 'PC1', 'Free'),
(7, 'PC2', 'Free'),
(8, 'PC3', 'Free'),
(10, 'PC4', 'Free'),
(11, 'PC5', 'Free'),
(12, 'PC6', 'Free'),
(13, 'PC7', 'Free'),
(14, 'PC8', 'Free'),
(15, 'PC9', 'Free');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_customer`
--

CREATE TABLE IF NOT EXISTS `tbl_customer` (
  `cu_id` int(3) NOT NULL,
  `a_id` int(3) DEFAULT NULL,
  `c_id` int(3) NOT NULL,
  `ci_id` int(3) DEFAULT NULL,
  `start_time` varchar(30) DEFAULT NULL,
  `end_time` varchar(30) DEFAULT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_customer`
--

INSERT INTO `tbl_customer` (`cu_id`, `a_id`, `c_id`, `ci_id`, `start_time`, `end_time`, `date`) VALUES
(79, NULL, 7, 51, '11:33:24', '11:40:57', '2015-01-10'),
(80, NULL, 8, 52, '12:36:28', '12:36:39', '2015-01-10'),
(81, 7, 10, NULL, '12:46:41', '12:46:48', '2015-01-10'),
(82, 9, 12, NULL, '13:58:01', '13:58:08', '2015-01-10'),
(83, 7, 6, NULL, '13:52:14', '13:52:21', '2015-08-30'),
(84, 14, 7, NULL, '13:54:07', '13:55:18', '2015-08-30'),
(85, 13, 11, NULL, '13:54:52', '13:56:30', '2015-08-30'),
(86, 12, 12, NULL, '13:54:57', '13:56:59', '2015-08-30');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cust_info`
--

CREATE TABLE IF NOT EXISTS `tbl_cust_info` (
  `ci_id` int(3) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_cust_info`
--

INSERT INTO `tbl_cust_info` (`ci_id`, `name`) VALUES
(51, 'aaa'),
(52, 'hdskfd'),
(53, '14'),
(54, 'Pandit'),
(55, 'PUSSY');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_member`
--

CREATE TABLE IF NOT EXISTS `tbl_member` (
  `m_id` int(3) NOT NULL,
  `name` varchar(30) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_member`
--

INSERT INTO `tbl_member` (`m_id`, `name`, `gender`, `phone`, `email`, `address`, `date`) VALUES
(7, 'shiva', 'M', '984117024', 'seb@gmail.com', 'ktm', '2015-01-07'),
(8, 'bik', 'M', '955555555', 'bik@gmail.com', 'ktm', '2015-01-07'),
(9, 'rajan', 'M', '3336597864', 'rajan@hotmail.com', 'hello', '2015-01-08'),
(11, 'abcd', 'F', '9841157024', 's@gmail.com', 'ktm', '2015-01-09'),
(12, 'ajdslk', 'F', '9874545478', 'sieb@gmail.com', 'kktkkt', '2015-01-09'),
(13, 'shivashrestha', 'M', '9841157024', 'seb.513@hotmail.com', 'ktm, Nepal	', '2015-01-10'),
(14, 'mike', 'M', '9841157878', 'mike@hotmail.com', 'pkh, Nepal', '2015-01-11'),
(18, 'ss', 'M', '5654455444', 'se@g.com', 'sss', '2015-08-31');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tariff`
--

CREATE TABLE IF NOT EXISTS `tbl_tariff` (
  `t_id` int(3) NOT NULL,
  `title` varchar(30) NOT NULL,
  `amount` int(3) NOT NULL,
  `reg_fee` int(3) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_tariff`
--

INSERT INTO `tbl_tariff` (`t_id`, `title`, `amount`, `reg_fee`) VALUES
(3, 'Member', 20, 350),
(4, 'Regular', 25, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE IF NOT EXISTS `tbl_user` (
  `u_id` int(3) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `status` varchar(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `username`, `password`, `status`) VALUES
(4, 'admin', 'pass', 'admin'),
(5, 'seb', 'pass', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_cabin`
--
ALTER TABLE `tbl_cabin`
  ADD PRIMARY KEY (`c_id`),
  ADD UNIQUE KEY `title` (`title`);

--
-- Indexes for table `tbl_customer`
--
ALTER TABLE `tbl_customer`
  ADD PRIMARY KEY (`cu_id`),
  ADD KEY `t_id` (`a_id`),
  ADD KEY `c_id` (`c_id`),
  ADD KEY `a_id` (`a_id`),
  ADD KEY `ci_id` (`ci_id`);

--
-- Indexes for table `tbl_cust_info`
--
ALTER TABLE `tbl_cust_info`
  ADD PRIMARY KEY (`ci_id`);

--
-- Indexes for table `tbl_member`
--
ALTER TABLE `tbl_member`
  ADD PRIMARY KEY (`m_id`);

--
-- Indexes for table `tbl_tariff`
--
ALTER TABLE `tbl_tariff`
  ADD PRIMARY KEY (`t_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_cabin`
--
ALTER TABLE `tbl_cabin`
  MODIFY `c_id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `tbl_customer`
--
ALTER TABLE `tbl_customer`
  MODIFY `cu_id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=87;
--
-- AUTO_INCREMENT for table `tbl_cust_info`
--
ALTER TABLE `tbl_cust_info`
  MODIFY `ci_id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=56;
--
-- AUTO_INCREMENT for table `tbl_member`
--
ALTER TABLE `tbl_member`
  MODIFY `m_id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `tbl_tariff`
--
ALTER TABLE `tbl_tariff`
  MODIFY `t_id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_customer`
--
ALTER TABLE `tbl_customer`
  ADD CONSTRAINT `tbl_customer_ibfk_2` FOREIGN KEY (`c_id`) REFERENCES `tbl_cabin` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_customer_ibfk_3` FOREIGN KEY (`a_id`) REFERENCES `tbl_member` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_customer_ibfk_4` FOREIGN KEY (`ci_id`) REFERENCES `tbl_cust_info` (`ci_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
