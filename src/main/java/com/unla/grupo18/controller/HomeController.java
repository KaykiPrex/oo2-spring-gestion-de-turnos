package com.unla.grupo18.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Hidden
    @GetMapping()
    public String getDashboard() {
        return "Bienvenido al área de Home";
    }

}
