package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository repository;

    public AcademicEventServiceImpl(AcademicEventRepository repository) {
        this.repository = repository;
    }

    public AcademicEvent save(AcademicEvent event) {
        return repository.save(event);
    }

    public List<AcademicEvent> getAll() {
        return repository.findAll();
    }

    public AcademicEvent getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
