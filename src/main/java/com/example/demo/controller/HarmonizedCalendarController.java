package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/harmonized-calendars")
@Tag(name = "Harmonized Calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService service;

    public HarmonizedCalendarController(HarmonizedCalendarService service) {
        this.service = service;
    }

    // POST /api/harmonized-calendars/generate
    @PostMapping("/generate")
    public HarmonizedCalendar generate(@RequestBody HarmonizedCalendar calendar) {
        return service.generate(calendar);
    }

    // GET /api/harmonized-calendars/{id}
    @GetMapping("/{id}")
    public HarmonizedCalendar getById(@PathVariable Long id) {
        throw new UnsupportedOperationException("Fetch by ID via repository");
    }

    // GET /api/harmonized-calendars
    @GetMapping
    public List<HarmonizedCalendar> getAll() {
        throw new UnsupportedOperationException("List all calendars");
    }

    // GET /api/harmonized-calendars/range
    @GetMapping("/range")
    public List<HarmonizedCalendar> range(LocalDate date) {
        return service.findActive(date);
    }
}
