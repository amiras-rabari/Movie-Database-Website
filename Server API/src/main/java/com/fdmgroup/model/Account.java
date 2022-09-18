package com.fdmgroup.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue//(generator = "AccountGenerator", strategy = GenerationType.AUTO)
//	@SequenceGenerator(name = "AccountGenerator", sequenceName = "account_seq", allocationSize = 1)
	private int id;

	@Column(name = "account_name")
	private String accountName;

	private String password;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	public Account() {
		
	}
	
	public Account(String a, String p, Type t) {
		accountName = a;
		password = p;
		type = t;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountname() {
		return accountName;
	}

	public void setAccountname(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountName=" + accountName + ", password=" + password + ", type=" + type + "]";
	}
}