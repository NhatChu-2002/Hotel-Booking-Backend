USE `booking-app` ;
INSERT INTO `user`(id, full_name, email, `password`, `role`)
VALUES(1, 'Admin', 'admin@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'ADMIN'), 
	  (2, 'Host1', 'host1@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (3, 'Host2', 'host2@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (4, 'Host3', 'host3@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (5, 'Host4', 'host4@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (6, 'Host5', 'host5@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (7, 'Host6', 'host6@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (8, 'Host7', 'host7@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (9, 'Host8', 'host8@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (10, 'Host9', 'host9@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (11, 'Host10', 'host10@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (12, 'Host11', 'host11@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (13, 'Host12', 'host12@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (14, 'Host13', 'host13@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (15, 'Host14', 'host14@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (16, 'Host15', 'host15@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (17, 'Host16', 'host16@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (18, 'Host17', 'host17@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (19, 'Host18', 'host18@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (20, 'Host18', 'host19@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (21, 'Host20', 'host20@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (22, 'Customer1', 'customer1@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (23, 'Customer2', 'customer2@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (24, 'Customer3', 'customer3@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (25, 'Customer4', 'customer4@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (26, 'Customer5', 'customer5@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (27, 'Customer6', 'customer6@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (28, 'Customer7', 'custome7@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (29, 'Customer8', 'customer8@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (30, 'Customer9', 'customer9@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (31, 'Customer10', 'customer10@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (32, 'Customer11', 'customer11@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (33, 'Customer12', 'customer12@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (34, 'Customer13', 'customer13@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (35, 'Customer14', 'customer14@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (36, 'Customer15', 'customer15@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (37, 'Customer16', 'customer16@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (38, 'Customer17', 'customer17@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
	  (39, 'Customer18', 'customer18@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (40, 'Customer19', 'customer19@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (41, 'Customer20', 'customer20@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (42, 'Customer21', 'customer21@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (43, 'Customer22', 'customer22@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (44, 'Customer23', 'customer23@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (45, 'Customer24', 'customer24@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (46, 'Customer25', 'customer25@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (47, 'Customer26', 'customer26@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (48, 'Customer27', 'custome27@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (49, 'Customer28', 'customer228@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (50, 'Customer29', 'customer29@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (51, 'Customer30', 'customer30@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (52, 'Customer31', 'customer31@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (53, 'Customer32', 'customer32@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (54, 'Customer33', 'customer33@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (55, 'Customer34', 'customer34@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (56, 'Customer35', 'customer35@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (57, 'Customer36', 'customer36@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (58, 'Customer37', 'customer37@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
	  (59, 'Customer38', 'customer38@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (60, 'Customer39', 'customer39@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (61, 'Customer40', 'customer40@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (62, 'Customer41', 'custome41@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (63, 'Customer42', 'customer42@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (64, 'Customer43', 'customer43@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (65, 'Customer44', 'customer44@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (66, 'Customer45', 'customer45@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (67, 'Customer46', 'customer46@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (68, 'Customer47', 'customer47@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
	  (69, 'Customer48', 'customer48@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (70, 'Customer49', 'customer49@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (71, 'Customer50', 'customer50@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (72, 'Customer51', 'customer51@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (73, 'Customer52', 'customer52@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (74, 'Customer53', 'customer53@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (75, 'Customer54', 'customer54@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (76, 'Customer55', 'customer55@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (77, 'Customer56', 'customer56@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (78, 'Customer57', 'customer57@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
	  (79, 'Customer58', 'customer58@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (80, 'Customer59', 'customer59@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (81, 'Customer60', 'customer60@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER');
      

-- INSERT INTO token()
-- VALUES();
    
    
INSERT INTO hotel_rate(id, `name`)
VALUES(1, '1 sao'),
	  (2, '2 sao'),
      (3, '3 sao'),
      (4, '4 sao'),
      (5, '5 sao');
     
     
INSERT INTO hotel_amenity(id, `name`)
VALUES(1, 'WiFi miễn phí'),
	  (2, 'Chỗ đỗ xe'),
	  (3, 'Phòng gia đình'),
	  (4, 'Phòng không hút thuốc'),
	  (5, 'Lễ tân 24 giờ'),
	  (6, 'Dịch vụ phòng'),
	  (7, 'Xe đưa đón sân bay'),
	  (8, 'Nhà hàng'),
	  (9, 'Trung tâm Spa & chăm sóc sức khoẻ'),
      (10, 'Cho phép mang theo vật nuôi'),
      (11, 'Trung tâm thể dục'),
      (12, 'Trạm sạc xe điện');
      
      
INSERT INTO hotel(id, `name`, `description`, province, district, ward, street, main_phone_number, main_email, check_in_time, check_out_time, `status`, rate_id, user_id)
VALUES(1, 'Menora Premium Da Nang - Sea Corner Boutique', 'Quay mặt ra bãi biển ở thành phố Đà Nẵng, Menora Premium Da Nang - Sea Corner Boutique cung cấp chỗ nghỉ 3 sao và có hồ bơi ngoài trời, sân hiên cũng như nhà hàng.', 'Thành phố Đà Nẵng', 'Ngũ Hành Sơn', 'Mỹ An', '196 Trần Bạch Đằng', '123456789', 'ks1@gmail.com', '07:00:00', '23:00:00', 'ACTIVE', 1, 2),
	  (2, 'MANGO MANGO HOTEL & APARTMENT', 'MANGO MANGO HOTEL & APARTMENT has city views, free WiFi and free private parking, set in Da Nang, 400 metres from My Khe Beach.', 'Thành phố Đà Nẵng', 'Ngũ Hành Sơn', 'Mỹ An', 'Mỹ Đa Đông 12', '123456789', 'ks2@gmail.com', '07:00:00', '23:00:00', 'ACTIVE', 2, 3),
      (3, 'Merry Land Hotel Da Nang', 'Merry Land Hotel Da Nang cung cấp các phòng nghỉ tại thành phố Đà Nẵng, cách Cầu Sông Hàn chỉ 2 phút lái xe. Khách sạn có hồ bơi ngoài trời mở cửa quanh năm, sân hiên tắm nắng và quầy bar tại chỗ.', 'Thành phố Đà Nẵng', 'Sơn Trà', 'An Hải Bắc', '21 Phạm Văn Đồng', '123456789', 'ks3@gmail.com', '07:00:00', '23:00:00', 'ACTIVE', 3, 4),
      (4, 'Shara Hotel Da Nang', 'Tọa lạc tại thành phố Đà Nẵng, cách Bãi biển Mỹ Khê 600 m và Bãi biển Bắc Mỹ An 1,3 km, Shara Hotel Da Nang cung cấp chỗ nghỉ với sảnh khách chung và WiFi miễn phí cũng như chỗ đỗ xe riêng miễn phí...', 'Thành phố Đà Nẵng', 'Ngũ Hành Sơn', 'Bắc Mỹ Phú', '53 Phan Liem', '123456789', 'ks4@gmail.com', '07:00:00', '23:00:00', 'ACTIVE', 4, 5),
      (5, 'Le House Boutique Hotel', 'Nằm trên khu vực Bãi biển Mỹ Khê ở thành phố Đà Nẵng, trong bán kính 2 km từ Cầu Sông Hàn, Le House Boutique Hotel cung cấp các phòng gắn máy điều hòa với Wi-Fi miễn phí toàn khuôn viên.', 'Thành phố Đà Nẵng', 'Sơn Trà', 'Phước Mỹ', '87 Hà Bổng', '123456789', 'ks5@gmail.com', '07:00:00', '23:00:00', 'ACTIVE', 5, 6),
      (6, 'Seashore Hotel & Apartment', 'Seashore Hotel & Apartment cung cấp chỗ nghỉ 4 sao hướng biển ở thành phố Đà Nẵng. Chỗ nghỉ có xe đạp để khách sử dụng miễn phí, hồ bơi ngoài trời và trung tâm thể dục.', 'Thành phố Đà Nẵng', 'Sơn Trà', 'Mân Thái', '16 Hoàng Sa', '123456789', 'ks6@gmail.com', '07:00:00', '23:00:00', 'ACTIVE', 4, 7),
      (7, 'Grand Sheraton', 'Tọa lạc trên cung đường biển tuyệt đẹp chạy thẳng từ thành phố Đà Nẵng đến Hội An', 'Tỉnh Quảng Nam', 'Ngũ Hành Sơn', 'Mỹ An', '196 Trần Bạch Đằng', '123456789', 'ks7@gmail.com', '07:00:00', '21:00:00','ACTIVE', 5, 8),
	  (8, 'Mia resort', 'Tọa lạc trên cung đường biển tuyệt đẹp chạy thẳng từ thành phố Đà Nẵng đến Hội An,', 'Thành phố Sài gòn', 'Ngũ Hành Sơn', 'Mỹ An', 'Mỹ Đa Đông 12', '123456789', 'ks8@gmail.com', '07:00:00', '21:00:00','ACTIVE', 4, 9),
	  (9, 'TIA beach Hotel ', 'Tọa lạc trên cung đường biển tuyệt đẹp chạy thẳng từ thành phố Đà Nẵng đến Hội An,', 'Thành phố Hà Nội', 'Sơn Trà', 'An Hải Bắc', '21 Phạm Văn Đồng', '123456789', 'ks9@gmail.com', '07:00:00', '21:00:00','ACTIVE', 5, 10),
	  (10, 'A LA CARTE', 'Tọa lạc trên cung đường biển tuyệt đẹp chạy thẳng từ thành phố Đà Nẵng đến Hội An,', 'Tỉnh Quảng Ngãi', 'Ngũ Hành Sơn', 'Bắc Mỹ Phú', '53 Phan Liem', '123456789', 'ks10@gmail.com', '07:00:00', '21:00:00','ACTIVE', 3, 11),
	  (11, 'Blue Sea', 'Tọa lạc trên cung đường biển tuyệt đẹp chạy thẳng từ thành phố Đà Nẵng đến Hội An,', 'Thành phố Hà Nội', 'Sơn Trà', 'Phước Mỹ', '87 Hà Bổng', '123456789', 'ks11@gmail.com', '07:00:00', '21:00:00','ACTIVE', 2, 12),
	  (12, 'Vinpearl Melia', 'Tọa lạc trên cung đường biển tuyệt đẹp chạy thẳng từ thành phố Đà Nẵng đến Hội An,', 'Thành phố Sài gòn', 'Sơn Trà', 'Mân Thái', '16 Hoàng Sa', '123456789', 'ks12@gmail.com', '07:00:00', '21:00:00','ACTIVE', 5, 13);

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
  
INSERT INTO hotel_image(id, image_path, hotel_id)
VALUES(1, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/80ecbccb-b32f-4cf5-b23c-a6d2d0534dae_hotel1.jpeg', 1),
 	  (2, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/23c16767-00e3-4192-80f2-e151323ae53f_hotel2.png', 1),
	  (3, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/c326d8bf-73e9-4422-812e-8d08bd3ccb2e_hotel3.jpeg', 1),
      (4, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/9d602727-817f-45f8-955e-afac2a7ac52d_hotel4.jpeg', 1),
 	  (5, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/b47330b5-aac9-414a-b173-84c1f5608a86_hotel5.jpeg', 1),
	  (6, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/a0fd9c23-6c96-4f83-b958-9486a17478c3_hotel6.jpeg', 2),
      (7, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/1e817c9f-3db1-428c-a4a5-7c4c2561524d_hotel7.jpeg', 2),
 	  (8, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/92bcfefe-51d3-4ba2-9f0d-f924fbb0f4e9_hotel8.jpeg', 2),
	  (9, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/e718b9a8-124e-4502-8f52-d43444f385ce_hotel9.jpeg', 2),
      (10, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/eb7ecd5c-b0da-4bd5-b52c-7fff60bcfe19_hotel10.jpeg', 2),
 	  (11, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/654f559e-2638-4cd6-b863-dd492e8f0168_hotel11.jpeg', 3),
	  (12, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/52dc93b5-fcc9-40ca-9d31-1a09a4afd4c6_hotel12.jpeg', 3),
	  (13, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/06d0cd5f-bcdc-4ed9-8569-7943ac9df15c_hotel13.jpg', 3),
	  (14, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/d07c72c2-a4f3-48f4-abb4-2f635631bfd5_hotel14.jpg', 3),
	  (15, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/449b3596-2d5f-427b-b9d8-874bb2bb61e7_hotel15.jpeg', 3),
	  (16, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/9821c6e5-0e21-4141-905e-99817d1402d4_hotel16.jpeg', 4),
	  (17, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/df845272-8640-4e25-b7e5-bc9dad82ac56_hotel17.jpeg', 4),
	  (18, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/e5b00f08-451a-4550-a98c-3dae7720dc77_hotel18.jpg', 4),
	  (19, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/923064f9-eaf7-4bca-b1bd-52e037a814b3_hotel1.jpeg', 4),
	  (20, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/c07beafd-ccfd-4d7e-abb8-34be93410c32_hotel2.png', 4),
	  (21, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/a8189e26-e6ec-433b-8d7a-210debf162ab_hotel17.jpeg', 5),
	  (22, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/090c2ff6-84e0-45b5-8dbe-220f35aff9be_hotel4.jpeg', 5),
	  (23, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/378ba0ec-872d-42fa-a4b8-f1200044ac65_hotel5.jpeg', 5),
	  (24, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/d0559042-2b4b-4ed1-b607-c3ac0d2749c9_hotel6.jpeg', 5),
	  (25, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/0deb918c-8d18-4edf-8de6-a34bd3e3575e_hotel7.jpeg', 5),
	  (26, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/87f4d774-40b2-46ba-ae7e-5f2d2c3ecb83_hotel18.jpg', 6),
	  (27, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/218e10f7-f2b2-44cf-a2f5-da1fb8480af3_hotel9.jpeg', 6),
	  (28, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/1a11c4c6-90a1-4ea8-8734-1e16302d2a75_hotel10.jpeg', 6),
	  (29, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/361ac41c-263f-4fd3-be68-7e8a59cd7169_hotel12.jpeg', 6),
	  (30, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/d174b7dc-1708-42ad-8de1-fd7cdc9d3181_hotel14.jpg', 6),
	  (31, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/49dafd2e-f028-402b-8673-f2b015518d37_hotel2.png', 7),
	  (32, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/a84f85dd-a165-4979-8bcb-b373a2a132ff_hotel1.jpeg', 7),
	  (33, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/f964c264-c7c6-4e66-9f46-627bfc433eaa_hotel3.jpeg', 7),
	  (34, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/0aa81016-960b-4559-b282-fd0040b5b8d1_hotel4.jpeg', 7),
	  (35, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/ba32e0cc-0625-4bbf-b830-9e4b566946b6_hotel5.jpeg', 7),
	  (36, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/45c6e63c-4843-481e-b09a-704c10fb6b58_hotel4.jpeg', 8),
	  (37, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/eff82191-47b2-4694-934e-a867d8f74ce2_hotel7.jpeg', 8),
	  (38, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/cf1d6006-2713-4019-8d00-7fda347ddb2c_hotel8.jpeg', 8),
	  (39, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/e077922c-e3e0-4d36-a433-ef04c1aeca24_hotel9.jpeg', 8),
	  (40, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/83bd8b4f-86b2-44c1-9ab1-f82e05ae6231_hotel10.jpeg', 8),
	  (41, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/8498b193-6387-471e-90c2-faf13e4f6003_hotel5.jpeg', 9),
	  (42, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/a737710b-67cc-4d1a-884d-61fda409bf98_hotel12.jpeg', 9),
	  (43, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/251db734-2d43-4101-ad58-a7d217bb52b3_hotel13.jpg', 9),
	  (44, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/37feaff6-89c7-4520-8f4d-62aaf2f3c051_hotel14.jpg', 9),
	  (45, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/76a7d0c8-089c-4673-a70e-e7f68f874d92_hotel15.jpeg', 9),
	  (46, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/719463d8-5956-4865-baaf-31d3e09f9b5b_hotel8.jpeg', 10),
	  (47, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/71106abe-4dd2-41fd-8c82-4c5a30ddfae2_hotel17.jpeg', 10),
	  (48, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/f9bc69a5-6f6d-4239-b828-14497d5e93f7_hotel18.jpg', 10),
	  (49, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/0533761d-f2e3-46ec-9ea8-c003a52e7c4b_hotel1.jpeg', 10),
	  (50, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/8bac1971-7e8b-48c5-89e1-f07b489988f1_hotel2.png', 10),
	  (51, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/6fcffd73-4b39-4f28-9d2e-ea3de1d6ff1c_hotel9.jpeg', 11),
	  (52, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/65a3a67f-0cda-48fb-80c3-337f66c3fec7_hotel4.jpeg', 11),
	  (53, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/c4c1a6d6-b149-4526-9871-9e0f35cdad4a_hotel5.jpeg', 11),
	  (54, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/5a6c825b-6ba2-483f-8447-2aa553b5ed95_hotel6.jpeg', 11),
	  (55, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/6e83ffd3-0aa3-4e50-b39f-c4ba9e9ea23e_hotel7.jpeg', 11),
	  (56, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/da17096e-98d4-4814-a869-2eb70045e321_hotel11.jpeg', 12),
	  (57, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/fd3e19dd-ad32-4caa-ae1d-76e22e5b4d62_hotel9.jpeg', 12),
	  (58, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/41c555ce-6403-401f-a40c-2ede888095c2_hotel10.jpeg', 12),
	  (59, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/fee95284-aef2-4beb-b40d-de15894b91dd_hotel12.jpeg', 12),
	  (60, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/39e9606d-f70e-4436-9a1f-d0ca0c90d42f_hotel14.jpg', 12);
  
  
INSERT INTO hotel_hotel_amenity(hotel_id, hotel_amenity_id)
VALUES(1, 1),
	  (1, 2),
	  (1, 3),
	  (1, 4),
	  (1, 5),
	  (1, 6),
	  (1, 7),
	  (2, 6),
	  (2, 7),
	  (2, 8),
	  (2, 9),
	  (2, 10),
	  (2, 11),
	  (2, 12),
      (3, 1),
	  (3, 2),
	  (3, 3),
	  (3, 4),
	  (3, 5),
	  (3, 6),
	  (3, 7),
      (4, 6),
	  (4, 7),
	  (4, 8),
	  (4, 9),
	  (4, 10),
	  (4, 11),
	  (4, 12),
      (5, 1),
	  (5, 2),
	  (5, 3),
	  (5, 4),
	  (5, 5),
	  (5, 6),
	  (5, 7),
	  (6, 6),
	  (6, 7),
	  (6, 8),
	  (6, 9),
	  (6, 10),
	  (6, 11),
	  (6, 12);
      

INSERT INTO review(id, rating_total, `comment`, user_id, hotel_id)
VALUES(1, 8.2, 'Vị trí thuận lợi, bạn Mạnh và bạn Đào lễ tân cực kỳ nhiệt tình, thân thiện với khách hàng', 22, 1),
	  (2, 8.3, 'sạch sẽ, nhân viên và bác bảo vệ nhiệt tình', 23, 1),
	  (3, 8.7, 'Tốt, mình đã ở 2 tuần rồi, và chắc sẽ ở thêm 2 tuần nữa', 24, 1),
	  (4, 8.2, 'Cách bãi tắm 200m. Có nhiều tiệm và quán ăn lân cận. Nhân viên lịch sự. Giá phòng tốt, bao gồm ăn sáng ngon, nhưng ở trên 1 tuần thì ăn hơi ngán vì món ít thay đổi.', 25, 2),
	  (5, 8.5, 'Địa điểm gần bãi biển, tiện nghi, phòng sạch sẽ và mới, nhân viên nhiệt tình thân thiện', 26, 2),
	  (6, 8.6, 'Rất gần biển, có thể đi bộ được, 2 bác bảo vệ bảo vệ và lễ tân Uyên rất thân thiện', 27, 2),
	  (7, 9.2, 'Cái điều hoà phòng mình lắp giữa giường nên nó vào người hơi khó chịu. Lắp xuống phía đuôi giường thì hay hơn', 28, 3),
	  (8, 9.1, 'Phục vụ tốt , vị trí ngay trung tâm , giá hợp lí .', 29, 3),
	  (9, 8.2, 'Gần biển, tiện lợi bắt xe', 30, 3),
	  (10, 9.2, 'Gần biển. Phòng đủ tiện nghi, nhưng tối ngủ hơi ồn vì tiếng điều hoà và tủ lạnh', 31, 4),
      (11, 9.6, 'Ăn sáng ngon. View góc biển đẹp. Giá cả hợp lí. Nhân viên nhiệt tình. Nhất là bạn Khánh lễ tân đẹp trai - niềm nở, xách đồ cho bạn tới tận xe về.', 32, 4),
	  (12, 9.1, 'Nhân viên nhẹ nhàng, nhiệt tình. Chỗ nghỉ gần bờ biển. Giá cả phải chăng', 33, 4),
	  (13, 8.7, 'Gần biển, giá hợp lý với dịch vụ', 34, 5),
	  (14, 8.2, 'điều hoà hơi nóng, mùa này nhiệt độ hơi cao bên ngoài', 35, 5),
	  (15, 8.1, 'Địa điểm thuận tiện, nhân viên nhiệt tình và lễ phép.', 36, 5),
	  (16, 9.2, 'phòng ăn quá chật, bể bơi bẩn và quá nhỏ, các cửa kính không được vệ sinh', 37, 6),
	  (17, 9.3, 'Khách sạn gần biển nhưng giá cả lại rẻ, phòng rộng rãi thoáng mát.', 38, 6),
	  (18, 9.3, 'sạch sẽ , nhân viên nhiệt tình', 39, 6);	  
      
      
INSERT INTO `view`(id, `name`)
VALUES(1, 'Nhìn ra biển'),
      (2, 'Nhìn ra núi');


INSERT INTO bed_type(id, `name`, `description`)
VALUES(1, 'Giường đơn', 'Rộng 90 - 130 cm'),
      (2, 'Giường đôi', 'Rộng 131 - 150 cm'),
      (3, 'Giường lớn (cỡ King)', 'Rộng 151 - 180 cm'),
      (4, 'Giường cực lớn (cỡ Super-King)', 'Rộng 181 - 210 cm');
      
      
INSERT INTO room_amenity(id, `name`)
VALUES(1, 'Hồ bơi riêng'), 
      (2, 'Điều hòa không khí'), 
      (3, 'Tiện nghi BBQ'), 
      (4, 'Ban công'), 
      (5, 'Máy giặt'), 
      (6, 'Tủ lạnh'), 
      (7, 'Bồn tắm'),
      (8, 'Sân hiên'), 
      (9, 'TV màn hình phẳng'), 
      (10, 'Bể sục'), 
      (11, 'Khăn tắm'), 
      (12, 'Ra trải giường'), 
      (13, 'Máy rửa bát'), 
      (14, 'Lò nướng'),
      (15, 'Bàn cho laptop'),
      (16, 'Khu vực ăn uống ngoài trời'),
      (17, 'Bàn ghế ngoài trời'),
      (18, 'Có phòng thông nhau qua cửa nối'),
      (19, 'TV');


INSERT INTO room_type(id, `name`, count, price, bathroom_count, room_area, adult_count, children_count, `description`, hotel_id, view_id)
VALUES(1, 'Phòng VIP', 3, 500000.0, 1, 30, 2, 1, '', 1, 1),
      (2, 'Phòng VIPPRO', 4, 600000.0, 2, 40, 3, 1, '', 1, 2),
      (3, 'Phòng VIPVIPPRO', 5, 800000.0, 1, 30, 2, 2, '', 1, 1),
      (4, 'Phòng VIP', 3, 3000000.0, 1, 35, 3, 2, '', 2, 1),
      (5, 'Phòng VIPPRO', 4, 3500000.0, 1, 40, 2, 1, '', 2, 2),
      (6, 'Phòng VIPVIPPRO', 5, 3800000.0, 1, 30, 2, 1, '', 2, 2),
      (7, 'Phòng VIP', 3, 3000000.0, 2, 40, 1, 0, '', 3, 1),
      (8, 'Phòng VIPPRO', 4, 3300000.0, 2, 35, 2, 1, '', 3, 1),
	  (9, 'Phòng VIPVIPPRO', 5, 4000000.0, 1, 30, 2, 1, '', 3, 2),
      (10, 'Phòng VIP', 3, 5000000.0, 1, 50, 3, 1, '', 4, 1),
      (11, 'Phòng VIPPRO', 4, 10000000.0, 2, 60, 2, 0, '', 4, 1),
      (12, 'Phòng VIPVIPPRO', 5, 12000000.0, 1, 55, 2, 1, '', 4, 1);
      
      
INSERT INTO room_room_amenity(room_type_id, room_amenity_id)
VALUES(1, 1),
	  (1, 2),
	  (1, 3),
	  (1, 4),
	  (1, 5),
	  (2, 6),
	  (2, 7),
	  (2, 8),
	  (2, 9),
	  (2, 10),
	  (3, 11),
	  (3, 12),
      (3, 13),
	  (3, 14),
	  (3, 15),
	  (4, 16),
	  (4, 17),
	  (4, 18),
	  (4, 19);
      

INSERT INTO room_bed_type(room_type_id, bed_type_id, count)
VALUES(1, 1, 1),
      (2, 1, 2),
      (3, 2, 2),
      (4, 3, 3),
      (5, 1, 1),
      (6, 2, 1),
      (7, 3, 1),
      (8, 4, 2),
      (9, 1, 2),
      (10, 2, 3),
      (11, 3, 2),
      (12, 4, 1);


-- INSERT INTO invoice()
-- VALUES();
   
      
INSERT INTO hotel_hotel_amenity(hotel_id, hotel_amenity_id)
VALUES(7, 1),
	  (8, 2),
	  (9, 3),
	  (10, 4),
	  (11, 5),
	  (12, 6),
	  (9, 7),
	  (8, 6),
	  (7, 7),
	  (10, 8),
	  (11, 9),
	  (12, 10),
	  (12, 11);
INSERT INTO review(id, rating_total, `comment`, user_id, hotel_id)
VALUES(19, 7.0, 'Vị trí thuận lợi, bạn Mạnh và bạn Đào lễ tân cực kỳ nhiệt tình, thân thiện với khách hàng', 22, 7),
	  (20, 6.2, 'sạch sẽ, nhân viên và bác bảo vệ nhiệt tình', 23, 7),
	  (21, 8.7, 'Tốt, mình đã ở 2 tuần rồi, và chắc sẽ ở thêm 2 tuần nữa', 24, 9),
	  (22, 8.2, 'Cách bãi tắm 200m. Có nhiều tiệm và quán ăn lân cận. Nhân viên lịch sự. Giá phòng tốt, bao gồm ăn sáng ngon, nhưng ở trên 1 tuần thì ăn hơi ngán vì món ít thay đổi.', 25, 8),
	  (23, 7.0, 'Địa điểm gần bãi biển, tiện nghi, phòng sạch sẽ và mới, nhân viên nhiệt tình thân thiện', 26, 5),
	  (24, 7.0, 'Rất gần biển, có thể đi bộ được, 2 bác bảo vệ bảo vệ và lễ tân Uyên rất thân thiện', 27, 10),
	  (25, 9.2, 'Cái điều hoà phòng mình lắp giữa giường nên nó vào người hơi khó chịu. Lắp xuống phía đuôi giường thì hay hơn', 28, 12),
	  (26, 7.5, 'Phục vụ tốt , vị trí ngay trung tâm , giá hợp lí .', 29, 11),
	  (27, 8.2, 'Gần biển, tiện lợi bắt xe', 30, 8),
	  (28, 9.2, 'Gần biển. Phòng đủ tiện nghi, nhưng tối ngủ hơi ồn vì tiếng điều hoà và tủ lạnh', 31, 7),
      (29, 9.6, 'Ăn sáng ngon. View góc biển đẹp. Giá cả hợp lí. Nhân viên nhiệt tình. Nhất là bạn Khánh lễ tân đẹp trai - niềm nở, xách đồ cho bạn tới tận xe về.', 32, 9),
	  (30, 9.1, 'Nhân viên nhẹ nhàng, nhiệt tình. Chỗ nghỉ gần bờ biển. Giá cả phải chăng', 33, 10),
	  (31, 9.8, 'Gần biển, giá hợp lý với dịch vụ', 34, 12),
	  (32, 6.2, 'điều hoà hơi nóng, mùa này nhiệt độ hơi cao bên ngoài', 35, 11),
	  (33, 7.5, 'Địa điểm thuận tiện, nhân viên nhiệt tình và lễ phép.', 36, 7),
	  (34, 9.2, 'phòng ăn quá chật, bể bơi bẩn và quá nhỏ, các cửa kính không được vệ sinh', 37, 6),
	  (35, 9.8, 'Khách sạn gần biển nhưng giá cả lại rẻ, phòng rộng rãi thoáng mát.', 38, 5),
	  (36, 7.5, 'sạch sẽ , nhân viên nhiệt tình', 39, 8);	  
      
INSERT INTO room_type(id, `name`, count, price, bathroom_count, room_area, adult_count, children_count, `description`, hotel_id, view_id)
VALUES(13, 'Phòng đơn', 2, 4000000.0, 1, 30, 1, 1, '', 7, 1),
      (14, 'Phòng đôi', 2, 4000000.0, 2, 40, 2, 1, '', 7, 2),
      (15, 'Phòng suite', 2, 4000000.0, 1, 100, 5, 2, '', 7, 1),
      (16, 'Phòng đơn', 1, 4000000.0, 1, 35, 3, 2, '', 8, 1),
      (17, 'Phòng đôi', 2, 4000000.0, 1, 40, 2, 1, '', 8, 2),
      (18, 'Phòng suite', 2, 4000000.0, 1, 100, 2, 1, '',8, 2),
      (19, 'Phòng đơn', 10, 4000000.0, 2, 40, 1, 0, '', 9, 1),
      (20, 'Phòng đôi', 7, 4000000.0, 2, 60, 2, 1, '', 9, 1),
	  (21, 'Phòng suite', 5, 4000000.0, 1, 100, 2, 1, '', 9, 2),
      (22, 'Phòng đơn', 3, 4000000.0, 1, 50, 3, 1, '', 10, 1),
      (23, 'Phòng đôi', 4, 4000000.0, 2, 60, 2, 0, '', 10, 1),
      (24, 'Phòng suite', 5, 4000000.0, 1, 100, 2, 1, '', 10, 2),
      (25, 'Phòng đơn', 3,4000000.0, 1, 50, 3, 1, '', 11, 2),
      (26, 'Phòng đôi', 4, 4000000.0, 2, 60, 2, 0, '', 11, 1),
      (27, 'Phòng suite', 5, 4000000.0, 1, 100, 2, 1, '', 11, 1),
      (28, 'Phòng đơn', 3, 4000000.0, 1, 50, 3, 1, '', 12, 2),
      (29, 'Phòng đôi', 4, 4000000.0, 2, 60, 2, 0, '', 12, 1),
      (30, 'Phòng suite', 5, 4000000.0, 1, 88, 2, 1, '', 12, 1);
INSERT INTO room (room_type_id)
SELECT 
    rt.id
FROM 
    room_type rt
JOIN (
    SELECT 
        1 AS n
    UNION ALL SELECT 2
    UNION ALL SELECT 3
    UNION ALL SELECT 4
    UNION ALL SELECT 5
    UNION ALL SELECT 6
    UNION ALL SELECT 7
    UNION ALL SELECT 8
    UNION ALL SELECT 9
    UNION ALL SELECT 10
    UNION ALL SELECT 11
) numbers
ON numbers.n <= rt.count;
      
INSERT INTO reservation(id, created_at, email, `status`, user_id)
VALUES(1, NOW(), 'customer1@gmai.com', 'CONFIRMED', 22),
	  (2, NOW(), 'customer4@gmai.com', 'CONFIRMED', 25),
      (3, NOW(), 'customer7@gmai.com', 'CONFIRMED', 28),
      (4, NOW(), 'customer10@gmai.com', 'CONFIRMED', 31),
      (5, NOW(), 'customer14@gmai.com', 'CONFIRMED', 35),
      (6, NOW(), 'customer16@gmai.com', 'CONFIRMED', 37),
      (7, NOW(), 'customer18@gmai.com', 'CONFIRMED', 39);
      
INSERT INTO room_reserved(id, start_day, end_day, reservation_id, room_id)
VALUES(1, '2023-9-1', '2023-9-5', 1, 1),
	  (2, '2023-9-6', '2023-9-10', 2, 2),
	  (3, '2023-9-19', '2023-9-23', 3, 5),
      (4, '2023-10-1', '2023-10-22', 4, 6),
      (5, '2023-11-2', '2023-11-11', 5, 9),
	  (6, '2023-11-5', '2023-11-12', 6, 10),
      (7, '2023-11-7', '2023-11-16', 7, 12);


UPDATE hotel
SET rule = 'Không phù hợp cho trẻ vị thành niên, Không cho phép hút thuốc, Không cho phép các loại thú cưng, Hủy phòng trước 1 ngày sẽ không mất phí';
ALTER TABLE reservation
ADD COLUMN reservation_code VARCHAR(255);

UPDATE `booking-app`.`room` SET `name` = 'room_1' WHERE (`id` = '1');
UPDATE `booking-app`.`room` SET `name` = 'room_2' WHERE (`id` = '2');
UPDATE `booking-app`.`room` SET `name` = 'room_3' WHERE (`id` = '3');
UPDATE `booking-app`.`room` SET `name` = 'room_4535' WHERE (`id` = '4');
UPDATE `booking-app`.`room` SET `name` = 'room_vaf' WHERE (`id` = '5');
UPDATE `booking-app`.`room` SET `name` = 'room_134' WHERE (`id` = '6');
UPDATE `booking-app`.`room` SET `name` = 'room_334' WHERE (`id` = '7');
UPDATE `booking-app`.`room` SET `name` = 'room_1543' WHERE (`id` = '8');
UPDATE `booking-app`.`room` SET `name` = 'room_1233' WHERE (`id` = '9');
UPDATE `booking-app`.`room` SET `name` = 'room_134' WHERE (`id` = '10');
UPDATE `booking-app`.`room` SET `name` = 'room_16' WHERE (`id` = '11');
UPDATE `booking-app`.`room` SET `name` = 'room_16546' WHERE (`id` = '12');
UPDATE `booking-app`.`room` SET `name` = 'room_1234' WHERE (`id` = '13');
UPDATE `booking-app`.`room` SET `name` = 'room_167' WHERE (`id` = '14');
UPDATE `booking-app`.`room` SET `name` = 'room_145' WHERE (`id` = '15');
UPDATE `booking-app`.`room` SET `name` = 'room_165' WHERE (`id` = '16');
UPDATE `booking-app`.`room` SET `name` = 'room_1876' WHERE (`id` = '17');
UPDATE `booking-app`.`room` SET `name` = 'room_1' WHERE (`id` = '19');
UPDATE `booking-app`.`room` SET `name` = 'room_176' WHERE (`id` = '18');
UPDATE `booking-app`.`room` SET `name` = 'room_156' WHERE (`id` = '20');
UPDATE `booking-app`.`room` SET `name` = 'room_1546' WHERE (`id` = '21');
UPDATE `booking-app`.`room` SET `name` = 'room_1435' WHERE (`id` = '22');
UPDATE `booking-app`.`room` SET `name` = 'room_123' WHERE (`id` = '23');
UPDATE `booking-app`.`room` SET `name` = 'room_1677' WHERE (`id` = '24');
UPDATE `booking-app`.`room` SET `name` = 'room_168567' WHERE (`id` = '25');
UPDATE `booking-app`.`room` SET `name` = 'room_1123' WHERE (`id` = '26');
UPDATE `booking-app`.`room` SET `name` = 'room_19879' WHERE (`id` = '27');
UPDATE `booking-app`.`room` SET `name` = 'room_1786' WHERE (`id` = '28');
UPDATE `booking-app`.`room` SET `name` = 'room_13423' WHERE (`id` = '29');
UPDATE `booking-app`.`room` SET `name` = 'room_14563' WHERE (`id` = '30');
UPDATE `booking-app`.`room` SET `name` = 'room_134563' WHERE (`id` = '31');
UPDATE `booking-app`.`room` SET `name` = 'room_14523' WHERE (`id` = '32');
UPDATE `booking-app`.`room` SET `name` = 'room_143' WHERE (`id` = '33');
UPDATE `booking-app`.`room` SET `name` = 'room_1345' WHERE (`id` = '34');
UPDATE `booking-app`.`room` SET `name` = 'room_145' WHERE (`id` = '35');
UPDATE `booking-app`.`room` SET `name` = 'room_12345' WHERE (`id` = '36');
UPDATE `booking-app`.`room` SET `name` = 'room_12345' WHERE (`id` = '37');
UPDATE `booking-app`.`room` SET `name` = 'room_1345' WHERE (`id` = '38');
UPDATE `booking-app`.`room` SET `name` = 'room_1545' WHERE (`id` = '39');
UPDATE `booking-app`.`room` SET `name` = 'room_1342' WHERE (`id` = '40');
UPDATE `booking-app`.`room` SET `name` = 'room_1352' WHERE (`id` = '41');
UPDATE `booking-app`.`room` SET `name` = 'room_1325' WHERE (`id` = '42');
UPDATE `booking-app`.`room` SET `name` = 'room_1ds' WHERE (`id` = '46');
UPDATE `booking-app`.`room` SET `name` = 'gsdf' WHERE (`id` = '48');
UPDATE `booking-app`.`room` SET `name` = 'dfg' WHERE (`id` = '44');
UPDATE `booking-app`.`room` SET `name` = 'sgd' WHERE (`id` = '43');
UPDATE `booking-app`.`room` SET `name` = 'sdgf' WHERE (`id` = '45');
UPDATE `booking-app`.`room` SET `name` = 'asw' WHERE (`id` = '47');
UPDATE `booking-app`.`room` SET `name` = 'ass' WHERE (`id` = '49');
UPDATE `booking-app`.`room` SET `name` = 'dsa' WHERE (`id` = '51');
UPDATE `booking-app`.`room` SET `name` = 'asdf' WHERE (`id` = '50');
UPDATE `booking-app`.`room` SET `name` = 'sd' WHERE (`id` = '54');
UPDATE `booking-app`.`room` SET `name` = 'asdfd' WHERE (`id` = '52');
UPDATE `booking-app`.`room` SET `name` = 'dasd' WHERE (`id` = '53');
UPDATE `booking-app`.`room` SET `name` = 'ghhjnngh' WHERE (`id` = '55');
UPDATE `booking-app`.`room` SET `name` = 'fgff' WHERE (`id` = '57');
UPDATE `booking-app`.`room` SET `name` = 'ffff' WHERE (`id` = '56');
UPDATE `booking-app`.`room` SET `name` = 'ffff' WHERE (`id` = '60');
UPDATE `booking-app`.`room` SET `name` = 'ff' WHERE (`id` = '58');
UPDATE `booking-app`.`room` SET `name` = 'fffadgdf' WHERE (`id` = '59');
UPDATE `booking-app`.`room` SET `name` = 'fgsdfg' WHERE (`id` = '62');
UPDATE `booking-app`.`room` SET `name` = 'dfg123' WHERE (`id` = '61');
UPDATE `booking-app`.`room` SET `name` = '454535' WHERE (`id` = '63');
UPDATE `booking-app`.`room` SET `name` = '233423423' WHERE (`id` = '65');
UPDATE `booking-app`.`room` SET `name` = '12312312' WHERE (`id` = '64');
UPDATE `booking-app`.`room` SET `name` = '12353453' WHERE (`id` = '66');
UPDATE `booking-app`.`room` SET `name` = '11231231' WHERE (`id` = '68');
UPDATE `booking-app`.`room` SET `name` = '3123123' WHERE (`id` = '67');
UPDATE `booking-app`.`room` SET `name` = '1231231' WHERE (`id` = '70');
UPDATE `booking-app`.`room` SET `name` = '131231' WHERE (`id` = '69');
UPDATE `booking-app`.`room` SET `name` = '12312' WHERE (`id` = '74');
UPDATE `booking-app`.`room` SET `name` = '31312' WHERE (`id` = '71');
UPDATE `booking-app`.`room` SET `name` = '313213' WHERE (`id` = '73');
UPDATE `booking-app`.`room` SET `name` = '1312' WHERE (`id` = '72');


INSERT INTO room_image(id, image_path, room_id)
VALUES(1, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/e2b53b40-4edc-4119-bef5-e9258a899a31_room2.jpeg', 1),
	  (2, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/e2b53b40-4edc-4119-bef5-e9258a899a31_room2.jpeg', 1),
	  (3, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/d365f1c5-da4a-459c-b8a2-0375715152d5_room3.jpeg', 1),
	  (4, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/24f62033-aae6-4ec1-87d0-71183d813cb1_room4.jpeg', 1),
	  (5, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/b73b8c02-3004-4d7e-8f91-9c75732f0efc_room5.jpeg', 1),
	  (6, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/07089e77-3086-4d9f-827d-9d8f1546bdb3_room2.jpeg', 2),
	  (7, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/59c485b9-d613-4bc0-9148-a6e2251c48be_room1.jpeg', 2),
	  (8, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/f33f8bdb-d2b3-4ba2-bb48-e0c0e385fc5e_room3.jpeg', 2),
	  (9, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/55c072c6-7c58-4da9-b9b4-96c300b6a538_room4.jpeg', 2),
	  (10, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/8a5a4391-75e5-4a7b-9d2f-a4a755fe46db_room5.jpeg', 2),
	  (11, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/0bf3744f-0c11-4301-9c12-30b56439b22b_room3.jpeg', 3),
	  (12, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/5818e3f5-d0f7-46b6-b9e5-d3b0cd9d37db_room1.jpeg', 3),
	  (13, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/6341d988-213f-42eb-bf0f-9aa330820798_room3.jpeg', 3),
	  (14, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/e0496e23-674f-41ca-afaa-7900af13ac4c_room4.jpeg', 3),
	  (15, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/b830247c-c86a-48f7-9183-48c5a6aa4229_room5.jpeg', 3),
	  (16, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/8a497c4f-aa61-4c7d-b400-58b86fed1890_room4.jpeg', 4),
	  (17, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/26f67642-b7b7-41f8-bc13-0bf3474dc777_room1.jpeg', 4),
	  (18, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/68b3c787-5197-43e9-9664-12554ddc18f1_room3.jpeg', 4),
	  (19, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/2d816934-24e3-4c11-a7fb-1bf087268c04_room4.jpeg', 4),
	  (20, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/83c1f5ba-799b-4a79-9309-482af2ad900e_room5.jpeg', 4),
	  (21, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/69413df2-7e44-4c30-9c1b-526bde2d6de4_room5.jpeg', 5),
	  (22, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/e22042af-b1be-4602-ad7c-442a9bc0356b_room1.jpeg', 5),
	  (23, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/a307fcfb-e59f-4f78-a443-99c5be01654d_room3.jpeg', 5),
	  (24, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/7ca04479-496a-4ac6-a19c-4464a84b0bbc_room4.jpeg', 5),
	  (25, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/0cb1f777-d9fd-41fa-94d9-0fa282651e27_room5.jpeg', 5),
	  (26, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/e4512029-e19b-458a-a4cc-3c36a5c65724_room6.jpeg', 6),
	  (27, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/76fd8398-ddb4-4df2-9e89-bcb5015948b5_room1.jpeg', 6),
	  (28, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/c3b94570-0bd7-4c78-a80a-8093afa0335c_room3.jpeg', 6),
	  (29, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/f24e2f0d-cc36-42a2-947f-0f521a08e856_room4.jpeg', 6),
	  (30, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/ea98a2fd-b001-4d3b-8c04-9db92bd29723_room5.jpeg', 6),
	  (31, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/edd19013-7813-4043-9bef-66ec913136fb_room7.jpeg', 7),
	  (32, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/cd10092b-388e-4aaa-8e4e-813f0a9c941f_room1.jpeg', 7),
	  (33, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/856d4822-200c-4774-9021-18fc43936772_room3.jpeg', 7),
	  (34, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/97c0b531-3fba-4027-9ae4-2e97dd50278d_room4.jpeg', 7),
	  (35, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/c6b5d236-ac23-4b75-8e4d-3d850ba21e8d_room5.jpeg', 7),
	  (36, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/f50170c8-0e19-4a13-930c-385a98202f8b_room9.jpeg', 8),
	  (37, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/2a876e09-fa20-4d4b-b7ed-3c68c9f2789d_room1.jpeg', 8),
	  (38, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/b12200e9-06ec-4a33-a372-25ededdaafd0_room3.jpeg', 8),
	  (39, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/d680a78d-9f55-439f-94dd-df8e2df6edab_room4.jpeg', 8),
	  (40, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/8619e120-63b7-4dce-aad1-94c52c0fb9b4_room5.jpeg', 8),
	  (41, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/18b04f48-0248-422b-9074-08211e37fa9e_room9.jpeg', 9),
	  (42, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/2459f4aa-13d9-4554-b299-0d9317c5bf6d_room1.jpeg', 9),
	  (43, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/d1ec39b9-b202-4324-b6d8-6d998e94abb3_room3.jpeg', 9),
	  (44, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/68d68914-94af-4320-920e-841ab0c3441f_room4.jpeg', 9),
	  (45, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/dea856b2-be2c-4f45-a870-eb417d27151f_room5.jpeg', 9),
	  (46, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/f89fa236-afec-4d64-a36f-ea82a414acd6_room10.jpeg', 10),
	  (47, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/705463a3-d937-4e33-bb06-bc0b621e63fa_room1.jpeg', 10),
	  (48, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/f1a1b2e1-b959-4603-9323-f32e103a1735_room3.jpeg', 10),
	  (49, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/c8dad16c-e43b-4716-af66-c618589298e5_room4.jpeg', 10),
	  (50, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/bd9f0e39-76f1-4e3a-80d1-3a2d43d107cd_room5.jpeg', 10),
      (51, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/a52ae39e-5054-4e6b-8310-4426d55553f9_room11.jpeg', 11),
	  (52, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/483a9ee4-53a6-4a1b-95f1-ab739822e4e9_room1.jpeg', 11),
	  (53, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/f072e911-c2f8-4fb6-b7a2-e790870a068d_room3.jpeg', 11),
	  (54, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/68ad60ae-5c5a-49f5-a381-9bb10bed6127_room4.jpeg', 11),
	  (55, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/0d272a10-7025-480b-a34d-c7b4ad1c45a6_room5.jpeg', 11),
	  (56, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/59cd0079-f3c9-44cd-b77a-7a5c5467b255_room12.jpeg', 12),
	  (57, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/0d7897b5-02b8-4b78-9c71-911901d79a4a_room1.jpeg', 12),
	  (58, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/c12e85b4-421c-4989-8b33-44552dea3011_room3.jpeg', 12),
	  (59, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/14e3d14a-fe84-4dd7-8ced-1bbb93d2c978_room4.jpeg', 12),
	  (60, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/f124a6d1-870f-4c3a-b9d7-9c4472017c03_room5.jpeg', 12),
	  (61, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/97c50d3a-9d4d-4d3d-9225-dfc5587027da_room13.jpeg', 13),
	  (62, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/af28873e-8943-4cf8-aad2-a675021740dd_room1.jpeg', 13),
	  (63, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/c59dcfd7-1ddf-45a6-889f-bc549d94d4f2_room3.jpeg', 13),
	  (64, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/a11b0fa5-8759-4553-a15a-681245362b6c_room4.jpeg', 13),
	  (65, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/9726d73d-2825-4c54-8d38-7197926516d8_room5.jpeg', 13),
	  (66, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/584347af-36ed-4b5f-9697-31cd69dc8633_room14.jpeg', 14),
	  (67, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/3cd979e5-da73-401c-911d-d1f7fb0b7e35_room1.jpeg', 14),
	  (68, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/70b62341-33b1-4155-8875-5e3ca1821db0_room3.jpeg', 14),
	  (69, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/2c5f11bf-3660-4a35-8ad7-a10fa85c83da_room4.jpeg', 14),
	  (70, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/e2b28589-785d-4789-a6f0-868ddb243e57_room5.jpeg', 14),
	  (71, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/655fbd49-4f86-40a1-9c4a-d826a4ec30e6_room15.jpeg', 15),
	  (72, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/ef86b97c-e5b6-44cc-ae93-9ddb93d6e8d5_room1.jpeg', 15),
	  (73, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/44356fab-3b23-4fc1-b55c-de2153e9fb5f_room3.jpeg', 15),
	  (74, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/1ae63bac-610d-4e93-ad08-25da0876fddf_room4.jpeg', 15),
	  (75, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/b687971b-e169-4653-b11e-3437a0723099_room5.jpeg', 15),
	  (76, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/ee61ff41-1017-484e-a800-3fe9d6030118_room16.jpeg', 16),
	  (77, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/0d3c48b6-cf31-4274-801d-4227ae46d25f_room1.jpeg', 16),
	  (78, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/66636702-c6fb-4f95-9c31-a20d528e9162_room3.jpeg', 16),
	  (79, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/92e1a841-2dc6-44df-a78c-a499e3f620c3_room4.jpeg', 16),
	  (80, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/a7596b09-487d-424a-89d2-895b25d5eb47_room5.jpeg', 16),
	  (81, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/c72bb339-8d9d-4f5a-8313-847d4af9ac94_room17.jpeg', 17),
	  (82, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/a2809482-394d-43a3-abf9-38bc34fb44a4_room1.jpeg', 17),
	  (83, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/138e8455-5b2c-4387-bf55-cfd6aacb1f50_room3.jpeg', 17),
	  (84, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/0592f48b-be3f-4c07-8ee8-e7b5f309d76c_room4.jpeg', 17),
	  (85, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/cefe4250-dd11-422e-918d-ce9675c1820e_room5.jpeg', 17),
	  (86, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/418a04c6-eace-49ac-a9ae-52202541ec30_room18.jpeg', 18),
	  (87, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/78b6669d-265e-45e5-92cb-d31a4e9299ce_room1.jpeg', 18),
	  (88, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/01fe0263-fb95-4465-a263-568025f9607c_room3.jpeg', 18),
	  (89, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/ed57e00c-d643-4095-916c-46dfae5e9ee1_room4.jpeg', 18),
	  (90, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/a0ee2f3f-7d1a-4750-90d4-c5e9dffcf75b_room5.jpeg', 18),
	  (91, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/be0ee589-1200-4008-9048-57bc6795ff28_room1.jpeg', 19),
	  (92, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/1993fb78-0db7-4fb0-9e2b-f78fb3e2d53c_room2.jpeg', 19),
	  (93, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/c204dce4-9219-4c10-af2b-08c927456584_room3.jpeg', 19),
	  (94, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/5dfba53e-7d40-4c4a-80a2-98bb6c26edbf_room4.jpeg', 19),
	  (95, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/22f0af96-4ffb-41cf-93c5-54c2f4a99b56_room5.jpeg', 19),
	  (96, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/44502c9a-ae46-4589-b40d-15d49b2b3615_room3.jpeg', 20),
	  (97, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/7050af41-fcd9-47d2-99f1-cb3ad89f3325_room2.jpeg', 20),
	  (98, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/fce52233-b1f1-4e49-af26-23549a40f4ed_room3.jpeg', 20),
	  (99, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/fa1c85d5-08db-48fc-9b55-62da18f24cb8_room4.jpeg', 20),
	  (100, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/520decd4-bdd8-48d9-b6f7-71c87eeb99ae_room5.jpeg', 20),
      (101, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/b9e62552-d926-46d2-af29-e47116636690_room4.jpeg', 21),
	  (102, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/7b5013e6-9484-4796-a15b-2c4595dad754_room2.jpeg', 21),
	  (103, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/53c52dba-7927-49ec-b64f-b79c833b63cf_room3.jpeg', 21),
	  (104, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/8e359381-2306-4cfe-bc9b-2976f12dd6b0_room4.jpeg', 21),
	  (105, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/d1ff9739-997d-4549-b2b0-a26553e68d91_room5.jpeg', 21),
	  (106, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/4dc688ea-1159-4e87-a2f2-d267b89cfcdd_room5.jpeg', 22),
	  (107, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/4ae182dd-37ca-4ddc-935d-b57141a9c975_room2.jpeg', 22),
	  (108, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/50b74215-57fe-4df6-9bf4-5fa899c49be2_room3.jpeg', 22),
	  (109, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/c5dcb145-37b2-47c3-ac29-8fc7f7e56d3d_room4.jpeg', 22),
	  (110, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/6de5eec9-17c3-4637-816b-3574f37d2805_room5.jpeg', 22),
	  (111, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/5fb35b0c-c125-47c9-a9a8-611a229d42e5_room6.jpeg', 23),
	  (112, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/dbe35873-6187-415b-bcc6-bb10ba368a8d_room2.jpeg', 23),
	  (113, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/94c2c018-d6d4-4a52-880d-26efa5d92fa5_room3.jpeg', 23),
	  (114, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/8d467a2d-002d-4921-8c62-5d89abebe90a_room4.jpeg', 23),
	  (115, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/4d2888b6-a6ee-4a69-b791-ba8282d5f620_room5.jpeg', 23),
	  (116, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/b808628d-d17e-45c4-a397-549d6f046c3e_room7.jpeg', 24),
	  (117, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/a1aef678-a2a2-442a-b4d8-34ead7a783ed_room2.jpeg', 24),
	  (118, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/9013774d-62ae-4857-9cb5-bde30ca65fdf_room3.jpeg', 24),
	  (119, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/f3e4d9c1-df9e-4a56-ae5a-b3513b38bffb_room4.jpeg', 24),
	  (120, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/d64933bf-4995-4dbd-849e-3857a268c5b4_room5.jpeg', 24),
	  (121, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/409028f9-695d-4056-bd8b-c6a6c8488886_room8.jpeg', 25),
	  (122, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/59d90cbb-8d53-4f36-984e-8735659721f1_room2.jpeg', 25),
	  (123, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/074450b5-c2e0-4a09-87c1-2b323466303c_room3.jpeg', 25),
	  (124, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/d9c64c1d-b68e-4860-b8cb-e087b7131e9e_room4.jpeg', 25),
	  (125, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/a5d92bc4-cc8d-44eb-a4a4-ace7108bb62a_room5.jpeg', 25),
	  (126, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/b86b9025-0d3a-45cc-88b4-e850ef13007e_room9.jpeg', 26),
	  (127, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/8d605ff6-3a7e-4f1a-b55a-57f06ab08d1b_room2.jpeg', 26),
	  (128, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/5bb0f30b-04cc-494d-8941-e856d1746844_room3.jpeg', 26),
	  (129, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/e226f408-e128-4430-aae0-6b0d0c47e1a2_room4.jpeg', 26),
	  (130, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/bf7368ba-28ae-48cd-aa75-6592127540e9_room5.jpeg', 26),
	  (131, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/0a45b246-4f4d-43c5-a61b-1c33093b423f_room10.jpeg', 27),
	  (132, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/7545722f-a8e9-49cd-8bbe-e8d92def5bfa_room2.jpeg', 27),
	  (133, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/aafe24a5-0e74-4c26-b4da-3232f9b7a336_room3.jpeg', 27),
	  (134, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/d8b44282-9e5a-4126-9e2c-7baa947fb94d_room4.jpeg', 27),
	  (135, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/9c9ffca7-d23d-4f92-8be2-d65ae1d47075_room5.jpeg', 27),
	  (136, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/5ccd8613-24e9-4b4a-948d-be6e69e1c135_room12.jpeg', 28),
	  (137, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/77594221-da5e-4029-a5a6-539218d678e0_room2.jpeg', 28),
	  (138, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/c9acb65c-ad82-4a07-af70-692358f7606c_room3.jpeg', 28),
	  (139, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/9386e724-721b-4a26-a365-f0ce54eb905e_room4.jpeg', 28),
	  (140, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/9df4f654-a22e-4081-9df8-98a68b6eb577_room5.jpeg', 28),
	  (141, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/71fbcd05-5943-4785-b4c2-e05324963199_room18.jpeg', 29),
	  (142, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/275abd98-41fe-4955-b24e-a421874e31dc_room2.jpeg', 29),
	  (143, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/e1088408-a6e7-4690-8447-9e3391229bc4_room3.jpeg', 29),
	  (144, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/c4a384ea-6f32-427d-9fb7-3d8949196b0b_room4.jpeg', 29),
	  (145, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/0b28b83f-c8d2-459a-88f9-0c6f14df30af_room5.jpeg', 29),
	  (146, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/ee351b41-4bdc-422a-aac9-d8b7f76c244a_room12.jpeg', 30),
	  (147, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/6ebe2c7f-45b8-40e6-8f8e-3e35b06eeaac_room2.jpeg', 30),
	  (148, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/c096f9b0-7b22-4b7a-b61f-6ee7a6d8154f_room3.jpeg', 30),
	  (149, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/47b127ac-ed9f-4c4e-bca3-c5c7c70f4433_room4.jpeg', 30),
	  (150, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/ac39ef0c-a25e-4199-a715-805f985b0783_room5.jpeg', 30);

ALTER TABLE user
ADD COLUMN is_deleted TINYINT(1) NOT NULL DEFAULT 0;



      



      



      
      
      
      


