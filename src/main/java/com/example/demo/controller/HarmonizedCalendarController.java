package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/harmonized-calendars")
@Tag(name = "Harmonized Calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService harmonizedCalendarService;

    public HarmonizedCalendarController(HarmonizedCalendarService harmonizedCalendarService) {
        this.harmonizedCalendarService = harmonizedCalendarService;
    }

    @PostMapping("/generate")
    public ResponseEntity<HarmonizedCalendar> generateCalendar(
            @RequestParam String title,
            @RequestParam String generatedBy) {

        return ResponseEntity.ok(
                harmonizedCalendarService.generateHarmonizedCalendar(title, generatedBy)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<HarmonizedCalendar> getCalendar(@PathVariable Long id) {
        return ResponseEntity.ok(harmonizedCalendarService.getCalendarById(id));
    }

    @GetMapping
    public ResponseEntity<List<HarmonizedCalendar>> getAllCalendars() {
        return ResponseEntity.ok(harmonizedCalendarService.getAllCalendars());
    }

    @GetMapping("/range")
    public ResponseEntity<List<HarmonizedCalendar>> getByDateRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {

        return ResponseEntity.ok(
                harmonizedCalendarService.getCalendarsWithinRange(start, end)
        );
    }
}
