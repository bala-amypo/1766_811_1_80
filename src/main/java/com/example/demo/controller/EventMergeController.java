/*package com.example.demo.controller;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    // POST /api/merge-records
    @PostMapping
    public EventMergeRecord merge(@RequestBody List<Long> eventIds,
                                  @RequestParam String reason) {
        return service.mergeEvents(eventIds, reason);
    }

    // GET /api/merge-records/{id}
    @GetMapping("/{id}")
    public EventMergeRecord getById(@PathVariable Long id) {
        throw new UnsupportedOperationException("Fetch by ID via repository if needed");
    }

    // GET /api/merge-records
    @GetMapping
    public List<EventMergeRecord> getAll() {
        throw new UnsupportedOperationException("List via repository if needed");
    }

    // GET /api/merge-records/range
    @GetMapping("/range")
    public List<EventMergeRecord> getByRange(LocalDate start, LocalDate end) {
        throw new UnsupportedOperationException("Range query via repository");
    }
}
*/
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceEventIds;
    private String mergedTitle;
    private LocalDate mergedStartDate;
    private LocalDate mergedEndDate;
    private String mergeReason;
    private LocalDateTime createdAt;

    public EventMergeRecord() {}

    public EventMergeRecord(Long id, String sourceEventIds, String mergedTitle,
                            LocalDate mergedStartDate, LocalDate mergedEndDate,
                            String mergeReason, LocalDateTime createdAt) {
        this.id = id;
        this.sourceEventIds = sourceEventIds;
        this.mergedTitle = mergedTitle;
        this.mergedStartDate = mergedStartDate;
        this.mergedEndDate = mergedEndDate;
        this.mergeReason = mergeReason;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSourceEventIds() { return sourceEventIds; }
    public void setSourceEventIds(String sourceEventIds) { this.sourceEventIds = sourceEventIds; }

    public String getMergedTitle() { return mergedTitle; }
    public void setMergedTitle(String mergedTitle) { this.mergedTitle = mergedTitle; }

    public LocalDate getMergedStartDate() { return mergedStartDate; }
    public void setMergedStartDate(LocalDate mergedStartDate) { this.mergedStartDate = mergedStartDate; }

    public LocalDate getMergedEndDate() { return mergedEndDate; }
    public void setMergedEndDate(LocalDate mergedEndDate) { this.mergedEndDate = mergedEndDate; }

    public String getMergeReason() { return mergeReason; }
    public void setMergeReason(String mergeReason) { this.mergeReason = mergeReason; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
