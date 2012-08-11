package entity;

import abstract_classes.Field;


import javax.persistence.Embeddable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Embeddable
public class RequestType extends Field{
    
    private String requestType;
    
    public RequestType(){
	
    }
    
    public RequestType(String requestType){
	this.setRequestType(requestType);
    }

    @Override
    public int getSize() {	
	return requestType.length();
    }

    public String getRequestType() {
	return requestType;
    }

    public void setRequestType(String requestType) {
	this.requestType = requestType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "RequestType [requestType=" + requestType + "]";
    }

    @Override
    public void update(HttpServletRequest request,
	    HttpServletResponse response) {
	
	String requestType = request.getParameter("requestType");
	
	if(!(this.requestType.equals(requestType))){
	    this.setRequestType(requestType);
	}
    }
    
    

}
