package entity;

import abstract_classes.Field;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Priority extends Field{
    
    private int priority;
    private String priorityDesc;
    
    public Priority(){
	
    }
    
    public Priority(int priority, String priorityDesc) {

	this.setPriority(priority);
	this.setPriorityDesc(priorityDesc);
    }

    @Override
    public int getSize() {
	return 0;
    }

    public int getPriority() {
	return priority;
    }

    public void setPriority(int priority) {
	this.priority = priority;
    }
    
    @Lob
    public String getPriorityDesc() {
	return priorityDesc;
    }

    public void setPriorityDesc(String priorityDesc) {
	this.priorityDesc = priorityDesc;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Priority [priority=" + priority + ", priorityDesc="
		+ priorityDesc + "]";
    }

    @Override
    public void update(HttpServletRequest request,
	    HttpServletResponse response) {
	
	String priority = request.getParameter("priority"); 
	String priorityDesc = request.getParameter("priorityDesc");
	
	int priorityINT = Integer.parseInt(priority);
	
	if (!(this.priority == priorityINT)){
	    this.setPriority(priorityINT);
	}
	
	if(!(this.priorityDesc.equals(priorityDesc))){
	    this.setPriorityDesc(priorityDesc);
	}

    }
}
