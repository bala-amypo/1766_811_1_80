package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.impl.AcademicEventServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventServiceImpl academicEventService;

    public AcademicEventController(AcademicEventServiceImpl academicEventService) {
        this.academicEventService = academicEventService;
    }

    @PostMapping
    public ResponseEntity<AcademicEvent> createEvent(@RequestBody AcademicEvent event) {
        AcademicEvent created = academicEventService.createEvent(event);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/branch/{branchId}")
    public ResponseEntity<List<AcademicEvent>> getEventsByBranch(@PathVariable Long branchId) {
        List<AcademicEvent> list = academicEventService.getEventsByBranch(branchId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicEvent> getEventById(@PathVariable Long id) {
        AcademicEvent event = academicEventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicEvent> updateEvent(@PathVariable Long id,
                                                     @RequestBody AcademicEvent event) {
        AcademicEvent updated = academicEventService.updateEvent(id, event);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        academicEventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
