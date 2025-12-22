package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import com.example.demo.service.ClashRecordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordService clashRecordService;

    public ClashDetectionServiceImpl(ClashRecordService clashRecordService) {
        this.clashRecordService = clashRecordService;
    }

    @Override
    public List<ClashRecord> detectClashes(List<AcademicEvent> events) {

        List<ClashRecord> clashes = new ArrayList<>();

        for (int i = 0; i < events.size(); i++) {
            for (int j = i + 1; j < events.size(); j++) {

                AcademicEvent e1 = events.get(i);
                AcademicEvent e2 = events.get(j);

                if (isClashing(e1, e2)) {
                    ClashRecord record = new ClashRecord();
                    record.setEventOneId(e1.getId());
                    record.setEventTwoId(e2.getId());
                    record.setReason("Date overlap detected");

                    clashes.add(clashRecordService.save(record));
                }
            }
        }
        return clashes;
    }

    private boolean isClashing(AcademicEvent e1, AcademicEvent e2) {
        return !e1.getEndDate().isBefore(e2.getStartDate())
                && !e2.getEndDate().isBefore(e1.getStartDate());
    }
}
