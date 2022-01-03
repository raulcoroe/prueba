package raulmartin.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raulmartin.prueba.domain.User;
import raulmartin.prueba.expection.ErrorResponse;
import raulmartin.prueba.expection.UserNotFoundException;
import raulmartin.prueba.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> altaUsuario(@RequestBody User user) {
        User userAdded = userService.altaUsuario(user);
        if (userAdded != null){
            return new ResponseEntity(userAdded, HttpStatus.OK);
        } else {
            return new ResponseEntity("El email del usuario ya ha sido registrado", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> verPerfil(@PathVariable long id) throws UserNotFoundException {
        User userView = userService.verPerfil(id);
        return new ResponseEntity(userView, HttpStatus.OK);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException (UserNotFoundException unfe){
        ErrorResponse errorResponse = new ErrorResponse("404", "User not found");
        return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
    }
}
