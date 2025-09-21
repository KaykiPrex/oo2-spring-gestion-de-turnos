package com.unla.grupo18.controller;

import com.unla.grupo18.model.Appointment;
import com.unla.grupo18.model.AppointmentDate;
import com.unla.grupo18.model.Client;
import com.unla.grupo18.repositories.IAppointmentDateRepository;
import com.unla.grupo18.repositories.IAppointmentRepository;
import com.unla.grupo18.services.AppointmentServiceImpl;
import com.unla.grupo18.services.abstraction.IAppointmentDateService;
import com.unla.grupo18.services.abstraction.IAppointmentService;
import com.unla.grupo18.services.abstraction.IProfessionalServiceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/users/professionals")
@PreAuthorize("hasAuthority('professional')")
public class UserProfessionalController {
    private final IAppointmentService appointmentService;
    private final IProfessionalServiceService professionalServiceService;
    private final IAppointmentDateService appointmentDateRepository;

    public UserProfessionalController(AppointmentServiceImpl appointmentService, IProfessionalServiceService professionalServiceService, IAppointmentDateService appointmentDateRepository) {
        this.appointmentService = appointmentService;
        this.professionalServiceService = professionalServiceService;
        this.appointmentDateRepository = appointmentDateRepository;
    }

    @GetMapping("/home")
    public String getHome(HttpSession session, Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer userId = (Integer) session.getAttribute("userId");
        model.addAttribute("userId", userId);
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
    public String mostrarFormulario(HttpSession session, Model model) {
        try {
            model.addAttribute("appointment", new Appointment());
            model.addAttribute("services", professionalServiceService.getServicesByProfessional(session));
            List<AppointmentDate> appointmentDates = appointmentDateRepository.getAllAppointmentDate();
            model.addAttribute("appointmentDates", appointmentDates);
            return "/professional/home/new-appointment";
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @PostMapping("/appointments/save")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment, @RequestParam("appointmentDateId") int dateId, Model model) {
        try {
            AppointmentDate appointmentDate = appointmentDateRepository.getAppointmentDateById(dateId);
            appointment.setAppointmentDate(appointmentDate);
            appointmentService.create(appointment);
            model.addAttribute("appointment", new Appointment());
            return "/professional/home/new-appointment";
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
