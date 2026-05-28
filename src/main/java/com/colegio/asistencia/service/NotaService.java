package com.colegio.asistencia.service;

import com.colegio.asistencia.model.Nota;
import com.colegio.asistencia.repository.NotaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotaService {

    private final NotaRepository repository;

    public NotaService(NotaRepository repository) {
        this.repository = repository;
    }

    public Nota guardarNota(Nota nota) {
        return repository.save(nota);
    }

    public List<Nota> obtenerTodas() {
        return repository.findAll();
    }

    public List<Nota> obtenerNotasPorEstudiante(Long estudianteId) {
        return repository.findByEstudianteId(estudianteId);
    }
}
