// EventMergeRecordServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventMergeRecordServiceImpl implements EventMergeRecordService {

    @Autowired
    private EventMergeRecordRepository repository;

    @Override
    public EventMergeRecord create(EventMergeRecord record) { return repository.save(record); }

    @Override
    public EventMergeRecord update(Long id, EventMergeRecord record) {
        record.setId(id);
        return repository.save(record);
    }

    @Override
    public EventMergeRecord getById(Long id) { return repository.findById(id).orElse(null); }

    @Override
    public List<EventMergeRecord> getAll() { return repository.findAll(); }

    @Override
    public void delete(Long id) { repository.deleteById(id); }
}
