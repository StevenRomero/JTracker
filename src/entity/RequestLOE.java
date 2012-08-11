package entity;

import abstract_classes.Field;


import javax.persistence.Embeddable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Embeddable
public class RequestLOE extends Field{
    
    private String requestLOE;
    
    public RequestLOE(){
	
    }
    
    public RequestLOE(String requestLOE){
	this.setRequestLOE(requestLOE);
    }

    @Override
    public int getSize() {
	return requestLOE.length();
    }

    public String getRequestLOE() {
        return requestLOE;
    }

    public void setRequestLOE(String requestLOE) {
        this.requestLOE = requestLOE;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "RequestLOE [requestLOE=" + requestLOE + "]";
    }

    @Override
    public void update(HttpServletRequest request,
	    HttpServletResponse response) {
	
	String requestLOE = request.getParameter("requestLOE"); 
	
	if(!(this.requestLOE.equals(requestLOE))){
	    this.setRequestLOE(requestLOE);
	}

    }
    
    

}
