package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clash_records")
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private Long eventDate;
    private String clashType;
    private String severity;
    private String details;
    private LocalDateTime detectedAt;
    private Boolean resolved = false;

    public ClashRecord() {}

    @PrePersist
    public void prePersist() {
        this.detectedAt = LocalDateTime.now();
        if (resolved == null) resolved = false;
    }

    // getters and setters
    public Long getId() { return id; }

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public Long getEventDate() { return eventDate; }
    public void setEventDate(Long eventDate) { this.eventDate = eventDate; }

    public String getClashType() { return clashType; }
    public void setClashType(String clashType) { this.clashType = clashType; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public LocalDateTime getDetectedAt() { return detectedAt; }

    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}
