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

import com.example.microservicio_materias.models.Materia;
import com.example.microservicio_materias.service.MateriaService;

import io.micrometer.common.lang.NonNull;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/subject")
public class MateriaController {

    private final Logger log = LoggerFactory.getLogger(MateriaController.class);

    @Autowired
    private MateriaService materiaService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Materia>> listarMaterias() {
        List<Materia> us = materiaService.findAll();
        return new ResponseEntity<List<Materia>>(us, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Materia> buscarMateria(@PathVariable String id) {
        Materia ma = materiaService.findById(id);
        return new ResponseEntity<Materia>(ma, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Materia> guardarMateria(@NonNull @RequestBody Materia subject) {
        Materia ma = materiaService.saveSubject(subject);
        return new ResponseEntity<Materia>(ma, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> editarMateria(@RequestBody Materia subject, @PathVariable UUID id) {
        subject.setId(id);
        Materia ma = materiaService.saveSubject(subject);
        return new ResponseEntity<Materia>(ma, HttpStatus.CREATED);
    }
}
