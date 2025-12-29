package com.example.demo.repository;

import com.example.demo.entity.AcademicEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AcademicEventRepository extends JpaRepository<AcademicEvent, Long> {
    List<AcademicEvent> findByBranchId(Long branchId);
    List<AcademicEvent> findByEventType(String eventType);
    
    
    @Query("SELECT e FROM AcademicEvent e WHERE e.startDate <= :end AND e.endDate >= :start")
    List<AcademicEvent> findEventsInRange(@Param("start") LocalDate start, @Param("end") LocalDate end);
}