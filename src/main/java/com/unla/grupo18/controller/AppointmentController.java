package com.unla.grupo18.controller;

import com.unla.grupo18.repositories.IAppointmentRepository;
import com.unla.grupo18.model.Appointment;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private IAppointmentRepository appointmentRepository;

    @PutMapping("/{id}/cancelar-turno")
    public <Appointment> ResponseEntity<?> removeClient(@PathVariable Integer id) {
        Optional<com.unla.grupo18.model.Appointment> optionalAppointment = appointmentRepository.findById(id);


        if (optionalAppointment.isPresent()) {
            com.unla.grupo18.model.Appointment appointment = optionalAppointment.get();

            appointment.setClient(null);
            appointmentRepository.save(appointment);
            return ResponseEntity.ok().body("Turno cancelada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El turno no existe.");
        }

    }


}
