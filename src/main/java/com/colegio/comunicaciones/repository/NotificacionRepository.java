package com.colegio.comunicaciones.repository;

import com.colegio.comunicaciones.model.Notificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    List<Notificacion> findByDestinatario(String destinatario);

    List<Notificacion> findByLeidaFalse();
}
