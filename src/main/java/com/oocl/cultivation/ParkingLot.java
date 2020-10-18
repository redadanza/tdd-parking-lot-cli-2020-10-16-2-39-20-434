package com.oocl.cultivation;

import java.util.*;

public class ParkingLot {
    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();
    private ArrayList<Car> ticketList = new ArrayList<Car>();
    private int capacity;
    private int occupied;
    private int lotNumber;
    private int numberOfLots;
    private int lotsFull = 0;
    String status = "";

    public ParkingLot(int capacity,int occupied, int lotNumber){
            this.capacity = capacity;
            this.occupied = occupied;
            this.lotNumber = lotNumber;
            this.numberOfLots = 1;
    }
    public ParkingLot(int occupied, int lotNumber) {
        this.capacity = 10;
        this.occupied = occupied;
        this.lotNumber = lotNumber;
        this.numberOfLots = 1;
    }
    public ParkingLot(){
        this.capacity = 10;
        this.occupied = 0;
        this.lotNumber = 1;
        this.numberOfLots = 1;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOccupied() {
        return occupied;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket ticket = new ParkingTicket();

        if(ticketCarMap.size() == capacity || occupied == capacity)
        {
            lotsFull++;
            if(lotsFull == numberOfLots) {
                throw new NotEnoughPositionException("Not enough position");
            }
            else{
                lotNumber++;
                capacity += 10;
                ticketCarMap.put(ticket,car);
            }
        }
        else {
            ticketCarMap.put(ticket, car);
        }
        return ticket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car car = ticketCarMap.get(parkingTicket);
        if(car == null){
            throw new ProvideTicketException("Please provide your parking ticket.");
        }
       status = ticketList.contains(car) ? "exist"
               : "new car";

        Car ticket = new Car();
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
