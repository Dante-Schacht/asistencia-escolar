package com.colegio.asistencia.service;

import com.colegio.asistencia.model.Asistencia;
import com.colegio.asistencia.repository.AsistenciaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AsistenciaService {

    private final AsistenciaRepository repository;

    public AsistenciaService(AsistenciaRepository repository) {
        this.repository = repository;
    }

    public Asistencia registrarAsistencia(Asistencia asistencia) {
        return repository.save(asistencia);
    }

    public List<Asistencia> obtenerTodas() {
        return repository.findAll();
    }

    public List<Asistencia> obtenerAsistenciaPorEstudiante(Long estudianteId) {
        return repository.findByEstudianteId(estudianteId);
    }

    public List<Asistencia> obtenerAsistenciaPorCurso(Long cursoId) {
        return repository.findByCursoId(cursoId);
    }
}