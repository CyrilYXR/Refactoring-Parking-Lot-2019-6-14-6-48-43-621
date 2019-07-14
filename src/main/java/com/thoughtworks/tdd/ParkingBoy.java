package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private String errMes;
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.parkingLot = parkingLots.get(0);
    }

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

        // select a parking lot
//        for(int i=0; i<this.parkingLots.size(); i++){
//            if(this.parkingLots.get(i) != null
//                    && this.parkingLots.get(i).getCars().size() < this.parkingLots.get(i).getCapacity()) {
//                this.parkingLot = this.parkingLots.get(i);
//                break;
//            }
//        }
        this.parkingLot = selectAParkingLot(this.parkingLots);

        if(this.parkingLot.getCars().size() == this.parkingLot.getCapacity()){
            errMes = "Not enough position.";
            return null;
        }

        return this.parkingLot.park(car);
    }

    public ParkingLot selectAParkingLot(List<ParkingLot> parkingLots) {
        for(int i=0; i<parkingLots.size(); i++){
            if(parkingLots.get(i) != null
                    && parkingLots.get(i).getCars().size() < parkingLots.get(i).getCapacity()) {
                return parkingLots.get(i);
            }
        }
        return this.parkingLot;
    }

    public Car fetch(Ticket ticket) {
        if(ticket == null){
            this.errMes = "Please provide your parking ticket.";
            return null;
        }
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
