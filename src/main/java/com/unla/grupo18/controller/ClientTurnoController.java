package com.unla.grupo18.controller;

import com.unla.grupo18.model.*;
import com.unla.grupo18.services.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Tag(name = "Controlador turno", description = "Controlador para sacar turno en cliente")
@Controller
@RequestMapping("/calendar")
public class ClientTurnoController {

    @Autowired
    private AppointmentService appointmentService;

    @Operation(summary = "Pedir turno", description = "Funcion para que el cliente pida un turno en especifico",  security = @SecurityRequirement(name = "basicAuth"))
    @ApiResponse(responseCode = "200", description = "Respuesta exitosa",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    @PutMapping("/{id}/pedir-turno")
    public ResponseEntity<?> assignClientToAppointment(@PathVariable Integer id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Client client = (Client) authentication.getPrincipal();

        if (appointmentService.saveClient(id, client))
            return ResponseEntity.ok().body("Turno sacado correctamente");
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo sacar turno");
    }


}
