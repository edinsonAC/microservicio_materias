package com.example.microservicio_materias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio_materias.dao.ITareaDao;
import com.example.microservicio_materias.models.Tarea;

@Service
public class TareaService {

    @Autowired
    private ITareaDao tareaDao;

    public List<Tarea> findAll() {
        return tareaDao.findAll();
    }

    public Tarea findById(String id) {
        return tareaDao.findById(id).orElse(null);
    }

    public Tarea saveSubject(Tarea materia) {
        return tareaDao.save(materia);
    }

    public void deleteSubject(String id) {
        tareaDao.deleteById(id);
    }
}
