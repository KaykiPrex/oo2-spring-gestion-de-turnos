package com.unla.grupo18.controller;
import com.unla.grupo18.infrastructure.exception.EntityNotFoundException;
import com.unla.grupo18.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/calendar")
public class ClientTurnoController {

    @Autowired
    private AppointmentService appointmentService;
    @PutMapping("/{id}/pedir-turno")
    public ResponseEntity<?> assignClientToAppointment(@PathVariable int id) {

        try {
            appointmentService.assignClientToAppointment(id);
            return ResponseEntity.ok("Turno sacado correctamente");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo sacar turno");
        }

    }


}
