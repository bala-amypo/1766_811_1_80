package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.HarmonizedCalendar;

public interface HarmonizedCalendarRepository extends JpaRepository<HarmonizedCalendar, Long> {
}
