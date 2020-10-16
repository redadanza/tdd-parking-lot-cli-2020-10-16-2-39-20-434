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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket1 = parkingBoy.park(carA);
        ParkingTicket parkingTicket2 = new ParkingTicket();
        //When
        Car fetchedCarA = parkingBoy.fetch(parkingTicket2);

        //Then
        assertNull(fetchedCarA);

    }
    @Test
    public void should_return_no_cars_when_fetching_given_no_ticket(){
        //Given
        Car carA = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket1 = parkingBoy.park(carA);

        //When
        Car fetchedCarA = parkingBoy.fetch(null);

        //Then
        assertNull(fetchedCarA);
    }
    @Test
    public void should_return_no_cars_when_fetching_given_used_ticket(){
        //Given
        Car carA = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket1 = parkingBoy.park(carA);

        //When
        Car fetchedCarA = parkingBoy.fetch(parkingTicket1);
        Car fetchedCarB = parkingBoy.fetch(parkingTicket1);
        //Then
        assertNull(fetchedCarB);
    }
    @Test
    public void should_return_no_ticket_when_car_park_is_full(){
        //Given
        Car carA = new Car();
        Car carB = new Car();
        Car carC = new Car();
        Car carD = new Car();
        Car carE = new Car();
        Car carF = new Car();
        Car carG = new Car();
        Car carH = new Car();
        Car carI = new Car();
        Car carJ = new Car();
        Car carK = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket1 = parkingBoy.park(carA);
        ParkingTicket parkingTicket2 = parkingBoy.park(carB);
        ParkingTicket parkingTicket3 = parkingBoy.park(carC);
        ParkingTicket parkingTicket4 = parkingBoy.park(carD);
        ParkingTicket parkingTicket5 = parkingBoy.park(carE);
        ParkingTicket parkingTicket6 = parkingBoy.park(carF);
        ParkingTicket parkingTicket7 = parkingBoy.park(carG);
        ParkingTicket parkingTicket8 = parkingBoy.park(carH);
        ParkingTicket parkingTicket9 = parkingBoy.park(carI);
        ParkingTicket parkingTicket10 = parkingBoy.park(carJ);

        //When
        ParkingTicket parkingTicket11 = parkingBoy.park(carK);

        //Then
        assertNull(parkingTicket11);
    }
}
