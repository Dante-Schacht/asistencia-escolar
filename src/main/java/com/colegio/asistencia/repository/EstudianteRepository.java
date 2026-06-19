package com.colegio.asistencia.repository;

import com.colegio.asistencia.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
	java.util.Optional<Estudiante> findByRut(String rut);
	java.util.List<Estudiante> findByCursoId(Long cursoId);
	java.util.List<Estudiante> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido);
}
