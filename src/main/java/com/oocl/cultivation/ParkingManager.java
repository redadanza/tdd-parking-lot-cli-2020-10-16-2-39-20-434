package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingManager {
    ArrayList<ParkingLot> parkingLotList = new ArrayList<>();
    ArrayList<ParkingBoy> parkingBoyLotList = new ArrayList<>();
    ParkingLot availableSpace;

    public ParkingManager() {
    }

    public void manage(ParkingBoy parkingBoy, String name){
        this.parkingBoyLotList.add(parkingBoy);
    }
    public void assignParkingLot(String name, ParkingLot parkingLot){

        parkingBoyLotList.stream().filter(x->name.equals(x.getName())).findAny().orElse(null).manage(parkingLot);
    }
    public ParkingTicket parkingBoyPark(CarParked car, String name){

       return parkingBoyLotList.stream().filter(x -> name.equals(x.getName())).findAny().orElse(null).park(car);

    }
    public ParkingTicket park(CarParked car) {
        availableSpace = this.parkingLotList.stream().filter(x->x.getOccupied() != 10).findAny().orElseThrow(()->new NotEnoughPositionException("Not enough position"));

        return availableSpace.park(car);
    }


    public CarParked fetch(ParkingTicket parkingTicket, String name) {
        return this.parkingBoyLotList.stream().filter(x -> name.equals(x.getName())).findAny().orElse(null).fetch(parkingTicket);

    }
    public int geLotNumber(){
        return availableSpace.getLotNumber();
    }
    public String getParkingBoy(ParkingTicket ticket, CarParked car){
        return this.parkingBoyLotList.stream().filter(x -> car.equals(x.fetch(ticket))).findAny().orElse(null).getName();
    }
}
