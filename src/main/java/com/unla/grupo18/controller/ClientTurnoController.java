package com.unla.grupo18.controller;

import com.unla.grupo18.services.abstraction.IAppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Turnos", description = "Controlador para sacar turno en cliente")
@Controller
@RequestMapping("/calendar")
public class ClientTurnoController {

    private final IAppointmentService service;

    public ClientTurnoController(IAppointmentService service) {
        this.service = service;
    }

    @Operation(summary = "Pedir turno", description = "Funcion para que el cliente pida un turno en especifico",  security = @SecurityRequirement(name = "basicAuth"))
    @ApiResponse(responseCode = "200", description = "Respuesta exitosa",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    @PutMapping("/{id}/pedir-turno")
    public ResponseEntity<?> assignClientToAppointment(@PathVariable Integer id) {
        service.assignClientToAppointment(id);
        return ResponseEntity.ok().body("Turno sacado correctamente");
    }


}
