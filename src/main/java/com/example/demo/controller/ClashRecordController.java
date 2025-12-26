package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ClashRecord> create(@RequestBody ClashRecord clashRecord) {
        return ResponseEntity.ok(service.createClash(clashRecord));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClashRecord> update(
            @PathVariable Long id,
            @RequestBody ClashRecord clashRecord) {
        return ResponseEntity.ok(service.updateClash(id, clashRecord));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClashRecord> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getClashById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClashRecord>> getAll() {
        return ResponseEntity.ok(service.getAllClashes());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteClash(id);
        return ResponseEntity.noContent().build();
    }
}
