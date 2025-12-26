package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService service;

    public HarmonizedCalendarController(HarmonizedCalendarService service) {
        this.service = service;
    }

    @PostMapping
    public HarmonizedCalendar create(@Valid @RequestBody HarmonizedCalendar calendar) {
        return service.save(calendar);
    }

    @PutMapping("/{id}")
    public HarmonizedCalendar update(@PathVariable Long id,
                                     @Valid @RequestBody HarmonizedCalendar calendar) {
        return service.update(id, calendar);
    }

    @GetMapping("/{id}")
    public HarmonizedCalendar getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<HarmonizedCalendar> getAll() {
        return service.getAll();
    }

    @GetMapping("/branch/{branchId}")
    public List<HarmonizedCalendar> getByBranch(@PathVariable Long branchId) {
        return service.getByBranch(branchId);
    }
}
