package com.colegio.asistencia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Long idAlumno;

    private String nombre;
    private String apellido;

    @Column(name = "curso_id") // Antes era 'curso', ahora es 'curso_id'
    private Long cursoId;

    // Getters y Setters
    public Long getIdAlumno() { return idAlumno; }
    public void setIdAlumno(Long idAlumno) { this.idAlumno = idAlumno; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public Long getCursoId() { return cursoId; }
    public void setCursoId(Long cursoId) { this.cursoId = cursoId; }

    @Override
    public String toString() {
        return "Estudiante{" +
                "idAlumno=" + idAlumno +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cursoId=" + cursoId +
                '}';
    }
}