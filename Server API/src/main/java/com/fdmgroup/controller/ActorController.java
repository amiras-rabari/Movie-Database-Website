package com.fdmgroup.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.model.Actor;
import com.fdmgroup.model.Movie;
import com.fdmgroup.service.ActorService;

@RestController
@CrossOrigin(origins = "*")
public class ActorController {

	@Autowired
	ActorService actorService;
	
	@GetMapping("/actors")
	public List<Actor> getAllActors(){
		return actorService.getActors();
	}
	
	@GetMapping("/actors/{id}")
	public Actor getActor(@PathVariable int id) {
		return actorService.getActor(id);
	}
	
	@PostMapping("/actors")
	public Actor addActor(@RequestBody Actor incomingActor) {
		return actorService.saveActor(incomingActor);
	}
	
	@DeleteMapping("/actors/{id}")
	public void deleteMovie(@PathVariable int id) {
		actorService.deleteActor(id);
	}
	
	@GetMapping("/actors/movie/{id}")
	public Set<Movie> getMoviesByActor(@PathVariable int id){
		return actorService.getMoviesByActor(id);
	}
}
