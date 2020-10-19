package com.oocl.cultivation;
import java.util.ArrayList;
import java.util.Comparator;

public class SmartParkingBoy extends ParkingBoy{
    ArrayList<ParkingLot> parkingLotList = new ArrayList<>();
    int largestSpace = 0;

    public SmartParkingBoy() {
    }
    public void manage(ParkingLot parkingLot){
        this.parkingLotList.add(parkingLot);
    }

    public ParkingTicket park(CarParked car) {
       availableSpace = this.parkingLotList.stream().max(Comparator.comparing(ParkingLot::getAvailable)).get();
        return this.parkingLotList.get(largestSpace).park(car);
    }
    public CarParked fetch(ParkingTicket parkingTicket) {
        return this.parkingLotList.get(largestSpace).fetch(parkingTicket);
    }
    public int geLotNumber(){
        return  this.parkingLotList.get(largestSpace).getLotNumber();
    }

}
