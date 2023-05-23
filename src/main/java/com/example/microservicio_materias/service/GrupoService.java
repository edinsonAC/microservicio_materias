package com.example.microservicio_materias.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservicio_materias.dao.IGrupoDao;
import com.example.microservicio_materias.dao.IGrupoPersonaDao;
import com.example.microservicio_materias.models.Grupo;
import com.example.microservicio_materias.models.GrupoPersona;
import com.example.microservicio_materias.models.Persona;

@Service
public class GrupoService {
    @Autowired
    private IGrupoDao grupoDao;

    @Autowired
    private IGrupoPersonaDao grupoPersonaDao;

    public List<Grupo> findAll() {
        return grupoDao.findAll();
    }

    public Grupo findById(@PathVariable UUID id) {
        return grupoDao.findById(id).orElse(null);
    }

    public Grupo saveGroup(Grupo grupo) {
        return grupoDao.save(grupo);
    }

    public void deleteById(@PathVariable UUID id) {
        grupoDao.deleteById(id);
    }

    public List<GrupoPersona> getAllGroupPersons() {
        return grupoPersonaDao.findAll();
    }

    public List<Persona> findPersonsByGroupId(UUID id) {
        return grupoPersonaDao.findPersonsByGroupId(id);
    }

}
