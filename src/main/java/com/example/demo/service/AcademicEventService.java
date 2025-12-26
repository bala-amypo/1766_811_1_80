package com.example.demo.service;

import com.example.demo.entity.AcademicEvent;

import java.util.List;

public interface AcademicEventService {

    AcademicEvent save(AcademicEvent event);

    AcademicEvent update(Long id, AcademicEvent event);

    AcademicEvent getById(Long id);

    List<AcademicEvent> getAll();

    List<AcademicEvent> getByBranch(Long branchId);
}
