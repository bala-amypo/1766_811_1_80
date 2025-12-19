package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.HarmonizedCalendar;

public interface HarmonizedCalendarService {
    HarmonizedCalendar save(HarmonizedCalendar calendar);
    List<HarmonizedCalendar> getAll();
}
