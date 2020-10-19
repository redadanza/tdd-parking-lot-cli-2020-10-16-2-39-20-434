package com.oocl.cultivation;

import java.util.*;

public class ParkingLot {
    private Map<ParkingTicket, CarParked> ticketCarMap = new HashMap<>();
    private ArrayList<CarParked> ticketList = new ArrayList<CarParked>();
    private int capacity;
    private int occupied;
    private int lotNumber;
    String status = "";
    public ParkingLot(int capacity,int occupied, int lotNumber){
            this.capacity = capacity;
            this.occupied = occupied;
            this.lotNumber = lotNumber;
    }
    public ParkingLot(int occupied, int lotNumber) {
        this.occupied = occupied;
        this.lotNumber = lotNumber;
        this.capacity = 10;
    }
    public ParkingLot(){
        this.occupied = 0;
        this.lotNumber = 1;
        this.capacity = 10;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public int getOccupied() {
        return occupied;
    }

    public ParkingTicket park(CarParked car) {
        ParkingTicket ticket = new ParkingTicket();
        if(ticketCarMap.size() == capacity || occupied == capacity)
        {
            throw new NotEnoughPositionException("Not enough position");
        }
        else {
            ticketCarMap.put(ticket, car);
        }
        return ticket;
    }

    public CarParked fetch(ParkingTicket parkingTicket) {
        CarParked car = ticketCarMap.get(parkingTicket);
        if(car == null){
            throw new ProvideTicketException("Please provide your parking ticket.");
        }
       status = ticketList.contains(car) ? "exist"
               : "new car";

        CarParked ticket = new CarParked();
        if(status.equals("exist")) {
           throw new UnrecognizedParkingTicket("Unrecognized Parking Ticket");
       }
       else {
           ticket = ticketCarMap.get(parkingTicket);
           ticketList.add(car);
       }

        return ticket;
    }
    public int getAvailable(){
        return capacity - occupied;
    }
    public double getRatio(){
        try {
            return capacity / occupied;
        }catch (Exception ignored){}
        return 0;
    }
}
