package nl.novi.garage.service;

import ch.qos.logback.core.joran.conditional.IfAction;
import nl.novi.garage.dto.CarRequestDto;
import nl.novi.garage.exception.RecordNotFoundException;
import nl.novi.garage.model.Car;
import nl.novi.garage.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Iterable<Car> getCars(String model){
        if (model.isEmpty()){
            return carRepository.findAll();
        }
        else {
            return carRepository.findAllByModelContainingIgnoreCase(model);
        }
    }

    public Car getCar(int id){
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()){
           return optionalCar.get();
        }
        else {
            //exception create
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public void deleteCar(int id){
        if (carRepository.existsById(id)){
            carRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public int addCar(CarRequestDto carRequestDto){
        Car car = new Car();
        car.setBrand(carRequestDto.getBrand());
        car.setModel(carRequestDto.getModel());
        car.setFuel(carRequestDto.getFuel());
        car.setTransmission(carRequestDto.getTransmission());
        car.setLicensePlate(carRequestDto.getLicensePlate());
        car.setYear(carRequestDto.getYear());
        car.setMileage(carRequestDto.getMileage());

        Car newCar = carRepository.save(car);
        return newCar.getId();
    }

    public void updateCar(int id, Car car){
        Car existingCar = carRepository.findById(id).orElse(null);

        if (!car.getBrand().isEmpty()) {
            existingCar.setBrand(car.getBrand());
        }
        if (!car.getModel().isEmpty()) {
            existingCar.setModel(car.getModel());
        }
        if (!car.getFuel().isEmpty()) {
            existingCar.setFuel(car.getFuel());
        }
        if (!car.getTransmission().isEmpty()) {
            existingCar.setTransmission(car.getTransmission());
        }
        if (!car.getLicensePlate().isEmpty()) {
            existingCar.setLicensePlate(car.getLicensePlate());
        }
        if ((car.getYear()) != (existingCar.getYear())){
            existingCar.setYear(car.getYear());
        }
        if ((car.getMileage()) != (existingCar.getMileage())){
            existingCar.setMileage(car.getMileage());
        }
        carRepository.save(existingCar);
    }

    public void partialUpdateCar(int id, Car car){
        Car existingCar = carRepository.findById(id).orElse(null);

        if (!(car.getBrand()==null) && !car.getBrand().isEmpty()){
            existingCar.setBrand(car.getBrand());
        }
        if (!(car.getModel()==null) && !car.getModel().isEmpty()){
            existingCar.setModel(car.getModel());
        }
        if (!(car.getFuel()==null) && !car.getFuel().isEmpty()){
            existingCar.setFuel(car.getFuel());
        }
        if (!(car.getTransmission()==null) && !car.getTransmission().isEmpty()){
            existingCar.setTransmission(car.getTransmission());
        }
        if (!(car.getLicensePlate()==null) && !car.getLicensePlate().isEmpty()){
            existingCar.setLicensePlate(car.getLicensePlate());
        }
        if ((car.getYear()) != (existingCar.getYear())){
            existingCar.setYear(car.getYear());
        }
        if ((car.getMileage()) != (existingCar.getMileage())){
            existingCar.setMileage(car.getMileage());
        }
        carRepository.save(existingCar);
    }

}
