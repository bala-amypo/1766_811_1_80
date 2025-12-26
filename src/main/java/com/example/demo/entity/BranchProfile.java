package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class AcademicEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long branchId;
    private String title;
    private String eventType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private String description;
    private LocalDateTime submittedAt;

    @PrePersist
    public void prePersist() {
        if (submittedAt == null) submittedAt = LocalDateTime.now();
    }

    public AcademicEvent() {}

    public AcademicEvent(Long id, Long branchId, String title, String eventType,
                         LocalDate startDate,
