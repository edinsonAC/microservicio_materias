package com.example.microservicio_materias.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.microservicio_materias.models.Grupo;

public interface IGrupoDao extends JpaRepository<Grupo, UUID> {

    @Query(nativeQuery = true, value = "SELECT * FROM \"group\" g where g.subject_code = ?1")
    public List<Grupo> findGroupsBySubjectId(UUID id);
}
