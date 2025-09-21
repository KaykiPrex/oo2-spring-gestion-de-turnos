package com.unla.grupo18.controller;

import com.unla.grupo18.services.AppointmentServiceImpl;
import com.unla.grupo18.services.abstraction.IAppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;

@Tag(name= "Turnos", description = "Operaciones relacionadas con la gestión de turnos")
@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    private final IAppointmentService service;

    public AppointmentController(AppointmentServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Cancelador de turnos desde el cliente", description = "Cancela el turno desde la parte del cliente y se envia un mail", security = @SecurityRequirement(name = "basicAuth"))
    @PostMapping("{id}/clients/{clientid}")
    public String deleteClient(@PathVariable int id, RedirectAttributes redirectAttributes) throws MessagingException, UnsupportedEncodingException {
        service.cancelAppointmentForProfessionalByAppointmentId(id);
        redirectAttributes.addFlashAttribute("mensaje", "Se canceló el turno correctamente.");
        return "redirect:/users/clients/home";
    }

    @Operation(summary = "Cancelador de turnos desde el profesional", description = "Cancela el turno desde la parte del profesional y se envia un mail", security = @SecurityRequirement(name = "basicAuth"))
    @PutMapping("/{id}/cancelar-turno")
    public String removeClientForProfessional(@PathVariable Integer id,RedirectAttributes redirectAttributes ) throws MessagingException, UnsupportedEncodingException {
        service.cancelAppointmentForClientByAppointmentId(id);
        redirectAttributes.addFlashAttribute("mensaje", "Se canceló el turno correctamente.");
        return "redirect:/users/professional/home";
    }

}
