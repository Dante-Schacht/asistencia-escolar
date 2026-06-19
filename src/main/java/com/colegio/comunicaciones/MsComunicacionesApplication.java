package com.colegio.comunicaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsComunicacionesApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-comunicaciones");
        SpringApplication.run(MsComunicacionesApplication.class, args);
    }
}
