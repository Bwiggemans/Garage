package nl.novi.garage.service;

import nl.novi.garage.exception.RecordNotFoundException;
import nl.novi.garage.model.CarInspectionRepair;
import nl.novi.garage.model.Customer;
import nl.novi.garage.repository.CarInspectionRepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarInspectionRepairService {

    @Autowired
    private CarService carService;

    @Autowired
    private CarInspectionRepairRepository carInspectionRepairRepository;

    public List<CarInspectionRepair> getAllCarInspectionRepairs() {
        return carInspectionRepairRepository.findAll();
    }

    public CarInspectionRepair getCarInspectionRepair(long id) {
        if (carInspectionRepairRepository.existsById(id)) {
            return carInspectionRepairRepository.findById(id).get();
        }
        else {
            throw new RecordNotFoundException("No car with id " + id);
        }
    }

    public long save(CarInspectionRepair carInspectionRepair) {
        CarInspectionRepair saved = carInspectionRepairRepository.save(carInspectionRepair);
        return saved.getId();
    }

    public void deleteById(long id) {
        if (carInspectionRepairRepository.existsById(id)) {
            carInspectionRepairRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException("No copy with id " + id);
        }
    }

    public long createCarInspectionRepair(CarInspectionRepair carInspectionRepair){

        CarInspectionRepair newCarInspectionRepair = carInspectionRepairRepository.save(carInspectionRepair);
        return newCarInspectionRepair.getId();
    }

}
