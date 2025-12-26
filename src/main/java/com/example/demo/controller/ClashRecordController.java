package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashDetectionService service;

    public ClashRecordController(ClashDetectionService service) {
        this.service = service;
    }

    @PostMapping
    public ClashRecord create(@RequestBody ClashRecord clash) {
        return service.logClash(clash);
    }

    @PutMapping("/{id}/resolve")
    public ClashRecord resolve(@PathVariable Long id) {
        return service.resolveClash(id);
    }

    @GetMapping("/event/{eventId}")
    public List<ClashRecord> byEvent(@PathVariable Long eventId) {
        return service.getClashesForEvent(eventId);
    }

    @GetMapping("/unresolved")
    public List<ClashRecord> unresolved() {
        return service.getUnresolvedClashes();
    }

    @GetMapping
    public List<ClashRecord> getAll() {
        return service.getAllClashes();
    }
}
