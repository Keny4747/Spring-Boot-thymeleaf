package com.app.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.app.jpa.models.Pelicula;
import com.app.jpa.service.IPeliculaService;

@Controller
public class PeliculaController {

	@Autowired
	IPeliculaService peliculaService;

	@GetMapping("/form")
	public String crear(Model model) {
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("titulo", "Registro de peliculas");
		return "form";
	}

	@PostMapping("/form")
	public String creado(Pelicula pelicula, Model model) {

		peliculaService.create(pelicula);
		return "redirect:/listar";
	}

	@GetMapping("/listar")
	public String lista(Model model) {
		model.addAttribute("titulo", "Lista de Peliculas");
		model.addAttribute("lista", peliculaService.read());
		return "listar";
	}

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("titulo", "BIENVENIDO");
		return "index";
	}

	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value = "id") Integer codigo, Model model) {
		Pelicula pelicula = null;
		if (codigo > 0) {
			pelicula = peliculaService.findOne(codigo);
		} else {
			return "redirect:/listar";
		}
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("titulo", "Editar");
		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer codigo) {
		if (codigo > 0) {
			peliculaService.delete(codigo);
		}
		return "redirect:/listar";
	}
}
