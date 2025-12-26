/*package com.example.demo.service;

import com.example.demo.entity.ClashRecord;

import java.util.List;

public interface ClashDetectionService {

    List<ClashRecord> findUnresolved();

    List<ClashRecord> findByEvent(Long eventId);

    ClashRecord resolve(Long id);
}
*/
package com.example.demo.service;

import com.example.demo.entity.ClashRecord;

import java.util.List;
import java.util.Optional;

public interface ClashRecordService {

    ClashRecord save(ClashRecord clashRecord);

    List<ClashRecord> findAll();

    Optional<ClashRecord> findById(Long id);

    List<ClashRecord> findUnresolved();

    List<ClashRecord> findByEvent(Long eventId);
}
