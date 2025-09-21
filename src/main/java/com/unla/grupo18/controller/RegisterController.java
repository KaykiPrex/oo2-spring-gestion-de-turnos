package com.unla.grupo18.controller;


import com.unla.grupo18.services.abstraction.IUserService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@RestController
@RequestMapping("/auth")
public class RegisterController {

    private final IUserService service;

    @Autowired
    public RegisterController(IUserService service) {
        this.service = service;
    }
    @Hidden
    @GetMapping("/register")
    public ModelAndView showRegisterPage() {
        return new ModelAndView("register");
    }

    @Hidden
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String password = payload.get("password");
        String name = payload.get("name");
        String lastName = payload.get("lastName");
        String dni = payload.get("dni");

        service.register(username, password, name, lastName, dni);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente");
    }
}

