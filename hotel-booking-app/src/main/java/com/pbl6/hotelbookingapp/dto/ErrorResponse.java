package com.pbl6.hotelbookingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class ErrorResponse {
    private String error;

    public ErrorResponse(String message) {
        this.error = message;
    }


}

