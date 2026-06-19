package com.colegio.comunicaciones.repository;

import com.colegio.comunicaciones.model.Mensaje;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    List<Mensaje> findByDestinatario(String destinatario);

    List<Mensaje> findByRemitente(String remitente);

    List<Mensaje> findByTipoDestinatario(String tipoDestinatario);

    List<Mensaje> findByLeidoFalse();
}
