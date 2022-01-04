package raulmartin.prueba.service;

import raulmartin.prueba.domain.Bike;
import raulmartin.prueba.domain.Rent;
import raulmartin.prueba.domain.dto.RentDto;
import raulmartin.prueba.expection.BikeNotFoundException;
import raulmartin.prueba.expection.UserNotFoundException;

public interface BikeService {

    Bike altaBici(Bike bike);

    Bike verBici(long id) throws BikeNotFoundException;
}
