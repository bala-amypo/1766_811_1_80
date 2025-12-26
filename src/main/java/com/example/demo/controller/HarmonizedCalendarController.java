package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService service;

    public HarmonizedCalendarController(HarmonizedCalendarService service) {
        this.service = service;
    }

    @PostMapping("/generate")
    public HarmonizedCalendar generate(@RequestParam String title,
                                       @RequestParam String generatedBy) {
        return service.generateHarmonizedCalendar(title, generatedBy);
    }

    @GetMapping("/{id}")
    public HarmonizedCalendar get(@PathVariable Long id) {
        return service.getCalendarById(id);
    }

    @GetMapping
    public List<HarmonizedCalendar> getAll() {
        return service.getAllCalendars();
    }

    @GetMapping("/range")
    public List<HarmonizedCalendar> byRange(@RequestParam LocalDate start,
                                            @RequestParam LocalDate end) {
        return service.getCalendarsWithinRange(start, end);
    }
}
