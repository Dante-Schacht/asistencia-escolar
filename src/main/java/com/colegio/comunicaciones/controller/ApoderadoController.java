package com.colegio.comunicaciones.controller;

import com.colegio.comunicaciones.exception.ResourceNotFoundException;
import com.colegio.comunicaciones.model.Apoderado;
import com.colegio.comunicaciones.service.ApoderadoService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/apoderados")
@RequiredArgsConstructor
public class ApoderadoController {

    private final ApoderadoService apoderadoService;

    @GetMapping
    public ResponseEntity<List<Apoderado>> listar() {
        return ResponseEntity.ok(apoderadoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apoderado> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(apoderadoService.buscarPorId(id));
    }

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<List<Apoderado>> listarPorEstudianteId(@PathVariable Long estudianteId) {
        return ResponseEntity.ok(apoderadoService.listarPorEstudianteId(estudianteId));
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<Apoderado> buscarPorCorreo(@PathVariable String correo) {
        return apoderadoService.buscarPorCorreo(correo)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Apoderado no encontrado con correo: " + correo));
    }

    @PostMapping
    public ResponseEntity<Apoderado> crear(@Valid @RequestBody Apoderado apoderado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(apoderadoService.crear(apoderado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Apoderado> actualizar(@PathVariable Long id, @Valid @RequestBody Apoderado apoderado) {
        return ResponseEntity.ok(apoderadoService.actualizar(id, apoderado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        apoderadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
