package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RelatedTicketElement {
    
    private String relatedTicket;
    private int id;
    
    public RelatedTicketElement() {}

    public RelatedTicketElement(String relatedTicket) {
	this.relatedTicket = relatedTicket;
    }

    public String getRelatedTicket() {
	return relatedTicket;
    }

    public void setRelatedTicket(String relatedTicket) {
	this.relatedTicket = relatedTicket;
    }
    
    @Id 
    @GeneratedValue
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((relatedTicket == null) ? 0 : relatedTicket.hashCode());
	return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof RelatedTicketElement))
	    return false;
	RelatedTicketElement other = (RelatedTicketElement) obj;
	if (relatedTicket == null) {
	    if (other.relatedTicket != null)
		return false;
	} else if (!relatedTicket.equals(other.relatedTicket))
	    return false;
	return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "RelatedTicketElement [relatedTicket=" + relatedTicket + "]";
    }
    
    

}
