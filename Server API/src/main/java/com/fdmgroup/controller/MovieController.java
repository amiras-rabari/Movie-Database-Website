package com.fdmgroup.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.model.Actor;
import com.fdmgroup.model.Movie;
import com.fdmgroup.service.MovieService;

@RestController
@CrossOrigin(origins = "*")
public class MovieController {
	
	@Autowired
	MovieService movieService;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/movies")
	public List<Movie> getAllMovies(){
		System.out.println("GET movies");
		/*
		 * Test to prove that Java can still use getter methods despite @JsonIgnore
		 */
		List<Movie> movies = movieService.getMovies();
		for(Movie m : movies) {
			System.out.println("Movie " + m.getTitle() + ", starring: ");
			for(Actor a : m.getActors()) {
				System.out.println(a.getFirstName() + " " + a.getLastName());
			}
		}
		
		return movies;
	}
	
	@GetMapping("/movies/{id}")
	public Movie getMovie(@PathVariable int id) {
		System.out.println("GET movie " + id);
		return movieService.getMovie(id);
	}
	@GetMapping("/movies/title/{title}")
	public Movie getMovieByTitle(@PathVariable String title) {
		System.out.println("GET movie " + title);
		return movieService.getMovieByTitle(title);
	}
	@PostMapping("/movies")
	public Movie addMovie(@RequestBody Movie incomingMovie) {
		System.out.println("POST movie");
		System.out.println("Inserting Movie:");
		System.out.println(incomingMovie);
		return movieService.saveMovie(incomingMovie);
	}
	
	@DeleteMapping("/movies/{id}")
	public void deleteMovie(@PathVariable int id) {
		System.out.println("DELETE movie");
		movieService.deleteMovie(id);
	}
	
	@GetMapping("/movies/actor/{id}")
	public Set<Actor> getActorsByMovie(@PathVariable int id){
		System.out.println("GET actors for movie " + id);
		Set<Actor> actors = movieService.getActorsByMovie(id);
		
		for(Actor a : actors) {
			System.out.println(a.getFirstName() + " " + a.getLastName());
		}
		
		return actors;
	}
	
	@GetMapping("/link/{actor}/{movie}")
	public void link(@PathVariable int actor, @PathVariable int movie) {
		System.out.println("Linking: " + actor + " + " + movie);
		movieService.link(actor, movie);
	}
}