package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AcademicEvent;

public interface AcademicEventService {
    AcademicEvent save(AcademicEvent event);
    List<AcademicEvent> getAll();
}
