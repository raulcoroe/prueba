package raulmartin.prueba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import raulmartin.prueba.domain.Bike;
import raulmartin.prueba.domain.User;

@Repository
public interface BikeRepository extends CrudRepository<Bike, Long> {
}
