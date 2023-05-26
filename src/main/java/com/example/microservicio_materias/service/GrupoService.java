package com.example.microservicio_materias.service;

import java.util.ArrayList;
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
        //por conflictos con el mapeo, surgio esta solucion
        ArrayList<Object[]> objetos = new ArrayList<Object[]>();
        List<Persona> personas = new ArrayList<>();

        objetos = grupoPersonaDao.findPersonsByGroupId(id);
        for (Object[] objArray : objetos) {
            UUID personaId = (UUID) objArray[0];
            String institutionalMail = (String) objArray[1];
            String names = (String) objArray[3];
            String lastnames = (String) objArray[4];
            String code = (String) objArray[5];
            String numDocument = (String) objArray[6];

            Persona persona = new Persona(personaId, names, lastnames, institutionalMail, code, numDocument);
            personas.add(persona);
        }

        return personas;
    }

    public List<Grupo> findGroupsBySubjectId(UUID id) {
        return grupoDao.findGroupsBySubjectId(id);
    }

}
