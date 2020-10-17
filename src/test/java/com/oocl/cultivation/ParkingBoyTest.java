package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    public void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_boy() {
        //GIVEN
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.manage(new ParkingLot());

        //WHEN
        ParkingTicket ticket = parkingBoy.park(car);

        //THEN
        assertNotNull(ticket);
    }
    @Test
    public void should_return_correct_car_when_fetching_given_a_correct_ticket(){
        //Given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.manage(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(car);
        //When
        Car fetchedCar = parkingBoy.fetch(parkingTicket);
        //Then
        assertSame(car,fetchedCar);
    }
    @Test
    public void should_return_correct_cars_when_fetching_given_two_tickets(){
        //Given
        Car carA = new Car();
        Car carB = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.manage(new ParkingLot());
        ParkingTicket parkingTicket1 = parkingBoy.park(carA);
        ParkingTicket parkingTicket2 = parkingBoy.park(carB);
        //When
        Car fetchedCarA = parkingBoy.fetch(parkingTicket1);
        Car fetchedCarB = parkingBoy.fetch(parkingTicket2);
        //Then
        assertSame(carA,fetchedCarA);
        assertSame(carB,fetchedCarB);
    }
    @Test
    public void should_return_no_cars_when_fetching_given_wrong_tickets(){
        //Given
        Car carA = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.manage(new ParkingLot());
        ParkingTicket parkingTicket1 = parkingBoy.park(carA);
        ParkingTicket parkingTicket2 = new ParkingTicket();

        //When
        //Car fetchedCarA = parkingBoy.fetch(parkingTicket2);
        Exception exception = assertThrows(ProvideTicketException.class, () ->  parkingBoy.fetch(parkingTicket2));
        //Then
        //assertNull(fetchedCarA);
        assertEquals("Please provide your parking ticket.",exception.getMessage());
    }
    @Test
    public void should_return_no_cars_when_fetching_given_no_ticket(){
        //Given
        Car carA = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.manage(new ParkingLot());
        ParkingTicket parkingTicket1 = parkingBoy.park(carA);

        //When
        Exception exception = assertThrows(ProvideTicketException.class, () ->  parkingBoy.fetch(null));
        //Then
        assertEquals("Please provide your parking ticket.",exception.getMessage());
        //assertNull(fetchedCarA);
    }
    @Test
    public void should_return_no_cars_when_fetching_given_used_ticket(){
        //Given
        Car carA = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.manage(new ParkingLot());
        ParkingTicket parkingTicket1 = parkingBoy.park(carA);

        //When
        Car fetchedCarA = parkingBoy.fetch(parkingTicket1);
        //Car fetchedCarB = parkingBoy.fetch(parkingTicket1);
        Exception exception = assertThrows(UnrecognizedParkingTicket.class, () -> parkingBoy.fetch(parkingTicket1));
        //Then

        //assertNull(fetchedCarB);
        assertEquals("Unrecognized Parking Ticket",exception.getMessage());
    }
    @Test
    public void should_return_no_ticket_when_car_park_is_full(){
        //Given
        Car carA = new Car();

        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.manage(new ParkingLot(10,1));
        //ParkingTicket parkingTicket1 = parkingBoy.park(carA);

        //When
        Exception exception = assertThrows(NotEnoughPositionException.class, () -> parkingBoy.park(carA));

        //Then
        assertEquals("Not enough position",exception.getMessage());
    }

    @Test
    public void should_return_parking2_when_parking1_full_given_car_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.manage(new ParkingLot(10,1));
        parkingBoy.manage(new ParkingLot(3,2));

        //WHEN
        ParkingTicket ticket = parkingBoy.park(car);

        //THEN
        assertEquals(2, parkingBoy.geLotNumber());
        //parkingBoy.geLotNumber()
        assertNotNull(ticket);
    }
    @Test
    public void should_return_parking1_when_parking1_notFull_given_car_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.manage(new ParkingLot(9,1));
        //WHEN
        ParkingTicket ticket = parkingBoy.park(car);

        //THEN
        assertEquals(1, parkingBoy.geLotNumber());
        //parkingBoy.geLotNumber()
        assertNotNull(ticket);
    }
}
