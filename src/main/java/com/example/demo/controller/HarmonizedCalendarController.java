package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService service;

    public HarmonizedCalendarController(HarmonizedCalendarService service) {
        this.service = service;
    }

    @PostMapping
    public HarmonizedCalendar create(@Valid @RequestBody HarmonizedCalendar calendar) {
        return service.save(calendar);
    }

    @GetMapping
    public List<HarmonizedCalendar> getAll() {
        return service.getAll();
    }
}
