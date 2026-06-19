package com.colegio.asistencia.controller;

import com.colegio.asistencia.model.Apoderado;
import com.colegio.asistencia.service.ApoderadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/apoderados")
public class ApoderadoController {

    private final ApoderadoService service;

    public ApoderadoController(ApoderadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Apoderado> listarApoderados() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apoderado> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estudiante/{estudianteId}")
    public List<Apoderado> obtenerPorEstudiante(@PathVariable Long estudianteId) {
        return service.obtenerPorEstudiante(estudianteId);
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<Apoderado> obtenerPorRut(@PathVariable String rut) {
        return service.obtenerPorRut(rut)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/rut")
    public List<Apoderado> buscarPorRut(@RequestParam String q) {
        return service.buscarPorRut(q);
    }

    @PostMapping
    public Apoderado crearApoderado(@RequestBody Apoderado apoderado) {
        return service.guardar(apoderado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarApoderado(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
