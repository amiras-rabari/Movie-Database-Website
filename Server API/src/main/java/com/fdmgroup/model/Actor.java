package com.fdmgroup.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "actor")
@NamedQueries({
	@NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a"),
	@NamedQuery(name = "Actor.findByFirstName", query = "SELECT a FROM Actor a WHERE a.firstName = :firstName"),
	@NamedQuery(name = "Actor.findByLastName", query = "SELECT a FROM Actor a WHERE a.lastName = :lastName")
})
public class Actor {

	@Id
	@GeneratedValue//(generator = "ActorGenerator", strategy = GenerationType.AUTO)
//	@SequenceGenerator(name = "ActorGenerator", sequenceName = "actor_seq", allocationSize = 1)
	private int id;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birth_date")
	private Date birthDate;

	@ManyToMany(cascade = { CascadeType.DETACH })
    @JoinTable(
        name = "actor_movie",
        joinColumns = { @JoinColumn(name = "actor_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "movie_id") }
    )
	@JsonIgnore
	private Set<Movie> movies;
	
	public Actor() {
		movies = new HashSet<Movie>();
	}
	
	public Actor(String fn, String ln, Date bd) {
		firstName = fn;
		lastName = ln;
		birthDate = bd;
		movies = new HashSet<Movie>();
	}
	
	public void addMovie(Movie m) {
		movies.add(m);
	}
	
	public void removeMovie(Movie m) {
		movies.remove(m);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", movies=" + movies.size() + "]";
	}

	public void clearMovies() {
		movies.clear();
	}
	
	
}