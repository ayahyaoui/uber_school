import java.util.ArrayList;
import java.util.Date;

import org.Reservations;
import org.UserInfo;
import org.Users;


/*
 * class imitating a Database for testing
 */
public class Examples {
	
	private Users[] users = new Users[] {
			new Users(1, "username1", "password1", "address1", "email1", "img1"),
			new Users(2, "username2", "password2", "address2", "email2", "img2"),
			new Users(3, "username3", "password3", "address3", "email3", "img3"),
			new Users(4, "username4", "password4", "address4", "email4", "img4"),
			new Users(5, "username5", "password5", "address5", "email5", "img5"),
			new Users(6, "username6", "password6", "address6", "email6", "img6"),
			new Users(7, "username7", "password7", "address7", "email7", "img7"),
			new Users(8, "username8", "password8", "address8", "email8", "img8"),
			new Users(9, "username9", "password9", "address9", "email9", "img9"),
			new Users(10, "username10", "password10", "address10", "email10", "img10"),
			new Users(11, "username11", "password11", "address11", "email11", "img11"),
			new Users(12, "username12", "password12", "address12", "email12", "img12")
	};
	
	
	public Users user_login(String username, String password) {
		for(Users user : users) {
			if(user.getUser_name().equals(username)) {
				if(user.getPassword().equals(password)) {
					return user;
				}
			}
		}return null;
	}
	
	public UserInfo getUserInfo(String username) {
		for(Users user : users) {
			if(user.getUser_name().equals(username)) {
				ArrayList<Reservations> reservationslist =  getUserReservations(username);
				UserInfo userInfo = new UserInfo(user.getUser_name(), user.getProfile_img(), user.getEmail(), reservationslist);
				return userInfo;
			}
		}return null;
	}
	
	private Reservations[] reservations = new Reservations[] {
			new Reservations(1, "username1", "driver1", 1, new Date()),
			new Reservations(2, "username2", "driver2", 2, new Date()),
			new Reservations(3, "username3", "driver3", 3, new Date())
	};
	
	
	public ArrayList<Reservations> getUserReservations(String username) {
		ArrayList<Reservations> list = new ArrayList<>();
		for(Reservations reservation : reservations) {
			if(reservation.getUser_name().equals(username)) {
				list.add(reservation);
			}
		}return list;
	}

}
