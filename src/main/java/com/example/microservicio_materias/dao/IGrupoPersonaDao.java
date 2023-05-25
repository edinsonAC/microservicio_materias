package com.example.microservicio_materias.dao;

import com.example.microservicio_materias.models.GrupoPersona;
import com.example.microservicio_materias.models.Materia;
import com.example.microservicio_materias.models.Persona;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IGrupoPersonaDao extends JpaRepository<GrupoPersona, UUID> {

    @Query(nativeQuery = true, value = "SELECT * FROM person p INNER JOIN group_person gp on gp.person_id = p.id where gp.group_id = ?1")
    public List<Persona> findPersonsByGroupId(UUID id);

    @Query(nativeQuery = true, value = "SELECT * FROM subject s INNER JOIN \"group\" g ON g.subject_code = s.id "
            + " INNER JOIN group_person gp ON gp.group_id = g.id"
            + " WHERE gp.person_id = ?1")
    public List<Materia> findSubjectsByPersonId(UUID id);

}
