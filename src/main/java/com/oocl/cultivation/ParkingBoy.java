package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingBoy {

    public static final int FULL_PARKING = 10;
    private ArrayList<ParkingLot> parkingLotList = new ArrayList<>();
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
        availableSpace = this.parkingLotList.stream().filter(parkingLot->parkingLot.getOccupied() != FULL_PARKING).findAny().orElseThrow(()->new NotEnoughPositionException("Not enough position"));

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
