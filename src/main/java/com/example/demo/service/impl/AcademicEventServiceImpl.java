package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;

import java.time.LocalDate;
import java.util.List;

public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository repository;

    public AcademicEventServiceImpl(AcademicEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public AcademicEvent save(AcademicEvent event) {
        return repository.save(event);
    }

    @Override
    public List<AcademicEvent> findByBranch(Long branchId) {
        return repository.findByBranchId(branchId);
    }

    @Override
    public List<AcademicEvent> findOverlapping(LocalDate start, LocalDate end) {
        return repository
                .findByStartDateLessThanEqualAndEndDateGreaterThanEqual(end, start);
    }
}
