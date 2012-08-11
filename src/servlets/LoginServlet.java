package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import entity.User;

import persistence.UserDAOHibernateImpl;
import uitilities.PasswordUtil;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 4286940923785367241L;
    private static Logger appLogger = Logger.getLogger("ErrorLog");

    @Override
    public void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// Get username and password from the request
	String userName = request.getParameter("username");
	String password = request.getParameter("password");

	// Get the user data access object

	UserDAOHibernateImpl userDAO = UserDAOHibernateImpl.getInstance();

	try {
	    User user = userDAO.getUser(userName);

	    if (!(PasswordUtil.authenticatePassword(password,
		    user.getPassword()))) {

		response.sendRedirect("/registerUser.jsp");

	    } else {

		HttpSession session = request.getSession(true);

		// Setup session variables
		synchronized (session) {

		    session.setAttribute("user", user);
		    session.setAttribute("authenticated", "true");

		}
	    }

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    appLogger.error(e);
	}

	RequestDispatcher view = request.getRequestDispatcher("/main.jsp");
	view.forward(request, response);

    }
}
