package org;

import java.util.Date;

public class Reservations {
	String driver_name;
	String user_name;
	int route_id;
	Date date;
	
	public Reservations(int id, String driver, String user, int route, Date date) {
		super();
		this.route_id = id;
		this.driver_name = driver;
		this.user_name = user;
		this.route_id = route;
		this.date = date;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getRoute_id() {
		return route_id;
	}

	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
