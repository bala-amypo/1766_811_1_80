package com.example.demo.service;

import com.example.demo.entity.EventMergeRecord;

import java.time.LocalDate;
import java.util.List;

public interface EventMergeService {

    EventMergeRecord save(EventMergeRecord record);

    EventMergeRecord getById(Long id);

    List<EventMergeRecord> getAll();

    List<EventMergeRecord> getByDateRange(LocalDate startDate, LocalDate endDate);
}
