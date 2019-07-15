package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    // e:10min a:12min
    @Test
    void should_contain_parking_boy_when_manager_add_parking_boy_to_management_list(){
        //GIVEN
        Manager manager = new Manager();
        ParkingBoy parkingBoy = new ParkingBoy();
        SmallParkingBoy smallParkingBoy = new SmallParkingBoy();
        ParkingLot parkingLot = new ParkingLot(manager);
        //WHEN
        manager.addBoyToLotManagements(parkingBoy, parkingLot);
        manager.addBoyToLotManagements(smallParkingBoy, parkingLot);

        //THEN
        Assertions.assertTrue(parkingLot.getManagements().contains(parkingBoy));
        Assertions.assertTrue(parkingLot.getManagements().contains(smallParkingBoy));
    }

    // e:10min a:12min
    @Test
    void should_return_ticket_when_manager_specify_a_parking_boy_to_park_the_car_only_from_their_lot(){
        //GIVEN
        Car car = new Car();
        Manager manager = new Manager();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(manager);
        manager.addBoyToLotManagements(parkingBoy, parkingLot);

        //WHEN
        Ticket ticket = manager.specifyBoyToPark(parkingBoy, parkingLot, car);

        //THEN
        Assertions.assertNotNull(ticket);
    }

    // e:5min a:3min
    @Test
    void should_return_car_when_manager_specify_a_parking_boy_to_fetch_car_from_their_lot(){
        //GIVEN
        Manager manager = new Manager();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(manager);
        manager.addBoyToLotManagements(parkingBoy, parkingLot);
        Ticket ticket = manager.specifyBoyToPark(parkingBoy, parkingLot, new Car());

        //WHEN
        Car car = manager.specifyBoyToFetch(parkingBoy, parkingLot, ticket);

        //THEN
        Assertions.assertNotNull(car);
    }

    // e:2min a:2min
    @Test
    void should_failed_when_manager_specify_a_parking_boy_to_park_or_fetch_car_not_from_their_lot(){
        //GIVEN
        Manager manager = new Manager();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot1 = new ParkingLot(manager);
        ParkingLot parkingLot2 = new ParkingLot(manager);
        manager.addBoyToLotManagements(parkingBoy, parkingLot1);

        //WHEN + THEN
        Assertions.assertThrows(RuntimeException.class, ()-> manager.specifyBoyToPark(parkingBoy, parkingLot2, new Car()));
        Assertions.assertThrows(RuntimeException.class, ()-> manager.specifyBoyToFetch(parkingBoy, parkingLot2, new Ticket()));

    }

    // e:5min a:3min
    @Test
    void should_return_ticket_when_manager_park_the_car_from_manager_own_lots(){
        //GIVEN
        Manager manager = new Manager();
        ParkingLot parkingLot = new ParkingLot(manager);
        //THEN
        Ticket ticket = manager.park(new Car(), parkingLot);
        //WHEN
        Assertions.assertNotNull(ticket);
    }

    // e:3min a:3min
    @Test
    void should_return_car_when_manager_fetch_the_car_from_manager_own_lots(){
        //GIVEN
        Manager manager = new Manager();
        ParkingLot parkingLot = new ParkingLot(manager);
        Ticket ticket = manager.park(new Car(), parkingLot);
        //THEN
        Car car = manager.fetch(ticket, parkingLot);
        //WHEN
        Assertions.assertNotNull(car);
    }

    // e:3min a:5min
    @Test
    void should_return_not_enough_position_when_boy_failed_to_do_the_operation(){
        // Given
        Car car = new Car();
        Manager manager = new Manager();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(0, manager);
        manager.addBoyToLotManagements(parkingBoy, parkingLot);

        // When
        manager.specifyBoyToPark(parkingBoy, parkingLot, car);
        String errMsg = manager.getErrorMessage();

        //Then
        Assertions.assertEquals("Not enough position.", errMsg);
    }

    //e:3min a:1min
    @Test
    void should_return_unrecognized_parking_ticket_when_boy_failed_to_do_the_operation(){
        // Given
        Manager manager = new Manager();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(5, manager);
        manager.addBoyToLotManagements(parkingBoy, parkingLot);

        // When
        Car car = manager.specifyBoyToFetch(parkingBoy, parkingLot, new Ticket(1));
        String errMsg = manager.getErrorMessage();

        //Then
        Assertions.assertNull(car);
        Assertions.assertEquals("Unrecognized parking ticket.", errMsg);
    }
}
