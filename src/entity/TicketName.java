package entity;

import abstract_classes.Field;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class TicketName extends Field{
    
    private String ticketName;
    
    public TicketName(){
	
    }
    
    public TicketName(String ticketName){
	this.setTicketName(ticketName);
    }

    public String getTicketName() {
	return ticketName;
    }

    public void setTicketName(String ticketName) {
	this.ticketName = ticketName;
    }

    @Override
    public int getSize() {	
	return ticketName.length();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "TicketName [ticketName=" + ticketName + "]";
    }

    @Override
    public void update(HttpServletRequest request,
	    HttpServletResponse response) {
	
	String ticketName = request.getParameter("ticketName");
	
	if (!(this.ticketName.equals(ticketName))){	    
	    this.setTicketName(ticketName);
	}

    }

}
