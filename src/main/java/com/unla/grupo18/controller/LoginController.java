package com.unla.grupo18.controller;

import com.unla.grupo18.model.User;
import com.unla.grupo18.repositories.IUserRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class LoginController {
    private final IUserRepository userRepository;

    public LoginController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/login-success")
    public String redirectByRole(HttpSession session, Authentication authentication) {
        var authorities = authentication.getAuthorities();
        validateUserSession(session);

        if (authorities.stream().anyMatch(a -> a.getAuthority().equals("admin"))) {
            return "redirect:users/admin/home";
        } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("client"))) {
            return "redirect:users/clients/home";
        } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("professional"))) {
            return "redirect:users/professionals/home";
        }

        return "redirect:/home";
    }

    private void validateUserSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
                Optional<User> user = userRepository.findByUsername(userDetails.getUsername());
                userId = user.map(User::getId).orElse(null);
                session.setAttribute("userId", userId);
            }
        }
    }
}
