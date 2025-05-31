package com.unla.grupo18.controller;

import com.unla.grupo18.model.Appointment;
import com.unla.grupo18.services.AppointmentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users/professionals")
@PreAuthorize("hasAuthority('professional')")
public class UserProfessionalController {
    private final AppointmentService appointmentService;

    public UserProfessionalController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/home")
    public String getHome(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");

        model.addAttribute("userId", userId);
        return "professional/home";
    }

    @GetMapping("/appointments/{userId}")
    public String getAppointments(Model model, @PathVariable int userId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByProfessional(userId);
        model.addAttribute("appointments", appointments);
        return "professional/home/appointments";
    }

}
