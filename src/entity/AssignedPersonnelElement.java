package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AssignedPersonnelElement {

    private String assignedPersonnel;
    private int id;

    public AssignedPersonnelElement() {
    }

    public AssignedPersonnelElement(String assignedPersonnel) {
	this.assignedPersonnel = assignedPersonnel;
    }

    public String getAssignedPersonnel() {
	return assignedPersonnel;
    }

    public void setAssignedPersonnel(String assignedPersonnel) {
	this.assignedPersonnel = assignedPersonnel;
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
	result = prime
		* result
		+ ((assignedPersonnel == null) ? 0 : assignedPersonnel
			.hashCode());
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
	if (!(obj instanceof AssignedPersonnelElement))
	    return false;
	AssignedPersonnelElement other = (AssignedPersonnelElement) obj;
	if (assignedPersonnel == null) {
	    if (other.assignedPersonnel != null)
		return false;
	} else if (!assignedPersonnel.equals(other.assignedPersonnel))
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
	return "AssignedPersonnelElement [assignedPersonnel="
		+ assignedPersonnel + "]";
    }

}
