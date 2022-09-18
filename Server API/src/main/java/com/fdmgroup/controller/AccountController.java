package com.fdmgroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.model.Account;
import com.fdmgroup.model.Type;
import com.fdmgroup.service.AccountService;

@RestController
@CrossOrigin(origins = "*")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	
	@GetMapping("/accounts/{id}")
	public Account getAccount(@PathVariable int id) {
		return accountService.getAccount(id);
		
	}
	
	@PostMapping("accounts/login")
	public ResponseEntity<Object> login(@RequestParam String username, @RequestParam String password) {
		Account a = accountService.login(username, password);
//		System.out.println("Username: " + username + ", Password: " + password);
//		System.out.println(a);
		if(a.getAccountname().equals(username)) {
			if(a.getPassword().equals(password)) {
				return ResponseEntity.accepted().body(a);
			} else {
				//wrong password
				return ResponseEntity.badRequest().body("wrong password");
			}
		} else {
			//username not found
			return ResponseEntity.badRequest().body("user not found");
		}
	}
	
	@PostMapping("/accounts")
	public Account addAccount(@RequestBody Account incomingAccount) {
		return accountService.saveAccount(incomingAccount);
	}
	
	@DeleteMapping("/accounts/{id}")
	public void deleteAccount(@PathVariable int id) {
		accountService.deleteAccount(id);
	}
}