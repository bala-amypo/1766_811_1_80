// AcademicEventServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    @Autowired
    private AcademicEventRepository repository;

    @Override
    public AcademicEvent create(AcademicEvent event) { return repository.save(event); }

    @Override
    public AcademicEvent update(Long id, AcademicEvent event) {
        event.setId(id);
        return repository.save(event);
    }

    @Override
    public AcademicEvent getById(Long id) { return repository.findById(id).orElse(null); }

    @Override
    public List<AcademicEvent> getAll() { return repository.findAll(); }

    @Override
    public void delete(Long id) { repository.deleteById(id); }
}
