package com.example.microservicio_materias.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservicio_materias.models.Materia;

public interface IMateriaDao extends JpaRepository<Materia, String> {
    
}
