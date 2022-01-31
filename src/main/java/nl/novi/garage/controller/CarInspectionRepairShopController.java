package nl.novi.garage.controller;

import nl.novi.garage.model.CarInspectionRepairShop;
import nl.novi.garage.service.CarInspectionRepairShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class CarInspectionRepairShopController {

    @Autowired
    private CarInspectionRepairShopService carInspectionRepairShopService;

    @GetMapping(value = "/cars_repair_inspection_shop")
    public ResponseEntity<?> getCarInspectionRepairShops() {
        List<CarInspectionRepairShop> carInspectionRepairShops = carInspectionRepairShopService.getAllCarInspectionRepairShops();
        return ResponseEntity.ok(carInspectionRepairShops);
    }

    @GetMapping(value = "/cars_repair_inspection_shop/{id}")
    public ResponseEntity<?> getCarInspectionRepairShop(@PathVariable("id") long id) {
        return ResponseEntity.ok(carInspectionRepairShopService.getCarInspectionRepairShop(id));
    }

    @PostMapping(value = "/cars_repair_inspection_shop")
    public ResponseEntity<?> createCarInspectionRepairShop(@RequestBody CarInspectionRepairShop carInspectionRepairShop) {
        long newId = carInspectionRepairShopService.save(carInspectionRepairShop);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/cars_repair_inspection_shop/{id}")
    public ResponseEntity<?> deleteCarInspectionRepairShop(@PathVariable("id") long id) {
        carInspectionRepairShopService.deleteById(id);
        return new ResponseEntity<>("CarInspectionRepairShop deleted", HttpStatus.OK);
    }

}
