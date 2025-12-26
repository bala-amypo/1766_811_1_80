package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.impl.HarmonizedCalendarServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarServiceImpl harmonizedCalendarService;

    public HarmonizedCalendarController(HarmonizedCalendarServiceImpl harmonizedCalendarService) {
        this.harmonizedCalendarService = harmonizedCalendarService;
    }

    @PostMapping("/generate")
    public ResponseEntity<HarmonizedCalendar> generateCalendar(
            @RequestParam String title,
            @RequestParam String generatedBy) {
        HarmonizedCalendar cal = harmonizedCalendarService.generateHarmonizedCalendar(title, generatedBy);
        return ResponseEntity.ok(cal);
    }

    @GetMapping("/range")
    public ResponseEntity<List<HarmonizedCalendar>> getCalendarsWithinRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        List<HarmonizedCalendar> list = harmonizedCalendarService.getCalendarsWithinRange(start, end);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HarmonizedCalendar> getCalendarById(@PathVariable Long id) {
        HarmonizedCalendar cal = harmonizedCalendarService.getCalendarById(id);
        return ResponseEntity.ok(cal);
    }
}
