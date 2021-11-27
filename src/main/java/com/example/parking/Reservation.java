package com.example.parking;

public class Reservation {

    private String name;

    private long parkingSpaceId;

    public Reservation() {
    }

    public Reservation(String name, long parkingSpaceId) {
        this.name = name;
        this.parkingSpaceId = parkingSpaceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void setParkingSpaceId(long parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }
}
