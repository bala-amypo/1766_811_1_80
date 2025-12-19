package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordRepository repository;

    public ClashDetectionServiceImpl(ClashRecordRepository repository) {
        this.repository = repository;
    }

    public ClashRecord save(ClashRecord clash) {
        return repository.save(clash);
    }

    public List<ClashRecord> getAll() {
        return repository.findAll();
    }

    public ClashRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
