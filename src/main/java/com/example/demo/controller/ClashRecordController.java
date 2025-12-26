package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clash-records")
public class ClashRecordController {

    private final ClashDetectionService clashDetectionService;

    public ClashRecordController(ClashDetectionService clashDetectionService) {
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

    @PutMapping("/resolve/{id}")
    public ResponseEntity<ClashRecord> resolveClash(@PathVariable Long id) {
        ClashRecord resolved = clashDetectionService.resolveClash(id);
        return ResponseEntity.ok(resolved);
    }
}
