package com.t3damoscurso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.t3damoscurso.models.Usuario;
import com.t3damoscurso.models.UsuarioService;

public class AuthController {
	@Autowired
	private UsuarioService usuarioService;

	// Tipo Get -> cargar la pagina de inicio de sesión
	@GetMapping("/auth/login")
	public String cargarLogin() {
		return "login"; // Retorna la vista de login
	}

	// Tipo Post -> Procesar el inicio de sesión
	@PostMapping("/auth/login")
	public String leerLogin(@RequestParam String email, @RequestParam String contraseña, Model model) {
		System.out.print(email + " " + contraseña);

		// Simulación de validación
		if (email.equals("adminUsua@gmail.com") && contraseña.equals("12345")) {
			// Mensaje de exito
			model.addAttribute("mensaje", "Bienvenido");
			model.addAttribute("cssmensaje", "alert alert-success");
		} else {
			// Mensaje de error
			model.addAttribute("mensaje", "Usuario o contraseña erróneos");
			model.addAttribute("cssmensaje", "alert alert-danger");
		}

		return "login";
	}

	// Tipo Get -> Cargar a la página de registro
	@GetMapping("/auth/registro")
	public String cargarRegistro() {
		return "registro"; // Retorna a la vista de registro
	}

	@PostMapping("/auth/register")
	public String registrarUsuario(@RequestParam String nombre, @RequestParam String email,
			@RequestParam String contraseña, Model model) {
		// Verifica si el usuario ya existe
		if (usuarioService.findByEmail(email) != null) {
			model.addAttribute("mensaje", "El correo ya está registrado.");
			model.addAttribute("cssmensaje", "alert alert-danger");
			return "register"; // Retorna a la vista de registro
		}

		// Crea un nuevo usuario
		Usuario nuevoUsuario = new Usuario(); // Aquí deberías ver el autocompletado
		nuevoUsuario.setNombre(nombre);
		nuevoUsuario.setEmail(email);
		nuevoUsuario.setContraseña(contraseña); // Se guarda la contraseña sin hash

		// Guarda el usuario en la base de datos
		usuarioService.save(nuevoUsuario);

		// Mensaje de éxito
		model.addAttribute("mensaje", "Registro exitoso");
		model.addAttribute("cssmensaje", "alert alert-success");
		return "redirect:/auth/login"; // Redirige a la página de login
	}

}
