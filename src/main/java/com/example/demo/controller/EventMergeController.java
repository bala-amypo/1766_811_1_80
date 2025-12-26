/*package com.example.demo.controller;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/merge-records")
@Tag(name = "Event Merge Records")
public class EventMergeController {

    private final EventMergeService service;

    public EventMergeController(EventMergeService service) {
        this.service = service;
    }

    // POST /api/merge-records
    @PostMapping
    public EventMergeRecord merge(@RequestBody List<Long> eventIds,
                                  @RequestParam String reason) {
        return service.mergeEvents(eventIds, reason);
    }

    // GET /api/merge-records/{id}
    @GetMapping("/{id}")
    public EventMergeRecord getById(@PathVariable Long id) {
        throw new UnsupportedOperationException("Fetch by ID via repository if needed");
    }

    // GET /api/merge-records
    @GetMapping
    public List<EventMergeRecord> getAll() {
        throw new UnsupportedOperationException("List via repository if needed");
    }

    // GET /api/merge-records/range
    @GetMapping("/range")
    public List<EventMergeRecord> getByRange(LocalDate start, LocalDate end) {
        throw new UnsupportedOperationException("Range query via repository");
    }
}
*/
