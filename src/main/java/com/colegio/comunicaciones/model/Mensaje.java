package com.colegio.comunicaciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mensajes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El asunto no puede estar vacio")
    private String asunto;

    @NotBlank(message = "El contenido no puede estar vacio")
    private String contenido;

    @NotBlank(message = "El remitente no puede estar vacio")
    private String remitente;

    @NotBlank(message = "El destinatario no puede estar vacio")
    private String destinatario;

    @NotBlank(message = "El tipoDestinatario no puede estar vacio")
    private String tipoDestinatario;

    @NotNull(message = "La fechaEnvio no puede ser nula")
    private LocalDateTime fechaEnvio;

    @NotNull(message = "El estado leido no puede ser nulo")
    private Boolean leido;

    @NotBlank(message = "La prioridad no puede estar vacia")
    private String prioridad;
}
