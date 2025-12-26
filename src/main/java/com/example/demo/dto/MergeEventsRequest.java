package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class MergeEventsRequest {

    @NotEmpty(message = "Event IDs cannot be empty")
    private List<Long> eventIds;

    public MergeEventsRequest() {}

    public MergeEventsRequest(List<Long> eventIds) {
        this.eventIds = eventIds;
    }

    // Getters & Setters
    public List<Long> getEventIds() {
        return eventIds;
    }

    public void setEventIds(List<Long> eventIds) {
        this.eventIds = eventIds;
    }
}
