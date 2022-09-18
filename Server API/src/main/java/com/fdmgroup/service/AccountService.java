package com.fdmgroup.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.olddao.AccountDao;
import com.fdmgroup.model.Account;

@Service
public class AccountService {
	
	@Autowired
	AccountDao acDao;

	public List<Account> getAllAccounts(){
		return acDao.findAllAccounts();
	}

	public Account getAccount(int id) {
		return acDao.findById(id);
	}

	public Account saveAccount(Account incomingAccount) {
		return acDao.create(incomingAccount);
	}

	public void deleteAccount(int id) {
		acDao.remove(id);
	}

	public Account login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}