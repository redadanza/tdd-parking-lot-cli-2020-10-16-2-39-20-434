package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertNotNull(ticket);
    }
    @Test
    public void should_return_correct_car_when_fetching_given_a_correct_ticket(){
        //Given
        Car car = new Car();
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.manage(new ParkingBoy(),"red");
        ParkingTicket ticket = parkingManager.parkingBoyPark(car,"red");

        //When
        Car fetchedCar = parkingManager.fetch(ticket,"red");

        //Then
        assertSame(car,fetchedCar);
    }
    @Test
    public void should_return_correct_cars_when_fetching_given_two_tickets(){
        //Given
        Car carA = new Car();
        Car carB = new Car();
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.manage(new ParkingBoy(),"red");
        parkingManager.manage(new ParkingBoy(),"flash");
        ParkingTicket ticket = parkingManager.parkingBoyPark(carA,"red");
        ParkingTicket ticket2 = parkingManager.parkingBoyPark(carB,"flash");

        //When
        Car fetchedCarA = parkingManager.fetch(ticket,"red");
        Car fetchedCarB = parkingManager.fetch(ticket2,"flash");
        //Then
        assertSame(carA,fetchedCarA);
        assertSame(carB,fetchedCarB);
    }
    @Test
    public void should_return_no_cars_when_fetching_given_wrong_tickets(){
        //Given
        Car carA = new Car();
        Car carB = new Car();
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.manage(new ParkingBoy(),"red");
        parkingManager.manage(new ParkingBoy(),"flash");
        ParkingTicket ticket = parkingManager.parkingBoyPark(carA,"red");
        ParkingTicket ticket2 = parkingManager.parkingBoyPark(carB,"flash");

        //When
        //Car fetchedCarA = parkingBoy.fetch(parkingTicket2);
        Exception exception = assertThrows(ProvideTicketException.class, () ->  parkingManager.fetch(ticket,"flash"));
        //Then
        //assertNull(fetchedCarA);
        assertEquals("Please provide your parking ticket.",exception.getMessage());
    }
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
    public void should_not_return_flash_when_given_car_to_manager_and_asked_red_to_park() {
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
