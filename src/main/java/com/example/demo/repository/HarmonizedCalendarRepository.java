/*package com.example.demo.repository;

import com.example.demo.entity.HarmonizedCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HarmonizedCalendarRepository
        extends JpaRepository<HarmonizedCalendar, Long> {

    List<HarmonizedCalendar>
    findByEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
            LocalDate from, LocalDate to);
}
*/
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

    // Method for t86 (Mocked in tests)
    List<HarmonizedCalendar> findByEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(LocalDate date1, LocalDate date2);

    // FIX: Add this method to resolve the Compilation Error
    List<HarmonizedCalendar> findByEffectiveFromBetween(LocalDate start, LocalDate end);
}