package nl.novi.garage.repository;

import nl.novi.garage.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
