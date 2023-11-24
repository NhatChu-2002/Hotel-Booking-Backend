package com.pbl6.hotelbookingapp.dto;

import com.pbl6.hotelbookingapp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserListResponse {
    List<User> users;
    Long totalItems;
    Long totalPages;
}
