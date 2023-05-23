package com.example.microservicio_materias.models;

import java.util.UUID;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "group_person")
public class GrupoPersona implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Grupo grupo;

}
