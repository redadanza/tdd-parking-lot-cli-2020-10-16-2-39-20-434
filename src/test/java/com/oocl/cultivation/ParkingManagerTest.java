package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingManagerTest {
    @Test
    public void should_return_red_when_given_car_to_manager_and_asked_red_to_park() {
        //GIVEN
        Car car = new Car();
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.manage(new ParkingBoy(),"red");
        //WHEN
        ParkingTicket ticket = parkingManager.parkingBoyPark(car,"red");

        //THEN
        assertEquals("red",parkingManager.getParkingBoy());
    }
    @Test
    public void should_return_flash_when_given_car_to_manager_and_asked_red_to_park() {
        //GIVEN
        Car car = new Car();
        Car car2 = new Car();
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.manage(new ParkingBoy(),"red");
        parkingManager.manage(new ParkingBoy(),"flash");
        ParkingTicket ticket = parkingManager.parkingBoyPark(car,"red");
        ParkingTicket ticket2 = parkingManager.parkingBoyPark(car,"flash");
        //WHEN

        Exception exception = assertThrows(ProvideTicketException.class, () -> parkingManager.fetch(ticket,"flash"));
        //THEN
        assertEquals("Please provide your parking ticket.",exception.getMessage());

    }
}
