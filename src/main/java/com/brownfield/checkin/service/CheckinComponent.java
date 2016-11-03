package com.brownfield.checkin.service;

import com.brownfield.checkin.entity.CheckInRecord;
import com.brownfield.checkin.repository.CheckinRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
@Slf4j
public class CheckinComponent {

    private CheckinRepository checkinRepository;
    private Sender sender;

    @Autowired
    CheckinComponent(CheckinRepository checkinRepository, Sender sender) {
        this.checkinRepository = checkinRepository;
        this.sender = sender;
    }

    public long checkIn(CheckInRecord checkIn) {
        checkIn.setCheckInTime(new Date());
        log.info("Saving checkin ");
        //save
        long id = checkinRepository.save(checkIn).getId();
        log.info("Successfully saved checkin ");
        //send a message back to booking to update status
        log.info("Sending booking id " + id);
        sender.send(id);
        return id;

    }

    public Optional<CheckInRecord> getCheckInRecord(long id) {
        return Optional.ofNullable(checkinRepository.findOne(id));
    }

}	
