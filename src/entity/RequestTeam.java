package entity;

import abstract_classes.Field;


import javax.persistence.Embeddable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Embeddable
public class RequestTeam extends Field{
    
    private String requestTeam;
    
    public RequestTeam(){
	
    }
    
    public RequestTeam(String requestTeam){
	this.setRequestTeam(requestTeam);
    }

    public String getRequestTeam() {
        return requestTeam;
    }

    public void setRequestTeam(String requestTeam) {
        this.requestTeam = requestTeam;
    }

    @Override
    public int getSize() {
	return requestTeam.length();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "RequestTeam [requestTeam=" + requestTeam + "]";
    }

    @Override
    public void update(HttpServletRequest request,
	    HttpServletResponse response) {
	
	String requestTeam = request.getParameter("requestTeam");
	
	if(!(this.requestTeam.equals(requestTeam))){
	    this.setRequestTeam(requestTeam);
	}

    }
    
    
}
