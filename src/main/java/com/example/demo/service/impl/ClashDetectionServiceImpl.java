package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ClashRecord;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashRecordService;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService{

    private final ClashRecordRepository repository;

    public ClashRecordServiceImpl(ClashRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClashRecord save(ClashRecord clash) {
        return repository.save(clash);
    }

    @Override
    public List<ClashRecord> getAll() {
        return repository.findAll();
    }
}
