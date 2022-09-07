package com.app.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.web.models.Usuario;

@Controller
@RequestMapping("/app")
public class indexController {
		
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	
	@GetMapping({ "/index", "/" })
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {

		Usuario usuario = new Usuario();

		usuario.setNombre("Keny");
		usuario.setApellido("Pau Vásquez");
		usuario.setEmail("example@email.com");
		model.addAttribute("usuario", usuario);

		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}

	@GetMapping("/listar")
	public String listar(Model model) {

		model.addAttribute("titulo", textoListar);
		return "listar";

	}

	//@ModelAttribute permite globalizar y hacer en común a todos los métodos el contenido
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuario() {
		List<Usuario> usuarios = new ArrayList<>();

		usuarios.add(new Usuario("Carlos", "Mendez", "example@email.com"));
		usuarios.add(new Usuario("Jaime", "Perez", "example@email.com"));
		usuarios.add(new Usuario("Maria", "Gomez", "example@email.com"));
		return usuarios;
	}
}
