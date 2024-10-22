package com.t3damoscurso.models;

import org.springframework.beans.factory.annotation.Autowired;

import com.t3damoscurso.interfaces.IUsuarioRepository;

public class UsuarioPlanService {
	 @Autowired
	    private IUsuarioRepository usuarioPlanRepository;

	    public boolean tienePlanActivo(Usuario usuario) {
	        // Implementa la lógica para verificar si el usuario tiene un plan activo
	        return usuarioPlanRepository.tienePlanActivo(usuario.getId_usuario());
	    }

	    // Otros métodos relacionados con usuario-plan
}
