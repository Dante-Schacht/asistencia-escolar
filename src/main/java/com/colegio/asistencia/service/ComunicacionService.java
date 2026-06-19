package com.colegio.asistencia.service;

import com.colegio.asistencia.model.Comunicacion;
import com.colegio.asistencia.repository.ComunicacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComunicacionService {

    private final ComunicacionRepository repository;

    public ComunicacionService(ComunicacionRepository repository) {
        this.repository = repository;
    }

    public Comunicacion registrarComunicacion(Comunicacion comunicacion) {
        return repository.save(comunicacion);
    }

    public List<Comunicacion> obtenerTodas() {
        return repository.findAll();
    }

    public Optional<Comunicacion> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public List<Comunicacion> obtenerPorCurso(Long cursoId) {
        return repository.findByCursoId(cursoId);
    }

    public List<Comunicacion> obtenerPorEstudiante(Long estudianteId) {
        return repository.findByEstudianteId(estudianteId);
    }

    public List<Comunicacion> obtenerPorTipo(String tipo) {
        return repository.findByTipo(tipo);
    }

    public void eliminarComunicacion(Long id) {
        repository.deleteById(id);
    }
}
