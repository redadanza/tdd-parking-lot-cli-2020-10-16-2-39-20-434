package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Comparator;

public class SuperSmartParkingBoy{
    ArrayList<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();

    ParkingLot parkingLot;

    public SuperSmartParkingBoy() {
        ParkingLot parkingLot = new ParkingLot();
    }
    public void manage(ParkingLot parkingLot){
        this.parkingLotList.add(parkingLot);
    }

    public ParkingTicket park(CarParked car) {
        parkingLot = this.parkingLotList.stream().max(Comparator.comparing(ParkingLot::getRatio)).get();
        return  parkingLot.park(car);
    }

    public CarParked fetch(ParkingTicket parkingTicket) {
        return parkingLot.fetch(parkingTicket);
    }
    public int geLotNumber(){
        return parkingLot.getLotNumber();
    }


}
