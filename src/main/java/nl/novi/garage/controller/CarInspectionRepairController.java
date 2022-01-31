package nl.novi.garage.controller;

import nl.novi.garage.model.CarInspectionRepair;
import nl.novi.garage.service.CarInspectionRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class CarInspectionRepairController {

    @Autowired
    private CarInspectionRepairService carInspectionRepairService;

    @GetMapping(value = "/cars_inspection_repair")
    public ResponseEntity<?> getCarInspectionRepairs() {
        List<CarInspectionRepair> carInspectionRepairs = carInspectionRepairService.getAllCarInspectionRepairs();
        return ResponseEntity.ok(carInspectionRepairs);
    }

    @GetMapping(value = "/cars_inspection_repair/{id}")
    public ResponseEntity<?> getCarInspectionRepair(@PathVariable("id") long id) {
        return ResponseEntity.ok(carInspectionRepairService.getCarInspectionRepair(id));
    }

    @PostMapping(value = "/cars_inspection_repair")
    public ResponseEntity<?> createCarInspectionRepair(@RequestBody CarInspectionRepair carInspectionRepair) {
        long newId = carInspectionRepairService.save(carInspectionRepair);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/cars_inspection_repair/{id}")
    public ResponseEntity<?> deleteCarInspectionRepair(@PathVariable("id") long id) {
        carInspectionRepairService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
