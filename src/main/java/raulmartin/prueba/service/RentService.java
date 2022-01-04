package raulmartin.prueba.service;

import raulmartin.prueba.domain.Rent;
import raulmartin.prueba.domain.dto.RentDto;
import raulmartin.prueba.expection.BikeNotFoundException;
import raulmartin.prueba.expection.UserNotFoundException;

import java.util.List;

public interface RentService {

    Rent alquilarBici(RentDto rentDto) throws UserNotFoundException, BikeNotFoundException;

    List<Rent> verHistorialUsuario(long id) throws UserNotFoundException;
}
