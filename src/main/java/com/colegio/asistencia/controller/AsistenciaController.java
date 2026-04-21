package com.colegio.asistencia.controller;

import com.colegio.asistencia.model.Asistencia;
import com.colegio.asistencia.service.AsistenciaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {

    private final AsistenciaService service;

    public AsistenciaController(AsistenciaService service) {
        this.service = service;
    }

    @PostMapping("/registrar")
    public Asistencia registrar(@RequestBody Asistencia asistencia) {
        return service.registrarAsistencia(asistencia);
    }

    @GetMapping("/todas")
    public List<Asistencia> verTodas() {
        return service.obtenerTodas();
    }

    @GetMapping("/historial/{estudianteId}")
    public List<Asistencia> verHistorial(@PathVariable Long estudianteId) {
        return service.obtenerAsistenciaPorEstudiante(estudianteId);
    }

    @GetMapping("/curso/{cursoId}")
    public List<Asistencia> verPorCurso(@PathVariable Long cursoId) {
        return service.obtenerAsistenciaPorCurso(cursoId);
    }
}