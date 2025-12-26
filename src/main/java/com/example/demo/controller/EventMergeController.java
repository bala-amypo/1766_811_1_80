package com.example.demo.controller;

import com.example.demo.dto.MergeEventsRequest;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.impl.EventMergeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    private final EventMergeServiceImpl eventMergeService;

    public EventMergeController(EventMergeServiceImpl eventMergeService) {
        this.eventMergeService = eventMergeService;
    }

    @PostMapping("/merge")
    public ResponseEntity<EventMergeRecord> mergeEvents(@RequestBody MergeEventsRequest request) {
        EventMergeRecord merged = eventMergeService.mergeEvents(request.getEventIds(), request.getReason());
        return ResponseEntity.ok(merged);
    }

    @GetMapping("/range")
    public ResponseEntity<List<EventMergeRecord>> getMergeRecordsByDate(
            @RequestParam LocalDate start, @RequestParam LocalDate end) {
        List<EventMergeRecord> list = eventMergeService.getMergeRecordsByDate(start, end);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventMergeRecord> getMergeRecordById(@PathVariable Long id) {
        EventMergeRecord record = eventMergeService.getMergeRecordById(id);
        return ResponseEntity.ok(record);
    }
}
