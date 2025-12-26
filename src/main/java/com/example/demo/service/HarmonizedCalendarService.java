package com.example.demo.service;

import com.example.demo.entity.HarmonizedCalendar;

import java.util.List;

public interface HarmonizedCalendarService {

    HarmonizedCalendar save(HarmonizedCalendar calendar);

    HarmonizedCalendar update(Long id, HarmonizedCalendar calendar);

    HarmonizedCalendar getById(Long id);

    List<HarmonizedCalendar> getAll();

    List<HarmonizedCalendar> getByBranch(Long branchId);
}
