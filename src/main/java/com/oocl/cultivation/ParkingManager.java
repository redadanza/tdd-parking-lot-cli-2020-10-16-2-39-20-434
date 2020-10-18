package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingManager {
    ArrayList<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
    ArrayList<ParkingBoy> parkingBoyLotList = new ArrayList<ParkingBoy>();
    ArrayList<String> parkingBoyName = new ArrayList<>();
    int availableSpace = 0;
    int value;
    int index;


    public ParkingManager() {
        ParkingBoy parkingBoy = new ParkingBoy();
    }

    public void manage(ParkingBoy parkingBoy, String name){
        this.parkingBoyName.add(name);
        this.parkingBoyLotList.add(parkingBoy);
    }

    public ParkingTicket parkingBoyPark(Car car, String name){
         index = this.parkingBoyName.indexOf(name);
        this.parkingBoyLotList.get(index).manage(new ParkingLot());

        return this.parkingBoyLotList.get(index).park(car);
    }
    public ParkingTicket park(Car car) {
        for(int i = 0; i < this.parkingLotList.size(); i++){
            value = this.parkingLotList.get(i).getOccupied();
            availableSpace = value != 10 ? i
                    : availableSpace;
        }
        return this.parkingLotList.get(availableSpace).park(car);
    }


    public Car fetch(ParkingTicket parkingTicket, String name) {
        index = this.parkingBoyName.indexOf(name);
        return this.parkingBoyLotList.get(index).fetch(parkingTicket);
    }
    public int geLotNumber(){
        return this.parkingBoyLotList.get(index).geLotNumber();
    }
    public String getParkingBoy(){

        return this.parkingBoyName.get(index);
    }
}
