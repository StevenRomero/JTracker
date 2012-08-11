package interfaces;

import java.util.List;

import entity.Ticket;

public interface TicketDAO {
    
    public void createTicket(Ticket ticket) throws Exception;
    public Ticket getTicket(String ticketName) throws Exception;
    public void saveTicket(Ticket ticket) throws Exception;
    public void deleteTicket(Ticket ticket) throws Exception;
    public List<Ticket> getAllTickets() throws Exception;

}
