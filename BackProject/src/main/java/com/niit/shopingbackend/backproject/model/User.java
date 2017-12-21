package com.niit.shopingbackend.backproject.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component

@Entity

public class User

{

	@Id
	private String userid;

	@Column(unique = true)
	private String username;

	private String password;

	boolean active;

	public String getUserid() {

		return userid;

	}

	public void setUserid(String userid) {

		this.userid = userid;

	}

	public String getUsername() {

		return username;

	}

	public void setUsername(String username) {

		this.username = username;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	public boolean isActive() {

		return active;

	}

	public void setActive(boolean active) {

		this.active = active;

	}

}