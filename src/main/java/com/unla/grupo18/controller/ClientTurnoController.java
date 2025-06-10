package com.unla.grupo18.controller;
import com.unla.grupo18.repositories.IAppointmentRepository;
import com.unla.grupo18.model.Client;
import com.unla.grupo18.model.Appointment;
import com.unla.grupo18.model.ProfessionalService;

import com.unla.grupo18.services.ProfessionalServiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.List;


import java.util.Optional;
@Tag(name= "Controlador turno", description = "Controlador para sacar turno en cliente")
@RestController
@RequestMapping("/calendar")
public class ClientTurnoController {

    @Autowired
    private IAppointmentRepository appointmentRepository;
    @Operation(summary = "Pedir turno", description = "Funcion para que el cliente pida un turno en especifico")
    @PutMapping("/{id}/pedir-turno")
    public ResponseEntity<?> assignClientToAppointment(@PathVariable Integer id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Client client = (Client) authentication.getPrincipal();

        System.out.println("cliente: " + client);
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()) {
            com.unla.grupo18.model.Appointment appointment = optionalAppointment.get();

            appointment.setClient(client);
            appointmentRepository.save(appointment);
            return ResponseEntity.ok().body("Turno sacado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo sacar turno");
        }
    }


}
