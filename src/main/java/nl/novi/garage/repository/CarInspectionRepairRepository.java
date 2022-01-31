package nl.novi.garage.repository;

import nl.novi.garage.model.CarInspectionRepair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarInspectionRepairRepository extends JpaRepository<CarInspectionRepair, Long> {
}
