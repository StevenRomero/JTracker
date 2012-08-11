package entity;

import abstract_classes.Field;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class TicketDescription extends Field {
        
    private String ticketDescription;
    
    public TicketDescription(){
	
    }
    
    public TicketDescription(String ticketDescription){
	this.setTicketDescription(ticketDescription);
    }
    @Lob
    public String getTicketDescription() {
	return ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
	this.ticketDescription = ticketDescription;
    }

    @Override
    public int getSize() {
	
	return ticketDescription.length();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "TicketDescription [ticketDescription=" + ticketDescription + "]";
    }

    @Override
    public void update(HttpServletRequest request,
	    HttpServletResponse response) {
	
	String ticketDescription = request.getParameter("ticketDescription");
	
	if(!(this.ticketDescription.equals(ticketDescription))){
	    this.setTicketDescription(ticketDescription);
	}

    }
}
