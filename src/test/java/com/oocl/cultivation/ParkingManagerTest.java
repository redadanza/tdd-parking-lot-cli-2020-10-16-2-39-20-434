package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingManagerTest {
    @Test
    public void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_boy() {
        //GIVEN
        Car car = new Car();
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.manage(new ParkingBoy(),"red");
        //WHEN
        ParkingTicket ticket = parkingManager.parkingBoyPark(car,"red");

        //THEN
        assertEquals("red",parkingManager.getParkingBoy());
    }
}
