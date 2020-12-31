package com;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class HibernateUtility {
	@Autowired
	 private  SessionFactory sessionFactory;
	    public  final ThreadLocal  localthread=new ThreadLocal();
	    public  Session currentSession() throws HibernateException
	    {
	    	Session s=(Session)localthread.get();
	    	if(s==null){
	    		s=getSessionFactory().openSession();
	    		localthread.set(s);
	    	}
	    	return s;
	    }	    
	    public  void closeSession()throws HibernateException
	    {
	    	Session s=(Session)localthread.get();
	    	localthread.set(null);
	    	if(s!=null)
	    	{
	    		s.close();
	    	}
	    }
		public  SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public  void setSessionFactory(SessionFactory sessionFactor) {
			sessionFactory = sessionFactor;
		}
  
}

