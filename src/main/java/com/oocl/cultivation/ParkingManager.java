package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingManager {
    //private final ParkingLot parkingLot;
    private final ParkingBoy parkingBoy;
    ArrayList<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
    ArrayList<ParkingBoy> parkingBoyLotList = new ArrayList<ParkingBoy>();
    ArrayList<String> parkingBoyName = new ArrayList<>();
    private int max = 0;
    int availableSpace = 0;
    int value;
    int index;


    public ParkingManager() {
        ParkingBoy parkingBoy = new ParkingBoy();
        this.parkingBoy = parkingBoy;
    }
//    public void manage(ParkingLot parkingLot){
//        this.parkingLotList.add(parkingLot);
//    }
    public void manage(ParkingBoy parkingBoy, String name){
        this.parkingBoyName.add(name);
        this.parkingBoyLotList.add(parkingBoy);
    }

    public ParkingTicket parkingBoyPark(Car car, String name){
         index = this.parkingBoyName.indexOf(name);
        this.parkingBoyLotList.get(index).manage(new ParkingLot());

        ParkingTicket ticket = this.parkingBoyLotList.get(index).park(car);

        return ticket;
    }
    public ParkingTicket park(Car car) {
        for(int i = 0; i < this.parkingLotList.size(); i++){
            value = this.parkingLotList.get(i).getOccupied();

            if(value == 10){
                System.out.println(this.parkingLotList.get(i).getOccupied());
            }
            else {
                availableSpace = i;
            }
        }
        System.out.println(availableSpace);
        return this.parkingLotList.get(availableSpace).park(car);
    }


    public Car fetch(ParkingTicket parkingTicket, String name) {
        index = this.parkingBoyName.indexOf(name);

        return this.parkingBoyLotList.get(index).fetch(parkingTicket);
        //return this.parkingLotList.get(availableSpace).fetch(parkingTicket);
    }
    public int geLotNumber(){

        return this.parkingLotList.get(availableSpace).getLotNumber();

    }
    public String getParkingBoy(){

        return this.parkingBoyName.get(index);
    }
}
