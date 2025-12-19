package com.example.demo.service.impl;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRecordRepository repository;

    public EventMergeServiceImpl(EventMergeRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {
        EventMergeRecord record = new EventMergeRecord();
        record.setSourceEventIds(eventIds.toString());
        record.setMergeReason(reason);
        record.setMergedTitle("Merged Events");

        return repository.save(record);
    }

    @Override
    public List<EventMergeRecord> getAllMergeRecords() {
        return repository.findAll();
    }

    @Override
    public EventMergeRecord getMergeRecordById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        return repository.findByCreatedAtBetween(
                start.atStartOfDay(),
                end.atTime(23, 59, 59)
        );
    }
}
