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
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Created extends Field {

    private Date dateCreated;
    private User creator;

    public Created() {

    }

    public Created(User creator, Date dateCreated) {
	this.setDateCreated(dateCreated);
    }

    /**
     * @return the dateCreated
     */
    @Embedded
    public Date getDateCreated() {
	return dateCreated;
    }

    /**
     * @param dateCreated
     *            the dateCreated to set
     */
    public void setDateCreated(Date dateCreated) {
	this.dateCreated = dateCreated;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Created [dateCreated=" + dateCreated + ", creatorObj="
		+ creator + "]";
    }

    @Override
    public int getSize() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub

	User user = (User) request.getSession().getAttribute("user");

	if (!(creator.equals(user))) {
	    this.setCreator(user);
	    this.setDateCreated(DateUtil.getDate());
	}
    }

    /**
     * @return the creator
     */
    @ManyToOne
    public User getCreator() {
	return creator;
    }

    /**
     * @param creator
     *            the creator to set
     */
    public void setCreator(User creator) {
	this.creator = creator;
    }


}
