package com.app.jpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.jpa.dao.IPeliculaDao;
import com.app.jpa.models.Pelicula;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

	@Autowired
	IPeliculaDao pelicualDao;
	
	@Override
	@Transactional
	public void create(Pelicula pelicula) {
		pelicualDao.create(pelicula);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pelicula> read() {
		return pelicualDao.read();
	}

	@Override
	public void update(Pelicula pelicula) {
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		pelicualDao.delete(id);
	}

	@Override
	public Pelicula findOne(Integer id) {	
		return pelicualDao.findOne(id);
	}
	
}
