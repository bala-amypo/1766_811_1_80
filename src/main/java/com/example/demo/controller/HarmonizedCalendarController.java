package com.example.demo.controller;

import com.example.demo.dto.HarmonizedCalendarRequest;
import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService harmonizedCalendarService;

    public HarmonizedCalendarController(HarmonizedCalendarService harmonizedCalendarService) {
        this.harmonizedCalendarService = harmonizedCalendarService;
    }

    @PostMapping
    public ResponseEntity<HarmonizedCalendar> generateCalendar(
            @Valid @RequestBody HarmonizedCalendarRequest request) {

        HarmonizedCalendar cal = harmonizedCalendarService.generateHarmonizedCalendar(
                request.getCalendarName(), "SYSTEM"
        );
        return ResponseEntity.ok(cal);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HarmonizedCalendar> getCalendar(@PathVariable Long id) {
        HarmonizedCalendar cal = harmonizedCalendarService.getCalendarById(id);
        return ResponseEntity.ok(cal);
    }

    @GetMapping
    public ResponseEntity<List<HarmonizedCalendar>> getCalendarsInRange(
            @RequestParam("from") String from,
            @RequestParam("to") String to) {

        List<HarmonizedCalendar> list = harmonizedCalendarService.getCalendarsWithinRange(
                LocalDate.parse(from),
                LocalDate.parse(to)
        );
        return ResponseEntity.ok(list);
    }
}
