package entity;

import abstract_classes.Field;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Entity
public class Creator extends Field{
    
    private User creator;

    
    public Creator(){
	
    }
    
    public Creator(User creator) {
	this.setCreator(creator);
    }

    @Override
    public int getSize() {
	// TODO Auto-generated method stub
	return 0;
    }

    @ManyToOne
    public User getCreator() {
	return creator;
    }

    public void setCreator(User creator) {
	this.creator = creator;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Creator [creator=" + creator + "]";
    }

    @Override
    public void update(HttpServletRequest request,
	    HttpServletResponse response) {

    }

}
