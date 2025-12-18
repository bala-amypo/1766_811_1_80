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
    private LocalDateTime generatedAt;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    @Lob
    private String eventsJson;

    public HarmonizedCalendar() {}

    @PrePersist
    public void onCreate() {
        generatedAt = LocalDateTime.now();
    }
   public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGeneratedBy() { return generatedBy; }
    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public String getEventsJson() { return eventsJson; }
    public void setEventsJson(String eventsJson) {
        this.eventsJson = eventsJson;
    }
}
