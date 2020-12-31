package com;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.model.UserDTO;
import com.service.UserService;
import com.service.UserServiceImpl;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
@WebListener
public class MySessionListener implements HttpSessionListener {
	UserDAO userdao = new UserDAOImpl();
    /**
     * Default constructor. 
     */
    public MySessionListener() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("==== Session is created ====");
    	se.getSession().setMaxInactiveInterval(5*60);
         
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("==== Session is destroyed ====");
   
    	se.getSession().invalidate();

    }
	
}
