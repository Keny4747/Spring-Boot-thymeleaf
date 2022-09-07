package com.app.form.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.form.controller.models.domain.Pais;
import com.app.form.controller.models.domain.Usuario;
import com.app.form.services.IPaisService;


@Controller
public class FormController {

	@Autowired
	IPaisService paisService;
		
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Jhon");
		usuario.setApellido("Doe");
		usuario.setIdentificador("1234.2342.23.k");

		model.addAttribute("titulo", "Formulario usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises() {
		return Arrays.asList(
				new Pais(1, "PE", "Perù"),
				new Pais(2, "CL", "Chile"),
				new Pais(3, "ES", "España"),
				new Pais(4, "Mx", "México"));
	}

	@ModelAttribute("paises")
	public List<String> paises() {
		return Arrays.asList("Perù", "Chile", "España", "México");
	}

	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap() {
		Map<String, String> paises = new HashMap<>();
		paises.put("ES", "España");
		paises.put("MX", "México");
		paises.put("CL", "Chile");
		paises.put("AR", "Argentina");

		return paises;
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
		/*
		 * cuando coincidan los atributos vista y modelo se asignan de manera automatica
		 * sin necesidad de hacer esto: Usuario usuario = new Usuario();
		 * usuario.setUsername(username); usuario.setEmail(email);
		 * usuario.setPassword(password);
		 */
		model.addAttribute("titulo", "Resultado form");
		if (result.hasErrors()) {

			return "form";
		}

		model.addAttribute("usuario", usuario);
		return "resultado";
	}

}
