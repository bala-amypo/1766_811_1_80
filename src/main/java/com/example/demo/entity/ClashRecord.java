package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private String clashType;
    private String severity;
    private String details;
    private Boolean resolved;
    private LocalDateTime detectedAt;

    public ClashRecord() {}

    public ClashRecord(Long eventId, String clashType, String severity, String details) {
        this.eventId = eventId;
        this.clashType = clashType;
        this.severity = severity;
        this.details = details;
        this.resolved = false;
    }

    @PrePersist
    public void onCreate() {
        detectedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Long getEventId() {
        return eventId;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
