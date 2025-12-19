package com.example.demo.service.impl;

import com.example.demo.service.EventMergeService;
import com.example.demo.model.EventMerge;
import com.example.demo.repository.EventMergeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    @Autowired
    private EventMergeRepository eventMergeRepository;

    @Override
    public EventMerge saveEventMerge(EventMerge eventMerge) {
        return eventMergeRepository.save(eventMerge);
    }

    @Override
    public List<EventMerge> getAllEventMerges() {
        return eventMergeRepository.findAll();
    }

    @Override
    public Optional<EventMerge> getEventMergeById(Long id) {
        return eventMergeRepository.findById(id);
    }

    @Override
    public void deleteEventMerge(Long id) {
        eventMergeRepository.deleteById(id);
    }
}
