package com.unla.grupo18.controller;

import com.unla.grupo18.services.abstraction.IAppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calendar")
public class ClientTurnoController {

    private final IAppointmentService service;

    public ClientTurnoController(IAppointmentService service) {
        this.service = service;
    }

    @PutMapping("/{id}/pedir-turno")
    public ResponseEntity<?> assignClientToAppointment(@PathVariable Integer id) {
        service.assignClientToAppointment(id);
        return ResponseEntity.ok().body("Turno sacado correctamente");
    }


}
