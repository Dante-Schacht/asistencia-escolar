package com.colegio.asistencia.service;

import com.colegio.asistencia.model.Curso;
import com.colegio.asistencia.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso buscarCursoPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso actualizarCurso(Long id, Curso cursoActualizado) {
        Curso cursoExistente = cursoRepository.findById(id).orElse(null);

        if (cursoExistente != null) {
            cursoExistente.setNombre(cursoActualizado.getNombre());
            return cursoRepository.save(cursoExistente);
        }

        return null;
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}