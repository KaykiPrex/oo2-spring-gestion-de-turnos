package com.unla.grupo18;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="Gestor de turnos",version="1.0.0") )
public class Grupo18Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo18Application.class, args);
	}

}
