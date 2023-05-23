package com.example.microservicio_materias.dao;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.microservicio_materias.models.Grupo;

public interface IGrupoDao extends JpaRepository<Grupo, UUID> {

}
