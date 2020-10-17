package com.oocl.cultivation;

import java.util.*;

public class ParkingLot {
    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();
    private ArrayList<Car> ticketList = new ArrayList<Car>();
    private Car car = new Car();
    private Car ticket = new Car();
    private int capacity;
    private int occupied;
    private int lotNumber;
    String status = "";

    public ParkingLot(int capacity,int occupied) {
        this.capacity = capacity;
        this.occupied = occupied;
    }
    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }
    public ParkingLot(){
        this.capacity = 10;
    }

    public int getLotNumber() {
        //this.lotNumber = 1;
        return lotNumber;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket ticket = new ParkingTicket();

        if(ticketCarMap.size() == capacity)
        {
            throw new NotEnoughPositionException("Not enough position");
        }
        else {
            ticketCarMap.put(ticket, car);
        }
        return ticket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        car = ticketCarMap.get(parkingTicket);
        if(car == null){
            throw new ProvideTicketException("Please provide your parking ticket.");
        }
       status = ticketList.contains(car) ? "exist"
               : "new car";

       if(status.equals("exist")) {
           throw new UnrecognizedParkingTicket("Unrecognized Parking Ticket");
       }
       else {
           ticket = ticketCarMap.get(parkingTicket);
           ticketList.add(car);
       }

        return ticket;
    }
}
