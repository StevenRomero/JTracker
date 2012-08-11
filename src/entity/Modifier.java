package entity;

import abstract_classes.Field;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Entity
public class Modifier extends Field{
    
    private User modifier;
    
    public Modifier(){
	
    }
    
    public Modifier(User modifier){
	this.setModifier(modifier);
    }

    @Override
    public int getSize() {
	// TODO Auto-generated method stub
	return 0;
    }

    @ManyToOne
    public User getModifier() {
	return modifier;
    }

    public void setModifier(User modifier) {
	this.modifier = modifier;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Modifier [modifier=" + modifier + "]";
    }

    @Override
    public void update(HttpServletRequest request,
	    HttpServletResponse response) {

    }

}
