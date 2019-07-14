package com.thoughtworks.tdd;

import java.util.List;

public class SmallParkingBoy extends ParkingBoy{

    public SmallParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot selectAParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().max((a, b) -> (a.getEmptyPositions() - b.getEmptyPositions())).get();
    }
}
