package abstract_classes;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Field {
       
    protected long id;
    
    public abstract int getSize();
    
    public abstract void update(HttpServletRequest request, HttpServletResponse response);

    @Id
    @GeneratedValue
    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }


}



