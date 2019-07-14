package com.thoughtworks.tdd;

import java.util.List;

public class Manager extends ParkingBoy{

    public void addBoyToLotManagerments(ParkingBoy parkingBoy, ParkingLot parkingLot) {
        List<? super ParkingBoy> parkingBoys = parkingLot.getManagements();
        parkingBoys.add(parkingBoy);
        parkingLot.setManagements(parkingBoys);
    }

    public Ticket specifyBoyToPark(ParkingBoy parkingBoy, ParkingLot parkingLot, Car car) {
        if(parkingLot.getManagements().contains(parkingBoy)){
            parkingBoy.setParkingLot(parkingLot);
            return parkingBoy.park(car);
        } else {
            throw new RuntimeException();
        }
    }

    public Car specifyBoyToFetch(ParkingBoy parkingBoy, ParkingLot parkingLot, Ticket ticket) {
        if(parkingLot.getManagements().contains(parkingBoy)){
            parkingBoy.setParkingLot(parkingLot);
            return parkingBoy.fetch(ticket);
        } else {
            throw new RuntimeException();
        }
    }

    public Ticket park(Car car, ParkingLot parkingLot) {
        if(parkingLot.getManager() == this){
            super.setParkingLot(parkingLot);
            return super.park(car);
        } else {
            return null;
        }
    }
}
