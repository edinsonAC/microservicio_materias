package com.example.microservicio_materias.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio_materias.dao.IPersonaProyecto;
import com.example.microservicio_materias.dao.IProyectoDao;
import com.example.microservicio_materias.models.Proyecto;
import com.example.microservicio_materias.models.ProyectoPersona;

@Service
public class ProyectoService {

    @Autowired
    private IProyectoDao proyectoDao;

    @Autowired
    private IPersonaProyecto personaProyecto;

    public List<Proyecto> findAll() {
        return proyectoDao.findAll();
    }

    public Proyecto findById(UUID id) {
        return proyectoDao.findById(id).orElse(null);
    }

    public Proyecto saveGroup(Proyecto proyecto) {
        return proyectoDao.save(proyecto);
    }

    public void deleteById(UUID id) {
        proyectoDao.deleteById(id);
    }

    public ProyectoPersona saveProjectPerson(ProyectoPersona proyectoPersona) {
        return personaProyecto.save(proyectoPersona);
    }

    public List<Proyecto> findProjectsBySubjectAndSemester(UUID subject, Integer semester) {
        return proyectoDao.findProjectsBySubjectAndSemester(subject, semester);
    }

    public List<Proyecto> findProjectsByGroupId(UUID grupId) {
        return proyectoDao.findProjectsByGroupId(grupId);
    }
}
