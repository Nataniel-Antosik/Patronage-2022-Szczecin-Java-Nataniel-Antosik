package com.example.parking;

public class ParkingSpace {

    private Long id;

    private int parkingSpace;

    private int storey;

    private boolean placeFTD; //place for the disabled

    public ParkingSpace() {
    }

    public ParkingSpace(Long id, int parkingSpace, int storey, boolean placeFTD) {
        this.id = id;
        this.parkingSpace = parkingSpace;
        this.storey = storey;
        this.placeFTD = placeFTD;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(int parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public boolean isPlaceFTD() {
        return placeFTD;
    }

    public void setPlaceFTD(boolean placeFTD) {
        this.placeFTD = placeFTD;
    }
}
