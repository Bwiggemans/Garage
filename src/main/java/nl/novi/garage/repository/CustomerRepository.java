package nl.novi.garage.repository;

import nl.novi.garage.model.Car;
import nl.novi.garage.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Iterable<Customer> findAllByName(String name);
    Iterable<Customer> findAllByNameContainingIgnoreCase(String name);

}
