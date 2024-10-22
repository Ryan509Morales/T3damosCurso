package com.t3damoscurso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.t3damoscurso.models.Curso;
import com.t3damoscurso.models.CursoService;
import com.t3damoscurso.models.Usuario;
import com.t3damoscurso.models.UsuarioPlanService;
import com.t3damoscurso.models.UsuarioService;

import org.springframework.ui.Model;

public class PlanController {
	@Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private UsuarioPlanService usuarioPlanService; // Servicio para gestionar la relación usuario-plan
    
    @Autowired
    private CursoService cursoService; // Servicio para gestionar cursos

    // Método para mostrar los cursos disponibles para usuarios con plan
    @GetMapping("/cursos")
    public String listarCursos(Model model) {
        // Obtener el usuario actualmente autenticado
        // Aquí asumo que tienes un método para obtener el usuario autenticado
        Usuario usuarioActual = obtenerUsuarioAutenticado(); // Implementa este método según tu lógica

        // Verificar si el usuario tiene un plan activo
        if (usuarioPlanService.tienePlanActivo(usuarioActual)) {
            // Obtener todos los cursos
            List<Curso> cursos = cursoService.findAll(); // Método para obtener todos los cursos
            
            model.addAttribute("cursos", cursos);
            return "cursos"; // Retorna la vista de cursos
        } else {
            model.addAttribute("mensaje", "No tienes un plan activo para acceder a los cursos.");
            model.addAttribute("cssmensaje", "alert alert-danger");
            return "error"; // Retorna a la vista de error
        }
    }

    private Usuario obtenerUsuarioAutenticado() {
        // Implementa la lógica para obtener el usuario autenticado
        // Esto puede depender de tu implementación de seguridad (Spring Security, por ejemplo)
        return null; // Cambia esto por tu implementación
    }
}
