package raulmartin.prueba.service;

import raulmartin.prueba.domain.User;
import raulmartin.prueba.expection.UserNotFoundException;

public interface UserService {
    User altaUsuario(User user);

    User verPerfil(long id) throws UserNotFoundException;
}
