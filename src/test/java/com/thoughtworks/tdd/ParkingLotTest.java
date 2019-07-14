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

    // e:2min a:2min
    @Test
    void should_return_a_car_when_give_a_ticket(){
        //GIVEN
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.park(new Car());
        //WHEN
        Car car = parkingBoy.fetch(ticket);
        //THEN
        Assertions.assertNotNull(car);
    }

    // e:2min a:2min
    @Test
    void should_failed_when_pass_null_car_to_parking_boy(){
        //GIVEN
        Car car = null;
        ParkingBoy parkingBoy = new ParkingBoy();
        //WHEN + THEN
        Assertions.assertThrows(RuntimeException.class, ()->parkingBoy.park(car));
    }
}
