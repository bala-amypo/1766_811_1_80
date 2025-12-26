package com.example.demo.service.impl;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    @Autowired
    private EventMergeRepository mergeRepository;

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {
        EventMergeRecord record = new EventMergeRecord();
        record.setEventIds(eventIds);
        record.setReason(reason);
        return mergeRepository.save(record);
    }

    @Override
    public EventMergeRecord getMergeRecordById(Long id) {
        return mergeRepository.findById(id).orElse(null);
    }

    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        return mergeRepository.findByDateBetween(start, end);
    }
}
