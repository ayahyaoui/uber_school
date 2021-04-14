package org;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Id;

public class Users {
	
	@Id
	@Column(name="user_id")
	int user_id;
	
	@Column(name="user_name")
	String user_name;
	
	@Column(name="password")
	String password;
	
	@Column(name="address")
	String address;
	
	@Column(name="email")
	String email;
	
	@Column(name="profile_img")
	String profile_img;

	
	
	public Users(int id, String user_name, String password, String address, String email, String profile_img) {
		super();
		this.user_id = id;
		this.user_name = user_name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.profile_img = profile_img;
	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	
	
}

