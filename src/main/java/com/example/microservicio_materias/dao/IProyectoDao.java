package com.example.microservicio_materias.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.microservicio_materias.models.Proyecto;

public interface IProyectoDao extends JpaRepository<Proyecto, UUID> {

    @Query(nativeQuery = true, value = "SELECT * FROM projects p INNER JOIN \"group\" g ON g.id = p.group_id WHERE g.subject_code = ?1 AND p.semestre = ?2 ")
    public List<Proyecto> findProjectsBySubjectAndSemester(UUID id, Integer semestre);

    @Query(nativeQuery = true, value = "SELECT * FROM projects p WHERE p.group_id = ?1 ")
    public List<Proyecto> findProjectsByGroupId(UUID id);
}
