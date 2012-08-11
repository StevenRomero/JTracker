package entity;

import abstract_classes.Field;


import javax.persistence.Embeddable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Embeddable
public class RequestorName extends Field{
    
    private String requestorName;
    
    public RequestorName(){
	
    }
    
    public RequestorName(String requestorName){
	this.setRequestorName(requestorName);
    }

    @Override
    public int getSize() {
	return requestorName.length();
    }

    public String getRequestorName() {
	return requestorName;
    }

    public void setRequestorName(String requestorName) {
	this.requestorName = requestorName;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "RequestorName [requestorName=" + requestorName + "]";
    }

    @Override
    public void update(HttpServletRequest request,
	    HttpServletResponse response) {
	
	String requestorName = request.getParameter("requestorName");
	
	if(!(this.requestorName.equals(requestorName))){
	    this.setRequestorName(requestorName);
	}

    }
    
    

}
