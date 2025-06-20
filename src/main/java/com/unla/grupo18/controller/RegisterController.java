package com.unla.grupo18.controller;
import com.unla.grupo18.services.UserService;

import com.unla.grupo18.model.Client;
import com.unla.grupo18.model.Role;
import com.unla.grupo18.repositories.IClientRepository;
import com.unla.grupo18.repositories.IRoleRepository;
import com.unla.grupo18.services.clientService;
import com.unla.grupo18.services.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController{
    @Autowired
    private final clientService clientService;
    @Autowired



    public RegisterController(clientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> payload) {

        String username = payload.get("username");
        String password = payload.get("password");
        String name = payload.get("name");
        String lastName = payload.get("lastName");
        String dni = payload.get("dni");

        clientService.createClient(username, password, name, lastName, dni);

        return ResponseEntity.ok("Usuario registrado correctamente");
    }
}
