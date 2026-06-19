package com.colegio.comunicaciones.controller;

import com.colegio.comunicaciones.model.Notificacion;
import com.colegio.comunicaciones.service.NotificacionService;
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
@RequestMapping("/api/notificaciones")
@RequiredArgsConstructor
public class NotificacionController {

    private final NotificacionService notificacionService;

    @GetMapping
    public ResponseEntity<List<Notificacion>> listar() {
        return ResponseEntity.ok(notificacionService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(notificacionService.buscarPorId(id));
    }

    @GetMapping("/destinatario/{destinatario}")
    public ResponseEntity<List<Notificacion>> listarPorDestinatario(@PathVariable String destinatario) {
        return ResponseEntity.ok(notificacionService.listarPorDestinatario(destinatario));
    }

    @GetMapping("/no-leidas")
    public ResponseEntity<List<Notificacion>> listarNoLeidas() {
        return ResponseEntity.ok(notificacionService.listarNoLeidas());
    }

    @PostMapping
    public ResponseEntity<Notificacion> crear(@Valid @RequestBody Notificacion notificacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificacionService.crear(notificacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacion> actualizar(@PathVariable Long id, @Valid @RequestBody Notificacion notificacion) {
        return ResponseEntity.ok(notificacionService.actualizar(id, notificacion));
    }

    @PutMapping("/{id}/leer")
    public ResponseEntity<Notificacion> marcarComoLeida(@PathVariable Long id) {
        return ResponseEntity.ok(notificacionService.marcarComoLeida(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        notificacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
