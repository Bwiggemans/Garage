package nl.novi.garage.controller;

import nl.novi.garage.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.ok(cars);
    }

}
