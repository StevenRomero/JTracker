package persistence;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import entity.User;
import interfaces.UserDAO;



public class UserDAOHibernateImpl extends DAO implements UserDAO{
    
    private static Logger appLogger = Logger.getLogger("ErrorLog");
    
    private static UserDAOHibernateImpl userDAOHibernateImpl = new UserDAOHibernateImpl();
    
    private UserDAOHibernateImpl (){
	
    }
    
    // Safe multi-threading
    public static UserDAOHibernateImpl getInstance(){
	return userDAOHibernateImpl;
    }

    @Override
    public void createUser(User user){
	
	try {
		begin();
		getSession().save(user);
		commit();
		
	} catch (HibernateException e) {
		rollback();
		appLogger.error(e);
	}finally{
	    close();
	}
	
	
    }

    @Override
    public User getUser(String userName) {

	try {
	    begin();
	    // will need to do join, fix query... 
	    Query query = getSession().createQuery("from User where userName = :username");
            query.setString("username", userName);
	    User returnedUser = (User)query.uniqueResult();
	    commit();
	    return returnedUser;
	} catch (HibernateException e) {
	    rollback();
	    appLogger.error(e);
	    return null;
	}finally{
	    close();
	}
	
    }

    @Override
    public void saveUser(User user) {
	
	try {
		begin();
		getSession().update(user);
		commit();
	} catch (HibernateException e) {
		rollback();
		appLogger.error(e);
	}finally{
	    close();
	}
	
    }

    @Override
    public void deleteUser(User user) {
	
	try {
		begin();
		getSession().delete(user);
		commit();
	} catch (HibernateException e) {
		rollback();
		appLogger.error(e);
	}finally{
	    close();
	}
	
    }

}
