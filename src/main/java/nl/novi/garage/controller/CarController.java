package nl.novi.garage.controller;

import nl.novi.garage.dto.CarRequestDto;
import nl.novi.garage.model.Car;
import nl.novi.garage.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars")
    public ResponseEntity<Object> getCars(@RequestParam(name="licenseplate", defaultValue = "")String licenseplate){
        return ResponseEntity.ok(carService.getCars(licenseplate)); // Jackson takes care of object => json
    }

    @GetMapping(value = "/cars/{id}")
    public ResponseEntity<Object> getCar(@PathVariable int id){
        return ResponseEntity.ok(carService.getCar(id)); // Jackson takes care of object => json
    }

    @DeleteMapping(value = "/cars/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable int id){
        carService.deleteCar(id);
        return ResponseEntity.noContent().build(); // De header builder needs a body to work
                                                    // 200 code will be returned
    }

    @PostMapping(value = "/cars")
    public ResponseEntity<Object> addCar(@Valid @RequestBody CarRequestDto carRequestDto){
        int newId = carService.addCar(carRequestDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/cars/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable int id, @RequestBody Car car){
        carService.updateCar(id, car);

        return ResponseEntity.noContent().build(); // 204 code will be returned
    }

    @PatchMapping(value = "/cars/{id}")
    public ResponseEntity<Object> partialUpdateCar(@PathVariable int id, @RequestBody Car car){
        carService.partialUpdateCar(id, car);

        return ResponseEntity.noContent().build(); // 204 code will be returned
    }

}
