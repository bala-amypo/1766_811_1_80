package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class HarmonizedCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String generatedBy;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    @Column(length = 2000)
    private String eventsJson;

    private LocalDateTime generatedAt;

    public HarmonizedCalendar() {}

    public HarmonizedCalendar(String title, String generatedBy,
                              LocalDate effectiveFrom, LocalDate effectiveTo,
                              String eventsJson) {
        this.title = title;
        this.generatedBy = generatedBy;
        this.effectiveFrom = effectiveFrom;
        this.effectiveTo = effectiveTo;
        this.eventsJson = eventsJson;
    }

    @PrePersist
    public void onCreate() {
        generatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }
}
