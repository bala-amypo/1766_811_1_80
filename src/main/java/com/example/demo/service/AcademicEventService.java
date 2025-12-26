package com.example.demo.service;

import com.example.demo.entity.AcademicEvent;

import java.time.LocalDate;
import java.util.List;

public interface AcademicEventService {

    AcademicEvent save(AcademicEvent event);

    List<AcademicEvent> findByBranch(Long branchId);

    List<AcademicEvent> findOverlapping(LocalDate start, LocalDate end);
}
