package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    @Autowired
    private AcademicEventService academicEventService;

    @PostMapping
    public ResponseEntity<AcademicEvent> createEvent(@RequestBody AcademicEvent event) {
        return ResponseEntity.ok(academicEventService.create(event));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicEvent> updateEvent(@PathVariable Long id, @RequestBody AcademicEvent event) {
        return ResponseEntity.ok(academicEventService.update(id, event));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicEvent> getEvent(@PathVariable Long id) {
        return ResponseEntity.ok(academicEventService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<AcademicEvent>> getAllEvents() {
        return ResponseEntity.ok(academicEventService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        academicEventService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
