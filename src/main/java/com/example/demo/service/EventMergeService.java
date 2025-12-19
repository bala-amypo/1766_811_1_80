package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EventMergeRecord;

public interface EventMergeRecordService {
    EventMergeRecord save(EventMergeRecord record);
    List<EventMergeRecord> getAll();
}
