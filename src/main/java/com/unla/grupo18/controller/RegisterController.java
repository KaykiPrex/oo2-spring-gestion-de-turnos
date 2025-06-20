package com.unla.grupo18.controller;

import com.unla.grupo18.services.clientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class RegisterController{
    @Autowired
    private final clientService clientService;
    @Autowired



    public RegisterController(clientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/register")
    public ModelAndView showRegisterPage() {
        return new ModelAndView("register");
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> payload) {

        String username = payload.get("username");
        String password = payload.get("password");
        String name = payload.get("name");
        String lastName = payload.get("lastName");
        String dni = payload.get("dni");

        clientService.createClient(username, password, name, lastName, dni);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente");
    }
}
