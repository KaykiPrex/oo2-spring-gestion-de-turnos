package com.unla.grupo18.controller;

import com.unla.grupo18.model.Appointment;
import com.unla.grupo18.model.Client;
import com.unla.grupo18.model.Professional;
import com.unla.grupo18.services.AppointmentService;
import com.unla.grupo18.services.ServiceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users/professionals")
@PreAuthorize("hasAuthority('professional')")
public class UserProfessionalController {
    private final AppointmentService appointmentService;
    private final AppointmentService service;
    private final ServiceService serviceService;
    public UserProfessionalController(AppointmentService appointmentService, AppointmentService service, ServiceService serviceService) {
        this.appointmentService = appointmentService;
        this.service = service;
        this.serviceService = serviceService;
    }

    @GetMapping("/home")
    public String getHome(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");

        model.addAttribute("userId", userId);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        model.addAttribute("username", username);
        return "professional/home";
    }

    @GetMapping("/appointments/{userId}")
    public String getAppointments(Model model, @PathVariable int userId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByProfessional(userId);
        model.addAttribute("appointments", appointments);
        return "professional/home/appointments";
    }

    @GetMapping("/appointments/{userId}/today")
    public String getAppointmentsToday(Model model, @PathVariable int userId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByToday(userId);
        model.addAttribute("appointments", appointments);
        return "professional/home/appointments-today";
    }

    @GetMapping("/{userId}/clients")
    public String getClientsForProfessional(Model model, @PathVariable int userId) {
        List<Client> clients = appointmentService.getClientsByProfessional(userId);
        model.addAttribute("clients", clients);
        return "professional/home/clients";
    }

    @GetMapping("/appointments/new")
    public String mostrarFormulario(Model model) {
        try {
            model.addAttribute("appointment", new Appointment());
            model.addAttribute("services", serviceService.findAll());
            return "/professional/home/new-appointment";
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @PostMapping("/appointments/save")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment,
                                  RedirectAttributes redirectAttributes, Model model) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Professional professional = (Professional) auth.getPrincipal();

            appointment.setProfessional(professional);

            service.save(appointment);
            model.addAttribute("appointment", new Appointment());
          return "/professional/home/new-appointment";
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
