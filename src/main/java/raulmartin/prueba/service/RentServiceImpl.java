package raulmartin.prueba.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
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

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepository rentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BikeRepository bikeRepository;

    @Override
    public Rent alquilarBici(RentDto rentDto) throws UserNotFoundException, BikeNotFoundException {

        User user = userRepository.findById(rentDto.getUser()).orElseThrow(UserNotFoundException::new);
        Bike bike = bikeRepository.findById(rentDto.getBike()).orElseThrow(BikeNotFoundException::new);

        ModelMapper mapper = new ModelMapper();
        Rent rent = mapper.map(rentDto, Rent.class);

        rent.setUser(user);
        rent.setBike(bike);
        return rentRepository.save(rent);
    }

    @Override
    public List<Rent> verHistorialUsuario(long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return user.getRents();
    }
}
