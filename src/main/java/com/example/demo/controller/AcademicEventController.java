package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@Tag(name = "Academic Events")
public class AcademicEventController {

    private final AcademicEventService service;

    public AcademicEventController(AcademicEventService service) {
        this.service = service;
    }

    @PostMapping
    public AcademicEvent create(@Valid @RequestBody AcademicEvent event) {
        return service.save(event);
    }

    @PutMapping("/{id}")
    public AcademicEvent update(
            @PathVariable Long id,
            @Valid @RequestBody AcademicEvent event) {
        return service.update(id, event);
    }

    @GetMapping("/{id}")
    public AcademicEvent getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<AcademicEvent> getAll() {
        return service.getAll();
    }

    @GetMapping("/branch/{branchId}")
    public List<AcademicEvent> getByBranch(@PathVariable Long branchId) {
        return service.getByBranch(branchId);
    }
}
