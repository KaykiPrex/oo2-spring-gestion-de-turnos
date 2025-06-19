package com.unla.grupo18.controller;

import com.unla.grupo18.services.AppointmentServiceImpl;
import com.unla.grupo18.services.abstraction.IAppointmentService;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    private final IAppointmentService service;

    public AppointmentController(AppointmentServiceImpl service) {
        this.service = service;
    }

    @PostMapping("{id}/clients/{clientid}")
    public String deleteClient(@PathVariable int id, @PathVariable int clientid, RedirectAttributes redirectAttributes) throws MessagingException, UnsupportedEncodingException {
        service.cancelAppointmentForProfessionalByAppointmentId(id);
        redirectAttributes.addFlashAttribute("mensaje", "Se canceló el turno correctamente.");
        return "redirect:/users/clients/home";
    }
    @PutMapping("/{id}/cancelar-turno")
    public String removeClientForProfessional(@PathVariable Integer id,RedirectAttributes redirectAttributes ) throws MessagingException, UnsupportedEncodingException {
        service.cancelAppointmentForClientByAppointmentId(id);
        redirectAttributes.addFlashAttribute("mensaje", "Se canceló el turno correctamente.");
        return "redirect:/users/professional/home";
    }

}
