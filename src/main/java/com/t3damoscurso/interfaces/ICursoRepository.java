package com.t3damoscurso.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t3damoscurso.models.Curso;
import com.t3damoscurso.models.Plan;

public interface ICursoRepository extends JpaRepository <Curso, Integer>{
	// Método para encontrar cursos por plan
    List<Curso> findByPlan(Plan plan);
}
