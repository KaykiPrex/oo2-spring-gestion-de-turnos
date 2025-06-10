package com.unla.grupo18.controller.rest;

import com.unla.grupo18.model.User;
import com.unla.grupo18.services.UserService;
import com.unla.grupo18.services.request.CreateUserRequest;
import com.unla.grupo18.services.response.CreateUserResponse;
import com.unla.grupo18.services.response.GetUserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con la gestión de usuarios")
public class UserController {

    final UserService service;
    private final AuthenticationManager authenticationManager;


    public UserController(UserService service, AuthenticationManager authenticationManager) {
        this.service = service;
        this.authenticationManager = authenticationManager;
    }

    @Operation(summary = "crear nuevo usuario", description = "Registra un nuevo usuario en el sistema")
    @ApiResponse(responseCode = "201",description = "respuesta usuario creado", content = @Content(mediaType = "application/json",schema = @Schema(implementation = CreateUserResponse.class)))
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateUserResponse> create(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del usuario")
            @RequestBody CreateUserRequest createUserRequest) {
        CreateUserResponse response = service.create(createUserRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @Operation(summary = "traer un usuario", description = "Trae un usuario segun el id del sistema")
    @ApiResponse(responseCode = "200", description = "Respuesta exitosa",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponse> get(@PathVariable String id) {
        GetUserResponse response = service.findById(Integer.parseInt(id));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "login de usuario", description = "Se loguea un usuario en el sistema")
    @ApiResponse(responseCode = "200",description = "respuesta exitosa")
    @PostMapping("auth/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok("Login exitoso para el usuario: " + username);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario inválido");
        }
    }

}
