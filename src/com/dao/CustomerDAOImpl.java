package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HibernateUtility;
import com.model.CustomerDTO;
import com.model.UserDTO;


@Repository("CustomerDao")
public class CustomerDAOImpl extends CustomerDAO{

	@Autowired
	 private HibernateUtility HibUtility;
	
	@Override
	public int addUser(CustomerDTO customer) {
		Session session = getHibUtility().currentSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		return 0;
	}

	@Override
	public int updateUser(CustomerDTO customer) {
		Session session = getHibUtility().currentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();
		return 0;
	}

	@Override
	public int deleteUser(CustomerDTO customer) {
		Session session = getHibUtility().currentSession();
		Transaction tx = session.beginTransaction();
		session.delete(customer);
		tx.commit();
		return 0;
	}

	@Override
	public CustomerDTO getUser(int uid) {
		try {
			Session session = getHibUtility().currentSession();
			Query query=session.createQuery("from CustomerDTO where uid=:uid");
			query.setParameter("uid", uid);
			return (CustomerDTO) query.uniqueResult();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CustomerDTO> getAllUsers() {
		try {
			Session session = getHibUtility().currentSession();
			Query query=session.createQuery("from CustomerDTO");
			
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CustomerDTO getUserByName(String cname) {
		try {
			Session session = getHibUtility().currentSession();
			Query query=session.createQuery("from CustomerDTO where username=:cname");
			query.setParameter("cname", cname);
			return (CustomerDTO) query.uniqueResult();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;// TODO Auto-generated method stub
		
	}

	public HibernateUtility getHibUtility() {
		return this.HibUtility;
	}

	public void setHibUtility(HibernateUtility hibUtility) {
		this.HibUtility = hibUtility;
	}

}
