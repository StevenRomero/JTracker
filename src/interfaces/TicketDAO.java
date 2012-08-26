package interfaces;

import java.util.List;

import entity.Ticket;

public interface TicketDAO {
    
    public void createTicket(Ticket ticket);
    public Ticket getTicket(String ticketName);
    public void saveTicket(Ticket ticket);
    public void deleteTicket(Ticket ticket);
    public List<Ticket> getAllTickets();
    public Ticket getFullTicket(String ticketName);
    public List<Ticket> getAllFullTickets();

}
