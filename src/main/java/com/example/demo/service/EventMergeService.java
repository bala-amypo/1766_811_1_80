package com.example.demo.service;

import com.example.demo.entity.EventMergeRecord;
import java.util.List;

public interface EventMergeService {
    EventMergeRecord save(EventMergeRecord record);
    List<EventMergeRecord> getAll();
    EventMergeRecord getById(Long id);
}
