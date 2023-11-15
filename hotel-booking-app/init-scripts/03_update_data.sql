UPDATE hotel
SET rule = 'Không phù hợp cho trẻ vị thành niên, Không cho phép hút thuốc, Không cho phép các loại thú cưng, Hủy phòng trước 1 ngày sẽ không mất phí';
ALTER TABLE extra_amenity
ADD COLUMN price DOUBLE;

ALTER TABLE `booking-app`.`user` 
CHANGE COLUMN `role` `role` ENUM('ADMIN', 'CUSTOMER', 'HOST', 'NOT_REGISTERED_CUSTOMER') NULL DEFAULT NULL ;

ALTER TABLE `booking-app`.`user` 
ADD UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE;

ALTER TABLE `booking-app`.`room_type` 
ADD COLUMN `room_name` VARCHAR(5) NULL AFTER `children_count`;

ALTER TABLE `booking-app`.`room` 
CHANGE COLUMN `description` `name` VARCHAR(255) NULL DEFAULT NULL ;

