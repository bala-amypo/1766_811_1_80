/*package com.example.demo.controller;

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

*/
/*
package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@Tag(name = "Academic Events")
public class AcademicEventController {
    
    private final AcademicEventService academicEventService;
    
    public AcademicEventController(AcademicEventService academicEventService) {
        this.academicEventService = academicEventService;
    }
    
    @PostMapping
    @Operation(summary = "Create academic event")
    public ResponseEntity<AcademicEvent> createEvent(@RequestBody AcademicEvent event) {
        return ResponseEntity.ok(academicEventService.createEvent(event));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update academic event")
    public ResponseEntity<AcademicEvent> updateEvent(@PathVariable Long id, @RequestBody AcademicEvent event) {
        return ResponseEntity.ok(academicEventService.updateEvent(id, event));
    }
    
    @GetMapping("/branch/{branchId}")
    @Operation(summary = "Get events by branch")
    public ResponseEntity<List<AcademicEvent>> getEventsByBranch(@PathVariable Long branchId) {
        return ResponseEntity.ok(academicEventService.getEventsByBranch(branchId));
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get event by ID")
    public ResponseEntity<AcademicEvent> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(academicEventService.getEventById(id));
    }
    
    @GetMapping
    @Operation(summary = "Get all events")
    public ResponseEntity<List<AcademicEvent>> getAllEvents() {
        return ResponseEntity.ok(academicEventService.getAllEvents());
    }
}*/
package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<AcademicEvent> createEvent(@RequestBody AcademicEvent event) {
        return ResponseEntity.ok(academicEventService.createEvent(event));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AcademicEvent> updateEvent(@PathVariable Long id, @RequestBody AcademicEvent event) {
        return ResponseEntity.ok(academicEventService.updateEvent(id, event));
    }
    
    @GetMapping("/branch/{branchId}")
    public ResponseEntity<List<AcademicEvent>> getEventsByBranch(@PathVariable Long branchId) {
        return ResponseEntity.ok(academicEventService.getEventsByBranch(branchId));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AcademicEvent> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(academicEventService.getEventById(id));
    }
    
    @GetMapping
    public ResponseEntity<List<AcademicEvent>> getAllEvents() {
        return ResponseEntity.ok(academicEventService.getAllEvents());
    }
}