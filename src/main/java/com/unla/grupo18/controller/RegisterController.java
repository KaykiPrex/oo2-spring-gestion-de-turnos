package com.unla.grupo18.controller;
import com.unla.grupo18.services.clientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
public class RegisterController{


    private final clientService clientService;

    public RegisterController(clientService ClientService) {
        this.clientService = ClientService;

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
