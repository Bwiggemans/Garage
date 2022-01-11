package nl.novi.garage.controller;

import nl.novi.garage.model.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {

    //Attribute
    private List<Car> cars = new ArrayList<>();

    //Constructor
    public CarController() {
        Car car1 = new Car();
        car1.setBrand("Kia");
        car1.setModel("Sportage");
        car1.setFuel("diesel");
        car1.setTransmission("Automatic");
        car1.setYear(2019);
        car1.setMileage(19500.5);
        cars.add(car1);

        Car car2 = new Car();
        car2.setBrand("Kia");
        car2.setModel("Forte");
        car2.setFuel("petrol");
        car2.setTransmission("Manual");
        car2.setYear(2016);
        car2.setMileage(75095.7);
        cars.add(car2);

        Car car3 = new Car();
        car3.setBrand("Kia");
        car3.setModel("Niro");
        car3.setFuel("petrol");
        car3.setTransmission("Manual");
        car3.setYear(2018);
        car3.setMileage(35155.7);
        cars.add(car3);

    }
    @GetMapping(value = "/cars")
    public ResponseEntity<Object> getCars(){
        return ResponseEntity.ok(cars); // Jackson zorgt ervoor object => json
    }

    @GetMapping(value = "/cars/{id}")
    public ResponseEntity<Object> getCar(@PathVariable int id){
        return ResponseEntity.ok(cars.get(id)); // Jackson zorgt ervoor object => json
    }

    @DeleteMapping(value = "/cars/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable int id){
        cars.remove(id);
        return ResponseEntity.noContent().build(); // De header builder heeft een body nodig om te kunnen functioneren
                                                    // 200 code wordt teruggegeven
    }

    @PostMapping(value = "/cars")
    public ResponseEntity<Object> addCar(@RequestBody Car car){
        cars.add(car);
        int newId = cars.size() - 1;

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/cars/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable int id, @RequestBody Car car){
        cars.set(id, car);
        return ResponseEntity.noContent().build(); // 200 code wordt teruggegeven
    }

    @PatchMapping(value = "/cars/{id}")
    public ResponseEntity<Object> partialUpdateCar(@PathVariable int id, @RequestBody Car car){
        Car existingCar = cars.get(id);
        if (!car.getBrand().isEmpty()){
            existingCar.setBrand(car.getBrand());
        }
        if (!car.getModel().isEmpty()){
            existingCar.setModel(car.getModel());
        }
        if (!car.getFuel().isEmpty()){
            existingCar.setFuel(car.getFuel());
        }
        if (!car.getTransmission().isEmpty()){
            existingCar.setTransmission(car.getTransmission());
        }
        if ((car.getYear()) != (existingCar.getYear())){
            existingCar.setYear(car.getYear());
        }
        if ((car.getMileage()) != (existingCar.getMileage())){
            existingCar.setMileage(car.getMileage());
        }
        cars.set(id, existingCar);
        return ResponseEntity.noContent().build(); // 200 code wordt teruggegeven
    }

}
