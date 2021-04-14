package org;

public class Routes {
	int route_id;
	String[] destinations;
	int nbr_of_selections;
	
	public Routes(int route_id, String[] destinations, int nbr_of_selections) {
		super();
		this.route_id = route_id;
		this.destinations = destinations;
		this.nbr_of_selections = nbr_of_selections;
	}

}
