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
@Table(name = "notificaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El titulo no puede estar vacio")
    private String titulo;

    @NotBlank(message = "La descripcion no puede estar vacia")
    private String descripcion;

    @NotBlank(message = "El destinatario no puede estar vacio")
    private String destinatario;

    @NotNull(message = "La fechaCreacion no puede ser nula")
    private LocalDateTime fechaCreacion;

    @NotNull(message = "El estado leida no puede ser nulo")
    private Boolean leida;

    @NotBlank(message = "El tipo no puede estar vacio")
    private String tipo;
}
