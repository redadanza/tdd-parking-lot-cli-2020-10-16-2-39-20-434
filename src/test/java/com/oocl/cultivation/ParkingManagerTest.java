package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingManagerTest {
    @Test
    public void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_boy() {
        //GIVEN
        CarParked car = new CarParked();
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.manage(new ParkingBoy("red"));
        parkingManager.assignParkingLot("red", new ParkingLot());
        //WHEN
        ParkingTicket ticket = parkingManager.parkingBoyPark(car,"red");

        //THEN
        assertNotNull(ticket);
    }
    @Test
    public void should_return_correct_car_when_fetching_given_a_correct_ticket(){
        //Given
        CarParked car = new CarParked();
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.manage(new ParkingBoy("red"));
        parkingManager.assignParkingLot("red", new ParkingLot());
        ParkingTicket ticket = parkingManager.parkingBoyPark(car,"red");

        //When
        CarParked fetchedCar = parkingManager.fetch(ticket,"red");

        //Then
        assertSame(car,fetchedCar);
    }
    @Test
    public void should_return_correct_cars_when_fetching_given_two_tickets(){
        //Given
        CarParked carA = new CarParked();
        CarParked carB = new CarParked();
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.manage(new ParkingBoy("red"));
        parkingManager.manage(new ParkingBoy("flash"));
        parkingManager.assignParkingLot("red", new ParkingLot());
        parkingManager.assignParkingLot("flash", new ParkingLot());
        ParkingTicket ticket = parkingManager.parkingBoyPark(carA,"red");
        ParkingTicket ticket2 = parkingManager.parkingBoyPark(carB,"flash");

        //When
        CarParked fetchedCarA = parkingManager.fetch(ticket,"red");
        CarParked fetchedCarB = parkingManager.fetch(ticket2,"flash");
        //Then
        assertSame(carA,fetchedCarA);
        assertSame(carB,fetchedCarB);
    }
    @Test
    public void should_return_no_cars_when_fetching_given_wrong_tickets(){
        //Given
        CarParked carA = new CarParked();
        CarParked carB = new CarParked();
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.manage(new ParkingBoy("red"));
        parkingManager.manage(new ParkingBoy("flash"));
        parkingManager.assignParkingLot("red", new ParkingLot());
        parkingManager.assignParkingLot("flash", new ParkingLot());
        ParkingTicket ticket = parkingManager.parkingBoyPark(carA,"red");
        parkingManager.parkingBoyPark(carB,"flash");

        //When
        Exception exception = assertThrows(ProvideTicketException.class, () ->  parkingManager.fetch(ticket,"flash"));

        //Then
        assertEquals("Please provide your parking ticket.",exception.getMessage());
    }
    @Test
    public void should_return_red_when_given_car_to_manager_and_asked_red_to_park() {
        //GIVEN
        CarParked car = new CarParked();
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.manage(new ParkingBoy("red"));
        parkingManager.assignParkingLot("red", new ParkingLot());
        //WHEN
        ParkingTicket ticket = parkingManager.parkingBoyPark(car,"red");

        //THEN
        assertEquals("red",parkingManager.getParkingBoy(ticket, car));
    }
    @Test
    public void should_not_return_flash_when_given_car_to_manager_and_asked_red_to_park() {
        //GIVEN
        CarParked car = new CarParked();
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.manage(new ParkingBoy("red"));
        parkingManager.manage(new ParkingBoy("flash"));
        parkingManager.assignParkingLot("red", new ParkingLot());
        parkingManager.assignParkingLot("flash", new ParkingLot());
        ParkingTicket ticket = parkingManager.parkingBoyPark(car,"red");
        parkingManager.parkingBoyPark(car,"flash");
        //WHEN
        Exception exception = assertThrows(ProvideTicketException.class, () -> parkingManager.fetch(ticket,"flash"));

        //THEN
        assertEquals("Please provide your parking ticket.",exception.getMessage());

    }
}
