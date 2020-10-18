package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{
    ArrayList<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
    private int max = 0;
    int largestSpace = 0;

    public SmartParkingBoy(int numberOfLots) {
    }
    public SmartParkingBoy() {
        ParkingLot parkingLot = new ParkingLot();
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
