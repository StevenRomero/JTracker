package entity;

import abstract_classes.Field;

import javax.persistence.Cacheable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import uitilities.DateUtil;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Comments extends Field {

    private String comments;
    private Date date;

    public Comments() {
    }

    /**
     * @return the comments
     */
    @Lob
    public String getComments() {
	return comments;
    }

    /**
     * @param comments
     *            the comments to set
     */
    public void setComments(String comments) {
	this.comments = comments;
    }

    /**
     * @return the date
     */
    @Embedded
    public Date getDate() {
	return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(Date date) {
	this.date = date;
    }

    @Override
    public int getSize() {
	// TODO Auto-generated method stub
	return comments.length();
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {

	String comments = request.getParameter("comments");

	if (!(this.comments.equals(comments))) {
	    this.setComments(comments);
	    this.setDate(DateUtil.getDate());
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Comments [comments=" + comments + ", date=" + date + "]";
    }

}
