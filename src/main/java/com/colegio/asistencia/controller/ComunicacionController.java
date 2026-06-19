package com.colegio.asistencia.controller;

import com.colegio.asistencia.model.Comunicacion;
import com.colegio.asistencia.service.ComunicacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping({"/api/comunicaciones", "/api/mensajes", "/api/notificaciones"})
public class ComunicacionController {

    private final ComunicacionService service;

    public ComunicacionController(ComunicacionService service) {
        this.service = service;
    }

    @PostMapping("/registrar")
    public Comunicacion registrar(@RequestBody Comunicacion comunicacion) {
        return service.registrarComunicacion(comunicacion);
    }

    @PostMapping({"", "/"})
    public Comunicacion crear(@RequestBody Comunicacion comunicacion) {
        return service.registrarComunicacion(comunicacion);
    }

    @GetMapping("/todas")
    public List<Comunicacion> verTodas() {
        return service.obtenerTodas();
    }

    @GetMapping({"", "/"})
    public List<Comunicacion> listar() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comunicacion> verPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/curso/{cursoId}")
    public List<Comunicacion> verPorCurso(@PathVariable Long cursoId) {
        return service.obtenerPorCurso(cursoId);
    }

    @GetMapping("/estudiante/{estudianteId}")
    public List<Comunicacion> verPorEstudiante(@PathVariable Long estudianteId) {
        return service.obtenerPorEstudiante(estudianteId);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Comunicacion> verPorTipo(@PathVariable String tipo) {
        return service.obtenerPorTipo(tipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarComunicacion(id);
        return ResponseEntity.noContent().build();
    }
}
