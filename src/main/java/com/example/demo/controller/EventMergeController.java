package com.example.demo.controller;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/merge-records")
@Tag(name = "Event Merge Records")
public class EventMergeController {

    private final EventMergeService service;

    public EventMergeController(EventMergeService service) {
        this.service = service;
    }

    @PostMapping
    public EventMergeRecord merge(@Valid @RequestBody EventMergeRecord record) {
        return service.save(record);
    }

    @GetMapping("/{id}")
    public EventMergeRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<EventMergeRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/range")
    public List<EventMergeRecord> getByDateRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return service.getByDateRange(startDate, endDate);
    }
}
