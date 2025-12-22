package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AcademicEvent event1;

    @ManyToOne
    private AcademicEvent event2;

    private String description;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public AcademicEvent getEvent1() { return event1; }
    public void setEvent1(AcademicEvent event1) { this.event1 = event1; }

    public AcademicEvent getEvent2() { return event2; }
    public void setEvent2(AcademicEvent event2) { this.event2 = event2; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
