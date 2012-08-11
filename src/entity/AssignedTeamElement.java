package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AssignedTeamElement {

    private String assignedTeam;
    private int id;

    public AssignedTeamElement() {
    }

    public AssignedTeamElement(String assignedTeam) {
	this.assignedTeam = assignedTeam;
    }

    public String getAssignedTeam() {
	return assignedTeam;
    }

    public void setAssignedTeam(String assignedTeam) {
	this.assignedTeam = assignedTeam;
    }

    @Id
    @GeneratedValue
    public int getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
	this.id = id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((assignedTeam == null) ? 0 : assignedTeam.hashCode());
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof AssignedTeamElement))
	    return false;
	AssignedTeamElement other = (AssignedTeamElement) obj;
	if (assignedTeam == null) {
	    if (other.assignedTeam != null)
		return false;
	} else if (!assignedTeam.equals(other.assignedTeam))
	    return false;
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "AssignedTeamElement [assignedTeam=" + assignedTeam + "]";
    }

}
