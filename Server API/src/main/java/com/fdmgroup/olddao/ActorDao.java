package com.fdmgroup.olddao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.fdmgroup.model.Actor;

public class ActorDao {

	@PersistenceContext
	private EntityManager em;
	
	public ActorDao() {
		
	}
	
	@Transactional
	public Actor create(Actor a) {
		em.persist(a);
		return a;
	}

	@Transactional
	public void remove(int id) {
		Actor a = em.find(Actor.class, id);
		a.clearMovies();
		em.merge(a);
		em.remove(a);
	}

	@Transactional
	public void update(Actor a) {
		em.merge(a);
	}
	
//	@Transactional
	public Actor findById(int id) {
		Actor a = em.find(Actor.class, id);
		return a;
	}

	@Transactional
	public List<Actor> getActors() {
		Query q = em.createQuery("SELECT a FROM Actor a", Actor.class);
		List<Actor> actors = q.getResultList();
		return actors;
	}

	@Transactional
	public Actor findByName(Actor a) {
		Query q = em.createQuery("SELECT a FROM Actor a WHERE a.firstName = :first AND a.lastName = :last", Actor.class);
		Actor actor = (Actor) q.setParameter("first", a.getFirstName()).setParameter("last", a.getLastName()).getSingleResult();
		return actor;
	}
}