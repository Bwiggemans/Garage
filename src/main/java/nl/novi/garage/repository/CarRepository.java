package nl.novi.garage.repository;

import nl.novi.garage.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends JpaRepository<Car, Integer> {

    Iterable<Car> findAllByModel(String Model);
    Iterable<Car> findAllByModelContainingIgnoreCase(String Model);

    //  Zoeken met gedeelte String in attribuut title:
/*    @Query(value = "SELECT * FROM cars b WHERE b.model LIKE %:s%", nativeQuery = true) // using SQL
    Iterable<Car> searchByModelLike(@Param("s") String s);

 */
}
