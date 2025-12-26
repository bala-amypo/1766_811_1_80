/*package com.example.demo.service;

import com.example.demo.entity.EventMergeRecord;

import java.util.List;

public interface EventMergeService {

    EventMergeRecord mergeEvents(List<Long> eventIds, String reason);
}
*/
package com.example.demo.service;

import com.example.demo.entity.EventMergeRecord;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventMergeRecordService {

    EventMergeRecord save(EventMergeRecord record);

    List<EventMergeRecord> findAll();

    Optional<EventMergeRecord> findById(Long id);

    List<EventMergeRecord> findBetweenDates(LocalDate start, LocalDate end);
}

