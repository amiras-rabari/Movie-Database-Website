package com.fdmgroup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fdmgroup.dao.ActorDaoNew;
import com.fdmgroup.dao.MovieDaoNew;
import com.fdmgroup.olddao.AccountDao;
import com.fdmgroup.olddao.ActorDao;
import com.fdmgroup.olddao.MovieDao;

@Configuration
public class AppConfig {
	
	@Bean
	public ActorDao actorDao() {
		return new ActorDao();
	}
	
	@Bean
	public MovieDao movieDao() {
		return new MovieDao();
	}
	
	@Bean
	public AccountDao accountDao() {
		return new AccountDao();
	}
}