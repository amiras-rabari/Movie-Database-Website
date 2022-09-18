package com.fdmgroup;

import java.sql.Date;

import com.fdmgroup.model.Actor;
import com.fdmgroup.model.Genre;
import com.fdmgroup.model.Movie;
import com.fdmgroup.olddao.ActorDao;
import com.fdmgroup.olddao.MovieDao;
import com.fdmgroup.service.ActorService;
import com.fdmgroup.service.MovieService;

/*
 * You may create tables in your SQL client, or have Spring create them automatically
 * You should probably run the DML in SQL Developer / H2
 * This method will not work in the spring project, but you can move it to a JPA project (with a lot of adjustment)
 */
public class DMLRunner {
	public static void main(String[] args) {
		MovieDao mDao = new MovieDao();
		ActorDao aDao = new ActorDao();
		
		Movie m1 = new Movie("Home Alone", 103, Genre.COMEDY, Date.valueOf("1990-01-01"));
		Movie m2 = new Movie("Terminator 2", 137, Genre.ACTION, Date.valueOf("1991-01-01"));
		Movie m3 = new Movie("Aladdin", 90, Genre.FAMILY, Date.valueOf("1992-01-01"));
		Movie m4 = new Movie("Jurassic Park", 128, Genre.ACTION, Date.valueOf("1993-01-01"));
		Movie m5 = new Movie("Forrest Gump", 142, Genre.DRAMA, Date.valueOf("1994-01-01"));
		Movie m6 = new Movie("Braveheart", 178, Genre.HISTORICAL, Date.valueOf("1995-01-01"));
		Movie m7 = new Movie("Mission Impossible", 110, Genre.ACTION, Date.valueOf("1996-01-01"));
		Movie m8 = new Movie("Titanic", 195, Genre.ROMANCE, Date.valueOf("1997-01-01"));
		Movie m9 = new Movie("Saving Private Ryan", 169, Genre.WAR, Date.valueOf("1998-01-01"));
		Movie m10 = new Movie("Star Wars: Episode I", 133, Genre.SCIFI, Date.valueOf("1999-01-01"));

		Actor a1 = new Actor("McCauly", "Caulkin", Date.valueOf("1990-01-01"));
		Actor a2 = new Actor("Arnold", "Schwarzenegger", Date.valueOf("1990-01-01"));
		Actor a3 = new Actor("Sam", "Neil", Date.valueOf("1990-01-01"));
		Actor a4 = new Actor("Jeff", "Goldblum", Date.valueOf("1990-01-01"));
		Actor a5 = new Actor("Tom", "Hanks", Date.valueOf("1990-01-01"));
		Actor a6 = new Actor("Mel", "Gibson", Date.valueOf("1990-01-01"));
		Actor a7 = new Actor("Leonardo", "DiCaprio", Date.valueOf("1990-01-01"));
		Actor a8 = new Actor("Kate", "Winslet", Date.valueOf("1990-01-01"));
		Actor a9 = new Actor("Ewan", "MacGreggor", Date.valueOf("1990-01-01"));
		Actor a10 = new Actor("Liam", "Neeson", Date.valueOf("1990-01-01"));

		mDao.create(m1);
		mDao.create(m2);
		mDao.create(m3);
		mDao.create(m4);
		mDao.create(m5);
		mDao.create(m6);
		mDao.create(m7);
		mDao.create(m8);
		mDao.create(m9);
		mDao.create(m10);
		
		aDao.create(a1);
		aDao.create(a2);
		aDao.create(a3);
		aDao.create(a4);
		aDao.create(a5);
		aDao.create(a6);
		aDao.create(a7);
		aDao.create(a8);
		aDao.create(a9);
		aDao.create(a10);
		
		mDao.link(m1,a1);
		mDao.link(m2,a2);
		mDao.link(m4,a3);
		mDao.link(m4,a4);
		mDao.link(m5,a5);
		mDao.link(m6,a6);
		mDao.link(m8,a7);
		mDao.link(m8,a8);
		mDao.link(m9,a5);
		mDao.link(m10,a9);
		mDao.link(m10,a10);
	}
}

