package com.colegio.comunicaciones.controller;

import com.colegio.comunicaciones.model.Mensaje;
import com.colegio.comunicaciones.service.MensajeService;
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
@RequestMapping("/api/mensajes")
@RequiredArgsConstructor
public class MensajeController {

    private final MensajeService mensajeService;

    @GetMapping
    public ResponseEntity<List<Mensaje>> listar() {
        return ResponseEntity.ok(mensajeService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensaje> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mensajeService.buscarPorId(id));
    }

    @GetMapping("/destinatario/{destinatario}")
    public ResponseEntity<List<Mensaje>> listarPorDestinatario(@PathVariable String destinatario) {
        return ResponseEntity.ok(mensajeService.listarPorDestinatario(destinatario));
    }

    @GetMapping("/remitente/{remitente}")
    public ResponseEntity<List<Mensaje>> listarPorRemitente(@PathVariable String remitente) {
        return ResponseEntity.ok(mensajeService.listarPorRemitente(remitente));
    }

    @GetMapping("/tipo-destinatario/{tipoDestinatario}")
    public ResponseEntity<List<Mensaje>> listarPorTipoDestinatario(@PathVariable String tipoDestinatario) {
        return ResponseEntity.ok(mensajeService.listarPorTipoDestinatario(tipoDestinatario));
    }

    @GetMapping("/no-leidos")
    public ResponseEntity<List<Mensaje>> listarNoLeidos() {
        return ResponseEntity.ok(mensajeService.listarNoLeidos());
    }

    @PostMapping
    public ResponseEntity<Mensaje> crear(@Valid @RequestBody Mensaje mensaje) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mensajeService.crear(mensaje));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mensaje> actualizar(@PathVariable Long id, @Valid @RequestBody Mensaje mensaje) {
        return ResponseEntity.ok(mensajeService.actualizar(id, mensaje));
    }

    @PutMapping("/{id}/leer")
    public ResponseEntity<Mensaje> marcarComoLeido(@PathVariable Long id) {
        return ResponseEntity.ok(mensajeService.marcarComoLeido(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        mensajeService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
