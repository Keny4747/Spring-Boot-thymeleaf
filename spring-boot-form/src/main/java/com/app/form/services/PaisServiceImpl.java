package com.app.form.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.form.controller.models.domain.Pais;

@Service
public class PaisServiceImpl implements IPaisService{
	
	private List<Pais> lista;
	
	
	
	
	public PaisServiceImpl(List<Pais> lista) {
		super();
		this.lista = Arrays.asList(
				new Pais(1, "PE", "Perù"),
				new Pais(2, "CL", "Chile"),
				new Pais(3, "ES", "España"),
				new Pais(4, "Mx", "México"));
	}

	@Override
	public List<Pais> listar() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		Pais resultado = null;
		
		for(Pais p : this.lista) {
			if(p.getId()==id) {
			 resultado=p;break;
			}
		}
	return resultado;	
	}

}
