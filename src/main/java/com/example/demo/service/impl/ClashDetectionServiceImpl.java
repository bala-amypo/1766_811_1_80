package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashDetectionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordRepository repository;

    public ClashDetectionServiceImpl(ClashRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClashRecord> getClashesForEvent(Long eventId) {
        // Fetch clashes where event appears as either A or B
        return repository.findByEventAIdOrEventBId(eventId, eventId);
    }

    @Override
    public ClashRecord saveClash(Long eventAId,
                                 Long eventBId,
                                 String clashType,
                                 String severity,
                                 String details) {

        ClashRecord record = new ClashRecord();
        record.setEventAId(eventAId);
        record.setEventBId(eventBId);
        record.setClashType(clashType);
        record.setSeverity(severity);
        record.setDetails(details);
        record.setResolved(false);
        record.setDetectedAt(LocalDateTime.now());

        return repository.save(record);
    }

    @Override
    public ClashRecord markResolved(Long clashId) {
        ClashRecord record = repository.findById(clashId)
                .orElseThrow(() -> new RuntimeException("Clash not found"));

        record.setResolved(true);
        return repository.save(record);
    }
}
