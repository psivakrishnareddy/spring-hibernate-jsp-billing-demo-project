package com.billingdemo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.billingdemo.HibernateUtility;
import com.billingdemo.model.UserDTO;

@Repository("UserDAO")
public class UserDAOImpl extends UserDAO{
	
	@Autowired
	 private HibernateUtility HibUtility;
	
	@Override
	public int addUser(UserDTO user) {
		// TODO Auto-generated method stub
		Session session = getHibUtility().currentSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		return 0;
	}

	@Override
	public int updateUser(UserDTO user) {
		Session session = getHibUtility().currentSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		return 0;
	}

	@Override
	public int deleteUser(UserDTO user) {
		Session session = getHibUtility().currentSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
		return 0;
	}

	@Override
	public UserDTO getUser(int uid) {
		try {
			Session session = getHibUtility().currentSession();
			Query query=session.createQuery("from UserDTO where uid=:uid");
			query.setParameter("uid", uid);
			return (UserDTO) query.uniqueResult();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		
		try {
			Session session = getHibUtility().currentSession();
			Query query=session.createQuery("from UserDTO");
			
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDTO getUserByName(String uname) {
		try {
			Session session = getHibUtility().currentSession();
			Query query=session.createQuery("from UserDTO where username=:uname");
			query.setParameter("uname", uname);
			return (UserDTO) query.uniqueResult();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public HibernateUtility getHibUtility() {
		return this.HibUtility;
	}

	public void setHibUtility(HibernateUtility hibUtility) {
		this.HibUtility = hibUtility;
	}

}
