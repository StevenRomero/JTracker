package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import persistence.TicketDAOHibernateImpl;

import entity.Ticket;

import uitilities.TicketUtil;


public class CreateTicketServlet extends HttpServlet {

    private static final long serialVersionUID = 1232285646569664420L;
    private static Logger appLogger = Logger.getLogger("ErrorLog");

    

    public void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// This is called from a form so doPost should be invoked instead.
	// Call doPost to ensure all requests are handled.
	doPost(request, response);
    }

    public void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	
	// Check if user is logged in.

	HttpSession session = request.getSession(false);

	if (null == session) {
		response.sendRedirect("/login.jsp?errorMessage=You must be logged in to perform this function.");
		return;
	}
	
	Ticket ticket = TicketUtil.createTicket(request, response);
	
	TicketDAOHibernateImpl ticketDAO = TicketDAOHibernateImpl.getInstance();
	
	try {
	    
	    ticketDAO.createTicket(ticket);
	    
	} catch (Exception e) {
	   
	    appLogger.error(e);
	}


	RequestDispatcher view = request.getRequestDispatcher("/main.jsp");
	view.forward(request, response);

    }

}
