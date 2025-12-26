package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.impl.ClashDetectionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashDetectionServiceImpl clashDetectionService;

    public ClashRecordController(ClashDetectionServiceImpl clashDetectionService) {
        this.clashDetectionService = clashDetectionService;
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<ClashRecord>> getClashesForEvent(@PathVariable Long eventId) {
        List<ClashRecord> list = clashDetectionService.getClashesForEvent(eventId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/unresolved")
    public ResponseEntity<List<ClashRecord>> getUnresolvedClashes() {
        List<ClashRecord> list = clashDetectionService.getUnresolvedClashes();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/resolve/{id}")
    public ResponseEntity<ClashRecord> resolveClash(@PathVariable Long id) {
        ClashRecord updated = clashDetectionService.resolveClash(id);
        return ResponseEntity.ok(updated);
    }
}
