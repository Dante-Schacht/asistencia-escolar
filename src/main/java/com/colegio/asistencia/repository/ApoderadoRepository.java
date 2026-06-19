package com.colegio.asistencia.repository;

import com.colegio.asistencia.model.Apoderado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApoderadoRepository extends JpaRepository<Apoderado, Long> {
    List<Apoderado> findByEstudianteId(Long estudianteId);
    Optional<Apoderado> findByRut(String rut);
    List<Apoderado> findByRutContainingIgnoreCase(String rut);
}
