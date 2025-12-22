package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashDetectionService clashService;

    public ClashRecordController(ClashDetectionService clashService) {
        this.clashService = clashService;
    }

    @PostMapping("/detect")
    public List<ClashRecord> detect(@RequestBody List<AcademicEvent> events) {
        return clashService.detectClashes(events);
    }

    @PostMapping
    public ClashRecord create(@Valid @RequestBody ClashRecord record) {
        return clashService.save(record);
    }

    @PutMapping("/{id}")
    public ClashRecord update(@PathVariable Long id,
                              @Valid @RequestBody ClashRecord record) {
        return clashService.update(id, record);
    }

    @GetMapping("/{id}")
    public ClashRecord getById(@PathVariable Long id) {
        return clashService.getById(id);
    }

    @GetMapping
    public List<ClashRecord> getAll() {
        return clashService.getAll();
    }
}
