package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
@Tag(name = "Clash Records")
public class ClashRecordController {

    private final ClashDetectionService clashDetectionService;

    public ClashRecordController(ClashDetectionService clashDetectionService) {
        this.clashDetectionService = clashDetectionService;
    }

    @PreAuthorize("hasAnyRole('ADMIN','CALENDAR_MANAGER')")
    @PostMapping
    public ResponseEntity<ClashRecord> logClash(@RequestBody ClashRecord clash) {
        return ResponseEntity.ok(clashDetectionService.logClash(clash));
    }

    @PreAuthorize("hasAnyRole('ADMIN','CALENDAR_MANAGER')")
    @PutMapping("/{id}/resolve")
    public ResponseEntity<ClashRecord> resolveClash(@PathVariable Long id) {
        return ResponseEntity.ok(clashDetectionService.resolveClash(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN','CALENDAR_MANAGER','REVIEWER')")
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<ClashRecord>> getClashesForEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(clashDetectionService.getClashesForEvent(eventId));
    }

    @PreAuthorize("hasAnyRole('ADMIN','CALENDAR_MANAGER','REVIEWER')")
    @GetMapping("/unresolved")
    public ResponseEntity<List<ClashRecord>> getUnresolvedClashes() {
        return ResponseEntity.ok(clashDetectionService.getUnresolvedClashes());
    }

    @PreAuthorize("hasAnyRole('ADMIN','CALENDAR_MANAGER','REVIEWER')")
    @GetMapping
    public ResponseEntity<List<ClashRecord>> getAllClashes() {
        return ResponseEntity.ok(clashDetectionService.getAllClashes());
    }
}
