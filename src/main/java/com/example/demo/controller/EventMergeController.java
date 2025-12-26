package com.example.demo.controller;

import com.example.demo.dto.MergeEventsRequest;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/merge-records")
@Tag(name = "Event Merge Records")
public class EventMergeController {

    private final EventMergeService eventMergeService;

    public EventMergeController(EventMergeService eventMergeService) {
        this.eventMergeService = eventMergeService;
    }

    @PreAuthorize("hasAnyRole('ADMIN','CALENDAR_MANAGER')")
    @PostMapping
    public ResponseEntity<EventMergeRecord> mergeEvents(
            @RequestBody MergeEventsRequest request) {

        return ResponseEntity.ok(
                eventMergeService.mergeEvents(
                        request.getEventIds(),
                        request.getReason()
                )
        );
    }

    @PreAuthorize("hasAnyRole('ADMIN','CALENDAR_MANAGER','REVIEWER')")
    @GetMapping("/{id}")
    public ResponseEntity<EventMergeRecord> getMergeRecordById(@PathVariable Long id) {
        return ResponseEntity.ok(eventMergeService.getMergeRecordById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN','CALENDAR_MANAGER','REVIEWER')")
    @GetMapping
    public ResponseEntity<List<EventMergeRecord>> getAllMergeRecords() {
        return ResponseEntity.ok(eventMergeService.getAllMergeRecords());
    }

    @PreAuthorize("hasAnyRole('ADMIN','CALENDAR_MANAGER','REVIEWER')")
    @GetMapping("/range")
    public ResponseEntity<List<EventMergeRecord>> getMergeRecordsByDate(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {

        return ResponseEntity.ok(
                eventMergeService.getMergeRecordsByDate(start, end)
        );
    }
}
