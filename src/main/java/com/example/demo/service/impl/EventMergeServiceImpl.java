package com.example.demo.service.impl;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRecordRepository repository;

    public EventMergeServiceImpl(EventMergeRecordRepository repository) {
        this.repository = repository;
    }

    public EventMergeRecord save(EventMergeRecord record) {
        return repository.save(record);
    }

    public List<EventMergeRecord> getAll() {
        return repository.findAll();
    }

    public EventMergeRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
