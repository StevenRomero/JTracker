package entity;

import javax.persistence.Cacheable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import abstract_classes.Field;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Request extends Field{
    
    private RequestType requestTypeObj;   
    private RequestLOE requestLOEObj;   
    private RequestorName requestorNameObj;   
    private RequestTeam requestTeamObj;
    

    public Request() {
	
	this.setRequestLOEObj(new RequestLOE());
	this.setRequestorNameObj(new RequestorName());
	this.setRequestTeamObj(new RequestTeam());
	this.setRequestTypeObj(new RequestType());
    }

    /**
     * @return the requestTypeObj
     */
    @Embedded
    public RequestType getRequestTypeObj() {
        return requestTypeObj;
    }

    /**
     * @param requestTypeObj the requestTypeObj to set
     */
    public void setRequestTypeObj(RequestType requestTypeObj) {
        this.requestTypeObj = requestTypeObj;
    }

    /**
     * @return the requestLOEObj
     */
    @Embedded
    public RequestLOE getRequestLOEObj() {
        return requestLOEObj;
    }

    /**
     * @param requestLOEObj the requestLOEObj to set
     */
    public void setRequestLOEObj(RequestLOE requestLOEObj) {
        this.requestLOEObj = requestLOEObj;
    }

    /**
     * @return the requestorNameObj
     */
    @Embedded
    public RequestorName getRequestorNameObj() {
        return requestorNameObj;
    }

    /**
     * @param requestorNameObj the requestorNameObj to set
     */
    public void setRequestorNameObj(RequestorName requestorNameObj) {
        this.requestorNameObj = requestorNameObj;
    }

    /**
     * @return the requestTeamObj
     */
    @Embedded
    public RequestTeam getRequestTeamObj() {
        return requestTeamObj;
    }

    /**
     * @param requestTeamObj the requestTeamObj to set
     */
    public void setRequestTeamObj(RequestTeam requestTeamObj) {
        this.requestTeamObj = requestTeamObj;
    }

    /**
     * @return
     * @see entity.RequestType#getRequestType()
     */
    public String getRequestType() {
	return requestTypeObj.getRequestType();
    }

    /**
     * @param requestType
     * @see entity.RequestType#setRequestType(java.lang.String)
     */
    public void setRequestType(String requestType) {
	requestTypeObj.setRequestType(requestType);
    }

    /**
     * @return
     * @see entity.RequestLOE#getRequestLOE()
     */
    public String getRequestLOE() {
	return requestLOEObj.getRequestLOE();
    }

    /**
     * @param requestLOE
     * @see entity.RequestLOE#setRequestLOE(java.lang.String)
     */
    public void setRequestLOE(String requestLOE) {
	requestLOEObj.setRequestLOE(requestLOE);
    }

    /**
     * @return
     * @see entity.RequestorName#getRequestorName()
     */
    public String getRequestorName() {
	return requestorNameObj.getRequestorName();
    }

    /**
     * @param requestorName
     * @see entity.RequestorName#setRequestorName(java.lang.String)
     */
    public void setRequestorName(String requestorName) {
	requestorNameObj.setRequestorName(requestorName);
    }

    /**
     * @return
     * @see entity.RequestTeam#getRequestTeam()
     */
    public String getRequestTeam() {
	return requestTeamObj.getRequestTeam();
    }

    /**
     * @param requestTeam
     * @see entity.RequestTeam#setRequestTeam(java.lang.String)
     */
    public void setRequestTeam(String requestTeam) {
	requestTeamObj.setRequestTeam(requestTeam);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Request [requestTypeObj=" + requestTypeObj + ", requestLOEObj="
		+ requestLOEObj + ", requestorNameObj=" + requestorNameObj
		+ ", requestTeamObj=" + requestTeamObj + "]";
    }

    @Override
    public int getSize() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public void update(HttpServletRequest request,
	    HttpServletResponse response) {
	
	this.getRequestLOEObj().update(request, response);
	this.getRequestorNameObj().update(request, response);
	this.getRequestTeamObj().update(request, response);
	this.getRequestTypeObj().update(request, response);

    }
 
}
