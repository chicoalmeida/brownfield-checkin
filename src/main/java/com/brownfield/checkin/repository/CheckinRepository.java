package com.brownfield.checkin.repository;

import com.brownfield.checkin.entity.CheckInRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckinRepository extends JpaRepository<CheckInRecord, Long> {

}
