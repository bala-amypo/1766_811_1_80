package com.example.demo.controller;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/merge-records")
public class EventMergeRecordController {

    @Autowired
    private EventMergeRecordService mergeRecordService;

    @PostMapping
    public ResponseEntity<EventMergeRecord> createRecord(@RequestBody EventMergeRecord record) {
        return ResponseEntity.ok(mergeRecordService.create(record));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventMergeRecord> updateRecord(@PathVariable Long id, @RequestBody EventMergeRecord record) {
        return ResponseEntity.ok(mergeRecordService.update(id, record));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventMergeRecord> getRecord(@PathVariable Long id) {
        return ResponseEntity.ok(mergeRecordService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EventMergeRecord>> getAllRecords() {
        return ResponseEntity.ok(mergeRecordService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        mergeRecordService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
