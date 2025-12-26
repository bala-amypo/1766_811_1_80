package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    @Autowired
    private AcademicEventRepository eventRepository;

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {
        return eventRepository.save(event);
    }

    @Override
    public AcademicEvent getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public List<AcademicEvent> getEventsByBranch(Long branchId) {
        return eventRepository.findByBranchId(branchId);
    }

    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent event) {
        AcademicEvent existing = eventRepository.findById(id).orElse(null);
        if(existing != null) {
            existing.setTitle(event.getTitle());
            existing.setEventType(event.getEventType());
            existing.setDate(event.getDate());
            return eventRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
