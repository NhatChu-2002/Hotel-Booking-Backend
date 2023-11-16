USE `booking-app` ;
INSERT INTO `user`(id, email, `password`, `role`)
VALUES(1, 'admin@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'ADMIN'), 
	  (2, 'host1@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (3, 'host2@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (4, 'host3@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (5, 'host4@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (6, 'host5@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (7, 'host6@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (8, 'host7@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (9, 'host8@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (10, 'host9@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (11, 'host10@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (12, 'host11@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (13, 'host12@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (14, 'host13@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (15, 'host14@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (16, 'host15@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (17, 'host16@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (18, 'host17@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (19, 'host18@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (20, 'host19@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (21, 'host20@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'HOST'), 
      (22, 'customer1@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (23, 'customer2@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (24, 'customer3@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (25, 'customer4@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (26, 'customer5@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (27, 'customer6@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (28, 'custome7@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (29, 'customer8@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (30, 'customer9@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (31, 'customer10@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (32, 'customer11@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (33, 'customer12@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (34, 'customer13@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (35, 'customer14@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (36, 'customer15@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (37, 'customer16@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (38, 'customer17@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
	  (39, 'customer18@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (40, 'customer19@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (41, 'customer20@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (42, 'customer21@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (43, 'customer22@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (44, 'customer23@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (45, 'customer24@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (46, 'customer25@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (47, 'customer26@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (48, 'custome27@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (49, 'customer228@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (50, 'customer29@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (51, 'customer30@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (52, 'customer31@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (53, 'customer32@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (54, 'customer33@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (55, 'customer34@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (56, 'customer35@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (57, 'customer36@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (58, 'customer37@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
	  (59, 'customer38@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (60, 'customer39@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (61, 'customer40@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (62, 'custome41@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (63, 'customer42@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (64, 'customer43@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (65, 'customer44@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (66, 'customer45@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (67, 'customer46@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (68, 'customer47@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
	  (69, 'customer48@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (70, 'customer49@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (71, 'customer50@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (72, 'customer51@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (73, 'customer52@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (74, 'customer53@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (75, 'customer54@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (76, 'customer55@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (77, 'customer56@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (78, 'customer57@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
	  (79, 'customer58@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (80, 'customer59@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER'), 
      (81, 'customer60@gmai.com', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 'CUSTOMER');
      

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
VALUES(1, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/cf2ef2e4-0f0a-4d8a-802d-4ce28a65ebdc_download (1).jpeg', 1),
 	  (2, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/fc90fc9f-8ca1-4ec5-aa67-565449203a5a_download (2).jpeg', 1),
	  (3, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/4e15a6be-a7d3-425b-8722-c03a4087569e_download (3).jpeg', 1),
      (4, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/cf2ef2e4-0f0a-4d8a-802d-4ce28a65ebdc_download (1).jpeg', 2),
 	  (5, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/fc90fc9f-8ca1-4ec5-aa67-565449203a5a_download (2).jpeg', 2),
	  (6, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/4e15a6be-a7d3-425b-8722-c03a4087569e_download (3).jpeg', 2),
      (7, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/cf2ef2e4-0f0a-4d8a-802d-4ce28a65ebdc_download (1).jpeg', 3),
 	  (8, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/fc90fc9f-8ca1-4ec5-aa67-565449203a5a_download (2).jpeg', 3),
	  (9, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/4e15a6be-a7d3-425b-8722-c03a4087569e_download (3).jpeg', 3),
      (10, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/cf2ef2e4-0f0a-4d8a-802d-4ce28a65ebdc_download (1).jpeg', 4),
 	  (11, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/fc90fc9f-8ca1-4ec5-aa67-565449203a5a_download (2).jpeg', 4),
	  (12, 'https://storage.googleapis.com/hotel-booking-cb28a.appspot.com/images/4e15a6be-a7d3-425b-8722-c03a4087569e_download (3).jpeg', 4);



      
  
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
VALUES(1, 'Phòng VIP', 3, 666.666, 1, 30, 2, 1, '', 1, 1),
      (2, 'Phòng VIPPRO', 4, 777.666, 2, 40, 3, 1, '', 1, 2),
      (3, 'Phòng VIPVIPPRO', 5, 888.666, 1, 30, 2, 2, '', 1, 1),
      (4, 'Phòng VIP', 3, 999.666, 1, 35, 3, 2, '', 2, 1),
      (5, 'Phòng VIPPRO', 4, 666.777, 1, 40, 2, 1, '', 2, 2),
      (6, 'Phòng VIPVIPPRO', 5, 777.777, 1, 30, 2, 1, '', 2, 2),
      (7, 'Phòng VIP', 3, 888.777, 2, 40, 1, 0, '', 3, 1),
      (8, 'Phòng VIPPRO', 4, 999.777, 2, 35, 2, 1, '', 3, 1),
	  (9, 'Phòng VIPVIPPRO', 5, 777.777, 1, 30, 2, 1, '', 3, 2),
      (10, 'Phòng VIP', 3, 888.777, 1, 50, 3, 1, '', 4, 1),
      (11, 'Phòng VIPPRO', 4, 999.777, 2, 60, 2, 0, '', 4, 1),
      (12, 'Phòng VIPVIPPRO', 5, 666.666, 1, 55, 2, 1, '', 4, 1);

      
      
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



INSERT INTO payment_type(id, payment_type_name)
VALUES(1, 'Thẻ tín dụng');


-- INSERT INTO invoice()
-- VALUES();
   
-- INSERT INTO hotel_image(id, image_path, hotel_id)
-- VALUES(19, 'hotel7-image1', 7),
-- 	  (20, 'hotel8-image2', 8),
--       (21, 'hotel9-image3', 9),
--       (22, 'hotel10-image1', 10),
-- 	  (23, 'hotel11-image2', 11),
--       (24, 'hotel11-image3', 11);
      
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
VALUES(13, 'Phòng đơn', 2, 300.000, 1, 30, 1, 1, '', 7, 1),
      (14, 'Phòng đôi', 2, 500.000, 2, 40, 2, 1, '', 7, 2),
      (15, 'Phòng suite', 2, 900.000, 1, 100, 5, 2, '', 7, 1),
      (16, 'Phòng đơn', 1, 400.000, 1, 35, 3, 2, '', 8, 1),
      (17, 'Phòng đôi', 2, 566.777, 1, 40, 2, 1, '', 8, 2),
      (18, 'Phòng suite', 2, 677.777, 1, 100, 2, 1, '',8, 2),
      (19, 'Phòng đơn', 10, 678.777, 2, 40, 1, 0, '', 9, 1),
      (20, 'Phòng đôi', 7, 900.777, 2, 60, 2, 1, '', 9, 1),
	  (21, 'Phòng suite', 5, 1000.777, 1, 100, 2, 1, '', 9, 2),
      (22, 'Phòng đơn', 3, 888.777, 1, 50, 3, 1, '', 10, 1),
      (23, 'Phòng đôi', 4, 999.777, 2, 60, 2, 0, '', 10, 1),
      (24, 'Phòng suite', 5, 1500.666, 1, 100, 2, 1, '', 10, 2),
      (25, 'Phòng đơn', 3, 888.777, 1, 50, 3, 1, '', 11, 2),
      (26, 'Phòng đôi', 4, 999.777, 2, 60, 2, 0, '', 11, 1),
      (27, 'Phòng suite', 5, 1500.666, 1, 100, 2, 1, '', 11, 1),
      (28, 'Phòng đơn', 3, 888.777, 1, 50, 3, 1, '', 12, 2),
      (29, 'Phòng đôi', 4, 999.777, 2, 60, 2, 0, '', 12, 1),
      (30, 'Phòng suite', 5, 1500.666, 1, 88, 2, 1, '', 12, 1);
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
      
INSERT INTO reservation(id, email, `status`, user_id)
VALUES(1, 'customer1@gmai.com', 'CONFIRMED', 22),
	  (2, 'customer4@gmai.com', 'CONFIRMED', 25),
      (3, 'customer7@gmai.com', 'CONFIRMED', 28),
      (4, 'customer10@gmai.com', 'CONFIRMED', 31);
      
INSERT INTO room_reserved(id, start_day, end_day, reservation_id, room_id)
VALUES(1, '2023-9-1', '2023-9-5', 1, 4),
	  (2, '2023-9-6', '2023-9-10', 2, 5),
	  (3, '2023-9-19', '2023-9-23', 3, 6),
      (4, '2023-10-1', '2023-10-22', 4, 7);

UPDATE hotel
SET rule = 'Không phù hợp cho trẻ vị thành niên, Không cho phép hút thuốc, Không cho phép các loại thú cưng, Hủy phòng trước 1 ngày sẽ không mất phí';
ALTER TABLE reservation
ADD COLUMN reservation_code VARCHAR(255);




      



      



      
      
      
      


