package raulmartin.prueba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import raulmartin.prueba.domain.Rent;
import raulmartin.prueba.domain.User;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {
}
