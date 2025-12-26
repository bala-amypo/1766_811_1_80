package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventAId;
    private Long eventBId;
    private String clashType;
    private String severity;
    private String description;

    private LocalDateTime detectedAt;
    private Boolean resolved;

    public ClashRecord() {
    }

    public ClashRecord(Long id, Long eventAId, Long eventBId,
                       String clashType, String severity,
                       String description, LocalDateTime detectedAt,
                       Boolean resolved) {
        this.id = id;
        this.eventAId = eventAId;
        this.eventBId = eventBId;
        this.clashType = clashType;
        this.severity = severity;
        this.description = description;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }

    @PrePersist
    public void prePersist() {
        this.detectedAt = LocalDateTime.now();
        this.resolved = false;
    }

    public Long getId() {
        return id;
    }

    public Long getEventAId() {
        return eventAId;
    }

    public Long getEventBId() {
        return eventBId;
    }

    public String getClashType() {
        return clashType;
    }

    public String getSeverity() {
        return severity;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEventAId(Long eventAId) {
        this.eventAId = eventAId;
    }

    public void setEventBId(Long eventBId) {
        this.eventBId = eventBId;
    }

    public void setClashType(String clashType) {
        this.clashType = clashType;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
