package nl.novi.garage.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarModelController {

    //Attribute
    private List<String> carModels = new ArrayList<>();

    //Constructor
    public CarModelController() {
        carModels.add("Ceed");
        carModels.add("Forte");
        carModels.add("Picanto");
        carModels.add("Ray");
        carModels.add("Rio");
        carModels.add("K4");
        carModels.add("K5");
        carModels.add("K7");
        carModels.add("K8");
        carModels.add("K9");
        carModels.add("Pegas");
        carModels.add("Stinger");
        carModels.add("Soul");
        carModels.add("EV6");
        carModels.add("KX5");
        carModels.add("KX7");
        carModels.add("Mohave");
        carModels.add("Niro");
        carModels.add("Seltos");
        carModels.add("Sonet");
        carModels.add("Sorento");
        carModels.add("Sportage");
        carModels.add("Stonic");
        carModels.add("Telluride");
        carModels.add("XCeed");
        carModels.add("Carens");
        carModels.add("Carnival");
    }
    @GetMapping(value = "/carmodels")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getCarModels() {
        return carModels;
    }

    @GetMapping(value = "/carmodels/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getCarModel(@PathVariable int id) {
        return carModels.get(id);
    }

    @DeleteMapping(value = "/carmodels/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteCarModel(@PathVariable int id){
        carModels.remove(id);
        return "Deleted!";
    }

    @PostMapping(value = "/carmodels")
    @ResponseStatus(HttpStatus.CREATED)
    public String addCarModel(@RequestBody String carmodel){
        carModels.add(carmodel);
        return "Added!";
    }

}
