-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema carmelitas_coffee
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema carmelitas_coffee
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carmelitas_coffee` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `carmelitas_coffee` ;

-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`persona_contacto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`persona_contacto` (
  `id_persona_contacto` INT(11) NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NULL DEFAULT NULL,
  `apellidos` VARCHAR(45) NULL DEFAULT NULL,
  `telefono` VARCHAR(10) NULL DEFAULT NULL,
  `correo` VARCHAR(50) NULL DEFAULT NULL,
  `direccion` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`id_persona_contacto`),
  INDEX `primer_nombre` (`nombres` ASC) VISIBLE,
  INDEX `primer_apellido` (`apellidos` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`cliente` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `numero_ruc` VARCHAR(20) NOT NULL,
  `nombres` VARCHAR(45) NULL DEFAULT NULL,
  `apellidos` VARCHAR(45) NULL DEFAULT NULL,
  `telefono` VARCHAR(10) NULL DEFAULT NULL,
  `correo` VARCHAR(50) NULL DEFAULT NULL,
  `direccion` VARCHAR(60) NULL DEFAULT NULL,
  `id_persona_contacto` INT(11) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `correo` (`correo` ASC) VISIBLE,
  INDEX `id_persona_contacto` (`id_persona_contacto` ASC) VISIBLE,
  FULLTEXT INDEX `nombres` (`nombres`) VISIBLE,
  FULLTEXT INDEX `apellidos` (`apellidos`) VISIBLE,
  FULLTEXT INDEX `direccion` (`direccion`) VISIBLE,
  CONSTRAINT `cliente_ibfk_1`
    FOREIGN KEY (`id_persona_contacto`)
    REFERENCES `carmelitas_coffee`.`persona_contacto` (`id_persona_contacto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`empleado` (
  `id_empleado` INT(11) NOT NULL AUTO_INCREMENT,
  `cedula_identidad` VARCHAR(45) NULL DEFAULT NULL,
  `primer_nombre` VARCHAR(45) NULL DEFAULT NULL,
  `segundo_nombre` VARCHAR(45) NULL DEFAULT NULL,
  `primer_apellido` VARCHAR(45) NULL DEFAULT NULL,
  `segundo_apellido` VARCHAR(45) NULL DEFAULT NULL,
  `sexo` CHAR(1) NULL DEFAULT NULL,
  `edad` INT(11) NULL DEFAULT NULL,
  `direccion` VARCHAR(60) NULL DEFAULT NULL,
  `telefono` VARCHAR(10) NULL DEFAULT NULL,
  `correo` VARCHAR(50) NULL DEFAULT NULL,
  `estado_civil` VARCHAR(45) NULL DEFAULT NULL,
  `grado_escolaridad` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  UNIQUE INDEX `cedula_identidad` (`cedula_identidad` ASC) VISIBLE,
  INDEX `primer_nombre` (`primer_nombre` ASC) VISIBLE,
  INDEX `primer_apellido` (`primer_apellido` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`contrato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`contrato` (
  `id_contrato` INT(11) NOT NULL AUTO_INCREMENT,
  `id_empleado` INT(11) NOT NULL,
  `puesto` VARCHAR(70) NOT NULL,
  `sueldo` DECIMAL(11,4) NULL DEFAULT NULL,
  `comisiones` DECIMAL(2,2) NULL DEFAULT NULL,
  `fecha_contratacion` DATETIME NOT NULL,
  `fecha_expiracion` DATETIME NULL DEFAULT NULL,
  `estado` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_contrato`),
  INDEX `id_empleado` (`id_empleado` ASC) VISIBLE,
  INDEX `sueldo` (`sueldo` ASC) VISIBLE,
  INDEX `estado` (`estado` ASC) VISIBLE,
  FULLTEXT INDEX `puesto` (`puesto`) VISIBLE,
  CONSTRAINT `contrato_ibfk_1`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `carmelitas_coffee`.`empleado` (`id_empleado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`deposito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`deposito` (
  `id_deposito` INT(11) NOT NULL AUTO_INCREMENT,
  `numero_comprobante` VARCHAR(20) NULL DEFAULT NULL,
  `banco` VARCHAR(30) NULL DEFAULT NULL,
  `monto` DECIMAL(11,4) NULL DEFAULT NULL,
  `moneda` VARCHAR(30) NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_deposito`),
  INDEX `numero_comprobante` (`numero_comprobante` ASC) VISIBLE,
  INDEX `banco` (`banco` ASC) VISIBLE,
  INDEX `moneda` (`moneda` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`proveedor` (
  `id_proveedor` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_proveedor` VARCHAR(50) NULL DEFAULT NULL,
  `descripcion` VARCHAR(70) NULL DEFAULT NULL,
  `telefono` VARCHAR(10) NULL DEFAULT NULL,
  `direccion` VARCHAR(50) NULL DEFAULT NULL,
  `correo` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`id_proveedor`),
  INDEX `telefono` (`telefono` ASC) VISIBLE,
  INDEX `correo` (`correo` ASC) VISIBLE,
  FULLTEXT INDEX `nombre_proveedor` (`nombre_proveedor`) VISIBLE,
  FULLTEXT INDEX `descripcion` (`descripcion`) VISIBLE,
  FULLTEXT INDEX `direccion` (`direccion`) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`factura_insumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`factura_insumo` (
  `id_factura_insumo` INT(11) NOT NULL AUTO_INCREMENT,
  `id_empleado` INT(11) NOT NULL,
  `id_proveedor` INT(11) NOT NULL,
  `numero_factura` VARCHAR(5) NULL DEFAULT NULL,
  `modo_pago` VARCHAR(45) NOT NULL,
  `fecha_orden` DATE NULL DEFAULT NULL,
  `fecha_recibido` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_factura_insumo`),
  INDEX `id_empleado` (`id_empleado` ASC) VISIBLE,
  INDEX `id_proveedor` (`id_proveedor` ASC) VISIBLE,
  INDEX `numero_factura` (`numero_factura` ASC) VISIBLE,
  INDEX `fecha_orden` (`fecha_orden` ASC) VISIBLE,
  INDEX `fecha_recibido` (`fecha_recibido` ASC) VISIBLE,
  CONSTRAINT `factura_insumo_ibfk_1`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `carmelitas_coffee`.`empleado` (`id_empleado`),
  CONSTRAINT `factura_insumo_ibfk_2`
    FOREIGN KEY (`id_proveedor`)
    REFERENCES `carmelitas_coffee`.`proveedor` (`id_proveedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`insumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`insumo` (
  `id_insumo` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  `cantidad_inventario` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_insumo`),
  FULLTEXT INDEX `descripcion` (`descripcion`) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`detalle_factura_insumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`detalle_factura_insumo` (
  `id_detalle_factura_insumo` INT(11) NOT NULL AUTO_INCREMENT,
  `id_factura_insumo` INT(11) NOT NULL,
  `id_insumo` INT(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `precio` DECIMAL(11,4) NOT NULL,
  `descuento` DECIMAL(11,4) NULL DEFAULT NULL,
  PRIMARY KEY (`id_detalle_factura_insumo`),
  INDEX `id_factura_insumo` (`id_factura_insumo` ASC) VISIBLE,
  INDEX `id_insumo` (`id_insumo` ASC) VISIBLE,
  INDEX `cantidad` (`cantidad` ASC) VISIBLE,
  CONSTRAINT `detalle_factura_insumo_ibfk_1`
    FOREIGN KEY (`id_factura_insumo`)
    REFERENCES `carmelitas_coffee`.`factura_insumo` (`id_factura_insumo`),
  CONSTRAINT `detalle_factura_insumo_ibfk_2`
    FOREIGN KEY (`id_insumo`)
    REFERENCES `carmelitas_coffee`.`insumo` (`id_insumo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`orden` (
  `id_orden` INT(11) NOT NULL AUTO_INCREMENT,
  `id_empleado` INT(11) NOT NULL,
  `id_cliente` INT(11) NOT NULL,
  `numero_factura` VARCHAR(5) NOT NULL,
  `fecha_orden` DATE NOT NULL,
  `fecha_entrega` DATE NOT NULL,
  `fecha_requerida` DATE NOT NULL,
  `sub_total` DECIMAL(11,4) NOT NULL,
  `iva` DECIMAL(11,4) NOT NULL,
  `total` DECIMAL(11,4) NOT NULL,
  PRIMARY KEY (`id_orden`),
  INDEX `numero_factura` (`numero_factura` ASC) VISIBLE,
  INDEX `id_empleado` (`id_empleado` ASC) VISIBLE,
  INDEX `id_cliente` (`id_cliente` ASC) VISIBLE,
  CONSTRAINT `orden_ibfk_1`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `carmelitas_coffee`.`empleado` (`id_empleado`),
  CONSTRAINT `orden_ibfk_2`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `carmelitas_coffee`.`cliente` (`id_cliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`producto` (
  `id_producto` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  `precio` DECIMAL(11,4) NOT NULL,
  `cantidad_en_inventario` INT(11) NOT NULL,
  `exento_iva` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_producto`),
  INDEX `precio` (`precio` ASC) VISIBLE,
  FULLTEXT INDEX `descripcion` (`descripcion`) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`detalle_orden_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`detalle_orden_producto` (
  `id_detalle_orden_producto` INT(11) NOT NULL AUTO_INCREMENT,
  `id_orden` INT(11) NOT NULL,
  `id_producto` INT(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `precio_unit` DECIMAL(11,4) NOT NULL,
  `descuento` DECIMAL(11,4) NULL DEFAULT NULL,
  PRIMARY KEY (`id_detalle_orden_producto`),
  INDEX `id_orden` (`id_orden` ASC) VISIBLE,
  INDEX `id_producto` (`id_producto` ASC) VISIBLE,
  INDEX `cantidad` (`cantidad` ASC) VISIBLE,
  CONSTRAINT `detalle_orden_producto_ibfk_1`
    FOREIGN KEY (`id_orden`)
    REFERENCES `carmelitas_coffee`.`orden` (`id_orden`),
  CONSTRAINT `detalle_orden_producto_ibfk_2`
    FOREIGN KEY (`id_producto`)
    REFERENCES `carmelitas_coffee`.`producto` (`id_producto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`servicio` (
  `id_servicio` INT(11) NOT NULL AUTO_INCREMENT,
  `precio` DECIMAL(11,4) NULL DEFAULT NULL,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  `exento_iva` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_servicio`),
  FULLTEXT INDEX `descripcion` (`descripcion`) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`detalle_orden_servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`detalle_orden_servicio` (
  `id_detalle_orden_servicio` INT(11) NOT NULL AUTO_INCREMENT,
  `id_orden` INT(11) NOT NULL,
  `id_servicio` INT(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `precio_unit` DECIMAL(11,4) NOT NULL,
  `descuento` DECIMAL(11,4) NULL DEFAULT NULL,
  PRIMARY KEY (`id_detalle_orden_servicio`),
  INDEX `id_orden` (`id_orden` ASC) VISIBLE,
  INDEX `id_servicio` (`id_servicio` ASC) VISIBLE,
  INDEX `cantidad` (`cantidad` ASC) VISIBLE,
  CONSTRAINT `detalle_orden_servicio_ibfk_1`
    FOREIGN KEY (`id_orden`)
    REFERENCES `carmelitas_coffee`.`orden` (`id_orden`),
  CONSTRAINT `detalle_orden_servicio_ibfk_2`
    FOREIGN KEY (`id_servicio`)
    REFERENCES `carmelitas_coffee`.`servicio` (`id_servicio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`planilla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`planilla` (
  `id_planilla` INT(11) NOT NULL AUTO_INCREMENT,
  `numero_planilla` VARCHAR(10) NULL DEFAULT NULL,
  `patronal` DECIMAL(11,4) NULL DEFAULT NULL,
  `periodo` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_planilla`),
  INDEX `numero_planilla` (`numero_planilla` ASC) VISIBLE,
  INDEX `periodo` (`periodo` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`empleado_planilla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`empleado_planilla` (
  `id_empleado_planilla` INT(11) NOT NULL AUTO_INCREMENT,
  `id_empleado` INT(11) NULL DEFAULT NULL,
  `id_planilla` INT(11) NULL DEFAULT NULL,
  `salario_base` DECIMAL(11,4) NULL DEFAULT NULL,
  `comisiones` DECIMAL(11,4) NULL DEFAULT NULL,
  `salario_bruto` DECIMAL(11,4) NULL DEFAULT NULL,
  `inss_laboral` DECIMAL(11,4) NOT NULL,
  `ir` DECIMAL(11,4) NOT NULL,
  `salario_total` DECIMAL(11,4) NOT NULL,
  PRIMARY KEY (`id_empleado_planilla`),
  INDEX `id_empleado` (`id_empleado` ASC) VISIBLE,
  INDEX `id_planilla` (`id_planilla` ASC) VISIBLE,
  CONSTRAINT `empleado_planilla_ibfk_1`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `carmelitas_coffee`.`empleado` (`id_empleado`),
  CONSTRAINT `empleado_planilla_ibfk_2`
    FOREIGN KEY (`id_planilla`)
    REFERENCES `carmelitas_coffee`.`planilla` (`id_planilla`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`mantenimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`mantenimiento` (
  `id_mantenimiento` INT(11) NOT NULL AUTO_INCREMENT,
  `id_proveedor` INT(11) NOT NULL,
  `id_empleado` INT(11) NOT NULL,
  `numero_factura` VARCHAR(5) NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  `descripcion` VARCHAR(70) NULL DEFAULT NULL,
  `tipo` VARCHAR(50) NULL DEFAULT NULL,
  `costo` DECIMAL(11,4) NULL DEFAULT NULL,
  PRIMARY KEY (`id_mantenimiento`),
  INDEX `id_proveedor` (`id_proveedor` ASC) VISIBLE,
  INDEX `id_empleado` (`id_empleado` ASC) VISIBLE,
  INDEX `fecha` (`fecha` ASC) VISIBLE,
  FULLTEXT INDEX `descripcion` (`descripcion`) VISIBLE,
  FULLTEXT INDEX `tipo` (`tipo`) VISIBLE,
  CONSTRAINT `mantenimiento_ibfk_1`
    FOREIGN KEY (`id_proveedor`)
    REFERENCES `carmelitas_coffee`.`proveedor` (`id_proveedor`),
  CONSTRAINT `mantenimiento_ibfk_2`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `carmelitas_coffee`.`empleado` (`id_empleado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`pago_empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`pago_empleado` (
  `id_pago_empleado` INT(11) NOT NULL AUTO_INCREMENT,
  `id_empleado_planilla` INT(11) NOT NULL,
  `id_deposito` INT(11) NOT NULL,
  `modo_pago` VARCHAR(20) NULL DEFAULT 'DEPOSITO',
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id_pago_empleado`),
  INDEX `id_empleado_planilla` (`id_empleado_planilla` ASC) VISIBLE,
  INDEX `id_deposito` (`id_deposito` ASC) VISIBLE,
  CONSTRAINT `pago_empleado_ibfk_1`
    FOREIGN KEY (`id_empleado_planilla`)
    REFERENCES `carmelitas_coffee`.`empleado_planilla` (`id_empleado_planilla`),
  CONSTRAINT `pago_empleado_ibfk_2`
    FOREIGN KEY (`id_deposito`)
    REFERENCES `carmelitas_coffee`.`deposito` (`id_deposito`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`pago_insumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`pago_insumo` (
  `id_pago_insumo` INT(11) NOT NULL AUTO_INCREMENT,
  `id_deposito` INT(11) NOT NULL,
  `id_factura_insumo` INT(11) NOT NULL,
  PRIMARY KEY (`id_pago_insumo`),
  INDEX `id_deposito` (`id_deposito` ASC) VISIBLE,
  INDEX `id_factura_insumo` (`id_factura_insumo` ASC) VISIBLE,
  CONSTRAINT `pago_insumo_ibfk_1`
    FOREIGN KEY (`id_deposito`)
    REFERENCES `carmelitas_coffee`.`deposito` (`id_deposito`),
  CONSTRAINT `pago_insumo_ibfk_2`
    FOREIGN KEY (`id_factura_insumo`)
    REFERENCES `carmelitas_coffee`.`factura_insumo` (`id_factura_insumo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`pago_mantenimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`pago_mantenimiento` (
  `id_pago_mantenimiento` INT(11) NOT NULL AUTO_INCREMENT,
  `id_deposito` INT(11) NOT NULL,
  `id_mantenimiento` INT(11) NOT NULL,
  PRIMARY KEY (`id_pago_mantenimiento`),
  INDEX `id_deposito` (`id_deposito` ASC) VISIBLE,
  INDEX `id_mantenimiento` (`id_mantenimiento` ASC) VISIBLE,
  CONSTRAINT `pago_mantenimiento_ibfk_1`
    FOREIGN KEY (`id_deposito`)
    REFERENCES `carmelitas_coffee`.`deposito` (`id_deposito`),
  CONSTRAINT `pago_mantenimiento_ibfk_2`
    FOREIGN KEY (`id_mantenimiento`)
    REFERENCES `carmelitas_coffee`.`mantenimiento` (`id_mantenimiento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carmelitas_coffee`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carmelitas_coffee`.`usuario` (
  `nombre` VARCHAR(10) NOT NULL,
  `id_empleado` INT(11) NULL DEFAULT NULL,
  `clave_acceso` VARCHAR(10) NOT NULL,
  `rol` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`nombre`),
  INDEX `rol` (`rol` ASC) VISIBLE,
  INDEX `id_empleado` (`id_empleado` ASC) VISIBLE,
  CONSTRAINT `usuario_ibfk_1`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `carmelitas_coffee`.`empleado` (`id_empleado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
