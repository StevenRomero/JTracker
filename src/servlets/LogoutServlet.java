package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{

    private static final long serialVersionUID = 538742136318470907L;
    

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get the current session and check to see if it is null
		// If it is not null the invalidate it
		HttpSession session = request.getSession(false);

		// update information from session in db before ending session.

		synchronized (session) {
			if (null != session) {
				session.invalidate();
			}
		}

		// Redirect the user to the index.jsp page where they can login again
		response.sendRedirect("main.jsp");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Call the doGet method to ensure that all requests are handled
		doGet(request, response);
	}

}
