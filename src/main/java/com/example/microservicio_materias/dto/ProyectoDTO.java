package com.example.microservicio_materias.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.example.microservicio_materias.models.Grupo;
import com.example.microservicio_materias.models.Persona;
import com.example.microservicio_materias.models.Proyecto;

import lombok.Data;

@Data
public class ProyectoDTO {
    private UUID id;
    private String name;
    private String description;
    private String state;
    private int numberOfStudents;
    private int registeredPersons;
    private Grupo grupo;
    private int semestre;
    private Date fechaInicio;
    private Date fechaFinalizacion;

    private List<Persona> personas;

    public ProyectoDTO(Proyecto proyecto) {
        this.id = proyecto.getId();
        this.name = proyecto.getName();
        this.description = proyecto.getDescription();
        this.state = proyecto.getState();
        this.numberOfStudents = proyecto.getNumberOfStudents();
        this.registeredPersons = proyecto.getRegisteredPersons();
        this.grupo = proyecto.getGrupo();
        this.semestre = proyecto.getSemestre();
        this.fechaInicio = proyecto.getFechaInicio();
        this.fechaFinalizacion = proyecto.getFechaFinalizacion();
    }

}
