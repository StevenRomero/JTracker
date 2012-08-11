package persistence;



import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAO {

    private static final ThreadLocal<Session> SESSION = new ThreadLocal<Session>();
    @SuppressWarnings("deprecation")
    private static final SessionFactory SESSIONFACTORY = new Configuration()
	    .configure().buildSessionFactory();
    private static Logger appLogger = Logger.getLogger("ErrorLog");

    protected DAO() {
    }

    public static Session getSession() {
	Session session = DAO.SESSION.get();
	if (session == null) {
	    session = SESSIONFACTORY.openSession();
	    DAO.SESSION.set(session);
	}
	return session;
    }

    protected void begin() {
	getSession().beginTransaction();
    }

    protected void commit() {
	getSession().getTransaction().commit();
    }

    protected void rollback() {
	try {
	    getSession().getTransaction().rollback();
	} catch (HibernateException e) {
	    appLogger.error(e);
	}
	try {
	    getSession().close();
	} catch (HibernateException e) {
	    appLogger.error(e);
	}
	DAO.SESSION.set(null);
    }

    public static void close() {
	getSession().close();
	DAO.SESSION.set(null);
    }
}
