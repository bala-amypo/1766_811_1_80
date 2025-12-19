package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeRecordService;

@RestController
@RequestMapping("/api/merge-records")
public class EventMergeRecordController {

    private final EventMergeRecordService eventMergeRecordService;

    public EventMergeRecordController(EventMergeRecordService eventMergeRecordService) {
        this.eventMergeRecordService = eventMergeRecordService;
    }

    @PostMapping
    public EventMergeRecord createMergeRecord(@Valid @RequestBody EventMergeRecord record) {
        return eventMergeRecordService.save(record);
    }

    @GetMapping
    public List<EventMergeRecord> getAllMergeRecords() {
        return eventMergeRecordService.getAll();
    }
}
