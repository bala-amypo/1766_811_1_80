package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashRecordService;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashRecordService clashRecordService;

    public ClashRecordController(ClashRecordService clashRecordService) {
        this.clashRecordService = clashRecordService;
    }

    @PostMapping
    public ClashRecord createClash(@Valid @RequestBody ClashRecord clash) {
        return clashRecordService.save(clash);
    }

    @GetMapping
    public List<ClashRecord> getAllClashes() {
        return clashRecordService.getAll();
    }
}
