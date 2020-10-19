package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingBoy {

    private ArrayList<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
    ParkingLot availableSpace = null;
    private String name = "";

    public ParkingBoy() {
    }
    public ParkingBoy(String name){
        this.name = name;
    }
    public void manage(ParkingLot parkingLot){
        this.parkingLotList.add(parkingLot);
    }

    public ParkingTicket park(CarParked car) {
        availableSpace = this.parkingLotList.stream().filter(x->x.getOccupied() != 10).findAny().orElseThrow(()->new NotEnoughPositionException("Not enough position"));

        return availableSpace.park(car);
    }

    public CarParked fetch(ParkingTicket parkingTicket) {

        return availableSpace.fetch(parkingTicket);
    }
    public int geLotNumber(){

        return availableSpace.getLotNumber();
    }

    public String getName() {
        return name;
    }
}
