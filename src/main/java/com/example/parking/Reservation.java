package com.example.parking;

public class Reservation {

    private long id;

    private String name;

    private long parkingSpaceId;

    public Reservation() {
    }

    public Reservation(long id, String name, long parkingSpaceId) {
        this.id = id;
        this.name = name;
        this.parkingSpaceId = parkingSpaceId;
    }

    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
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
