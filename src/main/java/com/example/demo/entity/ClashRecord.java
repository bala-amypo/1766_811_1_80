package com.example.demo.service;

import com.example.demo.entity.ClashRecord;
import java.util.List;

public interface ClashDetectionService {

    List<ClashRecord> getClashesForEvent(Long eventId);

    ClashRecord saveClash(Long eventAId,
                          Long eventBId,
                          String clashType,
                          String severity,
                          String details);

    ClashRecord markResolved(Long clashId);
}
