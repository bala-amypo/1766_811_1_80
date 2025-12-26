@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    @Autowired
    private ClashRecordService clashRecordService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClashRecord> createClash(@RequestBody ClashRecord record) {
        return ResponseEntity.ok(clashRecordService.create(record));
    }

    @PutMapping("/{id}/resolve")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClashRecord> resolveClash(@PathVariable Long id) {
        return ResponseEntity.ok(clashRecordService.resolve(id));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','REVIEWER')")
    public ResponseEntity<ClashRecord> getClash(@PathVariable Long id) {
        return ResponseEntity.ok(clashRecordService.getById(id));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','REVIEWER')")
    public ResponseEntity<List<ClashRecord>> getAllClashes() {
        return ResponseEntity.ok(clashRecordService.getAll());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteClash(@PathVariable Long id) {
        clashRecordService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
