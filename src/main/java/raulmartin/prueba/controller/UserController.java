package raulmartin.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import raulmartin.prueba.domain.User;
import raulmartin.prueba.service.UserService;

@Controller
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
}
