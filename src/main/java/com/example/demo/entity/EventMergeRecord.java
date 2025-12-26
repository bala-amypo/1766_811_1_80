package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class EventMergeRecord {

    @Id
    @GeneratedValue
    private Long id;

    private String sourceEventIds;
    private String mergedTitle;
    private LocalDate mergedStartDate;
    private LocalDate mergedEndDate;
    private String mergeReason;
    private LocalDateTime createdAt;

    public EventMergeRecord() {}

    public EventMergeRecord(Long id, String sourceEventIds, String merg
