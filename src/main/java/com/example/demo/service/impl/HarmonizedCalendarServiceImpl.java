package com.example.demo.service.impl;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

    private final HarmonizedCalendarRepository harmonizedCalendarRepository;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository harmonizedCalendarRepository) {
        this.harmonizedCalendarRepository = harmonizedCalendarRepository;
    }

    @Override
    public HarmonizedCalendar generateHarmonizedCalendar(String title, String generatedBy) {
        HarmonizedCalendar calendar = new HarmonizedCalendar();
        calendar.setTitle(title);
        calendar.setGeneratedBy(generatedBy);
        calendar.setGeneratedAt(LocalDateTime.now());
        calendar.setEffectiveFrom(LocalDate.now());
        calendar.setEffectiveTo(LocalDate.now().plusMonths(3));
        return harmonizedCalendarRepository.save(calendar);
    }

    @Override
    public List<HarmonizedCalendar> getCalendarsWithinRange(LocalDate from, LocalDate to) {
        return harmonizedCalendarRepository.findByEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(from, to);
    }

    @Override
    public HarmonizedCalendar getCalendarById(Long id) {
        return harmonizedCalendarRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HarmonizedCalendar not found with id: " + id));
    }
}
