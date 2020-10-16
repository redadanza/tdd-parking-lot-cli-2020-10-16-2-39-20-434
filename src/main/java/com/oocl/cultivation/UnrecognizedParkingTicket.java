package com.oocl.cultivation;

public class UnrecognizedParkingTicket extends RuntimeException {
    public UnrecognizedParkingTicket(String unrecognized_parking_ticket) {
        super(unrecognized_parking_ticket);
    }
}
