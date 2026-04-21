package com.colegio.asistencia.controller;

import com.colegio.asistencia.model.Estudiante;
import com.colegio.asistencia.service.EstudianteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @PostMapping("/crear")
    public Estudiante crear(@RequestBody Estudiante estudiante) {
        return service.guardar(estudiante);
    }

    @GetMapping("/todos")
    public List<Estudiante> verTodos() {
        return service.listarTodos();
    }
}
