package com.example.demo.service.impl;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.repository.AcademicEventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HarmonizedCalendarServiceImpl {

    private final HarmonizedCalendarRepository harmonizedCalendarRepository;
    private final AcademicEventRepository academicEventRepository;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository harmonizedCalendarRepository,
                                         AcademicEventRepository academicEventRepository) {
        this.harmonizedCalendarRepository = harmonizedCalendarRepository;
        this.academicEventRepository = academicEventRepository;
    }

    // Generate a new harmonized calendar
    public HarmonizedCalendar generateHarmonizedCalendar(String title, String generatedBy) {
        List<AcademicEvent> events = academicEventRepository.findAll();
        String eventsJson = events.stream()
                .map(e -> String.format("{\"id\":%d,\"title\":\"%s\",\"start\":\"%s\",\"end\":\"%s\"}",
                        e.getId(), e.getTitle(), e.getStartDate(), e.getEndDate()))
                .collect(Collectors.joining(",", "[", "]"));

        HarmonizedCalendar cal = new HarmonizedCalendar();
        cal.setTitle(title);
        cal.setGeneratedBy(generatedBy);
        cal.setGeneratedAt(LocalDateTime.now());
        cal.setEffectiveFrom(events.stream().map(AcademicEvent::getStartDate).min(LocalDate::compareTo).orElse(LocalDate.now()));
        cal.setEffectiveTo(events.stream().map(AcademicEvent::getEndDate).max(LocalDate::compareTo).orElse(LocalDate.now()));
        cal.setEventsJson(eventsJson);

        return harmonizedCalendarRepository.save(cal);
    }

    // Get calendars within a date range
    public List<HarmonizedCalendar> getCalendarsWithinRange(LocalDate start, LocalDate end) {
        return harmonizedCalendarRepository.findByEffectiveFromBetweenOrEffectiveToBetween(start, end, start, end);
    }

    // Get calendar by ID
    public HarmonizedCalendar getCalendarById(Long id) {
        return harmonizedCalendarRepository.findById(id).orElse(null);
    }
}
