-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 16, 2018 at 12:27 PM
-- Server version: 5.7.20-log
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bangna_queue`
--

-- --------------------------------------------------------

--
-- Table structure for table `b_company`
--

CREATE TABLE `b_company` (
  `comp_id` int(11) NOT NULL,
  `comp_code` varchar(255) DEFAULT NULL,
  `comp_name_t` varchar(255) DEFAULT NULL,
  `comp_name_e` varchar(255) DEFAULT NULL,
  `comp_address_e` varchar(50) DEFAULT NULL,
  `comp_address_t` varchar(255) DEFAULT NULL,
  `addr1` varchar(255) DEFAULT NULL,
  `addr2` varchar(255) DEFAULT NULL,
  `addr3` varchar(255) DEFAULT NULL,
  `amphur_id` varchar(255) DEFAULT NULL,
  `district_id` varchar(255) DEFAULT NULL,
  `province_id` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  `tele` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `tax_id` varchar(255) DEFAULT NULL,
  `vat` double DEFAULT NULL,
  `spec1` varchar(255) DEFAULT NULL,
  `date_create` varchar(255) DEFAULT NULL,
  `date_modi` varchar(255) DEFAULT NULL,
  `date_cancel` varchar(255) DEFAULT NULL,
  `user_create` varchar(255) DEFAULT NULL,
  `user_modi` varchar(255) DEFAULT NULL,
  `user_cancel` varchar(255) DEFAULT NULL,
  `qu_line1` varchar(255) DEFAULT NULL,
  `qu_line2` varchar(255) DEFAULT NULL,
  `qu_line3` varchar(255) DEFAULT NULL,
  `qu_line4` varchar(255) DEFAULT NULL,
  `qu_line5` varchar(255) DEFAULT NULL,
  `qu_line6` varchar(255) DEFAULT NULL,
  `qu_due_period` varchar(255) DEFAULT NULL COMMENT 'จำนวนวันในใบเสนอราคา',
  `inv_line1` varchar(255) DEFAULT NULL,
  `inv_line2` varchar(255) DEFAULT NULL,
  `inv_line3` varchar(255) DEFAULT NULL,
  `inv_line4` varchar(255) DEFAULT NULL,
  `inv_line5` varchar(255) DEFAULT NULL,
  `inv_line6` varchar(255) DEFAULT NULL,
  `inv_due_period` varchar(255) DEFAULT NULL COMMENT 'จำนวนวันในการให้ credit',
  `rec_line1` varchar(255) DEFAULT NULL,
  `rec_line2` varchar(255) DEFAULT NULL,
  `rec_line3` varchar(255) DEFAULT NULL,
  `rec_line4` varchar(255) DEFAULT NULL,
  `rec_line5` varchar(255) DEFAULT NULL,
  `rec_line6` varchar(255) DEFAULT NULL,
  `po_line1` varchar(255) DEFAULT NULL,
  `po_line2` varchar(255) DEFAULT NULL,
  `po_line3` varchar(255) DEFAULT NULL,
  `po_line4` varchar(255) DEFAULT NULL,
  `po_line5` varchar(255) DEFAULT NULL,
  `po_line6` varchar(255) DEFAULT NULL,
  `po_due_period` varchar(255) DEFAULT NULL COMMENT 'จำนวนวันในการขอ credit',
  `comp_active` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `b_prefix`
--

CREATE TABLE `b_prefix` (
  `prefix_id` int(11) NOT NULL,
  `prefix_code` varchar(255) DEFAULT NULL,
  `prefix_name_t` varchar(255) DEFAULT NULL,
  `prefix_name_e` varchar(255) DEFAULT NULL,
  `prefix_active` varchar(255) DEFAULT NULL,
  `status_prefix` varchar(255) DEFAULT NULL COMMENT '1=บุคคล 2= นิติบุคคล'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `b_prefix`
--

INSERT INTO `b_prefix` (`prefix_id`, `prefix_code`, `prefix_name_t`, `prefix_name_e`, `prefix_active`, `status_prefix`) VALUES
(1, '001', 'นาย', NULL, '1', '1'),
(2, '002', 'นาง', NULL, '1', '1'),
(3, '003', 'น.ส.', NULL, '1', '1'),
(4, '004', 'นายแพทย์', NULL, '1', '1');

-- --------------------------------------------------------

--
-- Table structure for table `b_queue`
--

CREATE TABLE `b_queue` (
  `b_queue_id` int(11) NOT NULL,
  `staff_id` int(11) DEFAULT NULL,
  `queue_date` varchar(255) DEFAULT NULL,
  `queue_current` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `b_staff`
--

CREATE TABLE `b_staff` (
  `staff_id` int(11) NOT NULL,
  `staff_code` varchar(255) DEFAULT NULL,
  `prefix_id` int(11) DEFAULT NULL,
  `prefix` varchar(255) DEFAULT NULL,
  `staff_fname_t` varchar(255) DEFAULT NULL,
  `staff_fname_e` varchar(255) DEFAULT NULL,
  `staff_lname_t` varchar(255) DEFAULT NULL,
  `staff_lname_e` varchar(255) DEFAULT NULL,
  `staff_username` varchar(255) DEFAULT NULL,
  `staff_password` varchar(255) DEFAULT NULL,
  `staff_active` varchar(255) DEFAULT NULL,
  `staff_remark` varchar(255) DEFAULT NULL,
  `priority` varchar(255) DEFAULT NULL,
  `tele` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `position_id` varchar(255) DEFAULT NULL,
  `position_name` varchar(255) DEFAULT NULL,
  `date_create` varchar(255) DEFAULT NULL,
  `date_modi` varchar(255) DEFAULT NULL,
  `date_cancel` varchar(255) DEFAULT NULL,
  `user_create` varchar(255) DEFAULT NULL,
  `user_modi` varchar(255) DEFAULT NULL,
  `user_cancel` varchar(255) DEFAULT NULL,
  `sort1` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `tax_id` varchar(255) DEFAULT NULL,
  `queue_current` varchar(255) DEFAULT NULL,
  `queue_date` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `b_staff`
--

INSERT INTO `b_staff` (`staff_id`, `staff_code`, `prefix_id`, `prefix`, `staff_fname_t`, `staff_fname_e`, `staff_lname_t`, `staff_lname_e`, `staff_username`, `staff_password`, `staff_active`, `staff_remark`, `priority`, `tele`, `mobile`, `fax`, `email`, `position_id`, `position_name`, `date_create`, `date_modi`, `date_cancel`, `user_create`, `user_modi`, `user_cancel`, `sort1`, `id_card`, `tax_id`, `queue_current`, `queue_date`) VALUES
(1, '001', 4, 'นายแพทย์', 'อรรถสิทธิ์ ', NULL, 'ทองปลาเค้า', NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '100000', NULL, NULL, '', '2018-03-16 18:20:29'),
(2, '002', 4, 'นายแพทย์', 'ทดสอบ', NULL, 'Test', NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '100001', NULL, NULL, '3', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `f_position`
--

CREATE TABLE `f_position` (
  `position_id` int(11) NOT NULL,
  `position_code` varchar(255) DEFAULT NULL,
  `position_name_t` varchar(255) DEFAULT NULL,
  `position_name_e` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `position_active` varchar(255) DEFAULT NULL,
  `status_position` varchar(255) DEFAULT NULL COMMENT '1=staff 2= doctor'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `f_position`
--

INSERT INTO `f_position` (`position_id`, `position_code`, `position_name_t`, `position_name_e`, `remark`, `position_active`, `status_position`) VALUES
(1, '001', 'แพทย์', NULL, NULL, '1', '1');

-- --------------------------------------------------------

--
-- Table structure for table `t_queue`
--

CREATE TABLE `t_queue` (
  `queue_id` int(11) NOT NULL,
  `staff_id` varchar(255) DEFAULT NULL,
  `queue_date` varchar(255) DEFAULT NULL,
  `row_1` varchar(255) DEFAULT NULL,
  `queue_active` varchar(255) DEFAULT NULL,
  `status_queue` varchar(255) DEFAULT NULL COMMENT '1=queue 2 = finish queue',
  `staff_name` varchar(255) DEFAULT NULL,
  `date_begin` varchar(255) DEFAULT NULL,
  `date_finish` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_queue`
