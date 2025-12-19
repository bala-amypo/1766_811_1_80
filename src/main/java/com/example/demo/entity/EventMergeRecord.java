package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "event_merge_records")
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Source event IDs required")
    private String sourceEventIds;

    @NotBlank(message = "Merged title required")
    private String mergedTitle;

    private String mergeReason;

    public EventMergeRecord() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSourceEventIds() { return sourceEventIds; }
    public void setSourceEventIds(String sourceEventIds) { this.sourceEventIds = sourceEventIds; }

    public String getMergedTitle() { return mergedTitle; }
    public void setMergedTitle(String mergedTitle) { this.mergedTitle = mergedTitle; }

    public String getMergeReason() { return mergeReason; }
    public void setMergeReason(String mergeReason) { this.mergeReason = mergeReason; }
}
