package com.example.microservicio_materias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio_materias.dao.IGrupoDao;
import com.example.microservicio_materias.models.Grupo;

@Service
public class GrupoService {
    @Autowired
    private IGrupoDao grupoDao;

    public List<Grupo> findAll() {
        return grupoDao.findAll();
    }

}
