package persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import entity.Ticket;
import interfaces.TicketDAO;

public class TicketDAOHibernateImpl extends DAO implements TicketDAO {
    
    private static Logger appLogger = Logger.getLogger("ErrorLog");
    
    private static TicketDAOHibernateImpl ticketDAOHibernateImpl = new TicketDAOHibernateImpl();
    
    private TicketDAOHibernateImpl (){
	
    }
    
    // Safe multi-threading
    //singleton
    public static TicketDAOHibernateImpl getInstance(){
	return ticketDAOHibernateImpl;
    }

    @Override
    public void createTicket(Ticket ticket) {

	try {
	    begin();
	    getSession().save(ticket);
	    commit();

	} catch (HibernateException e) {
	    rollback();
	    appLogger.error(e);
	}finally{
	    close();
	}

    }

    @Override
    public Ticket getTicket(String ticketName) {
	// TODO Auto-generated method stub
	try {
	    begin();
	    // will need to do join, fix query... 
	    Query query = getSession().createQuery("from Ticket where ticketName = :ticketname");
            query.setString("ticketname", ticketName);
	    Ticket returnedTicket = (Ticket)query.uniqueResult();
	    commit();
	    return returnedTicket;
	} catch (HibernateException e) {
	    rollback();
	    appLogger.error(e);
	    return null;
	}finally{
	    close();
	}
    }

    @Override
    public void saveTicket(Ticket ticket) {

	try {
	    begin();
	    getSession().update(ticket);
	    commit();
	} catch (HibernateException e) {
	    rollback();
	    appLogger.error(e);
	}finally{
	    close();
	}

    }

    @Override
    public void deleteTicket(Ticket ticket) {

	try {
	    begin();
	    getSession().delete(ticket);
	    commit();
	} catch (HibernateException e) {
	    rollback();
	    appLogger.error(e);
	}finally{
	    close();
	}

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Ticket> getAllTickets(){

	try {
	    Query q = getSession().createQuery("from Ticket");
	    List<Ticket> ticketList = q.list();
	    return ticketList;
	} catch (HibernateException e) {	 
	    appLogger.error(e);
	    return null;
	}finally{
	    close();
	}
	
    }

    @Override
    public Ticket getFullTicket(String ticketName) {
	try {
	    begin();
	    // will need to do join, fix query... 
	    Query query = getSession().createQuery("from Ticket where ticketName = :ticketname");
            query.setString("ticketname", ticketName);
	    Ticket returnedTicket = (Ticket)query.uniqueResult();
	    //deals with lazy initialization
	    returnedTicket.getRelatedTickets().getRelatedTicketsList();
	    returnedTicket.getAssignedTeams().getAssignedTeamsList();
	    returnedTicket.getAssignedPersonnel().getAssignedPersonnelList();
	    commit();
	    return returnedTicket;
	} catch (HibernateException e) {
	    rollback();
	    appLogger.error(e);
	    return null;
	}finally{
	    close();
	}
    }

    @Override
    public List<Ticket> getAllFullTickets() {
	try {
	    Query q = getSession().createQuery("from Ticket");
	    List<Ticket> ticketList = q.list();
	    //Fix lazy initialization
	    for(Ticket ticket: ticketList ){
		
		  ticket.getRelatedTickets().getRelatedTicketsList();
		  ticket.getAssignedTeams().getAssignedTeamsList();
		  ticket.getAssignedPersonnel().getAssignedPersonnelList();
	    }
	    return ticketList;
	} catch (HibernateException e) {	 
	    appLogger.error(e);
	    return null;
	}finally{
	    close();
	}
    }

}
