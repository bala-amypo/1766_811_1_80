package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<EventMergeRecord> mergeEvents(
            @RequestBody Map<String, Object> request) {

        @SuppressWarnings("unchecked")
        List<Long> eventIds = (List<Long>) request.get("eventIds");
        String reason = (String) request.get("mergeReason");

        return ResponseEntity.ok(
                eventMergeService.mergeEvents(eventIds, reason)
        );
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<EventMergeRecord> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                eventMergeService.getMergeRecordById(id)
        );
    }

    
    @GetMapping
    public ResponseEntity<List<EventMergeRecord>> getAll() {
        return ResponseEntity.ok(
                eventMergeService.getAllMergeRecords()
        );
    }

    
    @GetMapping("/range")
    public ResponseEntity<List<EventMergeRecord>> getByDateRange(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate start,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate end) {

        return ResponseEntity.ok(
                eventMergeService.getMergeRecordsByDate(start, end)
        );
    }
}
