package com.pbl6.hotelbookingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomSearchResult {
    private List<HotelFilterSearchResult> hotels;
    private Long totalItems;
    private String location;
    private int pageIndex;
    private int pageSize;
    private int pageTotal;

}
