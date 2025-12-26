@RestController
@RequestMapping("/api/merge-records")
public class EventMergeRecordController {

    @Autowired
    private EventMergeRecordService mergeRecordService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EventMergeRecord> createRecord(@RequestBody EventMergeRecord record) {
        return ResponseEntity.ok(mergeRecordService.create(record));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EventMergeRecord> updateRecord(@PathVariable Long id, @RequestBody EventMergeRecord record) {
        return ResponseEntity.ok(mergeRecordService.update(id, record));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','REVIEWER')")
    public ResponseEntity<EventMergeRecord> getRecord(@PathVariable Long id) {
        return ResponseEntity.ok(mergeRecordService.getById(id));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','REVIEWER')")
    public ResponseEntity<List<EventMergeRecord>> getAllRecords() {
        return ResponseEntity.ok(mergeRecordService.getAll());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        mergeRecordService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
