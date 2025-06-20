package com.unla.grupo18.controller;
import com.unla.grupo18.repositories.IClientRepository;
import com.unla.grupo18.model.Appointment;
import com.unla.grupo18.model.Category;
import com.unla.grupo18.model.Client;
import com.unla.grupo18.services.AppointmentService;
import com.unla.grupo18.services.CategoryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users/clients")
@PreAuthorize("hasAuthority('client')")

public class UserClientController {
    private final AppointmentService appointmentService;
    private final CategoryService categoryService;

    public UserClientController(AppointmentService appointmentService, CategoryService categoryService) {
        this.appointmentService = appointmentService;
        this.categoryService = categoryService;
    }

    @GetMapping("/home")
    public String getDashboard(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        model.addAttribute("userId", userId);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        model.addAttribute("username", username);
        return "client/home";
    }

    @GetMapping("/appointments")
    public String getAppointments(Model model, Principal principal) {
        List<Appointment> appointments = appointmentService.getAppointmentsForClient(principal);
        model.addAttribute("appointments", appointments);
        return "client/home/appointments";
    }

    @GetMapping("/categories")
    public String getCategories(Model model) {
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "client/home/categories";
    }
}
