package com.vetapp.vetapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Vet-app", version = "1.0", description = "Veterinary app"))

public class VetAppApplication {


    public static void main(String[] args) {
        SpringApplication.run(VetAppApplication.class, args);
    }

}
