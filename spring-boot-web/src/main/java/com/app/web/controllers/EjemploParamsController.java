package com.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	//Capturar valores desde la url
	@GetMapping("/string")
	public String param(@RequestParam(name = "texto", defaultValue = "Algùn valor no recibido por el momento") String texto, Model model) {
		model.addAttribute("titulo","Recibir parámetros del request HTTP GET - URL");
		model.addAttribute("resultado", "El texto enviado es: "+texto);
		return "params/ver";
	}
	
	//enivar parametros 
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo","Enviar parámetros del request HTTP GET - URL");
		return "params/index";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo,@RequestParam Integer numero, Model model) {
		model.addAttribute("titulo","Enviar múltiples parámetros");
		model.addAttribute("resultado", "El texto enviado es: "+saludo + " y el número es: "+numero);
		return "params/ver";
	}
	
}
