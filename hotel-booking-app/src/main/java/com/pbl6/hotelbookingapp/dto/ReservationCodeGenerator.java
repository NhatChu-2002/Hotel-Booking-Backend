package com.pbl6.hotelbookingapp.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservationCodeGenerator {


        public static String generateReservationCode() {
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            return "RES-" + currentTime.format(formatter);
        }

}

