-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Lug 23, 2021 alle 00:12
-- Versione del server: 10.4.14-MariaDB
-- Versione PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `schema_rubrica`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `contatti`
--

CREATE TABLE `contatti` (
  `id` int(11) NOT NULL,
  `nome` varchar(250) NOT NULL,
  `cognome` varchar(250) NOT NULL,
  `telefono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `contatti`
--

INSERT INTO `contatti` (`id`, `nome`, `cognome`, `telefono`) VALUES
(1, 'Nicola', 'Calise', '329335823'),
(2, 'Lorenzo', 'Calise', '543534'),
(3, 'Ariele', 'Grieco', '543543'),
(4, 'Federico ', 'Di Napoli', '5435345345'),
(5, 'Pravenut', 'Lakta', '7653543'),
(6, 'Esempio', 'Aggiunta', '123456'),
(7, 'Antani', 'Supercazzola', '4325324'),
(8, 'Conte', 'Mascetti', '645235'),
(9, 'Rambaldo', 'Melandri', '6542342'),
(10, 'Barista', 'Necchi', '546543'),
(11, 'Mario', 'Calise', '54353453'),
(12, 'TestDialog', 'Dialog3', '6345235');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `contatti`
--
ALTER TABLE `contatti`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `contatti`
--
ALTER TABLE `contatti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
