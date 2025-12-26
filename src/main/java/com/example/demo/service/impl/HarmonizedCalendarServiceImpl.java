package com.example.demo.service.impl;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

    private final HarmonizedCalendarRepository repository;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository repository) {
        this.repository = repository;
    }

    @Override
    public HarmonizedCalendar generate(HarmonizedCalendar calendar) {
        return repository.save(calendar);
    }

    @Override
    public List<HarmonizedCalendar> findActive(LocalDate date) {
        return repository
                .findByEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
                        date, date);
    }
}
