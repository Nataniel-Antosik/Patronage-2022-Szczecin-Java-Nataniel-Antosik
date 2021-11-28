package com.example.parking;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/booking")
public class BookingApi {

    private List<ParkingSpace> parkingSpace;
    private List<Booking> persons;
    private List<Reservation> reservations;

    public BookingApi() {
        parkingSpace = new ArrayList<>();
        reservations = new ArrayList<>();
        persons = new ArrayList<>();
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
    List<ParkingSpace> tmp = new ArrayList<>(parkingSpace);
        for(int i = 0; i < reservations.size(); i++){
            long tmpIndex = reservations.get(i).getParkingSpaceId();
            tmp.removeIf(element -> element.getId() == tmpIndex);
        }
        return tmp;
    }

    @GetMapping("/all/reservation/for/person")
    public List<ParkingSpace> getAllReservationForPerson(@RequestParam String name) {
        List<ParkingSpace> tmp = new ArrayList<>();

        for(int i = 0; i < reservations.size(); i++){
            for(int j = 0; j < parkingSpace.size(); j++){
                if(reservations.get(i).getName().equals(name)){
                    if(reservations.get(i).getParkingSpaceId() == parkingSpace.get(j).getId()){
                        tmp.add(new ParkingSpace(parkingSpace.get(j).getId(), parkingSpace.get(j).getParkingSpace(), parkingSpace.get(j).getStorey(), parkingSpace.get(j).isPlaceFTD()));
                    }
                }
            }
        }
        return tmp;
    }

    @GetMapping("/all/reservation")
    public List<Reservation> getAllReservation(){
        return reservations;
    }

    @GetMapping("/all/booking")
    public List<Booking> getAllBooking() {
        return persons;
    }

    @PostMapping("/add/reservation")
    public ResponseEntity addReservation(@RequestBody Reservation reservation) {
        boolean duplicate;
        boolean duplicateReservation = false;
        if(reservation.getName().isBlank() || reservation.getName().length() <= 2 || reservation.getName().length() > 20){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            if(persons.size() != 0){
                duplicate = false;
                for(int i = 0; i < persons.size(); i++){
                    if(persons.get(i).getName().equals(reservation.getName())){
                        duplicate = true;
                    }
                }
            } else {
                duplicate = false;
            }
            if(duplicate == false){
                persons.add(new Booking(reservation.getName()));
            }
            if(reservations.size() != 0){
                duplicateReservation = false;
                for(int i = 0; i < reservations.size(); i++){
                    if(reservations.get(i).getParkingSpaceId() == reservation.getParkingSpaceId() || reservations.get(i).getId() == reservation.getId()){
                        duplicateReservation = true;
                        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                    }
                }
            }
            if(duplicateReservation == false){
                reservations.add(reservation);
            }
        }
        return new ResponseEntity<>(reservation,HttpStatus.OK);
    }

    @DeleteMapping("/deleTe/reservation")
    public boolean deleteReservation(@RequestParam int index) {
        return reservations.removeIf(element -> element.getId() == index);
    }

}
