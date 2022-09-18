package com.fdmgroup.model;

import java.util.Date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "movie")
@NamedQueries({
	@NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE YEAR( m.releaseDate ) = :year")
})
public class Movie {

	@Id
	@GeneratedValue//(generator = "MovieGenerator", strategy = GenerationType.AUTO)
//	@SequenceGenerator(name = "MovieGenerator", sequenceName = "movie_seq", allocationSize = 1)
	private int id;

	private String title;
	private int runtime;
	
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	@Column(name = "release_date")
	private Date releaseDate;
	
	@JsonIgnore
    @ManyToMany(mappedBy = "movies")
	private Set<Actor> actors;

    public Movie() {
    	actors = new HashSet<Actor>();
    }
    
    public Movie(String title, int runtime, Genre genre, Date releaseDate) {
		super();
		this.title = title;
		this.runtime = runtime;
		this.genre = genre;
		this.releaseDate = releaseDate;
		actors = new HashSet<Actor>();
	}

	public void addActor(Actor a) {
    	actors.add(a);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String printReleaseDate() {
		DateFormat df = new SimpleDateFormat("MMMMMMMMMM dd, yyyy");
		return df.format(releaseDate);
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		String s = "Movie [id=" + id + ", title=" + title + ", runtime=" + runtime + ", releaseDate=" + releaseDate + ", actors=" + actors.size() + "]";
		return s;
	}

	public void clearActors() {
		actors.clear();
	}
	
}