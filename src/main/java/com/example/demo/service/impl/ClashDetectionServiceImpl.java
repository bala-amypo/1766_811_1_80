package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.entity.AcademicEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.ClashRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClashDetectionServiceImpl {

    private final AcademicEventRepository academicEventRepository;
    private final ClashRecordRepository clashRecordRepository;

    public ClashDetectionServiceImpl(AcademicEventRepository academicEventRepository,
                                     ClashRecordRepository clashRecordRepository) {
        this.academicEventRepository = academicEventRepository;
        this.clashRecordRepository = clashRecordRepository;
    }

    // Fetch all clashes related to a specific event
    public List<ClashRecord> getClashesForEvent(Long eventId) {
        return clashRecordRepository.findByEventAIdOrEventBId(eventId, eventId);
    }

    // Fetch unresolved clashes
    public List<ClashRecord> getUnresolvedClashes() {
        return clashRecordRepository.findByResolvedFalse();
    }

    // Resolve a specific clash by ID
    public ClashRecord resolveClash(Long id) {
        ClashRecord clash = clashRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clash not found"));
        clash.setResolved(true);
        clash.setDetectedAt(LocalDateTime.now());
        return clashRecordRepository.save(clash);
    }

    // Optional: Detect clashes between all events (simplified)
    public List<ClashRecord> detectClashes() {
        List<AcademicEvent> events = academicEventRepository.findAll();
        // naive O(n^2) comparison
        return events.stream()
                .flatMap(e1 -> events.stream()
                        .filter(e2 -> !e1.getId().equals(e2.getId()))
                        .filter(e2 -> datesOverlap(e1, e2))
                        .map(e2 -> createClashRecord(e1, e2)))
                .distinct()
                .collect(Collectors.toList());
    }

    private boolean datesOverlap(AcademicEvent e1, AcademicEvent e2) {
        return !e1.getEndDate().isBefore(e2.getStartDate()) &&
               !e1.getStartDate().isAfter(e2.getEndDate());
    }

    private ClashRecord createClashRecord(AcademicEvent e1, AcademicEvent e2) {
        ClashRecord record = new ClashRecord();
        record.setEventAId(e1.getId());
        record.setEventBId(e2.getId());
        record.setClashType("DATE_OVERLAP");
        record.setSeverity("MEDIUM");
        record.setResolved(false);
        record.setDetectedAt(LocalDateTime.now());
        return record;
    }
}
