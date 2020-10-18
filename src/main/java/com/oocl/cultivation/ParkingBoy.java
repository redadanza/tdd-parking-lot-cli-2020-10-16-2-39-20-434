package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingBoy {

    ArrayList<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
    int availableSpace = 0;
    int value;

    public ParkingBoy() {
        ParkingLot parkingLot = new ParkingLot();
    }
    public void manage(ParkingLot parkingLot){
        this.parkingLotList.add(parkingLot);
    }

    public ParkingTicket park(Car car) {

        for(int i = 0; i < this.parkingLotList.size(); i++){
            value = this.parkingLotList.get(i).getOccupied();
            availableSpace = value != 10 ? i
                            : availableSpace;
        }
        return this.parkingLotList.get(availableSpace).park(car);
    }


    public Car fetch(ParkingTicket parkingTicket) {
        return this.parkingLotList.get(availableSpace).fetch(parkingTicket);
    }
    public int geLotNumber(){
        return this.parkingLotList.get(availableSpace).getLotNumber();

    }

}
