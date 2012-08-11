package entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import enums.Role;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class User {
    
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private long userID;
    private Role role = Role.USER;
    
    public User(){
	
    }

    @Column(unique=true, nullable=false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(nullable=false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    @Enumerated
    @Column(nullable=false)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Id
    @GeneratedValue
    public long getUserID() {
        return userID;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "User [userName=" + userName + ", password=" + password
		+ ", firstName=" + firstName + ", lastName=" + lastName
		+ ", emailAddress=" + emailAddress + ", userID=" + userID
		+ ", role=" + role + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((emailAddress == null) ? 0 : emailAddress.hashCode());
	result = prime * result
		+ ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result
		+ ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result
		+ ((password == null) ? 0 : password.hashCode());
	result = prime * result + (int) (userID ^ (userID >>> 32));
	result = prime * result
		+ ((userName == null) ? 0 : userName.hashCode());
	return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (!(obj instanceof User)) {
	    return false;
	}
	User other = (User) obj;
	if (emailAddress == null) {
	    if (other.emailAddress != null) {
		return false;
	    }
	} else if (!emailAddress.equals(other.emailAddress)) {
	    return false;
	}
	if (firstName == null) {
	    if (other.firstName != null) {
		return false;
	    }
	} else if (!firstName.equals(other.firstName)) {
	    return false;
	}
	if (lastName == null) {
	    if (other.lastName != null) {
		return false;
	    }
	} else if (!lastName.equals(other.lastName)) {
	    return false;
	}
	if (password == null) {
	    if (other.password != null) {
		return false;
	    }
	} else if (!password.equals(other.password)) {
	    return false;
	}
	if (userID != other.userID) {
	    return false;
	}
	if (userName == null) {
	    if (other.userName != null) {
		return false;
	    }
	} else if (!userName.equals(other.userName)) {
	    return false;
	}
	return true;
    }
}
