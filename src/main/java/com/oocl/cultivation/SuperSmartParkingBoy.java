package com.oocl.cultivation;

import java.util.ArrayList;

public class SuperSmartParkingBoy{
    private ParkingLot parkingLot;
    ArrayList<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
    private int numberOfLots;
    private double max = 0;
    int largestSpace = 0;

    public SuperSmartParkingBoy(int numberOfLots) {
        this.numberOfLots = numberOfLots;
    }
    public SuperSmartParkingBoy() {
        ParkingLot parkingLot = new ParkingLot();
        this.parkingLot = parkingLot;
    }
    public void manage(ParkingLot parkingLot){
        this.parkingLotList.add(parkingLot);
    }

    public ParkingTicket park(Car car) {

        for(int i = 0; i < this.parkingLotList.size(); i++){
            if(this.parkingLotList.get(i).getRatio() >= max){
                max = this.parkingLotList.get(i).getRatio();
                largestSpace = i;
            }
        }
        return this.parkingLotList.get(largestSpace).park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return this.parkingLotList.get(largestSpace).fetch(parkingTicket);
    }
    public int geLotNumber(){
        return  this.parkingLotList.get(largestSpace).getLotNumber();

    }


}
