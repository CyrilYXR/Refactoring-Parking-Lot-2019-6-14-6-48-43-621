package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SuperSmallParkingBoyTest {

    // e:10min a:7min
    @Test
    void should_return_lotcode_of_3_when_it_has_a_larger_available_position_rate(){
        //GIVEN
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        ParkingLot parkingLot1 = new ParkingLot("1", 3);
        ParkingLot parkingLot2 = new ParkingLot("2", 3);
        ParkingLot parkingLot3 = new ParkingLot("3", 5);
        parkingLot1.setCars(cars);
        parkingLot3.setCars(cars);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        SuperSmallParkingBoy superSmallParkingBoy = new SuperSmallParkingBoy(parkingLots);

        //WHEN
        Car car = new Car();
        Ticket ticket = superSmallParkingBoy.park(car);
        //THEN
        Assertions.assertNotNull(ticket);
        Assertions.assertEquals("2", superSmallParkingBoy.getParkingLot().getLotCode());
    }
}
