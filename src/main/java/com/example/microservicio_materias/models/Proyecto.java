package com.example.microservicio_materias.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "projects")
public class Proyecto implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "state")
    private String state;

    @Column(name = "number_of_students")
    private int numberOfStudents;

    @Column(name = "registered_persons")
    private int registeredPersons;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Grupo grupo;

    @Column(name = "semestre")
    private int semestre;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_finalizacion")
    private Date fechaFinalizacion;
}
