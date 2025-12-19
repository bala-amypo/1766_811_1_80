package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService harmonizedCalendarService;

    public HarmonizedCalendarController(HarmonizedCalendarService harmonizedCalendarService) {
        this.harmonizedCalendarService = harmonizedCalendarService;
    }

    @PostMapping
    public HarmonizedCalendar createCalendar(@Valid @RequestBody HarmonizedCalendar calendar) {
        return harmonizedCalendarService.save(calendar);
    }

    @GetMapping
    public List<HarmonizedCalendar> getAllCalendars() {
        return harmonizedCalendarService.getAll();
    }
}
