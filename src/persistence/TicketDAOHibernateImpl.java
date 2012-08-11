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
    public static TicketDAOHibernateImpl getInstance(){
	return ticketDAOHibernateImpl;
    }

    @Override
    public void createTicket(Ticket ticket) throws Exception {

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
    public Ticket getTicket(String ticketName) throws Exception {
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
    public void saveTicket(Ticket ticket) throws Exception {

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
    public void deleteTicket(Ticket ticket) throws Exception {

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
    public List<Ticket> getAllTickets() throws Exception {

	try {
	    Query q = getSession().createQuery("from Ticket");
	    List<Ticket> list = q.list();
	    return list;
	} catch (HibernateException e) {	 
	    appLogger.error(e);
	    return null;
	}finally{
	    close();
	}
	
    }

}