--

INSERT INTO `t_queue` (`queue_id`, `staff_id`, `queue_date`, `row_1`, `queue_active`, `status_queue`, `staff_name`, `date_begin`, `date_finish`) VALUES
(45, '1', '2018-03-16 17:40:09', '1', '1', '2', NULL, '2018-03-16 17:40:09', '2018-03-16 17:44:20'),
(46, '1', '2018-03-16 17:40:10', '2', '1', '2', NULL, '2018-03-16 17:40:10', '2018-03-16 17:44:38'),
(47, '1', '2018-03-16 17:40:12', '3', '1', '2', NULL, '2018-03-16 17:40:12', '2018-03-16 17:44:46'),
(48, '1', '2018-03-16 17:40:13', '4', '1', '2', NULL, '2018-03-16 17:40:13', '2018-03-16 17:44:58'),
(49, '1', '2018-03-16 17:54:32', '1', '1', '2', NULL, '2018-03-16 17:54:32', '2018-03-16 17:54:42'),
(50, '1', '2018-03-16 17:55:58', '1', '1', '2', NULL, '2018-03-16 17:55:58', '2018-03-16 17:56:42'),
(51, '1', '2018-03-16 17:55:59', '2', '1', '2', NULL, '2018-03-16 17:55:59', '2018-03-16 17:59:32'),
(52, '1', '2018-03-16 17:55:59', '3', '1', '2', NULL, '2018-03-16 17:55:59', '2018-03-16 18:00:33'),
(53, '1', '2018-03-16 18:05:34', '1', '1', '2', NULL, '2018-03-16 18:05:34', '2018-03-16 18:07:47'),
(54, '1', '2018-03-16 18:05:35', '2', '1', '2', NULL, '2018-03-16 18:05:35', '2018-03-16 18:19:57'),
(55, '1', '2018-03-16 18:05:36', '3', '1', '2', NULL, '2018-03-16 18:05:36', '2018-03-16 18:20:09'),
(56, '1', '2018-03-16 18:20:29', '1', '1', '2', NULL, '2018-03-16 18:20:29', '2018-03-16 18:20:34'),
(57, '1', '2018-03-16 18:20:30', '2', '1', '2', NULL, '2018-03-16 18:20:30', '2018-03-16 18:20:44'),
(58, '1', '2018-03-16 18:20:30', '3', '1', '2', NULL, '2018-03-16 18:20:30', '2018-03-16 18:21:28');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `b_company`
--
ALTER TABLE `b_company`
  ADD PRIMARY KEY (`comp_id`);

--
-- Indexes for table `b_prefix`
--
ALTER TABLE `b_prefix`
  ADD PRIMARY KEY (`prefix_id`);

--
-- Indexes for table `b_queue`
--
ALTER TABLE `b_queue`
  ADD PRIMARY KEY (`b_queue_id`);

--
-- Indexes for table `b_staff`
--
ALTER TABLE `b_staff`
  ADD PRIMARY KEY (`staff_id`);

--
-- Indexes for table `f_position`
--
ALTER TABLE `f_position`
  ADD PRIMARY KEY (`position_id`);

--
-- Indexes for table `t_queue`
--
ALTER TABLE `t_queue`
  ADD PRIMARY KEY (`queue_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `b_company`
--
ALTER TABLE `b_company`
  MODIFY `comp_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `b_prefix`
--
ALTER TABLE `b_prefix`
  MODIFY `prefix_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `b_queue`
--
ALTER TABLE `b_queue`
  MODIFY `b_queue_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `b_staff`
--
ALTER TABLE `b_staff`
  MODIFY `staff_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `f_position`
--
ALTER TABLE `f_position`
  MODIFY `position_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `t_queue`
--
ALTER TABLE `t_queue`
  MODIFY `queue_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
