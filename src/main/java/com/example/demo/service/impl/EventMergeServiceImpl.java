// // package com.example.demo.service.impl;

// // import com.example.demo.entity.EventMergeRecord;
// // import com.example.demo.exception.ResourceNotFoundException;
// // import com.example.demo.repository.AcademicEventRepository;
// // import com.example.demo.repository.EventMergeRecordRepository;
// // import com.example.demo.service.EventMergeService;
// // import org.springframework.stereotype.Service;

// // import java.time.LocalDate;
// // import java.util.List;
// // import java.util.stream.Collectors;

// // @Service
// // public class EventMergeServiceImpl implements EventMergeService {
    
// //     private final EventMergeRecordRepository eventMergeRecordRepository;
// //     private final AcademicEventRepository academicEventRepository;
    
// //     public EventMergeServiceImpl(EventMergeRecordRepository eventMergeRecordRepository, 
// //                                 AcademicEventRepository academicEventRepository) {
// //         this.eventMergeRecordRepository = eventMergeRecordRepository;
// //         this.academicEventRepository = academicEventRepository;
// //     }
    
// //     @Override
// //     public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {
// //         for (Long eventId : eventIds) {
// //             if (!academicEventRepository.existsById(eventId)) {
// //                 throw new ResourceNotFoundException("Event not found with id: " + eventId);
// //             }
// //         }
        
// //         String sourceEventIds = eventIds.stream()
// //                 .map(String::valueOf)
// //                 .collect(Collectors.joining(","));
        
// //         EventMergeRecord mergeRecord = new EventMergeRecord();
// //         mergeRecord.setSourceEventIds(sourceEventIds);
// //         mergeRecord.setMergeReason(reason);
        
// //         return eventMergeRecordRepository.save(mergeRecord);
// //     }
    
// //     @Override
// //     public List<EventMergeRecord> getAllMergeRecords() {
// //         return eventMergeRecordRepository.findAll();
// //     }
    
// //     @Override
// //     public EventMergeRecord getMergeRecordById(Long id) {
// //         return eventMergeRecordRepository.findById(id)
// //                 .orElseThrow(() -> new ResourceNotFoundException("Merge record not found with id: " + id));
// //     }
    
// //     @Override
// //     public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
// //         // CORRECT: Matches the method name in your EventMergeRecordRepository
// //         return eventMergeRecordRepository.findByMergedStartDateBetween(start, end);
// //     }
// // }


// package com.example.demo.service.impl;

// import com.example.demo.entity.EventMergeRecord;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.AcademicEventRepository;
// import com.example.demo.repository.EventMergeRecordRepository;
// import com.example.demo.service.EventMergeService;
// import org.springframework.stereotype.Service;

// import java.time.LocalDate;
// import java.util.List;
// import java.util.stream.Collectors;

// @Service
// public class EventMergeServiceImpl implements EventMergeService {
    
//     private final EventMergeRecordRepository eventMergeRecordRepository;
//     private final AcademicEventRepository academicEventRepository;
    
//     public EventMergeServiceImpl(EventMergeRecordRepository eventMergeRecordRepository, 
//                                 AcademicEventRepository academicEventRepository) {
//         this.eventMergeRecordRepository = eventMergeRecordRepository;
//         this.academicEventRepository = academicEventRepository;
//     }
    
//     @Override
//     public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {
//         // FIX FOR t82: The test expects this exception if the input list doesn't yield events
//         if (eventIds == null || eventIds.isEmpty()) {
//             throw new ResourceNotFoundException("No events found");
//         }

//         // FIX FOR t81: Ensure the "Event not found with id: X" message is thrown
//         for (Long eventId : eventIds) {
//             if (!academicEventRepository.existsById(eventId)) {
//                 throw new ResourceNotFoundException("Event not found with id: " + eventId);
//             }
//         }
        
//         String sourceEventIds = eventIds.stream()
//                 .map(String::valueOf)
//                 .collect(Collectors.joining(","));
        
//         EventMergeRecord mergeRecord = new EventMergeRecord();
//         mergeRecord.setSourceEventIds(sourceEventIds);
//         mergeRecord.setMergeReason(reason);
        
//         // This build the record and returns it to pass t81
//         return eventMergeRecordRepository.save(mergeRecord);
//     }
    
//     @Override
//     public List<EventMergeRecord> getAllMergeRecords() {
//         return eventMergeRecordRepository.findAll();
//     }
    
//     @Override
//     public EventMergeRecord getMergeRecordById(Long id) {
//         return eventMergeRecordRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Merge record not found with id: " + id));
//     }
    
//     @Override
//     public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
//         return eventMergeRecordRepository.findByMergedStartDateBetween(start, end);
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventMergeServiceImpl implements EventMergeService {
    
    private final EventMergeRecordRepository eventMergeRecordRepository;
    private final AcademicEventRepository academicEventRepository;
    
    public EventMergeServiceImpl(EventMergeRecordRepository eventMergeRecordRepository, 
                                AcademicEventRepository academicEventRepository) {
        this.eventMergeRecordRepository = eventMergeRecordRepository;
        this.academicEventRepository = academicEventRepository;
    }
    
    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {
        // 1. Validate Input (Satisfies t82)
        if (eventIds == null || eventIds.isEmpty()) {
            throw new ResourceNotFoundException("No events found");
        }

        // 2. Fetch and Validate Existence (Satisfies t81)
        List<AcademicEvent> events = academicEventRepository.findAllById(eventIds);
        
        // Ensure every ID requested exists in the DB
        for (Long id : eventIds) {
            boolean exists = events.stream().anyMatch(e -> e.getId().equals(id));
            if (!exists) {
                throw new ResourceNotFoundException("Event not found with id: " + id);
            }
        }

        // 3. Prepare Merged Data
        // Convert IDs to a comma-separated string for auditing
        String sourceEventIdsCsv = eventIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        // Determine merged start/end dates (taking the earliest start and latest end)
        LocalDate mergedStart = events.stream()
                .map(AcademicEvent::getStartDate)
                .min(LocalDate::compareTo)
                .orElse(LocalDate.now());

        LocalDate mergedEnd = events.stream()
                .map(AcademicEvent::getEndDate)
                .max(LocalDate::compareTo)
                .orElse(LocalDate.now());

        // 4. Create and Save Record
        EventMergeRecord mergeRecord = new EventMergeRecord();
        mergeRecord.setSourceEventIds(sourceEventIdsCsv);
        mergeRecord.setMergeReason(reason);
        mergeRecord.setMergedTitle("Merged Event: " + reason);
        mergeRecord.setMergedStartDate(mergedStart);
        mergeRecord.setMergedEndDate(mergedEnd);
        mergeRecord.setCreatedAt(LocalDateTime.now());
        
        return eventMergeRecordRepository.save(mergeRecord);
    }
    
    @Override
    public List<EventMergeRecord> getAllMergeRecords() {
        return eventMergeRecordRepository.findAll();
    }
    
    @Override
    public EventMergeRecord getMergeRecordById(Long id) {
        return eventMergeRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Merge record not found with id: " + id));
    }
    
    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        return eventMergeRecordRepository.findByMergedStartDateBetween(start, end);
    }
}