package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository repository;

    public AcademicEventServiceImpl(AcademicEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {
        return repository.save(event);
    }

    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent event) {
        AcademicEvent existing = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("AcademicEvent not found with id: " + id));

        existing.setTitle(event.getTitle());
        existing.setEventType(event.getEventType());
        existing.setStartDate(event.getStartDate());
        existing.setEndDate(event.getEndDate());
        existing.setBranchId(event.getBranchId());

        return repository.save(existing);
    }

    @Override
    public AcademicEvent getEventById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("AcademicEvent not found with id: " + id));
    }

    @Override
    public List<AcademicEvent> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public List<AcademicEvent> getEventsByBranch(Long branchId) {
        return repository.findAll()
                .stream()
                .filter(e -> branchId.equals(e.getBranchId()))
                .collect(Collectors.toList());
    }
}
