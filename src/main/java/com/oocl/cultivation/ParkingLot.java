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
    private int numberOfLots;
    private int lotsFull = 0;
    String status = "";

//    public ParkingLot(int occupied) {
//        this.capacity = 10;
//        this.occupied = occupied;
//        this.numberOfLots = 1;
//        this.lotNumber = 1;
//    }
//    public ParkingLot(int capacity,int occupied, int numberOfLots) {
//        this.capacity = capacity;
//        this.occupied = occupied;
//        this.numberOfLots = numberOfLots;
//        this.lotNumber = 1;
//    }
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
        //this.lotNumber = 1;
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
    public ParkingTicket smartPark(Car car){
        ParkingTicket ticket = new ParkingTicket();

        return ticket;
    }
    public int getAvailable(){
        return capacity - occupied;
    }
    public double getRatio(){
        return capacity/occupied;
    }
}
