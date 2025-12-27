package com.example.demo.repository;

import com.example.demo.entity.HarmonizedCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
package com.example.demo.repository;

import com.example.demo.entity.HarmonizedCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface HarmonizedCalendarRepository extends JpaRepository<HarmonizedCalendar, Long> {

    // FIX FOR t86: This method must exist to find records where effectiveFrom 
    // falls within the start and end dates provided by the test.
    List<HarmonizedCalendar> findByEffectiveFromBetween(LocalDate start, LocalDate end);

    // Supporting method for other calendar logic (t86 mock support)
    List<HarmonizedCalendar> findByEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(LocalDate date1, LocalDate date2);
}