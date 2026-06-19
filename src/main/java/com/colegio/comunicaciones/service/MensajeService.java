package com.colegio.comunicaciones.service;

import com.colegio.comunicaciones.exception.ResourceNotFoundException;
import com.colegio.comunicaciones.model.Mensaje;
import com.colegio.comunicaciones.repository.MensajeRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MensajeService {

    private final MensajeRepository mensajeRepository;

    public List<Mensaje> listar() {
        return mensajeRepository.findAll();
    }

    public Mensaje buscarPorId(Long id) {
        return mensajeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mensaje no encontrado con id: " + id));
    }

    public Mensaje crear(Mensaje mensaje) {
        if (mensaje.getFechaEnvio() == null) {
            mensaje.setFechaEnvio(LocalDateTime.now());
        }
        if (mensaje.getLeido() == null) {
            mensaje.setLeido(Boolean.FALSE);
        }
        return mensajeRepository.save(mensaje);
    }

    public Mensaje actualizar(Long id, Mensaje mensaje) {
        Mensaje existente = buscarPorId(id);
        existente.setAsunto(mensaje.getAsunto());
        existente.setContenido(mensaje.getContenido());
        existente.setRemitente(mensaje.getRemitente());
        existente.setDestinatario(mensaje.getDestinatario());
        existente.setTipoDestinatario(mensaje.getTipoDestinatario());
        existente.setFechaEnvio(mensaje.getFechaEnvio());
        existente.setLeido(mensaje.getLeido());
        existente.setPrioridad(mensaje.getPrioridad());
        return mensajeRepository.save(existente);
    }

    public void eliminar(Long id) {
        Mensaje existente = buscarPorId(id);
        mensajeRepository.delete(existente);
    }

    public List<Mensaje> listarPorDestinatario(String destinatario) {
        return mensajeRepository.findByDestinatario(destinatario);
    }

    public List<Mensaje> listarPorRemitente(String remitente) {
        return mensajeRepository.findByRemitente(remitente);
    }

    public List<Mensaje> listarPorTipoDestinatario(String tipoDestinatario) {
        return mensajeRepository.findByTipoDestinatario(tipoDestinatario);
    }

    public List<Mensaje> listarNoLeidos() {
        return mensajeRepository.findByLeidoFalse();
    }

    public Mensaje marcarComoLeido(Long id) {
        Mensaje mensaje = buscarPorId(id);
        mensaje.setLeido(Boolean.TRUE);
        return mensajeRepository.save(mensaje);
    }
}
