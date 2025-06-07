package com.unla.grupo18.controller;
import com.unla.grupo18.services.UserService;

import com.unla.grupo18.model.Client;
import com.unla.grupo18.model.Role;
import com.unla.grupo18.repositories.IClientRepository;
import com.unla.grupo18.repositories.IRoleRepository;
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
    private final IClientRepository clientRepository;
    @Autowired
    private final IRoleRepository roleRepository;


    public RegisterController(IClientRepository clientRepository, IRoleRepository roleRepository) {
        this.clientRepository = clientRepository;
        this.roleRepository = roleRepository;

    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> payload) {
        System.out.println("Estas en la funcion de registrar usuario");
        String username = payload.get("username");
        String password = payload.get("password");
        String name = payload.get("name");
        String lastName = payload.get("lastName");
        String dni = payload.get("dni");

        if (clientRepository.findByUsername(username).isPresent()) {
            return ResponseEntity.ok("El nombre de usuario ya está en uso");
        }

        Client client = new Client(username, password, name, lastName, dni);

        System.out.println(client);
        Role role = roleRepository.findByName("client")
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        client.setRole(role);
        clientRepository.save(client);

        return ResponseEntity.ok("Usuario registrado correctamente");
    }

}
