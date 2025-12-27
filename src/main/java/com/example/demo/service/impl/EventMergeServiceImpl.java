/*package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final AcademicEventRepository eventRepo;
    private final EventMergeRecordRepository mergeRepo;

    public EventMergeServiceImpl(AcademicEventRepository eventRepo,
                                 EventMergeRecordRepository mergeRepo) {
        this.eventRepo = eventRepo;
        this.mergeRepo = mergeRepo;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {

        List<AcademicEvent> events = eventRepo.findAllById(eventIds);

        String ids = eventIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        EventMergeRecord record = new EventMergeRecord(
                null,
                ids,
                "Merged Event",
                events.get(0).getStartDate(),
                events.get(0).getEndDate(),
                reason,
                null
        );

        return mergeRepo.save(record);
    }
}
*/
/*
package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final AcademicEventRepository eventRepo;
    private final EventMergeRecordRepository mergeRepo;

    public EventMergeServiceImpl(AcademicEventRepository eventRepo,
                                 EventMergeRecordRepository mergeRepo) {
        this.eventRepo = eventRepo;
        this.mergeRepo = mergeRepo;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {
        List<AcademicEvent> events = eventRepo.findAllById(eventIds);

        String ids = eventIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        EventMergeRecord record = new EventMergeRecord();
        record.setSourceEventIds(ids);
        record.setMergedTitle("Merged Event");
        record.setMergedStartDate(events.get(0).getStartDate());
        record.setMergedEndDate(events.get(0).getEndDate());
        record.setMergeReason(reason);
        record.setCreatedAt(LocalDateTime.now());

        return mergeRepo.save(record);
    }
}
*/
/*package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final AcademicEventRepository eventRepo;
    private final EventMergeRecordRepository mergeRepo;

    public EventMergeServiceImpl(AcademicEventRepository eventRepo,
                                 EventMergeRecordRepository mergeRepo) {
        this.eventRepo = eventRepo;
        this.mergeRepo = mergeRepo;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {

        List<AcademicEvent> events = eventRepo.findAllById(eventIds);

        String ids = eventIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        EventMergeRecord record = new EventMergeRecord(
                null,
                ids,
                "Merged Event",
                events.get(0).getStartDate(),
                events.get(0).getEndDate(),
                reason,
                null
        );

        return mergeRepo.save(record);
    }
}
*/
package com.example.demo.service.impl;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventMergeServiceImpl implements EventMergeService {
    
    private final EventMergeRecordRepository eventMergeRecordRepository;
    private final AcademicEventRepository academicEventRepository;
    
    public EventMergeServiceImpl(EventMergeRecordRepository eventMergeRecordRepository, 
                                AcademicEventRepository academicEventRepository) {
        this.eventMergeRecordRepository = eventMergeRecordRepository;
        this.academicEventRepository = academicEventRepository;
    }
    
    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {
        for (Long eventId : eventIds) {
            if (!academicEventRepository.existsById(eventId)) {
                throw new ResourceNotFoundException("Event not found with id: " + eventId);
            }
        }
        
        String sourceEventIds = eventIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        
        EventMergeRecord mergeRecord = new EventMergeRecord();
        mergeRecord.setSourceEventIds(sourceEventIds);
        mergeRecord.setMergeReason(reason);
        
        return eventMergeRecordRepository.save(mergeRecord);
    }
    
    @Override
    public List<EventMergeRecord> getAllMergeRecords() {
        return eventMergeRecordRepository.findAll();
    }
    
    @Override
    public EventMergeRecord getMergeRecordById(Long id) {
        return eventMergeRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Merge record not found with id: " + id));
    }
    
    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        // CORRECT: Matches the method name in your EventMergeRecordRepository
        return eventMergeRecordRepository.findByMergedStartDateBetween(start, end);
    }
}