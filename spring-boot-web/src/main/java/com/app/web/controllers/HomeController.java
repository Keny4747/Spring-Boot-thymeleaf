package com.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
	//hay varias formas para redirigir 
		//return "forward:/app/index";
		//return "redirect:/app/index";
		return "redirect:https://www.google.com";
	}
}
