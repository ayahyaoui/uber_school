
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Auth
 */
@WebServlet(name = "/Auth", urlPatterns = {"/auth"})
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		// go to login page
		String param = request.getParameter("page");
		if (param.equals("login")) {
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}*/
		
		// logout 
		String action = request.getParameter("action");
		switch(action) {
		case "destroy" : 
			request.getSession().invalidate();
			response.sendRedirect("login.jsp");
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
		
		
		
		if(username.equals("elena")) {
			request.getSession().invalidate();
			HttpSession newSession = request.getSession(true);
			newSession.setMaxInactiveInterval(3000);
			newSession.setAttribute("username", username);		
			response.sendRedirect("memberArea.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
