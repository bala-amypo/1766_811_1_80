package com.example.demo.controller;

import com.example.demo.dto.MergeEventsRequest;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    private final EventMergeService service;

    public EventMergeController(EventMergeService service) {
        this.service = service;
    }

    @PostMapping
    public EventMergeRecord merge(@RequestBody MergeEventsRequest request) {
        return service.mergeEvents(request.getEventIds(), request.getReason());
    }

    @GetMapping("/{id}")
    public EventMergeRecord get(@PathVariable Long id) {
        return service.getMergeRecordById(id);
    }

    @GetMapping
    public List<EventMergeRecord> getAll() {
        return service.getAllMergeRecords();
    }

    @GetMapping("/range")
    public List<EventMergeRecord> byDate(@RequestParam LocalDate start,
                                         @RequestParam LocalDate end) {
        return service.getMergeRecordsByDate(start, end);
    }
}
