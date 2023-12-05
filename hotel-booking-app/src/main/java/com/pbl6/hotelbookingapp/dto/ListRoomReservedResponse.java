package com.pbl6.hotelbookingapp.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListRoomReservedResponse {
    private List<RoomReservedInfoByTime> roomReservedInfoByTime;
    @JsonSerialize(using = DecimalJsonSerializer.class)
    private Double totalPrice;
    @JsonSerialize(using = DecimalJsonSerializer.class)
    private Double totalCommission;
}
