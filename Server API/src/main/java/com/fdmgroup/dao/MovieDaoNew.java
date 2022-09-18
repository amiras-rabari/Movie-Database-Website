package com.fdmgroup.dao;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fdmgroup.model.Movie;


public interface MovieDaoNew extends CrudRepository<Movie, Integer>{
	public Movie findBytitle(String title);
}
