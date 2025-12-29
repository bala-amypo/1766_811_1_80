package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService harmonizedCalendarService;

    public HarmonizedCalendarController(HarmonizedCalendarService harmonizedCalendarService) {
        this.harmonizedCalendarService = harmonizedCalendarService;
    }

    
    @PostMapping("/generate")
    public ResponseEntity<HarmonizedCalendar> generateHarmonizedCalendar(
            @RequestBody Map<String, String> request) {

        String title = request.get("title");
        String generatedBy = request.get("generatedBy");

        return ResponseEntity.ok(
                harmonizedCalendarService.generateHarmonizedCalendar(title, generatedBy)
        );
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<HarmonizedCalendar> getCalendarById(@PathVariable Long id) {
        return ResponseEntity.ok(
                harmonizedCalendarService.getCalendarById(id)
        );
    }

    
    @GetMapping
    public ResponseEntity<List<HarmonizedCalendar>> getAllCalendars() {
        return ResponseEntity.ok(
                harmonizedCalendarService.getAllCalendars()
        );
    }

    
    @GetMapping("/range")
    public ResponseEntity<List<HarmonizedCalendar>> getCalendarsWithinRange(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate start,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate end) {

        return ResponseEntity.ok(
                harmonizedCalendarService.getCalendarsWithinRange(start, end)
        );
    }
}
