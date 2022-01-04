package raulmartin.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raulmartin.prueba.domain.Rent;
import raulmartin.prueba.domain.User;
import raulmartin.prueba.domain.dto.RentDto;
import raulmartin.prueba.expection.BikeNotFoundException;
import raulmartin.prueba.expection.ErrorResponse;
import raulmartin.prueba.expection.UserNotFoundException;
import raulmartin.prueba.service.RentService;
import raulmartin.prueba.service.UserService;

import java.util.List;

@RestController
public class RentController {

    @Autowired
    RentService rentService;

    @PostMapping("/rent")
    public ResponseEntity<Rent> alquilarBici (@RequestBody RentDto rentDto) throws UserNotFoundException, BikeNotFoundException {
        Rent rent = rentService.alquilarBici(rentDto);
        return new ResponseEntity(rent, HttpStatus.OK);
    }

    @GetMapping("/rent/user/{id}")
    public ResponseEntity<Rent> verHistorialUsuario (@PathVariable long id) throws UserNotFoundException {
        List<Rent> rents = rentService.verHistorialUsuario(id);
        return new ResponseEntity(rents, HttpStatus.OK);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException (UserNotFoundException unfe){
        ErrorResponse errorResponse = new ErrorResponse("404", "User not found");
        return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BikeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBikeNotFoundException (BikeNotFoundException bnfe){
        ErrorResponse errorResponse = new ErrorResponse("404", "Bike not found");
        return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
    }
}
