package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.EventMergeRecord;

public interface EventMergeService {
    EventMergeRecord save(EventMergeRecord record);
    List<EventMergeRecord> getAll();
}
