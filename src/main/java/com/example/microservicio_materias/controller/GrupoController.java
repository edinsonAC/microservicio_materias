package com.example.microservicio_materias.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicio_materias.models.Grupo;
import com.example.microservicio_materias.models.GrupoPersona;
import com.example.microservicio_materias.models.Persona;
import com.example.microservicio_materias.service.GrupoService;
import com.example.microservicio_materias.service.MateriaService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api-subject/group")
public class GrupoController {

    private final Logger log = LoggerFactory.getLogger(MateriaController.class);

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private MateriaService subjectService;

    @GetMapping("/all")
    public ResponseEntity<List<Grupo>> listarGrupos() {
        List<Grupo> grupos = grupoService.findAll();
        return new ResponseEntity<List<Grupo>>(grupos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> buscarGrupo(@PathVariable UUID id) {
        Grupo grupo = grupoService.findById(id);
        return new ResponseEntity<Grupo>(grupo, HttpStatus.OK);
    }

    @GetMapping("/groups_persons")
    public ResponseEntity<List<GrupoPersona>> listarGruposPersonas() {
        List<GrupoPersona> grupos = grupoService.getAllGroupPersons();
        return new ResponseEntity<List<GrupoPersona>>(grupos, HttpStatus.OK);
    }

    @GetMapping("/persons_by_group_id/{id}")
    public ResponseEntity<List<Persona>> findPersonsByGroupId(@PathVariable UUID id) {
        List<Persona> grupos = grupoService.findPersonsByGroupId(id);

        return new ResponseEntity<List<Persona>>(grupos, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Grupo> guardarGrupo(@RequestBody Grupo grupo) {
        Grupo gru = grupoService.saveGroup(grupo);
        return new ResponseEntity<Grupo>(gru, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grupo> editarMateria(@RequestBody Grupo grupo, @PathVariable UUID id) {
        grupo.setId(id);
        if (grupo.getSubject() == null) {
            Grupo gr1 = grupoService.findById(id);
            grupo.setSubject(gr1.getSubject());
        }
        Grupo gr = grupoService.saveGroup(grupo);
        return new ResponseEntity<Grupo>(gr, HttpStatus.CREATED);
    }

    @GetMapping("/by_subject_id/{id}")
    public ResponseEntity<List<Grupo>> listarGruposPorMateria(@PathVariable UUID id) {
        List<Grupo> grupos = grupoService.findGroupsBySubjectId(id);
        return new ResponseEntity<List<Grupo>>(grupos, HttpStatus.OK);
    }

}
