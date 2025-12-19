package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;

@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    private final EventMergeService eventMergeService;

    public EventMergeController(EventMergeService eventMergeService) {
        this.eventMergeService = eventMergeService;
    }

    @PostMapping
    public EventMergeRecord createMergeRecord(
            @Valid @RequestBody EventMergeRecord record) {
        return eventMergeService.save(record);
    }

    @GetMapping
    public List<EventMergeRecord> getAllMergeRecords() {
        return eventMergeService.getAll();
    }
}
