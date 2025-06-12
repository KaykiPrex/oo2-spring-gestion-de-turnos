package com.unla.grupo18.controller;


import com.unla.grupo18.model.Client;
import com.unla.grupo18.model.Role;
import com.unla.grupo18.repositories.IClientRepository;
import com.unla.grupo18.repositories.IRoleRepository;
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

    private final IClientRepository clientRepository;
    private final IRoleRepository roleRepository;

    @Autowired
    public RegisterController(IClientRepository clientRepository, IRoleRepository roleRepository) {
        this.clientRepository = clientRepository;
        this.roleRepository = roleRepository;
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

        if (clientRepository.findByUsername(username).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El nombre de usuario ya está en uso");
        }

        Client client = new Client(username, password, name, lastName, dni);
        Role role = roleRepository.findByName("client")
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        client.setRole(role);
        clientRepository.save(client);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente");
    }
}
