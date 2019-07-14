package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {

    // e:2min a:2min
    @Test
    void should_get_a_ticket_when_park_a_car(){
        //GIVEN
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        //WHEN
        Ticket ticket = parkingBoy.park(car);
        //THEN
        Assertions.assertNotNull(ticket);
    }
}
