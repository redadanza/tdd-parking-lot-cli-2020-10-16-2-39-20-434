package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    public void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_boy() {
        //GIVEN
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //WHEN
        ParkingTicket ticket = parkingBoy.park(car);

        //THEN
        assertNotNull(ticket);
    }
    @Test
    public void should_return_correct_car_when_fetching_given_a_correct_ticket(){
        //Given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
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
        Car carB = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket1 = parkingBoy.park(carA);
        ParkingTicket parkingTicket2 = parkingBoy.park(carB);
        //When
        Car fetchedCarA = parkingBoy.fetch(parkingTicket2);
        //Car fetchedCarB = parkingBoy.fetch(parkingTicket2);
        //Then
        assertNull(fetchedCarA);
        //assertSame(carA,fetchedCarA);
        //assertSame(carB,fetchedCarB);
    }
}
