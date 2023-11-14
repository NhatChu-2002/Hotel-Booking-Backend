UPDATE hotel
SET rule = 'Không phù hợp cho trẻ vị thành niên, Không cho phép hút thuốc, Không cho phép các loại thú cưng, Hủy phòng trước 1 ngày sẽ không mất phí';
ALTER TABLE extra_amenity
ADD COLUMN price DOUBLE;

INSERT INTO extra_amenity (name, description, hotel_id, price)
VALUES
  ('Amenity1', 'Description1', 1, 10.5),
  ('Amenity2', 'Description2', 1, 15.0),
  ('Amenity3', 'Description3', 2, 12.75),
  ('Amenity3', 'Description3', 2, 12.75),
  ('Amenity3', 'Description3', 2, 12.75),
  ('Amenity3', 'Description3', 3, 12.75),
  ('Amenity3121', 'Description3', 4, 12.75),
  ('Amenity123', 'Description3', 5, 12.75),
  ('Amenity1234', 'Description3', 5, 12.75),
  ('Amenity312132', 'Description3', 6, 12.75),
  ('Amenity1234', 'Description3', 7, 12.75),
  ('Amenity1234', 'Description3', 8, 12.75);
ALTER TABLE `booking-app`.`user` 
CHANGE COLUMN `role` `role` ENUM('ADMIN', 'CUSTOMER', 'HOST', 'NOT_REGISTERED_CUSTOMER') NULL DEFAULT NULL ;

ALTER TABLE `booking-app`.`user` 
ADD UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE;
