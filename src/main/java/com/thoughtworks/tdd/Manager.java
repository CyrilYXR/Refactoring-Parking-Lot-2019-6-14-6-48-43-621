package com.thoughtworks.tdd;

import java.util.List;

public class Manager extends ParkingBoy{

    public void addBoyToLotManagements(ParkingBoy parkingBoy, ParkingLot parkingLot) {
        List<? super ParkingBoy> parkingBoys = parkingLot.getManagements();
        parkingBoys.add(parkingBoy);
        parkingLot.setManagements(parkingBoys);
    }

    public Ticket specifyBoyToPark(ParkingBoy parkingBoy, ParkingLot parkingLot, Car car) {
        if(parkingLot.getManagements().contains(parkingBoy)){
            parkingBoy.setParkingLot(parkingLot);
            Ticket ticket = parkingBoy.park(car);
            if(ticket == null){
                this.setErrorMessage(parkingBoy.getErrorMessage());
                return null;
            }
            return parkingBoy.park(car);
        } else {
            throw new RuntimeException();
        }
    }

    public Car specifyBoyToFetch(ParkingBoy parkingBoy, ParkingLot parkingLot, Ticket ticket) {
        if(parkingLot.getManagements().contains(parkingBoy)){
            parkingBoy.setParkingLot(parkingLot);
            if(parkingBoy.fetch(ticket) == null) {
                this.setErrorMessage(parkingBoy.getErrorMessage());
                return null;
            }
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

    public Car fetch(Ticket ticket, ParkingLot parkingLot) {
        if(parkingLot.getManager() == this){
            super.setParkingLot(parkingLot);
            return super.fetch(ticket);
        } else {
            return null;
        }
    }
}
