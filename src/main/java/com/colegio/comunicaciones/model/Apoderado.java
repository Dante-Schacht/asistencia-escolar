package com.colegio.comunicaciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "apoderados")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Apoderado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El rut no puede estar vacio")
    private String rut;

    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacio")
    private String apellido;

    @Email(message = "El correo debe tener formato valido")
    @NotBlank(message = "El correo no puede estar vacio")
    private String correo;

    @NotBlank(message = "El telefono no puede estar vacio")
    private String telefono;

    private String direccion;

    @NotNull(message = "El estudianteId no puede ser nulo")
    private Long estudianteId;

    @NotBlank(message = "El parentesco no puede estar vacio")
    private String parentesco;
}
