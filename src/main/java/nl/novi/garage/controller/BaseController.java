package nl.novi.garage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping(value = "/welcome")
    public String welcomeGarage(){
        return "Welcome to the Garage webservice";
    }

    @GetMapping(value = "/goodbye")
    public String goodbyeGarage(){
        return "Goodbye, you are leaving the Garage webservice. Have a nice day!";
    }

    @RequestMapping(value = "/")
    public String index() {
        return "Endpoint: POST /file-upload";
    }

}
