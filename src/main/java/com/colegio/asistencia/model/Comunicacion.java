package com.colegio.asistencia.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import tools.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "comunicaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comunicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comunicacion")
    @JsonProperty("id")
    private Long idComunicacion;

    @JsonProperty("asunto")
    @JsonAlias({"titulo", "asunto", "subject"})
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @JsonAlias({"mensaje", "contenido", "texto", "descripcion", "body", "message", "content"})
    @Column(name = "mensaje", nullable = false, length = 1000)
    private String mensaje;

    @JsonAlias({"tipo", "type", "categoria"})
    @Column(name = "tipo", nullable = false)
    private String tipo;

    @JsonProperty("remitente")
    @JsonAlias({"emisor", "remitente", "autor", "from", "sender"})
    @Column(name = "emisor", nullable = false)
    private String emisor;

    @JsonProperty("destinatario")
    @JsonAlias({"destinatario", "receptor", "para", "to"})
    @Column(name = "destinatario")
    private String destinatario;

    @JsonAlias({"prioridad", "priority"})
    @Column(name = "prioridad")
    private String prioridad;

    @JsonAlias({"estado", "status", "leido"})
    @Column(name = "estado")
    private String estado;

    @JsonProperty("fechaEnvio")
    @JsonAlias({"fecha", "fechaEnvio", "date"})
    @JsonDeserialize(using = FlexibleLocalDateDeserializer.class)
    @Column(name = "fecha", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @PrePersist
    public void prePersist() {
        if (fecha == null) {
            fecha = LocalDate.now();
        }
        if (emisor == null || emisor.isBlank()) {
            emisor = "Colegio";
        }
        if (tipo == null || tipo.isBlank()) {
            tipo = "General";
        }
        if (titulo == null || titulo.isBlank()) {
            titulo = "Sin t\u00edtulo";
        }
        if (mensaje == null || mensaje.isBlank()) {
            mensaje = "";
        }
        if (estado == null || estado.isBlank()) {
            estado = "No leido";
        }
        if (prioridad == null || prioridad.isBlank()) {
            prioridad = "Normal";
        }
    }

    @Column(name = "curso_id")
    private Long cursoId;

    @Column(name = "estudiante_id")
    private Long estudianteId;
}
