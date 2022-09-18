package com.fdmgroup.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.model.Actor;
import com.fdmgroup.model.Movie;
import com.fdmgroup.olddao.ActorDao;

@Service
public class ActorService {

	@Autowired
	ActorDao aDao;
	
	public List<Actor> getActors(){
		return aDao.getActors();
	}

	public Actor getActor(int id) {
		return aDao.findById(id);
	}

	public Actor saveActor(Actor incomingActor) {
		return aDao.create(incomingActor);
	}

	public void deleteActor(int id) {
		aDao.remove(id);
	}

	public Set<Movie> getMoviesByActor(int id) {
		return aDao.findById(id).getMovies();
	}
}
