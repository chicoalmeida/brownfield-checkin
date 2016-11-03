package com.brownfield.checkin.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface CheckInSource {
    String CHECKINQ = "checkInQ";

    @Output("checkInQ")
    MessageChannel checkInQ();

}