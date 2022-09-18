package com.fdmgroup.olddao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.fdmgroup.model.Actor;
import com.fdmgroup.model.Movie;

public class MovieDao {

	@PersistenceContext
	private EntityManager em;
	private ActorDao aDao;

	public MovieDao() {

	}

	@Transactional
	public Movie create(Movie m) {
		System.out.println("Movie: " + m);
		em.persist(m);
		return m;
	}

	@Transactional
	public void update(Movie m) {
		em.merge(m);
	}

	@Transactional
	public void remove(int id) {
		Movie mov = em.find(Movie.class, id);
		for (Actor a : mov.getActors()) {
			a.removeMovie(mov);
		}
		mov.clearActors();
//		em.merge(mov);
		em.remove(mov);
	}

	@Transactional
	public Movie findById(int id) {
		Movie add = em.find(Movie.class, id);
		return add;
	}

	@Transactional
	public List<Movie> getMovies() {
		Query q = em.createQuery("SELECT m FROM Movie m");
		List<Movie> movies = q.getResultList();
		if (movies.size() > 0) {
			for (Actor a : movies.get(0).getActors()) {
				System.out.println(a);
			}
		}
		return movies;
	}

	@Transactional
	public List<Movie> search(String phrase) {
		Query q = em.createQuery("SELECT m FROM Movie m");
		List<Movie> all = q.getResultList();
		List<Movie> movies = new ArrayList<Movie>();

		for (Movie m : all) {
			if (m.getTitle().contains(phrase)) {
				movies.add(m);
			}
		}

		return movies;
	}

	@Transactional
	public List<Movie> searchByYear(int year) {
		List<Movie> movies = em.createNamedQuery("Movie.findByYear").setParameter("year", year).getResultList();
		return movies;
	}

	@Transactional
	public Movie findByTitle(Movie m) {
		Query q = em.createQuery("SELECT m FROM Movie m WHERE m.title = :title", Actor.class);
		Movie movie = (Movie) q.setParameter("title", m.getTitle()).getSingleResult();
		return movie;
	}

	/*
	 * For use in DMLRunner only The REST equivalent is in MovieService
	 */
	@Transactional
	public void link(Movie m1, Actor a1) {
		Movie m = findByTitle(m1);
		Actor a = aDao.findByName(a1);

		m.addActor(a);
		a.addMovie(m);

		update(m);
		aDao.update(a);
	}
}