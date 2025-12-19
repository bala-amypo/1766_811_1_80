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
}
