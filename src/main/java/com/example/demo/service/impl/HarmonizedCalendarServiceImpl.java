package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.service.HarmonizedCalendarService;

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
    public List<HarmonizedCalendar> getAll() {
        return repository.findAll();
    }
}
