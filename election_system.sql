-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2019 at 04:04 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `election_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(10) NOT NULL,
  `fullname` text NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `fullname`, `username`, `password`) VALUES
(1, 'Lynford Lagondi', 'ford', '1234'),
(2, 'Jeah Mae Lagondi', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `voted_candidates`
--

CREATE TABLE `voted_candidates` (
  `id` int(10) NOT NULL,
  `Student_id` varchar(255) NOT NULL,
  `President` text NOT NULL,
  `Vice_President` text NOT NULL,
  `Secretary` text NOT NULL,
  `Treasurer` text NOT NULL,
  `Auditor` text NOT NULL,
  `PRO` text NOT NULL,
  `date_voted` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `voted_candidates`
--

INSERT INTO `voted_candidates` (`id`, `Student_id`, `President`, `Vice_President`, `Secretary`, `Treasurer`, `Auditor`, `PRO`, `date_voted`) VALUES
(1, '1993', 'Rodrigo Duterte', 'Bong Bong Marcos', 'Leonide Sabino', 'Brad Pit', 'Mark Rasmus', 'Taylor Magsanoc', '2019-04-10 13:57:49'),
(2, '1234', 'Rodrigo Duterte', 'Leni Robredo ', 'John Doe', 'DingDong Dantes', 'Mark Rasmus', 'Steve Gates', '2019-04-10 13:59:35'),
(3, '100', 'Mar Roxas', 'Bong Bong Marcos', 'John Doe', 'Brad Pit', 'Hood Robin', 'Steve Gates', '2019-04-10 14:00:34'),
(4, '36', 'Mar Roxas', 'Leni Robredo ', 'John Doe', 'selected tres', 'Hood Robin', 'Taylor Magsanoc', '2019-04-10 14:02:47');

-- --------------------------------------------------------

--
-- Table structure for table `voters`
--

CREATE TABLE `voters` (
  `id` int(10) NOT NULL,
  `student_id` int(10) NOT NULL,
  `lastname` text NOT NULL,
  `firstname` text NOT NULL,
  `middlename` text NOT NULL,
  `course` text NOT NULL,
  `level` text NOT NULL,
  `position` varchar(255) NOT NULL,
  `number_of_votes` int(10) NOT NULL,
  `status` varchar(255) NOT NULL,
  `fullname` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `voters`
--

INSERT INTO `voters` (`id`, `student_id`, `lastname`, `firstname`, `middlename`, `course`, `level`, `position`, `number_of_votes`, `status`, `fullname`, `created_at`) VALUES
(1, 1234, 'Duterte', 'Rodrigo', 'Roa', 'BS-CRIM', '1st Year', 'President', 2, 'candidate', 'Rodrigo Duterte', '2019-04-10 13:42:57'),
(2, 2345, 'Roxas', 'Mar', 'M', 'BSIT', '1st Year', 'President', 2, 'candidate', 'Mar Roxas', '2019-04-10 13:43:29'),
(3, 100, 'Marcos', 'Bong Bong', 'R', 'BS-CRIM', '4th Year', 'Vice-President', 2, 'candidate', 'Bong Bong Marcos', '2019-04-10 13:45:25'),
(4, 69870, 'Robredo ', 'Leni', 'A', 'BS-COE', '2nd Year', 'Vice-President', 2, 'candidate', 'Leni Robredo ', '2019-04-10 13:45:48'),
(5, 5668, 'Sabino', 'Leonide', 'A', 'BS-CRIM', '3rd Year', 'Secretary', 1, 'candidate', 'Leonide Sabino', '2019-04-10 13:47:29'),
(6, 576788978, 'Doe', 'John', 'A', 'BS-COE', '4th Year', 'Secretary', 3, 'candidate', 'John Doe', '2019-04-10 13:48:09'),
(7, 987899, 'Pit', 'Brad', 'Bul', 'BS-COE', '2nd Year', 'Treasurer', 2, 'candidate', 'Brad Pit', '2019-04-10 13:49:36'),
(8, 120978, 'Dantes', 'DingDong', 'M', 'BS-CS', '1st Year', 'Treasurer', 1, 'candidate', 'DingDong Dantes', '2019-04-10 13:50:19'),
(9, 677221, 'Rasmus', 'Mark', 'L', 'BS-COE', '2nd Year', 'Auditor', 2, 'candidate', 'Mark Rasmus', '2019-04-10 13:51:05'),
(10, 98234, 'Robin', 'Hood', 'A', 'BS-COE', '1st Year', 'Auditor', 2, 'candidate', 'Hood Robin', '2019-04-10 13:53:01'),
(11, 98452, 'Magsanoc', 'Taylor', 'S', 'BS-CS', '1st Year', 'PRO', 2, 'candidate', 'Taylor Magsanoc', '2019-04-10 13:53:46'),
(12, 908238, 'Gates', 'Steve', 'J', 'BS-COE', '3rd Year', 'PRO', 2, 'candidate', 'Steve Gates', '2019-04-10 13:54:29'),
(13, 1993, 'Lagondi', 'Harrison Ford', 'D', 'BS-COE', '1st Year', '', 0, '', 'Harrison Ford Lagondi', '2019-04-10 13:55:22'),
(14, 36, 'Duterte', 'LynLags', 'A', 'BS-CS', '2nd Year', '', 0, '', 'LynLags Duterte', '2019-04-10 14:02:21');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `voted_candidates`
--
ALTER TABLE `voted_candidates`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `voters`
--
ALTER TABLE `voters`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `voted_candidates`
--
ALTER TABLE `voted_candidates`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `voters`
--
ALTER TABLE `voters`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
