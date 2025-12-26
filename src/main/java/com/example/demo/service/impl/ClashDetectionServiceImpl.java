package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.ClashRecord;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordRepository repository;

    public ClashDetectionServiceImpl(ClashRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClashRecord> detectClashes(List<AcademicEvent> events) {
        return events.stream()
                .flatMap(e1 ->
                        events.stream()
                                .filter(e2 -> !e1.equals(e2) && isClashing(e1, e2))
                                .map(e2 -> new ClashRecord())
                )
                .distinct()
                .collect(Collectors.toList());
    }

    private boolean isClashing(AcademicEvent e1, AcademicEvent e2) {
        return !e1.getEndDate().isBefore(e2.getStartDate()) &&
               !e2.getEndDate().isBefore(e1.getStartDate());
    }

    @Override
    public ClashRecord save(ClashRecord record) {
        return repository.save(record);
    }

    @Override
    public ClashRecord update(Long id, ClashRecord record) {
        ClashRecord existing = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("ClashRecord not found with id: " + id));

        existing.setEvent1(record.getEvent1());
        existing.setEvent2(record.getEvent2());
        existing.setDescription(record.getDescription());

        return repository.save(existing);
    }

    @Override
    public ClashRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("ClashRecord not found with id: " + id));
    }

    @Override
    public List<ClashRecord> getAll() {
        return repository.findAll();
    }
}
