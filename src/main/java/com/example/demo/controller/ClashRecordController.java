package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashRecordService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashRecordService service;

    public ClashRecordController(ClashRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ClashRecord create(@Valid @RequestBody ClashRecord record) {
        return service.save(record);
    }

    @GetMapping("/{id}")
    public ClashRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ClashRecord> getAll() {
        return service.getAll();
    }
}
