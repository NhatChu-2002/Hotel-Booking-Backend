package com.pbl6.hotelbookingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomTypesResponse {
    private String name;
    private List<String> roomName;
    private int childrenCount;
    private int adultCount;
    private int nightCount;
    private int count;

}
