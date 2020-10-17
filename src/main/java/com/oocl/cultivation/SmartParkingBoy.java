package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy{

    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLotList;
    private int numberOfLots;
    private int lotNumber = 1;

    public SmartParkingBoy(int numberOfLots) {
//        ParkingLot parkingLot = new ParkingLot();
//        this.parkingLot = parkingLot;
        this.numberOfLots = numberOfLots;
    }
    public SmartParkingBoy() {
        ParkingLot parkingLot = new ParkingLot();
        this.parkingLot = parkingLot;
    }
    public void manage(ParkingLot parkingLot){
        this.parkingLotList.add(parkingLot);
    }

    public ParkingTicket park(Car car) {

        return null;
    }

    public Car fetch(ParkingTicket parkingTicket) {

        return parkingLot.fetch(parkingTicket);
    }
    public int geLotNumber(){

        return parkingLot.getLotNumber();

    }

}
