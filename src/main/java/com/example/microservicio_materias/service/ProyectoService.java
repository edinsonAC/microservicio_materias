package com.example.microservicio_materias.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio_materias.dao.IGrupoPersonaDao;
import com.example.microservicio_materias.dao.IPersonaProyecto;
import com.example.microservicio_materias.dao.IProyectoDao;
import com.example.microservicio_materias.dto.ProyectoDTO;
import com.example.microservicio_materias.models.Persona;
import com.example.microservicio_materias.models.Proyecto;
import com.example.microservicio_materias.models.ProyectoPersona;

@Service
public class ProyectoService {

    @Autowired
    private IProyectoDao proyectoDao;

    @Autowired
    private IGrupoPersonaDao grupoPersonaDao;

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

    public List<ProyectoDTO> findProjectsBySubjectAndSemester(UUID subject, Integer semester) {
        HashMap<UUID, List<Persona>> mapaGrupos = new HashMap<>();// mapa
        List<ProyectoDTO> respuesta = new ArrayList<>();// Listado de personasDto
        List<Proyecto> pros = proyectoDao.findProjectsBySubjectAndSemester(subject, semester);// listado de proyectos
        for (int i = 0; i < pros.size(); i++) {
            ProyectoDTO proyecto = new ProyectoDTO(pros.get(i));

            if (proyecto.getGrupo() != null) {
                if (!mapaGrupos.containsKey(proyecto.getGrupo().getId())) {
                    ArrayList<Object[]> objetos = new ArrayList<Object[]>();
                    objetos = grupoPersonaDao.findPersonsByGroupId(proyecto.getGrupo().getId());

                    List<Persona> pers = new ArrayList<>();

                    for (Object[] objArray : objetos) {
                        UUID personaId = (UUID) objArray[0];
                        String institutionalMail = (String) objArray[1];
                        String names = (String) objArray[3];
                        String lastnames = (String) objArray[4];
                        String code = (String) objArray[5];
                        String numDocument = (String) objArray[6];

                        Persona persona = new Persona(personaId, names, lastnames, institutionalMail, code,
                                numDocument);
                        pers.add(persona);
                    }

                    proyecto.setPersonas(pers);
                    mapaGrupos.put(proyecto.getGrupo().getId(), pers);
                } else {
                    List<Persona> pers = mapaGrupos.get(proyecto.getGrupo().getId());
                    proyecto.setPersonas(pers);
                }

            }
            respuesta.add(proyecto);
        }

        return respuesta;
    }

    public List<Proyecto> findProjectsByGroupId(UUID grupId) {
        return proyectoDao.findProjectsByGroupId(grupId);
    }
}
