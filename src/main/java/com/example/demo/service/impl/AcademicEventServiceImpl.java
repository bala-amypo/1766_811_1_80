package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AcademicEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicEventServiceImpl {

    private final AcademicEventRepository academicEventRepository;

    public AcademicEventServiceImpl(AcademicEventRepository academicEventRepository) {
        this.academicEventRepository = academicEventRepository;
    }

    public AcademicEvent createEvent(AcademicEvent event) {
        return academicEventRepository.save(event);
    }

    public AcademicEvent getEventById(Long id) {
        return academicEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    public List<AcademicEvent> getEventsByBranch(Long branchId) {
        return academicEventRepository.findByBranchId(branchId);
    }

    public AcademicEvent updateEvent(Long id, AcademicEvent updatedEvent) {
        AcademicEvent existing = academicEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        existing.setTitle(updatedEvent.getTitle());
        existing.setEventType(updatedEvent.getEventType());
        existing.setStartDate(updatedEvent.getStartDate());
        existing.setEndDate(updatedEvent.getEndDate());
        existing.setLocation(updatedEvent.getLocation());
        existing.setDescription(updatedEvent.getDescription());

        return academicEventRepository.save(existing);
    }

    public void deleteEvent(Long id) {
        AcademicEvent existing = academicEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        academicEventRepository.delete(existing);
    }
}
