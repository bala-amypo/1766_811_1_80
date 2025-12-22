package com.example.demo.service.impl;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRepository repository;

    public EventMergeServiceImpl(EventMergeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EventMergeRecord save(EventMergeRecord record) {
        return repository.save(record);
    }

    @Override
    public EventMergeRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Merge record not found with id: " + id));
    }

    @Override
    public List<EventMergeRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public List<EventMergeRecord> getByDateRange(LocalDate startDate, LocalDate endDate) {
        return repository.findAll()
                .stream()
                .filter(r ->
                        !r.getMergedStartDate().isAfter(endDate) &&
                        !r.getMergedEndDate().isBefore(startDate))
                .collect(Collectors.toList());
    }
}
