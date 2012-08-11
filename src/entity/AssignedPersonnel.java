package entity;

import java.util.ArrayList;
import java.util.List;

import abstract_classes.Field;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AssignedPersonnel extends Field {

    private List<AssignedPersonnelElement> assignedPersonnelList;

    public AssignedPersonnel() {
	assignedPersonnelList = new ArrayList<AssignedPersonnelElement>();
    }

    public void addPersonnel(AssignedPersonnelElement personnel) {
	assignedPersonnelList.add(personnel);
    }

    public void removePersonnel(AssignedPersonnelElement personnel) {
	assignedPersonnelList.remove(personnel);
    }

    @Override
    public int getSize() {
	return assignedPersonnelList.size();
    }

    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable (name="ASGN_PERSNL_LIST",joinColumns=@JoinColumn(name="ASGN_PERSNL_ID"))
    @OneToMany(cascade = {CascadeType.ALL})
    public List<AssignedPersonnelElement> getAssignedPersonnelList() {
	return assignedPersonnelList;
    }

    public void setAssignedPersonnelList(
	    List<AssignedPersonnelElement> assignedPersonnelList) {
	this.assignedPersonnelList = assignedPersonnelList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "AssignedPersonnel [assignedPersonnel=" + assignedPersonnelList
		+ "]";
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {

	String[] assignedPersonnel = request
		.getParameterValues("assignedPersonnel");

	for (int i = 0; i < assignedPersonnel.length; i++) {
	    if (!(this.assignedPersonnelList
		    .contains(new AssignedPersonnelElement(assignedPersonnel[i])))) {
		this.assignedPersonnelList.add(new AssignedPersonnelElement(
			assignedPersonnel[i]));
	    }
	}

    }
}
