package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import entity.Ticket;

import persistence.TicketDAOHibernateImpl;

public class UpdateTicketServlet extends HttpServlet{

    /**
     * 
     */
    private static final long serialVersionUID = -5431271748095898510L;
    private static Logger appLogger = Logger.getLogger("ErrorLog");


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// This is called from a form so doPost should be invoked instead.
	// Call doPost to ensure all requests are handled.
	doPost(request, response);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	String ticketName = request.getParameter("ticketname");
	
	// Check if user is logged in.

	HttpSession session = request.getSession(false);
	
	// If no session user must log in
	
	if (null == session) {
		response.sendRedirect("/login.jsp?errorMessage=You must be logged in to perform this function.");
		return;
	}
	
	TicketDAOHibernateImpl ticketDAO = TicketDAOHibernateImpl.getInstance();
	
	try {
	    // get ticket
	    Ticket ticket = ticketDAO.getTicket(ticketName);
	    // update ticket
	    ticket.update(request, response);
	    // save ticket to db again
	    ticketDAO.saveTicket(ticket);
	    
	} catch (Exception e) {
	   
	    appLogger.error(e);
	}
	
	RequestDispatcher view = request.getRequestDispatcher("/main.jsp");
	view.forward(request, response);

	
    }
    
    

}
