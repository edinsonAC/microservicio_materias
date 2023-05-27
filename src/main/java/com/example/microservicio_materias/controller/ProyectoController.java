package com.example.microservicio_materias.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicio_materias.dto.ProyectoDTO;
import com.example.microservicio_materias.models.Proyecto;
import com.example.microservicio_materias.models.ProyectoPersona;
import com.example.microservicio_materias.service.ProyectoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api-subject/project")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("/all")
    public ResponseEntity<List<Proyecto>> listarProyecto() {
        List<Proyecto> proyectos = proyectoService.findAll();
        return new ResponseEntity<List<Proyecto>>(proyectos, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Proyecto> guardarProyecto(@RequestBody Proyecto proyecto) {

        // if (proyecto.getFechaInicio() != null) {
        // Date in = new Date(proyecto.getFechaInicio())
        // }
        System.out.println("el proyecto >>> " + proyecto.toString());

        Proyecto gru = proyectoService.saveGroup(proyecto);
        return new ResponseEntity<Proyecto>(gru, HttpStatus.OK);
    }

    @PostMapping("/person_project")
    public ResponseEntity<ProyectoPersona> guardarProyectoPersona(@RequestBody ProyectoPersona proyectoPersona) {
        ProyectoPersona pp = proyectoService.saveProjectPerson(proyectoPersona);
        return new ResponseEntity<ProyectoPersona>(pp, HttpStatus.OK);
    }

    @GetMapping("/by_subject_and_semester/{subject}/{semester}")
    public ResponseEntity<List<ProyectoDTO>> listarProyectosPorMateriaSemestre(@PathVariable UUID subject,
            @PathVariable Integer semester) {
        List<ProyectoDTO> proyectos = proyectoService.findProjectsBySubjectAndSemester(subject, semester);
        return new ResponseEntity<List<ProyectoDTO>>(proyectos, HttpStatus.OK);
    }

    @GetMapping("/projects_by_group_id/{grupoId}")
    public ResponseEntity<List<Proyecto>> listarProyectoPorGrupo(@PathVariable UUID grupoId) {
        List<Proyecto> proyectos = proyectoService.findProjectsByGroupId(grupoId);
        return new ResponseEntity<List<Proyecto>>(proyectos, HttpStatus.OK);
    }

    @GetMapping("/by_subject_code_and_semester/{subject}/{semester}")
    public ResponseEntity<List<ProyectoDTO>> listarProyectosPorCodigoMateriaSemestre(@PathVariable String subject,
            @PathVariable Integer semester) {
        List<ProyectoDTO> proyectos = proyectoService.findProjectsBySubjectCodeAndSemester(subject, semester);
        return new ResponseEntity<List<ProyectoDTO>>(proyectos, HttpStatus.OK);
    }

}
