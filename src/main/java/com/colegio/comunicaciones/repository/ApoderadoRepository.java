package com.colegio.comunicaciones.repository;

import com.colegio.comunicaciones.model.Apoderado;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApoderadoRepository extends JpaRepository<Apoderado, Long> {

    List<Apoderado> findByEstudianteId(Long estudianteId);

    Optional<Apoderado> findByCorreo(String correo);
}
