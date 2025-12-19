package com.example.demo.service.impl;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

    private final HarmonizedCalendarRepository repository;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository repository) {
        this.repository = repository;
    }

    public HarmonizedCalendar save(HarmonizedCalendar calendar) {
        return repository.save(calendar);
    }

    public List<HarmonizedCalendar> getAll() {
        return repository.findAll();
    }

    public HarmonizedCalendar getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
