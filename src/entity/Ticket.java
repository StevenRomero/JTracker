package entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Ticket {
    
    private long ticketID;
    private TicketName ticketName;
    private TicketDescription ticketDescription;
    private Request request;
    private RelatedTickets relatedTickets;
    private Priority priority;
    private Modified modified;
    private Created created;
    private AssignedPersonnel assignedPersonnel;
    private AssignedTeams assignedTeams;
    private Comments comments;
        
    public Ticket(){ }
      
    /**
     * @return the ticketID
     */
    @Id
    @GeneratedValue
    public long getTicketID() {
        return ticketID;
    }
    /**
     * @return the ticketName
     */
    @OneToOne
    @JoinColumn(name="TICKET_ID")
    public TicketName getTicketName() {
        return ticketName;
    }
    /**
     * @param ticketName the ticketName to set
     */
    public void setTicketName(TicketName ticketName) {
        this.ticketName = ticketName;
    }
    /**
     * @return the ticketDescription
     */
    @OneToOne
    @JoinColumn(name="Ticket_DESC_ID")
    public TicketDescription getTicketDescription() {
        return ticketDescription;
    }
    /**
     * @param ticketDescription the ticketDescription to set
     */
    public void setTicketDescription(TicketDescription ticketDescription) {
        this.ticketDescription = ticketDescription;
    }
    /**
     * @return the request
     */
    @OneToOne
    @JoinColumn(name="REQUEST_ID")
    public Request getRequest() {
        return request;
    }
    /**
     * @param request the request to set
     */
    public void setRequest(Request request) {
        this.request = request;
    }
    /**
     * @return the relatedTickets
     */
    @OneToOne
    @JoinColumn(name="REL_TICKET_ID")
    public RelatedTickets getRelatedTickets() {
        return relatedTickets;
    }
    /**
     * @param relatedTickets the relatedTickets to set
     */
    public void setRelatedTickets(RelatedTickets relatedTickets) {
        this.relatedTickets = relatedTickets;
    }
    /**
     * @return the priority
     */
    @OneToOne
    @JoinColumn(name="PRIORITY_ID")
    public Priority getPriority() {
        return priority;
    }
    /**
     * @param priority the priority to set
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    /**
     * @return the modified
     */
    @OneToOne
    @JoinColumn(name="MODIFIED_ID")
    public Modified getModified() {
        return modified;
    }
    /**
     * @param modified the modified to set
     */
    public void setModified(Modified modified) {
        this.modified = modified;
    }
    /**
     * @return the created
     */
    @OneToOne
    @JoinColumn(name="CREATED_ID")
    public Created getCreated() {
        return created;
    }
    /**
     * @param created the created to set
     */
    public void setCreated(Created created) {
        this.created = created;
    }
    /**
     * @return the assignedPersonnel
     */
    @OneToOne
    @JoinColumn(name="ASGN_PERSONAL_ID")
    public AssignedPersonnel getAssignedPersonnel() {
        return assignedPersonnel;
    }
    /**
     * @param assignedPersonnel the assignedPersonnel to set
     */
    public void setAssignedPersonnel(AssignedPersonnel assignedPersonnel) {
        this.assignedPersonnel = assignedPersonnel;
    }
    /**
     * @return the assignedTeams
     */
    @OneToOne
    @JoinColumn(name="ASGN_TEAM_ID")
    public AssignedTeams getAssignedTeams() {
        return assignedTeams;
    }
    /**
     * @param assignedTeams the assignedTeams to set
     */
    public void setAssignedTeams(AssignedTeams assignedTeams) {
        this.assignedTeams = assignedTeams;
    }
    /**
     * @return the comments
     */
    @OneToOne
    @JoinColumn(name="COMMENTS_ID")
    public Comments getComments() {
        return comments;
    }
    /**
     * @param comments the comments to set
     */
    public void setComments(Comments comments) {
        this.comments = comments;
    }
    
    // this method is used to update all parts of the ticket
    public void update(HttpServletRequest request, HttpServletResponse response){
	
	this.getAssignedPersonnel().update(request, response);
	this.getAssignedTeams().update(request, response);
	this.getComments().update(request, response);
	this.getRelatedTickets().update(request, response);
	this.getRequest().update(request, response);
	this.getTicketDescription().update(request, response);
	this.getPriority().update(request, response);
	this.getTicketName().update(request, response);
	this.getModified().update(request, response);
	
	
    }
    
    

}
