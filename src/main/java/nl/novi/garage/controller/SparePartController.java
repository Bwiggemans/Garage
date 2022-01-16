package nl.novi.garage.controller;

import nl.novi.garage.dto.CustomerRequestDto;
import nl.novi.garage.dto.SparePartRequestDto;
import nl.novi.garage.model.Customer;
import nl.novi.garage.model.SparePart;
import nl.novi.garage.service.CustomerService;
import nl.novi.garage.service.SparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class SparePartController {

    @Autowired
    private SparePartService sparePartService;

    @GetMapping(value = "/spareparts")
    public ResponseEntity<Object> getSpareParts(@RequestParam(name="part", defaultValue = "")String part){
        return ResponseEntity.ok(sparePartService.getSpareParts(part)); // Jackson takes customere of object => json
    }

    @GetMapping(value = "/spareparts/{id}")
    public ResponseEntity<Object> getSparePart(@PathVariable int id){
        return ResponseEntity.ok(sparePartService.getSparePart(id)); // Jackson takes customere of object => json
    }

    @DeleteMapping(value = "/spareparts/{id}")
    public ResponseEntity<Object> deleteSparePart(@PathVariable int id){
        sparePartService.deleteSparePart(id);
        return ResponseEntity.noContent().build(); // De header builder needs a body to work
        // 200 code will be returned
    }

    @PostMapping(value = "/spareparts")
    public ResponseEntity<Object> addSparePart(@Valid @RequestBody SparePartRequestDto sparePartRequestDto){
        int newId = sparePartService.addSparePart(sparePartRequestDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/spareparts/{id}")
    public ResponseEntity<Object> updateSparePart(@PathVariable int id, @RequestBody SparePart sparePart){
        sparePartService.updateSparePart(id, sparePart);

        return ResponseEntity.noContent().build(); // 204 code will be returned
    }

    @PatchMapping(value = "/spareparts/{id}")
    public ResponseEntity<Object> partialUpdateSparePart(@PathVariable int id, @RequestBody SparePart sparePart){
        sparePartService.partialUpdateSparePart(id, sparePart);

        return ResponseEntity.noContent().build(); // 204 code will be returned
    }

}
