package nl.novi.garage.controller;

import nl.novi.garage.model.Car;
import nl.novi.garage.model.Customer;
import nl.novi.garage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    public ResponseEntity<Object> getCustomers(@RequestParam(name="name", defaultValue = "")String name){
        return ResponseEntity.ok(customerService.getCustomers(name)); // Jackson takes customere of object => json
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable int id){
        return ResponseEntity.ok(customerService.getCustomer(id)); // Jackson takes customere of object => json
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build(); // De header builder needs a body to work
        // 200 code will be returned
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer){
        int newId = customerService.addCustomer(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable int id, @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);

        return ResponseEntity.noContent().build(); // 204 code will be returned
    }

    @PatchMapping(value = "/customers/{id}")
    public ResponseEntity<Object> partialUpdateCustomer(@PathVariable int id, @RequestBody Customer customer){
        customerService.partialUpdateCustomer(id, customer);

        return ResponseEntity.noContent().build(); // 204 code will be returned
    }


}
