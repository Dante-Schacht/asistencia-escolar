package com.colegio.asistencia.service;

import com.colegio.asistencia.model.Estudiante;
import com.colegio.asistencia.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public Estudiante guardar(Estudiante e) {
        return repository.save(e);
    }

    public Estudiante actualizar(Long id, Estudiante datos) {
        Estudiante existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado: " + id));
        existente.setNombre(datos.getNombre());
        existente.setApellido(datos.getApellido());
        existente.setCursoId(datos.getCursoId());
        if (datos.getRut() != null) existente.setRut(datos.getRut());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Optional<Estudiante> obtenerPorRut(String rut) {
        return repository.findByRut(rut);
    }

    public List<Estudiante> obtenerPorCurso(Long cursoId) {
        return repository.findByCursoId(cursoId);
    }

    public List<Estudiante> buscar(String q) {
        return repository.findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(q, q);
    }

    public List<Estudiante> listarTodos() {
        return repository.findAll();
    }

    public Optional<Estudiante> obtenerPorId(Long id) {
        return repository.findById(id);
    }
}
