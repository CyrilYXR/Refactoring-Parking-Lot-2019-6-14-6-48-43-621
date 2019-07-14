package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Ticket park(Car car){
        this.cars.add(car);
        return new Ticket(car.hashCode());
    }

    public Car fetch(Ticket ticket){
        for(Car car : cars){
            if(car.hashCode() == ticket.getCode()){
                cars.remove(car);
                return car;
            }
        }
        return null;
    }
}
