package com.unla.grupo18.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/clients")
@PreAuthorize("hasAuthority('client')")
public class UserClientController {
    @GetMapping("/dashboard")
    public String getDashboard() {
        return "Bienvenido al área de Cliente";
    }
}
