CREATE DATABASE `miappio_cursopos`;

USE `miappio_cursopos`;

CREATE TABLE `usuario` (
    `idusuario` int NOT NULL AUTO_INCREMENT,
    `email` varchar(50) NOT NULL,
    `password` varchar(200) NOT NULL,
    `nombre` varchar(45) NOT NULL,
    `apaterno` varchar(45) NOT NULL,
    `amaterno` varchar(45) DEFAULT NULL,
    `activo` bit(1) NOT NULL DEFAULT b'1',
    `perfil` varchar(20) NOT NULL,
    PRIMARY KEY (`idusuario`),
    UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `categoria` (
    `idcategoria` int NOT NULL AUTO_INCREMENT,
    `nombre` varchar(50) NOT NULL,
    `descripcion` varchar(500) NOT NULL,
    PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `cliente` (
    `idcliente` int NOT NULL AUTO_INCREMENT,
    `nombre` varchar(50) NOT NULL,
    `apaterno` varchar(50) NOT NULL,
    `amaterno` varchar(50) DEFAULT NULL,
    `rfc` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `compra` (
    `idcompra` int NOT NULL AUTO_INCREMENT,
    `idusuario` int NOT NULL,
    `total` decimal(7,2) NOT NULL,
    `fecha` datetime NOT NULL,
    `idcliente` int NOT NULL,
    PRIMARY KEY (`idcompra`),
    KEY `fk_compra_usuario1_idx` (`idusuario`),
    KEY `fk_compra_cliente1_idx` (`idcliente`),
    CONSTRAINT `fk_compra_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_compra_usuario1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `producto` (
    `idproducto` int NOT NULL AUTO_INCREMENT,
    `nombre` varchar(50) NOT NULL,
    `descripcion` varchar(500) NOT NULL,
    `precio` decimal(7,2) NOT NULL,
    `stock` int NOT NULL,
    `sku` varchar(10) DEFAULT NULL,
    `idcategoria` int NOT NULL,
    `imagen` text,
    PRIMARY KEY (`idproducto`),
    KEY `fk_producto_categoria_idx` (`idcategoria`),
    CONSTRAINT `fk_producto_categoria` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1101 DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `compraproducto` (
    `idcompra` int,
    `idproducto` int NOT NULL,
    `idcompraproducto` int NOT NULL AUTO_INCREMENT,
    `cantidad` int NOT NULL,
    `costo` decimal(7,2) NOT NULL,
    PRIMARY KEY (`idcompraproducto`),
    KEY `fk_compra_has_producto_producto1_idx` (`idproducto`),
    KEY `fk_compra_has_producto_compra1_idx` (`idcompra`),
    CONSTRAINT `fk_compra_has_producto_compra1` FOREIGN KEY (`idcompra`) REFERENCES `compra` (`idcompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_compra_has_producto_producto1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=UTF8MB4;