package org;

import java.util.Date;

public class Drivers {
	int driver_id;
	String driver_username;
	String driver_password;
	Date[] driver_calendar;
	Routes[] driver_routes;
	
	public Drivers(int driver_id, String driver_username, String driver_password, Date[] driver_calendar,
			Routes[] driver_routes) {
		super();
		this.driver_id = driver_id;
		this.driver_username = driver_username;
		this.driver_password = driver_password;
		this.driver_calendar = driver_calendar;
		this.driver_routes = driver_routes;
	}


}
