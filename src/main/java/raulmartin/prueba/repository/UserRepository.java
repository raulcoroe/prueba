package raulmartin.prueba.repository;

import
org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import raulmartin.prueba.domain.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
