package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperSmartParkingBoyTest {
    @Test
    public void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_boy() {
        //GIVEN
        Car car = new Car();
        //ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy();
        parkingBoy.manage(new ParkingLot(0,1));
        //WHEN
        ParkingTicket ticket = parkingBoy.park(car);

        //THEN
        assertNotNull(ticket);
    }
    @Test
    public void should_return_a_parking_lot1_when_parking_boy_manages_2_lots_and_lot1_has_more_spaces() {
        //GIVEN
        Car car = new Car();
        //ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(2);
        parkingBoy.manage(new ParkingLot(15,3,1));
        parkingBoy.manage(new ParkingLot(20,5,2));
        //WHEN
        ParkingTicket ticket = parkingBoy.park(car);

        //THEN
        //assertNotNull(ticket);
        assertEquals(1, parkingBoy.geLotNumber());
    }
}
