
package com.example.microservicio_materias.models;

import java.util.UUID;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "project_person")
public class ProyectoPersona implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Proyecto proyecto;

    @Column(name = "state")
    private boolean state;

}
