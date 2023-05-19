package com.example.microservicio_materias.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio_materias.dao.IMateriaDao;
import com.example.microservicio_materias.models.Materia;
import java.util.List;

@Service
public class MateriaService {
    
	@Autowired
	private IMateriaDao materiaDao;


    public List<Materia> findAll() {
		return materiaDao.findAll();
	}

}
