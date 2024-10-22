package com.t3damoscurso.models;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.t3damoscurso.interfaces.IUsuarioRepository;

public class UsuarioService {
	@Autowired
    private IUsuarioRepository usuarioRepository;

    // Método para encontrar un usuario por email
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    // Método para guardar un usuario (crear o actualizar)
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    // Método para obtener todos los usuarios
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // Método para encontrar un usuario por ID
    public Usuario findById(int id) {
        return usuarioRepository.findById(id);
    }

    // Método para eliminar un usuario por ID
    public void deleteById(int id) {
        usuarioRepository.deleteById(id);
    }
}
