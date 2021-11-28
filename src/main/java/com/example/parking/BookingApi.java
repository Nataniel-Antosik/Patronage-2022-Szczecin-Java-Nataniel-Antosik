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
        initialize();
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
        if(reservation.getName().isBlank()){
            return new ResponseEntity<>("The name contains only white characters", HttpStatus.BAD_REQUEST);
        } else if (reservation.getName().length() <= 2){
            return new ResponseEntity<>("The name should be more than 2 characters long", HttpStatus.BAD_REQUEST);
        } else if (reservation.getName().length() > 20) {
            return new ResponseEntity<>("The name should be less than 20 characters", HttpStatus.BAD_REQUEST);
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
                    if(reservations.get(i).getParkingSpaceId() == reservation.getParkingSpaceId()){
                        duplicateReservation = true;
                        return new ResponseEntity<>("This parking space is taken",HttpStatus.BAD_REQUEST);
                    } else if (reservations.get(i).getId() == reservation.getId()) {
                        return new ResponseEntity<>("Booking id is already taken",HttpStatus.BAD_REQUEST);
                    }
                }
            }
            if(duplicateReservation == false){
                reservations.add(reservation);
            }
        }
        return new ResponseEntity<>("Reservation correctly added",HttpStatus.OK);
    }

    @DeleteMapping("/deleTe/reservation")
    public ResponseEntity deleteReservation(@RequestParam int index) {
        boolean delete = reservations.removeIf(element -> element.getId() == index);
        if (delete == false)
            return new ResponseEntity<>("Reservation not found for deletion", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Reservation correctly deleted",HttpStatus.OK);
    }

    public void initialize() {
        int tmp = 1;
        int tmp2 = 1;
        for(int i = 0; i < 12; i++){
            if( (i+1) % 2 == 0){
                parkingSpace.add(new ParkingSpace((long) i + 1, tmp, tmp2, true));
            } else {
                parkingSpace.add(new ParkingSpace((long) i + 1, tmp, tmp2, false));
            }
            tmp += 1;
            if(tmp == 5){
                tmp = 1;
                tmp2 += 1;
            }
        }
    }
}
