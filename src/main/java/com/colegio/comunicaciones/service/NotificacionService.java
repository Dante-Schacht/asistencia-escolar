package com.colegio.comunicaciones.service;

import com.colegio.comunicaciones.exception.ResourceNotFoundException;
import com.colegio.comunicaciones.model.Notificacion;
import com.colegio.comunicaciones.repository.NotificacionRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;

    public List<Notificacion> listar() {
        return notificacionRepository.findAll();
    }

    public Notificacion buscarPorId(Long id) {
        return notificacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notificacion no encontrada con id: " + id));
    }

    public Notificacion crear(Notificacion notificacion) {
        if (notificacion.getFechaCreacion() == null) {
            notificacion.setFechaCreacion(LocalDateTime.now());
        }
        if (notificacion.getLeida() == null) {
            notificacion.setLeida(Boolean.FALSE);
        }
        return notificacionRepository.save(notificacion);
    }

    public Notificacion actualizar(Long id, Notificacion notificacion) {
        Notificacion existente = buscarPorId(id);
        existente.setTitulo(notificacion.getTitulo());
        existente.setDescripcion(notificacion.getDescripcion());
        existente.setDestinatario(notificacion.getDestinatario());
        existente.setFechaCreacion(notificacion.getFechaCreacion());
        existente.setLeida(notificacion.getLeida());
        existente.setTipo(notificacion.getTipo());
        return notificacionRepository.save(existente);
    }

    public void eliminar(Long id) {
        Notificacion existente = buscarPorId(id);
        notificacionRepository.delete(existente);
    }

    public List<Notificacion> listarPorDestinatario(String destinatario) {
        return notificacionRepository.findByDestinatario(destinatario);
    }

    public List<Notificacion> listarNoLeidas() {
        return notificacionRepository.findByLeidaFalse();
    }

    public Notificacion marcarComoLeida(Long id) {
        Notificacion notificacion = buscarPorId(id);
        notificacion.setLeida(Boolean.TRUE);
        return notificacionRepository.save(notificacion);
    }
}
