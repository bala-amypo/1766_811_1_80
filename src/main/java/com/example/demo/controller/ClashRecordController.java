/*package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
@Tag(name = "Clash Records")
public class ClashRecordController {

    private final ClashDetectionService service;

    public ClashRecordController(ClashDetectionService service) {
        this.service = service;
    }

    // POST /api/clashes
    @PostMapping
    public ClashRecord log(@RequestBody ClashRecord record) {
        throw new UnsupportedOperationException("Persist via service if needed");
    }

    // PUT /api/clashes/{id}/resolve
    @PutMapping("/{id}/resolve")
    public ClashRecord resolve(@PathVariable Long id) {
        return service.resolve(id);
    }

    // GET /api/clashes/event/{eventId}
    @GetMapping("/event/{eventId}")
    public List<ClashRecord> byEvent(@PathVariable Long eventId) {
        return service.findByEvent(eventId);
    }

    // GET /api/clashes/unresolved
    @GetMapping("/unresolved")
    public List<ClashRecord> unresolved() {
        return service.findUnresolved();
    }

    // GET /api/clashes
    @GetMapping
    public List<ClashRecord> all() {
        throw new UnsupportedOperationException("List all clashes");
    }
}
*/
/*
package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
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
    
    @PostMapping
    @Operation(summary = "Log clash record")
    public ResponseEntity<ClashRecord> logClash(@RequestBody ClashRecord clashRecord) {
        return ResponseEntity.ok(clashDetectionService.logClash(clashRecord));
    }
    
    @PutMapping("/{id}/resolve")
    @Operation(summary = "Resolve clash")
    public ResponseEntity<ClashRecord> resolveClash(@PathVariable Long id) {
        return ResponseEntity.ok(clashDetectionService.resolveClash(id));
    }
    
    @GetMapping("/event/{eventId}")
    @Operation(summary = "Get clashes for event")
    public ResponseEntity<List<ClashRecord>> getClashesForEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(clashDetectionService.getClashesForEvent(eventId));
    }
    
    @GetMapping("/unresolved")
    @Operation(summary = "Get unresolved clashes")
    public ResponseEntity<List<ClashRecord>> getUnresolvedClashes() {
        return ResponseEntity.ok(clashDetectionService.getUnresolvedClashes());
    }
    
    @GetMapping
    @Operation(summary = "Get all clashes")
    public ResponseEntity<List<ClashRecord>> getAllClashes() {
        return ResponseEntity.ok(clashDetectionService.getAllClashes());
    }
}

*/
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
    public ResponseEntity<ClashRecord> logClash(@RequestBody ClashRecord clashRecord) {
        return ResponseEntity.ok(clashDetectionService.logClash(clashRecord));
    }
    
    @PutMapping("/{id}/resolve")
    public ResponseEntity<ClashRecord> resolveClash(@PathVariable Long id) {
        return ResponseEntity.ok(clashDetectionService.resolveClash(id));
    }
    
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<ClashRecord>> getClashesForEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(clashDetectionService.getClashesForEvent(eventId));
    }
    
    @GetMapping("/unresolved")
    public ResponseEntity<List<ClashRecord>> getUnresolvedClashes() {
        return ResponseEntity.ok(clashDetectionService.getUnresolvedClashes());
    }
    
    @GetMapping
    public ResponseEntity<List<ClashRecord>> getAllClashes() {
        return ResponseEntity.ok(clashDetectionService.getAllClashes());
    }
}

