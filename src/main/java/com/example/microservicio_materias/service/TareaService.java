package com.example.microservicio_materias.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservicio_materias.dao.ITareaDao;
import com.example.microservicio_materias.models.Tarea;

@Service
public class TareaService {

    @Autowired
    private ITareaDao tareaDao;

    public List<Tarea> findAll() {
        return tareaDao.findAll();
    }

    public Tarea findById(@PathVariable UUID id) {
        return tareaDao.findById(id).orElse(null);
    }

    public Tarea saveSubject(Tarea materia) {
        return tareaDao.save(materia);
    }

    public void deleteSubject(@PathVariable UUID id) {
        tareaDao.deleteById(id);
    }
}
