package raulmartin.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raulmartin.prueba.domain.User;
import raulmartin.prueba.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User altaUsuario(User user) {
        if (userRepository.findByEmail(user.getEmail())){
            User userAdded = userRepository.save(user);
            return userAdded;
        } else {
            return null;
        }
    }
}
