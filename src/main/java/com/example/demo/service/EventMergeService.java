package com.example.demo.service;

import com.example.demo.entity.EventMergeRecord;
import java.util.List;

public interface EventMergeService {

    EventMergeRecord create(EventMergeRecord record);

    EventMergeRecord update(Long id, EventMergeRecord record);

    EventMergeRecord getById(Long id);

    List<EventMergeRecord> getAll();

    void delete(Long id);
}
