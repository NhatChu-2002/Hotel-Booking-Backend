package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.entity.View;
import com.pbl6.hotelbookingapp.repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ViewService {
    private final ViewRepository viewRepository;

    @Autowired
    public ViewService(ViewRepository viewRepository) {
        this.viewRepository = viewRepository;
    }

    public List<View> getAllViews() {
        return viewRepository.findAll();
    }

    public Optional<View> getViewById(Integer id) {
        return viewRepository.findById(id);
    }

    public View createOrUpdateView(View view) {
        return viewRepository.save(view);
    }

    public void deleteViewById(Integer id) {
        viewRepository.deleteById(id);
    }

    public List<View> findByNameContaining(String name) {
        return viewRepository.findByNameContaining(name);
    }
}
