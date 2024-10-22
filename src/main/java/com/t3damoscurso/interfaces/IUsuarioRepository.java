package com.t3damoscurso.interfaces;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.t3damoscurso.models.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	// Método para guardar un nuevo usuario o actualizar uno existente
    Usuario save(Usuario usuario);
    
    // Método para encontrar un usuario por su ID
    Usuario findById(int id);
    
    // Método para encontrar un usuario por su email
    Usuario findByEmail(String email);
    
    // Método para obtener todos los usuarios
    List<Usuario> findAll();
    
    // Método para eliminar un usuario por su ID
    void deleteById(int id);

	boolean tienePlanActivo(int id_usuario);
}
