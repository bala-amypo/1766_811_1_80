package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeRecordService;

@Service
public class EventMergeRecordServiceImpl implements EventMergeRecordService {

    private final EventMergeRecordRepository repository;

    public EventMergeRecordServiceImpl(EventMergeRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public EventMergeRecord save(EventMergeRecord record) {
        return repository.save(record);
    }

    @Override
    public List<EventMergeRecord> getAll() {
        return repository.findAll();
    }
}
