package com.app.di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.app.di.service.IServicio;

@Controller
public class IndexController {

	@Autowired
	@Qualifier("miServicioSimple")
	private IServicio servicio;
	
	
	@GetMapping({"/index","/"})
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		model.addAttribute("titulo", "Ejemplo de ID con una clase de servicios");
		return "index";
	}
}
