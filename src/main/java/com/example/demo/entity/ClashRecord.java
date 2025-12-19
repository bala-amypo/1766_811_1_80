package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clash_records")
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long eventAId;

    @NotNull
    private Long eventBId;

    @NotBlank
    private String clashType;

    @NotBlank
    private String severity;

    private String details;
    private Boolean resolved;
    private LocalDateTime detectedAt;

    @PrePersist
    public void onCreate() {
        detectedAt = LocalDateTime.now();
        if (resolved == null) resolved = false;
    }

    // Getters & Setters
    public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Long getEventAId() {
    return eventAId;
}

public void setEventAId(Long eventAId) {
    this.eventAId = eventAId;
}

public Long getEventBId() {
    return eventBId;
}

public void setEventBId(Long eventBId) {
    this.eventBId = eventBId;
}

public String getClashType() {
    return clashType;
}

public void setClashType(String clashType) {
    this.clashType = clashType;
}

public String getSeverity() {
    return severity;
}

public void setSeverity(String severity) {
    this.severity = severity;
}

public String getDetails() {
    return details;
}

public void setDetails(String details) {
    this.details = details;
}

public Boolean getResolved() {
    return resolved;
}

public void setResolved(Boolean resolved) {
    this.resolved = resolved;
}

public LocalDateTime getDetectedAt() {
    return detectedAt;
}

}
