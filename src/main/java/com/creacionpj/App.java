package com.creacionpj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition (info = @Info(
    title = "API Creación de Personajes PF2e",
    version = "0.1",
    description="Motor de reglas para creación y gestión de personajes de Pathfinder Segunda Edición"
))

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}