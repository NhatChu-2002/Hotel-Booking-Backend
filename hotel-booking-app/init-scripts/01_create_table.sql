-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema booking-app
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `booking-app` ;

-- -----------------------------------------------------
-- Schema booking-app
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `booking-app` DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_unicode_ci ;
USE `booking-app` ;

-- -----------------------------------------------------
-- Table `booking-app`.`bed_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`bed_type` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`bed_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `modified_at` DATETIME(6) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `booking-app`.`hotel_rate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`hotel_rate` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`hotel_rate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`user` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `date_of_birth` DATETIME(6) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `full_name` VARCHAR(255) NULL DEFAULT NULL,
  `gender` BIT(1) NULL DEFAULT NULL,
  `modified_at` DATETIME(6) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `phone_number` VARCHAR(255) NULL DEFAULT NULL,
  `role` ENUM('ADMIN', 'CUSTOMER', 'HOST') NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`hotel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`hotel` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`hotel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `check_in_time` TIME NULL DEFAULT NULL,
  `check_out_time` TIME NULL DEFAULT NULL,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `district` VARCHAR(255) NULL DEFAULT NULL,
  `main_email` VARCHAR(255) NULL DEFAULT NULL,
  `main_phone_number` VARCHAR(255) NULL DEFAULT NULL,
  `modified_at` DATETIME(6) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `province` VARCHAR(255) NULL DEFAULT NULL,
  `rule` VARCHAR(255) NULL DEFAULT NULL,
  `status` ENUM('ACTIVE', 'INACTIVE', 'OCCUPIED') NULL DEFAULT NULL,
  `street` VARCHAR(255) NULL DEFAULT NULL,
  `ward` VARCHAR(255) NULL DEFAULT NULL,
  `rate_id` INT NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK1mlr6ntd626uereshy0o17n62` (`rate_id` ASC) VISIBLE,
  INDEX `FKi0j3nnn6eecin1ry6cujioqq2` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK1mlr6ntd626uereshy0o17n62`
    FOREIGN KEY (`rate_id`)
    REFERENCES `booking-app`.`hotel_rate` (`id`),
  CONSTRAINT `FKi0j3nnn6eecin1ry6cujioqq2`
    FOREIGN KEY (`user_id`)
    REFERENCES `booking-app`.`user` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`extra_amenity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`extra_amenity` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`extra_amenity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `modified_at` DATETIME(6) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `hotel_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKcyk4p4jet1h8m0vwerixdri9j` (`hotel_id` ASC) VISIBLE,
  CONSTRAINT `FKcyk4p4jet1h8m0vwerixdri9j`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `booking-app`.`hotel` (`id`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `booking-app`.`hotel_amenity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`hotel_amenity` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`hotel_amenity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `modified_at` DATETIME(6) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `hotel_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKihwvu3gblwev48sndufalmb0` (`hotel_id` ASC) VISIBLE,
  CONSTRAINT `FKihwvu3gblwev48sndufalmb0`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `booking-app`.`hotel` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`hotel_hotel_amenity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`hotel_hotel_amenity` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`hotel_hotel_amenity` (
  `price` DOUBLE NULL DEFAULT NULL,
  `hotel_id` INT NOT NULL,
  `hotel_amenity_id` INT NOT NULL,
  PRIMARY KEY (`hotel_id`, `hotel_amenity_id`),
  INDEX `FKmq1ccyc973yloer5cjqn79r7c` (`hotel_amenity_id` ASC) VISIBLE,
  CONSTRAINT `FKggjvigxhwlk6rhytmprswj8kg`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `booking-app`.`hotel` (`id`),
  CONSTRAINT `FKmq1ccyc973yloer5cjqn79r7c`
    FOREIGN KEY (`hotel_amenity_id`)
    REFERENCES `booking-app`.`hotel_amenity` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`hotel_image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`hotel_image` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`hotel_image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `image_path` VARCHAR(255) NULL DEFAULT NULL,
  `modified_at` DATETIME(6) NULL DEFAULT NULL,
  `hotel_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK293ve9b0ocbfji4u5hl2oh3ks` (`hotel_id` ASC) VISIBLE,
  CONSTRAINT `FK293ve9b0ocbfji4u5hl2oh3ks`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `booking-app`.`hotel` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 19;




-- -----------------------------------------------------
-- Table `booking-app`.`payment_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`payment_type` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`payment_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `payment_type_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2;


-- -----------------------------------------------------
-- Table `booking-app`.`reservation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`reservation` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`reservation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `modified_at` DATETIME(6) NULL DEFAULT NULL,
  `site_fees` DOUBLE NULL DEFAULT NULL,
  `status` ENUM('CANCELLED', 'CONFIRMED', 'PENDING') NULL DEFAULT NULL,
  `tax_paid` DOUBLE NULL DEFAULT NULL,
  `total_price` DOUBLE NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKm4oimk0l1757o9pwavorj6ljg` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKm4oimk0l1757o9pwavorj6ljg`
    FOREIGN KEY (`user_id`)
    REFERENCES `booking-app`.`user` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`invoice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`invoice` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`invoice` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `invoice_amount` DOUBLE NULL DEFAULT NULL,
  `refund_amount` DOUBLE NULL DEFAULT NULL,
  `time_canceled` DATETIME(6) NULL DEFAULT NULL,
  `time_created` DATETIME(6) NULL DEFAULT NULL,
  `time_paid` DATETIME(6) NULL DEFAULT NULL,
  `payment_types_id` INT NULL DEFAULT NULL,
  `reservation_id` INT NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_mnulvpqacjexqxb3xccaaw7k5` (`reservation_id` ASC) VISIBLE,
  INDEX `FKcsvxwv08k19l5xddv7wwn7rlp` (`payment_types_id` ASC) VISIBLE,
  INDEX `FKjunvl5maki3unqdvljk31kns3` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKcsvxwv08k19l5xddv7wwn7rlp`
    FOREIGN KEY (`payment_types_id`)
    REFERENCES `booking-app`.`payment_type` (`id`),
  CONSTRAINT `FKjunvl5maki3unqdvljk31kns3`
    FOREIGN KEY (`user_id`)
    REFERENCES `booking-app`.`user` (`id`),
  CONSTRAINT `FKpmh1cqa0lf5txt7pqict1fb52`
    FOREIGN KEY (`reservation_id`)
    REFERENCES `booking-app`.`reservation` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`review` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(255) NULL DEFAULT NULL,
  `rating_total` DOUBLE NULL DEFAULT NULL,
  `hotel_id` INT NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKi0ly7ivbh8ijdgoi7cwtuoavt` (`hotel_id` ASC) VISIBLE,
  INDEX `FKiyf57dy48lyiftdrf7y87rnxi` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKi0ly7ivbh8ijdgoi7cwtuoavt`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `booking-app`.`hotel` (`id`),
  CONSTRAINT `FKiyf57dy48lyiftdrf7y87rnxi`
    FOREIGN KEY (`user_id`)
    REFERENCES `booking-app`.`user` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`view`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`view` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`view` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `modified_at` DATETIME(6) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`room_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`room_type` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`room_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `adult_count` INT NULL DEFAULT NULL,
  `bathroom_count` INT NULL DEFAULT NULL,
  `children_count` INT NULL DEFAULT NULL,
  `count` INT NULL DEFAULT NULL,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `modified_at` DATETIME(6) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `room_area` INT NULL DEFAULT NULL,
  `hotel_id` INT NULL DEFAULT NULL,
  `view_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK8sgnny12n0v74j6u7u94w7mxp` (`hotel_id` ASC) VISIBLE,
  INDEX `FK38lnvla7q0rshhh39eqepjrmd` (`view_id` ASC) VISIBLE,
  CONSTRAINT `FK38lnvla7q0rshhh39eqepjrmd`
    FOREIGN KEY (`view_id`)
    REFERENCES `booking-app`.`view` (`id`),
  CONSTRAINT `FK8sgnny12n0v74j6u7u94w7mxp`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `booking-app`.`hotel` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`room` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`room` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `room_type_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKd468eq7j1cbue8mk20qfrj5et` (`room_type_id` ASC) VISIBLE,
  CONSTRAINT `FKd468eq7j1cbue8mk20qfrj5et`
    FOREIGN KEY (`room_type_id`)
    REFERENCES `booking-app`.`room_type` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`room_amenity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`room_amenity` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`room_amenity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `modified_at` DATETIME(6) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`room_bed_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`room_bed_type` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`room_bed_type` (
  `count` INT NULL DEFAULT NULL,
  `room_type_id` INT NOT NULL,
  `bed_type_id` INT NOT NULL,
  PRIMARY KEY (`bed_type_id`, `room_type_id`),
  INDEX `FKht2d1wiy61ur43ylyho6mc1bb` (`room_type_id` ASC) VISIBLE,
  CONSTRAINT `FK1q78rw118u55o0nk5ahdlyesw`
    FOREIGN KEY (`bed_type_id`)
    REFERENCES `booking-app`.`bed_type` (`id`),
  CONSTRAINT `FKht2d1wiy61ur43ylyho6mc1bb`
    FOREIGN KEY (`room_type_id`)
    REFERENCES `booking-app`.`room_type` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`room_image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`room_image` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`room_image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `image_path` VARCHAR(255) NULL DEFAULT NULL,
  `modified_at` DATETIME(6) NULL DEFAULT NULL,
  `room_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK6jvg5vkoyldi645fpnlkvyugg` (`room_id` ASC) VISIBLE,
  CONSTRAINT `FK6jvg5vkoyldi645fpnlkvyugg`
    FOREIGN KEY (`room_id`)
    REFERENCES `booking-app`.`room_type` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`room_reserved`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`room_reserved` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`room_reserved` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `end_day` DATE NULL DEFAULT NULL,
  `start_day` DATE NULL DEFAULT NULL,
  `reservation_id` INT NULL DEFAULT NULL,
  `room_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKa83e4mjhk6jrar1vs6y63rqtc` (`reservation_id` ASC) VISIBLE,
  INDEX `FK71i4qwjdmwqgguc2y0xcmtrb8` (`room_id` ASC) VISIBLE,
  CONSTRAINT `FK71i4qwjdmwqgguc2y0xcmtrb8`
    FOREIGN KEY (`room_id`)
    REFERENCES `booking-app`.`room` (`id`),
  CONSTRAINT `FKa83e4mjhk6jrar1vs6y63rqtc`
    FOREIGN KEY (`reservation_id`)
    REFERENCES `booking-app`.`reservation` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`room_room_amenity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`room_room_amenity` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`room_room_amenity` (
  `room_type_id` INT NOT NULL,
  `room_amenity_id` INT NOT NULL,
  PRIMARY KEY (`room_type_id`, `room_amenity_id`),
  INDEX `FK3tan2c3wo4wvdhvgq1k8bpr69` (`room_amenity_id` ASC) VISIBLE,
  CONSTRAINT `FK3tan2c3wo4wvdhvgq1k8bpr69`
    FOREIGN KEY (`room_amenity_id`)
    REFERENCES `booking-app`.`room_amenity` (`id`),
  CONSTRAINT `FKcgcfrakf5igdqhncf6jhrdu5y`
    FOREIGN KEY (`room_type_id`)
    REFERENCES `booking-app`.`room_type` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`some_entity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`some_entity` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`some_entity` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-app`.`token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booking-app`.`token` ;

CREATE TABLE IF NOT EXISTS `booking-app`.`token` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `expired` BIT(1) NOT NULL,
  `revoked` BIT(1) NOT NULL,
  `token` VARCHAR(255) NULL DEFAULT NULL,
  `token_type` ENUM('BEARER') NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKe32ek7ixanakfqsdaokm4q9y2` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKe32ek7ixanakfqsdaokm4q9y2`
    FOREIGN KEY (`user_id`)
    REFERENCES `booking-app`.`user` (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
