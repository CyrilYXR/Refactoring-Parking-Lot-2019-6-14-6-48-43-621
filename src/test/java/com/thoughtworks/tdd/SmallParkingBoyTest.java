package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SmallParkingBoyTest {
    // e:15min a:16min
    @Test
    void should_return_lotcode_of_3_when_it_contains_more_empty_position(){
        //GIVEN
        ParkingLot parkingLot1 = new ParkingLot("1", 3);
        ParkingLot parkingLot2 = new ParkingLot("2", 5);
        ParkingLot parkingLot3 = new ParkingLot("3", 10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        SmallParkingBoy smallParkingBoy = new SmallParkingBoy(parkingLots);

        //WHEN
        Car car = new Car();
        Ticket ticket = smallParkingBoy.park(car);
        //THEN
        Assertions.assertNotNull(ticket);
        Assertions.assertEquals("3", smallParkingBoy.getParkingLot().getLotCode());
    }
}
