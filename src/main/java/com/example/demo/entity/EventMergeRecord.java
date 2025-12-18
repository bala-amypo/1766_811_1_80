package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceEventIds;
    private String mergeTitle;
    private String mergeReason;
    private LocalDateTime createdAt;

    public EventMergeRecord() {}

    public EventMergeRecord(String sourceEventIds, String mergeTitle, String mergeReason) {
        this.sourceEventIds = sourceEventIds;
        this.mergeTitle = mergeTitle;
        this.mergeReason = mergeReason;
    }

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getSourceEventIds() {
        return sourceEventIds;
    }

    public String getMergeTitle() {
        return mergeTitle;
    }

    public String getMergeReason() {
        return mergeReason;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
