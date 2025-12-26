package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository academicEventRepository;

    public AcademicEventServiceImpl(AcademicEventRepository academicEventRepository) {
        this.academicEventRepository = academicEventRepository;
    }

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {
        if (event.getStartDate().isAfter(event.getEndDate())) {
            throw new ValidationException("startDate cannot be after endDate");
        }
        return academicEventRepository.save(event);
    }

    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent updatedEvent) {
        AcademicEvent existing = getEventById(id);

        if (updatedEvent.getStartDate().isAfter(updatedEvent.getEndDate())) {
            throw new ValidationException("startDate cannot be after endDate");
        }

        existing.setTitle(updatedEvent.getTitle());
        existing.setEventType(updatedEvent.getEventType());
        existing.setStartDate(updatedEvent.getStartDate());
        existing.setEndDate(updatedEvent.getEndDate());
        existing.setLocation(updatedEvent.getLocation());
        existing.setDescription(updatedEvent.getDescription());

        return academicEventRepository.save(existing);
    }

    @Override
    public AcademicEvent getEventById(Long id) {
        return academicEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public List<AcademicEvent> getEventsByBranch(Long branchId) {
        return academicEventRepository.findByBranchId(branchId);
    }

    @Override
    public List<AcademicEvent> getAllEvents() {
        return academicEventRepository.findAll();
    }
}
