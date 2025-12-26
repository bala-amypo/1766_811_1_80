package com.example.demo.dto;

import java.util.List;

public class MergeEventsRequest {

    private List<Long> eventIds;
    private String mergedTitle;
    private String mergeReason;

    public MergeEventsRequest() {}

    public MergeEventsRequest(List<Long> eventIds, String mergedTitle, String mergeReason) {
        this.eventIds = eventIds;
        this.mergedTitle = mergedTitle;
        this.mergeReason = mergeReason;
    }

    public List<Long> getEventIds() {
        return eventIds;
    }

    public String getMergedTitle() {
        return mergedTitle;
    }

    public String getMergeReason() {
        return mergeReason;
    }
}
