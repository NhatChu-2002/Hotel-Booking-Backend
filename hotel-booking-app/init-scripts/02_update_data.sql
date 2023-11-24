
ALTER TABLE extra_amenity
ADD COLUMN price DOUBLE;

ALTER TABLE `booking-app`.`user` 
CHANGE COLUMN `role` `role` ENUM('ADMIN', 'CUSTOMER', 'HOST', 'NOT_REGISTERED_CUSTOMER') NULL DEFAULT NULL ;

ALTER TABLE `booking-app`.`user` 
ADD UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE;

ALTER TABLE `booking-app`.`room`
CHANGE COLUMN `description` `name` VARCHAR(255) NULL DEFAULT NULL ;

ALTER TABLE `booking-app`.`invoice` 
ADD COLUMN `vnp_txnref` VARCHAR(45) NULL AFTER `user_id`,
ADD COLUMN `vnp_transdate` VARCHAR(45) NULL AFTER `vnp_txnref`,
CHANGE COLUMN `refund_amount` `refund_amount` BIGINT(50) NULL DEFAULT NULL ;

ALTER TABLE `booking-app`.`invoice` 
DROP FOREIGN KEY `FKcsvxwv08k19l5xddv7wwn7rlp`;
ALTER TABLE `booking-app`.`invoice` 
DROP COLUMN `payment_types_id`,
ADD COLUMN `payment_type` ENUM('CREDIT_CARD', 'CASH') NULL AFTER `vnp_transdate`,
DROP INDEX `FKcsvxwv08k19l5xddv7wwn7rlp` ;
;
DROP TABLE IF EXISTS `booking-app`.`payment_type` ;

ALTER TABLE reservation
ADD COLUMN hotel_id INT,
ADD CONSTRAINT fk_hotel
    FOREIGN KEY (hotel_id)
    REFERENCES hotel(id);


