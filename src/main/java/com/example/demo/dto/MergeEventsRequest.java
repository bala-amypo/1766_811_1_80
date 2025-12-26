package com.example.demo.dto;

import java.util.List;

public class MergeEventsRequest {

    private List<Long> eventIds;
    private String mergeReason;

    public MergeEventsRequest() {
    }

    public MergeEventsRequest(List<Long> eventIds, String mergeReason) {
        this.eventIds = eventIds;
        this.mergeReason = mergeReason;
    }

    public List<Long> getEventIds() {
        return eventIds;
    }

    public String getMergeReason() {
        return mergeReason;
    }
}
