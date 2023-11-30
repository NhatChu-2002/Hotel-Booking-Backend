package com.pbl6.hotelbookingapp.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
public class RoomReservedInfoByTime {
    private String userName;
    private Integer userCount;
    private LocalDate checkInDay;
    private LocalDate checkOutDay;
    private String roomName;
    private LocalDateTime reserveTime;
    @JsonSerialize(using = DecimalJsonSerializer.class)
    private Double price;
    @JsonSerialize(using = DecimalJsonSerializer.class)
    private Double commission;
    private Integer reservedId;

    public RoomReservedInfoByTime(String userName, Integer userCount, LocalDate checkInDay, LocalDate checkOutDay, String roomName, LocalDateTime reserveTime, Double price, Double commission, Integer reservedId) {
        this.userName = userName;
        this.userCount = userCount;
        this.checkInDay = checkInDay;
        this.checkOutDay = checkOutDay;
        this.roomName = roomName;
        this.reserveTime = reserveTime;
        this.price = price;
        this.commission =  commission;
        this.reservedId = reservedId;
    }
}

