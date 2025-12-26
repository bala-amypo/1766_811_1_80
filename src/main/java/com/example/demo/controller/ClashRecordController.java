package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    @Autowired
    private ClashRecordService clashRecordService;

    @PostMapping
    public ResponseEntity<ClashRecord> createClash(@RequestBody ClashRecord record) {
        return ResponseEntity.ok(clashRecordService.create(record));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClashRecord> updateClash(@PathVariable Long id, @RequestBody ClashRecord record) {
        return ResponseEntity.ok(clashRecordService.update(id, record));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClashRecord> getClash(@PathVariable Long id) {
        return ResponseEntity.ok(clashRecordService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClashRecord>> getAllClashes() {
        return ResponseEntity.ok(clashRecordService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClash(@PathVariable Long id) {
        clashRecordService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
