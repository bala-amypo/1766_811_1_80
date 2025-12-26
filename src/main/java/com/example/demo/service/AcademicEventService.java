// AcademicEventService.java
package com.example.demo.service;

import com.example.demo.entity.AcademicEvent;
import java.util.List;

public interface AcademicEventService {
    AcademicEvent create(AcademicEvent event);
    AcademicEvent update(Long id, AcademicEvent event);
    AcademicEvent getById(Long id);
    List<AcademicEvent> getAll();
    void delete(Long id);
}
