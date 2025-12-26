package com.example.demo.service.impl;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

    private final HarmonizedCalendarRepository repository;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository repository) {
        this.repository = repository;
    }

    @Override
    public HarmonizedCalendar save(HarmonizedCalendar calendar) {
        return repository.save(calendar);
    }

    @Override
    public HarmonizedCalendar update(Long id, HarmonizedCalendar calendar) {
        HarmonizedCalendar existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("HarmonizedCalendar not found with id: " + id));

        existing.setName(calendar.getName());
        existing.setDescription(calendar.getDescription());
        existing.setStartDate(calendar.getStartDate());
        existing.setEndDate(calendar.getEndDate());
        existing.setBranchId(calendar.getBranchId());

        return repository.save(existing);
    }

    @Override
    public HarmonizedCalendar getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("HarmonizedCalendar not found with id: " + id));
    }

    @Override
    public List<HarmonizedCalendar> getAll() {
        return repository.findAll();
    }

    @Override
    public List<HarmonizedCalendar> getByBranch(Long branchId) {
        return repository.findAll()
                .stream()
                .filter(c -> branchId.equals(c.getBranchId()))
                .collect(Collectors.toList());
    }
}
