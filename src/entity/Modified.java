package entity;

import javax.persistence.Cacheable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import uitilities.DateUtil;

import abstract_classes.Field;



@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Modified extends Field{
    
    private Date dateModified;
    private User modifier;
    
    public Modified(){
	
    }
    
    public Modified(User modifier, Date dateModified) {
	this.setDateModified(dateModified);
	this.setModifier(modifier);
    }

    /**
     * @return the dateModified
     */
    @Embedded
    public Date getDateModified() {
        return dateModified;
    }

    /**
     * @param dateModified the dateModified to set
     */
    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Modified [dateModified=" + dateModified + ", modifierObj="
		+ modifier + "]";
    }

    @Override
    public int getSize() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public void update(HttpServletRequest request,
	    HttpServletResponse response) {
	
	User user = (User) request.getSession().getAttribute("user");
	
	if(!(modifier.equals(user))){
	    this.setModifier(user);
	    this.setDateModified(DateUtil.getDate());
	}


    }

    /**
     * @return the modifier
     */
    @ManyToOne
    public User getModifier() {
        return modifier;
    }

    /**
     * @param modifier the modifier to set
     */
    public void setModifier(User modifier) {
        this.modifier = modifier;
    }

}
