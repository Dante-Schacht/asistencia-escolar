package com.colegio.asistencia.controller;

import com.colegio.asistencia.model.Curso;
import com.colegio.asistencia.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("/{id}")
    public Curso buscarCursoPorId(@PathVariable Long id) {
        return cursoService.buscarCursoPorId(id);
    }

    @PostMapping
    public Curso guardarCurso(@RequestBody Curso curso) {
        return cursoService.guardarCurso(curso);
    }

    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.actualizarCurso(id, curso);
    }

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
    }
}