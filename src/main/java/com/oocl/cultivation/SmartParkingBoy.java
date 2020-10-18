package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy{

    private ParkingLot parkingLot;
    ArrayList<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
    private int numberOfLots;
    private int max = 0;
    int largestSpace = 0;

    public SmartParkingBoy(int numberOfLots) {
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

        for(int i = 0; i < this.parkingLotList.size() -1; i++){
            if(this.parkingLotList.get(i).getAvailable() > max){
                max = this.parkingLotList.get(i).getAvailable();
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
