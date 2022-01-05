package raulmartin.prueba.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raulmartin.prueba.domain.Bike;
import raulmartin.prueba.domain.Rent;
import raulmartin.prueba.domain.User;
import raulmartin.prueba.domain.dto.RentDto;
import raulmartin.prueba.expection.BikeNotFoundException;
import raulmartin.prueba.expection.RentNotFoundException;
import raulmartin.prueba.expection.UserNotFoundException;
import raulmartin.prueba.repository.BikeRepository;
import raulmartin.prueba.repository.RentRepository;
import raulmartin.prueba.repository.UserRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static java.lang.Math.abs;

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
        rent.setActive(true);
        bike.setAvailability(false);

        rent.setUser(user);
        rent.setBike(bike);
        return rentRepository.save(rent);
    }

    @Override
    public List<Rent> verHistorialUsuario(long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return user.getRents();
    }

    @Override
    public boolean verEstado(long id) throws RentNotFoundException {
        Rent rent = rentRepository.findById(id).orElseThrow(RentNotFoundException::new);
        return rent.isActive();
    }

    @Override
    public void devolverBici(long id) throws RentNotFoundException {
        Rent rent = rentRepository.findById(id).orElseThrow(RentNotFoundException::new);
        rent.setActive(false);
        rent.setEndDate(LocalDateTime.now());
        rent.rentCost();
        rent.getBike().setAvailability(true);
        rent.getUser().setBalance(rent.getUser().getBalance() - rent.getCost());
        rentRepository.save(rent);
    }
}