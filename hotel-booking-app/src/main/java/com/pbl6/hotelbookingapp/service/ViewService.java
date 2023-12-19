package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.entity.View;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ViewService {
    List<View> getAllViews();

    Optional<View> getViewById(Integer id);

    View createOrUpdateView(View view);

    void deleteViewById(Integer id);

    Page<View> findViewsByNameContaining(String name, Pageable pageable);
}
