package com.pbl6.hotelbookingapp.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomAvailableResponse {
    private String roomName;
    @JsonSerialize(using = DecimalJsonSerializer.class)
    private Double price;
    private Long count;
}
