package com.colegio.asistencia.repository;

import com.colegio.asistencia.model.Comunicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComunicacionRepository extends JpaRepository<Comunicacion, Long> {
    List<Comunicacion> findByCursoId(Long cursoId);
    List<Comunicacion> findByEstudianteId(Long estudianteId);
    List<Comunicacion> findByTipo(String tipo);
}
