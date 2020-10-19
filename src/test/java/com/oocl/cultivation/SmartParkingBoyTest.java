package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SmartParkingBoyTest {
    @Test
    public void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_boy() {
        //GIVEN
        CarParked car = new CarParked();
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        parkingBoy.manage(new ParkingLot(0,1));
        //WHEN
        ParkingTicket ticket = parkingBoy.park(car);

        //THEN
        assertNotNull(ticket);
    }
    @Test
    public void should_return_correct_car_when_fetching_given_a_correct_ticket(){
        //Given
        CarParked car = new CarParked();
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        parkingBoy.manage(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //When
        CarParked fetchedCar = parkingBoy.fetch(parkingTicket);
        //Then
        assertSame(car,fetchedCar);
    }
    @Test
    public void should_return_correct_cars_when_fetching_given_two_tickets(){
        //Given
        CarParked carA = new CarParked();
        CarParked carB = new CarParked();
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        parkingBoy.manage(new ParkingLot());
        ParkingTicket parkingTicket1 = parkingBoy.park(carA);
        ParkingTicket parkingTicket2 = parkingBoy.park(carB);
        //When
        CarParked fetchedCarA = parkingBoy.fetch(parkingTicket1);
        CarParked fetchedCarB = parkingBoy.fetch(parkingTicket2);
        //Then
        assertSame(carA,fetchedCarA);
        assertSame(carB,fetchedCarB);
    }
    @Test
    public void should_return_no_cars_when_fetching_given_wrong_tickets(){
        //Given
        CarParked carA = new CarParked();
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        parkingBoy.manage(new ParkingLot());
        parkingBoy.park(carA);
        ParkingTicket parkingTicket2 = new ParkingTicket();

        //When

        Exception exception = assertThrows(ProvideTicketException.class, () ->  parkingBoy.fetch(parkingTicket2));
        //Then

        assertEquals("Please provide your parking ticket.",exception.getMessage());
    }
    @Test
    public void should_return_no_cars_when_fetching_given_no_ticket(){
        //Given
        CarParked carA = new CarParked();
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        parkingBoy.manage(new ParkingLot());
        parkingBoy.park(carA);

        //When
        Exception exception = assertThrows(ProvideTicketException.class, () ->  parkingBoy.fetch(null));
        //Then
        assertEquals("Please provide your parking ticket.",exception.getMessage());

    }
    @Test
    public void should_return_no_cars_when_fetching_given_used_ticket(){
        //Given
        CarParked carA = new CarParked();
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        parkingBoy.manage(new ParkingLot());
        ParkingTicket parkingTicket1 = parkingBoy.park(carA);

        //When
        parkingBoy.fetch(parkingTicket1);

        Exception exception = assertThrows(UnrecognizedParkingTicket.class, () -> parkingBoy.fetch(parkingTicket1));
        //Then


        assertEquals("Unrecognized Parking Ticket",exception.getMessage());
    }
    @Test
    public void should_return_no_ticket_when_car_park_is_full(){
        //Given
        CarParked carA = new CarParked();

        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        parkingBoy.manage(new ParkingLot(10,1));


        //When
        Exception exception = assertThrows(NotEnoughPositionException.class, () -> parkingBoy.park(carA));

        //Then
        assertEquals("Not enough position",exception.getMessage());
    }
    @Test
    public void should_return_a_parking_lot1_when_parking_boy_manages_2_lots_and_lot1_has_more_spaces() {
        //GIVEN
        CarParked car = new CarParked();

        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        parkingBoy.manage(new ParkingLot(3,1));
        parkingBoy.manage(new ParkingLot(7,2));
        //WHEN
        parkingBoy.park(car);

        //THEN

        assertEquals(1, parkingBoy.geLotNumber());
    }

}
