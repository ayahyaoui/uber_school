
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.Reservations;
import org.UserInfo;
import org.Users;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Servlet implementation class UserProfile
 */
@WebServlet(name = "/UserProfile", urlPatterns = {"/profile"})
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Examples BD ;
    Gson gson = new Gson();
    
    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	ServletContext c = getServletContext();
    	if(c.getAttribute("baseU") != null) {
    		Examples BD = (Examples)c.getAttribute("baseU");
    	}else {
    		Examples BD = new Examples();
    		c.setAttribute("baseU", BD);
    	}
    	this.gson = new GsonBuilder().serializeNulls().create();
    }

	
	/**
	 * load profile page or logout
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = (String)request.getAttribute("page");
		switch(action) {
		case "profile":
			String user_name = (String)request.getSession().getAttribute("username");
			ArrayList<Reservations> reservations = BD.getUserReservations(user_name);
			UserInfo userInfo = this.BD.getUserInfo(user_name);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(this.gson.toJson(userInfo));
			break;
		case "logout":
			request.getSession().invalidate();
			break;
		default : 
			break;
		}

	}

	
	/**
	 * login
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username != null && password != null) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			Users user = BD.user_login(username, password);
			if( user != null ) {
				// create a new session for the user
				request.getSession().invalidate();
				HttpSession newSession = request.getSession(true);
				newSession.setMaxInactiveInterval(3000);
				newSession.setAttribute("username", username);
				response.getWriter().write(gson.toJson(user));
			}else {
				response.getWriter().write(gson.toJson(null));
			}
		}
	}

}
