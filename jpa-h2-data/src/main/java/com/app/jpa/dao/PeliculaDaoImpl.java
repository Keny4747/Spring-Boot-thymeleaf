package com.app.jpa.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.app.jpa.models.Pelicula;

@Repository
public class PeliculaDaoImpl implements IPeliculaDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Pelicula pelicula) {

		if (pelicula.getCodigo() != null && pelicula.getCodigo() > 0) {
			em.merge(pelicula);
		} else {
			em.persist(pelicula);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pelicula> read() {
		return em.createQuery("from Pelicula").getResultList();
	}

	@Override
	public void update(Pelicula pelicula) {

	}

	@Override
	public void delete(Integer id) {
		Pelicula pelicula = findOne(id);
		em.remove(pelicula);
	}

	@Override
	public Pelicula findOne(Integer id) {

		return em.find(Pelicula.class, id);
	}

}
