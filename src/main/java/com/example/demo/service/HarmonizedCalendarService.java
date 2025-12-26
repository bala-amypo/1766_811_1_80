// HarmonizedCalendarService.java
package com.example.demo.service;

import com.example.demo.entity.HarmonizedCalendar;
import java.util.List;

public interface HarmonizedCalendarService {
    HarmonizedCalendar create(HarmonizedCalendar calendar);
    HarmonizedCalendar update(Long id, HarmonizedCalendar calendar);
    HarmonizedCalendar getById(Long id);
    List<HarmonizedCalendar> getAll();
    void delete(Long id);
}
