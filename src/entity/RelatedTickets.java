package entity;

import java.util.ArrayList;
import java.util.List;

import abstract_classes.Field;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class RelatedTickets extends Field{
    
    private List<RelatedTicketElement> relatedTicketsList;
    
    public RelatedTickets() {
	relatedTicketsList = new ArrayList<RelatedTicketElement>();
    }
    
    public void addRelatedTicket(RelatedTicketElement ticket){
	relatedTicketsList.add(ticket);
    }
    
    public void removeRelatedTicket(RelatedTicketElement ticket){
	relatedTicketsList.remove(ticket);
    }

    @Override
    public int getSize() {
	// TODO Auto-generated method stub
	return relatedTicketsList.size();
    }
    @ElementCollection(fetch= FetchType.LAZY)
    @JoinTable (name="REL_TICKT_LIST",joinColumns=@JoinColumn(name="REL_TICKT_ID"))
    @OneToMany(cascade = {CascadeType.ALL})
    public List<RelatedTicketElement> getRelatedTicketsList() {
	return relatedTicketsList;
    }

    public void setRelatedTicketsList(List<RelatedTicketElement> relatedTicketsList) {
	this.relatedTicketsList = relatedTicketsList;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "RelatedTickets [relatedTickets=" + relatedTicketsList + "]";
    }

    @Override
    public void update(HttpServletRequest request,
	    HttpServletResponse response) {
	
	String[] relatedTickets = request.getParameterValues("relatedTickets");
	
	for (int i = 0; i < relatedTickets.length; i++){
	    if(!(this.relatedTicketsList.contains(new RelatedTicketElement(relatedTickets[i])))){
		this.relatedTicketsList.add(new RelatedTicketElement(relatedTickets[i]));
	    }
	}

    }

}
