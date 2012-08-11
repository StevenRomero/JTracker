package uitilities;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.AssignedPersonnel;
import entity.AssignedPersonnelElement;
import entity.AssignedTeamElement;
import entity.AssignedTeams;
import entity.Comments;
import entity.Created;
import entity.Date;
import entity.Modified;
import entity.Priority;
import entity.RelatedTicketElement;
import entity.RelatedTickets;
import entity.Request;
import entity.Ticket;
import entity.TicketDescription;
import entity.TicketName;
import entity.User;

public class TicketUtil {
    
    public static Ticket createTicket(HttpServletRequest request, HttpServletResponse response){
	
	Date date = DateUtil.getDate();
		
	User user = (User) request.getSession().getAttribute("user");
		
	Created createdObj = new Created();
	createdObj.setCreator(user);
	createdObj.setDateCreated(date);
		
	Modified modifiedObj = new Modified();
	modifiedObj.setModifier(user);
	modifiedObj.setDateModified(date);
	
	Ticket ticket = new Ticket();
	
	ticket.setCreated(createdObj);
	ticket.setModified(modifiedObj);
	ticket.setAssignedPersonnel(createAssignedPersonnel(request,response));
	ticket.setAssignedTeams(createAssignedTeams(request,response));
	ticket.setComments(createComments(request,response));
	ticket.setPriority(createPriority(request,response));
	ticket.setRelatedTickets(createRelatedTickets(request,response));
	ticket.setRequest(createRequest(request,response));
	ticket.setTicketDescription(createTicketDiscription(request,response));
	ticket.setTicketName(createTicketName(request,response));
	
	return ticket;
    }
    
    
    
    
    
    private static TicketDescription  createTicketDiscription(HttpServletRequest request, HttpServletResponse response){
	
	String ticketDescription = request.getParameter("ticketDescription");
	
	TicketDescription ticketDescriptionObj = new TicketDescription();
	ticketDescriptionObj.setTicketDescription(ticketDescription);
	
	return ticketDescriptionObj;
	
    }
    
    private static TicketName  createTicketName(HttpServletRequest request, HttpServletResponse response){
	
	String ticketName = request.getParameter("ticketName");
	
	TicketName ticketNameObj = new TicketName();
	ticketNameObj.setTicketName(ticketName);
	
	return ticketNameObj;
	
    }
    
    private static Request  createRequest(HttpServletRequest request, HttpServletResponse response){
	
	String requestType = request.getParameter("requestType");
	String requestTeam = request.getParameter("requestTeam");
	String requestorName = request.getParameter("requestorName");
	String requestLOE = request.getParameter("requestLOE"); 
	
	Request requestObj = new Request();
	requestObj.setRequestLOE(requestLOE);
	requestObj.setRequestorName(requestorName);
	requestObj.setRequestTeam(requestTeam);
	requestObj.setRequestType(requestType);
	
	return requestObj;
	
    }
    
    private static Priority  createPriority(HttpServletRequest request, HttpServletResponse response){
	
	String priority = request.getParameter("priority"); 
	String priorityDesc = request.getParameter("priorityDesc");
	
	Priority priorityObj = new Priority();
	priorityObj.setPriority(Integer.parseInt(priority));
	priorityObj.setPriorityDesc(priorityDesc);
	
	return priorityObj;
	
    }
    
    private static Comments  createComments(HttpServletRequest request, HttpServletResponse response){
	
	String comments = request.getParameter("comments");
	
	Comments commentsObj = new Comments();
	commentsObj.setComments(comments);
	
	return commentsObj;
	
    }
    
    private static AssignedTeams  createAssignedTeams(HttpServletRequest request, HttpServletResponse response){
	
	String[] assignedTeams = request.getParameterValues("assignedTeams");
	
	AssignedTeams assignedTeamsObj = new AssignedTeams();
	List<AssignedTeamElement> assignedTeamsList = new ArrayList<AssignedTeamElement>();	
	for(String e:assignedTeams){
	    assignedTeamsList.add(new AssignedTeamElement(e));	    
	}
	assignedTeamsObj.setAssignedTeamsList(assignedTeamsList);
	
	return assignedTeamsObj;
	
    }
    
    private static AssignedPersonnel  createAssignedPersonnel(HttpServletRequest request, HttpServletResponse response){
	
	String[] assignedPersonnel = request.getParameterValues("assignedPersonnel");
	
	AssignedPersonnel assignedPersonnelObj = new AssignedPersonnel();
	List<AssignedPersonnelElement> assignedPersonnelList = new ArrayList<AssignedPersonnelElement>();
	for(String e:assignedPersonnel){
	    assignedPersonnelList.add(new AssignedPersonnelElement(e));    
	}
	assignedPersonnelObj.setAssignedPersonnelList(assignedPersonnelList);
	
	return assignedPersonnelObj;
	
    }
    
    private static RelatedTickets  createRelatedTickets(HttpServletRequest request, HttpServletResponse response){
	
	String[] relatedTickets = request.getParameterValues("relatedTickets");
	
	RelatedTickets relatedTicketsObj = new RelatedTickets();
	List<RelatedTicketElement> relatedTicketList = new ArrayList<RelatedTicketElement>();
	for(String e:relatedTickets){
	    relatedTicketList.add(new RelatedTicketElement(e));
	}
	relatedTicketsObj.setRelatedTicketsList(relatedTicketList);
	
	return relatedTicketsObj;
	
    }

}
