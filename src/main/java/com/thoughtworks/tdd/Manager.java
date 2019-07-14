package com.thoughtworks.tdd;

import java.util.List;

public class Manager extends ParkingBoy{

    public void addBoyToLotManagerments(ParkingBoy parkingBoy, ParkingLot parkingLot) {
        List<? super ParkingBoy> parkingBoys = parkingLot.getManagements();
        parkingBoys.add(parkingBoy);
        parkingLot.setManagements(parkingBoys);
    }
}
