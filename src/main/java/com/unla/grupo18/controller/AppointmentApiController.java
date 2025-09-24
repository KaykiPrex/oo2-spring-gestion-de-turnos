package com.unla.grupo18.controller;

import com.unla.grupo18.model.Appointment;
import com.unla.grupo18.services.AppointmentServiceImpl;
import com.unla.grupo18.services.abstraction.IAppointmentService;
import com.unla.grupo18.services.response.GetAppointmentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;

@Tag(name= "Appointment", description = "Operaciones relacionadas con la gestión de turnos")
@RestController
@RequestMapping("/api/appointments")
public class AppointmentApiController {
    private final IAppointmentService service;

    public AppointmentApiController(AppointmentServiceImpl service) {
        this.service = service;
    }

    @Operation(
            summary = "Traer un appointment",
            description = "Trae un appointment según el ID del sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Appointment.class))),
            @ApiResponse(responseCode = "404", description = "Appointment no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<GetAppointmentResponse> getAppointmentById(@PathVariable String id) {
        GetAppointmentResponse response = service.getAppointmentById(Integer.parseInt(id));
        return ResponseEntity.ok(response);
    }


    @Operation(summary = "Cancelador de turnos desde el profesional", description = "Cancela el turno desde la parte del profesional y se envia un mail", security = @SecurityRequirement(name = "basicAuth"))
    @PostMapping ("/{id}/cancelar-turno")
    public ResponseEntity<String> cancelarTurnoApi(@PathVariable Integer id) throws MessagingException, UnsupportedEncodingException {
        try {
            service.cancelAppointmentForClientByAppointmentId(id);
            return ResponseEntity.ok("Se cancelo el turno y se envio el mail");
        }catch(Exception e){
            return ResponseEntity.internalServerError().body("Hubo un error");
        }
    }
}