package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoyTest {

    private ParkingLot parkingLot;

    @BeforeEach
    public void setup(){
        parkingLot = new ParkingLot();
    }

    // e:2min a:2min
    @Test
    void should_get_a_ticket_when_park_a_car(){
        //GIVEN
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //WHEN
        Ticket ticket = parkingBoy.park(car);
        //THEN
        Assertions.assertNotNull(ticket);
    }

    // e:2min a:2min
    @Test
    void should_return_a_car_when_give_a_ticket(){
        //GIVEN
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
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

    // e:10min a:15min
    @Test
    void should_return_correspond_car_when_park_multiply_cars(){
        //GIVEN
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        //WHEN
        Car fetchCar1 = parkingBoy.fetch(ticket1);
        Car fetchCar2 = parkingBoy.fetch(ticket2);
        //THEN
        Assertions.assertEquals(car1, fetchCar1);
        Assertions.assertEquals(car2, fetchCar2);
    }

    // e:3min a:2min
    @Test
    void should_return_null_when_ticket_is_wrong(){
        //GIVEN
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = new Ticket(1);
        //WHEN
        Car car = parkingBoy.fetch(ticket);
        //THEN
        Assertions.assertNull(car);
    }

    // e:3min a:2min
    @Test
    void should_return_null_when_ticket_is_not_given(){
        //GIVEN
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = null;
        //WHEN
        Car car = parkingBoy.fetch(ticket);
        //THEN
        Assertions.assertNull(car);
    }

    // e:3min a:1min
    @Test
    void should_return_null_when_ticket_is_used(){
        //GIVEN
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = parkingBoy.park(new Car());
        Car car = parkingBoy.fetch(ticket);
        //WHEN
        Car carNull = parkingBoy.fetch(ticket);
        //THEN
        Assertions.assertNull(carNull);
    }

    // e:5min a:5min
    @Test
    void should_not_park_the_car_when_parking_lot_has_not_position(){
        //GIVEN
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for(int i = 0; i < 10; i++){
            parkingBoy.park(new Car());
        }
        //WHEN
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //THEN
        Assertions.assertFalse(parkingLot.getCars().contains(car));
        Assertions.assertNull(ticket);
    }

    // e:5min a:4min
    @Test
    void should_get_message_unrecognized_parking_ticket_when_give_a_used_ticket(){
        //GIVEN
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = parkingBoy.park(new Car());
        parkingBoy.fetch(ticket);
        //WHEN
        parkingBoy.fetch(ticket);
        //THEN
        Assertions.assertEquals("Unrecognized parking ticket.", parkingBoy.queryErrorMessage());
    }

    // e:3min a:3min
    @Test
    void should_get_message_please_provide_your_parking_ticket_when_not_provide_a_ticket(){
        //GIVEN
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //WHEN
        Car car = parkingBoy.fetch(null);
        //THEN
        Assertions.assertNull(car);
        Assertions.assertEquals("Please provide your parking ticket.", parkingBoy.queryErrorMessage());
    }

    // e:3min a:3min
    @Test
    void should_get_message_no_enough_position_when_parking_without_a_position(){
        //GIVEN
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for(int i = 0; i < 10; i++){
            parkingBoy.park(new Car());
        }
        //WHEN
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //THEN
        Assertions.assertNull(ticket);
        Assertions.assertEquals("Not enough position.", parkingBoy.queryErrorMessage());
    }

    // e:10min a:14min
    @Test
    void should_park_car_to_second_parking_lot_when_first_parking_lot_is_full(){
        //GIVEN
        ParkingLot parkingLot1 = new ParkingLot("1");
        ParkingLot parkingLot2 = new ParkingLot("2");
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for(int i = 0; i < 10; i++){
            parkingBoy.park(new Car());
        }
        //WHEN
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //THEN
        Assertions.assertNotNull(ticket);
        Assertions.assertEquals("2", parkingBoy.getParkingLot().getLotCode());
    }


}
