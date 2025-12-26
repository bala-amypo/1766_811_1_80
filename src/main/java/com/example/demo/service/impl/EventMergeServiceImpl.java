package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRecordRepository mergeRepository;
    private final AcademicEventRepository eventRepository;

    public EventMergeServiceImpl(EventMergeRecordRepository mergeRepository,
                                 AcademicEventRepository eventRepository) {
        this.mergeRepository = mergeRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {
        List<AcademicEvent> events = eventIds.stream()
                .map(id -> eventRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Event not found")))
                .toList();

        EventMergeRecord record = new EventMergeRecord();
        record.setSourceEventIds(
                eventIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
        record.setMergeTitle("Merged Events");
        record.setMergeReason(reason);
        record.setMergeStartDate(
                events.stream().map(AcademicEvent::getStartDate).min(LocalDate::compareTo).get());
        record.setMergeEndDate(
                events.stream().map(AcademicEvent::getEndDate).max(LocalDate::compareTo).get());

        return mergeRepository.save(record);
    }

    @Override
    public List<EventMergeRecord> getAllMergeRecords() {
        return mergeRepository.findAll();
    }

    @Override
    public EventMergeRecord getMergeRecordById(Long id) {
        return mergeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Merge record not found"));
    }

    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        return mergeRepository.findByMergeStartDateBetween(start, end);
    }
}
