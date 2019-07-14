package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private String errMes;

    public String getErrMes() {
        return errMes;
    }

    public void setErrMes(String errMes) {
        this.errMes = errMes;
    }

    public ParkingBoy() {
    }

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) {
        if(car == null){
            throw new RuntimeException();
        }
        return this.parkingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        Car car = parkingLot.fetch(ticket);
        if(car == null){
            this.errMes = "Unrecognized parking ticket.";
        }
        return car;
    }

    public String queryErrorMessage() {
        return this.errMes;
    }
}
