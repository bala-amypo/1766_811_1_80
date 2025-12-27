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

        if (eventIds == null || eventIds.isEmpty()) {
            throw new IllegalArgumentException("Event IDs required");
        }

        List<AcademicEvent> events = eventRepo.findAllById(eventIds);

        if (events.isEmpty()) {
            throw new IllegalArgumentException("No events found");
        }

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
