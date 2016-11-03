package com.brownfield.checkin.controller;

import com.brownfield.checkin.entity.CheckInRecord;
import com.brownfield.checkin.service.CheckinComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/checkin")
public class CheckInController {

    private CheckinComponent checkInComponent;

    @Autowired
    public CheckInController(CheckinComponent checkInComponent) {
        this.checkInComponent = checkInComponent;
    }

    @RequestMapping("/get/{id}")
    private ResponseEntity<CheckInRecord> getCheckIn(@PathVariable long id) {
        return new ResponseEntity<>(checkInComponent.getCheckInRecord(id).get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ResponseEntity<Long> checkIn(@RequestBody CheckInRecord checkIn) {
        return new ResponseEntity<>(checkInComponent.checkIn(checkIn), HttpStatus.OK);
    }

}
