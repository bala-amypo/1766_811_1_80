package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashDetectionService clashDetectionService;

    public ClashRecordController(ClashDetectionService clashDetectionService) {
        this.clashDetectionService = clashDetectionService;
    }

    @PostMapping
    public ClashRecord logClash(@RequestBody ClashRecord clash) {
        return clashDetectionService.logClash(clash);
    }

    @PutMapping("/{id}/resolve")
    public ClashRecord resolveClash(@PathVariable Long id) {
        return clashDetectionService.resolveClash(id);
    }

    @GetMapping("/event/{eventId}")
    public List<ClashRecord> getClashesForEvent(@PathVariable Long eventId) {
        return clashDetectionService.getClashesForEvent(eventId);
    }

    @GetMapping("/unresolved")
    public List<ClashRecord> getUnresolvedClashes() {
        return clashDetectionService.getUnresolvedClashes();
    }

    @GetMapping
    public List<ClashRecord> getAllClashes() {
        return clashDetectionService.getAllClashes();
    }
}
