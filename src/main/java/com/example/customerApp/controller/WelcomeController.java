package com.example.customerApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //it tells spring that this class is rest_controller which handles rest api
    public class WelcomeController {
    @GetMapping("/welcome") // maps http get request
    public String welcome(){
        return "Welcome to HSBC Digital banking";
    }
}
