package com.app.jpa.dao;

import java.util.List;

import com.app.jpa.models.Pelicula;

public interface IPeliculaDao {
	
	void create(Pelicula pelicula);
	List<Pelicula> read();
	void update(Pelicula pelicula);
	void delete(Integer id);
	Pelicula findOne(Integer id);
}
