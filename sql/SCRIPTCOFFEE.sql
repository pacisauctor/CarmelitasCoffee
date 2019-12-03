CREATE DATABASE `carmelitas_coffee`;
CREATE TABLE `cliente` (
  `id_cliente` int(4) NOT NULL AUTO_INCREMENT,
  `numero_ruc` varchar(20) NOT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `id_persona_contacto` int(4) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `correo` (`correo`),
  KEY `id_persona_contacto` (`id_persona_contacto`),
  FULLTEXT KEY `nombres` (`nombres`),
  FULLTEXT KEY `apellidos` (`apellidos`),
  FULLTEXT KEY `direccion` (`direccion`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_persona_contacto`) REFERENCES `persona_contacto` (`id_persona_contacto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `contrato` (
  `id_contrato` int(4) NOT NULL AUTO_INCREMENT,
  `id_empleado` int(4) NOT NULL,
  `puesto` varchar(70) DEFAULT NULL,
  `sueldo` decimal(11,4) DEFAULT NULL,
  `comisiones` decimal(2,2) DEFAULT NULL,
  `fecha_contratacion` datetime DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_contrato`),
  KEY `id_empleado` (`id_empleado`),
  KEY `sueldo` (`sueldo`),
  KEY `estado` (`estado`),
  FULLTEXT KEY `puesto` (`puesto`),
  CONSTRAINT `contrato_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `deposito` (
  `id_deposito` int(4) NOT NULL AUTO_INCREMENT,
  `numero_comprobante` varchar(20) DEFAULT NULL,
  `banco` varchar(30) DEFAULT NULL,
  `monto` decimal(11,4) DEFAULT NULL,
  `moneda` varchar(30) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id_deposito`),
  KEY `numero_comprobante` (`numero_comprobante`),
  KEY `banco` (`banco`),
  KEY `moneda` (`moneda`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `detalle_factura_insumo` (
  `id_detalle_factura_insumo` int(4) NOT NULL AUTO_INCREMENT,
  `id_factura_insumo` int(4) NOT NULL,
  `id_insumo` int(4) NOT NULL,
  `cantidad` int(4) DEFAULT NULL,
  `descuento` decimal(11,4) DEFAULT NULL,
  PRIMARY KEY (`id_detalle_factura_insumo`),
  KEY `id_factura_insumo` (`id_factura_insumo`),
  KEY `id_insumo` (`id_insumo`),
  KEY `cantidad` (`cantidad`),
  CONSTRAINT `detalle_factura_insumo_ibfk_1` FOREIGN KEY (`id_factura_insumo`) REFERENCES `factura_insumo` (`id_factura_insumo`),
  CONSTRAINT `detalle_factura_insumo_ibfk_2` FOREIGN KEY (`id_insumo`) REFERENCES `insumo` (`id_insumo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `detalle_orden_producto` (
  `id_detalle_orden_producto` int(4) NOT NULL AUTO_INCREMENT,
  `id_orden` int(4) NOT NULL,
  `id_producto` int(4) NOT NULL,
  `cantidad` int(4) DEFAULT NULL,
  `descuento` decimal(11,4) DEFAULT NULL,
  PRIMARY KEY (`id_detalle_orden_producto`),
  KEY `id_orden` (`id_orden`),
  KEY `id_producto` (`id_producto`),
  KEY `cantidad` (`cantidad`),
  CONSTRAINT `detalle_orden_producto_ibfk_1` FOREIGN KEY (`id_orden`) REFERENCES `orden` (`id_orden`),
  CONSTRAINT `detalle_orden_producto_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `detalle_orden_servicio` (
  `id_detalle_orden_servicio` int(4) NOT NULL AUTO_INCREMENT,
  `id_orden` int(4) NOT NULL,
  `id_servicio` int(4) NOT NULL,
  `cantidad` int(4) DEFAULT NULL,
  `descuento` decimal(11,4) DEFAULT NULL,
  PRIMARY KEY (`id_detalle_orden_servicio`),
  KEY `id_orden` (`id_orden`),
  KEY `id_servicio` (`id_servicio`),
  KEY `cantidad` (`cantidad`),
  CONSTRAINT `detalle_orden_servicio_ibfk_1` FOREIGN KEY (`id_orden`) REFERENCES `orden` (`id_orden`),
  CONSTRAINT `detalle_orden_servicio_ibfk_2` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id_servicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `empleado` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `cedula_identidad` varchar(45) DEFAULT NULL,
  `primer_nombre` varchar(45) DEFAULT NULL,
  `segundo_nombre` varchar(45) DEFAULT NULL,
  `primer_apellido` varchar(45) DEFAULT NULL,
  `segundo_apellido` varchar(45) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `edad` int(3) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `estado_civil` varchar(45) DEFAULT NULL,
  `grado_escolaridad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  UNIQUE KEY `cedula_identidad` (`cedula_identidad`),
  KEY `primer_nombre` (`primer_nombre`),
  KEY `primer_apellido` (`primer_apellido`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `empleado_planilla` (
  `id_empleado_planilla` int(4) NOT NULL AUTO_INCREMENT,
  `id_empleado` int(4) DEFAULT NULL,
  `id_planilla` int(4) DEFAULT NULL,
  `salario` decimal(11,4) DEFAULT NULL,
  `fecha_recibido` date DEFAULT NULL,
  PRIMARY KEY (`id_empleado_planilla`),
  KEY `id_empleado` (`id_empleado`),
  KEY `id_planilla` (`id_planilla`),
  KEY `fecha_recibido` (`fecha_recibido`),
  CONSTRAINT `empleado_planilla_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`),
  CONSTRAINT `empleado_planilla_ibfk_2` FOREIGN KEY (`id_planilla`) REFERENCES `planilla` (`id_planilla`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `factura_insumo` (
  `id_factura_insumo` int(4) NOT NULL AUTO_INCREMENT,
  `id_empleado` int(4) NOT NULL,
  `id_proveedor` int(4) NOT NULL,
  `numero_factura` varchar(5) DEFAULT NULL,
  `fecha_orden` date DEFAULT NULL,
  `fecha_recibido` date DEFAULT NULL,
  PRIMARY KEY (`id_factura_insumo`),
  KEY `id_empleado` (`id_empleado`),
  KEY `id_proveedor` (`id_proveedor`),
  KEY `numero_factura` (`numero_factura`),
  KEY `fecha_orden` (`fecha_orden`),
  KEY `fecha_recibido` (`fecha_recibido`),
  CONSTRAINT `factura_insumo_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`),
  CONSTRAINT `factura_insumo_ibfk_2` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `insumo` (
  `id_insumo` int(4) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  `cantidad_inventario` int(4) DEFAULT NULL,
  PRIMARY KEY (`id_insumo`),
  FULLTEXT KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `mantenimiento` (
  `id_mantenimiento` int(4) NOT NULL AUTO_INCREMENT,
  `id_proveedor` int(4) NOT NULL,
  `id_empleado` int(4) NOT NULL,
  `numero_factura` varchar(5) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `descripcion` varchar(70) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `costo` decimal(11,4) DEFAULT NULL,
  PRIMARY KEY (`id_mantenimiento`),
  KEY `id_proveedor` (`id_proveedor`),
  KEY `id_empleado` (`id_empleado`),
  KEY `fecha` (`fecha`),
  FULLTEXT KEY `descripcion` (`descripcion`),
  FULLTEXT KEY `tipo` (`tipo`),
  CONSTRAINT `mantenimiento_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`),
  CONSTRAINT `mantenimiento_ibfk_2` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orden` (
  `id_orden` int(4) NOT NULL AUTO_INCREMENT,
  `id_empleado` int(4) NOT NULL,
  `id_cliente` int(4) NOT NULL,
  `numero_factura` varchar(5) DEFAULT NULL,
  `fecha_orden` date DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `fecha_requerida` date DEFAULT NULL,
  `tipo_orden` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_orden`),
  KEY `numero_factura` (`numero_factura`),
  KEY `id_empleado` (`id_empleado`),
  KEY `id_cliente` (`id_cliente`),
  FULLTEXT KEY `tipo_orden` (`tipo_orden`),
  CONSTRAINT `orden_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`),
  CONSTRAINT `orden_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `pago_empleado` (
  `id_pago_empleado` int(4) NOT NULL AUTO_INCREMENT,
  `id_empleado_planilla` int(4) NOT NULL,
  `id_deposito` int(4) NOT NULL,
  `modo_pago` varchar(20) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_pago_empleado`),
  KEY `id_empleado_planilla` (`id_empleado_planilla`),
  KEY `id_deposito` (`id_deposito`),
  CONSTRAINT `pago_empleado_ibfk_1` FOREIGN KEY (`id_empleado_planilla`) REFERENCES `empleado_planilla` (`id_empleado_planilla`),
  CONSTRAINT `pago_empleado_ibfk_2` FOREIGN KEY (`id_deposito`) REFERENCES `deposito` (`id_deposito`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `pago_insumo` (
  `id_pago_insumo` int(4) NOT NULL AUTO_INCREMENT,
  `id_deposito` int(4) NOT NULL,
  `id_factura_insumo` int(4) NOT NULL,
  PRIMARY KEY (`id_pago_insumo`),
  KEY `id_deposito` (`id_deposito`),
  KEY `id_factura_insumo` (`id_factura_insumo`),
  CONSTRAINT `pago_insumo_ibfk_1` FOREIGN KEY (`id_deposito`) REFERENCES `deposito` (`id_deposito`),
  CONSTRAINT `pago_insumo_ibfk_2` FOREIGN KEY (`id_factura_insumo`) REFERENCES `factura_insumo` (`id_factura_insumo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `pago_mantenimiento` (
  `id_pago_mantenimiento` int(4) NOT NULL AUTO_INCREMENT,
  `id_deposito` int(4) NOT NULL,
  `id_mantenimiento` int(4) NOT NULL,
  PRIMARY KEY (`id_pago_mantenimiento`),
  KEY `id_deposito` (`id_deposito`),
  KEY `id_mantenimiento` (`id_mantenimiento`),
  CONSTRAINT `pago_mantenimiento_ibfk_1` FOREIGN KEY (`id_deposito`) REFERENCES `deposito` (`id_deposito`),
  CONSTRAINT `pago_mantenimiento_ibfk_2` FOREIGN KEY (`id_mantenimiento`) REFERENCES `mantenimiento` (`id_mantenimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `persona_contacto` (
  `id_persona_contacto` int(4) NOT NULL AUTO_INCREMENT,
  `primer_nombre` varchar(45) DEFAULT NULL,
  `segundo_nombre` varchar(45) DEFAULT NULL,
  `primer_apellido` varchar(45) DEFAULT NULL,
  `segundo_apellido` varchar(45) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_persona_contacto`),
  KEY `primer_nombre` (`primer_nombre`),
  KEY `primer_apellido` (`primer_apellido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `planilla` (
  `id_planilla` int(4) NOT NULL AUTO_INCREMENT,
  `numero_planilla` varchar(10) DEFAULT NULL,
  `patronal` decimal(11,4) DEFAULT NULL,
  `periodo` date DEFAULT NULL,
  PRIMARY KEY (`id_planilla`),
  KEY `numero_planilla` (`numero_planilla`),
  KEY `periodo` (`periodo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `producto` (
  `id_producto` int(4) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `precio` decimal(11,4) DEFAULT NULL,
  `cantidad_en_inventario` int(4) DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `precio` (`precio`),
  FULLTEXT KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `proveedor` (
  `id_proveedor` int(4) NOT NULL AUTO_INCREMENT,
  `nombre_proveedor` varchar(50) DEFAULT NULL,
  `descripcion` varchar(70) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `correo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_proveedor`),
  KEY `telefono` (`telefono`),
  KEY `correo` (`correo`),
  FULLTEXT KEY `nombre_proveedor` (`nombre_proveedor`),
  FULLTEXT KEY `descripcion` (`descripcion`),
  FULLTEXT KEY `direccion` (`direccion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `servicio` (
  `id_servicio` int(11) NOT NULL AUTO_INCREMENT,
  `precio` decimal(11,4) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `unidad` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_servicio`),
  FULLTEXT KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuario` (
  `nombre` varchar(10) NOT NULL,
  `id_empleado` int(11) DEFAULT NULL,
  `clave_acceso` varchar(10) NOT NULL,
  `rol` varchar(10) NOT NULL,
  `correo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`nombre`),
  KEY `rol` (`rol`),
  KEY `id_empleado` (`id_empleado`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


