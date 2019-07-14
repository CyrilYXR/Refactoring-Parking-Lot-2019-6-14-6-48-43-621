package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Car> cars = new ArrayList<>();
    private int capacity = 10;
    private String lotCode;
    private List<? super ParkingBoy> managements = new ArrayList<>();
    private Manager manager;

    public List<? super ParkingBoy> getManagements() {
        return managements;
    }

    public void setManagements(List<? super ParkingBoy> managements) {
        this.managements = managements;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ParkingLot(Manager manager) {
        this.manager = manager;
    }

    public ParkingLot(String lotCode, int capacity) {
        this.capacity = capacity;
        this.lotCode = lotCode;
    }

    public ParkingLot(int capacity, Manager manager) {
        this.capacity = capacity;
        this.manager = manager;
    }

    public ParkingLot() {
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public ParkingLot(String lotCode) {
        this.lotCode = lotCode;
    }

    public Ticket park(Car car){
        if(this.cars.size() < this.capacity) {
            this.cars.add(car);
            return new Ticket(car.hashCode());
        } else {
            return null;
        }
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

    public int getEmptyPositions(){
        return this.capacity - this.getCars().size();
    }
}
