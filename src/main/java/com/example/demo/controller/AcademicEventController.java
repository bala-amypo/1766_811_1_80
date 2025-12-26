package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    // POST /api/events
    @PostMapping
    public AcademicEvent create(@RequestBody AcademicEvent event) {
        return service.submit(event);
    }

    // PUT /api/events/{id}
    @PutMapping("/{id}")
    public AcademicEvent update(@PathVariable Long id,
                                @RequestBody AcademicEvent event) {
        event.setId(id);
        return service.submit(event);
    }

    // GET /api/events/branch/{branchId}
    @GetMapping("/branch/{branchId}")
    public List<AcademicEvent> getByBranch(@PathVariable Long branchId) {
        return service.getByBranch(branchId);
    }

    // GET /api/events/{id}
    @GetMapping("/{id}")
    public AcademicEvent getById(@PathVariable Long id) {
        return service.findByIds(List.of(id)).get(0);
    }

    // GET /api/events
    @GetMapping
    public List<AcademicEvent> getAll() {
        return service.findByIds(List.of());
    }
}
