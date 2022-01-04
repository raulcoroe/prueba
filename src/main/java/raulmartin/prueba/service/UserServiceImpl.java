package raulmartin.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raulmartin.prueba.domain.User;
import raulmartin.prueba.expection.UserNotFoundException;
import raulmartin.prueba.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User altaUsuario(User user) {
        if (userRepository.findByEmail(user.getEmail()) == null){
            User userAdded = userRepository.save(user);
            return userAdded;
        } else {
            return null;
        }
    }

    @Override
    public User verPerfil(long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return user;
    }

    @Override
    public User cargarSaldo(long id, float balance) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        user.setBalance(balance);
        userRepository.save(user);
        return user;
    }

    @Override
    public void bajaUsuario(long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }
}
