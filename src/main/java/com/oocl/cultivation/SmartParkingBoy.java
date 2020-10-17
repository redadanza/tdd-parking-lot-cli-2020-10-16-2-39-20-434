package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy{

    private ParkingLot parkingLot;
    //private List<ParkingLot> parkingLotList;
    ArrayList<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
    private int numberOfLots;
    private int lotNumber = 1;
    private int max = 0;
    int largestSpace = 0;

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

        for(int i = 0; i < this.parkingLotList.size() -1; i++){
            if(this.parkingLotList.get(i).getAvailable() > max){
                max = this.parkingLotList.get(i).getAvailable();
                largestSpace = i;
            }
        }
        return this.parkingLotList.get(largestSpace).park(car);
        //return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {

        return parkingLot.fetch(parkingTicket);
    }
    public int geLotNumber(){
        return  this.parkingLotList.get(largestSpace).getLotNumber();
       // return parkingLot.getLotNumber();

    }

}
