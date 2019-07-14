package com.thoughtworks.tdd;

public class ParkingBoy {
    public Ticket park(Car car) {
        if(car == null){
            throw new RuntimeException();
        }
        return new Ticket();
    }

    public Car fetch(Ticket ticket) {
        return new Car();
    }
}
