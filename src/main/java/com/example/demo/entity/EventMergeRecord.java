package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_merge_records")
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String sourceEventIds;

    @NotBlank
    private String mergedTitle;

    @NotNull
    private LocalDate mergedStartDate;

    @NotNull
    private LocalDate mergedEndDate;

    private String mergeReason;
    private LocalDateTime createdAt;

    public EventMergeRecord() {}

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
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
}
