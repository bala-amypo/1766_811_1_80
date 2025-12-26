package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyRole('ADMIN','CALENDAR_MANAGER')")
    @PostMapping("/generate")
    public ResponseEntity<HarmonizedCalendar> generateCalendar(
            @RequestParam String title,
            @RequestParam String generatedBy) {

        return ResponseEntity.ok(
                harmonizedCalendarService.generateHarmonizedCalendar(title, generatedBy)
        );
    }

    @PreAuthorize("hasAnyRole('ADMIN','CALENDAR_MANAGER','REVIEWER')")
    @GetMapping("/{id}")
    public ResponseEntity<HarmonizedCalendar> getCalendarById(@PathVariable Long id) {
        return ResponseEntity.ok(harmonizedCalendarService.getCalendarById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN','CALENDAR_MANAGER','REVIEWER')")
    @GetMapping
    public ResponseEntity<List<HarmonizedCalendar>> getAllCalendars() {
        return ResponseEntity.ok(harmonizedCalendarService.getAllCalendars());
    }

    @PreAuthorize("hasAnyRole('ADMIN','CALENDAR_MANAGER','REVIEWER')")
    @GetMapping("/range")
    public ResponseEntity<List<HarmonizedCalendar>> getCalendarsWithinRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {

        return ResponseEntity.ok(
                harmonizedCalendarService.getCalendarsWithinRange(start, end)
        );
    }
}
