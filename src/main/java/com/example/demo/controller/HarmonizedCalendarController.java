@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    @Autowired
    private HarmonizedCalendarService calendarService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HarmonizedCalendar> generateCalendar(@RequestBody HarmonizedCalendar calendar) {
        return ResponseEntity.ok(calendarService.generate(calendar.getTitle(), calendar.getGeneratedBy()));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HarmonizedCalendar> updateCalendar(@PathVariable Long id, @RequestBody HarmonizedCalendar calendar) {
        return ResponseEntity.ok(calendarService.update(id, calendar));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','REVIEWER')")
    public ResponseEntity<HarmonizedCalendar> getCalendar(@PathVariable Long id) {
        return ResponseEntity.ok(calendarService.getById(id));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','REVIEWER')")
    public ResponseEntity<List<HarmonizedCalendar>> getAllCalendars() {
        return ResponseEntity.ok(calendarService.getAll());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteCalendar(@PathVariable Long id) {
        calendarService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
