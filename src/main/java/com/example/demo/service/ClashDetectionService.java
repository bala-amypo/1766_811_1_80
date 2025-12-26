package com.example.demo.service;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.ClashRecord;

import java.util.List;

public interface ClashDetectionService {

    List<ClashRecord> detectClashes(List<AcademicEvent> events);

    ClashRecord save(ClashRecord record);

    ClashRecord update(Long id, ClashRecord record);

    ClashRecord getById(Long id);

    List<ClashRecord> getAll();
}
