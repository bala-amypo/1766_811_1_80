package com.example.demo.controller;

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
