package nl.novi.garage.repository;

import nl.novi.garage.model.Customer;
import nl.novi.garage.model.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SparePartRepository extends JpaRepository<SparePart, Integer> {

    Iterable<SparePart> findAllByPart(String part);
    Iterable<SparePart> findAllByPartContainingIgnoreCase(String part);
    Iterable<SparePart> findAllByPartNumber(String partNumber);

}
