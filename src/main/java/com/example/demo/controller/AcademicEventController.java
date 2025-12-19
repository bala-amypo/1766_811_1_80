package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventService academicEventService;

    public AcademicEventController(AcademicEventService academicEventService) {
        this.academicEventService = academicEventService;
    }

    @PostMapping
    public AcademicEvent createEvent(@Valid @RequestBody AcademicEvent event) {
        return academicEventService.save(event);
    }

    @GetMapping
    public List<AcademicEvent> getAllEvents() {
        return academicEventService.getAll();
    }
}
