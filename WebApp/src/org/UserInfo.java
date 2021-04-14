package org;

import java.util.ArrayList;

public class UserInfo {

	String user_name;
	String profile_img;
	String email;
	ArrayList<Reservations> reservations = new ArrayList<>();
	
	public UserInfo(String user_name, String profile_img, String email, ArrayList<Reservations> reservations) {
		this.user_name = user_name;
		this.profile_img = profile_img;
		this.email = email;
		this.reservations = reservations;
	}
}
