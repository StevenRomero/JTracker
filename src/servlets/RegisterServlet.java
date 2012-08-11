package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import persistence.UserDAOHibernateImpl;

import entity.User;

import uitilities.PasswordUtil;

public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = -1451723899712538224L;
    private static Logger appLogger = Logger.getLogger("ErrorLog");

    public void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	doPost(request, response);
    }
    
    public void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// Get values from web page
	
	String userName = request.getParameter("username");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String firstName = request.getParameter("firstname");
	String lastName = request.getParameter("lastname");
	
	// Encrypt password
	
	String enPassword = PasswordUtil.hashPassword(password);
	
	// construct user object
	
	User user = new User();
	
	user.setEmailAddress(email);
	user.setFirstName(firstName);
	user.setLastName(lastName);
	user.setPassword(enPassword);
	user.setUserName(userName);
	
	// Get the user data access object
	
	UserDAOHibernateImpl userDAO = UserDAOHibernateImpl.getInstance();
	
	try {
	    
	    userDAO.createUser(user);
	    
	} catch (Exception e) {
	    
	    appLogger.error(e);
	}
	
	// Get session
	
	HttpSession session = request.getSession(true);
	
	// Add user data to session
	
	synchronized (session){
	    
	    session.setAttribute("user", user);
	    
	}
	
	// Dispatch to main view
	
	RequestDispatcher view = request.getRequestDispatcher("/main.jsp");
	view.forward(request, response);
	
    }

}
