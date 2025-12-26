package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventService service;

    public AcademicEventController(AcademicEventService service) {
        this.service = service;
    }

    @PostMapping
    public AcademicEvent create(@RequestBody AcademicEvent event) {
        return service.createEvent(event);
    }

    @PutMapping("/{id}")
    public AcademicEvent update(@PathVariable Long id,
                                @RequestBody AcademicEvent event) {
        return service.updateEvent(id, event);
    }

    @GetMapping("/branch/{branchId}")
    public List<AcademicEvent> byBranch(@PathVariable Long branchId) {
        return service.getEventsByBranch(branchId);
    }

    @GetMapping("/{id}")
    public AcademicEvent getById(@PathVariable Long id) {
        return service.getEventById(id);
    }

    @GetMapping
    public List<AcademicEvent> getAll() {
        return service.getAllEvents();
    }
}
