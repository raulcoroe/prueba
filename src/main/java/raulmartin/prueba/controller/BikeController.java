package raulmartin.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raulmartin.prueba.domain.Bike;
import raulmartin.prueba.domain.Rent;
import raulmartin.prueba.domain.User;
import raulmartin.prueba.domain.dto.RentDto;
import raulmartin.prueba.expection.BikeNotFoundException;
import raulmartin.prueba.expection.ErrorResponse;
import raulmartin.prueba.expection.UserNotFoundException;
import raulmartin.prueba.service.BikeService;
import raulmartin.prueba.service.RentService;

@RestController
public class BikeController {

    @Autowired
    BikeService bikeService;

    @PostMapping("/bike")
    public ResponseEntity<Bike> altaBici (@RequestBody Bike bike) {
        Bike bikeAdded = bikeService.altaBici(bike);

        return new ResponseEntity(bikeAdded, HttpStatus.OK);
    }

    @GetMapping("/bike/{id}")
    public ResponseEntity<Bike> verBici (@PathVariable long id) throws BikeNotFoundException {
        Bike bike = bikeService.verBici(id);
        return new ResponseEntity(bike, HttpStatus.OK);
    }


    @ExceptionHandler(BikeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBikeNotFoundException(BikeNotFoundException bnfe) {
        ErrorResponse errorResponse = new ErrorResponse("404", "Bike not found");
        return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
    }
}
