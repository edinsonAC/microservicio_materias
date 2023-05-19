package com.example.microservicio_materias.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicio_materias.models.Materia;
import com.example.microservicio_materias.service.MateriaService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/subject")
public class MateriaController {

    private final Logger log = LoggerFactory.getLogger(MateriaController.class);

    @Autowired
    private MateriaService materiaService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Materia>> listarUsuarios() {
        List<Materia> us = materiaService.findAll();
        System.out.println("=======>>>> " + us.get(0).getName());
        if (!us.isEmpty()) {
            System.out.println("impresion --- " + us.get(0).toString());
        }
        return new ResponseEntity<List<Materia>>(us, HttpStatus.OK);
    }

}
