package com.fdmgroup.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.dao.MovieDaoNew;
import com.fdmgroup.model.Actor;
import com.fdmgroup.model.Movie;
import com.fdmgroup.olddao.ActorDao;
import com.fdmgroup.olddao.MovieDao;

@Service
public class MovieService {

	@Autowired
	MovieDao mDao;
	
	@Autowired
	MovieDaoNew newDao;
	
	@Autowired
	ActorDao aDao;

	public List<Movie> getMovies(){
		return mDao.getMovies();
	}

	public Movie getMovie(int id) {
		return mDao.findById(id);
	}
	
	public Movie getMovieByTitle(String title) {
		return newDao.findBytitle(title);
	}

	public Movie saveMovie(Movie incomingMovie) {
		return mDao.create(incomingMovie);
	}

	public void deleteMovie(int id) {
		mDao.remove(id);
	}

	public Set<Actor> getActorsByMovie(int id) {
		return mDao.findById(id).getActors();
	}
	
	public void link(int actorId, int movieId) {
		Actor a = aDao.findById(actorId);
		Movie m = mDao.findById(movieId);

		m.addActor(a);
		a.addMovie(m);
		
		aDao.update(a);
		mDao.update(m);
	}
	
	public void link(Movie m, Actor a) {
		Actor actor = aDao.findByName(a);
		Movie movie = mDao.findByTitle(m);

		movie.addActor(actor);
		actor.addMovie(movie);
		
		aDao.update(actor);
		mDao.update(movie);
	}
}
