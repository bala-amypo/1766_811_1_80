package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    @Autowired
    private HarmonizedCalendarService calendarService;

    @PostMapping
    public ResponseEntity<HarmonizedCalendar> createCalendar(@RequestBody HarmonizedCalendar calendar) {
        return ResponseEntity.ok(calendarService.create(calendar));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HarmonizedCalendar> updateCalendar(@PathVariable Long id, @RequestBody HarmonizedCalendar calendar) {
        return ResponseEntity.ok(calendarService.update(id, calendar));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HarmonizedCalendar> getCalendar(@PathVariable Long id) {
        return ResponseEntity.ok(calendarService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<HarmonizedCalendar>> getAllCalendars() {
        return ResponseEntity.ok(calendarService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalendar(@PathVariable Long id) {
        calendarService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
