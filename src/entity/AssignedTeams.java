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
public class AssignedTeams extends Field {

    private List<AssignedTeamElement> assignedTeamsList;

    public AssignedTeams() {
	assignedTeamsList = new ArrayList<AssignedTeamElement>();
    }

    public void addTeam(AssignedTeamElement team) {
	assignedTeamsList.add(team);
    }

    public void removeTeam(AssignedTeamElement team) {
	assignedTeamsList.remove(team);
    }

    @Override
    public int getSize() {
	return assignedTeamsList.size();
    }

    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable (name="ASGN_TEAM_LIST",joinColumns=@JoinColumn(name="ASGN_TEAM_ID"))
    @OneToMany(cascade = {CascadeType.ALL})
    public List<AssignedTeamElement> getAssignedTeamsList() {
	return assignedTeamsList;
    }

    public void setAssignedTeamsList(List<AssignedTeamElement> assignedTeamsList) {
	this.assignedTeamsList = assignedTeamsList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "AssignedTeams [assignedTeams=" + assignedTeamsList + "]";
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {

	String[] assignedTeams = request.getParameterValues("assignedTeams");

	for (int i = 0; i < assignedTeams.length; i++) {
	    if (!(this.assignedTeamsList.contains(new AssignedTeamElement(
		    assignedTeams[i])))) {
		this.assignedTeamsList.add(new AssignedTeamElement(
			assignedTeams[i]));
	    }
	}

    }

}
