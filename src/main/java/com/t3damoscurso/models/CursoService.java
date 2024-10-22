package com.t3damoscurso.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.t3damoscurso.interfaces.ICursoRepository;

public class CursoService {
	 @Autowired
	    private ICursoRepository cursoRepository;

	    public List<Curso> findAll() {
	        return cursoRepository.findAll();
	    }

	    // Otros métodos relacionados con cursos
}
