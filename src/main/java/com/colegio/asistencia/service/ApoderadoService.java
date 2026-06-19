package com.colegio.asistencia.service;

import com.colegio.asistencia.model.Apoderado;
import com.colegio.asistencia.repository.ApoderadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApoderadoService {

    private final ApoderadoRepository repository;

    public ApoderadoService(ApoderadoRepository repository) {
        this.repository = repository;
    }

    public Apoderado guardar(Apoderado apoderado) {
        return repository.save(apoderado);
    }

    public List<Apoderado> listarTodos() {
        return repository.findAll();
    }

    public Optional<Apoderado> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public List<Apoderado> obtenerPorEstudiante(Long estudianteId) {
        return repository.findByEstudianteId(estudianteId);
    }

    public Optional<Apoderado> obtenerPorRut(String rut) {
        return repository.findByRut(rut);
    }

    public List<Apoderado> buscarPorRut(String rut) {
        return repository.findByRutContainingIgnoreCase(rut);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
