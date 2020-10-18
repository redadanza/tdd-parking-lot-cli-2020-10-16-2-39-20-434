package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingBoy {

    private ArrayList<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
    ParkingLot availableSpace = null;
    int value;
    int index=0;

    public ParkingBoy() {
        ParkingLot parkingLot = new ParkingLot();
    }
    public void manage(ParkingLot parkingLot){
        this.parkingLotList.add(parkingLot);
    }

    public ParkingTicket park(Car car) {
        for(ParkingLot parkingLot: this.parkingLotList){
            value = parkingLot.getOccupied();
            availableSpace = value != 10 ? parkingLot
                            :availableSpace;
        }
        try {
            return availableSpace.park(car);
        }
        catch (Exception e){throw new NotEnoughPositionException("Not enough position");}
    }

    public Car fetch(ParkingTicket parkingTicket) {

        return availableSpace.fetch(parkingTicket);
    }
    public int geLotNumber(){

        return availableSpace.getLotNumber();
    }

}
