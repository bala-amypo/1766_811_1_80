/*package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@Tag(name = "Academic Events")
public class AcademicEventController {

    private final AcademicEventService service;

    public AcademicEventController(AcademicEventService service) {
        this.service = service;
    }

    // POST /api/events
    @PostMapping
    public AcademicEvent create(@RequestBody AcademicEvent event) {
        return service.submit(event);
    }

    // PUT /api/events/{id}
    @PutMapping("/{id}")
    public AcademicEvent update(@PathVariable Long id,
                                @RequestBody AcademicEvent event) {
        event.setId(id);
        return service.submit(event);
    }

    // GET /api/events/branch/{branchId}
    @GetMapping("/branch/{branchId}")
    public List<AcademicEvent> getByBranch(@PathVariable Long branchId) {
        return service.getByBranch(branchId);
    }

    // GET /api/events/{id}
    @GetMapping("/{id}")
    public AcademicEvent getById(@PathVariable Long id) {
        return service.findByIds(List.of(id)).get(0);
    }

    // GET /api/events
    @GetMapping
    public List<AcademicEvent> getAll() {
        return service.findByIds(List.of());
    }
}
*/
// src/main/java/com/example/demo/controller/UserAccountController.java
package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/register")
    public UserAccount registerUser(@RequestBody RegisterRequest request) {
        UserAccount ua = new UserAccount();
        ua.setName(request.getName());
        ua.setEmail(request.getEmail());
        ua.setPassword(request.getPassword());
        ua.setRole(request.getRole());
        ua.setDepartment(request.getDepartment());
        return userAccountService.register(ua);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest request) {
        // Normally JWT generation and authentication happens here
        return "Login simulated for " + request.getEmail();
    }
}

// src/main/java/com/example/demo/controller/BranchProfileController.java
package com.example.demo.controller;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    @Autowired
    private BranchProfileService branchProfileService;

    @PostMapping
    public BranchProfile createBranch(@RequestBody BranchProfile branch) {
        return branchProfileService.createBranch(branch);
    }

    @GetMapping
    public List<BranchProfile> getAllBranches() {
        return branchProfileService.getAllBranches();
    }

    @PatchMapping("/{id}/status")
    public BranchProfile updateBranchStatus(@PathVariable Long id, @RequestParam Boolean active) {
        return branchProfileService.updateBranchStatus(id, active);
    }
}

// src/main/java/com/example/demo/controller/AcademicEventController.java
package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    @Autowired
    private AcademicEventService academicEventService;

    @PostMapping
    public AcademicEvent createEvent(@RequestBody AcademicEvent event) {
        return academicEventService.createEvent(event);
    }

    @GetMapping("/branch/{branchId}")
    public List<AcademicEvent> getEventsByBranch(@PathVariable Long branchId) {
        return academicEventService.getEventsByBranch(branchId);
    }
}

// src/main/java/com/example/demo/controller/ClashDetectionController.java
package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
public class ClashDetectionController {

    @Autowired
    private ClashDetectionService clashDetectionService;

    @GetMapping("/event/{eventId}")
    public List<ClashRecord> getClashesForEvent(@PathVariable Long eventId) {
        return clashDetectionService.getClashesForEvent(eventId);
    }

    @GetMapping("/unresolved")
    public List<ClashRecord> getUnresolvedClashes() {
        return clashDetectionService.getUnresolvedClashes();
    }

    @PatchMapping("/{id}/resolve")
    public ClashRecord resolveClash(@PathVariable Long id) {
        return clashDetectionService.resolveClash(id);
    }
}

// src/main/java/com/example/demo/controller/EventMergeController.java
package com.example.demo.controller;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    @Autowired
    private EventMergeService eventMergeService;

    @PostMapping("/merge")
    public EventMergeRecord mergeEvents(@RequestBody List<Long> eventIds) {
        return eventMergeService.mergeEvents(eventIds, "CONFLICT_RESOLUTION");
    }

    @GetMapping("/range")
    public List<EventMergeRecord> getMergeRecordsByDate(@RequestParam LocalDate start,
                                                        @RequestParam LocalDate end) {
        return eventMergeService.getMergeRecordsByDate(start, end);
    }
}

// src/main/java/com/example/demo/controller/HarmonizedCalendarController.java
package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    @Autowired
    private HarmonizedCalendarService harmonizedCalendarService;

    @PostMapping
    public HarmonizedCalendar generateCalendar(@RequestParam String title,
                                               @RequestParam String generatedBy) {
        return harmonizedCalendarService.generateHarmonizedCalendar(title, generatedBy);
    }

    @GetMapping("/range")
    public List<HarmonizedCalendar> getCalendarsWithinRange(@RequestParam LocalDate start,
                                                            @RequestParam LocalDate end) {
        return harmonizedCalendarService.getCalendarsWithinRange(start, end);
    }
}
