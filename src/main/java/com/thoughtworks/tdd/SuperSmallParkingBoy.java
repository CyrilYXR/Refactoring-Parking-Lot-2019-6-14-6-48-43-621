package com.thoughtworks.tdd;

import java.util.List;

public class SuperSmallParkingBoy extends ParkingBoy{

    public SuperSmallParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot selectAParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().max((a, b) ->
                (a.getEmptyPositions()/a.getCapacity() - b.getEmptyPositions()/b.getCapacity())).get();
    }
}
