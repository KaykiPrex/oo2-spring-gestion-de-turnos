package com.unla.grupo18.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/login-success")
    public String redirectByRole(Authentication authentication) {
        var authorities = authentication.getAuthorities();

        if (authorities.stream().anyMatch(a -> a.getAuthority().equals("admin"))) {
            return "redirect:users/admin/home";
        } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("client"))) {
            return "redirect:users/clients/home";
        } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("professional"))) {
            return "redirect:users/professionals/home";
        }

        return "redirect:/home";
    }
}
