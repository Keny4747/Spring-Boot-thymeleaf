package com.app.form.services;

import java.util.List;

import com.app.form.controller.models.domain.Pais;

public interface IPaisService {
	
	public List<Pais> listar();
	public Pais obtenerPorId(Integer id);
		
	
}
