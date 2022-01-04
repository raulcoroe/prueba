package raulmartin.prueba.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raulmartin.prueba.domain.Bike;
import raulmartin.prueba.domain.Rent;
import raulmartin.prueba.domain.User;
import raulmartin.prueba.domain.dto.RentDto;
import raulmartin.prueba.expection.BikeNotFoundException;
import raulmartin.prueba.expection.UserNotFoundException;
import raulmartin.prueba.repository.BikeRepository;
import raulmartin.prueba.repository.RentRepository;
import raulmartin.prueba.repository.UserRepository;

@Service
public class BikeServiceImpl implements BikeService {
    @Autowired
    BikeRepository bikeRepository;

    @Override
    public Bike altaBici(Bike bike) {
        Bike bikeAdded = bikeRepository.save(bike);
        return bikeAdded;
    }

    @Override
    public Bike verBici(long id) throws BikeNotFoundException {
        Bike bike = bikeRepository.findById(id).orElseThrow(BikeNotFoundException::new);
        return bike;
    }
}
