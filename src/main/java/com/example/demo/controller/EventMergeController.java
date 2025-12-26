package com.example.demo.controller;

import com.example.demo.dto.MergeEventsRequest;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    private final EventMergeService eventMergeService;

    public EventMergeController(EventMergeService eventMergeService) {
        this.eventMergeService = eventMergeService;
    }

    @PostMapping("/merge")
    public ResponseEntity<EventMergeRecord> mergeEvents(@Valid @RequestBody MergeEventsRequest request) {
        EventMergeRecord record = eventMergeService.mergeEvents(request.getEventIds(), "CONFLICT_RESOLUTION");
        return ResponseEntity.ok(record);
    }

    @GetMapping("/range")
    public ResponseEntity<List<EventMergeRecord>> getMergeRecordsByDate(
            @RequestParam("start") String start,
            @RequestParam("end") String end) {

        List<EventMergeRecord> list = eventMergeService.getMergeRecordsByDate(
                LocalDate.parse(start), LocalDate.parse(end)
        );
        return ResponseEntity.ok(list);
    }
}
