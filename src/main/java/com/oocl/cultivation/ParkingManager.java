package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Objects;

public class ParkingManager {
    ArrayList<ParkingLot> parkingLotList = new ArrayList<>();
    ArrayList<ParkingBoy> parkingBoyLotList = new ArrayList<>();
    ParkingLot availableSpace;

    public ParkingManager() {
    }

    public void manage(ParkingBoy parkingBoy){
        this.parkingBoyLotList.add(parkingBoy);
    }
    public void assignParkingLot(String name, ParkingLot parkingLot){
        Objects.requireNonNull(parkingBoyLotList.stream().filter(parkingBoy -> name.equals(parkingBoy.getName())).findAny().orElse(null)).manage(parkingLot);
    }
    public ParkingTicket parkingBoyPark(CarParked car, String parkingBoyName){

       return Objects.requireNonNull(parkingBoyLotList.stream().filter(parkingBoy -> parkingBoyName.equals(parkingBoy.getName())).findAny().orElse(null)).park(car);

    }
    public ParkingTicket park(CarParked car) {
        availableSpace = this.parkingLotList.stream().filter(parkingLot->parkingLot.getOccupied() != 10).findAny().orElseThrow(()->new NotEnoughPositionException("Not enough position"));

        return availableSpace.park(car);
    }


    public CarParked fetch(ParkingTicket parkingTicket, String parkingBoyName) {
        return Objects.requireNonNull(this.parkingBoyLotList.stream().filter(parkingBoy -> parkingBoyName.equals(parkingBoy.getName())).findAny().orElse(null)).fetch(parkingTicket);

    }
    public int geLotNumber(){
        return availableSpace.getLotNumber();
    }
    public String getParkingBoy(ParkingTicket ticket, CarParked car){
        return Objects.requireNonNull(this.parkingBoyLotList.stream().filter(parkingLot -> car.equals(parkingLot.fetch(ticket))).findAny().orElse(null)).getName();
    }
}
