@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    @Autowired
    private BranchProfileService branchProfileService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BranchProfile> createBranch(@RequestBody BranchProfile branch) {
        return ResponseEntity.ok(branchProfileService.create(branch));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BranchProfile> updateBranch(@PathVariable Long id, @RequestBody BranchProfile branch) {
        return ResponseEntity.ok(branchProfileService.update(id, branch));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','REVIEWER')")
    public ResponseEntity<BranchProfile> getBranch(@PathVariable Long id) {
        return ResponseEntity.ok(branchProfileService.getById(id));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','REVIEWER')")
    public ResponseEntity<List<BranchProfile>> getAllBranches() {
        return ResponseEntity.ok(branchProfileService.getAll());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long id) {
        branchProfileService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
