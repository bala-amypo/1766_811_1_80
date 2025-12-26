package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_merge_records")
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceEventIds;

    private String mergeTitle;

    private LocalDate mergeStartDate;

    private LocalDate mergeEndDate;

    private String mergeReason;

    private LocalDateTime createdAt;

    public EventMergeRecord() {
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getSourceEventIds() {
        return sourceEventIds;
    }

    public void setSourceEventIds(String sourceEventIds) {
        this.sourceEventIds = sourceEventIds;
    }

    public String getMergeTitle() {
        return mergeTitle;
    }

    public void setMergeTitle(String mergeTitle) {
        this.mergeTitle = mergeTitle;
    }

    public LocalDate getMergeStartDate() {
        return mergeStartDate;
    }

    public void setMergeStartDate(LocalDate mergeStartDate) {
        this.mergeStartDate = mergeStartDate;
    }

    public LocalDate getMergeEndDate() {
        return mergeEndDate;
    }

    public void setMergeEndDate(LocalDate mergeEndDate) {
        this.mergeEndDate = mergeEndDate;
    }

    public String getMergeReason() {
        return mergeReason;
    }

    public void setMergeReason(String mergeReason) {
        this.mergeReason = mergeReason;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
