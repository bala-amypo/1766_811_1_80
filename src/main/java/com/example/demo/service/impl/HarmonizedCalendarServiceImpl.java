// HarmonizedCalendarServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

    @Autowired
    private HarmonizedCalendarRepository repository;

    @Override
    public HarmonizedCalendar create(HarmonizedCalendar calendar) { return repository.save(calendar); }

    @Override
    public HarmonizedCalendar update(Long id, HarmonizedCalendar calendar) {
        calendar.setId(id);
        return repository.save(calendar);
    }

    @Override
    public HarmonizedCalendar getById(Long id) { return repository.findById(id).orElse(null); }

    @Override
    public List<HarmonizedCalendar> getAll() { return repository.findAll(); }

    @Override
    public void delete(Long id) { repository.deleteById(id); }
}
