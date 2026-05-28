package com.colegio.asistencia.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "asistencias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Long idAsistencia;

    @Column(name = "fecha", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "estudiante_id", nullable = false)
    private Long estudianteId;

    @Column(name = "curso_id", nullable = false)
    private Long cursoId;
}