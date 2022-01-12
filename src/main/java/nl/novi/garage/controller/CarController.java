package nl.novi.garage.controller;

import nl.novi.garage.model.Car;
import nl.novi.garage.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars")
    public ResponseEntity<Object> getCars(){
        return ResponseEntity.ok(carService.getCars()); // Jackson zorgt ervoor object => json
    }

    @GetMapping(value = "/cars/{id}")
    public ResponseEntity<Object> getCar(@PathVariable int id){
        return ResponseEntity.ok(carService.getCar(id)); // Jackson zorgt ervoor object => json
    }

    @DeleteMapping(value = "/cars/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable int id){
        carService.deleteCar(id);
        return ResponseEntity.noContent().build(); // De header builder heeft een body nodig om te kunnen functioneren
                                                    // 200 code wordt teruggegeven
    }

    @PostMapping(value = "/cars")
    public ResponseEntity<Object> addCar(@RequestBody Car car){
        int newId = carService.addCar(car);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/cars/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable int id, @RequestBody Car car){
        carService.updateCar(id, car);

        return ResponseEntity.noContent().build(); // 200 code wordt teruggegeven
    }

    @PatchMapping(value = "/cars/{id}")
    public ResponseEntity<Object> partialUpdateCar(@PathVariable int id, @RequestBody Car car){
        carService.partialUpdateCar(id, car);

        return ResponseEntity.noContent().build(); // 200 code wordt teruggegeven
    }

}
