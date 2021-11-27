package com.example.parking;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/booking")
public class BookingApi {

    private List<ParkingSpace> parkingSpace;
    private List<ParkingSpace> occupiedParkingSpace;
    private List<Reservation> reservations;

    public BookingApi() {
        parkingSpace = new ArrayList<>();
        reservations = new ArrayList<>();
        parkingSpace.add(new ParkingSpace(1L, 1, 1, false));
        parkingSpace.add(new ParkingSpace(2L, 2, 1, true));
        parkingSpace.add(new ParkingSpace(3L, 3, 1, true));
        parkingSpace.add(new ParkingSpace(4L, 4, 1, false));
        parkingSpace.add(new ParkingSpace(5L, 1, 2, false));
        parkingSpace.add(new ParkingSpace(6L, 2, 2, true));
        parkingSpace.add(new ParkingSpace(7L, 3, 2, true));
        parkingSpace.add(new ParkingSpace(8L, 4, 2, false));
        parkingSpace.add(new ParkingSpace(9L, 1, 3, false));
        parkingSpace.add(new ParkingSpace(10L, 2, 3, true));
        parkingSpace.add(new ParkingSpace(11L, 3, 3, true));
        parkingSpace.add(new ParkingSpace(12L, 4, 3, false));
    }

    @GetMapping("/all/parking/free/space")
    public List<ParkingSpace> getAllFreeParkingSpace() {
        return parkingSpace;
    }

    @PostMapping("/add/reservation")
    public boolean addReservation(@RequestBody Reservation reservation) {
        return reservations.add(reservation);
    }

    @GetMapping("/all/reservation2")
    public List<Reservation> getAllReservation2() {
        return reservations;
    }

    @GetMapping("/all/reservation")
    public List<Reservation> getAllReservation(@RequestParam String name) {
        List<Reservation> tmp = new ArrayList<>();
        for(int i = 0; i < reservations.size(); i++){
            if(reservations.get(i).getName().equals(name)){
                tmp.add(new Reservation(reservations.get(i).getName(), reservations.get(i).getParkingSpaceId()));
            }
        }
        return tmp;
    }
}
