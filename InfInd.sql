-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Oct 16, 2017 at 07:17 PM
-- Server version: 5.7.19
-- PHP Version: 7.0.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `InfInd`
--

-- --------------------------------------------------------

--
-- Table structure for table `Articulo`
--

CREATE TABLE `Articulo` (
  `idArticulo` int(10) NOT NULL,
  `codArticulo` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `unidadMedida` varchar(10) NOT NULL,
  `idTipoArticulo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ArtProv`
--

CREATE TABLE `ArtProv` (
  `idArtProv` int(10) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `precio` double NOT NULL,
  `idProveedor` int(10) NOT NULL,
  `idArticulo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `CentroTrabajo`
--

CREATE TABLE `CentroTrabajo` (
  `idCentro` int(10) NOT NULL,
  `codCentro` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `costoHoraMaquinaria` double NOT NULL,
  `costoHoraManoObra` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `DetalleOrdenProd`
--

CREATE TABLE `DetalleOrdenProd` (
  `idDetalleOrden` int(10) NOT NULL,
  `cantidad` int(10) NOT NULL,
  `idProducto` int(10) NOT NULL,
  `idOrdenProduccion` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `DetalleRuta`
--

CREATE TABLE `DetalleRuta` (
  `idDetalleRuta` int(10) NOT NULL,
  `orden` int(10) NOT NULL,
  `tiempoManoObra` double NOT NULL,
  `tiempoMaquina` double NOT NULL,
  `tiempoReposo` double NOT NULL,
  `idRuta` int(10) NOT NULL,
  `idCentro` int(10) NOT NULL,
  `idEstructura` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `EstadoOrdenProduccion`
--

CREATE TABLE `EstadoOrdenProduccion` (
  `idEstOP` int(10) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EstadoOrdenProduccion`
--

INSERT INTO `EstadoOrdenProduccion` (`idEstOP`, `descripcion`) VALUES
(1, 'Pendiente'),
(2, 'En curso'),
(3, 'Finalizada'),
(4, 'Cancelada');

-- --------------------------------------------------------

--
-- Table structure for table `Estructura`
--

CREATE TABLE `Estructura` (
  `idEstructura` int(10) NOT NULL,
  `cantidad` int(10) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `version` varchar(10) NOT NULL,
  `idProducto` int(10) NOT NULL,
  `idArticulo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Maquinaria`
--

CREATE TABLE `Maquinaria` (
  `idMaquinaria` int(10) NOT NULL,
  `codMaquinaria` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `idCentro` int(10) NOT NULL,
  `activa` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Materiales`
--

CREATE TABLE `Materiales` (
  `idMateriales` int(10) NOT NULL,
  `cantidad` int(10) NOT NULL,
  `idTipo` int(10) NOT NULL,
  `idDetRuta` int(10) NOT NULL,
  `idArticulo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `OrdenProduccion`
--

CREATE TABLE `OrdenProduccion` (
  `idOrdenProduccion` int(10) NOT NULL,
  `fechaPedido` varchar(15) NOT NULL,
  `idEstOP` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Producto`
--

CREATE TABLE `Producto` (
  `idProducto` int(10) NOT NULL,
  `codProducto` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `unidadMedida` varchar(10) NOT NULL,
  `idTipoProducto` int(10) NOT NULL,
  `idProductoBase` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Proveedor`
--

CREATE TABLE `Proveedor` (
  `idProveedor` int(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `RutaFabricacion`
--

CREATE TABLE `RutaFabricacion` (
  `idRuta` int(10) NOT NULL,
  `activa` tinyint(1) NOT NULL,
  `version` varchar(50) NOT NULL,
  `vigenteDesde` varchar(50) NOT NULL,
  `idProducto` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `TipoArticulo`
--

CREATE TABLE `TipoArticulo` (
  `idTipoArticulo` int(10) NOT NULL,
  `descripcion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `TipoArticulo`
--

INSERT INTO `TipoArticulo` (`idTipoArticulo`, `descripcion`) VALUES
(1, 'Materia Prima'),
(2, 'Producto Componente'),
(3, 'Producto proceso elaboracion');

-- --------------------------------------------------------

--
-- Table structure for table `TipoMateriales`
--

CREATE TABLE `TipoMateriales` (
  `idTipoMateriales` int(10) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `TipoMateriales`
--

INSERT INTO `TipoMateriales` (`idTipoMateriales`, `descripcion`) VALUES
(1, 'Entrada'),
(2, 'Salida');

-- --------------------------------------------------------

--
-- Table structure for table `TipoProducto`
--

CREATE TABLE `TipoProducto` (
  `idTipoProducto` int(10) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `TipoProducto`
--

INSERT INTO `TipoProducto` (`idTipoProducto`, `descripcion`) VALUES
(1, 'Base'),
(2, 'Final');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Articulo`
--
ALTER TABLE `Articulo`
  ADD PRIMARY KEY (`idArticulo`),
  ADD UNIQUE KEY `codArticulo` (`codArticulo`);

--
-- Indexes for table `ArtProv`
--
ALTER TABLE `ArtProv`
  ADD PRIMARY KEY (`idArtProv`);

--
-- Indexes for table `CentroTrabajo`
--
ALTER TABLE `CentroTrabajo`
  ADD PRIMARY KEY (`idCentro`),
  ADD UNIQUE KEY `codCentro` (`codCentro`);

--
-- Indexes for table `DetalleOrdenProd`
--
ALTER TABLE `DetalleOrdenProd`
  ADD PRIMARY KEY (`idDetalleOrden`);

--
-- Indexes for table `DetalleRuta`
--
ALTER TABLE `DetalleRuta`
  ADD PRIMARY KEY (`idDetalleRuta`);

--
-- Indexes for table `EstadoOrdenProduccion`
--
ALTER TABLE `EstadoOrdenProduccion`
  ADD PRIMARY KEY (`idEstOP`);

--
-- Indexes for table `Estructura`
--
ALTER TABLE `Estructura`
  ADD PRIMARY KEY (`idEstructura`);

--
-- Indexes for table `Maquinaria`
--
ALTER TABLE `Maquinaria`
  ADD PRIMARY KEY (`idMaquinaria`);

--
-- Indexes for table `Materiales`
--
ALTER TABLE `Materiales`
  ADD PRIMARY KEY (`idMateriales`);

--
-- Indexes for table `OrdenProduccion`
--
ALTER TABLE `OrdenProduccion`
  ADD PRIMARY KEY (`idOrdenProduccion`);

--
-- Indexes for table `Producto`
--
ALTER TABLE `Producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD UNIQUE KEY `codProducto` (`codProducto`);

--
-- Indexes for table `Proveedor`
--
ALTER TABLE `Proveedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- Indexes for table `RutaFabricacion`
--
ALTER TABLE `RutaFabricacion`
  ADD PRIMARY KEY (`idRuta`);

--
-- Indexes for table `TipoArticulo`
--
ALTER TABLE `TipoArticulo`
  ADD PRIMARY KEY (`idTipoArticulo`);

--
-- Indexes for table `TipoMateriales`
--
ALTER TABLE `TipoMateriales`
  ADD PRIMARY KEY (`idTipoMateriales`);

--
-- Indexes for table `TipoProducto`
--
ALTER TABLE `TipoProducto`
  ADD PRIMARY KEY (`idTipoProducto`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Articulo`
--
ALTER TABLE `Articulo`
  MODIFY `idArticulo` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ArtProv`
--
ALTER TABLE `ArtProv`
  MODIFY `idArtProv` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `CentroTrabajo`
--
ALTER TABLE `CentroTrabajo`
  MODIFY `idCentro` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `DetalleOrdenProd`
--
ALTER TABLE `DetalleOrdenProd`
  MODIFY `idDetalleOrden` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `DetalleRuta`
--
ALTER TABLE `DetalleRuta`
  MODIFY `idDetalleRuta` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `EstadoOrdenProduccion`
--
ALTER TABLE `EstadoOrdenProduccion`
  MODIFY `idEstOP` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Estructura`
--
ALTER TABLE `Estructura`
  MODIFY `idEstructura` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Maquinaria`
--
ALTER TABLE `Maquinaria`
  MODIFY `idMaquinaria` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Materiales`
--
ALTER TABLE `Materiales`
  MODIFY `idMateriales` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `OrdenProduccion`
--
ALTER TABLE `OrdenProduccion`
  MODIFY `idOrdenProduccion` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Producto`
--
ALTER TABLE `Producto`
  MODIFY `idProducto` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Proveedor`
--
ALTER TABLE `Proveedor`
  MODIFY `idProveedor` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `RutaFabricacion`
--
ALTER TABLE `RutaFabricacion`
  MODIFY `idRuta` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `TipoArticulo`
--
ALTER TABLE `TipoArticulo`
  MODIFY `idTipoArticulo` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `TipoMateriales`
--
ALTER TABLE `TipoMateriales`
  MODIFY `idTipoMateriales` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `TipoProducto`
--
ALTER TABLE `TipoProducto`
  MODIFY `idTipoProducto` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
