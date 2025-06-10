package com.unla.grupo18.controller;

import com.unla.grupo18.infrastructure.notification.MailSender;
import com.unla.grupo18.model.Appointment;
import com.unla.grupo18.services.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.UnsupportedEncodingException;

@Tag(name= "Controlador de appointments", description = "Cancelar turno desde el cliente y desde el profesional")
@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService service;
    private final MailSender mailSender;

    public AppointmentController(AppointmentService service, MailSender mailSender) {
        this.service = service;
        this.mailSender = mailSender;
    }
    @Operation(summary = "Cancelador de turnos desde el cliente", description = "Cancela el turno desde la parte del cliente y se envia un mail")
    @PostMapping("{id}/clients/{clientid}")
    public String deleteClient(@PathVariable int id, @PathVariable int clientid, RedirectAttributes redirectAttributes) throws MessagingException, UnsupportedEncodingException {
        Appointment appointment = service.getAppointmentsById(id) ;
        String clientDisplayName = appointment.getClient().getName() + " " +appointment.getClient().getLastName();
        appointment.deleteClient();
        service.updateAppointment(appointment);
        String to = System.getenv("SENDER_MAIL_TEST");// ONLY FOR TEST //appointment.getProfessional().getContact().getWorkEmail();
        mailSender.send(to,"Turno cancelado","Buen día : El cliente " +clientDisplayName+ " ha cancelado el turno");
        redirectAttributes.addFlashAttribute("mensaje", "Se canceló el turno correctamente.");
        return "redirect:/users/clients/home";
    }

    @Operation(summary = "Cancelador de turnos desde el profesional", description = "Cancela el turno desde la parte del profesional y se envia un mail")
    @PutMapping("/{id}/cancelar-turno")
    public String removeClientForProfessional(@PathVariable Integer id,RedirectAttributes redirectAttributes ) throws MessagingException, UnsupportedEncodingException {
        Appointment appointment = service.getAppointmentsById(id);
        String professionalDisplayName = appointment.getProfessional().getName() + " " +appointment.getProfessional().getLastName();
        appointment.deleteClient();
        service.updateAppointment(appointment);
        String to = System.getenv("SENDER_MAIL_TEST");// ONLY FOR TEST //appointment.getClient().getContact().getWorkEmail();
        mailSender.send(to,"Turno cancelado","Buen día : El profesional " +professionalDisplayName+ " ha cancelado el turno");
        redirectAttributes.addFlashAttribute("mensaje", "Se canceló el turno correctamente.");
        return "redirect:/users/professional/home";
    }

}
