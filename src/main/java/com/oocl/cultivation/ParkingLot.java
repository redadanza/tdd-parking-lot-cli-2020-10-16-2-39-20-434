package com.oocl.cultivation;

import java.util.*;

public class ParkingLot {
    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();
    private ArrayList<Car> ticketList = new ArrayList<Car>();
    private Car car = new Car();
    private Car ticket = new Car();

    public ParkingTicket park(Car car) {
        ParkingTicket ticket = new ParkingTicket();
        ticketCarMap.put(ticket,car);
        return ticket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        //System.out.println(ticketCarMap.get(parkingTicket));
        car = ticketCarMap.get(parkingTicket);

       ticket = ticketList.contains(car) ? null
               : ticketCarMap.get(parkingTicket);

       if(ticket == null) {
           return null;
       }
       else {
           ticketList.add(car);
       }

        return ticket;
    }
}
