package nl.novi.garage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping(value = "/welcome")
    public ResponseEntity<String> welcomeGarage(){
        return ResponseEntity.ok().body("Welcome to the Garage webservice");
    }

//    @GetMapping(value = "/")
//    public ResponseEntity<Object> index() {
//        return ResponseEntity.ok().body("Hello World");
//    }

    @GetMapping(value = "/goodbye")
    public ResponseEntity<String> goodbyeGarage(){
        return ResponseEntity.ok().body("Goodbye, you are leaving the Garage webservice. Have a nice day!");
    }

    @RequestMapping(value = "/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok().body("Endpoint: POST /file-upload");
    }

}
