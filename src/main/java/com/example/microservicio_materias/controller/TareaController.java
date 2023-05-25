package com.example.microservicio_materias.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.microservicio_materias.service.TareaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.microservicio_materias.models.Tarea;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api-subject/tasks")
public class TareaController {
    private final Logger log = LoggerFactory.getLogger(MateriaController.class);

    @Autowired
    private TareaService tareaService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Tarea>> listarTareas() {
        List<Tarea> us = tareaService.findAll();
        return new ResponseEntity<List<Tarea>>(us, HttpStatus.OK);
    }

    @GetMapping(value = "/:id")
    public ResponseEntity<Tarea> buscarTarea(@PathVariable UUID id) {
        Tarea tarea = tareaService.findById(id);
        return new ResponseEntity<Tarea>(tarea, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Tarea> guardarMateria(Tarea tarea) {
        Tarea ta = tareaService.saveSubject(tarea);
        return new ResponseEntity<Tarea>(ta, HttpStatus.OK);
    }
}
