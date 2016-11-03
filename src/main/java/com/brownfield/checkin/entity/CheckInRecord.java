package com.brownfield.checkin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CheckInRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String lastName;
    private String firstName;
    private String seatNumber;
    private Date checkInTime;
    private String flightNumber;
    private String flightDate;
    private Long bookingId;

}
