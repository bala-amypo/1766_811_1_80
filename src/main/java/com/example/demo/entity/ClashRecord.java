/*package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ClashRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long eventAId;
    private Long eventBId;
    private String clashType;
    private String severity;
    private String description;
    private LocalDateTime detectedAt;
    private Boolean resolved;

    public ClashRecord() {}

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
        if (detectedAt == null) detectedAt = LocalDateTime.now();
        if (resolved == null) resolved = false;
    }

    public Long getId() { return id; }
    public Boolean getResolved() { return resolved; }

    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}
*/
