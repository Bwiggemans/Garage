package nl.novi.garage.service;

import nl.novi.garage.exception.RecordNotFoundException;
import nl.novi.garage.model.CarInspectionRepairShop;
import nl.novi.garage.repository.CarInspectionRepairShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarInspectionRepairShopService {

    @Autowired
    private CarInspectionRepairShopRepository carInspectionRepairShopRepository;

    public List<CarInspectionRepairShop> getAllCarInspectionRepairShops() {
        return carInspectionRepairShopRepository.findAll();
    }

    public CarInspectionRepairShop getCarInspectionRepairShop(long id) {
        if (carInspectionRepairShopRepository.existsById(id)) {
            return carInspectionRepairShopRepository.findById(id).get();
        }
        else {
            throw new RecordNotFoundException("No carInspectionRepairShop with id " + id);
        }
    }

    public long save(CarInspectionRepairShop carInspectionRepairShop) {
        CarInspectionRepairShop saved = carInspectionRepairShopRepository.save(carInspectionRepairShop);
        return saved.getId();
    }

    public void deleteById(long id) {
        if (carInspectionRepairShopRepository.existsById(id)) {
            carInspectionRepairShopRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException("No carsRepairInspectionShop with id " + id);
        }
    }

}
