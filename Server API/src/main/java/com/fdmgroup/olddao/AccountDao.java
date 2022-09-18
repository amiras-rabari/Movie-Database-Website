package com.fdmgroup.olddao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.fdmgroup.model.Account;

public class AccountDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Account create(Account a) {
		em.persist(a);
		return a;
	}

	@Transactional
	public void remove(int id) {
		Account u = em.find(Account.class, id);
		em.remove(u);
	}
	
	@Transactional
	public Account findById(int id) {
		Account u = em.find(Account.class, id);
		return u;
	}
	
	@Transactional
	public Account findByName(String accountname) {
		for(Account u : findAllAccounts()) {
			if(u.getAccountname().equals(accountname)) {
				return u;
			}
		}
		return null;
	}

	@Transactional
	public List<Account> findAllAccounts() {
		Query q = em.createQuery("SELECT u FROM Account u", Account.class);
		List<Account> accounts = q.getResultList();
		return accounts;
	}
	
	@Transactional
	public boolean exists(String accountname) {
		for(Account u : findAllAccounts()) {
			if(u.getAccountname() == accountname) {
				return true;
			}
		}
		return false;
	}
}