package com.colegio.comunicaciones.service;

import com.colegio.comunicaciones.exception.ResourceNotFoundException;
import com.colegio.comunicaciones.model.Apoderado;
import com.colegio.comunicaciones.repository.ApoderadoRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApoderadoService {

    private final ApoderadoRepository apoderadoRepository;

    public List<Apoderado> listar() {
        return apoderadoRepository.findAll();
    }

    public Apoderado buscarPorId(Long id) {
        return apoderadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Apoderado no encontrado con id: " + id));
    }

    public Apoderado crear(Apoderado apoderado) {
        return apoderadoRepository.save(apoderado);
    }

    public Apoderado actualizar(Long id, Apoderado apoderado) {
        Apoderado existente = buscarPorId(id);
        existente.setRut(apoderado.getRut());
        existente.setNombre(apoderado.getNombre());
        existente.setApellido(apoderado.getApellido());
        existente.setCorreo(apoderado.getCorreo());
        existente.setTelefono(apoderado.getTelefono());
        existente.setDireccion(apoderado.getDireccion());
        existente.setEstudianteId(apoderado.getEstudianteId());
        existente.setParentesco(apoderado.getParentesco());
        return apoderadoRepository.save(existente);
    }

    public void eliminar(Long id) {
        Apoderado existente = buscarPorId(id);
        apoderadoRepository.delete(existente);
    }

    public List<Apoderado> listarPorEstudianteId(Long estudianteId) {
        return apoderadoRepository.findByEstudianteId(estudianteId);
    }

    public Optional<Apoderado> buscarPorCorreo(String correo) {
        return apoderadoRepository.findByCorreo(correo);
    }
}
