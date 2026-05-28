package com.colegio.asistencia.controller;

import com.colegio.asistencia.model.Nota;
import com.colegio.asistencia.service.NotaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/notas")
public class NotaController {

    private final NotaService service;

    public NotaController(NotaService service) {
        this.service = service;
    }

    @PostMapping("/registrar")
    public Nota registrar(@RequestBody Nota nota) {
        return service.guardarNota(nota);
    }

    @GetMapping("/todas")
    public List<Nota> obtenerTodas() {
        return service.obtenerTodas();
    }

    @GetMapping("/estudiante/{estudianteId}")
    public List<Nota> obtenerNotasPorEstudiante(@PathVariable Long estudianteId) {
        return service.obtenerNotasPorEstudiante(estudianteId);
    }
}
