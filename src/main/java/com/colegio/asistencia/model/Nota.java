package com.colegio.asistencia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Long idNota;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "materia", nullable = false)
    private String materia;

    @Column(name = "calificacion", nullable = false)
    private Double calificacion;

    @Column(name = "estudiante_id", nullable = false)
    private Long estudianteId;
}