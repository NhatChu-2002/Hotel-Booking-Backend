package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.entity.View;
import com.pbl6.hotelbookingapp.repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ViewServiceImpl implements ViewService {
    private final ViewRepository viewRepository;

    @Autowired
    public ViewServiceImpl(ViewRepository viewRepository) {
        this.viewRepository = viewRepository;
    }

    @Override
    public List<View> getAllViews() {
        return viewRepository.findAll();
    }

    @Override
    public Optional<View> getViewById(Integer id) {
        return viewRepository.findById(id);
    }

    @Override
    public View createOrUpdateView(View view) {
        return viewRepository.save(view);
    }

    @Override
    public void deleteViewById(Integer id) {
        viewRepository.deleteById(id);
    }

    @Override
    public Page<View> findViewsByNameContaining(String name, Pageable pageable) {
        return viewRepository.findByNameContaining(name, pageable);
    }
}
