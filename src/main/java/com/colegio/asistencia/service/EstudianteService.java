package com.colegio.asistencia.service;

import com.colegio.asistencia.model.Estudiante;
import com.colegio.asistencia.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public Estudiante guardar(Estudiante e) {
        return repository.save(e);
    }

    public List<Estudiante> listarTodos() {
        return repository.findAll();
    }
}
