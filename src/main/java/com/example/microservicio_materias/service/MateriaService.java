package com.example.microservicio_materias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio_materias.dao.IMateriaDao;
import com.example.microservicio_materias.models.Materia;
import java.util.List;
import java.util.UUID;

@Service
public class MateriaService {

	@Autowired
	private IMateriaDao materiaDao;

	public List<Materia> findAll() {
		return materiaDao.findAll();
	}

	public Materia findById(UUID id) {
		return materiaDao.findById(id).orElse(null);
	}

	public Materia saveSubject(Materia materia) {
		return materiaDao.save(materia);
	}

	public void deleteSubject(String id) {
		materiaDao.deleteById(id);
	}
}
