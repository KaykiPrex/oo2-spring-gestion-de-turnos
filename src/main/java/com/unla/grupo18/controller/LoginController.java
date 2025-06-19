package com.unla.grupo18.controller;

import com.unla.grupo18.services.abstraction.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    private final IUserService service;

    public LoginController(IUserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/login-success")
    public String redirectByRole(HttpSession session, Authentication authentication) {
        var authorities = authentication.getAuthorities();
        service.validateUserSession(session);

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
